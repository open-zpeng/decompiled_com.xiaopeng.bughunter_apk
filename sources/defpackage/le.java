package defpackage;

import android.car.hardware.CarPropertyValue;
import android.car.hardware.avas.CarAvasManager;
import android.car.hardware.bcm.CarBcmManager;
import android.car.hardware.ciu.CarCiuManager;
import android.car.hardware.eps.CarEpsManager;
import android.car.hardware.esp.CarEspManager;
import android.car.hardware.hvac.CarHvacManager;
import android.car.hardware.icm.CarIcmManager;
import android.car.hardware.mcu.CarMcuManager;
import android.car.hardware.msm.CarMsmManager;
import android.car.hardware.scu.CarScuManager;
import android.car.hardware.tpms.CarTpmsManager;
import android.car.hardware.vcu.CarVcuManager;
import android.util.Log;
import java.util.List;
/* compiled from: CarServiceEventAdapter.java */
/* renamed from: le  reason: default package */
/* loaded from: classes.dex */
public class le implements CarBcmManager.CarBcmEventCallback, CarMcuManager.CarMcuEventCallback, CarVcuManager.CarVcuEventCallback, CarIcmManager.CarIcmEventCallback, CarTpmsManager.CarTpmsEventCallback, CarEpsManager.CarEpsEventCallback, CarAvasManager.CarAvasEventCallback, CarScuManager.CarScuEventCallback, CarEspManager.CarEspEventCallback, CarMsmManager.CarMsmEventCallback, CarCiuManager.CarCiuEventCallback, CarHvacManager.CarHvacEventCallback {
    private String a;
    private List<ke> b;
    private List<Integer> c;

    /* compiled from: CarServiceEventAdapter.java */
    /* renamed from: le$a */
    /* loaded from: classes.dex */
    class a implements Runnable {
        final /* synthetic */ CarPropertyValue b;

        a(CarPropertyValue carPropertyValue) {
            this.b = carPropertyValue;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (ke keVar : le.this.b) {
                keVar.onChangeEvent(this.b);
            }
        }
    }

    /* compiled from: CarServiceEventAdapter.java */
    /* renamed from: le$b */
    /* loaded from: classes.dex */
    class b implements Runnable {
        final /* synthetic */ int b;
        final /* synthetic */ int c;

        b(int i, int i2) {
            this.b = i;
            this.c = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (ke keVar : le.this.b) {
                keVar.onErrorEvent(this.b, this.c);
            }
        }
    }

    public le(String str, List<ke> list) {
        this.a = str;
        this.b = list;
    }

    private boolean b(int i) {
        List<Integer> list = this.c;
        if (list == null) {
            return true;
        }
        return list.contains(Integer.valueOf(i));
    }

    public void onChangeEvent(CarPropertyValue carPropertyValue) {
        if (b(carPropertyValue.getPropertyId())) {
            Log.d("CarServiceEventAdapter", "ServiceName:" + this.a + " onChangeEvent value = " + carPropertyValue.toString());
            he.a(new a(carPropertyValue));
        }
    }

    public void onErrorEvent(int i, int i2) {
        if (b(i)) {
            return;
        }
        Log.e("CarServiceEventAdapter", "ServiceName:" + this.a + " onErrorEvent error, propertyId = " + i + " zone = " + i2);
        he.a(new b(i, i2));
    }
}
