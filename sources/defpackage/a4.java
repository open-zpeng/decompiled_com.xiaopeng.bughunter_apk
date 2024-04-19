package defpackage;
/* compiled from: Pools.java */
/* renamed from: a4  reason: default package */
/* loaded from: classes.dex */
public class a4<T> extends z3<T> {
    private final Object c;

    public a4(int i) {
        super(i);
        this.c = new Object();
    }

    @Override // defpackage.z3, defpackage.y3
    public boolean a(T t) {
        boolean a;
        synchronized (this.c) {
            a = super.a(t);
        }
        return a;
    }

    @Override // defpackage.z3, defpackage.y3
    public T b() {
        T t;
        synchronized (this.c) {
            t = (T) super.b();
        }
        return t;
    }
}
