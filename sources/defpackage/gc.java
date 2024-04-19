package defpackage;
/* compiled from: NoneCacheRequestPolicy.java */
/* renamed from: gc  reason: default package */
/* loaded from: classes.dex */
public class gc<T> extends bc<T> {

    /* compiled from: NoneCacheRequestPolicy.java */
    /* renamed from: gc$a */
    /* loaded from: classes.dex */
    class a implements Runnable {
        final /* synthetic */ ad b;

        a(ad adVar) {
            this.b = adVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            gc.this.f.onSuccess(this.b);
            gc.this.f.onFinish();
        }
    }

    /* compiled from: NoneCacheRequestPolicy.java */
    /* renamed from: gc$b */
    /* loaded from: classes.dex */
    class b implements Runnable {
        final /* synthetic */ ad b;

        b(ad adVar) {
            this.b = adVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            gc.this.f.onError(this.b);
            gc.this.f.onFinish();
        }
    }

    /* compiled from: NoneCacheRequestPolicy.java */
    /* renamed from: gc$c */
    /* loaded from: classes.dex */
    class c implements Runnable {
        final /* synthetic */ zb b;

        c(zb zbVar) {
            this.b = zbVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            gc gcVar = gc.this;
            gcVar.f.onStart(gcVar.a);
            try {
                gc.this.e();
                zb zbVar = this.b;
                if (zbVar != null) {
                    gc.this.f.onCacheSuccess(ad.m(true, zbVar.c(), gc.this.e, null));
                    gc.this.f.onFinish();
                    return;
                }
                gc.this.f();
            } catch (Throwable th) {
                gc.this.f.onError(ad.c(false, gc.this.e, null, th));
            }
        }
    }

    public gc(hd<T, ? extends hd> hdVar) {
        super(hdVar);
    }

    @Override // defpackage.cc
    public void b(zb<T> zbVar, jc<T> jcVar) {
        this.f = jcVar;
        g(new c(zbVar));
    }

    @Override // defpackage.cc
    public void onError(ad<T> adVar) {
        g(new b(adVar));
    }

    @Override // defpackage.cc
    public void onSuccess(ad<T> adVar) {
        g(new a(adVar));
    }
}
