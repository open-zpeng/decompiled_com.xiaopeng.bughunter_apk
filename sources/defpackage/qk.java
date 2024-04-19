package defpackage;

import com.xiaopeng.lib.security.xmartv1.XmartV1Constants;
import java.io.UnsupportedEncodingException;
/* compiled from: MqttTopic.java */
/* renamed from: qk  reason: default package */
/* loaded from: classes.dex */
public class qk {
    public static boolean a(String str, String str2) throws IllegalArgumentException {
        int length = str2.length();
        int length2 = str.length();
        b(str, true);
        b(str2, false);
        if (str.equals(str2)) {
            return true;
        }
        int i = 0;
        int i2 = 0;
        while (i < length2 && i2 < length && ((str2.charAt(i2) != '/' || str.charAt(i) == '/') && (str.charAt(i) == '+' || str.charAt(i) == '#' || str.charAt(i) == str2.charAt(i2)))) {
            if (str.charAt(i) == '+') {
                while (true) {
                    int i3 = i2 + 1;
                    if (i3 < length && str2.charAt(i3) != '/') {
                        i2++;
                    }
                }
            } else if (str.charAt(i) == '#') {
                i2 = length - 1;
            }
            i++;
            i2++;
        }
        return i2 == length && i == length2;
    }

    public static void b(String str, boolean z) throws IllegalArgumentException {
        try {
            int length = str.getBytes(XmartV1Constants.UTF8_ENCODING).length;
            if (length < 1 || length > 65535) {
                throw new IllegalArgumentException(String.format("Invalid topic length, should be in range[%d, %d]!", new Integer(1), new Integer(65535)));
            }
            if (z) {
                if (ym.d(str, new String[]{"#", "+"})) {
                    return;
                }
                if (ym.c(str, "#") <= 1 && (!str.contains("#") || str.endsWith("/#"))) {
                    c(str);
                    return;
                }
                throw new IllegalArgumentException("Invalid usage of multi-level wildcard in topic string: " + str);
            } else if (ym.a(str, "#+")) {
                throw new IllegalArgumentException("The topic name MUST NOT contain any wildcard characters (#+)");
            }
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }

    private static void c(String str) {
        char charAt = "+".charAt(0);
        char charAt2 = "/".charAt(0);
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        int i = 0;
        while (i < length) {
            int i2 = i - 1;
            char c = i2 >= 0 ? charArray[i2] : (char) 0;
            int i3 = i + 1;
            char c2 = i3 < length ? charArray[i3] : (char) 0;
            if (charArray[i] == charAt && ((c != charAt2 && c != 0) || (c2 != charAt2 && c2 != 0))) {
                throw new IllegalArgumentException(String.format("Invalid usage of single-level wildcard in topic string '%s'!", str));
            }
            i = i3;
        }
    }
}
