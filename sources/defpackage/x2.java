package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import defpackage.m3;
import defpackage.q2;
import defpackage.t2;
/* compiled from: TypefaceCompat.java */
/* renamed from: x2  reason: default package */
/* loaded from: classes.dex */
public class x2 {
    private static final c3 a;
    private static final v3<String, Typeface> b;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            a = new b3();
        } else if (i >= 26) {
            a = new a3();
        } else if (i >= 24 && z2.j()) {
            a = new z2();
        } else if (i >= 21) {
            a = new y2();
        } else {
            a = new c3();
        }
        b = new v3<>(16);
    }

    public static Typeface a(Context context, CancellationSignal cancellationSignal, m3.f[] fVarArr, int i) {
        return a.b(context, cancellationSignal, fVarArr, i);
    }

    public static Typeface b(Context context, q2.a aVar, Resources resources, int i, int i2, t2.a aVar2, Handler handler, boolean z) {
        Typeface a2;
        if (aVar instanceof q2.d) {
            q2.d dVar = (q2.d) aVar;
            boolean z2 = false;
            if (!z ? aVar2 == null : dVar.a() == 0) {
                z2 = true;
            }
            a2 = m3.g(context, dVar.b(), aVar2, handler, z2, z ? dVar.c() : -1, i2);
        } else {
            a2 = a.a(context, (q2.b) aVar, resources, i2);
            if (aVar2 != null) {
                if (a2 != null) {
                    aVar2.b(a2, handler);
                } else {
                    aVar2.a(-3, handler);
                }
            }
        }
        if (a2 != null) {
            b.e(d(resources, i, i2), a2);
        }
        return a2;
    }

    public static Typeface c(Context context, Resources resources, int i, String str, int i2) {
        Typeface d = a.d(context, resources, i, str, i2);
        if (d != null) {
            b.e(d(resources, i, i2), d);
        }
        return d;
    }

    private static String d(Resources resources, int i, int i2) {
        return resources.getResourcePackageName(i) + "-" + i + "-" + i2;
    }

    public static Typeface e(Resources resources, int i, int i2) {
        return b.d(d(resources, i, i2));
    }
}
