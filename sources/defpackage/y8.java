package defpackage;

import java.util.HashMap;
import java.util.Map;
/* compiled from: BalancedPool.java */
/* renamed from: y8  reason: default package */
/* loaded from: classes.dex */
public class y8 {
    private static y8 a = new y8();
    private Map<Class<? extends z8>, a9<? extends z8>> b = new HashMap();

    private y8() {
    }

    public static y8 a() {
        return a;
    }

    private synchronized <T extends z8> a9<T> c(Class<T> cls) {
        a9<T> a9Var;
        a9Var = (a9<T>) this.b.get(cls);
        if (a9Var == null) {
            a9Var = new a9<>();
            this.b.put(cls, a9Var);
        }
        return a9Var;
    }

    public <T extends z8> T b(Class<T> cls, Object... objArr) {
        T a2 = c(cls).a();
        if (a2 == null) {
            try {
                a2 = cls.newInstance();
            } catch (Exception e) {
                w8.d(e);
            }
        }
        if (a2 != null) {
            a2.b(objArr);
        }
        return a2;
    }

    public <T extends z8> void d(T t) {
        if (t == null || (t instanceof c9) || (t instanceof b9)) {
            return;
        }
        c(t.getClass()).b(t);
    }
}
