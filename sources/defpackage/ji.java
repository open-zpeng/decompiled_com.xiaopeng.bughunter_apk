package defpackage;
/* compiled from: ObservableDoOnEach.java */
/* renamed from: ji  reason: default package */
/* loaded from: classes.dex */
public final class ji<T> extends gi<T, T> {
    final mh<? super T> c;
    final mh<? super Throwable> d;
    final ih e;
    final ih f;

    /* compiled from: ObservableDoOnEach.java */
    /* renamed from: ji$a */
    /* loaded from: classes.dex */
    static final class a<T> implements sg<T>, zg {
        final sg<? super T> b;
        final mh<? super T> c;
        final mh<? super Throwable> d;
        final ih e;
        final ih f;
        zg g;
        boolean h;

        a(sg<? super T> sgVar, mh<? super T> mhVar, mh<? super Throwable> mhVar2, ih ihVar, ih ihVar2) {
            this.b = sgVar;
            this.c = mhVar;
            this.d = mhVar2;
            this.e = ihVar;
            this.f = ihVar2;
        }

        @Override // defpackage.zg
        public void dispose() {
            this.g.dispose();
        }

        @Override // defpackage.sg
        public void onComplete() {
            if (this.h) {
                return;
            }
            try {
                this.e.run();
                this.h = true;
                this.b.onComplete();
                try {
                    this.f.run();
                } catch (Throwable th) {
                    eh.b(th);
                    uj.m(th);
                }
            } catch (Throwable th2) {
                eh.b(th2);
                onError(th2);
            }
        }

        @Override // defpackage.sg
        public void onError(Throwable th) {
            if (this.h) {
                uj.m(th);
                return;
            }
            this.h = true;
            try {
                this.d.accept(th);
            } catch (Throwable th2) {
                eh.b(th2);
                th = new dh(th, th2);
            }
            this.b.onError(th);
            try {
                this.f.run();
            } catch (Throwable th3) {
                eh.b(th3);
                uj.m(th3);
            }
        }

        @Override // defpackage.sg
        public void onNext(T t) {
            if (this.h) {
                return;
            }
            try {
                this.c.accept(t);
                this.b.onNext(t);
            } catch (Throwable th) {
                eh.b(th);
                this.g.dispose();
                onError(th);
            }
        }

        @Override // defpackage.sg
        public void onSubscribe(zg zgVar) {
            if (sh.validate(this.g, zgVar)) {
                this.g = zgVar;
                this.b.onSubscribe(this);
            }
        }
    }

    public ji(rg<T> rgVar, mh<? super T> mhVar, mh<? super Throwable> mhVar2, ih ihVar, ih ihVar2) {
        super(rgVar);
        this.c = mhVar;
        this.d = mhVar2;
        this.e = ihVar;
        this.f = ihVar2;
    }

    @Override // defpackage.og
    public void w(sg<? super T> sgVar) {
        this.b.a(new a(sgVar, this.c, this.d, this.e, this.f));
    }
}
