package defpackage;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
/* compiled from: AnimationUtils.java */
/* renamed from: u  reason: default package */
/* loaded from: classes.dex */
public class u {
    public static final TimeInterpolator a = new LinearInterpolator();
    public static final TimeInterpolator b = new h5();
    public static final TimeInterpolator c = new g5();
    public static final TimeInterpolator d = new i5();
    public static final TimeInterpolator e = new DecelerateInterpolator();

    public static float a(float f, float f2, float f3) {
        return f + (f3 * (f2 - f));
    }
}
