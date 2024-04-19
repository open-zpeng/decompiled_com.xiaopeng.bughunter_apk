package defpackage;

import defpackage.vi;
import java.util.concurrent.Callable;
/* compiled from: ObservableJust.java */
/* renamed from: pi  reason: default package */
/* loaded from: classes.dex */
public final class pi<T> extends og<T> implements Callable {
    private final T b;

    public pi(T t) {
        this.b = t;
    }

    @Override // java.util.concurrent.Callable
    public T call() {
        return this.b;
    }

    @Override // defpackage.og
    protected void w(sg<? super T> sgVar) {
        vi.a aVar = new vi.a(sgVar, this.b);
        sgVar.onSubscribe(aVar);
        aVar.run();
    }
}
