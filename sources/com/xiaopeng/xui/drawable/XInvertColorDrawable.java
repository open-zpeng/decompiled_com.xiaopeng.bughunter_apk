package com.xiaopeng.xui.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.BitmapDrawable;
/* loaded from: classes.dex */
public class XInvertColorDrawable extends BitmapDrawable {
    private static final float[] NEGATIVE = {-1.0f, 0.0f, 0.0f, 0.0f, 255.0f, 0.0f, -1.0f, 0.0f, 0.0f, 255.0f, 0.0f, 0.0f, -1.0f, 0.0f, 255.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f};

    public XInvertColorDrawable(Resources resources, Bitmap bitmap) {
        super(resources, bitmap);
    }

    public void setInvert(boolean z) {
        if (z) {
            setColorFilter(new ColorMatrixColorFilter(NEGATIVE));
        } else {
            setColorFilter(null);
        }
    }
}
