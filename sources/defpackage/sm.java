package defpackage;

import java.util.MissingResourceException;
import java.util.ResourceBundle;
/* compiled from: LoggerFactory.java */
/* renamed from: sm  reason: default package */
/* loaded from: classes.dex */
public class sm {
    private static final String a = "sm";
    private static String b;
    private static String c = qm.class.getName();

    public static rm a(String str, String str2) {
        String str3 = b;
        if (str3 == null) {
            str3 = c;
        }
        rm b2 = b(str3, ResourceBundle.getBundle(str), str2, null);
        if (b2 != null) {
            return b2;
        }
        throw new MissingResourceException("Error locating the logging class", a, str2);
    }

    private static rm b(String str, ResourceBundle resourceBundle, String str2, String str3) {
        try {
            rm rmVar = (rm) Class.forName(str).newInstance();
            rmVar.initialise(resourceBundle, str2, str3);
            return rmVar;
        } catch (ClassNotFoundException | ExceptionInInitializerError | IllegalAccessException | InstantiationException | NoClassDefFoundError | SecurityException unused) {
            return null;
        }
    }

    public static void c(String str) {
        b = str;
    }
}
