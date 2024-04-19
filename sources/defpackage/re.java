package defpackage;

import android.car.hardware.input.CarInputManager;
import java.util.ArrayList;
/* compiled from: InputStrategy.java */
/* renamed from: re  reason: default package */
/* loaded from: classes.dex */
public class re extends pe implements ne {
    private CarInputManager b;

    @Override // defpackage.ne
    public void a() {
        try {
            tf.l("InputStrategy", "InputStrategy register");
            this.b = c("xp_input");
            ArrayList arrayList = new ArrayList();
            arrayList.add(557851176);
            this.b.registerPropCallback(arrayList, new le("InputStrategy", this.a));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
