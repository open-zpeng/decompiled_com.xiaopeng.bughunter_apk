package defpackage;
/* compiled from: ObservableMap.java */
/* renamed from: qi  reason: default package */
/* loaded from: classes.dex */
public final class qi<T, U> extends gi<T, U> {
    final nh<? super T, ? extends U> c;

    /* compiled from: ObservableMap.java */
    /* renamed from: qi$a */
    /* loaded from: classes.dex */
    static final class a<T, U> extends bi<T, U> {
        final nh<? super T, ? extends U> g;

        a(sg<? super U> sgVar, nh<? super T, ? extends U> nhVar) {
            super(sgVar);
            this.g = nhVar;
        }

        @Override // defpackage.sg
        public void onNext(T t) {
            if (this.e) {
                return;
            }
            if (this.f != 0) {
                this.b.onNext(null);
                return;
            }
            try {
                this.b.onNext(xh.d(this.g.apply(t), "The mapper function returned a null value."));
            } catch (Throwable th) {
                c(th);
            }
        }

        @Override // defpackage.ai
        public U poll() throws Exception {
            T poll = this.d.poll();
            if (poll != null) {
                return (U) xh.d(this.g.apply(poll), "The mapper function returned a null value.");
            }
            return null;
        }

        @Override // defpackage.zh
        public int requestFusion(int i) {
            return d(i);
        }
    }

    public qi(rg<T> rgVar, nh<? super T, ? extends U> nhVar) {
        super(rgVar);
        this.c = nhVar;
    }

    @Override // defpackage.og
    public void w(sg<? super U> sgVar) {
        this.b.a(new a(sgVar, this.c));
    }
}
