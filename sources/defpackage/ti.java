package defpackage;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ObservableRefCount.java */
/* renamed from: ti  reason: default package */
/* loaded from: classes.dex */
public final class ti<T> extends og<T> {
    final sj<T> b;
    final int c;
    final long d;
    final TimeUnit e;
    final tg f;
    a g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableRefCount.java */
    /* renamed from: ti$a */
    /* loaded from: classes.dex */
    public static final class a extends AtomicReference<zg> implements Runnable, mh<zg> {
        private static final long serialVersionUID = -4552101107598366241L;
        final ti<?> b;
        zg c;
        long d;
        boolean e;

        a(ti<?> tiVar) {
            this.b = tiVar;
        }

        @Override // defpackage.mh
        /* renamed from: a */
        public void accept(zg zgVar) throws Exception {
            sh.replace(this, zgVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.E(this);
        }
    }

    /* compiled from: ObservableRefCount.java */
    /* renamed from: ti$b */
    /* loaded from: classes.dex */
    static final class b<T> extends AtomicBoolean implements sg<T>, zg {
        private static final long serialVersionUID = -7419642935409022375L;
        final sg<? super T> b;
        final ti<T> c;
        final a d;
        zg e;

        b(sg<? super T> sgVar, ti<T> tiVar, a aVar) {
            this.b = sgVar;
            this.c = tiVar;
            this.d = aVar;
        }

        @Override // defpackage.zg
        public void dispose() {
            this.e.dispose();
            if (compareAndSet(false, true)) {
                this.c.C(this.d);
            }
        }

        @Override // defpackage.sg
        public void onComplete() {
            if (compareAndSet(false, true)) {
                this.c.D(this.d);
                this.b.onComplete();
            }
        }

        @Override // defpackage.sg
        public void onError(Throwable th) {
            if (compareAndSet(false, true)) {
                this.c.D(this.d);
                this.b.onError(th);
                return;
            }
            uj.m(th);
        }

        @Override // defpackage.sg
        public void onNext(T t) {
            this.b.onNext(t);
        }

        @Override // defpackage.sg
        public void onSubscribe(zg zgVar) {
            if (sh.validate(this.e, zgVar)) {
                this.e = zgVar;
                this.b.onSubscribe(this);
            }
        }
    }

    public ti(sj<T> sjVar) {
        this(sjVar, 1, 0L, TimeUnit.NANOSECONDS, vj.c());
    }

    void C(a aVar) {
        synchronized (this) {
            if (this.g == null) {
                return;
            }
            long j = aVar.d - 1;
            aVar.d = j;
            if (j == 0 && aVar.e) {
                if (this.d == 0) {
                    E(aVar);
                    return;
                }
                vh vhVar = new vh();
                aVar.c = vhVar;
                vhVar.b(this.f.c(aVar, this.d, this.e));
            }
        }
    }

    void D(a aVar) {
        synchronized (this) {
            if (this.g != null) {
                this.g = null;
                zg zgVar = aVar.c;
                if (zgVar != null) {
                    zgVar.dispose();
                }
                sj<T> sjVar = this.b;
                if (sjVar instanceof zg) {
                    ((zg) sjVar).dispose();
                }
            }
        }
    }

    void E(a aVar) {
        synchronized (this) {
            if (aVar.d == 0 && aVar == this.g) {
                this.g = null;
                sh.dispose(aVar);
                sj<T> sjVar = this.b;
                if (sjVar instanceof zg) {
                    ((zg) sjVar).dispose();
                }
            }
        }
    }

    @Override // defpackage.og
    protected void w(sg<? super T> sgVar) {
        a aVar;
        boolean z;
        zg zgVar;
        synchronized (this) {
            aVar = this.g;
            if (aVar == null) {
                aVar = new a(this);
                this.g = aVar;
            }
            long j = aVar.d;
            if (j == 0 && (zgVar = aVar.c) != null) {
                zgVar.dispose();
            }
            long j2 = j + 1;
            aVar.d = j2;
            z = true;
            if (aVar.e || j2 != this.c) {
                z = false;
            } else {
                aVar.e = true;
            }
        }
        this.b.a(new b(sgVar, this, aVar));
        if (z) {
            this.b.C(aVar);
        }
    }

    public ti(sj<T> sjVar, int i, long j, TimeUnit timeUnit, tg tgVar) {
        this.b = sjVar;
        this.c = i;
        this.d = j;
        this.e = timeUnit;
        this.f = tgVar;
    }
}
