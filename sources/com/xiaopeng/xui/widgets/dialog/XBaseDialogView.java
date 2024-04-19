package com.xiaopeng.xui.widgets.dialog;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.xiaopeng.xui.R;
import com.xiaopeng.xui.drawable.ColorNinePatchHelper;
/* loaded from: classes.dex */
public class XBaseDialogView extends LinearLayout {
    private ColorNinePatchHelper mColorNinePatchHelper;
    private XBaseDialog mDialog;
    private float mFontScale;
    private NinePatch mMaskNinePatch;
    private Rect mMaskRect;
    private PorterDuffXfermode mMode;
    private Paint mPaint;

    public XBaseDialogView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        this.mColorNinePatchHelper = new ColorNinePatchHelper();
        Paint paint = new Paint(1);
        this.mPaint = paint;
        paint.setAlpha(255);
        this.mPaint.setAntiAlias(false);
        this.mMode = new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP);
        this.mMaskNinePatch = this.mColorNinePatchHelper.getNinePatch(getResources(), getResources().getColor(R.color.x_dialog_bg_color_day));
        this.mFontScale = getResources().getConfiguration().fontScale;
        LayoutInflater.from(context).inflate(R.layout.x_base_dialog_layout, this);
    }

    private void setRect() {
        int left = getLeft();
        int top = getTop();
        this.mMaskRect = new Rect(left, top, getMeasuredWidth() + left, getMeasuredHeight() + top);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        this.mPaint.setAntiAlias(false);
        this.mPaint.setXfermode(this.mMode);
        this.mMaskNinePatch.draw(canvas, this.mMaskRect, this.mPaint);
        this.mPaint.setXfermode(null);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        float f = configuration.fontScale;
        Log.d("XBaseDialogView", "fontScale:" + this.mFontScale + ", " + f);
        if (this.mFontScale != f) {
            XBaseDialog xBaseDialog = this.mDialog;
            if (xBaseDialog != null && xBaseDialog.isShowing()) {
                this.mDialog.dismiss(false);
            }
            this.mFontScale = f;
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        setRect();
    }

    public void setDialog(XBaseDialog xBaseDialog) {
        this.mDialog = xBaseDialog;
    }

    public void setIsNight(boolean z) {
        int color;
        if (z) {
            color = getResources().getColor(R.color.x_dialog_bg_color_night);
        } else {
            color = getResources().getColor(R.color.x_dialog_bg_color_day);
        }
        this.mMaskNinePatch = this.mColorNinePatchHelper.getNinePatch(getResources(), color);
    }

    public XBaseDialogView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }
}
