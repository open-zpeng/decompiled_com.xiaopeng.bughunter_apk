package defpackage;

import defpackage.tg;
/* compiled from: ObservableObserveOn.java */
/* renamed from: ri  reason: default package */
/* loaded from: classes.dex */
public final class ri<T> extends gi<T, T> {
    final tg c;
    final boolean d;
    final int e;

    /* compiled from: ObservableObserveOn.java */
    /* renamed from: ri$a */
    /* loaded from: classes.dex */
    static final class a<T> extends ci<T> implements sg<T>, Runnable {
        private static final long serialVersionUID = 6576896619930983584L;
        final sg<? super T> b;
        final tg.b c;
        final boolean d;
        final int e;
        ai<T> f;
        zg g;
        Throwable h;
        volatile boolean i;
        volatile boolean j;
        int k;
        boolean l;

        a(sg<? super T> sgVar, tg.b bVar, boolean z, int i) {
            this.b = sgVar;
            this.c = bVar;
            this.d = z;
            this.e = i;
        }

        boolean a(boolean z, boolean z2, sg<? super T> sgVar) {
            if (this.j) {
                this.f.clear();
                return true;
            } else if (z) {
                Throwable th = this.h;
                if (this.d) {
                    if (z2) {
                        if (th != null) {
                            sgVar.onError(th);
                        } else {
                            sgVar.onComplete();
                        }
                        this.c.dispose();
                        return true;
                    }
                    return false;
                } else if (th != null) {
                    this.f.clear();
                    sgVar.onError(th);
                    this.c.dispose();
                    return true;
                } else if (z2) {
                    sgVar.onComplete();
                    this.c.dispose();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        void b() {
            int i = 1;
            while (!this.j) {
                boolean z = this.i;
                Throwable th = this.h;
                if (!this.d && z && th != null) {
                    this.b.onError(th);
                    this.c.dispose();
                    return;
                }
                this.b.onNext(null);
                if (z) {
                    Throwable th2 = this.h;
                    if (th2 != null) {
                        this.b.onError(th2);
                    } else {
                        this.b.onComplete();
                    }
                    this.c.dispose();
                    return;
                }
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
        }

        void c() {
            ai<T> aiVar = this.f;
            sg<? super T> sgVar = this.b;
            int i = 1;
            while (!a(this.i, aiVar.isEmpty(), sgVar)) {
                while (true) {
                    boolean z = this.i;
                    try {
                        Object obj = (T) aiVar.poll();
                        boolean z2 = obj == null;
                        if (a(z, z2, sgVar)) {
                            return;
                        }
                        if (z2) {
                            i = addAndGet(-i);
                            if (i == 0) {
                                return;
                            }
                        } else {
                            sgVar.onNext(obj);
                        }
                    } catch (Throwable th) {
                        eh.b(th);
                        this.g.dispose();
                        aiVar.clear();
                        sgVar.onError(th);
                        this.c.dispose();
                        return;
                    }
                }
            }
        }

        @Override // defpackage.ai
        public void clear() {
            this.f.clear();
        }

        void d() {
            if (getAndIncrement() == 0) {
                this.c.b(this);
            }
        }

        @Override // defpackage.zg
        public void dispose() {
            if (this.j) {
                return;
            }
            this.j = true;
            this.g.dispose();
            this.c.dispose();
            if (getAndIncrement() == 0) {
                this.f.clear();
            }
        }

        @Override // defpackage.ai
        public boolean isEmpty() {
            return this.f.isEmpty();
        }

        @Override // defpackage.sg
        public void onComplete() {
            if (this.i) {
                return;
            }
            this.i = true;
            d();
        }

        @Override // defpackage.sg
        public void onError(Throwable th) {
            if (this.i) {
                uj.m(th);
                return;
            }
            this.h = th;
            this.i = true;
            d();
        }

        @Override // defpackage.sg
        public void onNext(T t) {
            if (this.i) {
                return;
            }
            if (this.k != 2) {
                this.f.offer(t);
            }
            d();
        }

        @Override // defpackage.sg
        public void onSubscribe(zg zgVar) {
            if (sh.validate(this.g, zgVar)) {
                this.g = zgVar;
                if (zgVar instanceof yh) {
                    yh yhVar = (yh) zgVar;
                    int requestFusion = yhVar.requestFusion(7);
                    if (requestFusion == 1) {
                        this.k = requestFusion;
                        this.f = yhVar;
                        this.i = true;
                        this.b.onSubscribe(this);
                        d();
                        return;
                    } else if (requestFusion == 2) {
                        this.k = requestFusion;
                        this.f = yhVar;
                        this.b.onSubscribe(this);
                        return;
                    }
                }
                this.f = new zi(this.e);
                this.b.onSubscribe(this);
            }
        }

        @Override // defpackage.ai
        public T poll() throws Exception {
            return this.f.poll();
        }

        @Override // defpackage.zh
        public int requestFusion(int i) {
            if ((i & 2) != 0) {
                this.l = true;
                return 2;
            }
            return 0;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.l) {
                b();
            } else {
                c();
            }
        }
    }

    public ri(rg<T> rgVar, tg tgVar, boolean z, int i) {
        super(rgVar);
        this.c = tgVar;
        this.d = z;
        this.e = i;
    }

    @Override // defpackage.og
    protected void w(sg<? super T> sgVar) {
        tg tgVar = this.c;
        if (tgVar instanceof kj) {
            this.b.a(sgVar);
            return;
        }
        this.b.a(new a(sgVar, tgVar.a(), this.d, this.e));
    }
}
