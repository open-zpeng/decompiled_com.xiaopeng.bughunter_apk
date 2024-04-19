package defpackage;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.view.ViewConfiguration;
/* compiled from: ActionBarPolicy.java */
/* renamed from: b6  reason: default package */
/* loaded from: classes.dex */
public class b6 {
    private Context a;

    private b6(Context context) {
        this.a = context;
    }

    public static b6 a(Context context) {
        return new b6(context);
    }

    public int b() {
        return this.a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public int c() {
        Configuration configuration = this.a.getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        int i2 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i > 600) {
            return 5;
        }
        if (i <= 960 || i2 <= 720) {
            if (i <= 720 || i2 <= 960) {
                if (i < 500) {
                    if (i <= 640 || i2 <= 480) {
                        if (i <= 480 || i2 <= 640) {
                            return i >= 360 ? 3 : 2;
                        }
                        return 4;
                    }
                    return 4;
                }
                return 4;
            }
            return 5;
        }
        return 5;
    }

    public int d() {
        return this.a.getResources().getDimensionPixelSize(n5.b);
    }

    public int e() {
        TypedArray obtainStyledAttributes = this.a.obtainStyledAttributes(null, t5.a, k5.c, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(t5.i, 0);
        Resources resources = this.a.getResources();
        if (!f()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(n5.a));
        }
        obtainStyledAttributes.recycle();
        return layoutDimension;
    }

    public boolean f() {
        return this.a.getResources().getBoolean(l5.a);
    }

    public boolean g() {
        if (Build.VERSION.SDK_INT >= 19) {
            return true;
        }
        return !ViewConfiguration.get(this.a).hasPermanentMenuKey();
    }
}
