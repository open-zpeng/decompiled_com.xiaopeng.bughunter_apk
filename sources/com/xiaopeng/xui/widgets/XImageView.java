package com.xiaopeng.xui.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.xiaopeng.xui.R;
import com.xiaopeng.xui.utils.BitmapUtils;
/* loaded from: classes.dex */
public class XImageView extends ImageView {
    private static final String STATE_BORDER_RADIUS = "state_border_radius";
    private static final String STATE_INSTANCE = "state_instance";
    private static final String STATE_TYPE = "state_type";
    private static final int TYPE_CIRCLE = 1;
    private static final int TYPE_ROUND_CORNER = 2;
    private BitmapShader mBitmapShader;
    private int mBorderRadius;
    private int mDisplayType;
    private int mHeight;
    private Matrix mMatrix;
    private Paint mPaint;
    private int mRadius;
    private RectF mRoundRect;
    private int mStrokeColor;
    private float mStrokeWidth;
    private int mWidth;

    public XImageView(Context context) {
        this(context, null, 0);
    }

    private void drawBorder(Canvas canvas) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(this.mStrokeColor);
        paint.setStrokeWidth(this.mStrokeWidth);
        int i = this.mDisplayType;
        if (2 == i) {
            RectF rectF = this.mRoundRect;
            int i2 = this.mBorderRadius;
            float f = this.mStrokeWidth;
            canvas.drawRoundRect(rectF, i2 + (f / 2.0f), i2 + (f / 2.0f), paint);
        } else if (1 == i) {
            int i3 = this.mRadius;
            canvas.drawCircle(i3, i3, (i3 - (this.mStrokeWidth / 2.0f)) - getPadding(), paint);
        }
        canvas.save();
    }

    private void drawImage(Canvas canvas) {
        setUpShader();
        this.mPaint.setStyle(Paint.Style.FILL);
        int i = this.mDisplayType;
        if (2 == i) {
            RectF rectF = this.mRoundRect;
            float f = rectF.left;
            float f2 = this.mStrokeWidth;
            RectF rectF2 = new RectF(f + (f2 / 2.0f), rectF.top + (f2 / 2.0f), rectF.right - (f2 / 2.0f), rectF.bottom - (f2 / 2.0f));
            int i2 = this.mBorderRadius;
            canvas.drawRoundRect(rectF2, i2, i2, this.mPaint);
        } else if (1 == i) {
            int i3 = this.mRadius;
            canvas.drawCircle(i3, i3, (i3 - this.mStrokeWidth) - getPadding(), this.mPaint);
        }
        canvas.save();
    }

    private int getPadding() {
        return Math.min(getPaddingLeft(), Math.min(getPaddingRight(), Math.min(getPaddingBottom(), getPaddingTop())));
    }

    private void initial() {
        this.mMatrix = new Matrix();
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
    }

    private void setUpShader() {
        Bitmap drawableToBitmap;
        Drawable drawable = getDrawable();
        if (drawable == null || (drawableToBitmap = BitmapUtils.drawableToBitmap(drawable)) == null) {
            return;
        }
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.mBitmapShader = new BitmapShader(drawableToBitmap, tileMode, tileMode);
        int i = this.mDisplayType;
        float f = 1.0f;
        if (1 == i) {
            f = (this.mWidth * 1.0f) / Math.min(drawableToBitmap.getWidth(), drawableToBitmap.getHeight());
        } else if (2 == i) {
            f = Math.max((getWidth() * 1.0f) / drawableToBitmap.getWidth(), (getHeight() * 1.0f) / drawableToBitmap.getHeight());
        }
        this.mMatrix.setScale(f, f);
        this.mBitmapShader.setLocalMatrix(this.mMatrix);
        this.mPaint.setShader(this.mBitmapShader);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mStrokeWidth > 0.0f) {
            drawBorder(canvas);
        }
        if (getDrawable() != null) {
            drawImage(canvas);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.mDisplayType == 1) {
            int min = Math.min(getMeasuredWidth(), getMeasuredHeight());
            this.mWidth = min;
            this.mHeight = min;
            this.mRadius = min / 2;
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            if (bundle.containsKey(STATE_INSTANCE)) {
                super.onRestoreInstanceState(bundle.getParcelable(STATE_INSTANCE));
                this.mDisplayType = bundle.getInt(STATE_TYPE);
                this.mBorderRadius = bundle.getInt(STATE_BORDER_RADIUS);
                return;
            }
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        Bundle bundle = new Bundle();
        bundle.putParcelable(STATE_INSTANCE, onSaveInstanceState);
        bundle.putInt(STATE_TYPE, this.mDisplayType);
        bundle.putInt(STATE_BORDER_RADIUS, this.mBorderRadius);
        return bundle;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (2 == this.mDisplayType) {
            this.mRoundRect = new RectF(getPaddingLeft() + (this.mStrokeWidth / 2.0f), getPaddingTop() + (this.mStrokeWidth / 2.0f), (getWidth() - (this.mStrokeWidth / 2.0f)) - getPaddingRight(), (getHeight() - (this.mStrokeWidth / 2.0f)) - getPaddingBottom());
        }
    }

    public XImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mStrokeWidth = 0.0f;
        this.mStrokeColor = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Xui_Common);
        this.mBorderRadius = (int) obtainStyledAttributes.getDimension(R.styleable.Xui_Common_xui_radius, 0.0f);
        this.mDisplayType = obtainStyledAttributes.getInt(R.styleable.Xui_Common_xui_display, 0);
        this.mStrokeWidth = obtainStyledAttributes.getDimension(R.styleable.Xui_Common_xui_strokeWidth, 0.0f);
        this.mStrokeColor = obtainStyledAttributes.getColor(R.styleable.Xui_Common_xui_strokeColor, 0);
        obtainStyledAttributes.recycle();
        initial();
    }
}
