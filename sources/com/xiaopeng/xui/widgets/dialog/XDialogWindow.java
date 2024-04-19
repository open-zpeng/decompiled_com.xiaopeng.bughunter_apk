package com.xiaopeng.xui.widgets.dialog;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.xiaopeng.xui.R;
import com.xiaopeng.xui.XUI;
import com.xiaopeng.xui.utils.UIUtils;
/* loaded from: classes.dex */
public class XDialogWindow {
    private static final String TAG = "XDialogWindow";
    private View mBgView;
    private View mContentView;
    private Context mContext;
    private boolean mIsNight;
    protected boolean mIsShowing;
    private int mStartY;
    private int mOffsetY = UIUtils.getStatusBarHeight();
    private int mWindowType = 2;
    private int mGravity = 80;
    private int mWindowFlags = 150995240;

    public XDialogWindow(Context context) {
        this.mContext = context;
    }

    private void initBackground() {
        View view = new View(XUI.getContext());
        this.mBgView = view;
        view.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        if (this.mIsNight) {
            this.mBgView.setBackgroundColor(UIUtils.getColor(R.color.x_dialog_window_bg_color_night));
        } else {
            this.mBgView.setBackgroundColor(UIUtils.getColor(R.color.x_dialog_window_bg_color_day));
        }
    }

    private void remove() {
        removeView(this.mContentView);
    }

    private void removeView(View view) {
        try {
            ((WindowManager) this.mContext.getSystemService("window")).removeView(view);
        } catch (Exception e) {
            e.printStackTrace();
            Log.d(TAG, "remove error, msg=" + e.getMessage());
        }
    }

    public void dismiss() {
        dismiss(true);
    }

    public boolean isShowing() {
        return this.mIsShowing;
    }

    public void setContentView(View view) {
        this.mContentView = view;
        WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = this.mWindowType;
        layoutParams.flags = this.mWindowFlags;
        layoutParams.format = -2;
        layoutParams.gravity = this.mGravity;
        layoutParams.width = UIUtils.getScreenWidth();
        layoutParams.height = (UIUtils.getScreenHeight() - this.mOffsetY) + 2;
        layoutParams.windowAnimations = 16973826;
        layoutParams.y = this.mStartY;
        initBackground();
        windowManager.addView(this.mBgView, layoutParams);
        windowManager.addView(this.mContentView, layoutParams);
        this.mIsShowing = true;
    }

    public void setGravity(int i) {
        this.mGravity = i;
    }

    public void setIsNight(boolean z) {
        this.mIsNight = z;
    }

    public void setOffsetY(int i) {
        this.mOffsetY = 0;
    }

    public void setWindowFlags(int i) {
        this.mWindowFlags = i;
    }

    public void setWindowType(int i) {
        this.mWindowType = i;
    }

    public void setY(int i) {
        this.mStartY = i;
    }

    public void show() {
        XDialogAnimUtils.startShowAnimation(this.mContentView);
    }

    public void dismiss(boolean z) {
        this.mIsShowing = false;
        removeView(this.mBgView);
        remove();
        if (z) {
            XDialogAnimUtils.startDismissAnimation(this.mContentView, new AnimatorListenerAdapter() { // from class: com.xiaopeng.xui.widgets.dialog.XDialogWindow.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                }
            });
        }
    }
}
