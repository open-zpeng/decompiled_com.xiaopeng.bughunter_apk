package defpackage;
/* compiled from: ParseUtils.java */
/* renamed from: p9  reason: default package */
/* loaded from: classes.dex */
public class p9 {
    public static int a(String str) {
        if (q9.a(str)) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                return 0;
            }
        }
        return 0;
    }
}
