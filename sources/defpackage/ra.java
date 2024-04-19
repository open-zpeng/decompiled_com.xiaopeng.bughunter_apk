package defpackage;

import android.app.ActivityManager;
import android.content.Context;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import com.xiaopeng.lib.security.xmartv1.XmartV1Constants;
/* compiled from: AppInfoUtil.java */
/* renamed from: ra  reason: default package */
/* loaded from: classes.dex */
public class ra {
    private static String a = "";
    private static String b;

    public static String a(Context context) {
        if (context == null) {
            return "";
        }
        int myPid = Process.myPid();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    public static boolean b(Context context) {
        if (context == null) {
            return false;
        }
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            String packageName = context.getPackageName();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.processName.equals(packageName)) {
                    if (runningAppProcessInfo.importance == 400) {
                        return false;
                    }
                    if (powerManager.isScreenOn()) {
                        return true;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static String c() {
        return b;
    }

    public static String d() {
        if (ea.j() == null) {
            return "";
        }
        try {
            String string = ea.j().getSharedPreferences("UTCommon", 0).getString("_lun", "");
            return !TextUtils.isEmpty(string) ? new String(sa.a(string.getBytes(), 2), XmartV1Constants.UTF8_ENCODING) : "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static String e() {
        if (ea.j() == null) {
            return "";
        }
        try {
            String string = ea.j().getSharedPreferences("UTCommon", 0).getString("_luid", "");
            return !TextUtils.isEmpty(string) ? new String(sa.a(string.getBytes(), 2), XmartV1Constants.UTF8_ENCODING) : "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static String f() {
        return a;
    }

    public static String g() {
        return "";
    }

    public static String h() {
        return "";
    }

    public static void i(String str) {
        ya.c("AppInfoUtil", "[setChannle]", str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int indexOf = str.indexOf("@");
        if (indexOf == -1) {
            a = str;
        } else {
            a = str.substring(0, indexOf);
        }
    }

    public static void j(String str) {
        ya.c("AppInfoUtil", "set Appkey:", str);
        b = str;
    }
}
