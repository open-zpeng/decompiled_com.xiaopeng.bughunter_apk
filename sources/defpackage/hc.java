package defpackage;
/* compiled from: RequestFailedCachePolicy.java */
/* renamed from: hc  reason: default package */
/* loaded from: classes.dex */
public class hc<T> extends bc<T> {

    /* compiled from: RequestFailedCachePolicy.java */
    /* renamed from: hc$a */
    /* loaded from: classes.dex */
    class a implements Runnable {
        final /* synthetic */ ad b;

        a(ad adVar) {
            this.b = adVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            hc.this.f.onSuccess(this.b);
            hc.this.f.onFinish();
        }
    }

    /* compiled from: RequestFailedCachePolicy.java */
    /* renamed from: hc$b */
    /* loaded from: classes.dex */
    class b implements Runnable {
        final /* synthetic */ ad b;

        b(ad adVar) {
            this.b = adVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            hc.this.f.onCacheSuccess(this.b);
            hc.this.f.onFinish();
        }
    }

    /* compiled from: RequestFailedCachePolicy.java */
    /* renamed from: hc$c */
    /* loaded from: classes.dex */
    class c implements Runnable {
        final /* synthetic */ ad b;

        c(ad adVar) {
            this.b = adVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            hc.this.f.onError(this.b);
            hc.this.f.onFinish();
        }
    }

    /* compiled from: RequestFailedCachePolicy.java */
    /* renamed from: hc$d */
    /* loaded from: classes.dex */
    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            hc hcVar = hc.this;
            hcVar.f.onStart(hcVar.a);
            try {
                hc.this.e();
                hc.this.f();
            } catch (Throwable th) {
                hc.this.f.onError(ad.c(false, hc.this.e, null, th));
            }
        }
    }

    public hc(hd<T, ? extends hd> hdVar) {
        super(hdVar);
    }

    @Override // defpackage.cc
    public void b(zb<T> zbVar, jc<T> jcVar) {
        this.f = jcVar;
        g(new d());
    }

    @Override // defpackage.cc
    public void onError(ad<T> adVar) {
        zb<T> zbVar = this.g;
        if (zbVar != null) {
            g(new b(ad.m(true, zbVar.c(), adVar.e(), adVar.f())));
        } else {
            g(new c(adVar));
        }
    }

    @Override // defpackage.cc
    public void onSuccess(ad<T> adVar) {
        g(new a(adVar));
    }
}
