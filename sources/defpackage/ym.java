package defpackage;
/* compiled from: Strings.java */
/* renamed from: ym  reason: default package */
/* loaded from: classes.dex */
public final class ym {
    public static boolean a(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence2 == null) {
            return false;
        }
        return b(charSequence, h(charSequence2));
    }

    public static boolean b(CharSequence charSequence, char[] cArr) {
        if (f(charSequence) || g(cArr)) {
            return false;
        }
        int length = charSequence.length();
        int length2 = cArr.length;
        int i = length - 1;
        int i2 = length2 - 1;
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = charSequence.charAt(i3);
            for (int i4 = 0; i4 < length2; i4++) {
                if (cArr[i4] == charAt) {
                    if (!Character.isHighSurrogate(charAt) || i4 == i2) {
                        return true;
                    }
                    if (i3 < i && cArr[i4 + 1] == charSequence.charAt(i3 + 1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static int c(CharSequence charSequence, CharSequence charSequence2) {
        int i = 0;
        if (f(charSequence) || f(charSequence2)) {
            return 0;
        }
        int i2 = 0;
        while (true) {
            int e = e(charSequence, charSequence2, i);
            if (e == -1) {
                return i2;
            }
            i2++;
            i = e + charSequence2.length();
        }
    }

    public static boolean d(CharSequence charSequence, CharSequence[] charSequenceArr) {
        boolean z = charSequence == null && charSequenceArr == null;
        if (charSequenceArr != null) {
            for (CharSequence charSequence2 : charSequenceArr) {
                z = z || charSequence2.equals(charSequence);
            }
        }
        return z;
    }

    private static int e(CharSequence charSequence, CharSequence charSequence2, int i) {
        return charSequence.toString().indexOf(charSequence2.toString(), i);
    }

    public static boolean f(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    private static boolean g(char[] cArr) {
        return cArr == null || cArr.length == 0;
    }

    private static char[] h(CharSequence charSequence) {
        if (charSequence instanceof String) {
            return ((String) charSequence).toCharArray();
        }
        int length = charSequence.length();
        char[] cArr = new char[charSequence.length()];
        for (int i = 0; i < length; i++) {
            cArr[i] = charSequence.charAt(i);
        }
        return cArr;
    }
}
