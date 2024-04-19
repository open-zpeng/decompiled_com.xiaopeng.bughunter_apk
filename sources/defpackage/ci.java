package defpackage;

import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: BasicIntQueueDisposable.java */
/* renamed from: ci  reason: default package */
/* loaded from: classes.dex */
public abstract class ci<T> extends AtomicInteger implements yh<T> {
    private static final long serialVersionUID = -1001730202384742097L;

    @Override // defpackage.ai
    public final boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called");
    }
}
