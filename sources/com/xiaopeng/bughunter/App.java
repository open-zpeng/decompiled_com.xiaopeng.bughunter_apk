package com.xiaopeng.bughunter;

import android.app.ActivityManager;
import android.app.Application;
import android.car.Car;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Process;
import com.activeandroid.ActiveAndroid;
import com.xiaopeng.bughunter.system.a;
import com.xiaopeng.bughunter.system.b;
import com.xiaopeng.bughunter.system.c;
import com.xiaopeng.lib.framework.carcontrollermodule.CarControllerModuleEntry;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IMcuController;
import com.xiaopeng.lib.framework.netchannelmodule.NetworkChannelsEntry;
import com.xiaopeng.lib.http.HttpsUtils;
import java.util.List;
/* loaded from: classes.dex */
public class App extends Application {
    private static App b;

    private String a() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("BugHunter_App");
        stringBuffer.append(": \t");
        stringBuffer.append("commitID :");
        stringBuffer.append("649c5f5af4628ef85e3edb300cd1a39324ff4846");
        stringBuffer.append("\t");
        stringBuffer.append("RELEASE_TIME :");
        stringBuffer.append("20230725123628");
        return stringBuffer.toString();
    }

    public static App b() {
        return b;
    }

    public static String d(Context context) {
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    private void e() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addDataScheme("package");
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        registerReceiver(new a(), intentFilter);
    }

    private boolean f() {
        return "com.xiaopeng.bughunter".equals(d(this));
    }

    public IMcuController c() {
        return (IMcuController) Module.get(CarControllerModuleEntry.class).get(IMcuController.class);
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        boolean f = f();
        tf.l("BugHunter_App", "Application onCreate . isMianProceess: " + f);
        if (f()) {
            tf.l("BugHunter_App", a());
        }
        b = this;
        gf.l(this);
        HttpsUtils.init(this, false);
        ge.h(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.xiaopeng.broadcast.ACTION_PM_STATUS_CHANGE");
        if (f) {
            intentFilter.addAction("com.xiaopeng.scu.ACTION_UP_LOAD_CAN_LOG");
            intentFilter.addAction("com.xiaopeng.scu.ACTION_UP_LOAD_CAN_LOG_CS");
            e();
        }
        Module.register(NetworkChannelsEntry.class, new NetworkChannelsEntry());
        Module.register(CarControllerModuleEntry.class, new CarControllerModuleEntry(this));
        registerReceiver(new c(), intentFilter, "com.xiaopeng.permission.BROADCAST", null);
        try {
            ActiveAndroid.initialize(this);
        } catch (Exception e) {
            tf.f("BugHunter_App", "Failed to init ActiveAndroid, Exception:" + e);
        }
        try {
            if (("Q1".equals(Car.getXpCduType()) || "Q8".equals(Car.getXpCduType())) && f) {
                b.b().c(this).e();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        tf.l("BugHunter_App", "Application onCreate finish");
    }
}
