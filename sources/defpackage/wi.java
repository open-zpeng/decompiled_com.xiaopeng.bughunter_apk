package defpackage;

import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ObservableSubscribeOn.java */
/* renamed from: wi  reason: default package */
/* loaded from: classes.dex */
public final class wi<T> extends gi<T, T> {
    final tg c;

    /* compiled from: ObservableSubscribeOn.java */
    /* renamed from: wi$a */
    /* loaded from: classes.dex */
    static final class a<T> extends AtomicReference<zg> implements sg<T>, zg {
        private static final long serialVersionUID = 8094547886072529208L;
        final sg<? super T> b;
        final AtomicReference<zg> c = new AtomicReference<>();

        a(sg<? super T> sgVar) {
            this.b = sgVar;
        }

        void a(zg zgVar) {
            sh.setOnce(this, zgVar);
        }

        @Override // defpackage.zg
        public void dispose() {
            sh.dispose(this.c);
            sh.dispose(this);
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
            sh.setOnce(this.c, zgVar);
        }
    }

    /* compiled from: ObservableSubscribeOn.java */
    /* renamed from: wi$b */
    /* loaded from: classes.dex */
    final class b implements Runnable {
        private final a<T> b;

        b(a<T> aVar) {
            this.b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            wi.this.b.a(this.b);
        }
    }

    public wi(rg<T> rgVar, tg tgVar) {
        super(rgVar);
        this.c = tgVar;
    }

    @Override // defpackage.og
    public void w(sg<? super T> sgVar) {
        a aVar = new a(sgVar);
        sgVar.onSubscribe(aVar);
        aVar.a(this.c.b(new b(aVar)));
    }
}
