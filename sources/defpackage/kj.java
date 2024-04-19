package defpackage;

import defpackage.tg;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: TrampolineScheduler.java */
/* renamed from: kj  reason: default package */
/* loaded from: classes.dex */
public final class kj extends tg {
    private static final kj b = new kj();

    /* compiled from: TrampolineScheduler.java */
    /* renamed from: kj$a */
    /* loaded from: classes.dex */
    static final class a implements Runnable {
        private final Runnable b;
        private final c c;
        private final long d;

        a(Runnable runnable, c cVar, long j) {
            this.b = runnable;
            this.c = cVar;
            this.d = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.c.e) {
                return;
            }
            long a = this.c.a(TimeUnit.MILLISECONDS);
            long j = this.d;
            if (j > a) {
                try {
                    Thread.sleep(j - a);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    uj.m(e);
                    return;
                }
            }
            if (this.c.e) {
                return;
            }
            this.b.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TrampolineScheduler.java */
    /* renamed from: kj$b */
    /* loaded from: classes.dex */
    public static final class b implements Comparable<b> {
        final Runnable b;
        final long c;
        final int d;
        volatile boolean e;

        b(Runnable runnable, Long l, int i) {
            this.b = runnable;
            this.c = l.longValue();
            this.d = i;
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(b bVar) {
            int b = xh.b(this.c, bVar.c);
            return b == 0 ? xh.a(this.d, bVar.d) : b;
        }
    }

    /* compiled from: TrampolineScheduler.java */
    /* renamed from: kj$c */
    /* loaded from: classes.dex */
    static final class c extends tg.b implements zg {
        final PriorityBlockingQueue<b> b = new PriorityBlockingQueue<>();
        private final AtomicInteger c = new AtomicInteger();
        final AtomicInteger d = new AtomicInteger();
        volatile boolean e;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TrampolineScheduler.java */
        /* renamed from: kj$c$a */
        /* loaded from: classes.dex */
        public final class a implements Runnable {
            final b b;

            a(b bVar) {
                this.b = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.b.e = true;
                c.this.b.remove(this.b);
            }
        }

        c() {
        }

        @Override // defpackage.tg.b
        public zg b(Runnable runnable) {
            return d(runnable, a(TimeUnit.MILLISECONDS));
        }

        @Override // defpackage.tg.b
        public zg c(Runnable runnable, long j, TimeUnit timeUnit) {
            long a2 = a(TimeUnit.MILLISECONDS) + timeUnit.toMillis(j);
            return d(new a(runnable, this, a2), a2);
        }

        zg d(Runnable runnable, long j) {
            if (this.e) {
                return th.INSTANCE;
            }
            b bVar = new b(runnable, Long.valueOf(j), this.d.incrementAndGet());
            this.b.add(bVar);
            if (this.c.getAndIncrement() == 0) {
                int i = 1;
                while (!this.e) {
                    b poll = this.b.poll();
                    if (poll == null) {
                        i = this.c.addAndGet(-i);
                        if (i == 0) {
                            return th.INSTANCE;
                        }
                    } else if (!poll.e) {
                        poll.b.run();
                    }
                }
                this.b.clear();
                return th.INSTANCE;
            }
            return ah.b(new a(bVar));
        }

        @Override // defpackage.zg
        public void dispose() {
            this.e = true;
        }
    }

    kj() {
    }

    public static kj d() {
        return b;
    }

    @Override // defpackage.tg
    public tg.b a() {
        return new c();
    }

    @Override // defpackage.tg
    public zg b(Runnable runnable) {
        uj.o(runnable).run();
        return th.INSTANCE;
    }

    @Override // defpackage.tg
    public zg c(Runnable runnable, long j, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(j);
            uj.o(runnable).run();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            uj.m(e);
        }
        return th.INSTANCE;
    }
}
