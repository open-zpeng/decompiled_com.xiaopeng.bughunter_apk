package defpackage;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import com.ut.device.UTDevice;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/* compiled from: DeviceUtil.java */
/* renamed from: ta  reason: default package */
/* loaded from: classes.dex */
public class ta {
    private static Map<String, String> a;

    public static synchronized Map<String, String> a(Context context) {
        synchronized (ta.class) {
            Map<String, String> map = a;
            if (map != null) {
                map.put(pb.CHANNEL.toString(), ra.f());
                a.put(pb.APPKEY.toString(), ra.c());
                b(a, context);
                return a;
            } else if (context != null) {
                a = new HashMap();
                try {
                    String a2 = cb.a(context);
                    String b = cb.b(context);
                    if (TextUtils.isEmpty(a2) || TextUtils.isEmpty(b)) {
                        a2 = "";
                        b = "";
                    }
                    a.put(pb.IMEI.toString(), a2);
                    a.put(pb.IMSI.toString(), b);
                    a.put(pb.BRAND.toString(), Build.BRAND);
                    a.put(pb.DEVICE_MODEL.toString(), Build.MODEL);
                    a.put(pb.RESOLUTION.toString(), d(context));
                    a.put(pb.CHANNEL.toString(), ra.f());
                    a.put(pb.APPKEY.toString(), ra.c());
                    a.put(pb.APPVERSION.toString(), e(context));
                    a.put(pb.LANGUAGE.toString(), c(context));
                    a.put(pb.OS.toString(), i());
                    a.put(pb.OSVERSION.toString(), h());
                    a.put(pb.SDKVERSION.toString(), "2.6.4.10_for_bc");
                    a.put(pb.SDKTYPE.toString(), "mini");
                    try {
                        a.put(pb.UTDID.toString(), UTDevice.getUtdid(context));
                    } catch (Throwable th) {
                        Log.e("DeviceUtil", "utdid4all jar doesn't exist, please copy the libs folder.");
                        th.printStackTrace();
                    }
                    try {
                        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                        String str = "";
                        if (telephonyManager != null && telephonyManager.getSimState() == 5) {
                            str = telephonyManager.getNetworkOperatorName();
                        }
                        if (TextUtils.isEmpty(str)) {
                            str = "Unknown";
                        }
                        a.put(pb.CARRIER.toString(), str);
                    } catch (Exception unused) {
                    }
                    b(a, context);
                    return a;
                } catch (Exception unused2) {
                    return null;
                }
            } else {
                return null;
            }
        }
    }

    private static void b(Map<String, String> map, Context context) {
        try {
            String[] f = bb.f(context);
            map.put(pb.ACCESS.toString(), f[0]);
            if (f[0].equals("2G/3G")) {
                map.put(pb.ACCESS_SUBTYPE.toString(), f[1]);
            } else {
                map.put(pb.ACCESS_SUBTYPE.toString(), "Unknown");
            }
        } catch (Exception unused) {
            map.put(pb.ACCESS.toString(), "Unknown");
            map.put(pb.ACCESS_SUBTYPE.toString(), "Unknown");
        }
    }

    private static String c(Context context) {
        try {
            return Locale.getDefault().getLanguage();
        } catch (Throwable unused) {
            return "Unknown";
        }
    }

    private static String d(Context context) {
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            int i = displayMetrics.widthPixels;
            int i2 = displayMetrics.heightPixels;
            if (i > i2) {
                int i3 = i ^ i2;
                i2 ^= i3;
                i = i3 ^ i2;
            }
            return i2 + "*" + i;
        } catch (Exception unused) {
            return "Unknown";
        }
    }

    public static String e(Context context) {
        String e = la.b().e();
        if (TextUtils.isEmpty(e)) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                if (packageInfo != null) {
                    a.put(pb.APPVERSION.toString(), packageInfo.versionName);
                    return packageInfo.versionName;
                }
                return "Unknown";
            } catch (Throwable unused) {
                return "Unknown";
            }
        }
        return e;
    }

    public static boolean f() {
        try {
            if ((System.getProperty("java.vm.name") == null || !System.getProperty("java.vm.name").toLowerCase().contains("lemur")) && System.getProperty("ro.yunos.version") == null && TextUtils.isEmpty(hb.a("ro.yunos.build.version"))) {
                return g();
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean g() {
        return (TextUtils.isEmpty(hb.a("ro.yunos.product.chip")) && TextUtils.isEmpty(hb.a("ro.yunos.hardware"))) ? false : true;
    }

    private static String h() {
        String str = Build.VERSION.RELEASE;
        if (f()) {
            String property = System.getProperty("ro.yunos.version");
            if (!TextUtils.isEmpty(property)) {
                return property;
            }
            str = l();
            if (!TextUtils.isEmpty(str)) {
            }
        }
        return str;
    }

    private static String i() {
        return (!f() || g()) ? "a" : "y";
    }

    public static String j() {
        String b = hb.b("ro.aliyun.clouduuid", "false");
        if ("false".equals(b)) {
            b = hb.b("ro.sys.aliyun.clouduuid", "false");
        }
        return TextUtils.isEmpty(b) ? k() : b;
    }

    private static String k() {
        try {
            return (String) Class.forName("com.yunos.baseservice.clouduuid.CloudUUID").getMethod("getCloudUUID", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    private static String l() {
        try {
            Field declaredField = Build.class.getDeclaredField("YUNOS_BUILD_VERSION");
            if (declaredField != null) {
                declaredField.setAccessible(true);
                return (String) declaredField.get(new String());
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
