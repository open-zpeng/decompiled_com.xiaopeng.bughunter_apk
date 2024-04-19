package com.xiaopeng.xui.watchers;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.google.android.material.internal.TouchTargetUtils;
import com.xiaopeng.xui.utils.UIUtils;
/* loaded from: classes.dex */
public class XTouchAreaWatcher implements XWatcher {
    private static final int MIN_PADDING_10 = 10;
    private static final int MIN_PADDING_20 = 20;
    private static final int MIN_TOUCH_HEIGHT = 88;
    private static final int MIN_TOUCH_WIDTH = 88;
    private final int[] mPaddings;
    private ViewGroup mRootView;
    private final Class<?>[] mWatchingClasses;

    public XTouchAreaWatcher() {
        this.mWatchingClasses = new Class[0];
        this.mPaddings = null;
    }

    private int adjustDefaultPadding(View view) {
        return (view.getMeasuredWidth() >= 88 || view.getMeasuredHeight() >= 88) ? 10 : 20;
    }

    public void extendTouchArea(View view, ViewGroup viewGroup) {
        if (view == null) {
            return;
        }
        int[] iArr = this.mPaddings;
        if (iArr == null) {
            int adjustDefaultPadding = adjustDefaultPadding(view);
            iArr = new int[]{adjustDefaultPadding, adjustDefaultPadding, adjustDefaultPadding, adjustDefaultPadding};
        }
        TouchTargetUtils.extendViewTouchTarget(view, viewGroup, iArr[0], iArr[1], iArr[2], iArr[3]);
    }

    @Override // com.xiaopeng.xui.watchers.XWatcher
    public void onCreate(Activity activity, Bundle bundle) {
        Class<?>[] clsArr = this.mWatchingClasses;
        if (clsArr == null || clsArr.length <= 0) {
            return;
        }
        if (this.mRootView == null) {
            this.mRootView = (ViewGroup) activity.findViewById(16908290).getRootView();
        }
        ViewGroup viewGroup = this.mRootView;
        if (viewGroup != null) {
            viewGroup.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.xiaopeng.xui.watchers.XTouchAreaWatcher.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    XTouchAreaWatcher xTouchAreaWatcher = XTouchAreaWatcher.this;
                    xTouchAreaWatcher.extendTouchArea(xTouchAreaWatcher.mWatchingClasses, XTouchAreaWatcher.this.mRootView);
                    XTouchAreaWatcher.this.mRootView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
            });
        }
    }

    @Override // com.xiaopeng.xui.watchers.XWatcher
    public void onDestroy() {
        this.mRootView = null;
    }

    @Override // com.xiaopeng.xui.watchers.XWatcher
    public void onPause() {
    }

    @Override // com.xiaopeng.xui.watchers.XWatcher
    public void onResume() {
    }

    public XTouchAreaWatcher(Class<?>[] clsArr, int i, int i2, int i3, int i4) {
        this.mWatchingClasses = clsArr;
        this.mPaddings = new int[]{i, i2, i3, i4};
    }

    public void extendTouchArea(Class<?>[] clsArr, ViewGroup viewGroup) {
        for (Class<?> cls : clsArr) {
            for (View view : UIUtils.findViewsByType(viewGroup, cls)) {
                extendTouchArea(view, viewGroup);
            }
        }
    }

    public XTouchAreaWatcher(int i, int i2, int i3, int i4) {
        this.mWatchingClasses = null;
        this.mPaddings = new int[]{i, i2, i3, i4};
    }

    public void extendTouchArea(View[] viewArr, ViewGroup viewGroup) {
        for (View view : viewArr) {
            extendTouchArea(view, viewGroup);
        }
    }
}
