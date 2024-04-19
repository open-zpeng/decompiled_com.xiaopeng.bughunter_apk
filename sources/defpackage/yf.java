package defpackage;

import android.os.Build;
import android.os.SystemProperties;
import android.text.TextUtils;
/* compiled from: SystemPropertyUtil.java */
/* renamed from: yf  reason: default package */
/* loaded from: classes.dex */
public class yf {
    private static final String a = "persist.sys.mqtt.comm_url" + gg.a();
    private static final String b = "persist.sys.mqtt.url" + gg.a();
    private static final String c = "persist.sys.mqtt.user" + gg.a();
    private static final String d = "persist.sys.mqtt.pass" + gg.a();
    private static final String e = "persist.sys.mqtt.id" + gg.a();

    public static long a() {
        return SystemProperties.getLong("persist.sys.account_uid", -1L);
    }

    public static String b() {
        return SystemProperties.get("sys.xiaopeng.dbc_ver", "");
    }

    public static String c() {
        if (Build.VERSION.SDK_INT >= 26) {
            return SystemProperties.get("persist.sys.mcu.hardwareId");
        }
        return SystemProperties.get("persist.sys.hardware_id");
    }

    public static String d() {
        String str;
        if (Build.VERSION.SDK_INT > 28) {
            str = SystemProperties.get("ro.boot.hw_version");
        } else {
            str = SystemProperties.get("ro.xiaopeng.hardware");
        }
        return TextUtils.isEmpty(str) ? "Unknown" : str;
    }

    public static String e() {
        if (Build.VERSION.SDK_INT >= 26) {
            return SystemProperties.get("sys.xiaopeng.iccid", "");
        }
        return SystemProperties.get("ril.audio.iccid", "");
    }

    public static String f() {
        return SystemProperties.get("ro.xiaopeng.software");
    }

    public static String g() {
        String str = SystemProperties.get("persist.sys.xiaopeng.vin", "");
        return TextUtils.isEmpty(str) ? SystemProperties.get("sys.xiaopeng.vin", "") : str;
    }

    public static int h() {
        return SystemProperties.getInt("persist.sys.vehicle_id", -1);
    }
}
