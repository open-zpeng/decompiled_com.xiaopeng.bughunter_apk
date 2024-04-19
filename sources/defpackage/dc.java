package defpackage;

import okhttp3.Call;
import okhttp3.Response;
/* compiled from: DefaultCachePolicy.java */
/* renamed from: dc  reason: default package */
/* loaded from: classes.dex */
public class dc<T> extends bc<T> {

    /* compiled from: DefaultCachePolicy.java */
    /* renamed from: dc$a */
    /* loaded from: classes.dex */
    class a implements Runnable {
        final /* synthetic */ ad b;

        a(ad adVar) {
            this.b = adVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            dc.this.f.onSuccess(this.b);
            dc.this.f.onFinish();
        }
    }

    /* compiled from: DefaultCachePolicy.java */
    /* renamed from: dc$b */
    /* loaded from: classes.dex */
    class b implements Runnable {
        final /* synthetic */ ad b;

        b(ad adVar) {
            this.b = adVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            dc.this.f.onError(this.b);
            dc.this.f.onFinish();
        }
    }

    /* compiled from: DefaultCachePolicy.java */
    /* renamed from: dc$c */
    /* loaded from: classes.dex */
    class c implements Runnable {
        final /* synthetic */ ad b;

        c(ad adVar) {
            this.b = adVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            dc.this.f.onError(this.b);
            dc.this.f.onFinish();
        }
    }

    /* compiled from: DefaultCachePolicy.java */
    /* renamed from: dc$d */
    /* loaded from: classes.dex */
    class d implements Runnable {
        final /* synthetic */ ad b;

        d(ad adVar) {
            this.b = adVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            dc.this.f.onCacheSuccess(this.b);
            dc.this.f.onFinish();
        }
    }

    /* compiled from: DefaultCachePolicy.java */
    /* renamed from: dc$e */
    /* loaded from: classes.dex */
    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            dc dcVar = dc.this;
            dcVar.f.onStart(dcVar.a);
            try {
                dc.this.e();
                dc.this.f();
            } catch (Throwable th) {
                dc.this.f.onError(ad.c(false, dc.this.e, null, th));
            }
        }
    }

    public dc(hd<T, ? extends hd> hdVar) {
        super(hdVar);
    }

    @Override // defpackage.cc
    public void b(zb<T> zbVar, jc<T> jcVar) {
        this.f = jcVar;
        g(new e());
    }

    @Override // defpackage.bc
    public boolean d(Call call, Response response) {
        if (response.code() != 304) {
            return false;
        }
        zb<T> zbVar = this.g;
        if (zbVar == null) {
            g(new c(ad.c(true, call, response, tc.a(this.a.i()))));
        } else {
            g(new d(ad.m(true, zbVar.c(), call, response)));
        }
        return true;
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
