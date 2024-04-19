package com.xiaopeng.bughunter.system;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
/* loaded from: classes.dex */
public class CrashDetectService extends Service {
    private td b = new td();

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        this.b.b();
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.b.a();
    }
}
