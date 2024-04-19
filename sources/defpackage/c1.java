package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
/* compiled from: Fade.java */
/* renamed from: c1  reason: default package */
/* loaded from: classes.dex */
public class c1 extends h2 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Fade.java */
    /* renamed from: c1$a */
    /* loaded from: classes.dex */
    public class a extends m1 {
        final /* synthetic */ View a;

        a(View view) {
            this.a = view;
        }

        @Override // defpackage.l1.f
        public void b(l1 l1Var) {
            c2.h(this.a, 1.0f);
            c2.a(this.a);
            l1Var.O(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Fade.java */
    /* renamed from: c1$b */
    /* loaded from: classes.dex */
    public static class b extends AnimatorListenerAdapter {
        private final View a;
        private boolean b = false;

        b(View view) {
            this.a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            c2.h(this.a, 1.0f);
            if (this.b) {
                this.a.setLayerType(0, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (v4.w(this.a) && this.a.getLayerType() == 0) {
                this.b = true;
                this.a.setLayerType(2, null);
            }
        }
    }

    public c1(int i) {
        h0(i);
    }

    private Animator i0(View view, float f, float f2) {
        if (f == f2) {
            return null;
        }
        c2.h(view, f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, c2.d, f2);
        ofFloat.addListener(new b(view));
        a(new a(view));
        return ofFloat;
    }

    private static float j0(r1 r1Var, float f) {
        Float f2;
        return (r1Var == null || (f2 = (Float) r1Var.a.get("android:fade:transitionAlpha")) == null) ? f : f2.floatValue();
    }

    @Override // defpackage.h2
    public Animator e0(ViewGroup viewGroup, View view, r1 r1Var, r1 r1Var2) {
        float j0 = j0(r1Var, 0.0f);
        return i0(view, j0 != 1.0f ? j0 : 0.0f, 1.0f);
    }

    @Override // defpackage.h2
    public Animator g0(ViewGroup viewGroup, View view, r1 r1Var, r1 r1Var2) {
        c2.f(view);
        return i0(view, j0(r1Var, 1.0f), 0.0f);
    }

    @Override // defpackage.h2, defpackage.l1
    public void i(r1 r1Var) {
        super.i(r1Var);
        r1Var.a.put("android:fade:transitionAlpha", Float.valueOf(c2.d(r1Var.b)));
    }
}
