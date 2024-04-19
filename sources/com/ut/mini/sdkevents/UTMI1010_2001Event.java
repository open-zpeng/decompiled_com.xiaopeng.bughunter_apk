package com.ut.mini.sdkevents;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import com.ut.mini.UTAnalytics;
import com.ut.mini.UTInterfaceCallDelegate;
import com.ut.mini.UTTracker;
import com.ut.mini.core.appstatus.UTMCAppStatusCallbacks;
import com.ut.mini.internal.UTOriginalCustomHitBuilder;
import com.ut.mini.plugin.UTPlugin;
import java.util.List;
/* loaded from: classes.dex */
public class UTMI1010_2001Event extends UTPlugin implements UTMCAppStatusCallbacks {
    private long C = 0;
    private long D = 0;
    private long E = 0;

    private void a(long j) {
        if (pa.a().d()) {
            return;
        }
        if (j > 0) {
            UTOriginalCustomHitBuilder uTOriginalCustomHitBuilder = new UTOriginalCustomHitBuilder("UT", 1010, "" + j, "" + (0 != this.E ? SystemClock.elapsedRealtime() - this.E : 0L), null, null);
            UTTracker defaultTracker = UTAnalytics.getInstance().getDefaultTracker();
            if (defaultTracker != null) {
                defaultTracker.send(uTOriginalCustomHitBuilder.build());
            } else {
                ya.a("Record app display event error", "Fatal Error,must call setRequestAuthentication method first.");
            }
        }
    }

    private static boolean m() {
        String packageName;
        ActivityManager activityManager;
        ComponentName componentName;
        try {
            Context f = la.b().f();
            if (f != null && (packageName = f.getPackageName()) != null && (activityManager = (ActivityManager) f.getSystemService("activity")) != null) {
                try {
                    List<ActivityManager.RunningTaskInfo> runningTasks = activityManager.getRunningTasks(1);
                    if (runningTasks != null && runningTasks.size() > 0 && (componentName = runningTasks.get(0).topActivity) != null) {
                        if (packageName.contains(componentName.getPackageName())) {
                            return false;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivityPaused(Activity activity) {
        UTInterfaceCallDelegate.pageDisAppearByAuto(activity);
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivityResumed(Activity activity) {
        UTInterfaceCallDelegate.pageAppearByAuto(activity);
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivityStopped(Activity activity) {
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    @Override // com.ut.mini.plugin.UTPlugin
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onPluginMsgArrivedFromSDK(int r6, java.lang.Object r7) {
        /*
            r5 = this;
            r0 = 3
            if (r6 != r0) goto L57
            java.util.Map r7 = (java.util.Map) r7
            pb r6 = defpackage.pb.EVENTID
            java.lang.String r0 = r6.toString()
            boolean r0 = r7.containsKey(r0)
            if (r0 == 0) goto L57
            java.lang.String r6 = r6.toString()
            java.lang.Object r6 = r7.get(r6)
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String r0 = "2001"
            boolean r6 = r0.equals(r6)
            if (r6 == 0) goto L57
            pb r6 = defpackage.pb.ARG3
            java.lang.String r0 = r6.toString()
            boolean r0 = r7.containsKey(r0)
            r1 = 0
            if (r0 == 0) goto L44
            java.lang.String r6 = r6.toString()
            java.lang.Object r6 = r7.get(r6)
            java.lang.String r6 = (java.lang.String) r6
            long r6 = java.lang.Long.parseLong(r6)     // Catch: java.lang.Exception -> L40
            goto L45
        L40:
            r6 = move-exception
            r6.printStackTrace()
        L44:
            r6 = r1
        L45:
            long r3 = r5.C
            long r3 = r3 + r6
            r5.C = r3
            boolean r6 = m()
            if (r6 == 0) goto L57
            long r6 = r5.C
            r5.a(r6)
            r5.C = r1
        L57:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ut.mini.sdkevents.UTMI1010_2001Event.onPluginMsgArrivedFromSDK(int, java.lang.Object):void");
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onSwitchBackground() {
        a(SystemClock.elapsedRealtime() - this.D);
        this.E = SystemClock.elapsedRealtime();
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onSwitchForeground() {
        this.D = SystemClock.elapsedRealtime();
    }

    @Override // com.ut.mini.plugin.UTPlugin
    public int[] returnRequiredMsgIds() {
        return new int[]{3};
    }
}
