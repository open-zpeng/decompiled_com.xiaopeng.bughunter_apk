package defpackage;

import android.car.CarManagerBase;
import android.car.CarNotConnectedException;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
/* compiled from: BaseStrategy.java */
/* renamed from: pe  reason: default package */
/* loaded from: classes.dex */
public abstract class pe implements ne {
    protected List<ke> a = new ArrayList();

    public final void b(ke keVar) {
        if (keVar != null) {
            if (this.a.contains(keVar)) {
                return;
            }
            this.a.add(keVar);
            return;
        }
        throw new RuntimeException("CarService call back can not be null.");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final CarManagerBase c(String str) {
        try {
            Object carManager = ge.e().getCarManager(str);
            if (carManager instanceof CarManagerBase) {
                return (CarManagerBase) carManager;
            }
            return null;
        } catch (CarNotConnectedException e) {
            Log.e("BaseStrategy", "getCarManagerService error, CarNotConnectedException");
            e.printStackTrace();
            return null;
        }
    }
}
