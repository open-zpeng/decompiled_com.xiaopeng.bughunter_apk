package defpackage;

import android.car.Car;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.xiaopeng.lib.framework.carcontrollermodule.controller.McuController;
/* compiled from: XPCar.java */
/* renamed from: ie  reason: default package */
/* loaded from: classes.dex */
public class ie {
    private Context a;
    private Car b;
    private boolean c;
    private me d;

    /* compiled from: XPCar.java */
    /* renamed from: ie$a */
    /* loaded from: classes.dex */
    class a implements ServiceConnection {
        a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            ie.this.f();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            ie.this.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ie(Context context) {
        this.a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Log.i("XPCar", "CarVersion :" + ge.g() + " Car connected!");
        this.c = true;
        me meVar = this.d;
        if (meVar != null) {
            meVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        Log.e("XPCar", "Car disConnected!");
        this.c = false;
        me meVar = this.d;
        if (meVar != null) {
            meVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        String g = ge.g();
        g.hashCode();
        if (g.equals(McuController.CAR_TYPE_D21) || g.equals(McuController.CAR_TYPE_E28)) {
            Car createCar = Car.createCar(this.a, new a());
            this.b = createCar;
            createCar.connect();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object d() {
        String g = ge.g();
        g.hashCode();
        if (g.equals(McuController.CAR_TYPE_D21) || g.equals(McuController.CAR_TYPE_E28)) {
            return this.b;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(me meVar) {
        this.d = meVar;
    }
}
