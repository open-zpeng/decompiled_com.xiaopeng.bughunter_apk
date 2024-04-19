package defpackage;
/* compiled from: NoCachePolicy.java */
/* renamed from: fc  reason: default package */
/* loaded from: classes.dex */
public class fc<T> extends bc<T> {

    /* compiled from: NoCachePolicy.java */
    /* renamed from: fc$a */
    /* loaded from: classes.dex */
    class a implements Runnable {
        final /* synthetic */ ad b;

        a(ad adVar) {
            this.b = adVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            fc.this.f.onSuccess(this.b);
            fc.this.f.onFinish();
        }
    }

    /* compiled from: NoCachePolicy.java */
    /* renamed from: fc$b */
    /* loaded from: classes.dex */
    class b implements Runnable {
        final /* synthetic */ ad b;

        b(ad adVar) {
            this.b = adVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            fc.this.f.onError(this.b);
            fc.this.f.onFinish();
        }
    }

    /* compiled from: NoCachePolicy.java */
    /* renamed from: fc$c */
    /* loaded from: classes.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            fc fcVar = fc.this;
            fcVar.f.onStart(fcVar.a);
            try {
                fc.this.e();
                fc.this.f();
            } catch (Throwable th) {
                fc.this.f.onError(ad.c(false, fc.this.e, null, th));
            }
        }
    }

    public fc(hd<T, ? extends hd> hdVar) {
        super(hdVar);
    }

    @Override // defpackage.cc
    public void b(zb<T> zbVar, jc<T> jcVar) {
        this.f = jcVar;
        g(new c());
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
