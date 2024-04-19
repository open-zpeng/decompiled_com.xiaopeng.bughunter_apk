package defpackage;

import defpackage.tg;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ComputationScheduler.java */
/* renamed from: bj  reason: default package */
/* loaded from: classes.dex */
public final class bj extends tg {
    static final b b;
    static final fj c;
    static final int d = d(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());
    static final c e;
    final ThreadFactory f;
    final AtomicReference<b> g;

    /* compiled from: ComputationScheduler.java */
    /* renamed from: bj$a */
    /* loaded from: classes.dex */
    static final class a extends tg.b {
        private final uh b;
        private final yg c;
        private final uh d;
        private final c e;
        volatile boolean f;

        a(c cVar) {
            this.e = cVar;
            uh uhVar = new uh();
            this.b = uhVar;
            yg ygVar = new yg();
            this.c = ygVar;
            uh uhVar2 = new uh();
            this.d = uhVar2;
            uhVar2.c(uhVar);
            uhVar2.c(ygVar);
        }

        @Override // defpackage.tg.b
        public zg b(Runnable runnable) {
            if (this.f) {
                return th.INSTANCE;
            }
            return this.e.d(runnable, 0L, TimeUnit.MILLISECONDS, this.b);
        }

        @Override // defpackage.tg.b
        public zg c(Runnable runnable, long j, TimeUnit timeUnit) {
            if (this.f) {
                return th.INSTANCE;
            }
            return this.e.d(runnable, j, timeUnit, this.c);
        }

        @Override // defpackage.zg
        public void dispose() {
            if (this.f) {
                return;
            }
            this.f = true;
            this.d.dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ComputationScheduler.java */
    /* renamed from: bj$b */
    /* loaded from: classes.dex */
    public static final class b {
        final int a;
        final c[] b;
        long c;

        b(int i, ThreadFactory threadFactory) {
            this.a = i;
            this.b = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.b[i2] = new c(threadFactory);
            }
        }

        public c a() {
            int i = this.a;
            if (i == 0) {
                return bj.e;
            }
            c[] cVarArr = this.b;
            long j = this.c;
            this.c = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void b() {
            for (c cVar : this.b) {
                cVar.dispose();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ComputationScheduler.java */
    /* renamed from: bj$c */
    /* loaded from: classes.dex */
    public static final class c extends ej {
        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        c cVar = new c(new fj("RxComputationShutdown"));
        e = cVar;
        cVar.dispose();
        fj fjVar = new fj("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        c = fjVar;
        b bVar = new b(0, fjVar);
        b = bVar;
        bVar.b();
    }

    public bj() {
        this(c);
    }

    static int d(int i, int i2) {
        return (i2 <= 0 || i2 > i) ? i : i2;
    }

    @Override // defpackage.tg
    public tg.b a() {
        return new a(this.g.get().a());
    }

    @Override // defpackage.tg
    public zg c(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.g.get().a().e(runnable, j, timeUnit);
    }

    public void e() {
        b bVar = new b(d, this.f);
        if (this.g.compareAndSet(b, bVar)) {
            return;
        }
        bVar.b();
    }

    public bj(ThreadFactory threadFactory) {
        this.f = threadFactory;
        this.g = new AtomicReference<>(b);
        e();
    }
}
