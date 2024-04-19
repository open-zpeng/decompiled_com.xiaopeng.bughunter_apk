package com.xiaopeng.xui.widgets.dialog;

import android.content.Context;
/* loaded from: classes.dex */
public class XSingleTextDialog extends XTextDialog {
    public XSingleTextDialog(Context context, int i) {
        super(context, i);
    }

    @Override // com.xiaopeng.xui.widgets.dialog.XTextDialog, com.xiaopeng.xui.widgets.dialog.XBaseDialog
    public void initDialog() {
        super.initDialog();
        showCancelButton(false);
        showTitle(false);
        showClose(false);
        setGravity(17);
    }

    public XSingleTextDialog(Context context) {
        super(context);
    }
}
