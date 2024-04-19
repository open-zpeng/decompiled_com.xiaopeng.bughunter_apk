package defpackage;

import android.view.View;
import android.view.WindowId;
/* compiled from: WindowIdApi18.java */
/* renamed from: j2  reason: default package */
/* loaded from: classes.dex */
class j2 implements k2 {
    private final WindowId a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j2(View view) {
        this.a = view.getWindowId();
    }

    public boolean equals(Object obj) {
        return (obj instanceof j2) && ((j2) obj).a.equals(this.a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
