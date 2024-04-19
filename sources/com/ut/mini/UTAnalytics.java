package com.ut.mini;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.ut.mini.base.UTMIVariables;
import com.ut.mini.core.appstatus.UTMCAppStatusRegHelper;
import com.ut.mini.core.sign.IUTRequestAuthentication;
import com.ut.mini.core.sign.UTBaseRequestAuthentication;
import com.ut.mini.core.sign.UTSecuritySDKRequestAuthentication;
import com.ut.mini.internal.UTOriginalCustomHitBuilder;
import com.ut.mini.internal.UTTeamWork;
import com.ut.mini.plugin.UTPluginMgr;
import com.ut.mini.sdkevents.UTMI1010_2001Event;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class UTAnalytics {
    private static UTAnalytics a;
    private boolean M;
    private boolean N;

    /* renamed from: a  reason: collision with other field name */
    private UTTracker f127a;
    private Map<String, UTTracker> w = new HashMap();
    private Map<String, UTTracker> x = new HashMap();

    private UTAnalytics() {
        if (Build.VERSION.SDK_INT < 14) {
            UTMI1010_2001Event uTMI1010_2001Event = new UTMI1010_2001Event();
            UTPluginMgr.getInstance().registerPlugin(uTMI1010_2001Event, false);
            UTMIVariables.getInstance().setUTMI1010_2001EventInstance(uTMI1010_2001Event);
            return;
        }
        UTMI1010_2001Event uTMI1010_2001Event2 = new UTMI1010_2001Event();
        UTMCAppStatusRegHelper.registerAppStatusCallbacks(uTMI1010_2001Event2);
        UTMIVariables.getInstance().setUTMI1010_2001EventInstance(uTMI1010_2001Event2);
    }

    public static synchronized UTAnalytics getInstance() {
        UTAnalytics uTAnalytics;
        synchronized (UTAnalytics.class) {
            if (a == null) {
                a = new UTAnalytics();
            }
            uTAnalytics = a;
        }
        return uTAnalytics;
    }

    public synchronized UTTracker getDefaultTracker() {
        if (this.f127a == null) {
            this.f127a = new UTTracker();
        }
        if (this.f127a == null) {
            ya.a("getDefaultTracker error", "Fatal Error,must call setRequestAuthentication method first.");
        }
        return this.f127a;
    }

    public synchronized UTTracker getTracker(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (this.w.containsKey(str)) {
                return this.w.get(str);
            }
            UTTracker uTTracker = new UTTracker();
            uTTracker.q(str);
            this.w.put(str, uTTracker);
            return uTTracker;
        }
        ya.a("getTracker", "TrackId is null.");
        return null;
    }

    public synchronized UTTracker getTrackerByAppkey(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (this.x.containsKey(str)) {
                return this.x.get(str);
            }
            UTTracker uTTracker = new UTTracker();
            uTTracker.r(str);
            this.x.put(str, uTTracker);
            return uTTracker;
        }
        ya.a("getTracker", "TrackId is null.");
        return null;
    }

    @Deprecated
    public void setAppApplicationInstance(Application application) {
        la.b().h(application);
        e8.p(application);
    }

    public void setAppApplicationInstance4sdk(Application application, IUTApplication iUTApplication) {
        try {
            if (this.N) {
                return;
            }
            if (application != null && iUTApplication != null && application.getApplicationContext() != null) {
                getInstance().setContext(application.getApplicationContext());
                getInstance().setAppApplicationInstance(application);
                if (iUTApplication.isUTLogEnable()) {
                    getInstance().turnOnDebug();
                }
                getInstance().setChannel(iUTApplication.getUTChannel());
                getInstance().setAppVersion(iUTApplication.getUTAppVersion());
                getInstance().setRequestAuthentication(iUTApplication.getUTRequestAuthInstance());
                this.N = true;
                return;
            }
            throw new IllegalArgumentException("application and callback must not be null");
        } catch (Throwable th) {
            try {
                ya.a(null, th);
            } catch (Throwable unused) {
            }
        }
    }

    @Deprecated
    public void setAppVersion(String str) {
        la.b().i(str);
    }

    @Deprecated
    public void setChannel(String str) {
        e8.r(str);
    }

    @Deprecated
    public void setContext(Context context) {
        la.b().j(context);
        if (context != null) {
            UTTeamWork.getInstance().initialized();
        }
    }

    @Deprecated
    public void setRequestAuthentication(IUTRequestAuthentication iUTRequestAuthentication) {
        if (iUTRequestAuthentication == null) {
            ya.a("setRequestAuthentication", "Fatal Error,pRequestAuth must not be null.");
        }
        if (iUTRequestAuthentication instanceof UTBaseRequestAuthentication) {
            String appkey = iUTRequestAuthentication.getAppkey();
            UTBaseRequestAuthentication uTBaseRequestAuthentication = (UTBaseRequestAuthentication) iUTRequestAuthentication;
            e8.s(false, appkey, uTBaseRequestAuthentication.getAppSecret(), uTBaseRequestAuthentication.isEncode() ? "1" : "0");
            return;
        }
        e8.s(true, iUTRequestAuthentication.getAppkey(), null, ((UTSecuritySDKRequestAuthentication) iUTRequestAuthentication).getAuthCode());
    }

    public void turnOffAutoPageTrack() {
        UTPageHitHelper.getInstance().turnOffAutoPageTrack();
    }

    @Deprecated
    public void turnOnDebug() {
        la.b().k();
    }

    public void updateSessionProperties(Map<String, String> map) {
        Map<String, String> b = pa.a().b();
        HashMap hashMap = new HashMap();
        if (b != null) {
            hashMap.putAll(b);
        }
        hashMap.putAll(map);
        pa.a().c(hashMap);
    }

    public void updateUserAccount(String str, String str2) {
        la.b().l(str, str2);
    }

    public void userRegister(String str) {
        if (!TextUtils.isEmpty(str)) {
            UTTracker defaultTracker = getDefaultTracker();
            if (defaultTracker != null) {
                defaultTracker.send(new UTOriginalCustomHitBuilder("UT", 1006, str, null, null, null).build());
                return;
            } else {
                ya.a("Record userRegister event error", "Fatal Error,must call setRequestAuthentication method first.");
                return;
            }
        }
        ya.a("userRegister", "Fatal Error,usernick can not be null or empty!");
    }

    public void setAppApplicationInstance(Application application, IUTApplication iUTApplication) {
        try {
            if (this.M) {
                return;
            }
            if (application != null && iUTApplication != null && application.getApplicationContext() != null) {
                getInstance().setContext(application.getApplicationContext());
                getInstance().setAppApplicationInstance(application);
                if (iUTApplication.isUTLogEnable()) {
                    getInstance().turnOnDebug();
                }
                getInstance().setChannel(iUTApplication.getUTChannel());
                getInstance().setAppVersion(iUTApplication.getUTAppVersion());
                getInstance().setRequestAuthentication(iUTApplication.getUTRequestAuthInstance());
                this.N = true;
                this.M = true;
                return;
            }
            throw new IllegalArgumentException("application and callback must not be null");
        } catch (Throwable th) {
            try {
                ya.a(null, th);
            } catch (Throwable unused) {
            }
        }
    }
}
