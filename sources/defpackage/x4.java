package defpackage;

import android.os.Build;
import android.view.ViewGroup;
/* compiled from: ViewGroupCompat.java */
/* renamed from: x4  reason: default package */
/* loaded from: classes.dex */
public final class x4 {
    public static boolean a(ViewGroup viewGroup) {
        if (Build.VERSION.SDK_INT >= 21) {
            return viewGroup.isTransitionGroup();
        }
        Boolean bool = (Boolean) viewGroup.getTag(g.a);
        return ((bool == null || !bool.booleanValue()) && viewGroup.getBackground() == null && v4.s(viewGroup) == null) ? false : true;
    }
}
