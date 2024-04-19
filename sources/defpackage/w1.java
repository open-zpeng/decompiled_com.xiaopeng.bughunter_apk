package defpackage;

import android.os.Build;
import android.view.ViewGroup;
/* compiled from: ViewGroupUtils.java */
/* renamed from: w1  reason: default package */
/* loaded from: classes.dex */
class w1 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static v1 a(ViewGroup viewGroup) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new u1(viewGroup);
        }
        return t1.g(viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(ViewGroup viewGroup, boolean z) {
        if (Build.VERSION.SDK_INT >= 18) {
            y1.b(viewGroup, z);
        } else {
            x1.b(viewGroup, z);
        }
    }
}
