package defpackage;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
/* compiled from: CollectionTypeAdapterFactory.java */
/* renamed from: k6  reason: default package */
/* loaded from: classes.dex */
public final class k6 implements c8 {
    private final y6 b;

    /* compiled from: CollectionTypeAdapterFactory.java */
    /* renamed from: k6$a */
    /* loaded from: classes.dex */
    private static final class a<E> extends b8<Collection<E>> {
        private final b8<E> a;
        private final c7<? extends Collection<E>> b;

        public a(p7 p7Var, Type type, b8<E> b8Var, c7<? extends Collection<E>> c7Var) {
            this.a = new t6(p7Var, b8Var, type);
            this.b = c7Var;
        }

        @Override // defpackage.b8
        /* renamed from: d */
        public Collection<E> c(i7 i7Var) throws IOException {
            if (i7Var.t() == j7.NULL) {
                i7Var.w();
                return null;
            }
            Collection<E> O000000o = this.b.O000000o();
            i7Var.c();
            while (i7Var.s()) {
                O000000o.add(this.a.c(i7Var));
            }
            i7Var.l();
            return O000000o;
        }

        @Override // defpackage.b8
        /* renamed from: e */
        public void a(k7 k7Var, Collection<E> collection) throws IOException {
            if (collection == null) {
                k7Var.u();
                return;
            }
            k7Var.i();
            for (E e : collection) {
                this.a.a(k7Var, e);
            }
            k7Var.p();
        }
    }

    public k6(y6 y6Var) {
        this.b = y6Var;
    }

    @Override // defpackage.c8
    public <T> b8<T> a(p7 p7Var, m7<T> m7Var) {
        Type d = m7Var.d();
        Class<? super T> a2 = m7Var.a();
        if (Collection.class.isAssignableFrom(a2)) {
            Type f = w6.f(d, a2);
            return new a(p7Var, f, p7Var.b(m7.c(f)), this.b.a(m7Var));
        }
        return null;
    }
}
