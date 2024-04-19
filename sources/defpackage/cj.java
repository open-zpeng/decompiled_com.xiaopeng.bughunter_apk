package defpackage;

import defpackage.tg;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: IoScheduler.java */
/* renamed from: cj  reason: default package */
/* loaded from: classes.dex */
public final class cj extends tg {
    static final fj b;
    static final fj c;
    private static final TimeUnit d = TimeUnit.SECONDS;
    static final c e;
    static final a f;
    final ThreadFactory g;
    final AtomicReference<a> h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IoScheduler.java */
    /* renamed from: cj$a */
    /* loaded from: classes.dex */
    public static final class a implements Runnable {
        private final long b;
        private final ConcurrentLinkedQueue<c> c;
        final yg d;
        private final ScheduledExecutorService e;
        private final Future<?> f;
        private final ThreadFactory g;

        a(long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledFuture<?> scheduledFuture;
            long nanos = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.b = nanos;
            this.c = new ConcurrentLinkedQueue<>();
            this.d = new yg();
            this.g = threadFactory;
            ScheduledExecutorService scheduledExecutorService = null;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, cj.c);
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(this, nanos, nanos, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.e = scheduledExecutorService;
            this.f = scheduledFuture;
        }

        void a() {
            if (this.c.isEmpty()) {
                return;
            }
            long c = c();
            Iterator<c> it = this.c.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next.g() > c) {
                    return;
                }
                if (this.c.remove(next)) {
                    this.d.b(next);
                }
            }
        }

        c b() {
            if (this.d.e()) {
                return cj.e;
            }
            while (!this.c.isEmpty()) {
                c poll = this.c.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.g);
            this.d.c(cVar);
            return cVar;
        }

        long c() {
            return System.nanoTime();
        }

        void d(c cVar) {
            cVar.h(c() + this.b);
            this.c.offer(cVar);
        }

        void e() {
            this.d.dispose();
            Future<?> future = this.f;
            if (future != null) {
                future.cancel(true);
            }
            ScheduledExecutorService scheduledExecutorService = this.e;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
        }
    }

    /* compiled from: IoScheduler.java */
    /* renamed from: cj$b */
    /* loaded from: classes.dex */
    static final class b extends tg.b {
        private final a c;
        private final c d;
        final AtomicBoolean e = new AtomicBoolean();
        private final yg b = new yg();

        b(a aVar) {
            this.c = aVar;
            this.d = aVar.b();
        }

        @Override // defpackage.tg.b
        public zg c(Runnable runnable, long j, TimeUnit timeUnit) {
            if (this.b.e()) {
                return th.INSTANCE;
            }
            return this.d.d(runnable, j, timeUnit, this.b);
        }

        @Override // defpackage.zg
        public void dispose() {
            if (this.e.compareAndSet(false, true)) {
                this.b.dispose();
                this.c.d(this.d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IoScheduler.java */
    /* renamed from: cj$c */
    /* loaded from: classes.dex */
    public static final class c extends ej {
        private long d;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.d = 0L;
        }

        public long g() {
            return this.d;
        }

        public void h(long j) {
            this.d = j;
        }
    }

    static {
        c cVar = new c(new fj("RxCachedThreadSchedulerShutdown"));
        e = cVar;
        cVar.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        fj fjVar = new fj("RxCachedThreadScheduler", max);
        b = fjVar;
        c = new fj("RxCachedWorkerPoolEvictor", max);
        a aVar = new a(0L, null, fjVar);
        f = aVar;
        aVar.e();
    }

    public cj() {
        this(b);
    }

    @Override // defpackage.tg
    public tg.b a() {
        return new b(this.h.get());
    }

    public void d() {
        a aVar = new a(60L, d, this.g);
        if (this.h.compareAndSet(f, aVar)) {
            return;
        }
        aVar.e();
    }

    public cj(ThreadFactory threadFactory) {
        this.g = threadFactory;
        this.h = new AtomicReference<>(f);
        d();
    }
}
