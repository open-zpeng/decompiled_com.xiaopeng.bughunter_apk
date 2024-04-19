package defpackage;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import defpackage.vc;
import defpackage.wc;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import okhttp3.Call;
import okhttp3.OkHttpClient;
/* compiled from: OkGo.java */
/* renamed from: wb  reason: default package */
/* loaded from: classes.dex */
public class wb {
    public static long a = 300;
    private Application b;
    private Handler c;
    private OkHttpClient d;
    private yc e;
    private xc f;
    private int g;
    private ac h;
    private long i;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: OkGo.java */
    /* renamed from: wb$b */
    /* loaded from: classes.dex */
    public static class b {
        private static wb a = new wb();
    }

    public static wb h() {
        return b.a;
    }

    public void a(Object obj) {
        if (obj == null) {
            return;
        }
        for (Call call : i().dispatcher().queuedCalls()) {
            if (obj.equals(call.request().tag())) {
                call.cancel();
            }
        }
        for (Call call2 : i().dispatcher().runningCalls()) {
            if (obj.equals(call2.request().tag())) {
                call2.cancel();
            }
        }
    }

    public ac b() {
        return this.h;
    }

    public long c() {
        return this.i;
    }

    public xc d() {
        return this.f;
    }

    public yc e() {
        return this.e;
    }

    public Context f() {
        jd.b(this.b, "please call OkGo.getInstance().init() first in application!");
        return this.b;
    }

    public Handler g() {
        return this.c;
    }

    public OkHttpClient i() {
        jd.b(this.d, "please call OkGo.getInstance().setOkHttpClient() first in application!");
        return this.d;
    }

    public int j() {
        return this.g;
    }

    public wb k(Application application) {
        this.b = application;
        return this;
    }

    public wb l(OkHttpClient okHttpClient) {
        jd.b(okHttpClient, "okHttpClient == null");
        this.d = okHttpClient;
        return this;
    }

    public wb m(int i) {
        if (i >= 0) {
            this.g = i;
            return this;
        }
        throw new IllegalArgumentException("retryCount must > 0");
    }

    private wb() {
        this.c = new Handler(Looper.getMainLooper());
        this.g = 3;
        this.i = -1L;
        this.h = ac.NO_CACHE;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        wc wcVar = new wc("OkGo");
        wcVar.h(wc.a.BODY);
        wcVar.g(Level.INFO);
        builder.addInterceptor(wcVar);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        builder.readTimeout(60000L, timeUnit);
        builder.writeTimeout(60000L, timeUnit);
        builder.connectTimeout(60000L, timeUnit);
        vc.c b2 = vc.b();
        builder.sslSocketFactory(b2.a, b2.b);
        builder.hostnameVerifier(vc.b);
        this.d = builder.build();
    }
}
