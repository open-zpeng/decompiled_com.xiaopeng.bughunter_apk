package com.xiaopeng.xui.widgets.dialog;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.xiaopeng.xui.R;
import com.xiaopeng.xui.drawable.ColorNinePatchHelper;
import com.xiaopeng.xui.theme.ThemeWatcher;
import com.xiaopeng.xui.utils.UIUtils;
/* loaded from: classes.dex */
class XImageDialogView extends FrameLayout implements ThemeWatcher.OnThemeSwitchListener {
    private static final String TAG = "XImageDialogView";
    private FrameLayout mBottomContainer;
    private XDialogCloseView mCloseView;
    private ColorNinePatchHelper mColorNinePatchHelper;
    private int mDialogWidth;
    private Bitmap mMask;
    private Rect mMaskRect;
    private PorterDuffXfermode mMode;
    private Paint mPaint;
    private NinePatch mPatch;
    private Drawable mTopImgDrawable;

    public XImageDialogView(Context context) {
        this(context, null);
    }

    private void init() {
        this.mColorNinePatchHelper = new ColorNinePatchHelper();
        this.mMask = BitmapFactory.decodeResource(getResources(), R.mipmap.xdialog_top_mask);
        this.mPaint = new Paint(1);
        Bitmap bitmap = this.mMask;
        this.mPatch = new NinePatch(bitmap, bitmap.getNinePatchChunk(), null);
        this.mMode = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        LayoutInflater.from(getContext()).inflate(R.layout.xdialog_top_image_layout, this);
        this.mBottomContainer = (FrameLayout) findViewById(R.id.bottom_container);
        this.mCloseView = (XDialogCloseView) findViewById(R.id.xdialog_close_view);
        setTheme();
        addThemeListener();
    }

    private void setRect() {
        int dip2px = UIUtils.dip2px(59.0f);
        int dip2px2 = UIUtils.dip2px(16.5f);
        this.mMaskRect = new Rect(0, -dip2px2, getWidth(), this.mMask.getHeight());
        this.mTopImgDrawable.setBounds(dip2px, dip2px2, getWidth() - dip2px, this.mTopImgDrawable.getIntrinsicHeight() + dip2px2);
    }

    public void addThemeListener() {
        ThemeWatcher.getInstance().addThemeSwitchListener(this);
    }

    public void cleanup() {
        ThemeWatcher.getInstance().removeThemeListener(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        this.mTopImgDrawable.draw(canvas);
        this.mPaint.setXfermode(this.mMode);
        this.mPatch.draw(canvas, this.mMaskRect, this.mPaint);
        this.mPaint.setXfermode(null);
        drawChild(canvas, this.mCloseView, getDrawingTime());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        setRect();
        this.mBottomContainer.setPadding(0, this.mTopImgDrawable.getIntrinsicHeight() - UIUtils.dip2px(34.0f), 0, 0);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.mDialogWidth, 1073741824), i2);
    }

    @Override // com.xiaopeng.xui.theme.ThemeWatcher.OnThemeSwitchListener
    public void onSwitchTheme(int i) {
        boolean isNight = ThemeWatcher.getInstance().isNight();
        Log.d(TAG, "XImageDialogView onSwitchTheme, i: " + i + "  isNight: " + isNight);
        setTheme();
    }

    public void setBottomContentView(View view) {
        this.mBottomContainer.addView(view);
    }

    public void setDialogWidth(int i) {
        this.mDialogWidth = i;
    }

    public void setTheme() {
        int color;
        if (ThemeWatcher.getInstance().isNight()) {
            color = getResources().getColor(R.color.x_dialog_bg_color_night);
            this.mCloseView.setIsNight(true);
        } else {
            color = getResources().getColor(R.color.x_dialog_bg_color_day);
            this.mCloseView.setIsNight(false);
        }
        setBackground(this.mColorNinePatchHelper.getDrawable(getResources(), color));
    }

    public void setTopImage(int i) {
        this.mTopImgDrawable = UIUtils.getDrawable(i);
    }

    public XImageDialogView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XImageDialogView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }
}
