package com.xiaopeng.xui.widgets.dialog;

import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import com.xiaopeng.xui.anims.XAnimator;
import com.xiaopeng.xui.interpolator.EaseCubicInterpolator;
/* loaded from: classes.dex */
public class XDialogAnimUtils {
    public static void startDismissAnimation(View view) {
        startDismissAnimation(view, null);
    }

    public static void startShowAnimation(View view) {
        startShowAnimation(view, null);
    }

    public static void startDismissAnimation(View view, AnimatorListenerAdapter animatorListenerAdapter) {
        new XAnimator.Builder().animators(ObjectAnimator.ofFloat(view, View.SCALE_X, 1.0f, 0.95f), ObjectAnimator.ofFloat(view, View.SCALE_Y, 1.0f, 0.95f), ObjectAnimator.ofFloat(view, View.ALPHA, 1.0f, 0.0f)).target(view).interpolator(new EaseCubicInterpolator()).addListener(animatorListenerAdapter).duration(200L).start();
    }

    public static void startShowAnimation(View view, AnimatorListenerAdapter animatorListenerAdapter) {
        new XAnimator.Builder().animators(ObjectAnimator.ofFloat(view, View.SCALE_X, 0.95f, 1.0f), ObjectAnimator.ofFloat(view, View.SCALE_Y, 0.95f, 1.0f), ObjectAnimator.ofFloat(view, View.ALPHA, 0.0f, 1.0f)).target(view).interpolator(new EaseCubicInterpolator()).addListener(animatorListenerAdapter).duration(200L).start();
    }
}
