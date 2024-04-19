package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import java.util.Map;
/* compiled from: ChangeBounds.java */
/* renamed from: b1  reason: default package */
/* loaded from: classes.dex */
public class b1 extends l1 {
    private static final String[] L = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    private static final Property<Drawable, PointF> M = new b(PointF.class, "boundsOrigin");
    private static final Property<k, PointF> N = new c(PointF.class, "topLeft");
    private static final Property<k, PointF> O = new d(PointF.class, "bottomRight");
    private static final Property<View, PointF> P = new e(PointF.class, "bottomRight");
    private static final Property<View, PointF> Q = new f(PointF.class, "topLeft");
    private static final Property<View, PointF> R = new g(PointF.class, RequestParameters.POSITION);
    private static j1 S = new j1();
    private int[] T = new int[2];
    private boolean U = false;
    private boolean V = false;

    /* compiled from: ChangeBounds.java */
    /* renamed from: b1$a */
    /* loaded from: classes.dex */
    class a extends AnimatorListenerAdapter {
        final /* synthetic */ ViewGroup a;
        final /* synthetic */ BitmapDrawable b;
        final /* synthetic */ View c;
        final /* synthetic */ float d;

        a(ViewGroup viewGroup, BitmapDrawable bitmapDrawable, View view, float f) {
            this.a = viewGroup;
            this.b = bitmapDrawable;
            this.c = view;
            this.d = f;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            c2.c(this.a).d(this.b);
            c2.h(this.c, this.d);
        }
    }

    /* compiled from: ChangeBounds.java */
    /* renamed from: b1$b */
    /* loaded from: classes.dex */
    static class b extends Property<Drawable, PointF> {
        private Rect a;

        b(Class cls, String str) {
            super(cls, str);
            this.a = new Rect();
        }

        @Override // android.util.Property
        /* renamed from: a */
        public PointF get(Drawable drawable) {
            drawable.copyBounds(this.a);
            Rect rect = this.a;
            return new PointF(rect.left, rect.top);
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(Drawable drawable, PointF pointF) {
            drawable.copyBounds(this.a);
            this.a.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable.setBounds(this.a);
        }
    }

    /* compiled from: ChangeBounds.java */
    /* renamed from: b1$c */
    /* loaded from: classes.dex */
    static class c extends Property<k, PointF> {
        c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public PointF get(k kVar) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(k kVar, PointF pointF) {
            kVar.c(pointF);
        }
    }

    /* compiled from: ChangeBounds.java */
    /* renamed from: b1$d */
    /* loaded from: classes.dex */
    static class d extends Property<k, PointF> {
        d(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public PointF get(k kVar) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(k kVar, PointF pointF) {
            kVar.a(pointF);
        }
    }

    /* compiled from: ChangeBounds.java */
    /* renamed from: b1$e */
    /* loaded from: classes.dex */
    static class e extends Property<View, PointF> {
        e(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(View view, PointF pointF) {
            c2.g(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    }

    /* compiled from: ChangeBounds.java */
    /* renamed from: b1$f */
    /* loaded from: classes.dex */
    static class f extends Property<View, PointF> {
        f(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(View view, PointF pointF) {
            c2.g(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    }

    /* compiled from: ChangeBounds.java */
    /* renamed from: b1$g */
    /* loaded from: classes.dex */
    static class g extends Property<View, PointF> {
        g(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(View view, PointF pointF) {
            int round = Math.round(pointF.x);
            int round2 = Math.round(pointF.y);
            c2.g(view, round, round2, view.getWidth() + round, view.getHeight() + round2);
        }
    }

    /* compiled from: ChangeBounds.java */
    /* renamed from: b1$h */
    /* loaded from: classes.dex */
    class h extends AnimatorListenerAdapter {
        final /* synthetic */ k a;
        private k mViewBounds;

        h(k kVar) {
            this.a = kVar;
            this.mViewBounds = kVar;
        }
    }

    /* compiled from: ChangeBounds.java */
    /* renamed from: b1$i */
    /* loaded from: classes.dex */
    class i extends AnimatorListenerAdapter {
        private boolean a;
        final /* synthetic */ View b;
        final /* synthetic */ Rect c;
        final /* synthetic */ int d;
        final /* synthetic */ int e;
        final /* synthetic */ int f;
        final /* synthetic */ int g;

        i(View view, Rect rect, int i, int i2, int i3, int i4) {
            this.b = view;
            this.c = rect;
            this.d = i;
            this.e = i2;
            this.f = i3;
            this.g = i4;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.a) {
                return;
            }
            v4.M(this.b, this.c);
            c2.g(this.b, this.d, this.e, this.f, this.g);
        }
    }

    /* compiled from: ChangeBounds.java */
    /* renamed from: b1$j */
    /* loaded from: classes.dex */
    class j extends m1 {
        boolean a = false;
        final /* synthetic */ ViewGroup b;

        j(ViewGroup viewGroup) {
            this.b = viewGroup;
        }

        @Override // defpackage.m1, defpackage.l1.f
        public void a(l1 l1Var) {
            w1.b(this.b, false);
        }

        @Override // defpackage.l1.f
        public void b(l1 l1Var) {
            if (!this.a) {
                w1.b(this.b, false);
            }
            l1Var.O(this);
        }

        @Override // defpackage.m1, defpackage.l1.f
        public void d(l1 l1Var) {
            w1.b(this.b, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ChangeBounds.java */
    /* renamed from: b1$k */
    /* loaded from: classes.dex */
    public static class k {
        private int a;
        private int b;
        private int c;
        private int d;
        private View e;
        private int f;
        private int g;

        k(View view) {
            this.e = view;
        }

        private void b() {
            c2.g(this.e, this.a, this.b, this.c, this.d);
            this.f = 0;
            this.g = 0;
        }

        void a(PointF pointF) {
            this.c = Math.round(pointF.x);
            this.d = Math.round(pointF.y);
            int i = this.g + 1;
            this.g = i;
            if (this.f == i) {
                b();
            }
        }

        void c(PointF pointF) {
            this.a = Math.round(pointF.x);
            this.b = Math.round(pointF.y);
            int i = this.f + 1;
            this.f = i;
            if (i == this.g) {
                b();
            }
        }
    }

    private void b0(r1 r1Var) {
        View view = r1Var.b;
        if (!v4.z(view) && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        r1Var.a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        r1Var.a.put("android:changeBounds:parent", r1Var.b.getParent());
        if (this.V) {
            r1Var.b.getLocationInWindow(this.T);
            r1Var.a.put("android:changeBounds:windowX", Integer.valueOf(this.T[0]));
            r1Var.a.put("android:changeBounds:windowY", Integer.valueOf(this.T[1]));
        }
        if (this.U) {
            r1Var.a.put("android:changeBounds:clip", v4.g(view));
        }
    }

    private boolean c0(View view, View view2) {
        if (this.V) {
            r1 s = s(view, true);
            if (s == null) {
                if (view == view2) {
                    return true;
                }
            } else if (view2 == s.b) {
                return true;
            }
            return false;
        }
        return true;
    }

    @Override // defpackage.l1
    public String[] C() {
        return L;
    }

    @Override // defpackage.l1
    public void f(r1 r1Var) {
        b0(r1Var);
    }

    @Override // defpackage.l1
    public void i(r1 r1Var) {
        b0(r1Var);
    }

    @Override // defpackage.l1
    public Animator m(ViewGroup viewGroup, r1 r1Var, r1 r1Var2) {
        int i2;
        View view;
        int i3;
        Rect rect;
        ObjectAnimator objectAnimator;
        Animator c2;
        if (r1Var == null || r1Var2 == null) {
            return null;
        }
        Map<String, Object> map = r1Var.a;
        Map<String, Object> map2 = r1Var2.a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = r1Var2.b;
        if (c0(viewGroup2, viewGroup3)) {
            Rect rect2 = (Rect) r1Var.a.get("android:changeBounds:bounds");
            Rect rect3 = (Rect) r1Var2.a.get("android:changeBounds:bounds");
            int i4 = rect2.left;
            int i5 = rect3.left;
            int i6 = rect2.top;
            int i7 = rect3.top;
            int i8 = rect2.right;
            int i9 = rect3.right;
            int i10 = rect2.bottom;
            int i11 = rect3.bottom;
            int i12 = i8 - i4;
            int i13 = i10 - i6;
            int i14 = i9 - i5;
            int i15 = i11 - i7;
            Rect rect4 = (Rect) r1Var.a.get("android:changeBounds:clip");
            Rect rect5 = (Rect) r1Var2.a.get("android:changeBounds:clip");
            if ((i12 == 0 || i13 == 0) && (i14 == 0 || i15 == 0)) {
                i2 = 0;
            } else {
                i2 = (i4 == i5 && i6 == i7) ? 0 : 1;
                if (i8 != i9 || i10 != i11) {
                    i2++;
                }
            }
            if ((rect4 != null && !rect4.equals(rect5)) || (rect4 == null && rect5 != null)) {
                i2++;
            }
            if (i2 > 0) {
                if (!this.U) {
                    view = view2;
                    c2.g(view, i4, i6, i8, i10);
                    if (i2 == 2) {
                        if (i12 == i14 && i13 == i15) {
                            c2 = e1.a(view, R, u().a(i4, i6, i5, i7));
                        } else {
                            k kVar = new k(view);
                            ObjectAnimator a2 = e1.a(kVar, N, u().a(i4, i6, i5, i7));
                            ObjectAnimator a3 = e1.a(kVar, O, u().a(i8, i10, i9, i11));
                            AnimatorSet animatorSet = new AnimatorSet();
                            animatorSet.playTogether(a2, a3);
                            animatorSet.addListener(new h(kVar));
                            c2 = animatorSet;
                        }
                    } else if (i4 == i5 && i6 == i7) {
                        c2 = e1.a(view, P, u().a(i8, i10, i9, i11));
                    } else {
                        c2 = e1.a(view, Q, u().a(i4, i6, i5, i7));
                    }
                } else {
                    view = view2;
                    c2.g(view, i4, i6, Math.max(i12, i14) + i4, Math.max(i13, i15) + i6);
                    ObjectAnimator a4 = (i4 == i5 && i6 == i7) ? null : e1.a(view, R, u().a(i4, i6, i5, i7));
                    if (rect4 == null) {
                        i3 = 0;
                        rect = new Rect(0, 0, i12, i13);
                    } else {
                        i3 = 0;
                        rect = rect4;
                    }
                    Rect rect6 = rect5 == null ? new Rect(i3, i3, i14, i15) : rect5;
                    if (rect.equals(rect6)) {
                        objectAnimator = null;
                    } else {
                        v4.M(view, rect);
                        j1 j1Var = S;
                        Object[] objArr = new Object[2];
                        objArr[i3] = rect;
                        objArr[1] = rect6;
                        ObjectAnimator ofObject = ObjectAnimator.ofObject(view, "clipBounds", j1Var, objArr);
                        ofObject.addListener(new i(view, rect5, i5, i7, i9, i11));
                        objectAnimator = ofObject;
                    }
                    c2 = q1.c(a4, objectAnimator);
                }
                if (view.getParent() instanceof ViewGroup) {
                    ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                    w1.b(viewGroup4, true);
                    a(new j(viewGroup4));
                }
                return c2;
            }
            return null;
        }
        int intValue = ((Integer) r1Var.a.get("android:changeBounds:windowX")).intValue();
        int intValue2 = ((Integer) r1Var.a.get("android:changeBounds:windowY")).intValue();
        int intValue3 = ((Integer) r1Var2.a.get("android:changeBounds:windowX")).intValue();
        int intValue4 = ((Integer) r1Var2.a.get("android:changeBounds:windowY")).intValue();
        if (intValue == intValue3 && intValue2 == intValue4) {
            return null;
        }
        viewGroup.getLocationInWindow(this.T);
        Bitmap createBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
        view2.draw(new Canvas(createBitmap));
        BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
        float d2 = c2.d(view2);
        c2.h(view2, 0.0f);
        c2.c(viewGroup).b(bitmapDrawable);
        f1 u = u();
        int[] iArr = this.T;
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, h1.a(M, u.a(intValue - iArr[0], intValue2 - iArr[1], intValue3 - iArr[0], intValue4 - iArr[1])));
        ofPropertyValuesHolder.addListener(new a(viewGroup, bitmapDrawable, view2, d2));
        return ofPropertyValuesHolder;
    }
}
