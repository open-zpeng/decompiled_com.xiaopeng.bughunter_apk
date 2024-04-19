package defpackage;
/* compiled from: TransactionDelegate.java */
/* renamed from: l8  reason: default package */
/* loaded from: classes.dex */
public class l8 {
    private static void a(k8 k8Var) {
        if (k8Var == null || k8Var.e == null) {
            return;
        }
        r8.b().m(k8Var.f, k8Var.b, k8Var.c, k8Var.d, v9.f().d(k8Var.e));
    }

    public static void b(k8 k8Var, String str) {
        try {
            if (f8.c && k8Var != null) {
                ya.c("TransactionDelegate", "statEvent begin. module: ", k8Var.c, " monitorPoint: ", k8Var.d, " measureName: ", str);
                s8 s8Var = s8.STAT;
                if (!s8Var.isOpen() || (!f8.a && !n9.d(s8Var, k8Var.c, k8Var.d))) {
                    ya.c("TransactionDelegate", "log discard", k8Var.c, " monitorPoint: ", k8Var.d, " measureName: ", str);
                    return;
                }
                r8.b().n(k8Var.f, k8Var.b, k8Var.c, k8Var.d, str);
                a(k8Var);
            }
        } catch (Throwable th) {
            w8.d(th);
        }
    }

    public static void c(k8 k8Var, String str) {
        try {
            if (f8.c && k8Var != null) {
                ya.c("TransactionDelegate", "statEvent end. module: ", k8Var.c, " monitorPoint: ", k8Var.d, " measureName: ", str);
                s8 s8Var = s8.STAT;
                if (!s8Var.isOpen() || (!f8.a && !n9.d(s8Var, k8Var.c, k8Var.d))) {
                    ya.c("TransactionDelegate", "log discard", k8Var.c, " monitorPoint: ", k8Var.d, " measureName: ", str);
                    return;
                }
                a(k8Var);
                r8.b().p(k8Var.f, str, false, k8Var.g);
            }
        } catch (Throwable th) {
            w8.d(th);
        }
    }
}
