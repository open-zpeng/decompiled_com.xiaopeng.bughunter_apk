package defpackage;

import okhttp3.Call;
import okhttp3.Response;
/* compiled from: Response.java */
/* renamed from: ad  reason: default package */
/* loaded from: classes.dex */
public final class ad<T> {
    private T a;
    private Throwable b;
    private boolean c;
    private Call d;
    private Response e;

    public static <T> ad<T> c(boolean z, Call call, Response response, Throwable th) {
        ad<T> adVar = new ad<>();
        adVar.j(z);
        adVar.k(call);
        adVar.l(response);
        adVar.i(th);
        return adVar;
    }

    public static <T> ad<T> m(boolean z, T t, Call call, Response response) {
        ad<T> adVar = new ad<>();
        adVar.j(z);
        adVar.h(t);
        adVar.k(call);
        adVar.l(response);
        return adVar;
    }

    public T a() {
        return this.a;
    }

    public int b() {
        Response response = this.e;
        if (response == null) {
            return -1;
        }
        return response.code();
    }

    public Throwable d() {
        return this.b;
    }

    public Call e() {
        return this.d;
    }

    public Response f() {
        return this.e;
    }

    public String g() {
        Response response = this.e;
        if (response == null) {
            return null;
        }
        return response.message();
    }

    public void h(T t) {
        this.a = t;
    }

    public void i(Throwable th) {
        this.b = th;
    }

    public void j(boolean z) {
        this.c = z;
    }

    public void k(Call call) {
        this.d = call;
    }

    public void l(Response response) {
        this.e = response;
    }
}
