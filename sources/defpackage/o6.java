package defpackage;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;
/* compiled from: MapTypeAdapterFactory.java */
/* renamed from: o6  reason: default package */
/* loaded from: classes.dex */
public final class o6 implements c8 {
    private final y6 b;
    private final boolean c;

    /* compiled from: MapTypeAdapterFactory.java */
    /* renamed from: o6$a */
    /* loaded from: classes.dex */
    private final class a<K, V> extends b8<Map<K, V>> {
        private final b8<K> a;
        private final b8<V> b;
        private final c7<? extends Map<K, V>> c;

        public a(p7 p7Var, Type type, b8<K> b8Var, Type type2, b8<V> b8Var2, c7<? extends Map<K, V>> c7Var) {
            this.a = new t6(p7Var, b8Var, type);
            this.b = new t6(p7Var, b8Var2, type2);
            this.c = c7Var;
        }

        private String f(d8 d8Var) {
            if (!d8Var.d()) {
                if (d8Var.c()) {
                    return "null";
                }
                throw new AssertionError();
            }
            x7 g = d8Var.g();
            if (g.s()) {
                return String.valueOf(g.m());
            }
            if (g.j()) {
                return Boolean.toString(g.q());
            }
            if (g.t()) {
                return g.l();
            }
            throw new AssertionError();
        }

        @Override // defpackage.b8
        /* renamed from: d */
        public Map<K, V> c(i7 i7Var) throws IOException {
            j7 t = i7Var.t();
            if (t == j7.NULL) {
                i7Var.w();
                return null;
            }
            Map<K, V> O000000o = this.c.O000000o();
            if (t == j7.BEGIN_ARRAY) {
                i7Var.c();
                while (i7Var.s()) {
                    i7Var.c();
                    K c = this.a.c(i7Var);
                    if (O000000o.put(c, this.b.c(i7Var)) != null) {
                        throw new z7("duplicate key: " + c);
                    }
                    i7Var.l();
                }
                i7Var.l();
            } else {
                i7Var.q();
                while (i7Var.s()) {
                    z6.a.a(i7Var);
                    K c2 = this.a.c(i7Var);
                    if (O000000o.put(c2, this.b.c(i7Var)) != null) {
                        throw new z7("duplicate key: " + c2);
                    }
                }
                i7Var.o();
            }
            return O000000o;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // defpackage.b8
        /* renamed from: e */
        public void a(k7 k7Var, Map<K, V> map) throws IOException {
            if (map == null) {
                k7Var.u();
            } else if (!o6.this.c) {
                k7Var.m();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    k7Var.f(String.valueOf(entry.getKey()));
                    this.b.a(k7Var, entry.getValue());
                }
                k7Var.s();
            } else {
                ArrayList arrayList = new ArrayList(map.size());
                ArrayList arrayList2 = new ArrayList(map.size());
                int i = 0;
                boolean z = false;
                for (Map.Entry<K, V> entry2 : map.entrySet()) {
                    d8 b = this.a.b(entry2.getKey());
                    arrayList.add(b);
                    arrayList2.add(entry2.getValue());
                    z |= b.b() || b.a();
                }
                if (!z) {
                    k7Var.m();
                    while (i < arrayList.size()) {
                        k7Var.f(f((d8) arrayList.get(i)));
                        this.b.a(k7Var, arrayList2.get(i));
                        i++;
                    }
                    k7Var.s();
                    return;
                }
                k7Var.i();
                while (i < arrayList.size()) {
                    k7Var.i();
                    e7.b((d8) arrayList.get(i), k7Var);
                    this.b.a(k7Var, arrayList2.get(i));
                    k7Var.p();
                    i++;
                }
                k7Var.p();
            }
        }
    }

    public o6(y6 y6Var, boolean z) {
        this.b = y6Var;
        this.c = z;
    }

    private b8<?> b(p7 p7Var, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? u6.f : p7Var.b(m7.c(type));
    }

    @Override // defpackage.c8
    public <T> b8<T> a(p7 p7Var, m7<T> m7Var) {
        Type d = m7Var.d();
        if (Map.class.isAssignableFrom(m7Var.a())) {
            Type[] o = w6.o(d, w6.r(d));
            return new a(p7Var, o[0], b(p7Var, o[0]), o[1], p7Var.b(m7.c(o[1])), this.b.a(m7Var));
        }
        return null;
    }
}
