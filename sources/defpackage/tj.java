package defpackage;
/* compiled from: SerializedObserver.java */
/* renamed from: tj  reason: default package */
/* loaded from: classes.dex */
public final class tj<T> implements sg<T>, zg {
    final sg<? super T> b;
    final boolean c;
    zg d;
    boolean e;
    lj<Object> f;
    volatile boolean g;

    public tj(sg<? super T> sgVar) {
        this(sgVar, false);
    }

    void a() {
        lj<Object> ljVar;
        do {
            synchronized (this) {
                ljVar = this.f;
                if (ljVar == null) {
                    this.e = false;
                    return;
                }
                this.f = null;
            }
        } while (!ljVar.a((sg<? super T>) this.b));
    }

    @Override // defpackage.zg
    public void dispose() {
        this.d.dispose();
    }

    @Override // defpackage.sg
    public void onComplete() {
        if (this.g) {
            return;
        }
        synchronized (this) {
            if (this.g) {
                return;
            }
            if (this.e) {
                lj<Object> ljVar = this.f;
                if (ljVar == null) {
                    ljVar = new lj<>(4);
                    this.f = ljVar;
                }
                ljVar.b(pj.complete());
                return;
            }
            this.g = true;
            this.e = true;
            this.b.onComplete();
        }
    }

    @Override // defpackage.sg
    public void onError(Throwable th) {
        if (this.g) {
            uj.m(th);
            return;
        }
        synchronized (this) {
            boolean z = true;
            if (!this.g) {
                if (this.e) {
                    this.g = true;
                    lj<Object> ljVar = this.f;
                    if (ljVar == null) {
                        ljVar = new lj<>(4);
                        this.f = ljVar;
                    }
                    Object error = pj.error(th);
                    if (this.c) {
                        ljVar.b(error);
                    } else {
                        ljVar.c(error);
                    }
                    return;
                }
                this.g = true;
                this.e = true;
                z = false;
            }
            if (z) {
                uj.m(th);
            } else {
                this.b.onError(th);
            }
        }
    }

    @Override // defpackage.sg
    public void onNext(T t) {
        if (this.g) {
            return;
        }
        if (t == null) {
            this.d.dispose();
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        synchronized (this) {
            if (this.g) {
                return;
            }
            if (this.e) {
                lj<Object> ljVar = this.f;
                if (ljVar == null) {
                    ljVar = new lj<>(4);
                    this.f = ljVar;
                }
                ljVar.b(pj.next(t));
                return;
            }
            this.e = true;
            this.b.onNext(t);
            a();
        }
    }

    @Override // defpackage.sg
    public void onSubscribe(zg zgVar) {
        if (sh.validate(this.d, zgVar)) {
            this.d = zgVar;
            this.b.onSubscribe(this);
        }
    }

    public tj(sg<? super T> sgVar, boolean z) {
        this.b = sgVar;
        this.c = z;
    }
}
