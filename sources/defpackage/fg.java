package defpackage;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
/* compiled from: AppInfoUtils.java */
/* renamed from: fg  reason: default package */
/* loaded from: classes.dex */
public class fg {
    private static String a;

    public static PackageInfo a(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 128);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String b() {
        BufferedReader bufferedReader;
        Throwable th;
        Exception e;
        String str = a;
        if (str != null) {
            return str;
        }
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader(new File("/proc/" + Process.myPid() + "/cmdline")));
                try {
                    a = bufferedReader.readLine().trim();
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    a = "";
                    sf.a(bufferedReader);
                    return a;
                }
            } catch (Throwable th2) {
                th = th2;
                sf.a(bufferedReader);
                throw th;
            }
        } catch (Exception e3) {
            bufferedReader = null;
            e = e3;
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
            sf.a(bufferedReader);
            throw th;
        }
        sf.a(bufferedReader);
        return a;
    }

    public static String c(Context context, String str) {
        PackageInfo a2 = a(context, str);
        return a2 == null ? "" : a2.versionName;
    }
}
