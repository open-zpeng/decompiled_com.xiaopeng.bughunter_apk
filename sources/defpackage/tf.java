package defpackage;

import android.app.ActivityThread;
import android.util.Log;
/* compiled from: LogUtils.java */
/* renamed from: tf  reason: default package */
/* loaded from: classes.dex */
public class tf {
    public static int a = 2;
    public static String b = k();
    public static b c = new a();
    public static boolean d = true;
    public static boolean e = false;

    /* compiled from: LogUtils.java */
    /* renamed from: tf$a */
    /* loaded from: classes.dex */
    public static class a implements b {
        @Override // defpackage.tf.b
        public void a(int i, String str, String str2, String str3) {
            if (i == 2) {
                Log.v(str2, str);
            } else if (i == 3) {
                Log.d(str2, str);
                String str4 = "DEBUG: " + str;
            } else if (i == 4) {
                Log.i(str2, str);
                String str5 = "INFO: " + str;
            } else if (i == 5) {
                Log.w(str2, str);
                String str6 = "WARN: " + str;
            } else if (i != 6) {
            } else {
                Log.e(str2, str);
                String str7 = "ERROR: " + str;
            }
        }
    }

    /* compiled from: LogUtils.java */
    /* renamed from: tf$b */
    /* loaded from: classes.dex */
    public interface b {
        void a(int i, String str, String str2, String str3);
    }

    public static void a(Object obj, String str) {
        if (n(3)) {
            e(3, obj, str, null, e);
        }
    }

    public static void b(Object obj, String str, Throwable th) {
        if (n(3)) {
            e(3, obj, str, th, e);
        }
    }

    public static void c(Object obj, Throwable th) {
        if (n(3)) {
            e(3, obj, "Exception occurs at", th, e);
        }
    }

    public static void d(String str) {
        if (n(3)) {
            e(3, null, str, null, e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void e(int r4, java.lang.Object r5, java.lang.String r6, java.lang.Throwable r7, boolean r8) {
        /*
            r0 = 0
            if (r8 == 0) goto L20
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            java.lang.StackTraceElement[] r1 = r1.getStackTrace()
            if (r1 == 0) goto L14
            int r2 = r1.length
            r3 = 4
            if (r2 <= r3) goto L14
            r1 = r1[r3]
            goto L15
        L14:
            r1 = r0
        L15:
            if (r1 == 0) goto L20
            java.lang.String r0 = r1.getFileName()
            int r1 = r1.getLineNumber()
            goto L21
        L20:
            r1 = 0
        L21:
            if (r8 != 0) goto L25
            if (r7 == 0) goto L29
        L25:
            java.lang.String r6 = p(r0, r1, r6, r7, r8)
        L29:
            java.lang.String r5 = q(r5)
            if (r5 != 0) goto L38
            boolean r5 = android.text.TextUtils.isEmpty(r0)
            if (r5 == 0) goto L39
            java.lang.String r0 = defpackage.tf.b
            goto L39
        L38:
            r0 = r5
        L39:
            o(r4, r0, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.tf.e(int, java.lang.Object, java.lang.String, java.lang.Throwable, boolean):void");
    }

    public static void f(Object obj, String str) {
        if (n(6)) {
            e(6, obj, str, null, e);
        }
    }

    public static void g(Object obj, String str, Throwable th) {
        if (n(6)) {
            e(6, obj, str, th, e);
        }
    }

    public static void h(Object obj, String str, Object... objArr) {
        if (n(6)) {
            e(6, obj, String.format(str, objArr), null, e);
        }
    }

    public static void i(Object obj, Throwable th) {
        if (n(6)) {
            e(6, obj, "Exception occurs at", th, e);
        }
    }

    public static void j(String str) {
        if (n(6)) {
            e(6, null, str, null, e);
        }
    }

    private static String k() {
        String[] split = ActivityThread.currentApplication().getPackageName().split("\\.");
        return split[split.length - 1];
    }

    public static void l(Object obj, String str) {
        if (n(4)) {
            e(4, obj, str, null, e);
        }
    }

    public static boolean m() {
        return d;
    }

    public static boolean n(int i) {
        return a <= i && m();
    }

    private static void o(int i, String str, String str2) {
        c.a(i, str2, str, null);
    }

    private static String p(String str, int i, String str2, Throwable th, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        if (z) {
            sb.append(" (T:");
            sb.append(Thread.currentThread().getId());
            sb.append(")");
            if (b != null) {
                sb.append("(C:");
                sb.append(b);
                sb.append(")");
            }
            sb.append("at (");
            if (str == null) {
                str = "";
            }
            sb.append(str);
            sb.append(":");
            sb.append(i);
            sb.append(")");
        }
        if (th != null) {
            sb.append('\n');
            sb.append(Log.getStackTraceString(th));
        }
        return sb.toString();
    }

    private static String q(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof Class) {
            return ((Class) obj).getSimpleName();
        }
        return obj.getClass().getSimpleName();
    }

    public static void r(Object obj, String str) {
        if (n(2)) {
            e(2, obj, str, null, e);
        }
    }

    public static void s(Object obj, String str) {
        if (n(5)) {
            e(5, obj, str, null, e);
        }
    }

    public static void t(Object obj, String str, Throwable th) {
        if (n(5)) {
            e(5, obj, str, th, e);
        }
    }

    public static void u(String str) {
        if (n(5)) {
            e(5, null, str, null, e);
        }
    }
}
