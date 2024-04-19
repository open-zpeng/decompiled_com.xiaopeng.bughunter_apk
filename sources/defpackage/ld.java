package defpackage;

import android.util.Log;
/* compiled from: OkLogger.java */
/* renamed from: ld  reason: default package */
/* loaded from: classes.dex */
public class ld {
    private static boolean a = true;

    public static void a(Throwable th) {
        if (!a || th == null) {
            return;
        }
        th.printStackTrace();
    }

    public static void b(String str, String str2) {
        if (a) {
            Log.v(str, str2);
        }
    }
}
