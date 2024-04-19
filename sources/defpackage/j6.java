package defpackage;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;
/* compiled from: ArrayTypeAdapter.java */
/* renamed from: j6  reason: default package */
/* loaded from: classes.dex */
public final class j6<E> extends b8<Object> {
    public static final c8 a = new a();
    private final Class<E> b;
    private final b8<E> c;

    /* compiled from: ArrayTypeAdapter.java */
    /* renamed from: j6$a */
    /* loaded from: classes.dex */
    static class a implements c8 {
        a() {
        }

        @Override // defpackage.c8
        public <T> b8<T> a(p7 p7Var, m7<T> m7Var) {
            Type d = m7Var.d();
            if ((d instanceof GenericArrayType) || ((d instanceof Class) && ((Class) d).isArray())) {
                Type t = w6.t(d);
                return new j6(p7Var, p7Var.b(m7.c(t)), w6.r(t));
            }
            return null;
        }
    }

    public j6(p7 p7Var, b8<E> b8Var, Class<E> cls) {
        this.c = new t6(p7Var, b8Var, cls);
        this.b = cls;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.b8
    public void a(k7 k7Var, Object obj) throws IOException {
        if (obj == null) {
            k7Var.u();
            return;
        }
        k7Var.i();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.c.a(k7Var, Array.get(obj, i));
        }
        k7Var.p();
    }

    @Override // defpackage.b8
    public Object c(i7 i7Var) throws IOException {
        if (i7Var.t() == j7.NULL) {
            i7Var.w();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        i7Var.c();
        while (i7Var.s()) {
            arrayList.add(this.c.c(i7Var));
        }
        i7Var.l();
        Object newInstance = Array.newInstance((Class<?>) this.b, arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            Array.set(newInstance, i, arrayList.get(i));
        }
        return newInstance;
    }
}
