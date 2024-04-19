package defpackage;

import android.os.Build;
import android.os.SystemProperties;
import android.text.TextUtils;
/* compiled from: BuildInfoUtils.java */
/* renamed from: gg  reason: default package */
/* loaded from: classes.dex */
public class gg {
    private static String a;

    public static String a() {
        int indexOf;
        String b = b();
        return (!TextUtils.isEmpty(b) && (indexOf = b.indexOf("_")) > 1) ? b.substring(indexOf - 1, indexOf) : "4";
    }

    public static String b() {
        String str = a;
        if (str != null) {
            return str;
        }
        String d = d("ro.xiaopeng.software");
        a = d;
        if ("unknown".equals(d)) {
            a = d("ro.build.display.id");
        }
        return a;
    }

    public static String c() {
        return d("persist.sys.mcu.hardwareId");
    }

    private static String d(String str) {
        return SystemProperties.get(str, "unknown");
    }

    public static String e() {
        String b;
        int indexOf;
        int i;
        int indexOf2;
        String d = d("ro.product.firmware");
        return (!"unknown".equals(d) || (indexOf = (b = b()).indexOf("_")) <= 1 || (indexOf2 = b.indexOf("_", (i = indexOf + 1))) <= indexOf) ? d : b.substring(i, indexOf2);
    }

    public static boolean f() {
        return g() || i();
    }

    public static boolean g() {
        return "eng".equals(Build.TYPE);
    }

    public static boolean h() {
        return "4".equals(a());
    }

    public static boolean i() {
        return "userdebug".equals(Build.TYPE);
    }

    public static boolean j() {
        return "user".equals(Build.TYPE);
    }
}
