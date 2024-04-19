package defpackage;

import defpackage.tg;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
/* compiled from: NewThreadWorker.java */
/* renamed from: ej  reason: default package */
/* loaded from: classes.dex */
public class ej extends tg.b implements zg {
    private final ScheduledExecutorService b;
    volatile boolean c;

    public ej(ThreadFactory threadFactory) {
        this.b = ij.a(threadFactory);
    }

    @Override // defpackage.tg.b
    public zg b(Runnable runnable) {
        return c(runnable, 0L, null);
    }

    @Override // defpackage.tg.b
    public zg c(Runnable runnable, long j, TimeUnit timeUnit) {
        if (this.c) {
            return th.INSTANCE;
        }
        return d(runnable, j, timeUnit, null);
    }

    public hj d(Runnable runnable, long j, TimeUnit timeUnit, rh rhVar) {
        Future<?> schedule;
        hj hjVar = new hj(uj.o(runnable), rhVar);
        if (rhVar == null || rhVar.c(hjVar)) {
            try {
                if (j <= 0) {
                    schedule = this.b.submit((Callable) hjVar);
                } else {
                    schedule = this.b.schedule((Callable) hjVar, j, timeUnit);
                }
                hjVar.a(schedule);
            } catch (RejectedExecutionException e) {
                if (rhVar != null) {
                    rhVar.b(hjVar);
                }
                uj.m(e);
            }
            return hjVar;
        }
        return hjVar;
    }

    @Override // defpackage.zg
    public void dispose() {
        if (this.c) {
            return;
        }
        this.c = true;
        this.b.shutdownNow();
    }

    public zg e(Runnable runnable, long j, TimeUnit timeUnit) {
        Future<?> schedule;
        gj gjVar = new gj(uj.o(runnable));
        try {
            if (j <= 0) {
                schedule = this.b.submit(gjVar);
            } else {
                schedule = this.b.schedule(gjVar, j, timeUnit);
            }
            gjVar.a(schedule);
            return gjVar;
        } catch (RejectedExecutionException e) {
            uj.m(e);
            return th.INSTANCE;
        }
    }

    public void f() {
        if (this.c) {
            return;
        }
        this.c = true;
        this.b.shutdown();
    }
}
