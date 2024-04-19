package com.xiaopeng.xui.widgets.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.xiaopeng.xui.R;
import com.xiaopeng.xui.utils.UIUtils;
/* loaded from: classes.dex */
public class XTextDialog extends XBaseDialog {
    protected TextView mContentTextView;

    public XTextDialog(Context context) {
        super(context);
    }

    @Override // com.xiaopeng.xui.widgets.dialog.XBaseDialog
    protected View getContentView() {
        return LayoutInflater.from(getContext()).inflate(R.layout.xdialog_text_layout, (ViewGroup) null);
    }

    @Override // com.xiaopeng.xui.widgets.dialog.XBaseDialog
    public void initDialog() {
        super.initDialog();
        this.mContentTextView = (TextView) findViewById(R.id.xdialog_content1);
    }

    public void setContentText(String str) {
        this.mContentTextView.setText(str);
    }

    @Override // com.xiaopeng.xui.widgets.dialog.XBaseDialog
    public void setGravity(int i) {
        this.mContentTextView.setGravity(i);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mContentTextView.getLayoutParams();
        layoutParams.width = -2;
        layoutParams.gravity = i;
        this.mContentTextView.setLayoutParams(layoutParams);
    }

    @Override // com.xiaopeng.xui.widgets.dialog.XBaseDialog
    public void setIsNight(boolean z) {
        TextView textView = this.mDialogTitleTextView;
        updateViewNight(z, textView != null && textView.getVisibility() == 0);
        super.setIsNight(z);
    }

    @Override // com.xiaopeng.xui.widgets.dialog.XBaseDialog
    public void showTitle(boolean z) {
        super.showTitle(z);
        if (!z) {
            this.mContentTextView.setTextSize(2, 30.0f);
        } else {
            this.mContentTextView.setTextSize(2, 24.0f);
        }
        updateViewNight(this.mIsNight, z);
    }

    protected void updateViewNight(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.mContentTextView.setTextColor(UIUtils.getColor(R.color.x_dialog_content_color_night));
            } else {
                this.mContentTextView.setTextColor(UIUtils.getColor(R.color.x_dialog_content_color_day));
            }
        } else if (z) {
            this.mContentTextView.setTextColor(UIUtils.getColor(R.color.x_dialog_title_color_night));
        } else {
            this.mContentTextView.setTextColor(UIUtils.getColor(R.color.x_dialog_title_color_day));
        }
    }

    public XTextDialog(Context context, int i) {
        super(context, i);
    }

    public void setContentText(int i) {
        this.mContentTextView.setText(i);
    }
}
