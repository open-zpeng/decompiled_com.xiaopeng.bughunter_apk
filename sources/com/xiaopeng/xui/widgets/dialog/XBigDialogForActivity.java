package com.xiaopeng.xui.widgets.dialog;

import android.os.Bundle;
import android.support.v4.app.f;
import android.util.Log;
import android.view.View;
import com.xiaopeng.xui.theme.ThemeWatcher;
/* loaded from: classes.dex */
public abstract class XBigDialogForActivity extends f implements IXDialog, ThemeWatcher.OnThemeSwitchListener {
    private static final String TAG = "XBigDialogForActivity";
    private XBigDialogView mContentView;

    protected abstract View getContentView();

    protected abstract void initView();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.f, android.support.v4.app.a0, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        XBigDialogView xBigDialogView = new XBigDialogView(this);
        this.mContentView = xBigDialogView;
        setContentView(xBigDialogView);
        this.mContentView.setDialog(this);
        this.mContentView.setContentView(getContentView());
        initView();
        boolean isNight = ThemeWatcher.getInstance().isNight();
        Log.d(TAG, "XBigDialogForActivity XBigDialogForActivity(), isNight:" + isNight);
        setIsNight(isNight);
        ThemeWatcher.getInstance().addThemeSwitchListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.f, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ThemeWatcher.getInstance().removeThemeListener(this);
    }

    @Override // com.xiaopeng.xui.widgets.dialog.IXDialog
    public void onDialogClose() {
        finish();
    }

    @Override // com.xiaopeng.xui.theme.ThemeWatcher.OnThemeSwitchListener
    public void onSwitchTheme(int i) {
        boolean isNight = ThemeWatcher.getInstance().isNight();
        Log.d(TAG, "XBigDialogForActivity onSwitchTheme, i: " + i + "  isNight:" + isNight);
        setIsNight(isNight);
    }

    protected void setCloseImage(int i, int i2) {
        this.mContentView.setCloseImage(i, i2);
    }

    protected void setContentViewPadding(int i, int i2, int i3, int i4) {
        this.mContentView.setContentViewPadding(i, i2, i3, i4);
    }

    protected void setIsNight(boolean z) {
        this.mContentView.setIsNight(z);
    }

    protected void setMask(int i, int i2) {
        this.mContentView.setMask(i, i2);
    }

    public void showClose(boolean z) {
        this.mContentView.showClose(z);
    }
}
