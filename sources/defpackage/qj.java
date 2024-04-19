package defpackage;
/* compiled from: OpenHashSet.java */
/* renamed from: qj  reason: default package */
/* loaded from: classes.dex */
public final class qj<T> {
    final float a;
    int b;
    int c;
    int d;
    T[] e;

    public qj() {
        this(16, 0.75f);
    }

    static int c(int i) {
        int i2 = i * (-1640531527);
        return i2 ^ (i2 >>> 16);
    }

    public boolean a(T t) {
        T t2;
        T[] tArr = this.e;
        int i = this.b;
        int c = c(t.hashCode()) & i;
        T t3 = tArr[c];
        if (t3 != null) {
            if (t3.equals(t)) {
                return false;
            }
            do {
                c = (c + 1) & i;
                t2 = tArr[c];
                if (t2 == null) {
                }
            } while (!t2.equals(t));
            return false;
        }
        tArr[c] = t;
        int i2 = this.c + 1;
        this.c = i2;
        if (i2 >= this.d) {
            d();
        }
        return true;
    }

    public Object[] b() {
        return this.e;
    }

    void d() {
        T[] tArr = this.e;
        int length = tArr.length;
        int i = length << 1;
        int i2 = i - 1;
        T[] tArr2 = (T[]) new Object[i];
        int i3 = this.c;
        while (true) {
            int i4 = i3 - 1;
            if (i3 != 0) {
                do {
                    length--;
                } while (tArr[length] == null);
                int c = c(tArr[length].hashCode()) & i2;
                if (tArr2[c] != null) {
                    do {
                        c = (c + 1) & i2;
                    } while (tArr2[c] != null);
                }
                tArr2[c] = tArr[length];
                i3 = i4;
            } else {
                this.b = i2;
                this.d = (int) (i * this.a);
                this.e = tArr2;
                return;
            }
        }
    }

    public boolean e(T t) {
        T t2;
        T[] tArr = this.e;
        int i = this.b;
        int c = c(t.hashCode()) & i;
        T t3 = tArr[c];
        if (t3 == null) {
            return false;
        }
        if (t3.equals(t)) {
            return f(c, tArr, i);
        }
        do {
            c = (c + 1) & i;
            t2 = tArr[c];
            if (t2 == null) {
                return false;
            }
        } while (!t2.equals(t));
        return f(c, tArr, i);
    }

    boolean f(int i, T[] tArr, int i2) {
        int i3;
        T t;
        this.c--;
        while (true) {
            int i4 = i + 1;
            while (true) {
                i3 = i4 & i2;
                t = tArr[i3];
                if (t == null) {
                    tArr[i] = null;
                    return true;
                }
                int c = c(t.hashCode()) & i2;
                if (i > i3) {
                    if (i >= c && c > i3) {
                        break;
                    }
                    i4 = i3 + 1;
                } else if (i < c && c <= i3) {
                    i4 = i3 + 1;
                }
            }
            tArr[i] = t;
            i = i3;
        }
    }

    public qj(int i, float f) {
        this.a = f;
        int a = rj.a(i);
        this.b = a - 1;
        this.d = (int) (f * a);
        this.e = (T[]) new Object[a];
    }
}
