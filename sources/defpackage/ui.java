package defpackage;

import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: ObservableRetryPredicate.java */
/* renamed from: ui  reason: default package */
/* loaded from: classes.dex */
public final class ui<T> extends gi<T, T> {
    final ph<? super Throwable> c;
    final long d;

    /* compiled from: ObservableRetryPredicate.java */
    /* renamed from: ui$a */
    /* loaded from: classes.dex */
    static final class a<T> extends AtomicInteger implements sg<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final sg<? super T> b;
        final vh c;
        final rg<? extends T> d;
        final ph<? super Throwable> e;
        long f;

        a(sg<? super T> sgVar, long j, ph<? super Throwable> phVar, vh vhVar, rg<? extends T> rgVar) {
            this.b = sgVar;
            this.c = vhVar;
            this.d = rgVar;
            this.e = phVar;
            this.f = j;
        }

        void a() {
            if (getAndIncrement() == 0) {
                int i = 1;
                while (!this.c.a()) {
                    this.d.a(this);
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
        }

        @Override // defpackage.sg
        public void onComplete() {
            this.b.onComplete();
        }

        @Override // defpackage.sg
        public void onError(Throwable th) {
            long j = this.f;
            if (j != Long.MAX_VALUE) {
                this.f = j - 1;
            }
            if (j == 0) {
                this.b.onError(th);
                return;
            }
            try {
                if (!this.e.test(th)) {
                    this.b.onError(th);
                } else {
                    a();
                }
            } catch (Throwable th2) {
                eh.b(th2);
                this.b.onError(new dh(th, th2));
            }
        }

        @Override // defpackage.sg
        public void onNext(T t) {
            this.b.onNext(t);
        }

        @Override // defpackage.sg
        public void onSubscribe(zg zgVar) {
            this.c.c(zgVar);
        }
    }

    public ui(og<T> ogVar, long j, ph<? super Throwable> phVar) {
        super(ogVar);
        this.c = phVar;
        this.d = j;
    }

    @Override // defpackage.og
    public void w(sg<? super T> sgVar) {
        vh vhVar = new vh();
        sgVar.onSubscribe(vhVar);
        new a(sgVar, this.d, this.c, vhVar, this.b).a();
    }
}
