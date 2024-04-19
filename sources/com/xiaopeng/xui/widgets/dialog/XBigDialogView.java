package com.xiaopeng.xui.widgets.dialog;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.xiaopeng.xui.R;
import com.xiaopeng.xui.utils.UIUtils;
/* loaded from: classes.dex */
public class XBigDialogView extends FrameLayout {
    private XDialogCloseView mCloseView;
    private ViewGroup mContentContainer;
    private IXDialog mDialog;
    private float mFontScale;
    private int mMaskResIdDay;
    private int mMaskResIdNight;

    public XBigDialogView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        float f = configuration.fontScale;
        Log.d("XBigDialogView", "fontScale:" + this.mFontScale + ", " + f);
        if (this.mFontScale != f) {
            IXDialog iXDialog = this.mDialog;
            if (iXDialog != null) {
                if (iXDialog instanceof XBigDialog) {
                    XBigDialog xBigDialog = (XBigDialog) iXDialog;
                    if (xBigDialog.isShowing()) {
                        xBigDialog.dismiss(false);
                    }
                } else {
                    iXDialog.onDialogClose();
                }
            }
            this.mFontScale = f;
        }
    }

    public void setCloseImage(int i, int i2) {
        this.mCloseView.setCloseImage(i, i2);
    }

    public void setContentView(View view) {
        this.mContentContainer.addView(view);
    }

    public void setContentViewPadding(int i, int i2, int i3, int i4) {
        this.mContentContainer.setPadding(i, i2, i3, i4);
    }

    public void setDialog(IXDialog iXDialog) {
        this.mDialog = iXDialog;
        this.mCloseView.setDialog(iXDialog);
    }

    public void setIsNight(boolean z) {
        this.mCloseView.setIsNight(z);
        if (z) {
            setBackgroundResource(this.mMaskResIdNight);
        } else {
            setBackgroundResource(this.mMaskResIdDay);
        }
    }

    public void setMask(int i, int i2) {
        this.mMaskResIdDay = i;
        this.mMaskResIdNight = i2;
    }

    public void showClose(boolean z) {
        XDialogCloseView xDialogCloseView = this.mCloseView;
        if (xDialogCloseView != null) {
            xDialogCloseView.setVisibility(z ? 0 : 8);
        }
    }

    public XBigDialogView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(context).inflate(R.layout.xdialog_big_layout, this);
        this.mCloseView = (XDialogCloseView) findViewById(R.id.xdialog_big_close_view);
        this.mContentContainer = (ViewGroup) findViewById(R.id.xdialog_content_container);
        setIsNight(false);
        int dip2px = UIUtils.dip2px(100.0f);
        setContentViewPadding(dip2px, dip2px, dip2px, dip2px);
        this.mMaskResIdDay = R.drawable.xdialog_big_bg_day;
        this.mMaskResIdNight = R.drawable.xdialog_big_bg_night;
        this.mFontScale = getResources().getConfiguration().fontScale;
    }
}
