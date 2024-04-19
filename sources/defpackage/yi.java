package defpackage;

import defpackage.tg;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ObservableTimeoutTimed.java */
/* renamed from: yi  reason: default package */
/* loaded from: classes.dex */
public final class yi<T> extends gi<T, T> {
    final long c;
    final TimeUnit d;
    final tg e;
    final rg<? extends T> f;

    /* compiled from: ObservableTimeoutTimed.java */
    /* renamed from: yi$a */
    /* loaded from: classes.dex */
    static final class a<T> implements sg<T> {
        final sg<? super T> b;
        final AtomicReference<zg> c;

        a(sg<? super T> sgVar, AtomicReference<zg> atomicReference) {
            this.b = sgVar;
            this.c = atomicReference;
        }

        @Override // defpackage.sg
        public void onComplete() {
            this.b.onComplete();
        }

        @Override // defpackage.sg
        public void onError(Throwable th) {
            this.b.onError(th);
        }

        @Override // defpackage.sg
        public void onNext(T t) {
            this.b.onNext(t);
        }

        @Override // defpackage.sg
        public void onSubscribe(zg zgVar) {
            sh.replace(this.c, zgVar);
        }
    }

    /* compiled from: ObservableTimeoutTimed.java */
    /* renamed from: yi$b */
    /* loaded from: classes.dex */
    static final class b<T> extends AtomicReference<zg> implements sg<T>, zg, d {
        private static final long serialVersionUID = 3764492702657003550L;
        final sg<? super T> b;
        final long c;
        final TimeUnit d;
        final tg.b e;
        final vh f = new vh();
        final AtomicLong g = new AtomicLong();
        final AtomicReference<zg> h = new AtomicReference<>();
        rg<? extends T> i;

        b(sg<? super T> sgVar, long j, TimeUnit timeUnit, tg.b bVar, rg<? extends T> rgVar) {
            this.b = sgVar;
            this.c = j;
            this.d = timeUnit;
            this.e = bVar;
            this.i = rgVar;
        }

        @Override // defpackage.yi.d
        public void a(long j) {
            if (this.g.compareAndSet(j, Long.MAX_VALUE)) {
                sh.dispose(this.h);
                rg<? extends T> rgVar = this.i;
                this.i = null;
                rgVar.a(new a(this.b, this));
                this.e.dispose();
            }
        }

        void b(long j) {
            this.f.b(this.e.c(new e(j, this), this.c, this.d));
        }

        @Override // defpackage.zg
        public void dispose() {
            sh.dispose(this.h);
            sh.dispose(this);
            this.e.dispose();
        }

        @Override // defpackage.sg
        public void onComplete() {
            if (this.g.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f.dispose();
                this.b.onComplete();
                this.e.dispose();
            }
        }

        @Override // defpackage.sg
        public void onError(Throwable th) {
            if (this.g.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f.dispose();
                this.b.onError(th);
                this.e.dispose();
                return;
            }
            uj.m(th);
        }

        @Override // defpackage.sg
        public void onNext(T t) {
            long j = this.g.get();
            if (j != Long.MAX_VALUE) {
                long j2 = 1 + j;
                if (this.g.compareAndSet(j, j2)) {
                    this.f.get().dispose();
                    this.b.onNext(t);
                    b(j2);
                }
            }
        }

        @Override // defpackage.sg
        public void onSubscribe(zg zgVar) {
            sh.setOnce(this.h, zgVar);
        }
    }

    /* compiled from: ObservableTimeoutTimed.java */
    /* renamed from: yi$c */
    /* loaded from: classes.dex */
    static final class c<T> extends AtomicLong implements sg<T>, zg, d {
        private static final long serialVersionUID = 3764492702657003550L;
        final sg<? super T> b;
        final long c;
        final TimeUnit d;
        final tg.b e;
        final vh f = new vh();
        final AtomicReference<zg> g = new AtomicReference<>();

        c(sg<? super T> sgVar, long j, TimeUnit timeUnit, tg.b bVar) {
            this.b = sgVar;
            this.c = j;
            this.d = timeUnit;
            this.e = bVar;
        }

        @Override // defpackage.yi.d
        public void a(long j) {
            if (compareAndSet(j, Long.MAX_VALUE)) {
                sh.dispose(this.g);
                this.b.onError(new TimeoutException());
                this.e.dispose();
            }
        }

        void b(long j) {
            this.f.b(this.e.c(new e(j, this), this.c, this.d));
        }

        @Override // defpackage.zg
        public void dispose() {
            sh.dispose(this.g);
            this.e.dispose();
        }

        @Override // defpackage.sg
        public void onComplete() {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f.dispose();
                this.b.onComplete();
                this.e.dispose();
            }
        }

        @Override // defpackage.sg
        public void onError(Throwable th) {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f.dispose();
                this.b.onError(th);
                this.e.dispose();
                return;
            }
            uj.m(th);
        }

        @Override // defpackage.sg
        public void onNext(T t) {
            long j = get();
            if (j != Long.MAX_VALUE) {
                long j2 = 1 + j;
                if (compareAndSet(j, j2)) {
                    this.f.get().dispose();
                    this.b.onNext(t);
                    b(j2);
                }
            }
        }

        @Override // defpackage.sg
        public void onSubscribe(zg zgVar) {
            sh.setOnce(this.g, zgVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableTimeoutTimed.java */
    /* renamed from: yi$d */
    /* loaded from: classes.dex */
    public interface d {
        void a(long j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableTimeoutTimed.java */
    /* renamed from: yi$e */
    /* loaded from: classes.dex */
    public static final class e implements Runnable {
        final d b;
        final long c;

        e(long j, d dVar) {
            this.c = j;
            this.b = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.a(this.c);
        }
    }

    public yi(og<T> ogVar, long j, TimeUnit timeUnit, tg tgVar, rg<? extends T> rgVar) {
        super(ogVar);
        this.c = j;
        this.d = timeUnit;
        this.e = tgVar;
        this.f = rgVar;
    }

    @Override // defpackage.og
    protected void w(sg<? super T> sgVar) {
        if (this.f == null) {
            c cVar = new c(sgVar, this.c, this.d, this.e.a());
            sgVar.onSubscribe(cVar);
            cVar.b(0L);
            this.b.a(cVar);
            return;
        }
        b bVar = new b(sgVar, this.c, this.d, this.e.a(), this.f);
        sgVar.onSubscribe(bVar);
        bVar.b(0L);
        this.b.a(bVar);
    }
}
