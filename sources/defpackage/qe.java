package defpackage;

import android.car.hardware.icm.CarIcmManager;
import java.util.ArrayList;
/* compiled from: IcmStrategy.java */
/* renamed from: qe  reason: default package */
/* loaded from: classes.dex */
public class qe extends pe implements ne {
    private CarIcmManager b;

    @Override // defpackage.ne
    public void a() {
        try {
            tf.l("IcmStrategy", "IcmStrategy register");
            this.b = c("xp_icm");
            ArrayList arrayList = new ArrayList();
            arrayList.add(554702429);
            this.b.registerPropCallback(arrayList, new le("IcmStrategy", this.a));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
