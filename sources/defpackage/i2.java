package defpackage;

import android.os.IBinder;
/* compiled from: WindowIdApi14.java */
/* renamed from: i2  reason: default package */
/* loaded from: classes.dex */
class i2 implements k2 {
    private final IBinder a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i2(IBinder iBinder) {
        this.a = iBinder;
    }

    public boolean equals(Object obj) {
        return (obj instanceof i2) && ((i2) obj).a.equals(this.a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
