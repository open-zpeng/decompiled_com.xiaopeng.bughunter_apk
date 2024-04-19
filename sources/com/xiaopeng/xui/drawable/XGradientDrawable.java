package com.xiaopeng.xui.drawable;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
/* loaded from: classes.dex */
public class XGradientDrawable extends GradientDrawable {
    private ColorStateList mColorStateList;
    private int mPaddingBottom;
    private int mPaddingLeft;
    private int mPaddingRight;
    private int mPaddingTop;

    public XGradientDrawable() {
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        setBounds(new Rect(this.mPaddingLeft, this.mPaddingTop, getBounds().width() - this.mPaddingRight, getBounds().height() - this.mPaddingBottom));
        super.draw(canvas);
    }

    public int getCurrentStateColor() {
        ColorStateList colorStateList = this.mColorStateList;
        if (colorStateList != null) {
            return colorStateList.getColorForState(getState(), this.mColorStateList.getDefaultColor());
        }
        return 0;
    }

    public int getPaddingBottom() {
        return this.mPaddingBottom;
    }

    public int getPaddingLeft() {
        return this.mPaddingLeft;
    }

    public int getPaddingRight() {
        return this.mPaddingRight;
    }

    public int getPaddingTop() {
        return this.mPaddingTop;
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        ColorStateList colorStateList;
        if (Build.VERSION.SDK_INT < 21 && (colorStateList = this.mColorStateList) != null) {
            setColor(colorStateList.getColorForState(iArr, colorStateList.getDefaultColor()));
            return true;
        }
        return super.onStateChange(iArr);
    }

    public void setColorStateList(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return;
        }
        this.mColorStateList = colorStateList;
        setColor(colorStateList.getColorForState(getState(), this.mColorStateList.getDefaultColor()));
    }

    @Override // android.graphics.drawable.GradientDrawable
    public void setPadding(int i, int i2, int i3, int i4) {
        this.mPaddingLeft = i;
        this.mPaddingRight = i3;
        this.mPaddingTop = i2;
        this.mPaddingBottom = i4;
        invalidateSelf();
    }

    public XGradientDrawable(GradientDrawable.Orientation orientation, int[] iArr) {
        super(orientation, iArr);
    }
}
