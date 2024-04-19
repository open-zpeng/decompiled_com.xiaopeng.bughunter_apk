package defpackage;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
/* compiled from: ArrayMap.java */
/* renamed from: p3  reason: default package */
/* loaded from: classes.dex */
public class p3<K, V> extends c4<K, V> implements Map<K, V> {
    w3<K, V> i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ArrayMap.java */
    /* renamed from: p3$a */
    /* loaded from: classes.dex */
    public class a extends w3<K, V> {
        a() {
        }

        @Override // defpackage.w3
        protected void a() {
            p3.this.clear();
        }

        @Override // defpackage.w3
        protected Object b(int i, int i2) {
            return p3.this.g[(i << 1) + i2];
        }

        @Override // defpackage.w3
        protected Map<K, V> c() {
            return p3.this;
        }

        @Override // defpackage.w3
        protected int d() {
            return p3.this.h;
        }

        @Override // defpackage.w3
        protected int e(Object obj) {
            return p3.this.f(obj);
        }

        @Override // defpackage.w3
        protected int f(Object obj) {
            return p3.this.h(obj);
        }

        @Override // defpackage.w3
        protected void g(K k, V v) {
            p3.this.put(k, v);
        }

        @Override // defpackage.w3
        protected void h(int i) {
            p3.this.k(i);
        }

        @Override // defpackage.w3
        protected V i(int i, V v) {
            return p3.this.l(i, v);
        }
    }

    public p3() {
    }

    private w3<K, V> n() {
        if (this.i == null) {
            this.i = new a();
        }
        return this.i;
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return n().l();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return n().m();
    }

    public boolean o(Collection<?> collection) {
        return w3.p(this, collection);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        c(this.h + map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return n().n();
    }

    public p3(int i) {
        super(i);
    }

    public p3(c4 c4Var) {
        super(c4Var);
    }
}
