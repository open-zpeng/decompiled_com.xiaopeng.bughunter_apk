package defpackage;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* compiled from: ArraySet.java */
/* renamed from: q3  reason: default package */
/* loaded from: classes.dex */
public final class q3<E> implements Collection<E>, Set<E> {
    private static final int[] b = new int[0];
    private static final Object[] c = new Object[0];
    private static Object[] d;
    private static int e;
    private static Object[] f;
    private static int g;
    private int[] h;
    Object[] i;
    int j;
    private w3<E, E> k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ArraySet.java */
    /* renamed from: q3$a */
    /* loaded from: classes.dex */
    public class a extends w3<E, E> {
        a() {
        }

        @Override // defpackage.w3
        protected void a() {
            q3.this.clear();
        }

        @Override // defpackage.w3
        protected Object b(int i, int i2) {
            return q3.this.i[i];
        }

        @Override // defpackage.w3
        protected Map<E, E> c() {
            throw new UnsupportedOperationException("not a map");
        }

        @Override // defpackage.w3
        protected int d() {
            return q3.this.j;
        }

        @Override // defpackage.w3
        protected int e(Object obj) {
            return q3.this.indexOf(obj);
        }

        @Override // defpackage.w3
        protected int f(Object obj) {
            return q3.this.indexOf(obj);
        }

        @Override // defpackage.w3
        protected void g(E e, E e2) {
            q3.this.add(e);
        }

        @Override // defpackage.w3
        protected void h(int i) {
            q3.this.g(i);
        }

        @Override // defpackage.w3
        protected E i(int i, E e) {
            throw new UnsupportedOperationException("not a map");
        }
    }

    public q3() {
        this(0);
    }

    private void a(int i) {
        if (i == 8) {
            synchronized (q3.class) {
                Object[] objArr = f;
                if (objArr != null) {
                    this.i = objArr;
                    f = (Object[]) objArr[0];
                    this.h = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    g--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (q3.class) {
                Object[] objArr2 = d;
                if (objArr2 != null) {
                    this.i = objArr2;
                    d = (Object[]) objArr2[0];
                    this.h = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    e--;
                    return;
                }
            }
        }
        this.h = new int[i];
        this.i = new Object[i];
    }

    private static void c(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (q3.class) {
                if (g < 10) {
                    objArr[0] = f;
                    objArr[1] = iArr;
                    for (int i2 = i - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f = objArr;
                    g++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (q3.class) {
                if (e < 10) {
                    objArr[0] = d;
                    objArr[1] = iArr;
                    for (int i3 = i - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    d = objArr;
                    e++;
                }
            }
        }
    }

    private w3<E, E> d() {
        if (this.k == null) {
            this.k = new a();
        }
        return this.k;
    }

    private int e(Object obj, int i) {
        int i2 = this.j;
        if (i2 == 0) {
            return -1;
        }
        int a2 = r3.a(this.h, i2, i);
        if (a2 >= 0 && !obj.equals(this.i[a2])) {
            int i3 = a2 + 1;
            while (i3 < i2 && this.h[i3] == i) {
                if (obj.equals(this.i[i3])) {
                    return i3;
                }
                i3++;
            }
            for (int i4 = a2 - 1; i4 >= 0 && this.h[i4] == i; i4--) {
                if (obj.equals(this.i[i4])) {
                    return i4;
                }
            }
            return ~i3;
        }
        return a2;
    }

    private int f() {
        int i = this.j;
        if (i == 0) {
            return -1;
        }
        int a2 = r3.a(this.h, i, 0);
        if (a2 >= 0 && this.i[a2] != null) {
            int i2 = a2 + 1;
            while (i2 < i && this.h[i2] == 0) {
                if (this.i[i2] == null) {
                    return i2;
                }
                i2++;
            }
            for (int i3 = a2 - 1; i3 >= 0 && this.h[i3] == 0; i3--) {
                if (this.i[i3] == null) {
                    return i3;
                }
            }
            return ~i2;
        }
        return a2;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e2) {
        int i;
        int e3;
        if (e2 == null) {
            e3 = f();
            i = 0;
        } else {
            int hashCode = e2.hashCode();
            i = hashCode;
            e3 = e(e2, hashCode);
        }
        if (e3 >= 0) {
            return false;
        }
        int i2 = ~e3;
        int i3 = this.j;
        int[] iArr = this.h;
        if (i3 >= iArr.length) {
            int i4 = 4;
            if (i3 >= 8) {
                i4 = (i3 >> 1) + i3;
            } else if (i3 >= 4) {
                i4 = 8;
            }
            Object[] objArr = this.i;
            a(i4);
            int[] iArr2 = this.h;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.i, 0, objArr.length);
            }
            c(iArr, objArr, this.j);
        }
        int i5 = this.j;
        if (i2 < i5) {
            int[] iArr3 = this.h;
            int i6 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i6, i5 - i2);
            Object[] objArr2 = this.i;
            System.arraycopy(objArr2, i2, objArr2, i6, this.j - i2);
        }
        this.h[i2] = i;
        this.i[i2] = e2;
        this.j++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        b(this.j + collection.size());
        boolean z = false;
        for (E e2 : collection) {
            z |= add(e2);
        }
        return z;
    }

    public void b(int i) {
        int[] iArr = this.h;
        if (iArr.length < i) {
            Object[] objArr = this.i;
            a(i);
            int i2 = this.j;
            if (i2 > 0) {
                System.arraycopy(iArr, 0, this.h, 0, i2);
                System.arraycopy(objArr, 0, this.i, 0, this.j);
            }
            c(iArr, objArr, this.j);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i = this.j;
        if (i != 0) {
            c(this.h, this.i, i);
            this.h = b;
            this.i = c;
            this.j = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            for (int i = 0; i < this.j; i++) {
                try {
                    if (!set.contains(h(i))) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    public E g(int i) {
        Object[] objArr = this.i;
        E e2 = (E) objArr[i];
        int i2 = this.j;
        if (i2 <= 1) {
            c(this.h, objArr, i2);
            this.h = b;
            this.i = c;
            this.j = 0;
        } else {
            int[] iArr = this.h;
            if (iArr.length > 8 && i2 < iArr.length / 3) {
                a(i2 > 8 ? i2 + (i2 >> 1) : 8);
                this.j--;
                if (i > 0) {
                    System.arraycopy(iArr, 0, this.h, 0, i);
                    System.arraycopy(objArr, 0, this.i, 0, i);
                }
                int i3 = this.j;
                if (i < i3) {
                    int i4 = i + 1;
                    System.arraycopy(iArr, i4, this.h, i, i3 - i);
                    System.arraycopy(objArr, i4, this.i, i, this.j - i);
                }
            } else {
                int i5 = i2 - 1;
                this.j = i5;
                if (i < i5) {
                    int i6 = i + 1;
                    System.arraycopy(iArr, i6, iArr, i, i5 - i);
                    Object[] objArr2 = this.i;
                    System.arraycopy(objArr2, i6, objArr2, i, this.j - i);
                }
                this.i[this.j] = null;
            }
        }
        return e2;
    }

    public E h(int i) {
        return (E) this.i[i];
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArr = this.h;
        int i = this.j;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += iArr[i3];
        }
        return i2;
    }

    public int indexOf(Object obj) {
        return obj == null ? f() : e(obj, obj.hashCode());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.j <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return d().m().iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf >= 0) {
            g(indexOf);
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            z |= remove(it.next());
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int i = this.j - 1; i >= 0; i--) {
            if (!collection.contains(this.i[i])) {
                g(i);
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.j;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        int i = this.j;
        Object[] objArr = new Object[i];
        System.arraycopy(this.i, 0, objArr, 0, i);
        return objArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.j * 14);
        sb.append('{');
        for (int i = 0; i < this.j; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            E h = h(i);
            if (h != this) {
                sb.append(h);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public q3(int i) {
        if (i == 0) {
            this.h = b;
            this.i = c;
        } else {
            a(i);
        }
        this.j = 0;
    }

    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.j) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.j));
        }
        System.arraycopy(this.i, 0, tArr, 0, this.j);
        int length = tArr.length;
        int i = this.j;
        if (length > i) {
            tArr[i] = null;
        }
        return tArr;
    }
}
