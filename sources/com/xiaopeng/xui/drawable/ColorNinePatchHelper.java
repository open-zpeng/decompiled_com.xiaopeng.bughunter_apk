package com.xiaopeng.xui.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.xiaopeng.xui.utils.UIUtils;
/* loaded from: classes.dex */
public class ColorNinePatchHelper {
    private Bitmap mMaskNinePatchBitmap;
    private Paint mPaint = new Paint(1);

    private Bitmap getBitmap(int i) {
        Bitmap bitmap;
        int color = this.mPaint.getColor();
        int dip2px = UIUtils.dip2px(40.0f);
        int i2 = (dip2px + 1) * 2;
        Bitmap bitmap2 = this.mMaskNinePatchBitmap;
        if (bitmap2 == null) {
            bitmap = Bitmap.createBitmap(i2, i2, Bitmap.Config.ARGB_8888);
            this.mMaskNinePatchBitmap = bitmap;
        } else {
            bitmap2.eraseColor(16777215);
            bitmap = this.mMaskNinePatchBitmap;
        }
        Canvas canvas = new Canvas(bitmap);
        float f = i2 - 1;
        RectF rectF = new RectF(1.0f, 1.0f, f, f);
        this.mPaint.setColor(i);
        float f2 = dip2px;
        canvas.drawRoundRect(rectF, f2, f2, this.mPaint);
        this.mPaint.setColor(color);
        return bitmap;
    }

    public Drawable getDrawable(Resources resources, int i) {
        return new NinePatchBuilder(resources, getBitmap(i)).addXCenteredRegion(2).addYCenteredRegion(2).build();
    }

    public NinePatch getNinePatch(Resources resources, int i) {
        return new NinePatchBuilder(resources, getBitmap(i)).addXCenteredRegion(2).addYCenteredRegion(2).buildNinePatch();
    }
}
