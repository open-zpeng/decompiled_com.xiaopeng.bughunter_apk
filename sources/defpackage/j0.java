package defpackage;

import android.os.Build;
/* compiled from: CircularRevealHelper.java */
/* renamed from: j0  reason: default package */
/* loaded from: classes.dex */
public class j0 {
    public static final int a;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            a = 2;
        } else if (i >= 18) {
            a = 1;
        } else {
            a = 0;
        }
    }
}
