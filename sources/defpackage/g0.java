package defpackage;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.support.design.internal.c;
import android.support.v4.graphics.drawable.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MaterialButtonHelper.java */
/* renamed from: g0  reason: default package */
/* loaded from: classes.dex */
public class g0 {
    private static final boolean a;
    private final e0 b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private PorterDuff.Mode i;
    private ColorStateList j;
    private ColorStateList k;
    private ColorStateList l;
    private GradientDrawable p;
    private Drawable q;
    private GradientDrawable r;
    private Drawable s;
    private GradientDrawable t;
    private GradientDrawable u;
    private GradientDrawable v;
    private final Paint m = new Paint(1);
    private final Rect n = new Rect();
    private final RectF o = new RectF();
    private boolean w = false;

    static {
        a = Build.VERSION.SDK_INT >= 21;
    }

    public g0(e0 e0Var) {
        this.b = e0Var;
    }

    private Drawable a() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.p = gradientDrawable;
        gradientDrawable.setCornerRadius(this.g + 1.0E-5f);
        this.p.setColor(-1);
        Drawable q = a.q(this.p);
        this.q = q;
        a.o(q, this.j);
        PorterDuff.Mode mode = this.i;
        if (mode != null) {
            a.p(this.q, mode);
        }
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        this.r = gradientDrawable2;
        gradientDrawable2.setCornerRadius(this.g + 1.0E-5f);
        this.r.setColor(-1);
        Drawable q2 = a.q(this.r);
        this.s = q2;
        a.o(q2, this.l);
        return y(new LayerDrawable(new Drawable[]{this.q, this.s}));
    }

    @TargetApi(21)
    private Drawable b() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.t = gradientDrawable;
        gradientDrawable.setCornerRadius(this.g + 1.0E-5f);
        this.t.setColor(-1);
        x();
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        this.u = gradientDrawable2;
        gradientDrawable2.setCornerRadius(this.g + 1.0E-5f);
        this.u.setColor(0);
        this.u.setStroke(this.h, this.k);
        InsetDrawable y = y(new LayerDrawable(new Drawable[]{this.t, this.u}));
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        this.v = gradientDrawable3;
        gradientDrawable3.setCornerRadius(this.g + 1.0E-5f);
        this.v.setColor(-1);
        return new f0(o0.a(this.l), y, this.v);
    }

    private GradientDrawable t() {
        if (!a || this.b.getBackground() == null) {
            return null;
        }
        return (GradientDrawable) ((LayerDrawable) ((InsetDrawable) ((RippleDrawable) this.b.getBackground()).getDrawable(0)).getDrawable()).getDrawable(0);
    }

    private GradientDrawable u() {
        if (!a || this.b.getBackground() == null) {
            return null;
        }
        return (GradientDrawable) ((LayerDrawable) ((InsetDrawable) ((RippleDrawable) this.b.getBackground()).getDrawable(0)).getDrawable()).getDrawable(1);
    }

    private void w() {
        boolean z = a;
        if (z && this.u != null) {
            this.b.setInternalBackground(b());
        } else if (z) {
        } else {
            this.b.invalidate();
        }
    }

    private void x() {
        GradientDrawable gradientDrawable = this.t;
        if (gradientDrawable != null) {
            a.o(gradientDrawable, this.j);
            PorterDuff.Mode mode = this.i;
            if (mode != null) {
                a.p(this.t, mode);
            }
        }
    }

    private InsetDrawable y(Drawable drawable) {
        return new InsetDrawable(drawable, this.c, this.e, this.d, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(Canvas canvas) {
        if (canvas == null || this.k == null || this.h <= 0) {
            return;
        }
        this.n.set(this.b.getBackground().getBounds());
        RectF rectF = this.o;
        Rect rect = this.n;
        int i = this.h;
        rectF.set(rect.left + (i / 2.0f) + this.c, rect.top + (i / 2.0f) + this.e, (rect.right - (i / 2.0f)) - this.d, (rect.bottom - (i / 2.0f)) - this.f);
        float f = this.g - (this.h / 2.0f);
        canvas.drawRoundRect(this.o, f, f, this.m);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList e() {
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList f() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList h() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode i() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean j() {
        return this.w;
    }

    public void k(TypedArray typedArray) {
        this.c = typedArray.getDimensionPixelOffset(t.X, 0);
        this.d = typedArray.getDimensionPixelOffset(t.Y, 0);
        this.e = typedArray.getDimensionPixelOffset(t.Z, 0);
        this.f = typedArray.getDimensionPixelOffset(t.a0, 0);
        this.g = typedArray.getDimensionPixelSize(t.d0, 0);
        this.h = typedArray.getDimensionPixelSize(t.m0, 0);
        this.i = c.a(typedArray.getInt(t.c0, -1), PorterDuff.Mode.SRC_IN);
        this.j = n0.a(this.b.getContext(), typedArray, t.b0);
        this.k = n0.a(this.b.getContext(), typedArray, t.l0);
        this.l = n0.a(this.b.getContext(), typedArray, t.k0);
        this.m.setStyle(Paint.Style.STROKE);
        this.m.setStrokeWidth(this.h);
        Paint paint = this.m;
        ColorStateList colorStateList = this.k;
        paint.setColor(colorStateList != null ? colorStateList.getColorForState(this.b.getDrawableState(), 0) : 0);
        int r = v4.r(this.b);
        int paddingTop = this.b.getPaddingTop();
        int q = v4.q(this.b);
        int paddingBottom = this.b.getPaddingBottom();
        this.b.setInternalBackground(a ? b() : a());
        v4.T(this.b, r + this.c, paddingTop + this.e, q + this.d, paddingBottom + this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(int i) {
        GradientDrawable gradientDrawable;
        GradientDrawable gradientDrawable2;
        boolean z = a;
        if (z && (gradientDrawable2 = this.t) != null) {
            gradientDrawable2.setColor(i);
        } else if (z || (gradientDrawable = this.p) == null) {
        } else {
            gradientDrawable.setColor(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m() {
        this.w = true;
        this.b.setSupportBackgroundTintList(this.j);
        this.b.setSupportBackgroundTintMode(this.i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(int i) {
        GradientDrawable gradientDrawable;
        if (this.g != i) {
            this.g = i;
            boolean z = a;
            if (!z || this.t == null || this.u == null || this.v == null) {
                if (z || (gradientDrawable = this.p) == null || this.r == null) {
                    return;
                }
                float f = i + 1.0E-5f;
                gradientDrawable.setCornerRadius(f);
                this.r.setCornerRadius(f);
                this.b.invalidate();
                return;
            }
            if (Build.VERSION.SDK_INT == 21) {
                float f2 = i + 1.0E-5f;
                t().setCornerRadius(f2);
                u().setCornerRadius(f2);
            }
            float f3 = i + 1.0E-5f;
            this.t.setCornerRadius(f3);
            this.u.setCornerRadius(f3);
            this.v.setCornerRadius(f3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(ColorStateList colorStateList) {
        Drawable drawable;
        if (this.l != colorStateList) {
            this.l = colorStateList;
            boolean z = a;
            if (z && (this.b.getBackground() instanceof RippleDrawable)) {
                ((RippleDrawable) this.b.getBackground()).setColor(colorStateList);
            } else if (z || (drawable = this.s) == null) {
            } else {
                a.o(drawable, colorStateList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(ColorStateList colorStateList) {
        if (this.k != colorStateList) {
            this.k = colorStateList;
            this.m.setColor(colorStateList != null ? colorStateList.getColorForState(this.b.getDrawableState(), 0) : 0);
            w();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(int i) {
        if (this.h != i) {
            this.h = i;
            this.m.setStrokeWidth(i);
            w();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(ColorStateList colorStateList) {
        if (this.j != colorStateList) {
            this.j = colorStateList;
            if (a) {
                x();
                return;
            }
            Drawable drawable = this.q;
            if (drawable != null) {
                a.o(drawable, colorStateList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(PorterDuff.Mode mode) {
        if (this.i != mode) {
            this.i = mode;
            if (a) {
                x();
                return;
            }
            Drawable drawable = this.q;
            if (drawable == null || mode == null) {
                return;
            }
            a.p(drawable, mode);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(int i, int i2) {
        GradientDrawable gradientDrawable = this.v;
        if (gradientDrawable != null) {
            gradientDrawable.setBounds(this.c, this.e, i2 - this.d, i - this.f);
        }
    }
}
