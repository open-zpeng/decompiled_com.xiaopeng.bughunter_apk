package com.xiaopeng.xui.interpolator;

import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public class SpringInterpolator implements Interpolator {
    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return (float) ((Math.pow(2.0d, (-11.0f) * f) * Math.sin(((f - 0.175f) * 6.283185307179586d) / 0.7f)) + 1.0d);
    }
}
