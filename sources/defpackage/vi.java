package defpackage;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: ObservableScalarXMap.java */
/* renamed from: vi  reason: default package */
/* loaded from: classes.dex */
public final class vi {

    /* compiled from: ObservableScalarXMap.java */
    /* renamed from: vi$a */
    /* loaded from: classes.dex */
    public static final class a<T> extends AtomicInteger implements yh<T>, Runnable {
        private static final long serialVersionUID = 3880992722410194083L;
        final sg<? super T> b;
        final T c;

        public a(sg<? super T> sgVar, T t) {
            this.b = sgVar;
            this.c = t;
        }

        @Override // defpackage.ai
        public void clear() {
            lazySet(3);
        }

        @Override // defpackage.zg
        public void dispose() {
            set(3);
        }

        @Override // defpackage.ai
        public boolean isEmpty() {
            return get() != 1;
        }

        @Override // defpackage.ai
        public boolean offer(T t) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        @Override // defpackage.ai
        public T poll() throws Exception {
            if (get() == 1) {
                lazySet(3);
                return this.c;
            }
            return null;
        }

        @Override // defpackage.zh
        public int requestFusion(int i) {
            if ((i & 1) != 0) {
                lazySet(1);
                return 1;
            }
            return 0;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (get() == 0 && compareAndSet(0, 2)) {
                this.b.onNext((T) this.c);
                if (get() == 2) {
                    lazySet(3);
                    this.b.onComplete();
                }
            }
        }
    }

    public static <T, R> boolean a(rg<T> rgVar, sg<? super R> sgVar, nh<? super T, ? extends rg<? extends R>> nhVar) {
        if (rgVar instanceof Callable) {
            try {
                Object obj = (Object) ((Callable) rgVar).call();
                if (obj == 0) {
                    th.complete(sgVar);
                    return true;
                }
                try {
                    rg rgVar2 = (rg) xh.d(nhVar.apply(obj), "The mapper returned a null ObservableSource");
                    if (rgVar2 instanceof Callable) {
                        try {
                            Object call = ((Callable) rgVar2).call();
                            if (call == null) {
                                th.complete(sgVar);
                                return true;
                            }
                            a aVar = new a(sgVar, call);
                            sgVar.onSubscribe(aVar);
                            aVar.run();
                        } catch (Throwable th) {
                            eh.b(th);
                            th.error(th, sgVar);
                            return true;
                        }
                    } else {
                        rgVar2.a(sgVar);
                    }
                    return true;
                } catch (Throwable th2) {
                    eh.b(th2);
                    th.error(th2, sgVar);
                    return true;
                }
            } catch (Throwable th3) {
                eh.b(th3);
                th.error(th3, sgVar);
                return true;
            }
        }
        return false;
    }
}
