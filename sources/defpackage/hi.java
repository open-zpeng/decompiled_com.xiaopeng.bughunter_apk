package defpackage;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ObservableConcatMap.java */
/* renamed from: hi  reason: default package */
/* loaded from: classes.dex */
public final class hi<T, U> extends gi<T, U> {
    final nh<? super T, ? extends rg<? extends U>> c;
    final int d;
    final nj e;

    /* compiled from: ObservableConcatMap.java */
    /* renamed from: hi$a */
    /* loaded from: classes.dex */
    static final class a<T, R> extends AtomicInteger implements sg<T>, zg {
        private static final long serialVersionUID = -6951100001833242599L;
        final sg<? super R> b;
        final nh<? super T, ? extends rg<? extends R>> c;
        final int d;
        final mj e = new mj();
        final C0042a<R> f;
        final boolean g;
        ai<T> h;
        zg i;
        volatile boolean j;
        volatile boolean k;
        volatile boolean l;
        int m;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ObservableConcatMap.java */
        /* renamed from: hi$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0042a<R> extends AtomicReference<zg> implements sg<R> {
            private static final long serialVersionUID = 2620149119579502636L;
            final sg<? super R> b;
            final a<?, R> c;

            C0042a(sg<? super R> sgVar, a<?, R> aVar) {
                this.b = sgVar;
                this.c = aVar;
            }

            void a() {
                sh.dispose(this);
            }

            @Override // defpackage.sg
            public void onComplete() {
                a<?, R> aVar = this.c;
                aVar.j = false;
                aVar.a();
            }

            @Override // defpackage.sg
            public void onError(Throwable th) {
                a<?, R> aVar = this.c;
                if (aVar.e.a(th)) {
                    if (!aVar.g) {
                        aVar.i.dispose();
                    }
                    aVar.j = false;
                    aVar.a();
                    return;
                }
                uj.m(th);
            }

            @Override // defpackage.sg
            public void onNext(R r) {
                this.b.onNext(r);
            }

            @Override // defpackage.sg
            public void onSubscribe(zg zgVar) {
                sh.replace(this, zgVar);
            }
        }

        a(sg<? super R> sgVar, nh<? super T, ? extends rg<? extends R>> nhVar, int i, boolean z) {
            this.b = sgVar;
            this.c = nhVar;
            this.d = i;
            this.g = z;
            this.f = new C0042a<>(sgVar, this);
        }

        void a() {
            if (getAndIncrement() != 0) {
                return;
            }
            sg<? super R> sgVar = this.b;
            ai<T> aiVar = this.h;
            mj mjVar = this.e;
            while (true) {
                if (!this.j) {
                    if (this.l) {
                        aiVar.clear();
                        return;
                    } else if (!this.g && mjVar.get() != null) {
                        aiVar.clear();
                        this.l = true;
                        sgVar.onError(mjVar.b());
                        return;
                    } else {
                        boolean z = this.k;
                        try {
                            T poll = aiVar.poll();
                            boolean z2 = poll == null;
                            if (z && z2) {
                                this.l = true;
                                Throwable b = mjVar.b();
                                if (b != null) {
                                    sgVar.onError(b);
                                    return;
                                } else {
                                    sgVar.onComplete();
                                    return;
                                }
                            } else if (!z2) {
                                try {
                                    rg rgVar = (rg) xh.d(this.c.apply(poll), "The mapper returned a null ObservableSource");
                                    if (rgVar instanceof Callable) {
                                        try {
                                            Object obj = (Object) ((Callable) rgVar).call();
                                            if (obj != 0 && !this.l) {
                                                sgVar.onNext(obj);
                                            }
                                        } catch (Throwable th) {
                                            eh.b(th);
                                            mjVar.a(th);
                                        }
                                    } else {
                                        this.j = true;
                                        rgVar.a(this.f);
                                    }
                                } catch (Throwable th2) {
                                    eh.b(th2);
                                    this.l = true;
                                    this.i.dispose();
                                    aiVar.clear();
                                    mjVar.a(th2);
                                    sgVar.onError(mjVar.b());
                                    return;
                                }
                            }
                        } catch (Throwable th3) {
                            eh.b(th3);
                            this.l = true;
                            this.i.dispose();
                            mjVar.a(th3);
                            sgVar.onError(mjVar.b());
                            return;
                        }
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
        }

        @Override // defpackage.zg
        public void dispose() {
            this.l = true;
            this.i.dispose();
            this.f.a();
        }

        @Override // defpackage.sg
        public void onComplete() {
            this.k = true;
            a();
        }

        @Override // defpackage.sg
        public void onError(Throwable th) {
            if (this.e.a(th)) {
                this.k = true;
                a();
                return;
            }
            uj.m(th);
        }

        @Override // defpackage.sg
        public void onNext(T t) {
            if (this.m == 0) {
                this.h.offer(t);
            }
            a();
        }

        @Override // defpackage.sg
        public void onSubscribe(zg zgVar) {
            if (sh.validate(this.i, zgVar)) {
                this.i = zgVar;
                if (zgVar instanceof yh) {
                    yh yhVar = (yh) zgVar;
                    int requestFusion = yhVar.requestFusion(3);
                    if (requestFusion == 1) {
                        this.m = requestFusion;
                        this.h = yhVar;
                        this.k = true;
                        this.b.onSubscribe(this);
                        a();
                        return;
                    } else if (requestFusion == 2) {
                        this.m = requestFusion;
                        this.h = yhVar;
                        this.b.onSubscribe(this);
                        return;
                    }
                }
                this.h = new zi(this.d);
                this.b.onSubscribe(this);
            }
        }
    }

    /* compiled from: ObservableConcatMap.java */
    /* renamed from: hi$b */
    /* loaded from: classes.dex */
    static final class b<T, U> extends AtomicInteger implements sg<T>, zg {
        private static final long serialVersionUID = 8828587559905699186L;
        final sg<? super U> b;
        final nh<? super T, ? extends rg<? extends U>> c;
        final a<U> d;
        final int e;
        ai<T> f;
        zg g;
        volatile boolean h;
        volatile boolean i;
        volatile boolean j;
        int k;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ObservableConcatMap.java */
        /* renamed from: hi$b$a */
        /* loaded from: classes.dex */
        public static final class a<U> extends AtomicReference<zg> implements sg<U> {
            private static final long serialVersionUID = -7449079488798789337L;
            final sg<? super U> b;
            final b<?, ?> c;

            a(sg<? super U> sgVar, b<?, ?> bVar) {
                this.b = sgVar;
                this.c = bVar;
            }

            void a() {
                sh.dispose(this);
            }

            @Override // defpackage.sg
            public void onComplete() {
                this.c.b();
            }

            @Override // defpackage.sg
            public void onError(Throwable th) {
                this.c.dispose();
                this.b.onError(th);
            }

            @Override // defpackage.sg
            public void onNext(U u) {
                this.b.onNext(u);
            }

            @Override // defpackage.sg
            public void onSubscribe(zg zgVar) {
                sh.set(this, zgVar);
            }
        }

        b(sg<? super U> sgVar, nh<? super T, ? extends rg<? extends U>> nhVar, int i) {
            this.b = sgVar;
            this.c = nhVar;
            this.e = i;
            this.d = new a<>(sgVar, this);
        }

        void a() {
            if (getAndIncrement() != 0) {
                return;
            }
            while (!this.i) {
                if (!this.h) {
                    boolean z = this.j;
                    try {
                        T poll = this.f.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            this.i = true;
                            this.b.onComplete();
                            return;
                        } else if (!z2) {
                            try {
                                rg rgVar = (rg) xh.d(this.c.apply(poll), "The mapper returned a null ObservableSource");
                                this.h = true;
                                rgVar.a(this.d);
                            } catch (Throwable th) {
                                eh.b(th);
                                dispose();
                                this.f.clear();
                                this.b.onError(th);
                                return;
                            }
                        }
                    } catch (Throwable th2) {
                        eh.b(th2);
                        dispose();
                        this.f.clear();
                        this.b.onError(th2);
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            this.f.clear();
        }

        void b() {
            this.h = false;
            a();
        }

        @Override // defpackage.zg
        public void dispose() {
            this.i = true;
            this.d.a();
            this.g.dispose();
            if (getAndIncrement() == 0) {
                this.f.clear();
            }
        }

        @Override // defpackage.sg
        public void onComplete() {
            if (this.j) {
                return;
            }
            this.j = true;
            a();
        }

        @Override // defpackage.sg
        public void onError(Throwable th) {
            if (this.j) {
                uj.m(th);
                return;
            }
            this.j = true;
            dispose();
            this.b.onError(th);
        }

        @Override // defpackage.sg
        public void onNext(T t) {
            if (this.j) {
                return;
            }
            if (this.k == 0) {
                this.f.offer(t);
            }
            a();
        }

        @Override // defpackage.sg
        public void onSubscribe(zg zgVar) {
            if (sh.validate(this.g, zgVar)) {
                this.g = zgVar;
                if (zgVar instanceof yh) {
                    yh yhVar = (yh) zgVar;
                    int requestFusion = yhVar.requestFusion(3);
                    if (requestFusion == 1) {
                        this.k = requestFusion;
                        this.f = yhVar;
                        this.j = true;
                        this.b.onSubscribe(this);
                        a();
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
    }

    public hi(rg<T> rgVar, nh<? super T, ? extends rg<? extends U>> nhVar, int i, nj njVar) {
        super(rgVar);
        this.c = nhVar;
        this.e = njVar;
        this.d = Math.max(8, i);
    }

    @Override // defpackage.og
    public void w(sg<? super U> sgVar) {
        if (vi.a(this.b, sgVar, this.c)) {
            return;
        }
        nj njVar = this.e;
        if (njVar == nj.IMMEDIATE) {
            this.b.a(new b(new tj(sgVar), this.c, this.d));
        } else {
            this.b.a(new a(sgVar, this.c, this.d, njVar == nj.END));
        }
    }
}
