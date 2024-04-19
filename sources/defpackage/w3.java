package defpackage;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MapCollections.java */
/* renamed from: w3  reason: default package */
/* loaded from: classes.dex */
public abstract class w3<K, V> {
    w3<K, V>.b a;
    w3<K, V>.c b;
    w3<K, V>.e c;

    /* compiled from: MapCollections.java */
    /* renamed from: w3$a */
    /* loaded from: classes.dex */
    final class a<T> implements Iterator<T> {
        final int b;
        int c;
        int d;
        boolean e = false;

        a(int i) {
            this.b = i;
            this.c = w3.this.d();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.d < this.c;
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                T t = (T) w3.this.b(this.d, this.b);
                this.d++;
                this.e = true;
                return t;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.e) {
                int i = this.d - 1;
                this.d = i;
                this.c--;
                this.e = false;
                w3.this.h(i);
                return;
            }
            throw new IllegalStateException();
        }
    }

    /* compiled from: MapCollections.java */
    /* renamed from: w3$b */
    /* loaded from: classes.dex */
    final class b implements Set<Map.Entry<K, V>> {
        b() {
        }

        @Override // java.util.Set, java.util.Collection
        /* renamed from: a */
        public boolean add(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            int d = w3.this.d();
            for (Map.Entry<K, V> entry : collection) {
                w3.this.g(entry.getKey(), entry.getValue());
            }
            return d != w3.this.d();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            w3.this.a();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                int e = w3.this.e(entry.getKey());
                if (e < 0) {
                    return false;
                }
                return r3.c(w3.this.b(e, 1), entry.getValue());
            }
            return false;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return w3.k(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int i = 0;
            for (int d = w3.this.d() - 1; d >= 0; d--) {
                Object b = w3.this.b(d, 0);
                Object b2 = w3.this.b(d, 1);
                i += (b == null ? 0 : b.hashCode()) ^ (b2 == null ? 0 : b2.hashCode());
            }
            return i;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return w3.this.d() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return new d();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return w3.this.d();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }
    }

    /* compiled from: MapCollections.java */
    /* renamed from: w3$c */
    /* loaded from: classes.dex */
    final class c implements Set<K> {
        c() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            w3.this.a();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            return w3.this.e(obj) >= 0;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return w3.j(w3.this.c(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return w3.k(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int i = 0;
            for (int d = w3.this.d() - 1; d >= 0; d--) {
                Object b = w3.this.b(d, 0);
                i += b == null ? 0 : b.hashCode();
            }
            return i;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return w3.this.d() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return new a(0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            int e = w3.this.e(obj);
            if (e >= 0) {
                w3.this.h(e);
                return true;
            }
            return false;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            return w3.o(w3.this.c(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            return w3.p(w3.this.c(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return w3.this.d();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            return w3.this.q(0);
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) w3.this.r(tArr, 0);
        }
    }

    /* compiled from: MapCollections.java */
    /* renamed from: w3$d */
    /* loaded from: classes.dex */
    final class d implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {
        int b;
        boolean d = false;
        int c = -1;

        d() {
            this.b = w3.this.d() - 1;
        }

        @Override // java.util.Iterator
        /* renamed from: a */
        public Map.Entry<K, V> next() {
            if (hasNext()) {
                this.c++;
                this.d = true;
                return this;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (this.d) {
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    return r3.c(entry.getKey(), w3.this.b(this.c, 0)) && r3.c(entry.getValue(), w3.this.b(this.c, 1));
                }
                return false;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            if (this.d) {
                return (K) w3.this.b(this.c, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            if (this.d) {
                return (V) w3.this.b(this.c, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.c < this.b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            if (this.d) {
                Object b = w3.this.b(this.c, 0);
                Object b2 = w3.this.b(this.c, 1);
                return (b == null ? 0 : b.hashCode()) ^ (b2 != null ? b2.hashCode() : 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.d) {
                w3.this.h(this.c);
                this.c--;
                this.b--;
                this.d = false;
                return;
            }
            throw new IllegalStateException();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            if (this.d) {
                return (V) w3.this.i(this.c, v);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    /* compiled from: MapCollections.java */
    /* renamed from: w3$e */
    /* loaded from: classes.dex */
    final class e implements Collection<V> {
        e() {
        }

        @Override // java.util.Collection
        public boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public void clear() {
            w3.this.a();
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            return w3.this.f(obj) >= 0;
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return w3.this.d() == 0;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new a(1);
        }

        @Override // java.util.Collection
        public boolean remove(Object obj) {
            int f = w3.this.f(obj);
            if (f >= 0) {
                w3.this.h(f);
                return true;
            }
            return false;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            int d = w3.this.d();
            int i = 0;
            boolean z = false;
            while (i < d) {
                if (collection.contains(w3.this.b(i, 1))) {
                    w3.this.h(i);
                    i--;
                    d--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            int d = w3.this.d();
            int i = 0;
            boolean z = false;
            while (i < d) {
                if (!collection.contains(w3.this.b(i, 1))) {
                    w3.this.h(i);
                    i--;
                    d--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        @Override // java.util.Collection
        public int size() {
            return w3.this.d();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            return w3.this.q(1);
        }

        @Override // java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) w3.this.r(tArr, 1);
        }
    }

    public static <K, V> boolean j(Map<K, V> map, Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean k(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
                return false;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static <K, V> boolean o(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return size != map.size();
    }

    public static <K, V> boolean p(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    protected abstract void a();

    protected abstract Object b(int i, int i2);

    protected abstract Map<K, V> c();

    protected abstract int d();

    protected abstract int e(Object obj);

    protected abstract int f(Object obj);

    protected abstract void g(K k, V v);

    protected abstract void h(int i);

    protected abstract V i(int i, V v);

    public Set<Map.Entry<K, V>> l() {
        if (this.a == null) {
            this.a = new b();
        }
        return this.a;
    }

    public Set<K> m() {
        if (this.b == null) {
            this.b = new c();
        }
        return this.b;
    }

    public Collection<V> n() {
        if (this.c == null) {
            this.c = new e();
        }
        return this.c;
    }

    public Object[] q(int i) {
        int d2 = d();
        Object[] objArr = new Object[d2];
        for (int i2 = 0; i2 < d2; i2++) {
            objArr[i2] = b(i2, i);
        }
        return objArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T[] r(T[] tArr, int i) {
        int d2 = d();
        if (tArr.length < d2) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), d2));
        }
        for (int i2 = 0; i2 < d2; i2++) {
            tArr[i2] = b(i2, i);
        }
        if (tArr.length > d2) {
            tArr[d2] = null;
        }
        return tArr;
    }
}
