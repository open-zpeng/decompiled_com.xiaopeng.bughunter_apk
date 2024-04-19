package defpackage;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
/* compiled from: MotionSpec.java */
/* renamed from: b0  reason: default package */
/* loaded from: classes.dex */
public class b0 {
    private final c4<String, c0> a = new c4<>();

    private static void a(b0 b0Var, Animator animator) {
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            b0Var.g(objectAnimator.getPropertyName(), c0.b(objectAnimator));
            return;
        }
        throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + animator);
    }

    public static b0 b(Context context, int i) {
        try {
            Animator loadAnimator = AnimatorInflater.loadAnimator(context, i);
            if (loadAnimator instanceof AnimatorSet) {
                return c(((AnimatorSet) loadAnimator).getChildAnimations());
            }
            if (loadAnimator != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(loadAnimator);
                return c(arrayList);
            }
            return null;
        } catch (Exception e) {
            Log.w("MotionSpec", "Can't load animation resource ID #0x" + Integer.toHexString(i), e);
            return null;
        }
    }

    private static b0 c(List<Animator> list) {
        b0 b0Var = new b0();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            a(b0Var, list.get(i));
        }
        return b0Var;
    }

    public c0 d(String str) {
        if (f(str)) {
            return this.a.get(str);
        }
        throw new IllegalArgumentException();
    }

    public long e() {
        int size = this.a.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            c0 m = this.a.m(i);
            j = Math.max(j, m.c() + m.d());
        }
        return j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b0.class != obj.getClass()) {
            return false;
        }
        return this.a.equals(((b0) obj).a);
    }

    public boolean f(String str) {
        return this.a.get(str) != null;
    }

    public void g(String str, c0 c0Var) {
        this.a.put(str, c0Var);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return '\n' + b0.class.getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " timings: " + this.a + "}\n";
    }
}
