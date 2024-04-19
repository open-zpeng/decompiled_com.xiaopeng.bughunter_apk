package defpackage;

import java.util.Map;
/* compiled from: UTAdapter.java */
/* renamed from: jb  reason: default package */
/* loaded from: classes.dex */
public class jb {
    public static void a(Map<String, String> map) {
        Object b;
        try {
            Object d = eb.d("com.ut.mini.UTAnalytics", "getInstance");
            if (d == null || (b = eb.b(d, "getDefaultTracker")) == null) {
                return;
            }
            eb.c(b, "send", new Object[]{map}, Map.class);
        } catch (Exception unused) {
        }
    }
}
