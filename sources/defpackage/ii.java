package defpackage;

import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ObservableCreate.java */
/* renamed from: ii  reason: default package */
/* loaded from: classes.dex */
public final class ii<T> extends og<T> {
    final qg<T> b;

    /* compiled from: ObservableCreate.java */
    /* renamed from: ii$a */
    /* loaded from: classes.dex */
    static final class a<T> extends AtomicReference<zg> implements pg<T>, zg {
        private static final long serialVersionUID = -3434801548987643227L;
        final sg<? super T> b;

        a(sg<? super T> sgVar) {
            this.b = sgVar;
        }

        @Override // defpackage.pg
        public void a(lh lhVar) {
            c(new qh(lhVar));
        }

        @Override // defpackage.pg
        public boolean b() {
            return sh.isDisposed(get());
        }

        public void c(zg zgVar) {
            sh.set(this, zgVar);
        }

        public boolean d(Throwable th) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (b()) {
                return false;
            }
            try {
                this.b.onError(th);
                dispose();
                return true;
            } catch (Throwable th2) {
                dispose();
                throw th2;
            }
        }

        @Override // defpackage.zg
        public void dispose() {
            sh.dispose(this);
        }

        @Override // defpackage.lg
        public void onError(Throwable th) {
            if (d(th)) {
                return;
            }
            uj.m(th);
        }

        @Override // defpackage.lg
        public void onNext(T t) {
            if (t == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else if (b()) {
            } else {
                this.b.onNext(t);
            }
        }
    }

    public ii(qg<T> qgVar) {
        this.b = qgVar;
    }

    @Override // defpackage.og
    protected void w(sg<? super T> sgVar) {
        a aVar = new a(sgVar);
        sgVar.onSubscribe(aVar);
        try {
            this.b.subscribe(aVar);
        } catch (Throwable th) {
            eh.b(th);
            aVar.onError(th);
        }
    }
}
