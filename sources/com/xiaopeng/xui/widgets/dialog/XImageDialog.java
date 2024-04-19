package com.xiaopeng.xui.widgets.dialog;

import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import com.xiaopeng.xui.R;
import com.xiaopeng.xui.theme.ThemeWatcher;
import com.xiaopeng.xui.utils.UIUtils;
/* loaded from: classes.dex */
public class XImageDialog extends Dialog implements IXDialog {
    private XDialogCloseView mCloseView;
    private XImageDialogView mContentView;
    private int mWidth;

    public XImageDialog(Context context, int i) {
        super(context, R.style.XDialog);
        this.mWidth = UIUtils.getScreenWidth() - UIUtils.dip2px(42.0f);
        initDialog();
        XImageDialogView xImageDialogView = new XImageDialogView(context);
        this.mContentView = xImageDialogView;
        xImageDialogView.setDialogWidth(getWidth());
        XDialogCloseView xDialogCloseView = (XDialogCloseView) this.mContentView.findViewById(R.id.xdialog_close_view);
        this.mCloseView = xDialogCloseView;
        xDialogCloseView.setDialog(this);
        setContentView(this.mContentView);
        if (context instanceof Application) {
            getWindow().setType(i);
        }
    }

    private void initDialog() {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = getWidth();
        attributes.height = -2;
        attributes.y = ((-UIUtils.getStatusBarHeight()) / 2) + (UIUtils.dip2px(60.0f) / 2);
        getWindow().setAttributes(attributes);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        this.mContentView.cleanup();
        super.dismiss();
    }

    public int getWidth() {
        return this.mWidth;
    }

    @Override // com.xiaopeng.xui.widgets.dialog.IXDialog
    public void onDialogClose() {
        dismiss();
    }

    public void refreshTheme() {
        this.mContentView.setTheme();
    }

    public void setBottomContentView(View view) {
        this.mContentView.setBottomContentView(view);
    }

    public void setCloseImageDrawable(int i, int i2) {
        XDialogCloseView xDialogCloseView = this.mCloseView;
        if (xDialogCloseView != null) {
            xDialogCloseView.setCloseImage(i, i2);
            this.mCloseView.setIsNight(ThemeWatcher.getInstance().isNight());
        }
    }

    public void setTopImageView(int i) {
        this.mContentView.setTopImage(i);
    }

    @Override // android.app.Dialog
    public void show() {
        this.mContentView.addThemeListener();
        super.show();
    }

    public XImageDialog(Context context) {
        this(context, 2010);
    }
}
