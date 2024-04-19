package defpackage;
/* compiled from: ObservableFilter.java */
/* renamed from: mi  reason: default package */
/* loaded from: classes.dex */
public final class mi<T> extends gi<T, T> {
    final ph<? super T> c;

    /* compiled from: ObservableFilter.java */
    /* renamed from: mi$a */
    /* loaded from: classes.dex */
    static final class a<T> extends bi<T, T> {
        final ph<? super T> g;

        a(sg<? super T> sgVar, ph<? super T> phVar) {
            super(sgVar);
            this.g = phVar;
        }

        @Override // defpackage.sg
        public void onNext(T t) {
            if (this.f == 0) {
                try {
                    if (this.g.test(t)) {
                        this.b.onNext(t);
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    c(th);
                    return;
                }
            }
            this.b.onNext(null);
        }

        @Override // defpackage.ai
        public T poll() throws Exception {
            T poll;
            do {
                poll = this.d.poll();
                if (poll == null) {
                    break;
                }
            } while (!this.g.test(poll));
            return poll;
        }

        @Override // defpackage.zh
        public int requestFusion(int i) {
            return d(i);
        }
    }

    public mi(rg<T> rgVar, ph<? super T> phVar) {
        super(rgVar);
        this.c = phVar;
    }

    @Override // defpackage.og
    public void w(sg<? super T> sgVar) {
        this.b.a(new a(sgVar, this.c));
    }
}
