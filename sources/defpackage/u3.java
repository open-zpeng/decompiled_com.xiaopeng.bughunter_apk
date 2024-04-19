package defpackage;
/* compiled from: LongSparseArray.java */
/* renamed from: u3  reason: default package */
/* loaded from: classes.dex */
public class u3<E> implements Cloneable {
    private static final Object b = new Object();
    private boolean c;
    private long[] d;
    private Object[] e;
    private int f;

    public u3() {
        this(10);
    }

    private void e() {
        int i = this.f;
        long[] jArr = this.d;
        Object[] objArr = this.e;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != b) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.c = false;
        this.f = i2;
    }

    public void a(long j, E e) {
        int i = this.f;
        if (i != 0 && j <= this.d[i - 1]) {
            j(j, e);
            return;
        }
        if (this.c && i >= this.d.length) {
            e();
        }
        int i2 = this.f;
        if (i2 >= this.d.length) {
            int f = r3.f(i2 + 1);
            long[] jArr = new long[f];
            Object[] objArr = new Object[f];
            long[] jArr2 = this.d;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr2 = this.e;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.d = jArr;
            this.e = objArr;
        }
        this.d[i2] = j;
        this.e[i2] = e;
        this.f = i2 + 1;
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
    public u3<E> clone() {
        try {
            u3<E> u3Var = (u3) super.clone();
            u3Var.d = (long[]) this.d.clone();
            u3Var.e = (Object[]) this.e.clone();
            return u3Var;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public void d(long j) {
        int b2 = r3.b(this.d, this.f, j);
        if (b2 >= 0) {
            Object[] objArr = this.e;
            Object obj = objArr[b2];
            Object obj2 = b;
            if (obj != obj2) {
                objArr[b2] = obj2;
                this.c = true;
            }
        }
    }

    public E f(long j) {
        return g(j, null);
    }

    public E g(long j, E e) {
        int b2 = r3.b(this.d, this.f, j);
        if (b2 >= 0) {
            Object[] objArr = this.e;
            if (objArr[b2] != b) {
                return (E) objArr[b2];
            }
        }
        return e;
    }

    public int h(long j) {
        if (this.c) {
            e();
        }
        return r3.b(this.d, this.f, j);
    }

    public long i(int i) {
        if (this.c) {
            e();
        }
        return this.d[i];
    }

    public void j(long j, E e) {
        int b2 = r3.b(this.d, this.f, j);
        if (b2 >= 0) {
            this.e[b2] = e;
            return;
        }
        int i = ~b2;
        int i2 = this.f;
        if (i < i2) {
            Object[] objArr = this.e;
            if (objArr[i] == b) {
                this.d[i] = j;
                objArr[i] = e;
                return;
            }
        }
        if (this.c && i2 >= this.d.length) {
            e();
            i = ~r3.b(this.d, this.f, j);
        }
        int i3 = this.f;
        if (i3 >= this.d.length) {
            int f = r3.f(i3 + 1);
            long[] jArr = new long[f];
            Object[] objArr2 = new Object[f];
            long[] jArr2 = this.d;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.e;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.d = jArr;
            this.e = objArr2;
        }
        int i4 = this.f;
        if (i4 - i != 0) {
            long[] jArr3 = this.d;
            int i5 = i + 1;
            System.arraycopy(jArr3, i, jArr3, i5, i4 - i);
            Object[] objArr4 = this.e;
            System.arraycopy(objArr4, i, objArr4, i5, this.f - i);
        }
        this.d[i] = j;
        this.e[i] = e;
        this.f++;
    }

    public void k(int i) {
        Object[] objArr = this.e;
        Object obj = objArr[i];
        Object obj2 = b;
        if (obj != obj2) {
            objArr[i] = obj2;
            this.c = true;
        }
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

    public u3(int i) {
        this.c = false;
        if (i == 0) {
            this.d = r3.b;
            this.e = r3.c;
        } else {
            int f = r3.f(i);
            this.d = new long[f];
            this.e = new Object[f];
        }
        this.f = 0;
    }
}
