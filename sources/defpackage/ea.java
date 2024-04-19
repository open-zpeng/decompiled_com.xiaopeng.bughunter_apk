package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: UTDC.java */
/* renamed from: ea  reason: default package */
/* loaded from: classes.dex */
public class ea {
    private static Context a = null;
    private static boolean b = false;
    public static boolean c = false;
    private static boolean d = true;
    public static String e = String.valueOf(System.currentTimeMillis());
    public static final AtomicInteger f = new AtomicInteger(0);
    public static boolean g = true;
    public static sb h = null;
    public static boolean i = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UTDC.java */
    /* renamed from: ea$a */
    /* loaded from: classes.dex */
    public static class a implements Runnable {
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;
        final /* synthetic */ String f;
        final /* synthetic */ HashMap g;

        a(String str, String str2, String str3, String str4, String str5, HashMap hashMap) {
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = str4;
            this.f = str5;
            this.g = hashMap;
        }

        @Override // java.lang.Runnable
        public void run() {
            ya.c("UTDC", "[commit] page:", this.b, "eventId:", this.c, "arg1:", this.d, "arg2:", this.e, "arg3:", this.f, "args:", this.g);
            try {
                ka.h(this.c);
                oa.e().i(new qb(this.b, this.c, this.d, this.e, this.f, this.g));
            } catch (Throwable unused) {
            }
        }
    }

    public static sb a() {
        sb sbVar = h;
        if (sbVar == null || TextUtils.isEmpty(sbVar.getAppkey())) {
            if (!ya.g()) {
                Log.w("UTDC", "please Set <meta-data android:value=\"YOU KEY\" android:name=\"com.alibaba.apmplus.app_key\"></meta-data> in app AndroidManifest.xml ");
            } else {
                throw new RuntimeException("please Set <meta-data android:value=\"YOU KEY\" android:name=\"com.alibaba.apmplus.app_key\"></meta-data> in app AndroidManifest.xml ");
            }
        }
        return h;
    }

    public static synchronized void b(Context context) {
        synchronized (ea.class) {
            if (context == null) {
                ya.a("UTDC", "UTDC init failed ,context:" + context);
                return;
            }
            if (!b) {
                b = true;
                a = context.getApplicationContext();
                ub.d().f();
            }
        }
    }

    public static void c(sb sbVar) {
        h = sbVar;
        if (sbVar != null) {
            ra.j(sbVar.getAppkey());
        }
    }

    public static void d(String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        if (a == null) {
            ya.a("UTDC", "please call UTDC.init(context) before commit log,and this log will be discarded");
        } else if (h == null) {
            ya.a("UTDC", "please call UTDC.setRequestAuthentication(auth) before commit log,and this log will be discarded");
        } else {
            f(str, str2, str3, str4, str5, map);
        }
    }

    public static String e() {
        try {
            return bb.f(j())[0];
        } catch (Exception unused) {
            return "Unknown";
        }
    }

    private static void f(String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        ib.a().g(new a(str, str2, str3, str4, str5, new HashMap(map)));
    }

    public static String g() {
        try {
            String[] f2 = bb.f(j());
            return f2[0].equals("2G/3G") ? f2[1] : "Unknown";
        } catch (Exception unused) {
            return "Unknown";
        }
    }

    public static String h() {
        return "";
    }

    public static String i() {
        return "";
    }

    public static Context j() {
        return a;
    }

    public static void k() {
        ya.c("UTDC", "[onBackground]");
        c = true;
        ka.c();
    }

    public static void l() {
        ya.c("UTDC", "[onForeground]");
        c = false;
        ub.d().f();
    }

    public static void m() {
        ub.d().f();
    }

    public static void n(String str) {
        ra.i(str);
    }
}
