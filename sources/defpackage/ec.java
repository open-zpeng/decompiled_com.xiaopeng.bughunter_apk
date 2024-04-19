package defpackage;
/* compiled from: FirstCacheRequestPolicy.java */
/* renamed from: ec  reason: default package */
/* loaded from: classes.dex */
public class ec<T> extends bc<T> {

    /* compiled from: FirstCacheRequestPolicy.java */
    /* renamed from: ec$a */
    /* loaded from: classes.dex */
    class a implements Runnable {
        final /* synthetic */ ad b;

        a(ad adVar) {
            this.b = adVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ec.this.f.onSuccess(this.b);
            ec.this.f.onFinish();
        }
    }

    /* compiled from: FirstCacheRequestPolicy.java */
    /* renamed from: ec$b */
    /* loaded from: classes.dex */
    class b implements Runnable {
        final /* synthetic */ ad b;

        b(ad adVar) {
            this.b = adVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ec.this.f.onError(this.b);
            ec.this.f.onFinish();
        }
    }

    /* compiled from: FirstCacheRequestPolicy.java */
    /* renamed from: ec$c */
    /* loaded from: classes.dex */
    class c implements Runnable {
        final /* synthetic */ zb b;

        c(zb zbVar) {
            this.b = zbVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ec ecVar = ec.this;
            ecVar.f.onStart(ecVar.a);
            try {
                ec.this.e();
                zb zbVar = this.b;
                if (zbVar != null) {
                    ec.this.f.onCacheSuccess(ad.m(true, zbVar.c(), ec.this.e, null));
                }
                ec.this.f();
            } catch (Throwable th) {
                ec.this.f.onError(ad.c(false, ec.this.e, null, th));
            }
        }
    }

    public ec(hd<T, ? extends hd> hdVar) {
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
