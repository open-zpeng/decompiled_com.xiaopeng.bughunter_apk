package com.ut.mini.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.ut.device.UTDevice;
import com.ut.mini.base.UTMIVariables;
import java.util.Map;
/* loaded from: classes.dex */
public class UTTeamWork {
    private static UTTeamWork a;

    public static synchronized UTTeamWork getInstance() {
        UTTeamWork uTTeamWork;
        synchronized (UTTeamWork.class) {
            if (a == null) {
                a = new UTTeamWork();
            }
            uTTeamWork = a;
        }
        return uTTeamWork;
    }

    public void clearHost4Https(Context context) {
        if (context == null) {
            Log.w("UTTeamWork", "context is null");
            return;
        }
        fa.h("");
        fb.a(context, "utanalytics_https_host", null);
    }

    public void closeAuto1010Track() {
        pa.a().f();
    }

    public void disableNetworkStatusChecker() {
    }

    public void dispatchLocalHits() {
    }

    public void enableUpload(boolean z) {
        ea.i = z;
    }

    public String getUtsid() {
        try {
            String appkey = ea.a() != null ? ea.a().getAppkey() : null;
            String utdid = UTDevice.getUtdid(la.b().f());
            long longValue = Long.valueOf(ea.e).longValue();
            if (!TextUtils.isEmpty(appkey) && !TextUtils.isEmpty(utdid)) {
                return utdid + "_" + appkey + "_" + longValue;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void initialized() {
    }

    public void saveCacheDataToLocal() {
        oa.e().a();
    }

    public void setHost4Https(Context context, String str) {
        if (context == null) {
            Log.w("UTTeamWork", "context is null");
        } else if (TextUtils.isEmpty(str)) {
            Log.w("UTTeamWork", "host or port is empty");
        } else {
            fa.h(str);
            fb.a(context, "utanalytics_https_host", str);
        }
    }

    public void setToAliyunOsPlatform() {
        UTMIVariables.getInstance().setToAliyunOSPlatform();
    }

    public void turnOffRealTimeDebug() {
        e8.t();
    }

    public void turnOnRealTimeDebug(Map<String, String> map) {
        e8.u(map);
    }
}
