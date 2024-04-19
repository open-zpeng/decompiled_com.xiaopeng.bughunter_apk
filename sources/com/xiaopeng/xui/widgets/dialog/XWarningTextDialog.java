package com.xiaopeng.xui.widgets.dialog;

import android.content.Context;
import com.xiaopeng.xui.R;
import com.xiaopeng.xui.utils.UIUtils;
/* loaded from: classes.dex */
public class XWarningTextDialog extends XIconTextDialog {
    public XWarningTextDialog(Context context, int i) {
        super(context, i);
    }

    @Override // com.xiaopeng.xui.widgets.dialog.XIconTextDialog, com.xiaopeng.xui.widgets.dialog.XTextDialog, com.xiaopeng.xui.widgets.dialog.XBaseDialog
    public void initDialog() {
        super.initDialog();
        this.mIconView.setImageDrawable(UIUtils.getDrawable(R.mipmap.xdialog_img_warning));
    }

    public XWarningTextDialog(Context context) {
        super(context);
    }
}
