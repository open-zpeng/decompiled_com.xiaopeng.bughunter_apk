package defpackage;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ObservablePublish.java */
/* renamed from: si  reason: default package */
/* loaded from: classes.dex */
public final class si<T> extends sj<T> {
    final rg<T> b;
    final AtomicReference<b<T>> c;
    final rg<T> d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservablePublish.java */
    /* renamed from: si$a */
    /* loaded from: classes.dex */
    public static final class a<T> extends AtomicReference<Object> implements zg {
        private static final long serialVersionUID = -1100270633763673112L;
        final sg<? super T> b;

        a(sg<? super T> sgVar) {
            this.b = sgVar;
        }

        void a(b<T> bVar) {
            if (compareAndSet(null, bVar)) {
                return;
            }
            bVar.c(this);
        }

        @Override // defpackage.zg
        public void dispose() {
            Object andSet = getAndSet(this);
            if (andSet == null || andSet == this) {
                return;
            }
            ((b) andSet).c(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservablePublish.java */
    /* renamed from: si$b */
    /* loaded from: classes.dex */
    public static final class b<T> implements sg<T>, zg {
        static final a[] b = new a[0];
        static final a[] c = new a[0];
        final AtomicReference<b<T>> d;
        final AtomicReference<zg> g = new AtomicReference<>();
        final AtomicReference<a<T>[]> e = new AtomicReference<>(b);
        final AtomicBoolean f = new AtomicBoolean();

        b(AtomicReference<b<T>> atomicReference) {
            this.d = atomicReference;
        }

        boolean a(a<T> aVar) {
            a<T>[] aVarArr;
            a<T>[] aVarArr2;
            do {
                aVarArr = this.e.get();
                if (aVarArr == c) {
                    return false;
                }
                int length = aVarArr.length;
                aVarArr2 = new a[length + 1];
                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                aVarArr2[length] = aVar;
            } while (!this.e.compareAndSet(aVarArr, aVarArr2));
            return true;
        }

        public boolean b() {
            return this.e.get() == c;
        }

        /* JADX WARN: Multi-variable type inference failed */
        void c(a<T> aVar) {
            a<T>[] aVarArr;
            a[] aVarArr2;
            do {
                aVarArr = this.e.get();
                int length = aVarArr.length;
                if (length == 0) {
                    return;
                }
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (aVarArr[i2].equals(aVar)) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    aVarArr2 = b;
                } else {
                    a[] aVarArr3 = new a[length - 1];
                    System.arraycopy(aVarArr, 0, aVarArr3, 0, i);
                    System.arraycopy(aVarArr, i + 1, aVarArr3, i, (length - i) - 1);
                    aVarArr2 = aVarArr3;
                }
            } while (!this.e.compareAndSet(aVarArr, aVarArr2));
        }

        @Override // defpackage.zg
        public void dispose() {
            AtomicReference<a<T>[]> atomicReference = this.e;
            a<T>[] aVarArr = c;
            if (atomicReference.getAndSet(aVarArr) != aVarArr) {
                this.d.compareAndSet(this, null);
                sh.dispose(this.g);
            }
        }

        @Override // defpackage.sg
        public void onComplete() {
            this.d.compareAndSet(this, null);
            for (a<T> aVar : this.e.getAndSet(c)) {
                aVar.b.onComplete();
            }
        }

        @Override // defpackage.sg
        public void onError(Throwable th) {
            this.d.compareAndSet(this, null);
            a<T>[] andSet = this.e.getAndSet(c);
            if (andSet.length != 0) {
                for (a<T> aVar : andSet) {
                    aVar.b.onError(th);
                }
                return;
            }
            uj.m(th);
        }

        @Override // defpackage.sg
        public void onNext(T t) {
            for (a<T> aVar : this.e.get()) {
                aVar.b.onNext(t);
            }
        }

        @Override // defpackage.sg
        public void onSubscribe(zg zgVar) {
            sh.setOnce(this.g, zgVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservablePublish.java */
    /* renamed from: si$c */
    /* loaded from: classes.dex */
    public static final class c<T> implements rg<T> {
        private final AtomicReference<b<T>> b;

        c(AtomicReference<b<T>> atomicReference) {
            this.b = atomicReference;
        }

        @Override // defpackage.rg
        public void a(sg<? super T> sgVar) {
            a aVar = new a(sgVar);
            sgVar.onSubscribe(aVar);
            while (true) {
                b<T> bVar = this.b.get();
                if (bVar == null || bVar.b()) {
                    b<T> bVar2 = new b<>(this.b);
                    if (this.b.compareAndSet(bVar, bVar2)) {
                        bVar = bVar2;
                    } else {
                        continue;
                    }
                }
                if (bVar.a(aVar)) {
                    aVar.a(bVar);
                    return;
                }
            }
        }
    }

    private si(rg<T> rgVar, rg<T> rgVar2, AtomicReference<b<T>> atomicReference) {
        this.d = rgVar;
        this.b = rgVar2;
        this.c = atomicReference;
    }

    public static <T> sj<T> E(rg<T> rgVar) {
        AtomicReference atomicReference = new AtomicReference();
        return uj.k(new si(new c(atomicReference), rgVar, atomicReference));
    }

    @Override // defpackage.sj
    public void C(mh<? super zg> mhVar) {
        b<T> bVar;
        while (true) {
            bVar = this.c.get();
            if (bVar != null && !bVar.b()) {
                break;
            }
            b<T> bVar2 = new b<>(this.c);
            if (this.c.compareAndSet(bVar, bVar2)) {
                bVar = bVar2;
                break;
            }
        }
        boolean z = true;
        if (bVar.f.get() || !bVar.f.compareAndSet(false, true)) {
            z = false;
        }
        try {
            mhVar.accept(bVar);
            if (z) {
                this.b.a(bVar);
            }
        } catch (Throwable th) {
            eh.b(th);
            throw oj.c(th);
        }
    }

    @Override // defpackage.og
    protected void w(sg<? super T> sgVar) {
        this.d.a(sgVar);
    }
}
