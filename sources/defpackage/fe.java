package defpackage;

import android.car.Car;
import android.os.Build;
import android.os.SystemProperties;
import android.util.Log;
/* compiled from: SystemPropertyUtils.java */
/* renamed from: fe  reason: default package */
/* loaded from: classes.dex */
public class fe {
    public static String a() {
        String str = SystemProperties.get("persist.xiaopeng.icm.version", "UNKNOWN");
        tf.a("SystemPropertyUtils", "getIcmVersion = " + str);
        return str;
    }

    public static boolean b() {
        return "au8155_xp".equals(Build.DEVICE);
    }

    public static boolean c() {
        boolean z = true;
        try {
            z = true ^ Car.getVersionInCountryCode().contains("ZH");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.i("netChannel", "isInternationVersion :\t" + z);
        return z;
    }
}
