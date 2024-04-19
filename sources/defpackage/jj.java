package defpackage;

import defpackage.tg;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: SingleScheduler.java */
/* renamed from: jj  reason: default package */
/* loaded from: classes.dex */
public final class jj extends tg {
    static final fj b;
    static final ScheduledExecutorService c;
    final ThreadFactory d;
    final AtomicReference<ScheduledExecutorService> e;

    /* compiled from: SingleScheduler.java */
    /* renamed from: jj$a */
    /* loaded from: classes.dex */
    static final class a extends tg.b {
        final ScheduledExecutorService b;
        final yg c = new yg();
        volatile boolean d;

        a(ScheduledExecutorService scheduledExecutorService) {
            this.b = scheduledExecutorService;
        }

        @Override // defpackage.tg.b
        public zg c(Runnable runnable, long j, TimeUnit timeUnit) {
            Future<?> schedule;
            if (this.d) {
                return th.INSTANCE;
            }
            hj hjVar = new hj(uj.o(runnable), this.c);
            this.c.c(hjVar);
            try {
                if (j <= 0) {
                    schedule = this.b.submit((Callable) hjVar);
                } else {
                    schedule = this.b.schedule((Callable) hjVar, j, timeUnit);
                }
                hjVar.a(schedule);
                return hjVar;
            } catch (RejectedExecutionException e) {
                dispose();
                uj.m(e);
                return th.INSTANCE;
            }
        }

        @Override // defpackage.zg
        public void dispose() {
            if (this.d) {
                return;
            }
            this.d = true;
            this.c.dispose();
        }
    }

    static {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(0);
        c = newScheduledThreadPool;
        newScheduledThreadPool.shutdown();
        b = new fj("RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.single-priority", 5).intValue())), true);
    }

    public jj() {
        this(b);
    }

    static ScheduledExecutorService d(ThreadFactory threadFactory) {
        return ij.a(threadFactory);
    }

    @Override // defpackage.tg
    public tg.b a() {
        return new a(this.e.get());
    }

    @Override // defpackage.tg
    public zg c(Runnable runnable, long j, TimeUnit timeUnit) {
        Future<?> schedule;
        gj gjVar = new gj(uj.o(runnable));
        try {
            if (j <= 0) {
                schedule = this.e.get().submit(gjVar);
            } else {
                schedule = this.e.get().schedule(gjVar, j, timeUnit);
            }
            gjVar.a(schedule);
            return gjVar;
        } catch (RejectedExecutionException e) {
            uj.m(e);
            return th.INSTANCE;
        }
    }

    public jj(ThreadFactory threadFactory) {
        AtomicReference<ScheduledExecutorService> atomicReference = new AtomicReference<>();
        this.e = atomicReference;
        this.d = threadFactory;
        atomicReference.lazySet(d(threadFactory));
    }
}
