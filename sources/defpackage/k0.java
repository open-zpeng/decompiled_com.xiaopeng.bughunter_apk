package defpackage;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.support.design.widget.k;
import android.util.Property;
/* compiled from: CircularRevealWidget.java */
/* renamed from: k0  reason: default package */
/* loaded from: classes.dex */
public interface k0 {

    /* compiled from: CircularRevealWidget.java */
    /* renamed from: k0$b */
    /* loaded from: classes.dex */
    public static class b implements TypeEvaluator<e> {
        public static final TypeEvaluator<e> a = new b();
        private final e b = new e();

        @Override // android.animation.TypeEvaluator
        /* renamed from: a */
        public e evaluate(float f, e eVar, e eVar2) {
            this.b.a(k.c(eVar.a, eVar2.a, f), k.c(eVar.b, eVar2.b, f), k.c(eVar.c, eVar2.c, f));
            return this.b;
        }
    }

    /* compiled from: CircularRevealWidget.java */
    /* renamed from: k0$c */
    /* loaded from: classes.dex */
    public static class c extends Property<k0, e> {
        public static final Property<k0, e> a = new c("circularReveal");

        private c(String str) {
            super(e.class, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public e get(k0 k0Var) {
            return k0Var.getRevealInfo();
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(k0 k0Var, e eVar) {
            k0Var.setRevealInfo(eVar);
        }
    }

    /* compiled from: CircularRevealWidget.java */
    /* renamed from: k0$d */
    /* loaded from: classes.dex */
    public static class d extends Property<k0, Integer> {
        public static final Property<k0, Integer> a = new d("circularRevealScrimColor");

        private d(String str) {
            super(Integer.class, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Integer get(k0 k0Var) {
            return Integer.valueOf(k0Var.getCircularRevealScrimColor());
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(k0 k0Var, Integer num) {
            k0Var.setCircularRevealScrimColor(num.intValue());
        }
    }

    /* compiled from: CircularRevealWidget.java */
    /* renamed from: k0$e */
    /* loaded from: classes.dex */
    public static class e {
        public float a;
        public float b;
        public float c;

        public void a(float f, float f2, float f3) {
            this.a = f;
            this.b = f2;
            this.c = f3;
        }

        private e() {
        }

        public e(float f, float f2, float f3) {
            this.a = f;
            this.b = f2;
            this.c = f3;
        }
    }

    void a();

    void b();

    int getCircularRevealScrimColor();

    e getRevealInfo();

    void setCircularRevealOverlayDrawable(Drawable drawable);

    void setCircularRevealScrimColor(int i);

    void setRevealInfo(e eVar);
}
