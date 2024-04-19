package defpackage;

import java.util.concurrent.Callable;
/* compiled from: ScheduledDirectTask.java */
/* renamed from: gj  reason: default package */
/* loaded from: classes.dex */
public final class gj extends aj implements Callable<Void> {
    private static final long serialVersionUID = 1811839108042568751L;

    public gj(Runnable runnable) {
        super(runnable);
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: b */
    public Void call() throws Exception {
        this.e = Thread.currentThread();
        try {
            this.d.run();
            return null;
        } finally {
            lazySet(aj.b);
            this.e = null;
        }
    }
}
