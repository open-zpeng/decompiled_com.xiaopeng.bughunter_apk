package defpackage;
/* compiled from: ObservableTake.java */
/* renamed from: xi  reason: default package */
/* loaded from: classes.dex */
public final class xi<T> extends gi<T, T> {
    final long c;

    /* compiled from: ObservableTake.java */
    /* renamed from: xi$a */
    /* loaded from: classes.dex */
    static final class a<T> implements sg<T>, zg {
        final sg<? super T> b;
        boolean c;
        zg d;
        long e;

        a(sg<? super T> sgVar, long j) {
            this.b = sgVar;
            this.e = j;
        }

        @Override // defpackage.zg
        public void dispose() {
            this.d.dispose();
        }

        @Override // defpackage.sg
        public void onComplete() {
            if (this.c) {
                return;
            }
            this.c = true;
            this.d.dispose();
            this.b.onComplete();
        }

        @Override // defpackage.sg
        public void onError(Throwable th) {
            if (this.c) {
                uj.m(th);
                return;
            }
            this.c = true;
            this.d.dispose();
            this.b.onError(th);
        }

        @Override // defpackage.sg
        public void onNext(T t) {
            if (this.c) {
                return;
            }
            long j = this.e;
            long j2 = j - 1;
            this.e = j2;
            if (j > 0) {
                boolean z = j2 == 0;
                this.b.onNext(t);
                if (z) {
                    onComplete();
                }
            }
        }

        @Override // defpackage.sg
        public void onSubscribe(zg zgVar) {
            if (sh.validate(this.d, zgVar)) {
                this.d = zgVar;
                if (this.e == 0) {
                    this.c = true;
                    zgVar.dispose();
                    th.complete(this.b);
                    return;
                }
                this.b.onSubscribe(this);
            }
        }
    }

    public xi(rg<T> rgVar, long j) {
        super(rgVar);
        this.c = j;
    }

    @Override // defpackage.og
    protected void w(sg<? super T> sgVar) {
        this.b.a(new a(sgVar, this.c));
    }
}
