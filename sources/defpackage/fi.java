package defpackage;

import java.util.concurrent.atomic.AtomicReference;
/* compiled from: LambdaObserver.java */
/* renamed from: fi  reason: default package */
/* loaded from: classes.dex */
public final class fi<T> extends AtomicReference<zg> implements sg<T>, zg {
    private static final long serialVersionUID = -7251123623727029452L;
    final mh<? super T> b;
    final mh<? super Throwable> c;
    final ih d;
    final mh<? super zg> e;

    public fi(mh<? super T> mhVar, mh<? super Throwable> mhVar2, ih ihVar, mh<? super zg> mhVar3) {
        this.b = mhVar;
        this.c = mhVar2;
        this.d = ihVar;
        this.e = mhVar3;
    }

    public boolean a() {
        return get() == sh.DISPOSED;
    }

    @Override // defpackage.zg
    public void dispose() {
        sh.dispose(this);
    }

    @Override // defpackage.sg
    public void onComplete() {
        if (a()) {
            return;
        }
        lazySet(sh.DISPOSED);
        try {
            this.d.run();
        } catch (Throwable th) {
            eh.b(th);
            uj.m(th);
        }
    }

    @Override // defpackage.sg
    public void onError(Throwable th) {
        if (a()) {
            return;
        }
        lazySet(sh.DISPOSED);
        try {
            this.c.accept(th);
        } catch (Throwable th2) {
            eh.b(th2);
            uj.m(new dh(th, th2));
        }
    }

    @Override // defpackage.sg
    public void onNext(T t) {
        if (a()) {
            return;
        }
        try {
            this.b.accept(t);
        } catch (Throwable th) {
            eh.b(th);
            get().dispose();
            onError(th);
        }
    }

    @Override // defpackage.sg
    public void onSubscribe(zg zgVar) {
        if (sh.setOnce(this, zgVar)) {
            try {
                this.e.accept(this);
            } catch (Throwable th) {
                eh.b(th);
                zgVar.dispose();
                onError(th);
            }
        }
    }
}
