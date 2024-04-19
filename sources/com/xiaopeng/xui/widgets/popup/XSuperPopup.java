package com.xiaopeng.xui.widgets.popup;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Point;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import com.xiaopeng.xui.R;
import com.xiaopeng.xui.theme.ThemeWatcher;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public class XSuperPopup {
    private static final String ACTION_REMOVE_X_SUPER_POPUP = "com.xiaopeng.action.REMOVE_X_SUPER_POPUP";
    public static final int DURATION_ALWAYS = 0;
    public static final int DURATION_LONG = 5000;
    public static final int DURATION_NORMAL = 3000;
    public static final int DURATION_SHORT = 1000;
    public static final int GRAVITY_CENTER = 0;
    public static final int GRAVITY_LEFT = 1;
    public static final int GRAVITY_RIGHT = 2;
    private static final String STATE_SHOW = "STATE_SHOW";
    public static final XPopupAnimator sDefaultAnimator = new DefaultXPopupAnimator();

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface Gravity {
    }

    /* loaded from: classes.dex */
    public interface OnClickListener {
        void doClick();
    }

    /* loaded from: classes.dex */
    public interface OnDismissListener {
        void dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void animateDismiss(Builder builder, final WindowManager windowManager, final View view, XPopupAnimator xPopupAnimator, OnDismissListener onDismissListener) {
        if (view.getTag() != null) {
            view.setTag(null);
            if (view.isAttachedToWindow()) {
                xPopupAnimator.popout(view, new AnimatorListenerAdapter() { // from class: com.xiaopeng.xui.widgets.popup.XSuperPopup.4
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (view.isAttachedToWindow()) {
                            windowManager.removeView(view);
                        }
                    }
                });
                if (onDismissListener != null) {
                    onDismissListener.dismiss();
                }
            }
            builder.unregisterTheme();
        }
    }

    public static void dismissAllByBroadcast(Context context) {
        sendRemoveBroadcast(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getTextGravity(int i) {
        if (i != 0) {
            if (i != 1) {
                return i != 2 ? 17 : 8388613;
            }
            return 8388611;
        }
        return 17;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void sendRemoveBroadcast(Context context) {
        Intent intent = new Intent();
        intent.setAction(ACTION_REMOVE_X_SUPER_POPUP);
        context.sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void show(final Builder builder, final View view) {
        Context context;
        long j;
        WindowManager.LayoutParams layoutParams;
        Context context2 = builder.context;
        int i = builder.windowType;
        long j2 = builder.time;
        Point point = builder.point;
        int i2 = builder.width;
        int i3 = builder.height;
        boolean z = builder.outsideExit;
        final OnDismissListener onDismissListener = builder.dismissListener;
        final XPopupAnimator xPopupAnimator = sDefaultAnimator;
        sendRemoveBroadcast(context2);
        final WindowManager windowManager = (WindowManager) context2.getApplicationContext().getSystemService("window");
        WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams();
        layoutParams2.type = i;
        layoutParams2.flags = 151061288;
        if (z) {
            layoutParams2.flags = 151061288 | 262144;
            context = context2;
            j = j2;
            layoutParams = layoutParams2;
            view.setOnTouchListener(new View.OnTouchListener() { // from class: com.xiaopeng.xui.widgets.popup.XSuperPopup.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        try {
                            new Handler().postDelayed(new Runnable() { // from class: com.xiaopeng.xui.widgets.popup.XSuperPopup.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    XSuperPopup.animateDismiss(Builder.this, windowManager, view, xPopupAnimator, onDismissListener);
                                }
                            }, 200L);
                            return false;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return false;
                        }
                    }
                    return false;
                }
            });
        } else {
            context = context2;
            j = j2;
            layoutParams = layoutParams2;
        }
        layoutParams.gravity = 51;
        layoutParams.format = 1;
        layoutParams.y = point.y;
        layoutParams.x = point.x;
        layoutParams.width = i2;
        layoutParams.height = i3;
        windowManager.addView(view, layoutParams);
        xPopupAnimator.popup(view);
        view.setTag(STATE_SHOW);
        final BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.xiaopeng.xui.widgets.popup.XSuperPopup.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context3, Intent intent) {
                try {
                    XSuperPopup.animateDismiss(Builder.this, windowManager, view, xPopupAnimator, onDismissListener);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        if (j > 0) {
            final Context context3 = context;
            context3.registerReceiver(broadcastReceiver, new IntentFilter(ACTION_REMOVE_X_SUPER_POPUP));
            new Handler().postDelayed(new Runnable() { // from class: com.xiaopeng.xui.widgets.popup.XSuperPopup.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        XSuperPopup.animateDismiss(Builder.this, windowManager, view, xPopupAnimator, onDismissListener);
                        context3.unregisterReceiver(broadcastReceiver);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, j);
        }
    }

    /* loaded from: classes.dex */
    public static class Builder implements ThemeWatcher.OnThemeSwitchListener {
        private int bgRes;
        private int bgResNight;
        private Context context;
        private OnDismissListener dismissListener;
        private int height;
        private boolean outsideExit;
        private Point point;
        private String text;
        private int textAppearanceStyle;
        private int textAppearanceStyleNight;
        private int textGravity;
        private long time;
        private View view;
        private int width;
        private int windowType;

        public Builder(Context context, String str, long j, Point point, int i, int i2, boolean z, OnDismissListener onDismissListener) {
            this.context = context;
            this.text = str;
            this.time = j;
            this.point = point;
            this.width = i;
            this.height = i2;
            this.outsideExit = z;
            this.dismissListener = onDismissListener;
            this.view = null;
            this.textGravity = 0;
            this.bgRes = R.mipmap.xpopup_no_arrow;
            this.bgResNight = R.mipmap.xpopup_no_arrow_night;
            this.textAppearanceStyle = R.style.XPopupDefaultStyle;
            this.textAppearanceStyleNight = R.style.XPopupNightStyle;
            this.windowType = 2010;
        }

        private void updateTheme(View view, Builder builder) {
            if (!ThemeWatcher.getInstance().isNight()) {
                view.setBackgroundResource(builder.bgRes);
                if (view instanceof TextView) {
                    ((TextView) view).setTextAppearance(builder.context, builder.textAppearanceStyle);
                    return;
                }
                return;
            }
            view.setBackgroundResource(builder.bgResNight);
            if (view instanceof TextView) {
                ((TextView) view).setTextAppearance(builder.context, builder.textAppearanceStyleNight);
            }
        }

        public void hide() {
            if (this.time > 0) {
                XSuperPopup.sendRemoveBroadcast(this.context);
                return;
            }
            try {
                XSuperPopup.animateDismiss(this, (WindowManager) this.context.getApplicationContext().getSystemService("window"), this.view, XSuperPopup.sDefaultAnimator, this.dismissListener);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.xiaopeng.xui.theme.ThemeWatcher.OnThemeSwitchListener
        public void onSwitchTheme(int i) {
            updateTheme(this.view, this);
        }

        public void registerTheme() {
            ThemeWatcher.getInstance().addThemeSwitchListener(this);
        }

        public Builder setBgRes(int i) {
            this.bgRes = i;
            return this;
        }

        public Builder setBgResNight(int i) {
            this.bgResNight = i;
            return this;
        }

        public Builder setGravity(int i) {
            this.textGravity = i;
            return this;
        }

        public Builder setTextAppearanceStyle(int i) {
            this.textAppearanceStyle = i;
            return this;
        }

        public Builder setTextAppearanceStyleNight(int i) {
            this.textAppearanceStyleNight = i;
            return this;
        }

        public Builder setWindowType(int i) {
            this.windowType = i;
            return this;
        }

        public void show() {
            View view = this.view;
            if (view == null) {
                TextView textView = new TextView(this.context);
                textView.setText(this.text);
                textView.setGravity(XSuperPopup.getTextGravity(this.textGravity));
                this.view = textView;
                updateTheme(textView, this);
                XSuperPopup.show(this, textView);
            } else {
                updateTheme(view, this);
                XSuperPopup.show(this, this.view);
            }
            registerTheme();
        }

        public void unregisterTheme() {
            ThemeWatcher.getInstance().removeThemeListener(this);
        }

        public Builder(Context context, View view, long j, Point point, int i, int i2, boolean z, OnDismissListener onDismissListener) {
            this(context, "", j, point, i, i2, z, onDismissListener);
            this.view = view;
        }
    }
}
