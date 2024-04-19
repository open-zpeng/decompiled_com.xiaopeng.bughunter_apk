package defpackage;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import defpackage.gd;
import defpackage.hd;
import java.io.IOException;
import java.io.Serializable;
import java.util.Map;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
/* compiled from: Request.java */
/* renamed from: hd  reason: default package */
/* loaded from: classes.dex */
public abstract class hd<T, R extends hd> implements Serializable {
    private static final long serialVersionUID = -7174118653689916252L;
    protected String b;
    protected String c;
    protected transient OkHttpClient d;
    protected transient Object e;
    protected int f;
    protected ac g;
    protected String h;
    protected long i;
    protected yc j = new yc();
    protected xc k = new xc();
    protected transient Request l;
    protected transient yb<T> m;
    protected transient jc<T> n;
    protected transient lc<T> o;
    protected transient cc<T> p;
    protected transient gd.c q;

    public hd(String str) {
        this.b = str;
        this.c = str;
        wb h = wb.h();
        String d = xc.d();
        if (!TextUtils.isEmpty(d)) {
            u("Accept-Language", d);
        }
        String i = xc.i();
        if (!TextUtils.isEmpty(i)) {
            u(HttpHeaders.USER_AGENT, i);
        }
        if (h.e() != null) {
            v(h.e());
        }
        if (h.d() != null) {
            t(h.d());
        }
        this.f = h.j();
        this.g = h.b();
        this.i = h.c();
    }

    public R A(Map<String, String> map, boolean... zArr) {
        this.j.l(map, zArr);
        return this;
    }

    public R B() {
        this.k.a();
        return this;
    }

    public R C() {
        this.j.a();
        return this;
    }

    public R D(String str) {
        this.k.n(str);
        return this;
    }

    public R E(String str) {
        this.j.m(str);
        return this;
    }

    public R F(Object obj) {
        this.e = obj;
        return this;
    }

    public yb<T> a() {
        yb<T> ybVar = this.m;
        return ybVar == null ? new xb(this) : ybVar;
    }

    public R b(String str) {
        jd.b(str, "cacheKey == null");
        this.h = str;
        return this;
    }

    public R c(ac acVar) {
        this.g = acVar;
        return this;
    }

    public Response d() throws IOException {
        return p().execute();
    }

    public void e(jc<T> jcVar) {
        jd.b(jcVar, "callback == null");
        this.n = jcVar;
        a().a(jcVar);
    }

    public abstract Request f(RequestBody requestBody);

    protected abstract RequestBody g();

    public String h() {
        return this.c;
    }

    public String i() {
        return this.h;
    }

    public ac j() {
        return this.g;
    }

    public cc<T> k() {
        return this.p;
    }

    public long l() {
        return this.i;
    }

    public lc<T> m() {
        if (this.o == null) {
            this.o = this.n;
        }
        jd.b(this.o, "converter == null, do you forget to call Request#converter(Converter<T>) ?");
        return this.o;
    }

    public xc n() {
        return this.k;
    }

    public yc o() {
        return this.j;
    }

    public Call p() {
        RequestBody g = g();
        if (g != null) {
            gd gdVar = new gd(g, this.n);
            gdVar.e(this.q);
            this.l = f(gdVar);
        } else {
            this.l = f(null);
        }
        if (this.d == null) {
            this.d = wb.h().i();
        }
        return this.d.newCall(this.l);
    }

    public Request q() {
        return this.l;
    }

    public int r() {
        return this.f;
    }

    public String s() {
        return this.b;
    }

    public R t(xc xcVar) {
        this.k.l(xcVar);
        return this;
    }

    public R u(String str, String str2) {
        this.k.m(str, str2);
        return this;
    }

    public R v(yc ycVar) {
        this.j.c(ycVar);
        return this;
    }

    public R w(String str, float f, boolean... zArr) {
        this.j.d(str, f, zArr);
        return this;
    }

    public R x(String str, int i, boolean... zArr) {
        this.j.e(str, i, zArr);
        return this;
    }

    public R y(String str, String str2, boolean... zArr) {
        this.j.j(str, str2, zArr);
        return this;
    }

    public R z(String str, boolean z, boolean... zArr) {
        this.j.k(str, z, zArr);
        return this;
    }
}
