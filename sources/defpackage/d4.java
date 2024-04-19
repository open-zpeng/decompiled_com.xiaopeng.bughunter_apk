package defpackage;
/* compiled from: SparseArrayCompat.java */
/* renamed from: d4  reason: default package */
/* loaded from: classes.dex */
public class d4<E> implements Cloneable {
    private static final Object b = new Object();
    private boolean c;
    private int[] d;
    private Object[] e;
    private int f;

    public d4() {
        this(10);
    }

    private void e() {
        int i = this.f;
        int[] iArr = this.d;
        Object[] objArr = this.e;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != b) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.c = false;
        this.f = i2;
    }

    public void a(int i, E e) {
        int i2 = this.f;
        if (i2 != 0 && i <= this.d[i2 - 1]) {
            j(i, e);
            return;
        }
        if (this.c && i2 >= this.d.length) {
            e();
        }
        int i3 = this.f;
        if (i3 >= this.d.length) {
            int e2 = r3.e(i3 + 1);
            int[] iArr = new int[e2];
            Object[] objArr = new Object[e2];
            int[] iArr2 = this.d;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr2 = this.e;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.d = iArr;
            this.e = objArr;
        }
        this.d[i3] = i;
        this.e[i3] = e;
        this.f = i3 + 1;
    }

    public void b() {
        int i = this.f;
        Object[] objArr = this.e;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f = 0;
        this.c = false;
    }

    /* renamed from: c */
    public d4<E> clone() {
        try {
            d4<E> d4Var = (d4) super.clone();
            d4Var.d = (int[]) this.d.clone();
            d4Var.e = (Object[]) this.e.clone();
            return d4Var;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public void d(int i) {
        int a = r3.a(this.d, this.f, i);
        if (a >= 0) {
            Object[] objArr = this.e;
            Object obj = objArr[a];
            Object obj2 = b;
            if (obj != obj2) {
                objArr[a] = obj2;
                this.c = true;
            }
        }
    }

    public E f(int i) {
        return g(i, null);
    }

    public E g(int i, E e) {
        int a = r3.a(this.d, this.f, i);
        if (a >= 0) {
            Object[] objArr = this.e;
            if (objArr[a] != b) {
                return (E) objArr[a];
            }
        }
        return e;
    }

    public int h(int i) {
        if (this.c) {
            e();
        }
        return r3.a(this.d, this.f, i);
    }

    public int i(int i) {
        if (this.c) {
            e();
        }
        return this.d[i];
    }

    public void j(int i, E e) {
        int a = r3.a(this.d, this.f, i);
        if (a >= 0) {
            this.e[a] = e;
            return;
        }
        int i2 = ~a;
        int i3 = this.f;
        if (i2 < i3) {
            Object[] objArr = this.e;
            if (objArr[i2] == b) {
                this.d[i2] = i;
                objArr[i2] = e;
                return;
            }
        }
        if (this.c && i3 >= this.d.length) {
            e();
            i2 = ~r3.a(this.d, this.f, i);
        }
        int i4 = this.f;
        if (i4 >= this.d.length) {
            int e2 = r3.e(i4 + 1);
            int[] iArr = new int[e2];
            Object[] objArr2 = new Object[e2];
            int[] iArr2 = this.d;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.e;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.d = iArr;
            this.e = objArr2;
        }
        int i5 = this.f;
        if (i5 - i2 != 0) {
            int[] iArr3 = this.d;
            int i6 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i6, i5 - i2);
            Object[] objArr4 = this.e;
            System.arraycopy(objArr4, i2, objArr4, i6, this.f - i2);
        }
        this.d[i2] = i;
        this.e[i2] = e;
        this.f++;
    }

    public void k(int i) {
        d(i);
    }

    public int l() {
        if (this.c) {
            e();
        }
        return this.f;
    }

    public E m(int i) {
        if (this.c) {
            e();
        }
        return (E) this.e[i];
    }

    public String toString() {
        if (l() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f * 28);
        sb.append('{');
        for (int i = 0; i < this.f; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(i(i));
            sb.append('=');
            E m = m(i);
            if (m != this) {
                sb.append(m);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public d4(int i) {
        this.c = false;
        if (i == 0) {
            this.d = r3.a;
            this.e = r3.c;
        } else {
            int e = r3.e(i);
            this.d = new int[e];
            this.e = new Object[e];
        }
        this.f = 0;
    }
}
