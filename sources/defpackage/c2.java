package defpackage;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.util.Property;
import android.view.View;
import java.lang.reflect.Field;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ViewUtils.java */
/* renamed from: c2  reason: default package */
/* loaded from: classes.dex */
public class c2 {
    private static final g2 a;
    private static Field b;
    private static boolean c;
    static final Property<View, Float> d;
    static final Property<View, Rect> e;

    /* compiled from: ViewUtils.java */
    /* renamed from: c2$a */
    /* loaded from: classes.dex */
    static class a extends Property<View, Float> {
        a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Float get(View view) {
            return Float.valueOf(c2.d(view));
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(View view, Float f) {
            c2.h(view, f.floatValue());
        }
    }

    /* compiled from: ViewUtils.java */
    /* renamed from: c2$b */
    /* loaded from: classes.dex */
    static class b extends Property<View, Rect> {
        b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Rect get(View view) {
            return v4.g(view);
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(View view, Rect rect) {
            v4.M(view, rect);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 22) {
            a = new f2();
        } else if (i >= 21) {
            a = new e2();
        } else if (i >= 19) {
            a = new d2();
        } else {
            a = new g2();
        }
        d = new a(Float.class, "translationAlpha");
        e = new b(Rect.class, "clipBounds");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(View view) {
        a.a(view);
    }

    private static void b() {
        if (c) {
            return;
        }
        try {
            Field declaredField = View.class.getDeclaredField("mViewFlags");
            b = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException unused) {
            Log.i("ViewUtils", "fetchViewFlagsField: ");
        }
        c = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b2 c(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new a2(view);
        }
        return z1.e(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float d(View view) {
        return a.b(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static k2 e(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new j2(view);
        }
        return new i2(view.getWindowToken());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void f(View view) {
        a.c(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void g(View view, int i, int i2, int i3, int i4) {
        a.d(view, i, i2, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void h(View view, float f) {
        a.e(view, f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void i(View view, int i) {
        b();
        Field field = b;
        if (field != null) {
            try {
                b.setInt(view, i | (field.getInt(view) & (-13)));
            } catch (IllegalAccessException unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void j(View view, Matrix matrix) {
        a.f(view, matrix);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void k(View view, Matrix matrix) {
        a.g(view, matrix);
    }
}
