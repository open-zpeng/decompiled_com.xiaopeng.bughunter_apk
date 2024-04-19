package defpackage;

import java.util.concurrent.TimeUnit;
/* compiled from: Scheduler.java */
/* renamed from: tg  reason: default package */
/* loaded from: classes.dex */
public abstract class tg {
    static final long a = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Scheduler.java */
    /* renamed from: tg$a */
    /* loaded from: classes.dex */
    public static final class a implements zg, Runnable {
        final Runnable b;
        final b c;
        Thread d;

        a(Runnable runnable, b bVar) {
            this.b = runnable;
            this.c = bVar;
        }

        @Override // defpackage.zg
        public void dispose() {
            if (this.d == Thread.currentThread()) {
                b bVar = this.c;
                if (bVar instanceof ej) {
                    ((ej) bVar).f();
                    return;
                }
            }
            this.c.dispose();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.d = Thread.currentThread();
            try {
                this.b.run();
            } finally {
                dispose();
                this.d = null;
            }
        }
    }

    /* compiled from: Scheduler.java */
    /* renamed from: tg$b */
    /* loaded from: classes.dex */
    public static abstract class b implements zg {
        public long a(TimeUnit timeUnit) {
            return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        public zg b(Runnable runnable) {
            return c(runnable, 0L, TimeUnit.NANOSECONDS);
        }

        public abstract zg c(Runnable runnable, long j, TimeUnit timeUnit);
    }

    public abstract b a();

    public zg b(Runnable runnable) {
        return c(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    public zg c(Runnable runnable, long j, TimeUnit timeUnit) {
        b a2 = a();
        a aVar = new a(uj.o(runnable), a2);
        a2.c(aVar, j, timeUnit);
        return aVar;
    }
}
