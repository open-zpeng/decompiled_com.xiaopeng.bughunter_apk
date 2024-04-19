package com.xiaopeng.bughunter.system;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
/* loaded from: classes.dex */
public class KeepAliveService extends Service {
    private wd b = new wd();

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (intent != null) {
            this.b.a(intent);
            return null;
        }
        return null;
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        tf.l("KeepAliveService", "Rebind ....");
        this.b.a(intent);
        super.onRebind(intent);
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        tf.l("KeepAliveService", "Unbind ....");
        if (intent != null) {
            this.b.b(intent);
            return true;
        }
        return true;
    }
}
