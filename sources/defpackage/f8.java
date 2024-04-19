package defpackage;

import android.app.Application;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* compiled from: AppMonitorDelegate.java */
/* renamed from: f8  reason: default package */
/* loaded from: classes.dex */
public final class f8 {
    public static boolean a = false;
    private static Application b = null;
    static volatile boolean c = false;

    /* compiled from: AppMonitorDelegate.java */
    /* renamed from: f8$a */
    /* loaded from: classes.dex */
    public static class a {
        @Deprecated
        public static boolean a(String str, String str2) {
            return n9.d(s8.ALARM, str, str2);
        }

        public static void b(String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    ka.a();
                    HashMap hashMap = new HashMap();
                    hashMap.put("_status", "0");
                    if (f8.c && fa.i()) {
                        s8 s8Var = s8.ALARM;
                        if (s8Var.isOpen() && (f8.a || n9.f(str, str2, Boolean.FALSE, hashMap))) {
                            ya.c("AppMonitorDelegate", "commitFail module:", str, " monitorPoint:", str2, " errorCode:", str4, "errorMsg:", str5);
                            ka.b();
                            r8.b().i(s8Var.a(), str, str2, str3, str4, str5, map);
                            return;
                        }
                    }
                    ya.a("log discard !", "");
                    return;
                }
                ya.a("AppMonitorDelegate", "module & monitorPoint must not null");
            } catch (Throwable th) {
                w8.d(th);
            }
        }

        public static void c(String str, String str2, String str3, String str4, Map<String, String> map) {
            b(str, str2, null, str3, str4, map);
        }

        public static void d(String str, String str2, String str3, Map<String, String> map) {
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    ka.a();
                    if (f8.c && fa.i()) {
                        s8 s8Var = s8.ALARM;
                        if (s8Var.isOpen() && (f8.a || n9.f(str, str2, Boolean.TRUE, null))) {
                            ya.c("AppMonitorDelegate", "commitSuccess module:", str, " monitorPoint:", str2);
                            ka.b();
                            r8.b().j(s8Var.a(), str, str2, str3, map);
                            return;
                        }
                    }
                    ya.a("log discard !", "");
                    return;
                }
                ya.a("AppMonitorDelegate", "module & monitorPoint must not null");
            } catch (Throwable th) {
                w8.d(th);
            }
        }

        public static void e(String str, String str2, Map<String, String> map) {
            d(str, str2, null, map);
        }

        public static void f(int i) {
            n9.a().c(s8.ALARM, i);
        }

        public static void g(int i) {
            s8 s8Var = s8.ALARM;
            s8Var.setStatisticsInterval(i);
            f8.l(s8Var, i);
        }
    }

    /* compiled from: AppMonitorDelegate.java */
    /* renamed from: f8$b */
    /* loaded from: classes.dex */
    public static class b {
        @Deprecated
        public static boolean a(String str, String str2) {
            return n9.d(s8.COUNTER, str, str2);
        }

        public static void b(String str, String str2, double d, Map<String, String> map) {
            c(str, str2, null, d, map);
        }

        public static void c(String str, String str2, String str3, double d, Map<String, String> map) {
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    ka.p();
                    if (f8.c && fa.i()) {
                        s8 s8Var = s8.COUNTER;
                        if (s8Var.isOpen()) {
                            if (f8.a || n9.d(s8Var, str, str2)) {
                                ya.c("AppMonitorDelegate", "commitCount module: ", str, " monitorPoint: ", str2, " value: ", Double.valueOf(d));
                                ka.q();
                                r8.b().h(s8Var.a(), str, str2, str3, d, map);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                ya.a("AppMonitorDelegate", "module & monitorPoint must not null");
            } catch (Throwable th) {
                w8.d(th);
            }
        }

        public static void d(int i) {
            n9.a().c(s8.COUNTER, i);
        }

        public static void e(int i) {
            s8 s8Var = s8.COUNTER;
            s8Var.setStatisticsInterval(i);
            f8.l(s8Var, i);
        }
    }

    /* compiled from: AppMonitorDelegate.java */
    /* renamed from: f8$c */
    /* loaded from: classes.dex */
    public static class c {
        @Deprecated
        public static boolean a(String str, String str2) {
            return n9.d(s8.OFFLINE_COUNTER, str, str2);
        }

        public static void b(String str, String str2, double d) {
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    ka.n();
                    if (f8.c && fa.i()) {
                        s8 s8Var = s8.OFFLINE_COUNTER;
                        if (s8Var.isOpen()) {
                            if (f8.a || n9.d(s8Var, str, str2)) {
                                ya.c("AppMonitorDelegate", "commitOffLineCount module: ", str, " monitorPoint: ", str2, " value: ", Double.valueOf(d));
                                ka.o();
                                r8.b().h(s8Var.a(), str, str2, null, d, null);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                ya.a("AppMonitorDelegate", "module & monitorPoint must not null");
            } catch (Throwable th) {
                w8.d(th);
            }
        }

        public static void c(int i) {
            n9.a().c(s8.OFFLINE_COUNTER, i);
        }

        public static void d(int i) {
            s8 s8Var = s8.OFFLINE_COUNTER;
            s8Var.setStatisticsInterval(i);
            f8.l(s8Var, i);
        }
    }

    /* compiled from: AppMonitorDelegate.java */
    /* renamed from: f8$d */
    /* loaded from: classes.dex */
    public static class d {
        public static void a(String str, String str2, String str3) {
            try {
                if (f8.c && fa.i()) {
                    s8 s8Var = s8.STAT;
                    if (s8Var.isOpen()) {
                        if (f8.a || n9.d(s8Var, str, str2)) {
                            ya.c("AppMonitorDelegate", "statEvent begin. module: ", str, " monitorPoint: ", str2, " measureName: ", str3);
                            r8.b().l(Integer.valueOf(s8Var.a()), str, str2, str3);
                        }
                    }
                }
            } catch (Throwable th) {
                w8.d(th);
            }
        }

        @Deprecated
        public static boolean b(String str, String str2) {
            return n9.d(s8.STAT, str, str2);
        }

        public static void c(String str, String str2, double d, Map<String, String> map) {
            d(str, str2, null, d, map);
        }

        public static void d(String str, String str2, v9 v9Var, double d, Map<String, String> map) {
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    ka.l();
                    if (f8.c && fa.i()) {
                        s8 s8Var = s8.STAT;
                        if (s8Var.isOpen()) {
                            if (f8.a || n9.d(s8Var, str, str2)) {
                                ya.c("AppMonitorDelegate", "statEvent commit. module: ", str, " monitorPoint: ", str2);
                                aa b = ba.c().b(str, str2);
                                ka.m();
                                if (b != null) {
                                    List<w9> e = b.e().e();
                                    if (e.size() == 1) {
                                        e(str, str2, v9Var, ((z9) y8.a().b(z9.class, new Object[0])).i(e.get(0).d(), d), map);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                ya.a("AppMonitorDelegate", "module & monitorPoint must not null");
            } catch (Throwable th) {
                w8.d(th);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x003a, code lost:
            if (defpackage.n9.e(r1, r11, r12, r13 != null ? r13.g() : null) != false) goto L21;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static void e(java.lang.String r11, java.lang.String r12, defpackage.v9 r13, defpackage.z9 r14, java.util.Map<java.lang.String, java.lang.String> r15) {
            /*
                boolean r1 = android.text.TextUtils.isEmpty(r11)     // Catch: java.lang.Throwable -> L7d
                if (r1 != 0) goto L75
                boolean r1 = android.text.TextUtils.isEmpty(r12)     // Catch: java.lang.Throwable -> L7d
                if (r1 == 0) goto Le
                goto L75
            Le:
                defpackage.ka.l()     // Catch: java.lang.Throwable -> L7d
                boolean r1 = defpackage.f8.c     // Catch: java.lang.Throwable -> L7d
                r2 = 3
                java.lang.String r3 = " monitorPoint: "
                r5 = 2
                r6 = 1
                r7 = 0
                r8 = 4
                if (r1 == 0) goto L63
                boolean r1 = defpackage.fa.i()     // Catch: java.lang.Throwable -> L7d
                if (r1 == 0) goto L63
                s8 r1 = defpackage.s8.STAT     // Catch: java.lang.Throwable -> L7d
                boolean r9 = r1.isOpen()     // Catch: java.lang.Throwable -> L7d
                if (r9 == 0) goto L63
                boolean r9 = defpackage.f8.a     // Catch: java.lang.Throwable -> L7d
                if (r9 != 0) goto L3c
                if (r13 == 0) goto L35
                java.util.Map r9 = r13.g()     // Catch: java.lang.Throwable -> L7d
                goto L36
            L35:
                r9 = 0
            L36:
                boolean r9 = defpackage.n9.e(r1, r11, r12, r9)     // Catch: java.lang.Throwable -> L7d
                if (r9 == 0) goto L63
            L3c:
                java.lang.String r9 = "statEvent commit success"
                java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch: java.lang.Throwable -> L7d
                java.lang.String r10 = "statEvent commit. module: "
                r8[r7] = r10     // Catch: java.lang.Throwable -> L7d
                r8[r6] = r11     // Catch: java.lang.Throwable -> L7d
                r8[r5] = r3     // Catch: java.lang.Throwable -> L7d
                r8[r2] = r12     // Catch: java.lang.Throwable -> L7d
                defpackage.ya.c(r9, r8)     // Catch: java.lang.Throwable -> L7d
                defpackage.ka.m()     // Catch: java.lang.Throwable -> L7d
                r8 r2 = defpackage.r8.b()     // Catch: java.lang.Throwable -> L7d
                int r3 = r1.a()     // Catch: java.lang.Throwable -> L7d
                r1 = r2
                r2 = r3
                r3 = r11
                r4 = r12
                r5 = r14
                r6 = r13
                r7 = r15
                r1.g(r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L7d
                goto L81
            L63:
                java.lang.String r1 = "statEvent commit failed,log discard"
                java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch: java.lang.Throwable -> L7d
                java.lang.String r9 = " ,. module: "
                r8[r7] = r9     // Catch: java.lang.Throwable -> L7d
                r8[r6] = r11     // Catch: java.lang.Throwable -> L7d
                r8[r5] = r3     // Catch: java.lang.Throwable -> L7d
                r8[r2] = r12     // Catch: java.lang.Throwable -> L7d
                defpackage.ya.c(r1, r8)     // Catch: java.lang.Throwable -> L7d
                goto L81
            L75:
                java.lang.String r0 = "AppMonitorDelegate"
                java.lang.String r1 = "module & monitorPoint must not null"
                defpackage.ya.a(r0, r1)     // Catch: java.lang.Throwable -> L7d
                return
            L7d:
                r0 = move-exception
                defpackage.w8.d(r0)
            L81:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.f8.d.e(java.lang.String, java.lang.String, v9, z9, java.util.Map):void");
        }

        public static void f(String str, String str2, String str3) {
            try {
                if (f8.c && fa.i()) {
                    s8 s8Var = s8.STAT;
                    if (s8Var.isOpen()) {
                        if (f8.a || n9.d(s8Var, str, str2)) {
                            ya.c("AppMonitorDelegate", "statEvent end. module: ", str, " monitorPoint: ", str2, " measureName: ", str3);
                            r8.b().o(str, str2, str3);
                        }
                    }
                }
            } catch (Throwable th) {
                w8.d(th);
            }
        }

        public static void g(int i) {
            n9.a().c(s8.STAT, i);
        }

        public static void h(int i) {
            s8 s8Var = s8.STAT;
            s8Var.setStatisticsInterval(i);
            f8.l(s8Var, i);
        }
    }

    public static synchronized void a() {
        synchronized (f8.class) {
            try {
                ya.c("AppMonitorDelegate", "start destory");
                if (c) {
                    d9.c();
                    d9.d();
                    x8.a();
                    Application application = b;
                    if (application != null) {
                        bb.e(application.getApplicationContext());
                    }
                    c = false;
                }
            } finally {
            }
        }
    }

    public static void b(boolean z) {
        ya.c("AppMonitorDelegate", "[enableLog]");
        ya.e(z);
    }

    public static synchronized void c(Application application) {
        synchronized (f8.class) {
            ya.c("AppMonitorDelegate", "start init");
            if (!c) {
                b = application;
                ea.b(application.getApplicationContext());
                x8.b();
                d9.e();
                m8.b(application);
                bb.d(application.getApplicationContext());
                c = true;
            }
        }
    }

    public static void d(String str, String str2, x9 x9Var) {
        e(str, str2, x9Var, null);
    }

    public static void e(String str, String str2, x9 x9Var, u9 u9Var) {
        f(str, str2, x9Var, u9Var, false);
    }

    public static void f(String str, String str2, x9 x9Var, u9 u9Var, boolean z) {
        try {
            if (c) {
                if (!q9.b(str) && !q9.b(str2)) {
                    ba.c().a(new aa(str, str2, x9Var, u9Var, z));
                    return;
                }
                ya.c("AppMonitorDelegate", "register stat event. module: ", str, " monitorPoint: ", str2);
                if (a) {
                    throw new v8("register error. module and monitorPoint can't be null");
                }
            }
        } catch (Throwable th) {
            w8.d(th);
        }
    }

    public static void g(String str, String str2, x9 x9Var, boolean z) {
        f(str, str2, x9Var, null, z);
    }

    public static void h(String str) {
        ea.n(str);
    }

    public static void i(boolean z, String str, String str2, String str3) {
        sb rbVar;
        if (z) {
            rbVar = new tb(str, str3);
        } else {
            rbVar = new rb(str, str2, "1".equalsIgnoreCase(str3));
        }
        ea.c(rbVar);
        fa.d(b);
    }

    public static void j(int i) {
        s8[] values;
        ya.c("AppMonitorDelegate", "[setSampling]");
        for (s8 s8Var : s8.values()) {
            s8Var.c(i);
            n9.a().c(s8Var, i);
        }
    }

    public static void k(int i) {
        s8[] values;
        for (s8 s8Var : s8.values()) {
            s8Var.setStatisticsInterval(i);
            l(s8Var, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void l(s8 s8Var, int i) {
        try {
            if (c && s8Var != null) {
                d9.b(s8Var.a(), i);
                if (i > 0) {
                    s8Var.b(true);
                } else {
                    s8Var.b(false);
                }
            }
        } catch (Throwable th) {
            w8.d(th);
        }
    }

    public static synchronized void m() {
        synchronized (f8.class) {
            try {
                ya.c("AppMonitorDelegate", "triggerUpload");
                if (c && fa.i()) {
                    d9.c();
                }
            } finally {
            }
        }
    }

    public static void n() {
        ya.c("AppMonitorDelegate", "[turnOffRealTimeDebug]");
    }

    public static void o(Map<String, String> map) {
        fa.q(map);
    }
}
