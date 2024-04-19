package com.xiaopeng.xui.widgets.dialog;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextPaint;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaopeng.xui.R;
import com.xiaopeng.xui.theme.ThemeWatcher;
import com.xiaopeng.xui.utils.UIUtils;
/* loaded from: classes.dex */
public abstract class XBaseDialog extends Dialog implements IXDialog, View.OnClickListener, ThemeWatcher.OnThemeSwitchListener {
    private static final String TAG = "XBaseDialog";
    protected ViewGroup mButtonContainer;
    protected TextView mCancelButton;
    protected Drawable mCancelButtonBg;
    protected XDialogCloseView mCloseView;
    protected ViewGroup mContentContainer;
    protected XBaseDialogView mContentView;
    protected Context mContext;
    protected TextView mDialogTitleTextView;
    protected View mHorDivider;
    protected boolean mIsDialogShowing;
    protected boolean mIsNight;
    protected RelativeLayout mMainContent;
    protected TextView mOkButton;
    protected Drawable mOkButtonBg;
    protected OnDialogCloseListener mOnDialogCloseListener;
    protected int mTitleColor;

    /* loaded from: classes.dex */
    public interface OnDialogCloseListener {
        void onDialogClose();
    }

    public XBaseDialog(Context context, int i) {
        super(context, R.style.XDialog);
        Window window;
        this.mContext = context;
        init();
        setContentView(this.mContentView);
        initDialog();
        boolean isNight = ThemeWatcher.getInstance().isNight();
        Log.d(TAG, "XBaseDialog XBaseDialog(), isNight: " + isNight);
        setIsNight(isNight);
        ThemeWatcher.getInstance().addThemeSwitchListener(this);
        if (!(context instanceof Application) || (window = getWindow()) == null) {
            return;
        }
        window.setType(i);
    }

    private void checkButtonContainerVisible() {
        if (this.mOkButton.getVisibility() != 0 && this.mCancelButton.getVisibility() != 0) {
            this.mButtonContainer.setVisibility(8);
            return;
        }
        this.mButtonContainer.setVisibility(0);
        if (this.mOkButton.getVisibility() == 0 && this.mCancelButton.getVisibility() == 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mOkButton.getLayoutParams();
            layoutParams.addRule(9, -1);
            layoutParams.removeRule(14);
            layoutParams.width = 262;
            this.mOkButton.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mCancelButton.getLayoutParams();
            layoutParams2.addRule(11, -1);
            layoutParams2.removeRule(14);
            layoutParams2.width = 262;
            this.mCancelButton.setLayoutParams(layoutParams2);
        } else if (this.mOkButton.getVisibility() == 0) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mOkButton.getLayoutParams();
            layoutParams3.width = 432;
            layoutParams3.addRule(14, -1);
            layoutParams3.removeRule(9);
            this.mOkButton.setLayoutParams(layoutParams3);
        } else {
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.mCancelButton.getLayoutParams();
            layoutParams4.width = 432;
            layoutParams4.addRule(14, -1);
            layoutParams4.removeRule(11);
            this.mCancelButton.setLayoutParams(layoutParams4);
        }
    }

    private void init() {
        XBaseDialogView xBaseDialogView = new XBaseDialogView(this.mContext);
        this.mContentView = xBaseDialogView;
        xBaseDialogView.setDialog(this);
        this.mMainContent = (RelativeLayout) this.mContentView.findViewById(R.id.main_content);
        this.mCloseView = (XDialogCloseView) this.mContentView.findViewById(R.id.xdialog_close_view);
        this.mDialogTitleTextView = (TextView) this.mContentView.findViewById(R.id.xdialog_title);
        this.mCancelButton = (TextView) this.mContentView.findViewById(R.id.dialog_cancel_button);
        this.mOkButton = (TextView) this.mContentView.findViewById(R.id.dialog_ok_button);
        this.mHorDivider = this.mContentView.findViewById(R.id.xdialog_divider_horizontal);
        this.mButtonContainer = (ViewGroup) this.mContentView.findViewById(R.id.dialog_button_group);
        this.mContentContainer = (ViewGroup) this.mContentView.findViewById(R.id.content_container);
        if (getContentView() != null) {
            this.mContentContainer.addView(getContentView());
        }
        this.mCloseView.setDialog(this);
        this.mOkButton.setOnClickListener(this);
        this.mCancelButton.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveDismiss() {
        try {
            super.dismiss();
        } catch (Exception e) {
            tf.i(TAG, e);
        }
    }

    protected void checkTitleVisible(boolean z) {
        ViewGroup viewGroup = this.mContentContainer;
        if (viewGroup != null) {
            Resources resources = viewGroup.getResources();
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mContentContainer.getLayoutParams();
            if (z) {
                marginLayoutParams.topMargin = resources.getDimensionPixelSize(R.dimen.xdialog_content_margin_top_with_title);
            } else {
                marginLayoutParams.topMargin = resources.getDimensionPixelSize(R.dimen.xdialog_content_margin_top_no_title);
            }
            this.mContentContainer.setLayoutParams(marginLayoutParams);
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        dismiss(true);
    }

    protected abstract View getContentView();

    /* JADX INFO: Access modifiers changed from: protected */
    public void initDialog() {
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = UIUtils.getScreenWidth() - (UIUtils.dip2px(160.0f) * 2);
            attributes.height = -2;
            attributes.y = -UIUtils.dip2px(100.0f);
            window.setAttributes(attributes);
        }
    }

    public boolean isDialogShowing() {
        return this.mIsDialogShowing;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.xiaopeng.xui.widgets.dialog.IXDialog
    public void onDialogClose() {
        dismiss();
        OnDialogCloseListener onDialogCloseListener = this.mOnDialogCloseListener;
        if (onDialogCloseListener != null) {
            onDialogCloseListener.onDialogClose();
        }
    }

    @Override // com.xiaopeng.xui.theme.ThemeWatcher.OnThemeSwitchListener
    public void onSwitchTheme(int i) {
        boolean isNight = ThemeWatcher.getInstance().isNight();
        Log.d(TAG, "XBaseDialog onSwitchTheme, i: " + i + "  isNight: " + isNight);
        setIsNight(isNight);
    }

    public void refreshTheme() {
        setIsNight(ThemeWatcher.getInstance().isNight());
    }

    public void setButtonMarginTop(int i) {
        RelativeLayout.LayoutParams layoutParams;
        View view = this.mHorDivider;
        if (view == null || (layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams()) == null) {
            return;
        }
        layoutParams.topMargin = i - 1;
    }

    public void setCancelButtonClickListener(View.OnClickListener onClickListener) {
        TextView textView = this.mCancelButton;
        if (textView == null || textView.getVisibility() != 0) {
            return;
        }
        this.mCancelButton.setOnClickListener(onClickListener);
    }

    public void setCancelButtonEnable(boolean z) {
        TextView textView = this.mCancelButton;
        if (textView != null) {
            textView.setEnabled(z);
        }
    }

    public void setCancelButtonText(CharSequence charSequence) {
        TextView textView = this.mCancelButton;
        if (textView == null || textView.getVisibility() != 0) {
            return;
        }
        this.mCancelButton.setText(charSequence);
    }

    public void setCancelButtonTextColor(int i) {
        TextView textView = this.mCancelButton;
        if (textView == null || textView.getVisibility() != 0) {
            return;
        }
        this.mCancelButton.setTextColor(i);
    }

    public void setCloseImageDrawable(int i, int i2) {
        XDialogCloseView xDialogCloseView = this.mCloseView;
        if (xDialogCloseView != null) {
            xDialogCloseView.setCloseImage(i, i2);
        }
    }

    public void setContentMargin(int i, int i2, int i3, int i4) {
        RelativeLayout.LayoutParams layoutParams;
        ViewGroup viewGroup = this.mContentContainer;
        if (viewGroup == null || (layoutParams = (RelativeLayout.LayoutParams) viewGroup.getLayoutParams()) == null) {
            return;
        }
        layoutParams.leftMargin = i;
        layoutParams.topMargin = i2;
        layoutParams.rightMargin = i3;
        layoutParams.bottomMargin = i4;
    }

    public void setGravity(int i) {
    }

    public void setIsNight(boolean z) {
        this.mIsNight = z;
        this.mContentView.setIsNight(z);
        this.mCloseView.setIsNight(z);
        if (z) {
            this.mTitleColor = UIUtils.getColor(R.color.x_dialog_title_color_night);
            this.mOkButtonBg = UIUtils.getDrawable(R.drawable.xdialog_btn_ok_bg_selector_night);
            this.mCancelButtonBg = UIUtils.getDrawable(R.drawable.xdialog_btn_bg_selector_night);
        } else {
            this.mTitleColor = UIUtils.getColor(R.color.x_dialog_title_color_day);
            this.mOkButtonBg = UIUtils.getDrawable(R.drawable.xdialog_btn_ok_bg_selector_day);
            this.mCancelButtonBg = UIUtils.getDrawable(R.drawable.xdialog_btn_bg_selector_day);
        }
        this.mDialogTitleTextView.setTextColor(this.mTitleColor);
        this.mOkButton.setBackground(this.mOkButtonBg);
        this.mCancelButton.setBackground(this.mCancelButtonBg);
        TextPaint paint = this.mDialogTitleTextView.getPaint();
        if (paint != null) {
            paint.setFakeBoldText(false);
        }
        this.mContentView.invalidate();
    }

    public void setOkButtonClickListener(View.OnClickListener onClickListener) {
        TextView textView = this.mOkButton;
        if (textView == null || textView.getVisibility() != 0) {
            return;
        }
        this.mOkButton.setOnClickListener(onClickListener);
    }

    public void setOkButtonEnable(boolean z) {
        TextView textView = this.mOkButton;
        if (textView != null) {
            textView.setEnabled(z);
        }
    }

    public void setOkButtonText(CharSequence charSequence) {
        TextView textView = this.mOkButton;
        if (textView == null || textView.getVisibility() != 0) {
            return;
        }
        this.mOkButton.setText(charSequence);
    }

    public void setOkButtonTextColor(int i) {
        TextView textView = this.mOkButton;
        if (textView == null || textView.getVisibility() != 0) {
            return;
        }
        this.mOkButton.setTextColor(i);
    }

    public void setOnDialogCloseListener(OnDialogCloseListener onDialogCloseListener) {
        this.mOnDialogCloseListener = onDialogCloseListener;
    }

    @Override // android.app.Dialog
    public void setTitle(int i) {
        TextView textView = this.mDialogTitleTextView;
        if (textView == null || textView.getVisibility() != 0) {
            return;
        }
        this.mDialogTitleTextView.setText(i);
    }

    public void setTitleMarginTop(int i) {
        RelativeLayout.LayoutParams layoutParams;
        TextView textView = this.mDialogTitleTextView;
        if (textView == null || (layoutParams = (RelativeLayout.LayoutParams) textView.getLayoutParams()) == null) {
            return;
        }
        layoutParams.topMargin = i;
    }

    @Override // android.app.Dialog
    public void show() {
        show(true);
    }

    public void showCancelButton(boolean z) {
        TextView textView = this.mCancelButton;
        if (textView != null) {
            textView.setVisibility(z ? 0 : 8);
            checkButtonContainerVisible();
        }
    }

    public void showClose(boolean z) {
        XDialogCloseView xDialogCloseView = this.mCloseView;
        if (xDialogCloseView != null) {
            xDialogCloseView.setVisibility(z ? 0 : 8);
            this.mContentView.invalidate();
        }
    }

    public void showOkButton(boolean z) {
        TextView textView = this.mOkButton;
        if (textView != null) {
            textView.setVisibility(z ? 0 : 8);
            checkButtonContainerVisible();
        }
    }

    public void showTitle(boolean z) {
        TextView textView = this.mDialogTitleTextView;
        if (textView != null) {
            textView.setVisibility(z ? 0 : 8);
            checkTitleVisible(z);
        }
    }

    public void dismiss(boolean z) {
        ThemeWatcher.getInstance().removeThemeListener(this);
        Context context = this.mContext;
        if (!((context instanceof Activity) && ((Activity) context).isFinishing()) && this.mIsDialogShowing) {
            if (z) {
                XDialogAnimUtils.startDismissAnimation(this.mContentView, new AnimatorListenerAdapter() { // from class: com.xiaopeng.xui.widgets.dialog.XBaseDialog.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        XBaseDialog.this.saveDismiss();
                        XBaseDialog.this.mIsDialogShowing = false;
                    }
                });
                return;
            }
            saveDismiss();
            this.mIsDialogShowing = false;
        }
    }

    public void show(boolean z) {
        Context context = this.mContext;
        if (((context instanceof Activity) && ((Activity) context).isFinishing()) || this.mIsDialogShowing) {
            return;
        }
        this.mIsDialogShowing = true;
        ThemeWatcher.getInstance().addThemeSwitchListener(this);
        if (z) {
            XDialogAnimUtils.startShowAnimation(this.mContentView);
        }
        super.show();
    }

    public void setCancelButtonText(int i) {
        TextView textView = this.mCancelButton;
        if (textView == null || textView.getVisibility() != 0) {
            return;
        }
        this.mCancelButton.setText(i);
    }

    public void setOkButtonText(int i) {
        TextView textView = this.mOkButton;
        if (textView == null || textView.getVisibility() != 0) {
            return;
        }
        this.mOkButton.setText(i);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        TextView textView = this.mDialogTitleTextView;
        if (textView == null || textView.getVisibility() != 0) {
            return;
        }
        this.mDialogTitleTextView.setText(charSequence);
    }

    @Deprecated
    public void dismiss(long j) {
        ThemeWatcher.getInstance().removeThemeListener(this);
        new Handler().postDelayed(new Runnable() { // from class: com.xiaopeng.xui.widgets.dialog.XBaseDialog.3
            @Override // java.lang.Runnable
            public void run() {
                XBaseDialog.this.dismiss();
            }
        }, j);
    }

    @Deprecated
    public void show(long j) {
        new Handler().postDelayed(new Runnable() { // from class: com.xiaopeng.xui.widgets.dialog.XBaseDialog.2
            @Override // java.lang.Runnable
            public void run() {
                XBaseDialog.this.show();
            }
        }, j);
    }

    public XBaseDialog(Context context) {
        this(context, 2010);
    }
}
