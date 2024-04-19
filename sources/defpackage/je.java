package defpackage;

import android.car.hardware.CarPropertyValue;
import android.util.Log;
/* compiled from: BaseCallbackAdapter.java */
/* renamed from: je  reason: default package */
/* loaded from: classes.dex */
public abstract class je implements ke {
    protected abstract void a(int i, Object obj);

    @Override // defpackage.ke
    public final void onChangeEvent(CarPropertyValue carPropertyValue) {
        if (carPropertyValue == null) {
            return;
        }
        Object value = carPropertyValue.getValue();
        if (value == null) {
            Log.e("BaseCallbackAdapter", "onChangeEvent error, value is null.");
        } else {
            a(carPropertyValue.getPropertyId(), value);
        }
    }

    @Override // defpackage.ke
    public void onErrorEvent(int i, int i2) {
    }
}
