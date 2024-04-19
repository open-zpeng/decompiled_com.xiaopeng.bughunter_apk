package defpackage;

import android.graphics.Bitmap;
import java.io.IOException;
import java.net.SocketTimeoutException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.Response;
/* compiled from: BaseCachePolicy.java */
/* renamed from: bc  reason: default package */
/* loaded from: classes.dex */
public abstract class bc<T> implements cc<T> {
    protected hd<T, ? extends hd> a;
    protected volatile boolean b;
    protected volatile int c = 0;
    protected boolean d;
    protected Call e;
    protected jc<T> f;
    protected zb<T> g;

    /* compiled from: BaseCachePolicy.java */
    /* renamed from: bc$a */
    /* loaded from: classes.dex */
    class a implements Callback {
        a() {
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            if ((iOException instanceof SocketTimeoutException) && bc.this.c < bc.this.a.r()) {
                bc.this.c++;
                bc bcVar = bc.this;
                bcVar.e = bcVar.a.p();
                if (bc.this.b) {
                    bc.this.e.cancel();
                } else {
                    bc.this.e.enqueue(this);
                }
            } else if (call.isCanceled()) {
            } else {
                bc.this.onError(ad.c(false, call, null, iOException));
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            int code = response.code();
            if (code != 404 && code < 500) {
                if (bc.this.d(call, response)) {
                    return;
                }
                try {
                    T convertResponse = bc.this.a.m().convertResponse(response);
                    bc.this.h(response.headers(), convertResponse);
                    bc.this.onSuccess(ad.m(false, convertResponse, call, response));
                    return;
                } catch (Throwable th) {
                    bc.this.onError(ad.c(false, call, response, th));
                    return;
                }
            }
            bc.this.onError(ad.c(false, call, response, uc.b()));
        }
    }

    public bc(hd<T, ? extends hd> hdVar) {
        this.a = hdVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(Headers headers, T t) {
        if (this.a.j() == ac.NO_CACHE || (t instanceof Bitmap)) {
            return;
        }
        zb<T> b = id.b(headers, t, this.a.j(), this.a.i());
        if (b == null) {
            oc.l().n(this.a.i());
        } else {
            oc.l().o(this.a.i(), b);
        }
    }

    @Override // defpackage.cc
    public zb<T> a() {
        if (this.a.i() == null) {
            hd<T, ? extends hd> hdVar = this.a;
            hdVar.b(jd.c(hdVar.h(), this.a.o().e));
        }
        if (this.a.j() == null) {
            this.a.c(ac.NO_CACHE);
        }
        ac j = this.a.j();
        if (j != ac.NO_CACHE) {
            zb<T> zbVar = (zb<T>) oc.l().j(this.a.i());
            this.g = zbVar;
            id.a(this.a, zbVar, j);
            zb<T> zbVar2 = this.g;
            if (zbVar2 != null && zbVar2.a(j, this.a.l(), System.currentTimeMillis())) {
                this.g.j(true);
            }
        }
        zb<T> zbVar3 = this.g;
        if (zbVar3 == null || zbVar3.g() || this.g.c() == null || this.g.f() == null) {
            this.g = null;
        }
        return this.g;
    }

    public boolean d(Call call, Response response) {
        return false;
    }

    public synchronized Call e() throws Throwable {
        if (!this.d) {
            this.d = true;
            this.e = this.a.p();
            if (this.b) {
                this.e.cancel();
            }
        } else {
            throw uc.a("Already executed!");
        }
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f() {
        this.e.enqueue(new a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(Runnable runnable) {
        wb.h().g().post(runnable);
    }
}
