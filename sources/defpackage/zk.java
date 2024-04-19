package defpackage;
/* compiled from: ExceptionHelper.java */
/* renamed from: zk  reason: default package */
/* loaded from: classes.dex */
public class zk {
    public static jk a(int i) {
        if (i != 4 && i != 5) {
            return new jk(i);
        }
        return new ok(i);
    }

    public static jk b(Throwable th) {
        if (th.getClass().getName().equals("java.security.GeneralSecurityException")) {
            return new ok(th);
        }
        return new jk(th);
    }

    public static boolean c(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }
}
