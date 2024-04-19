package defpackage;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
/* compiled from: AppMonitorService.java */
/* renamed from: g8  reason: default package */
/* loaded from: classes.dex */
public class g8 extends Service {
    h8 b = null;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (this.b == null) {
            this.b = new i8(getApplication());
        }
        return (IBinder) this.b;
    }

    @Override // android.app.Service
    public void onDestroy() {
        h8 h8Var = this.b;
        if (h8Var != null) {
            try {
                h8Var.H();
            } catch (RemoteException unused) {
            }
        }
        super.onDestroy();
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onLowMemory() {
        h8 h8Var = this.b;
        if (h8Var != null) {
            try {
                h8Var.H();
            } catch (RemoteException unused) {
            }
        }
        super.onLowMemory();
    }
}
