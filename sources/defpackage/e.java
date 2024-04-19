package defpackage;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
/* compiled from: SafeIterableMap.java */
/* renamed from: e  reason: default package */
/* loaded from: classes.dex */
public class e<K, V> implements Iterable<Map.Entry<K, V>> {
    private d<K, V> b;
    private d<K, V> c;
    private WeakHashMap<g<K, V>, Boolean> d = new WeakHashMap<>();
    private int e = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SafeIterableMap.java */
    /* renamed from: e$b */
    /* loaded from: classes.dex */
    public static class b<K, V> extends f<K, V> {
        b(d<K, V> dVar, d<K, V> dVar2) {
            super(dVar, dVar2);
        }

        @Override // defpackage.e.f
        d<K, V> b(d<K, V> dVar) {
            return dVar.e;
        }

        @Override // defpackage.e.f
        d<K, V> c(d<K, V> dVar) {
            return dVar.d;
        }
    }

    /* compiled from: SafeIterableMap.java */
    /* renamed from: e$c */
    /* loaded from: classes.dex */
    private static class c<K, V> extends f<K, V> {
        c(d<K, V> dVar, d<K, V> dVar2) {
            super(dVar, dVar2);
        }

        @Override // defpackage.e.f
        d<K, V> b(d<K, V> dVar) {
            return dVar.d;
        }

        @Override // defpackage.e.f
        d<K, V> c(d<K, V> dVar) {
            return dVar.e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SafeIterableMap.java */
    /* renamed from: e$d */
    /* loaded from: classes.dex */
    public static class d<K, V> implements Map.Entry<K, V> {
        final K b;
        final V c;
        d<K, V> d;
        d<K, V> e;

        d(K k, V v) {
            this.b = k;
            this.c = v;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof d) {
                d dVar = (d) obj;
                return this.b.equals(dVar.b) && this.c.equals(dVar.c);
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.b;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.c;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.b + "=" + this.c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SafeIterableMap.java */
    /* renamed from: e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0039e implements Iterator<Map.Entry<K, V>>, g<K, V> {
        private d<K, V> b;
        private boolean c;

        private C0039e() {
            this.c = true;
        }

        @Override // defpackage.e.g
        public void a(d<K, V> dVar) {
            d<K, V> dVar2 = this.b;
            if (dVar == dVar2) {
                d<K, V> dVar3 = dVar2.e;
                this.b = dVar3;
                this.c = dVar3 == null;
            }
        }

        @Override // java.util.Iterator
        /* renamed from: b */
        public Map.Entry<K, V> next() {
            if (this.c) {
                this.c = false;
                this.b = e.this.b;
            } else {
                d<K, V> dVar = this.b;
                this.b = dVar != null ? dVar.d : null;
            }
            return this.b;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.c) {
                return e.this.b != null;
            }
            d<K, V> dVar = this.b;
            return (dVar == null || dVar.d == null) ? false : true;
        }
    }

    /* compiled from: SafeIterableMap.java */
    /* renamed from: e$f */
    /* loaded from: classes.dex */
    private static abstract class f<K, V> implements Iterator<Map.Entry<K, V>>, g<K, V> {
        d<K, V> b;
        d<K, V> c;

        f(d<K, V> dVar, d<K, V> dVar2) {
            this.b = dVar2;
            this.c = dVar;
        }

        private d<K, V> e() {
            d<K, V> dVar = this.c;
            d<K, V> dVar2 = this.b;
            if (dVar == dVar2 || dVar2 == null) {
                return null;
            }
            return c(dVar);
        }

        @Override // defpackage.e.g
        public void a(d<K, V> dVar) {
            if (this.b == dVar && dVar == this.c) {
                this.c = null;
                this.b = null;
            }
            d<K, V> dVar2 = this.b;
            if (dVar2 == dVar) {
                this.b = b(dVar2);
            }
            if (this.c == dVar) {
                this.c = e();
            }
        }

        abstract d<K, V> b(d<K, V> dVar);

        abstract d<K, V> c(d<K, V> dVar);

        @Override // java.util.Iterator
        /* renamed from: d */
        public Map.Entry<K, V> next() {
            d<K, V> dVar = this.c;
            this.c = e();
            return dVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.c != null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SafeIterableMap.java */
    /* renamed from: e$g */
    /* loaded from: classes.dex */
    public interface g<K, V> {
        void a(d<K, V> dVar);
    }

    public Map.Entry<K, V> b() {
        return this.b;
    }

    protected d<K, V> c(K k) {
        d<K, V> dVar = this.b;
        while (dVar != null && !dVar.b.equals(k)) {
            dVar = dVar.d;
        }
        return dVar;
    }

    public e<K, V>.C0039e d() {
        e<K, V>.C0039e c0039e = new C0039e();
        this.d.put(c0039e, Boolean.FALSE);
        return c0039e;
    }

    public Iterator<Map.Entry<K, V>> descendingIterator() {
        c cVar = new c(this.c, this.b);
        this.d.put(cVar, Boolean.FALSE);
        return cVar;
    }

    public Map.Entry<K, V> e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (size() != eVar.size()) {
                return false;
            }
            Iterator<Map.Entry<K, V>> it = iterator();
            Iterator<Map.Entry<K, V>> it2 = eVar.iterator();
            while (it.hasNext() && it2.hasNext()) {
                Map.Entry<K, V> next = it.next();
                Map.Entry<K, V> next2 = it2.next();
                if ((next == null && next2 != null) || (next != null && !next.equals(next2))) {
                    return false;
                }
            }
            return (it.hasNext() || it2.hasNext()) ? false : true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public d<K, V> f(K k, V v) {
        d<K, V> dVar = new d<>(k, v);
        this.e++;
        d<K, V> dVar2 = this.c;
        if (dVar2 == null) {
            this.b = dVar;
            this.c = dVar;
            return dVar;
        }
        dVar2.d = dVar;
        dVar.e = dVar2;
        this.c = dVar;
        return dVar;
    }

    public V g(K k, V v) {
        d<K, V> c2 = c(k);
        if (c2 != null) {
            return c2.c;
        }
        f(k, v);
        return null;
    }

    public V h(K k) {
        d<K, V> c2 = c(k);
        if (c2 == null) {
            return null;
        }
        this.e--;
        if (!this.d.isEmpty()) {
            for (g<K, V> gVar : this.d.keySet()) {
                gVar.a(c2);
            }
        }
        d<K, V> dVar = c2.e;
        if (dVar != null) {
            dVar.d = c2.d;
        } else {
            this.b = c2.d;
        }
        d<K, V> dVar2 = c2.d;
        if (dVar2 != null) {
            dVar2.e = dVar;
        } else {
            this.c = dVar;
        }
        c2.d = null;
        c2.e = null;
        return c2.c;
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        b bVar = new b(this.b, this.c);
        this.d.put(bVar, Boolean.FALSE);
        return bVar;
    }

    public int size() {
        return this.e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
