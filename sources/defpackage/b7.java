package defpackage;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
/* compiled from: LinkedTreeMap.java */
/* renamed from: b7  reason: default package */
/* loaded from: classes.dex */
public final class b7<K, V> extends AbstractMap<K, V> implements Serializable {
    Comparator<? super K> d;
    e<K, V> e;
    int f;
    int g;
    final e<K, V> h;
    private b7<K, V>.b i;
    private b7<K, V>.c j;
    static final /* synthetic */ boolean c = true;
    private static final Comparator<Comparable> b = new a();

    /* compiled from: LinkedTreeMap.java */
    /* renamed from: b7$a */
    /* loaded from: classes.dex */
    static class a implements Comparator<Comparable> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    /* compiled from: LinkedTreeMap.java */
    /* renamed from: b7$b */
    /* loaded from: classes.dex */
    class b extends AbstractSet<Map.Entry<K, V>> {

        /* compiled from: LinkedTreeMap.java */
        /* renamed from: b7$b$a */
        /* loaded from: classes.dex */
        class a extends b7<K, V>.d<Map.Entry<K, V>> {
            a() {
                super(b7.this, null);
            }

            @Override // java.util.Iterator
            /* renamed from: b */
            public Map.Entry<K, V> next() {
                return a();
            }
        }

        b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            b7.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && b7.this.c((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            e<K, V> c;
            if ((obj instanceof Map.Entry) && (c = b7.this.c((Map.Entry) obj)) != null) {
                b7.this.f(c, true);
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return b7.this.f;
        }
    }

    /* compiled from: LinkedTreeMap.java */
    /* renamed from: b7$c */
    /* loaded from: classes.dex */
    class c extends AbstractSet<K> {

        /* compiled from: LinkedTreeMap.java */
        /* renamed from: b7$c$a */
        /* loaded from: classes.dex */
        class a extends b7<K, V>.d<K> {
            a() {
                super(b7.this, null);
            }

            @Override // java.util.Iterator
            public K next() {
                return a().g;
            }
        }

        c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            b7.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return b7.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return b7.this.h(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return b7.this.f;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LinkedTreeMap.java */
    /* renamed from: b7$d */
    /* loaded from: classes.dex */
    public abstract class d<T> implements Iterator<T> {
        e<K, V> b;
        e<K, V> c;
        int d;

        private d() {
            this.b = b7.this.h.e;
            this.c = null;
            this.d = b7.this.g;
        }

        /* synthetic */ d(b7 b7Var, a aVar) {
            this();
        }

        final e<K, V> a() {
            e<K, V> eVar = this.b;
            b7 b7Var = b7.this;
            if (eVar != b7Var.h) {
                if (b7Var.g == this.d) {
                    this.b = eVar.e;
                    this.c = eVar;
                    return eVar;
                }
                throw new ConcurrentModificationException();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.b != b7.this.h;
        }

        @Override // java.util.Iterator
        public final void remove() {
            e<K, V> eVar = this.c;
            if (eVar == null) {
                throw new IllegalStateException();
            }
            b7.this.f(eVar, true);
            this.c = null;
            this.d = b7.this.g;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LinkedTreeMap.java */
    /* renamed from: b7$e */
    /* loaded from: classes.dex */
    public static final class e<K, V> implements Map.Entry<K, V> {
        e<K, V> b;
        e<K, V> c;
        e<K, V> d;
        e<K, V> e;
        e<K, V> f;
        final K g;
        V h;
        int i;

        e() {
            this.g = null;
            this.f = this;
            this.e = this;
        }

        e(e<K, V> eVar, K k, e<K, V> eVar2, e<K, V> eVar3) {
            this.b = eVar;
            this.g = k;
            this.i = 1;
            this.e = eVar2;
            this.f = eVar3;
            eVar3.e = this;
            eVar2.f = this;
        }

        public e<K, V> a() {
            e<K, V> eVar = this;
            for (e<K, V> eVar2 = this.c; eVar2 != null; eVar2 = eVar2.c) {
                eVar = eVar2;
            }
            return eVar;
        }

        public e<K, V> b() {
            e<K, V> eVar = this;
            for (e<K, V> eVar2 = this.d; eVar2 != null; eVar2 = eVar2.d) {
                eVar = eVar2;
            }
            return eVar;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                K k = this.g;
                if (k == null) {
                    if (entry.getKey() != null) {
                        return false;
                    }
                } else if (!k.equals(entry.getKey())) {
                    return false;
                }
                V v = this.h;
                Object value = entry.getValue();
                if (v == null) {
                    if (value != null) {
                        return false;
                    }
                } else if (!v.equals(value)) {
                    return false;
                }
                return true;
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.g;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.h;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k = this.g;
            int hashCode = k == null ? 0 : k.hashCode();
            V v = this.h;
            return hashCode ^ (v != null ? v.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.h;
            this.h = v;
            return v2;
        }

        public String toString() {
            return this.g + "=" + this.h;
        }
    }

    public b7() {
        this(b);
    }

    public b7(Comparator<? super K> comparator) {
        this.f = 0;
        this.g = 0;
        this.h = new e<>();
        this.d = comparator == null ? b : comparator;
    }

    private void d(e<K, V> eVar) {
        e<K, V> eVar2 = eVar.c;
        e<K, V> eVar3 = eVar.d;
        e<K, V> eVar4 = eVar3.c;
        e<K, V> eVar5 = eVar3.d;
        eVar.d = eVar4;
        if (eVar4 != null) {
            eVar4.b = eVar;
        }
        e(eVar, eVar3);
        eVar3.c = eVar;
        eVar.b = eVar3;
        int max = Math.max(eVar2 != null ? eVar2.i : 0, eVar4 != null ? eVar4.i : 0) + 1;
        eVar.i = max;
        eVar3.i = Math.max(max, eVar5 != null ? eVar5.i : 0) + 1;
    }

    private void e(e<K, V> eVar, e<K, V> eVar2) {
        e<K, V> eVar3 = eVar.b;
        eVar.b = null;
        if (eVar2 != null) {
            eVar2.b = eVar3;
        }
        if (eVar3 == null) {
            this.e = eVar2;
        } else if (eVar3.c == eVar) {
            eVar3.c = eVar2;
        } else if (!c && eVar3.d != eVar) {
            throw new AssertionError();
        } else {
            eVar3.d = eVar2;
        }
    }

    private boolean g(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    private void i(e<K, V> eVar) {
        e<K, V> eVar2 = eVar.c;
        e<K, V> eVar3 = eVar.d;
        e<K, V> eVar4 = eVar2.c;
        e<K, V> eVar5 = eVar2.d;
        eVar.c = eVar5;
        if (eVar5 != null) {
            eVar5.b = eVar;
        }
        e(eVar, eVar2);
        eVar2.d = eVar;
        eVar.b = eVar2;
        int max = Math.max(eVar3 != null ? eVar3.i : 0, eVar5 != null ? eVar5.i : 0) + 1;
        eVar.i = max;
        eVar2.i = Math.max(max, eVar4 != null ? eVar4.i : 0) + 1;
    }

    private void j(e<K, V> eVar, boolean z) {
        while (eVar != null) {
            e<K, V> eVar2 = eVar.c;
            e<K, V> eVar3 = eVar.d;
            int i = eVar2 != null ? eVar2.i : 0;
            int i2 = eVar3 != null ? eVar3.i : 0;
            int i3 = i - i2;
            if (i3 == -2) {
                e<K, V> eVar4 = eVar3.c;
                e<K, V> eVar5 = eVar3.d;
                int i4 = (eVar4 != null ? eVar4.i : 0) - (eVar5 != null ? eVar5.i : 0);
                if (i4 != -1 && (i4 != 0 || z)) {
                    if (!c && i4 != 1) {
                        throw new AssertionError();
                    }
                    i(eVar3);
                }
                d(eVar);
                if (z) {
                    return;
                }
            } else if (i3 == 2) {
                e<K, V> eVar6 = eVar2.c;
                e<K, V> eVar7 = eVar2.d;
                int i5 = (eVar6 != null ? eVar6.i : 0) - (eVar7 != null ? eVar7.i : 0);
                if (i5 != 1 && (i5 != 0 || z)) {
                    if (!c && i5 != -1) {
                        throw new AssertionError();
                    }
                    d(eVar2);
                }
                i(eVar);
                if (z) {
                    return;
                }
            } else if (i3 == 0) {
                eVar.i = i + 1;
                if (z) {
                    return;
                }
            } else if (!c && i3 != -1 && i3 != 1) {
                throw new AssertionError();
            } else {
                eVar.i = Math.max(i, i2) + 1;
                if (!z) {
                    return;
                }
            }
            eVar = eVar.b;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    e<K, V> a(Object obj) {
        if (obj != 0) {
            try {
                return b(obj, false);
            } catch (ClassCastException unused) {
                return null;
            }
        }
        return null;
    }

    e<K, V> b(K k, boolean z) {
        int i;
        e<K, V> eVar;
        Comparator<? super K> comparator = this.d;
        e<K, V> eVar2 = this.e;
        if (eVar2 != null) {
            Comparable comparable = comparator == b ? (Comparable) k : null;
            while (true) {
                Object obj = (K) eVar2.g;
                i = comparable != null ? comparable.compareTo(obj) : comparator.compare(k, obj);
                if (i == 0) {
                    return eVar2;
                }
                e<K, V> eVar3 = i < 0 ? eVar2.c : eVar2.d;
                if (eVar3 == null) {
                    break;
                }
                eVar2 = eVar3;
            }
        } else {
            i = 0;
        }
        if (z) {
            e<K, V> eVar4 = this.h;
            if (eVar2 != null) {
                eVar = new e<>(eVar2, k, eVar4, eVar4.f);
                if (i < 0) {
                    eVar2.c = eVar;
                } else {
                    eVar2.d = eVar;
                }
                j(eVar2, true);
            } else if (comparator == b && !(k instanceof Comparable)) {
                throw new ClassCastException(k.getClass().getName() + " is not Comparable");
            } else {
                eVar = new e<>(eVar2, k, eVar4, eVar4.f);
                this.e = eVar;
            }
            this.f++;
            this.g++;
            return eVar;
        }
        return null;
    }

    e<K, V> c(Map.Entry<?, ?> entry) {
        e<K, V> a2 = a(entry.getKey());
        if (a2 != null && g(a2.h, entry.getValue())) {
            return a2;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.e = null;
        this.f = 0;
        this.g++;
        e<K, V> eVar = this.h;
        eVar.f = eVar;
        eVar.e = eVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return a(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        b7<K, V>.b bVar = this.i;
        if (bVar != null) {
            return bVar;
        }
        b7<K, V>.b bVar2 = new b();
        this.i = bVar2;
        return bVar2;
    }

    void f(e<K, V> eVar, boolean z) {
        int i;
        if (z) {
            e<K, V> eVar2 = eVar.f;
            eVar2.e = eVar.e;
            eVar.e.f = eVar2;
        }
        e<K, V> eVar3 = eVar.c;
        e<K, V> eVar4 = eVar.d;
        e<K, V> eVar5 = eVar.b;
        int i2 = 0;
        if (eVar3 == null || eVar4 == null) {
            if (eVar3 != null) {
                e(eVar, eVar3);
                eVar.c = null;
            } else if (eVar4 != null) {
                e(eVar, eVar4);
                eVar.d = null;
            } else {
                e(eVar, null);
            }
            j(eVar5, false);
            this.f--;
            this.g++;
            return;
        }
        e<K, V> b2 = eVar3.i > eVar4.i ? eVar3.b() : eVar4.a();
        f(b2, false);
        e<K, V> eVar6 = eVar.c;
        if (eVar6 != null) {
            i = eVar6.i;
            b2.c = eVar6;
            eVar6.b = b2;
            eVar.c = null;
        } else {
            i = 0;
        }
        e<K, V> eVar7 = eVar.d;
        if (eVar7 != null) {
            i2 = eVar7.i;
            b2.d = eVar7;
            eVar7.b = b2;
            eVar.d = null;
        }
        b2.i = Math.max(i, i2) + 1;
        e(eVar, b2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        e<K, V> a2 = a(obj);
        if (a2 != null) {
            return a2.h;
        }
        return null;
    }

    e<K, V> h(Object obj) {
        e<K, V> a2 = a(obj);
        if (a2 != null) {
            f(a2, true);
        }
        return a2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        b7<K, V>.c cVar = this.j;
        if (cVar != null) {
            return cVar;
        }
        b7<K, V>.c cVar2 = new c();
        this.j = cVar2;
        return cVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        Objects.requireNonNull(k, "key == null");
        e<K, V> b2 = b(k, true);
        V v2 = b2.h;
        b2.h = v;
        return v2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        e<K, V> h = h(obj);
        if (h != null) {
            return h.h;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f;
    }
}
