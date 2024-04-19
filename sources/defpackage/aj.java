package defpackage;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: AbstractDirectTask.java */
/* renamed from: aj  reason: default package */
/* loaded from: classes.dex */
abstract class aj extends AtomicReference<Future<?>> implements zg {
    protected static final FutureTask<Void> b;
    protected static final FutureTask<Void> c;
    private static final long serialVersionUID = 1811839108042568751L;
    protected final Runnable d;
    protected Thread e;

    static {
        Runnable runnable = wh.b;
        b = new FutureTask<>(runnable, null);
        c = new FutureTask<>(runnable, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(Runnable runnable) {
        this.d = runnable;
    }

    public final void a(Future<?> future) {
        Future<?> future2;
        do {
            future2 = get();
            if (future2 == b) {
                return;
            }
            if (future2 == c) {
                future.cancel(this.e != Thread.currentThread());
                return;
            }
        } while (!compareAndSet(future2, future));
    }

    @Override // defpackage.zg
    public final void dispose() {
        FutureTask<Void> futureTask;
        Future<?> future = get();
        if (future == b || future == (futureTask = c) || !compareAndSet(future, futureTask) || future == null) {
            return;
        }
        future.cancel(this.e != Thread.currentThread());
    }
}
