package defpackage;
/* compiled from: Pools.java */
/* renamed from: z3  reason: default package */
/* loaded from: classes.dex */
public class z3<T> implements y3<T> {
    private final Object[] a;
    private int b;

    public z3(int i) {
        if (i > 0) {
            this.a = new Object[i];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0");
    }

    private boolean c(T t) {
        for (int i = 0; i < this.b; i++) {
            if (this.a[i] == t) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.y3
    public boolean a(T t) {
        if (!c(t)) {
            int i = this.b;
            Object[] objArr = this.a;
            if (i < objArr.length) {
                objArr[i] = t;
                this.b = i + 1;
                return true;
            }
            return false;
        }
        throw new IllegalStateException("Already in the pool!");
    }

    @Override // defpackage.y3
    public T b() {
        int i = this.b;
        if (i > 0) {
            int i2 = i - 1;
            Object[] objArr = this.a;
            T t = (T) objArr[i2];
            objArr[i2] = null;
            this.b = i - 1;
            return t;
        }
        return null;
    }
}
