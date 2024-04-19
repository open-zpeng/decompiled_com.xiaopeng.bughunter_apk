package defpackage;
/* compiled from: BasicFuseableObserver.java */
/* renamed from: bi  reason: default package */
/* loaded from: classes.dex */
public abstract class bi<T, R> implements sg<T>, yh<R> {
    protected final sg<? super R> b;
    protected zg c;
    protected yh<T> d;
    protected boolean e;
    protected int f;

    public bi(sg<? super R> sgVar) {
        this.b = sgVar;
    }

    protected void a() {
    }

    protected boolean b() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c(Throwable th) {
        eh.b(th);
        this.c.dispose();
        onError(th);
    }

    @Override // defpackage.ai
    public void clear() {
        this.d.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int d(int i) {
        yh<T> yhVar = this.d;
        if (yhVar == null || (i & 4) != 0) {
            return 0;
        }
        int requestFusion = yhVar.requestFusion(i);
        if (requestFusion != 0) {
            this.f = requestFusion;
        }
        return requestFusion;
    }

    @Override // defpackage.zg
    public void dispose() {
        this.c.dispose();
    }

    @Override // defpackage.ai
    public boolean isEmpty() {
        return this.d.isEmpty();
    }

    @Override // defpackage.ai
    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // defpackage.sg
    public void onComplete() {
        if (this.e) {
            return;
        }
        this.e = true;
        this.b.onComplete();
    }

    @Override // defpackage.sg
    public void onError(Throwable th) {
        if (this.e) {
            uj.m(th);
            return;
        }
        this.e = true;
        this.b.onError(th);
    }

    @Override // defpackage.sg
    public final void onSubscribe(zg zgVar) {
        if (sh.validate(this.c, zgVar)) {
            this.c = zgVar;
            if (zgVar instanceof yh) {
                this.d = (yh) zgVar;
            }
            if (b()) {
                this.b.onSubscribe(this);
                a();
            }
        }
    }
}
