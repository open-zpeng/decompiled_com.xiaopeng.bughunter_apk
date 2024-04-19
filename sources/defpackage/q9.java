package defpackage;
/* compiled from: StringUtils.java */
/* renamed from: q9  reason: default package */
/* loaded from: classes.dex */
public class q9 {
    public static boolean a(String str) {
        return !b(str);
    }

    public static boolean b(String str) {
        int length;
        if (str != null && (length = str.length()) != 0) {
            for (int i = 0; i < length; i++) {
                if (!Character.isWhitespace(str.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }
}
