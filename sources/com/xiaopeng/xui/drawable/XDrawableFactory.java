package com.xiaopeng.xui.drawable;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
/* loaded from: classes.dex */
public class XDrawableFactory {
    public static Drawable createAnimatedCircleDrawable(int i, float f, ColorStateList colorStateList, long j, int i2, int i3, float f2, float f3) {
        XSpringCircleDrawable xSpringCircleDrawable = new XSpringCircleDrawable(i, f, j, f2, f3);
        xSpringCircleDrawable.setColorStateList(colorStateList);
        xSpringCircleDrawable.setStroke(i3, i2);
        return xSpringCircleDrawable;
    }

    public static Drawable createRoundDrawable(float f, ColorStateList colorStateList, int i, int i2) {
        XGradientDrawable xGradientDrawable = new XGradientDrawable();
        xGradientDrawable.setCornerRadius(f);
        xGradientDrawable.setColorStateList(colorStateList);
        xGradientDrawable.setStroke(i2, i);
        return xGradientDrawable;
    }

    public static Drawable createRoundDrawable(GradientDrawable.Orientation orientation, int[] iArr, float f, int i, int i2) {
        XGradientDrawable xGradientDrawable = new XGradientDrawable(orientation, iArr);
        xGradientDrawable.setCornerRadius(f);
        xGradientDrawable.setStroke(i2, i);
        return xGradientDrawable;
    }

    public static Drawable createRoundDrawable(int i, float f, int i2, int i3) {
        XGradientDrawable xGradientDrawable = new XGradientDrawable();
        xGradientDrawable.setColor(i);
        xGradientDrawable.setCornerRadius(f);
        xGradientDrawable.setStroke(i3, i2);
        return xGradientDrawable;
    }
}
