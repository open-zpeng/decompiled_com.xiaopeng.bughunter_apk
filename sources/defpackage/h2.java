package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import defpackage.l1;
import defpackage.z0;
/* compiled from: Visibility.java */
/* renamed from: h2  reason: default package */
/* loaded from: classes.dex */
public abstract class h2 extends l1 {
    private static final String[] L = {"android:visibility:visibility", "android:visibility:parent"};
    private int M = 3;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Visibility.java */
    /* renamed from: h2$a */
    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {
        final /* synthetic */ v1 a;
        final /* synthetic */ View b;

        a(v1 v1Var, View view) {
            this.a = v1Var;
            this.b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.a.c(this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Visibility.java */
    /* renamed from: h2$b */
    /* loaded from: classes.dex */
    public static class b extends AnimatorListenerAdapter implements l1.f, z0.a {
        private final View a;
        private final int b;
        private final ViewGroup c;
        private final boolean d;
        private boolean e;
        boolean f = false;

        b(View view, int i, boolean z) {
            this.a = view;
            this.b = i;
            this.c = (ViewGroup) view.getParent();
            this.d = z;
            f(true);
        }

        private void e() {
            if (!this.f) {
                c2.i(this.a, this.b);
                ViewGroup viewGroup = this.c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            f(false);
        }

        private void f(boolean z) {
            ViewGroup viewGroup;
            if (!this.d || this.e == z || (viewGroup = this.c) == null) {
                return;
            }
            this.e = z;
            w1.b(viewGroup, z);
        }

        @Override // defpackage.l1.f
        public void a(l1 l1Var) {
            f(false);
        }

        @Override // defpackage.l1.f
        public void b(l1 l1Var) {
            e();
            l1Var.O(this);
        }

        @Override // defpackage.l1.f
        public void c(l1 l1Var) {
        }

        @Override // defpackage.l1.f
        public void d(l1 l1Var) {
            f(true);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            e();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, defpackage.z0.a
        public void onAnimationPause(Animator animator) {
            if (this.f) {
                return;
            }
            c2.i(this.a, this.b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, defpackage.z0.a
        public void onAnimationResume(Animator animator) {
            if (this.f) {
                return;
            }
            c2.i(this.a, 0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Visibility.java */
    /* renamed from: h2$c */
    /* loaded from: classes.dex */
    public static class c {
        boolean a;
        boolean b;
        int c;
        int d;
        ViewGroup e;
        ViewGroup f;

        c() {
        }
    }

    private void b0(r1 r1Var) {
        r1Var.a.put("android:visibility:visibility", Integer.valueOf(r1Var.b.getVisibility()));
        r1Var.a.put("android:visibility:parent", r1Var.b.getParent());
        int[] iArr = new int[2];
        r1Var.b.getLocationOnScreen(iArr);
        r1Var.a.put("android:visibility:screenLocation", iArr);
    }

    private c c0(r1 r1Var, r1 r1Var2) {
        c cVar = new c();
        cVar.a = false;
        cVar.b = false;
        if (r1Var != null && r1Var.a.containsKey("android:visibility:visibility")) {
            cVar.c = ((Integer) r1Var.a.get("android:visibility:visibility")).intValue();
            cVar.e = (ViewGroup) r1Var.a.get("android:visibility:parent");
        } else {
            cVar.c = -1;
            cVar.e = null;
        }
        if (r1Var2 != null && r1Var2.a.containsKey("android:visibility:visibility")) {
            cVar.d = ((Integer) r1Var2.a.get("android:visibility:visibility")).intValue();
            cVar.f = (ViewGroup) r1Var2.a.get("android:visibility:parent");
        } else {
            cVar.d = -1;
            cVar.f = null;
        }
        if (r1Var != null && r1Var2 != null) {
            int i = cVar.c;
            int i2 = cVar.d;
            if (i == i2 && cVar.e == cVar.f) {
                return cVar;
            }
            if (i != i2) {
                if (i == 0) {
                    cVar.b = false;
                    cVar.a = true;
                } else if (i2 == 0) {
                    cVar.b = true;
                    cVar.a = true;
                }
            } else if (cVar.f == null) {
                cVar.b = false;
                cVar.a = true;
            } else if (cVar.e == null) {
                cVar.b = true;
                cVar.a = true;
            }
        } else if (r1Var == null && cVar.d == 0) {
            cVar.b = true;
            cVar.a = true;
        } else if (r1Var2 == null && cVar.c == 0) {
            cVar.b = false;
            cVar.a = true;
        }
        return cVar;
    }

    @Override // defpackage.l1
    public String[] C() {
        return L;
    }

    @Override // defpackage.l1
    public boolean E(r1 r1Var, r1 r1Var2) {
        if (r1Var == null && r1Var2 == null) {
            return false;
        }
        if (r1Var == null || r1Var2 == null || r1Var2.a.containsKey("android:visibility:visibility") == r1Var.a.containsKey("android:visibility:visibility")) {
            c c0 = c0(r1Var, r1Var2);
            if (c0.a) {
                return c0.c == 0 || c0.d == 0;
            }
            return false;
        }
        return false;
    }

    public Animator d0(ViewGroup viewGroup, r1 r1Var, int i, r1 r1Var2, int i2) {
        if ((this.M & 1) != 1 || r1Var2 == null) {
            return null;
        }
        if (r1Var == null) {
            View view = (View) r1Var2.b.getParent();
            if (c0(s(view, false), D(view, false)).a) {
                return null;
            }
        }
        return e0(viewGroup, r1Var2.b, r1Var, r1Var2);
    }

    public abstract Animator e0(ViewGroup viewGroup, View view, r1 r1Var, r1 r1Var2);

    @Override // defpackage.l1
    public void f(r1 r1Var) {
        b0(r1Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0087 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ee A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.animation.Animator f0(android.view.ViewGroup r7, defpackage.r1 r8, int r9, defpackage.r1 r10, int r11) {
        /*
            Method dump skipped, instructions count: 239
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.h2.f0(android.view.ViewGroup, r1, int, r1, int):android.animation.Animator");
    }

    public abstract Animator g0(ViewGroup viewGroup, View view, r1 r1Var, r1 r1Var2);

    public void h0(int i) {
        if ((i & (-4)) == 0) {
            this.M = i;
            return;
        }
        throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
    }

    @Override // defpackage.l1
    public void i(r1 r1Var) {
        b0(r1Var);
    }

    @Override // defpackage.l1
    public Animator m(ViewGroup viewGroup, r1 r1Var, r1 r1Var2) {
        c c0 = c0(r1Var, r1Var2);
        if (c0.a) {
            if (c0.e == null && c0.f == null) {
                return null;
            }
            if (c0.b) {
                return d0(viewGroup, r1Var, c0.c, r1Var2, c0.d);
            }
            return f0(viewGroup, r1Var, c0.c, r1Var2, c0.d);
        }
        return null;
    }
}
