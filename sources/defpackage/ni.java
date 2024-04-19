package defpackage;
/* compiled from: ObservableFromArray.java */
/* renamed from: ni  reason: default package */
/* loaded from: classes.dex */
public final class ni<T> extends og<T> {
    final T[] b;

    /* compiled from: ObservableFromArray.java */
    /* renamed from: ni$a */
    /* loaded from: classes.dex */
    static final class a<T> extends di<T> {
        final sg<? super T> b;
        final T[] c;
        int d;
        boolean e;
        volatile boolean f;

        a(sg<? super T> sgVar, T[] tArr) {
            this.b = sgVar;
            this.c = tArr;
        }

        public boolean a() {
            return this.f;
        }

        void b() {
            T[] tArr = this.c;
            int length = tArr.length;
            for (int i = 0; i < length && !a(); i++) {
                T t = tArr[i];
                if (t == null) {
                    sg<? super T> sgVar = this.b;
                    sgVar.onError(new NullPointerException("The " + i + "th element is null"));
                    return;
                }
                this.b.onNext(t);
            }
            if (a()) {
                return;
            }
            this.b.onComplete();
        }

        @Override // defpackage.ai
        public void clear() {
            this.d = this.c.length;
        }

        @Override // defpackage.zg
        public void dispose() {
            this.f = true;
        }

        @Override // defpackage.ai
        public boolean isEmpty() {
            return this.d == this.c.length;
        }

        @Override // defpackage.ai
        public T poll() {
            int i = this.d;
            T[] tArr = this.c;
            if (i != tArr.length) {
                this.d = i + 1;
                return (T) xh.d(tArr[i], "The array element is null");
            }
            return null;
        }

        @Override // defpackage.zh
        public int requestFusion(int i) {
            if ((i & 1) != 0) {
                this.e = true;
                return 1;
            }
            return 0;
        }
    }

    public ni(T[] tArr) {
        this.b = tArr;
    }

    @Override // defpackage.og
    public void w(sg<? super T> sgVar) {
        a aVar = new a(sgVar, this.b);
        sgVar.onSubscribe(aVar);
        if (aVar.e) {
            return;
        }
        aVar.b();
    }
}
