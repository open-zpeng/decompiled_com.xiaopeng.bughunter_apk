package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.os.Build;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import defpackage.k0;
/* compiled from: CircularRevealCompat.java */
/* renamed from: h0  reason: default package */
/* loaded from: classes.dex */
public final class h0 {

    /* compiled from: CircularRevealCompat.java */
    /* renamed from: h0$a */
    /* loaded from: classes.dex */
    static class a extends AnimatorListenerAdapter {
        final /* synthetic */ k0 a;

        a(k0 k0Var) {
            this.a = k0Var;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.a.a();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.a.b();
        }
    }

    public static Animator a(k0 k0Var, float f, float f2, float f3) {
        ObjectAnimator ofObject = ObjectAnimator.ofObject(k0Var, (Property<k0, V>) k0.c.a, (TypeEvaluator) k0.b.a, (Object[]) new k0.e[]{new k0.e(f, f2, f3)});
        if (Build.VERSION.SDK_INT >= 21) {
            k0.e revealInfo = k0Var.getRevealInfo();
            if (revealInfo != null) {
                Animator createCircularReveal = ViewAnimationUtils.createCircularReveal((View) k0Var, (int) f, (int) f2, revealInfo.c, f3);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(ofObject, createCircularReveal);
                return animatorSet;
            }
            throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
        }
        return ofObject;
    }

    public static Animator.AnimatorListener b(k0 k0Var) {
        return new a(k0Var);
    }
}
