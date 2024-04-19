package com.xiaopeng.xui.widgets.dialog;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.xiaopeng.xui.R;
import com.xiaopeng.xui.theme.ThemeWatcher;
import com.xiaopeng.xui.utils.UIUtils;
/* loaded from: classes.dex */
public class XDialogCloseView extends FrameLayout implements View.OnClickListener {
    private int mCloseImageResIdDay;
    private int mCloseImageResIdNight;
    private ImageView mCloseView;
    private IXDialog mDialog;
    private boolean mIsNight;

    public XDialogCloseView(Context context) {
        this(context, null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IXDialog iXDialog;
        if (view != this || (iXDialog = this.mDialog) == null) {
            return;
        }
        iXDialog.onDialogClose();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(UIUtils.dip2px(96.0f), 1073741824), View.MeasureSpec.makeMeasureSpec(UIUtils.dip2px(96.0f), 1073741824));
    }

    public void setCloseImage(int i, int i2) {
        this.mCloseImageResIdDay = i;
        this.mCloseImageResIdNight = i2;
        setIsNight(ThemeWatcher.getInstance().isNight());
    }

    public void setDialog(IXDialog iXDialog) {
        this.mDialog = iXDialog;
    }

    public void setIsNight(boolean z) {
        this.mIsNight = z;
        if (z) {
            this.mCloseView.setImageDrawable(UIUtils.getDrawable(this.mCloseImageResIdNight));
        } else {
            this.mCloseView.setImageDrawable(UIUtils.getDrawable(this.mCloseImageResIdDay));
        }
    }

    public XDialogCloseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        ImageView imageView = new ImageView(context);
        this.mCloseView = imageView;
        addView(imageView, layoutParams);
        setCloseImage(R.drawable.xdialog_img_close_selector_day, R.drawable.xdialog_img_close_selector_night);
        setIsNight(false);
        setOnClickListener(this);
    }
}
