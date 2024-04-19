package com.xiaopeng.xui.widgets.dialog;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.xiaopeng.xui.R;
import com.xiaopeng.xui.utils.UIUtils;
/* loaded from: classes.dex */
public class XIconTextDialog extends XTextDialog {
    protected ImageView mIconView;

    public XIconTextDialog(Context context, int i) {
        super(context, i);
    }

    @Override // com.xiaopeng.xui.widgets.dialog.XTextDialog, com.xiaopeng.xui.widgets.dialog.XBaseDialog
    public void initDialog() {
        super.initDialog();
        showCancelButton(false);
        showClose(false);
        setGravity(17);
        ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.xdialog_icon_layout, (ViewGroup) this.mMainContent, false);
        this.mIconView = imageView;
        this.mMainContent.addView(imageView);
        showTitle(false);
        this.mContentTextView.setTextSize(2, 34.0f);
    }

    public void setIconDrawable(int i) {
        this.mIconView.setImageDrawable(UIUtils.getDrawable(i));
    }

    @Override // com.xiaopeng.xui.widgets.dialog.XTextDialog, com.xiaopeng.xui.widgets.dialog.XBaseDialog
    public void showTitle(boolean z) {
        super.showTitle(z);
        Resources resources = this.mIconView.getResources();
        if (z) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mDialogTitleTextView.getLayoutParams();
            layoutParams.addRule(3, R.id.xdialog_icon);
            layoutParams.topMargin = resources.getDimensionPixelSize(R.dimen.xdialog_title_margin_with_icon);
            this.mDialogTitleTextView.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mContentContainer.getLayoutParams();
            layoutParams2.addRule(3, R.id.xdialog_title);
            layoutParams2.topMargin = resources.getDimensionPixelSize(R.dimen.xdialog_content_margin_top_with_title);
            this.mContentContainer.setLayoutParams(layoutParams2);
            return;
        }
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mContentContainer.getLayoutParams();
        layoutParams3.addRule(3, R.id.xdialog_icon);
        layoutParams3.topMargin = resources.getDimensionPixelSize(R.dimen.xdialog_content_margin_top_waring_no_title);
        this.mContentContainer.setLayoutParams(layoutParams3);
    }

    public XIconTextDialog(Context context) {
        super(context);
    }

    public void setIconDrawable(Drawable drawable) {
        this.mIconView.setImageDrawable(drawable);
    }
}
