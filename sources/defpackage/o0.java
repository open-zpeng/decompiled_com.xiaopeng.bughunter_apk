package defpackage;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.util.StateSet;
/* compiled from: RippleUtils.java */
/* renamed from: o0  reason: default package */
/* loaded from: classes.dex */
public class o0 {
    public static final boolean a;
    private static final int[] b;
    private static final int[] c;
    private static final int[] d;
    private static final int[] e;
    private static final int[] f;
    private static final int[] g;
    private static final int[] h;
    private static final int[] i;
    private static final int[] j;

    static {
        a = Build.VERSION.SDK_INT >= 21;
        b = new int[]{16842919};
        c = new int[]{16843623, 16842908};
        d = new int[]{16842908};
        e = new int[]{16843623};
        f = new int[]{16842913, 16842919};
        g = new int[]{16842913, 16843623, 16842908};
        h = new int[]{16842913, 16842908};
        i = new int[]{16842913, 16843623};
        j = new int[]{16842913};
    }

    public static ColorStateList a(ColorStateList colorStateList) {
        if (a) {
            return new ColorStateList(new int[][]{j, StateSet.NOTHING}, new int[]{c(colorStateList, f), c(colorStateList, b)});
        }
        int[] iArr = f;
        int[] iArr2 = g;
        int[] iArr3 = h;
        int[] iArr4 = i;
        int[] iArr5 = b;
        int[] iArr6 = c;
        int[] iArr7 = d;
        int[] iArr8 = e;
        return new ColorStateList(new int[][]{iArr, iArr2, iArr3, iArr4, j, iArr5, iArr6, iArr7, iArr8, StateSet.NOTHING}, new int[]{c(colorStateList, iArr), c(colorStateList, iArr2), c(colorStateList, iArr3), c(colorStateList, iArr4), 0, c(colorStateList, iArr5), c(colorStateList, iArr6), c(colorStateList, iArr7), c(colorStateList, iArr8), 0});
    }

    @TargetApi(21)
    private static int b(int i2) {
        return v2.d(i2, Math.min(Color.alpha(i2) * 2, 255));
    }

    private static int c(ColorStateList colorStateList, int[] iArr) {
        int colorForState = colorStateList != null ? colorStateList.getColorForState(iArr, colorStateList.getDefaultColor()) : 0;
        return a ? b(colorForState) : colorForState;
    }
}
