package defpackage;

import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ReferenceDisposable.java */
/* renamed from: bh  reason: default package */
/* loaded from: classes.dex */
abstract class bh<T> extends AtomicReference<T> implements zg {
    private static final long serialVersionUID = 6537757548749041217L;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(T t) {
        super(xh.d(t, "value is null"));
    }

    public final boolean a() {
        return get() == null;
    }

    protected abstract void b(T t);

    @Override // defpackage.zg
    public final void dispose() {
        T andSet;
        if (get() == null || (andSet = getAndSet(null)) == null) {
            return;
        }
        b(andSet);
    }
}
