package defpackage;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.SystemProperties;
import java.text.SimpleDateFormat;
/* compiled from: BugHunterUtils.java */
/* renamed from: qf  reason: default package */
/* loaded from: classes.dex */
public class qf {
    public static String a(long j) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(j));
    }

    public static String b() {
        return SystemProperties.get("sys.mcu.version");
    }

    public static String c(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            if (activeNetworkInfo.getType() != 0) {
                return activeNetworkInfo.getType() == 1 ? "WIFI" : "";
            }
            switch (activeNetworkInfo.getSubtype()) {
                case 1:
                case 2:
                case 4:
                case 7:
                    return "2G";
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return "3G";
                case 11:
                default:
                    return "";
                case 13:
                    return "4G";
            }
        }
        return "";
    }
}
