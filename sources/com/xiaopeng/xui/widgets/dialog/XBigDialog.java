package com.xiaopeng.xui.widgets.dialog;

import android.content.Context;
import android.util.Log;
import android.view.View;
import com.xiaopeng.xui.XUI;
import com.xiaopeng.xui.theme.ThemeWatcher;
/* loaded from: classes.dex */
public class XBigDialog implements IXDialog, View.OnClickListener, ThemeWatcher.OnThemeSwitchListener {
    private static final String TAG = "XBigDialog";
    private XBigDialogView mContentView;
    private XDialogWindow mWindow;

    /* loaded from: classes.dex */
    public static class Builder {
        private Integer closeImgResIdDay;
        private Integer closeImgResIdNight;
        private View contentView;
        private Context context;
        private Integer mMaskResIdDay;
        private Integer mMaskResIdNight;
        private Integer offSetY;
        private OnDismissListener onDismissListener;
        private Integer paddingBottom;
        private Integer paddingLeft;
        private Integer paddingRight;
        private Integer paddingTop;
        private Integer windowFlags;
        private Integer windowType;
        private boolean isNight = ThemeWatcher.getInstance().isNight();
        private boolean showClose = true;

        public Builder(Context context) {
            this.context = context;
        }

        public XBigDialog build() {
            XBigDialog xBigDialog = new XBigDialog(this.context) { // from class: com.xiaopeng.xui.widgets.dialog.XBigDialog.Builder.1
                @Override // com.xiaopeng.xui.widgets.dialog.XBigDialog, com.xiaopeng.xui.widgets.dialog.IXDialog
                public void onDialogClose() {
                    super.onDialogClose();
                    if (Builder.this.onDismissListener != null) {
                        Builder.this.onDismissListener.onDismiss();
                    }
                }
            };
            xBigDialog.mContentView.setContentView(this.contentView);
            if (this.offSetY != null) {
                xBigDialog.mWindow.setOffsetY(this.offSetY.intValue());
            }
            if (this.windowType != null) {
                xBigDialog.mWindow.setWindowType(this.windowType.intValue());
            }
            if (this.windowFlags != null) {
                xBigDialog.mWindow.setWindowFlags(this.windowFlags.intValue());
            }
            if (this.mMaskResIdNight != null && this.mMaskResIdDay != null) {
                xBigDialog.mContentView.setMask(this.mMaskResIdDay.intValue(), this.mMaskResIdNight.intValue());
            }
            if (this.paddingLeft != null && this.paddingTop != null && this.paddingRight != null && this.paddingBottom != null) {
                xBigDialog.mContentView.setContentViewPadding(this.paddingLeft.intValue(), this.paddingTop.intValue(), this.paddingRight.intValue(), this.paddingBottom.intValue());
            }
            if (this.closeImgResIdNight != null && this.closeImgResIdDay != null) {
                xBigDialog.mContentView.setCloseImage(this.closeImgResIdDay.intValue(), this.closeImgResIdNight.intValue());
            }
            xBigDialog.mContentView.showClose(this.showClose);
            xBigDialog.mContentView.setIsNight(this.isNight);
            return xBigDialog;
        }

        public Builder setCloseImage(int i, int i2) {
            this.closeImgResIdDay = Integer.valueOf(i);
            this.closeImgResIdNight = Integer.valueOf(i2);
            return this;
        }

        public Builder setContentView(View view) {
            this.contentView = view;
            return this;
        }

        public Builder setContentViewPadding(int i, int i2, int i3, int i4) {
            this.paddingLeft = Integer.valueOf(i);
            this.paddingTop = Integer.valueOf(i2);
            this.paddingRight = Integer.valueOf(i3);
            this.paddingBottom = Integer.valueOf(i4);
            return this;
        }

        public Builder setIsNight(boolean z) {
            this.isNight = z;
            return this;
        }

        public Builder setMask(int i, int i2) {
            this.mMaskResIdDay = Integer.valueOf(i);
            this.mMaskResIdNight = Integer.valueOf(i2);
            return this;
        }

        public Builder setOffsetY(int i) {
            this.offSetY = Integer.valueOf(i);
            return this;
        }

        public Builder setOnDismissListener(OnDismissListener onDismissListener) {
            this.onDismissListener = onDismissListener;
            return this;
        }

        public Builder setWindowFlags(int i) {
            this.windowFlags = Integer.valueOf(i);
            return this;
        }

        public Builder setWindowType(int i) {
            this.windowType = Integer.valueOf(i);
            return this;
        }

        public Builder showClose(boolean z) {
            this.showClose = z;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public interface OnDismissListener {
        void onDismiss();
    }

    public void dismiss() {
        dismiss(true);
    }

    public boolean isShowing() {
        return this.mWindow.isShowing();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.xiaopeng.xui.widgets.dialog.IXDialog
    public void onDialogClose() {
        dismiss();
    }

    @Override // com.xiaopeng.xui.theme.ThemeWatcher.OnThemeSwitchListener
    public void onSwitchTheme(int i) {
        boolean isNight = ThemeWatcher.getInstance().isNight();
        Log.d(TAG, "XBigDialog onSwitchTheme, i: " + i + " isNight: " + isNight);
        this.mWindow.setIsNight(isNight);
        this.mContentView.setIsNight(isNight);
    }

    public void refreshTheme() {
        boolean isNight = ThemeWatcher.getInstance().isNight();
        Log.d(TAG, "XBigDialog refreshTheme, isNight: " + isNight);
        this.mWindow.setIsNight(isNight);
        this.mContentView.setIsNight(isNight);
    }

    public void show() {
        ThemeWatcher.getInstance().addThemeSwitchListener(this);
        this.mWindow.setContentView(this.mContentView);
        this.mWindow.show();
    }

    public void showClose(boolean z) {
        XBigDialogView xBigDialogView = this.mContentView;
        if (xBigDialogView != null) {
            xBigDialogView.showClose(z);
        }
    }

    private XBigDialog(Context context) {
        this.mWindow = new XDialogWindow(context);
        XBigDialogView xBigDialogView = new XBigDialogView(XUI.getContext());
        this.mContentView = xBigDialogView;
        xBigDialogView.setDialog(this);
        boolean isNight = ThemeWatcher.getInstance().isNight();
        Log.d(TAG, "XBigDialog XBigDialog(), isNight: " + isNight);
        this.mWindow.setIsNight(isNight);
        this.mContentView.setIsNight(ThemeWatcher.getInstance().isNight());
        ThemeWatcher.getInstance().addThemeSwitchListener(this);
    }

    public void dismiss(boolean z) {
        ThemeWatcher.getInstance().removeThemeListener(this);
        this.mWindow.dismiss(z);
    }
}
