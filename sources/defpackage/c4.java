package defpackage;

import java.util.ConcurrentModificationException;
import java.util.Map;
/* compiled from: SimpleArrayMap.java */
/* renamed from: c4  reason: default package */
/* loaded from: classes.dex */
public class c4<K, V> {
    static Object[] b;
    static int c;
    static Object[] d;
    static int e;
    int[] f;
    Object[] g;
    int h;

    public c4() {
        this.f = r3.a;
        this.g = r3.c;
        this.h = 0;
    }

    private void a(int i) {
        if (i == 8) {
            synchronized (p3.class) {
                Object[] objArr = d;
                if (objArr != null) {
                    this.g = objArr;
                    d = (Object[]) objArr[0];
                    this.f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    e--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (p3.class) {
                Object[] objArr2 = b;
                if (objArr2 != null) {
                    this.g = objArr2;
                    b = (Object[]) objArr2[0];
                    this.f = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    c--;
                    return;
                }
            }
        }
        this.f = new int[i];
        this.g = new Object[i << 1];
    }

    private static int b(int[] iArr, int i, int i2) {
        try {
            return r3.a(iArr, i, i2);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    private static void d(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (p3.class) {
                if (e < 10) {
                    objArr[0] = d;
                    objArr[1] = iArr;
                    for (int i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    d = objArr;
                    e++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (p3.class) {
                if (c < 10) {
                    objArr[0] = b;
                    objArr[1] = iArr;
                    for (int i3 = (i << 1) - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    b = objArr;
                    c++;
                }
            }
        }
    }

    public void c(int i) {
        int i2 = this.h;
        int[] iArr = this.f;
        if (iArr.length < i) {
            Object[] objArr = this.g;
            a(i);
            if (this.h > 0) {
                System.arraycopy(iArr, 0, this.f, 0, i2);
                System.arraycopy(objArr, 0, this.g, 0, i2 << 1);
            }
            d(iArr, objArr, i2);
        }
        if (this.h != i2) {
            throw new ConcurrentModificationException();
        }
    }

    public void clear() {
        int i = this.h;
        if (i > 0) {
            int[] iArr = this.f;
            Object[] objArr = this.g;
            this.f = r3.a;
            this.g = r3.c;
            this.h = 0;
            d(iArr, objArr, i);
        }
        if (this.h > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return f(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return h(obj) >= 0;
    }

    int e(Object obj, int i) {
        int i2 = this.h;
        if (i2 == 0) {
            return -1;
        }
        int b2 = b(this.f, i2, i);
        if (b2 >= 0 && !obj.equals(this.g[b2 << 1])) {
            int i3 = b2 + 1;
            while (i3 < i2 && this.f[i3] == i) {
                if (obj.equals(this.g[i3 << 1])) {
                    return i3;
                }
                i3++;
            }
            for (int i4 = b2 - 1; i4 >= 0 && this.f[i4] == i; i4--) {
                if (obj.equals(this.g[i4 << 1])) {
                    return i4;
                }
            }
            return ~i3;
        }
        return b2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c4) {
            c4 c4Var = (c4) obj;
            if (size() != c4Var.size()) {
                return false;
            }
            for (int i = 0; i < this.h; i++) {
                try {
                    K i2 = i(i);
                    V m = m(i);
                    Object obj2 = c4Var.get(i2);
                    if (m == null) {
                        if (obj2 != null || !c4Var.containsKey(i2)) {
                            return false;
                        }
                    } else if (!m.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            for (int i3 = 0; i3 < this.h; i3++) {
                try {
                    K i4 = i(i3);
                    V m2 = m(i3);
                    Object obj3 = map.get(i4);
                    if (m2 == null) {
                        if (obj3 != null || !map.containsKey(i4)) {
                            return false;
                        }
                    } else if (!m2.equals(obj3)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public int f(Object obj) {
        return obj == null ? g() : e(obj, obj.hashCode());
    }

    int g() {
        int i = this.h;
        if (i == 0) {
            return -1;
        }
        int b2 = b(this.f, i, 0);
        if (b2 >= 0 && this.g[b2 << 1] != null) {
            int i2 = b2 + 1;
            while (i2 < i && this.f[i2] == 0) {
                if (this.g[i2 << 1] == null) {
                    return i2;
                }
                i2++;
            }
            for (int i3 = b2 - 1; i3 >= 0 && this.f[i3] == 0; i3--) {
                if (this.g[i3 << 1] == null) {
                    return i3;
                }
            }
            return ~i2;
        }
        return b2;
    }

    public V get(Object obj) {
        int f = f(obj);
        if (f >= 0) {
            return (V) this.g[(f << 1) + 1];
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h(Object obj) {
        int i = this.h * 2;
        Object[] objArr = this.g;
        if (obj == null) {
            for (int i2 = 1; i2 < i; i2 += 2) {
                if (objArr[i2] == null) {
                    return i2 >> 1;
                }
            }
            return -1;
        }
        for (int i3 = 1; i3 < i; i3 += 2) {
            if (obj.equals(objArr[i3])) {
                return i3 >> 1;
            }
        }
        return -1;
    }

    public int hashCode() {
        int[] iArr = this.f;
        Object[] objArr = this.g;
        int i = this.h;
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            i4 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return i4;
    }

    public K i(int i) {
        return (K) this.g[i << 1];
    }

    public boolean isEmpty() {
        return this.h <= 0;
    }

    public void j(c4<? extends K, ? extends V> c4Var) {
        int i = c4Var.h;
        c(this.h + i);
        if (this.h != 0) {
            for (int i2 = 0; i2 < i; i2++) {
                put(c4Var.i(i2), c4Var.m(i2));
            }
        } else if (i > 0) {
            System.arraycopy(c4Var.f, 0, this.f, 0, i);
            System.arraycopy(c4Var.g, 0, this.g, 0, i << 1);
            this.h = i;
        }
    }

    public V k(int i) {
        Object[] objArr = this.g;
        int i2 = i << 1;
        V v = (V) objArr[i2 + 1];
        int i3 = this.h;
        int i4 = 0;
        if (i3 <= 1) {
            d(this.f, objArr, i3);
            this.f = r3.a;
            this.g = r3.c;
        } else {
            int i5 = i3 - 1;
            int[] iArr = this.f;
            if (iArr.length > 8 && i3 < iArr.length / 3) {
                a(i3 > 8 ? i3 + (i3 >> 1) : 8);
                if (i3 != this.h) {
                    throw new ConcurrentModificationException();
                }
                if (i > 0) {
                    System.arraycopy(iArr, 0, this.f, 0, i);
                    System.arraycopy(objArr, 0, this.g, 0, i2);
                }
                if (i < i5) {
                    int i6 = i + 1;
                    int i7 = i5 - i;
                    System.arraycopy(iArr, i6, this.f, i, i7);
                    System.arraycopy(objArr, i6 << 1, this.g, i2, i7 << 1);
                }
            } else {
                if (i < i5) {
                    int i8 = i + 1;
                    int i9 = i5 - i;
                    System.arraycopy(iArr, i8, iArr, i, i9);
                    Object[] objArr2 = this.g;
                    System.arraycopy(objArr2, i8 << 1, objArr2, i2, i9 << 1);
                }
                Object[] objArr3 = this.g;
                int i10 = i5 << 1;
                objArr3[i10] = null;
                objArr3[i10 + 1] = null;
            }
            i4 = i5;
        }
        if (i3 == this.h) {
            this.h = i4;
            return v;
        }
        throw new ConcurrentModificationException();
    }

    public V l(int i, V v) {
        int i2 = (i << 1) + 1;
        Object[] objArr = this.g;
        V v2 = (V) objArr[i2];
        objArr[i2] = v;
        return v2;
    }

    public V m(int i) {
        return (V) this.g[(i << 1) + 1];
    }

    public V put(K k, V v) {
        int i;
        int e2;
        int i2 = this.h;
        if (k == null) {
            e2 = g();
            i = 0;
        } else {
            int hashCode = k.hashCode();
            i = hashCode;
            e2 = e(k, hashCode);
        }
        if (e2 >= 0) {
            int i3 = (e2 << 1) + 1;
            Object[] objArr = this.g;
            V v2 = (V) objArr[i3];
            objArr[i3] = v;
            return v2;
        }
        int i4 = ~e2;
        int[] iArr = this.f;
        if (i2 >= iArr.length) {
            int i5 = 4;
            if (i2 >= 8) {
                i5 = (i2 >> 1) + i2;
            } else if (i2 >= 4) {
                i5 = 8;
            }
            Object[] objArr2 = this.g;
            a(i5);
            if (i2 == this.h) {
                int[] iArr2 = this.f;
                if (iArr2.length > 0) {
                    System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                    System.arraycopy(objArr2, 0, this.g, 0, objArr2.length);
                }
                d(iArr, objArr2, i2);
            } else {
                throw new ConcurrentModificationException();
            }
        }
        if (i4 < i2) {
            int[] iArr3 = this.f;
            int i6 = i4 + 1;
            System.arraycopy(iArr3, i4, iArr3, i6, i2 - i4);
            Object[] objArr3 = this.g;
            System.arraycopy(objArr3, i4 << 1, objArr3, i6 << 1, (this.h - i4) << 1);
        }
        int i7 = this.h;
        if (i2 == i7) {
            int[] iArr4 = this.f;
            if (i4 < iArr4.length) {
                iArr4[i4] = i;
                Object[] objArr4 = this.g;
                int i8 = i4 << 1;
                objArr4[i8] = k;
                objArr4[i8 + 1] = v;
                this.h = i7 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public V remove(Object obj) {
        int f = f(obj);
        if (f >= 0) {
            return k(f);
        }
        return null;
    }

    public int size() {
        return this.h;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.h * 28);
        sb.append('{');
        for (int i = 0; i < this.h; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            K i2 = i(i);
            if (i2 != this) {
                sb.append(i2);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            V m = m(i);
            if (m != this) {
                sb.append(m);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public c4(int i) {
        if (i == 0) {
            this.f = r3.a;
            this.g = r3.c;
        } else {
            a(i);
        }
        this.h = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c4(c4<K, V> c4Var) {
        this();
        if (c4Var != 0) {
            j(c4Var);
        }
    }
}
