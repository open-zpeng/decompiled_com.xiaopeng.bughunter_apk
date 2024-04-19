package defpackage;

import defpackage.e;
import java.util.HashMap;
import java.util.Map;
/* compiled from: FastSafeIterableMap.java */
/* renamed from: d  reason: default package */
/* loaded from: classes.dex */
public class d<K, V> extends e<K, V> {
    private HashMap<K, e.d<K, V>> f = new HashMap<>();

    @Override // defpackage.e
    protected e.d<K, V> c(K k) {
        return this.f.get(k);
    }

    public boolean contains(K k) {
        return this.f.containsKey(k);
    }

    @Override // defpackage.e
    public V g(K k, V v) {
        e.d<K, V> c = c(k);
        if (c != null) {
            return c.c;
        }
        this.f.put(k, f(k, v));
        return null;
    }

    @Override // defpackage.e
    public V h(K k) {
        V v = (V) super.h(k);
        this.f.remove(k);
        return v;
    }

    public Map.Entry<K, V> i(K k) {
        if (contains(k)) {
            return this.f.get(k).e;
        }
        return null;
    }
}
