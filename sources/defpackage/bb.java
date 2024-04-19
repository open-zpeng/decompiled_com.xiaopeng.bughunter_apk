package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
/* compiled from: NetworkUtil.java */
/* renamed from: bb  reason: default package */
/* loaded from: classes.dex */
public class bb {
    private static String[] a = {"Unknown", "Unknown"};
    private static c b = new c();
    private static b c = new b();

    /* compiled from: NetworkUtil.java */
    /* renamed from: bb$b */
    /* loaded from: classes.dex */
    private static class b implements Runnable {
        private Context b;

        private b() {
        }

        public b a(Context context) {
            this.b = context;
            return this;
        }

        @Override // java.lang.Runnable
        public void run() {
            Context context = this.b;
            if (context == null) {
                return;
            }
            try {
                if (context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", this.b.getPackageName()) != 0) {
                    bb.a[0] = "Unknown";
                    return;
                }
                ConnectivityManager connectivityManager = (ConnectivityManager) this.b.getSystemService("connectivity");
                if (connectivityManager == null) {
                    bb.a[0] = "Unknown";
                    return;
                }
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                    return;
                }
                if (1 == activeNetworkInfo.getType()) {
                    bb.a[0] = "Wi-Fi";
                } else if (activeNetworkInfo.getType() == 0) {
                    bb.a[0] = "2G/3G";
                    bb.a[1] = activeNetworkInfo.getSubtypeName();
                }
            } catch (Exception unused) {
            }
        }
    }

    /* compiled from: NetworkUtil.java */
    /* renamed from: bb$c */
    /* loaded from: classes.dex */
    private static class c extends BroadcastReceiver {
        private c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            ib.a().g(bb.c.a(context));
        }
    }

    private static String b(int i) {
        switch (i) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
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
            case 13:
                return "4G";
            default:
                return "Unknown";
        }
    }

    public static void d(Context context) {
        if (context == null) {
            return;
        }
        context.registerReceiver(b, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public static void e(Context context) {
        c cVar;
        if (context == null || (cVar = b) == null) {
            return;
        }
        context.unregisterReceiver(cVar);
    }

    public static String[] f(Context context) {
        return a;
    }

    public static boolean g() {
        Context j = ea.j();
        if (j != null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) j.getSystemService("connectivity");
                if (connectivityManager != null) {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo != null) {
                        return activeNetworkInfo.isConnected();
                    }
                    return false;
                }
                return true;
            } catch (Exception unused) {
                return true;
            }
        }
        return true;
    }

    public static String h() {
        NetworkInfo activeNetworkInfo;
        Context j = ea.j();
        if (j == null) {
            return "Unknown";
        }
        try {
            if (j.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", j.getPackageName()) == 0 && (activeNetworkInfo = ((ConnectivityManager) j.getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
                if (activeNetworkInfo.getType() == 1) {
                    return "wifi";
                }
                if (activeNetworkInfo.getType() == 0) {
                    return b(activeNetworkInfo.getSubtype());
                }
            }
        } catch (Throwable unused) {
        }
        return "Unknown";
    }
}
