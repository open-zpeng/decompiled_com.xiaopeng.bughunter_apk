package defpackage;

import java.util.Enumeration;
import java.util.Properties;
import org.apache.commons.io.IOUtils;
/* compiled from: Debug.java */
/* renamed from: xm  reason: default package */
/* loaded from: classes.dex */
public class xm {
    private static final String a;
    private static final rm b;
    private static final String c;

    static {
        String name = rk.class.getName();
        a = name;
        b = sm.a("org.eclipse.paho.client.mqttv3.internal.nls.logcat", name);
        c = System.getProperty("line.separator", IOUtils.LINE_SEPARATOR_UNIX);
    }

    public static String a(Properties properties, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        Enumeration<?> propertyNames = properties.propertyNames();
        String str2 = c;
        stringBuffer.append(String.valueOf(str2) + "============== " + str + " ==============" + str2);
        while (propertyNames.hasMoreElements()) {
            String str3 = (String) propertyNames.nextElement();
            stringBuffer.append(String.valueOf(b(str3, 28, ' ')) + ":  " + properties.get(str3) + c);
        }
        stringBuffer.append("==========================================" + c);
        return stringBuffer.toString();
    }

    public static String b(String str, int i, char c2) {
        if (str.length() >= i) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer(i);
        stringBuffer.append(str);
        int length = i - str.length();
        while (true) {
            length--;
            if (length < 0) {
                return stringBuffer.toString();
            }
            stringBuffer.append(c2);
        }
    }
}
