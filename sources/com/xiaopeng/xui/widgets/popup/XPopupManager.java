package com.xiaopeng.xui.widgets.popup;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Point;
import android.graphics.Typeface;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.xiaopeng.xui.utils.UIUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class XPopupManager {
    private static final String TAG = "XPopupManager";
    private boolean hideByTouchInSide;
    private boolean hideByTouchOutSide;
    private XPopupListener mListener;
    private Map<Integer, Boolean> mShowStateMap;
    private Map<Integer, View> mTipsMap;
    private XPopupAnimator mXPopupAnimator;
    private List<XPopup> mXPopupList;

    /* loaded from: classes.dex */
    public interface XPopupListener {
        void onXPopupDismissed(View view, int i, boolean z);
    }

    public XPopupManager() {
        this.mTipsMap = new HashMap();
        this.mShowStateMap = new HashMap();
        this.mXPopupList = new ArrayList();
        this.hideByTouchOutSide = true;
        this.hideByTouchInSide = true;
        this.mXPopupAnimator = new DefaultXPopupAnimator();
    }

    private void animateDismiss(final View view, final boolean z) {
        this.mXPopupAnimator.popout(view, new AnimatorListenerAdapter() { // from class: com.xiaopeng.xui.widgets.popup.XPopupManager.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (view.getParent() != null) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
                if (XPopupManager.this.mListener != null) {
                    XPopupListener xPopupListener = XPopupManager.this.mListener;
                    View view2 = view;
                    xPopupListener.onXPopupDismissed(view2, ((Integer) view2.getTag()).intValue(), z);
                }
            }
        });
    }

    private View create(final XPopup xPopup) {
        View createText;
        if (xPopup.getAnchorView() == null) {
            Log.e(TAG, "Unable to create a tip, anchor view is null");
            return null;
        } else if (xPopup.getRootView() == null) {
            Log.e(TAG, "Unable to create a tip, root layout is null");
            return null;
        } else {
            if (xPopup.getCustomView() != null) {
                if (this.mTipsMap.containsKey(Integer.valueOf(xPopup.getAnchorView().getId()))) {
                    View view = this.mTipsMap.get(Integer.valueOf(xPopup.getAnchorView().getId()));
                    int id = xPopup.getAnchorView().getId();
                    this.mTipsMap.remove(Integer.valueOf(id));
                    if (view.getParent() != null) {
                        ((ViewGroup) view.getParent()).removeView(view);
                    }
                    this.mShowStateMap.put(Integer.valueOf(id), Boolean.FALSE);
                }
                createText = createCustom(xPopup);
            } else if (this.mTipsMap.containsKey(Integer.valueOf(xPopup.getAnchorView().getId()))) {
                createText = this.mTipsMap.get(Integer.valueOf(xPopup.getAnchorView().getId()));
            } else {
                createText = createText(xPopup);
            }
            if (createText.getParent() != null) {
                ((ViewGroup) createText.getParent()).removeView(createText);
            }
            xPopup.getRootView().addView(createText);
            int[] iArr = new int[2];
            xPopup.getRootView().getLocationOnScreen(iArr);
            int[] iArr2 = new int[2];
            createText.getLocationOnScreen(iArr2);
            if (iArr2[0] <= iArr[0]) {
                moveTipToCorrectPosition(createText, XPopupCoordinatesFinder.getCoordinates(createText, xPopup));
            }
            int id2 = xPopup.getAnchorView().getId();
            createText.setTag(Integer.valueOf(id2));
            this.mTipsMap.put(Integer.valueOf(id2), createText);
            if (this.hideByTouchOutSide) {
                xPopup.getRootView().setOnTouchListener(new View.OnTouchListener() { // from class: com.xiaopeng.xui.widgets.popup.XPopupManager.1
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view2, MotionEvent motionEvent) {
                        if (motionEvent.getAction() == 0) {
                            XPopupManager.this.dismissAll();
                            return false;
                        }
                        return false;
                    }
                });
            }
            if (this.hideByTouchInSide) {
                createText.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.xui.widgets.popup.XPopupManager.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (XPopupManager.this.isShow(xPopup)) {
                            XPopupManager.this.dismiss(xPopup, true);
                        }
                    }
                });
            } else {
                createText.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.xui.widgets.popup.XPopupManager.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                    }
                });
            }
            return createText;
        }
    }

    private View createCustom(XPopup xPopup) {
        View customView = xPopup.getCustomView();
        xPopup.updateByTheme(customView, xPopup);
        return customView;
    }

    private View createText(XPopup xPopup) {
        TextView createTextView = createTextView(xPopup);
        if (UIUtils.isRtl()) {
            switchXPopupSidePosition(xPopup);
        }
        xPopup.setCustomView(createTextView);
        xPopup.updateByTheme(createTextView, xPopup);
        return createTextView;
    }

    private TextView createTextView(XPopup xPopup) {
        TextView textView = new TextView(xPopup.getContext());
        textView.setText(xPopup.getMessage());
        textView.setVisibility(4);
        textView.setGravity(xPopup.getTextGravity());
        setTextAppearance(textView, xPopup);
        setTextTypeFace(textView, xPopup);
        return textView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dismiss(XPopup xPopup, boolean z) {
        xPopup.unregisterTheme();
        if (this.mXPopupList.contains(xPopup)) {
            this.mXPopupList.remove(xPopup);
        }
        View find = xPopup.getAnchorView() != null ? find(Integer.valueOf(xPopup.getAnchorView().getId())) : null;
        if (find == null || !isVisible(find)) {
            return false;
        }
        int intValue = ((Integer) find.getTag()).intValue();
        this.mTipsMap.remove(Integer.valueOf(intValue));
        this.mShowStateMap.put(Integer.valueOf(intValue), Boolean.FALSE);
        animateDismiss(find, z);
        return true;
    }

    private View find(Integer num) {
        if (this.mTipsMap.containsKey(num)) {
            return this.mTipsMap.get(num);
        }
        return null;
    }

    private boolean isVisible(View view) {
        return view.getVisibility() == 0;
    }

    private void moveTipToCorrectPosition(View view, Point point) {
        Coordinates coordinates = new Coordinates(view);
        int i = point.x - coordinates.left;
        int i2 = point.y - coordinates.top;
        view.setTranslationX(!UIUtils.isRtl() ? i : -i);
        view.setTranslationY(i2);
    }

    private void setTextAppearance(TextView textView, XPopup xPopup) {
        textView.setTextAppearance(xPopup.getContext(), xPopup.getTextAppearanceStyle());
    }

    private void setTextTypeFace(TextView textView, XPopup xPopup) {
        if (xPopup.getTypeface() != null) {
            Typeface typeface = textView.getTypeface();
            if (typeface != null) {
                textView.setTypeface(xPopup.getTypeface(), typeface.getStyle());
            } else {
                textView.setTypeface(xPopup.getTypeface());
            }
        }
    }

    private void switchXPopupSidePosition(XPopup xPopup) {
        if (xPopup.positionedLeftTo()) {
            xPopup.setPosition(4);
        } else if (xPopup.positionedRightTo()) {
            xPopup.setPosition(3);
        }
    }

    public void dismissAll() {
        if (!this.mXPopupList.isEmpty()) {
            ArrayList<XPopup> arrayList = new ArrayList(this.mXPopupList);
            for (XPopup xPopup : arrayList) {
                dismiss(xPopup, false);
            }
            arrayList.clear();
        }
        this.mXPopupList.clear();
        this.mTipsMap.clear();
    }

    public boolean findAndDismiss(XPopup xPopup) {
        return (xPopup.getAnchorView() == null || find(Integer.valueOf(xPopup.getAnchorView().getId())) == null || !dismiss(xPopup, false)) ? false : true;
    }

    public boolean isShow(XPopup xPopup) {
        if (xPopup.getAnchorView() == null || !this.mShowStateMap.containsKey(Integer.valueOf(xPopup.getAnchorView().getId()))) {
            return false;
        }
        return this.mShowStateMap.get(Integer.valueOf(xPopup.getAnchorView().getId())).booleanValue();
    }

    public void setHideByTouchInSide(boolean z) {
        this.hideByTouchInSide = z;
    }

    public void setHideByTouchOutSide(boolean z) {
        this.hideByTouchOutSide = z;
    }

    public void setXPopupAnimator(XPopupAnimator xPopupAnimator) {
        this.mXPopupAnimator = xPopupAnimator;
    }

    public View show(XPopup xPopup) {
        if (isShow(xPopup)) {
            findAndDismiss(xPopup);
        }
        View create = create(xPopup);
        if (create == null) {
            return null;
        }
        this.mXPopupAnimator.breakAnimator(create);
        this.mShowStateMap.put(Integer.valueOf(xPopup.getAnchorView().getId()), Boolean.TRUE);
        this.mXPopupAnimator.popup(create);
        if (!this.mXPopupList.contains(xPopup)) {
            this.mXPopupList.add(xPopup);
        }
        xPopup.registerTheme();
        return create;
    }

    public XPopupManager(XPopupListener xPopupListener) {
        this();
        this.mListener = xPopupListener;
    }
}
