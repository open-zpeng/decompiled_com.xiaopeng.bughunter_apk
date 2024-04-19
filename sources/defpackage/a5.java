package defpackage;

import android.os.Build;
import android.view.WindowInsets;
/* compiled from: WindowInsetsCompat.java */
/* renamed from: a5  reason: default package */
/* loaded from: classes.dex */
public class a5 {
    private final Object a;

    private a5(Object obj) {
        this.a = obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object f(a5 a5Var) {
        if (a5Var == null) {
            return null;
        }
        return a5Var.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a5 g(Object obj) {
        if (obj == null) {
            return null;
        }
        return new a5(obj);
    }

    public int a() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.a).getSystemWindowInsetBottom();
        }
        return 0;
    }

    public int b() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.a).getSystemWindowInsetLeft();
        }
        return 0;
    }

    public int c() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.a).getSystemWindowInsetRight();
        }
        return 0;
    }

    public int d() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.a).getSystemWindowInsetTop();
        }
        return 0;
    }

    public boolean e() {
        if (Build.VERSION.SDK_INT >= 21) {
            return ((WindowInsets) this.a).isConsumed();
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a5.class != obj.getClass()) {
            return false;
        }
        Object obj2 = this.a;
        Object obj3 = ((a5) obj).a;
        return obj2 == null ? obj3 == null : obj2.equals(obj3);
    }

    public int hashCode() {
        Object obj = this.a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }
}
