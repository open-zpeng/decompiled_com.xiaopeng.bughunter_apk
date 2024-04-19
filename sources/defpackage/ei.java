package defpackage;
/* compiled from: DisposableLambdaObserver.java */
/* renamed from: ei  reason: default package */
/* loaded from: classes.dex */
public final class ei<T> implements sg<T>, zg {
    final sg<? super T> b;
    final mh<? super zg> c;
    final ih d;
    zg e;

    public ei(sg<? super T> sgVar, mh<? super zg> mhVar, ih ihVar) {
        this.b = sgVar;
        this.c = mhVar;
        this.d = ihVar;
    }

    @Override // defpackage.zg
    public void dispose() {
        try {
            this.d.run();
        } catch (Throwable th) {
            eh.b(th);
            uj.m(th);
        }
        this.e.dispose();
    }

    @Override // defpackage.sg
    public void onComplete() {
        if (this.e != sh.DISPOSED) {
            this.b.onComplete();
        }
    }

    @Override // defpackage.sg
    public void onError(Throwable th) {
        if (this.e != sh.DISPOSED) {
            this.b.onError(th);
        } else {
            uj.m(th);
        }
    }

    @Override // defpackage.sg
    public void onNext(T t) {
        this.b.onNext(t);
    }

    @Override // defpackage.sg
    public void onSubscribe(zg zgVar) {
        try {
            this.c.accept(zgVar);
            if (sh.validate(this.e, zgVar)) {
                this.e = zgVar;
                this.b.onSubscribe(this);
            }
        } catch (Throwable th) {
            eh.b(th);
            zgVar.dispose();
            this.e = sh.DISPOSED;
            th.error(th, this.b);
        }
    }
}
