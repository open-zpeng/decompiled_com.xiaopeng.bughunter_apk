package com.xiaopeng.lib.framework.ipcmodule;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.support.v4.app.t;
import android.util.Log;
/* loaded from: classes.dex */
public class AgentService extends Service {
    private static final String CHANNEL_ID = "XPENG";
    private static final String CHANNEL_NAME = "IPC";
    private static final String CONTENT = "IPC application is running";
    private static final String TAG = "AgentService";
    private static final String TITLE = "Xmart";

    private void startNotification() {
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        Log.i(TAG, "startNotification");
        NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, 3);
        ((NotificationManager) getApplicationContext().getSystemService("notification")).createNotificationChannel(notificationChannel);
        startForeground(100, new t.b(this, notificationChannel.getId()).h(R.mipmap.icon_notification).f(TITLE).e(CONTENT).g(3).d("service").a());
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        Log.i(TAG, "onCreate");
        startNotification();
        super.onCreate();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        Log.i(TAG, "onStartCommand:\t" + i2 + "\tflgs:\t" + i);
        IpcServiceImpl.getInstance().init();
        return super.onStartCommand(intent, i, i2);
    }
}
