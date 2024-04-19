package defpackage;

import android.os.Build;
import android.os.Trace;
/* compiled from: TraceCompat.java */
/* renamed from: k3  reason: default package */
/* loaded from: classes.dex */
public final class k3 {
    public static void a(String str) {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.beginSection(str);
        }
    }

    public static void b() {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.endSection();
        }
    }
}
