package defpackage;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.text.TextUtils;
import android.util.Log;
import com.google.gson.reflect.TypeToken;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEvent;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* compiled from: StatEvent.java */
/* renamed from: ve  reason: default package */
/* loaded from: classes.dex */
public class ve implements IStatEvent {
    private static String a;
    private static String b;
    private String c;
    private Map<String, Object> d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StatEvent.java */
    /* renamed from: ve$a */
    /* loaded from: classes.dex */
    public class a extends TypeToken<Map<String, Object>> {
        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ve(Context context) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.d = concurrentHashMap;
        concurrentHashMap.put(IStatEvent.CUSTOM_TIMESTAMP, Long.valueOf(System.currentTimeMillis()));
        this.d.put(IStatEvent.CUSTOM_MODULE_VERSION, d(context));
        this.d.put(IStatEvent.CUSTOM_NETWORK, c(context));
        this.d.put(IStatEvent.CUSTOM_STARTUP, Long.valueOf(SystemClock.uptimeMillis() / 1000));
        this.d.put(IStatEvent.CUSTOM_DEVICE_MCUVER, a());
        this.d.put(IStatEvent.CUSTOM_UID, Long.valueOf(yf.a()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a() {
        if (TextUtils.isEmpty(a)) {
            a = SystemProperties.get("persist.sys.mcu.version");
        }
        if (TextUtils.isEmpty(a)) {
            a = SystemProperties.get("sys.mcu.version");
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(String str) {
        String[] split;
        return (TextUtils.isEmpty(str) || (split = str.split("_")) == null || split.length <= 0) ? "" : split[0];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String d(Context context) {
        if (TextUtils.isEmpty(b)) {
            try {
                b = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (Exception e) {
                Log.w("StatEvent", "getVersion fail!", e);
                return "Unknown";
            }
        }
        return b;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEvent
    public String getEventName() {
        return this.c;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEvent
    public void put(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        this.d.put(str, str2);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEvent
    public void setEventName(String str) {
        this.c = str;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEvent
    public String toJson() {
        this.d.put(IStatEvent.CUSTOM_MODULE, b(this.c));
        this.d.put(IStatEvent.CUSTOM_EVENT, this.c);
        return ze.b().a().toJson(this.d, new a().getType());
    }

    public String toString() {
        return "StatEvent{eventName='" + this.c + "'}";
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEvent
    public void put(String str, Number number) {
        if (str == null || number == null) {
            return;
        }
        this.d.put(str, number);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEvent
    public void put(String str, Boolean bool) {
        if (str == null || bool == null) {
            return;
        }
        this.d.put(str, bool);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEvent
    public void put(String str, Character ch) {
        if (str == null || ch == null) {
            return;
        }
        this.d.put(str, ch);
    }
}
