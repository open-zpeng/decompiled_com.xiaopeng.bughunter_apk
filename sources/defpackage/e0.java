package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.design.internal.b;
import android.support.design.internal.c;
import android.support.v4.graphics.drawable.a;
import android.support.v4.widget.m;
import android.support.v7.widget.g;
import android.util.AttributeSet;
import android.util.Log;
/* compiled from: MaterialButton.java */
/* renamed from: e0  reason: default package */
/* loaded from: classes.dex */
public class e0 extends g {
    private final g0 d;
    private int e;
    private PorterDuff.Mode f;
    private ColorStateList g;
    private Drawable h;
    private int i;
    private int j;
    private int k;

    public e0(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, m.materialButtonStyle);
    }

    private boolean a() {
        return v4.n(this) == 1;
    }

    private boolean b() {
        g0 g0Var = this.d;
        return (g0Var == null || g0Var.j()) ? false : true;
    }

    private void c() {
        Drawable drawable = this.h;
        if (drawable != null) {
            Drawable mutate = drawable.mutate();
            this.h = mutate;
            a.o(mutate, this.g);
            PorterDuff.Mode mode = this.f;
            if (mode != null) {
                a.p(this.h, mode);
            }
            int i = this.i;
            if (i == 0) {
                i = this.h.getIntrinsicWidth();
            }
            int i2 = this.i;
            if (i2 == 0) {
                i2 = this.h.getIntrinsicHeight();
            }
            Drawable drawable2 = this.h;
            int i3 = this.j;
            drawable2.setBounds(i3, 0, i + i3, i2);
        }
        m.f(this, this.h, null, null, null);
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        if (b()) {
            return this.d.d();
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.h;
    }

    public int getIconGravity() {
        return this.k;
    }

    public int getIconPadding() {
        return this.e;
    }

    public int getIconSize() {
        return this.i;
    }

    public ColorStateList getIconTint() {
        return this.g;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f;
    }

    public ColorStateList getRippleColor() {
        if (b()) {
            return this.d.e();
        }
        return null;
    }

    public ColorStateList getStrokeColor() {
        if (b()) {
            return this.d.f();
        }
        return null;
    }

    public int getStrokeWidth() {
        if (b()) {
            return this.d.g();
        }
        return 0;
    }

    @Override // android.support.v7.widget.g, defpackage.u4
    public ColorStateList getSupportBackgroundTintList() {
        if (b()) {
            return this.d.h();
        }
        return super.getSupportBackgroundTintList();
    }

    @Override // android.support.v7.widget.g, defpackage.u4
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (b()) {
            return this.d.i();
        }
        return super.getSupportBackgroundTintMode();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (Build.VERSION.SDK_INT >= 21 || !b()) {
            return;
        }
        this.d.c(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.widget.g, android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        g0 g0Var;
        super.onLayout(z, i, i2, i3, i4);
        if (Build.VERSION.SDK_INT != 21 || (g0Var = this.d) == null) {
            return;
        }
        g0Var.v(i4 - i2, i3 - i);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.h == null || this.k != 2) {
            return;
        }
        int measureText = (int) getPaint().measureText(getText().toString());
        int i3 = this.i;
        if (i3 == 0) {
            i3 = this.h.getIntrinsicWidth();
        }
        int measuredWidth = (((((getMeasuredWidth() - measureText) - v4.q(this)) - i3) - this.e) - v4.r(this)) / 2;
        if (a()) {
            measuredWidth = -measuredWidth;
        }
        if (this.j != measuredWidth) {
            this.j = measuredWidth;
            c();
        }
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (b()) {
            this.d.l(i);
        } else {
            super.setBackgroundColor(i);
        }
    }

    @Override // android.support.v7.widget.g, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (b()) {
            if (drawable != getBackground()) {
                Log.i("MaterialButton", "Setting a custom background is not supported.");
                this.d.m();
                super.setBackgroundDrawable(drawable);
                return;
            }
            getBackground().setState(drawable.getState());
            return;
        }
        super.setBackgroundDrawable(drawable);
    }

    @Override // android.support.v7.widget.g, android.view.View
    public void setBackgroundResource(int i) {
        setBackgroundDrawable(i != 0 ? u5.d(getContext(), i) : null);
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCornerRadius(int i) {
        if (b()) {
            this.d.n(i);
        }
    }

    public void setCornerRadiusResource(int i) {
        if (b()) {
            setCornerRadius(getResources().getDimensionPixelSize(i));
        }
    }

    public void setIcon(Drawable drawable) {
        if (this.h != drawable) {
            this.h = drawable;
            c();
        }
    }

    public void setIconGravity(int i) {
        this.k = i;
    }

    public void setIconPadding(int i) {
        if (this.e != i) {
            this.e = i;
            setCompoundDrawablePadding(i);
        }
    }

    public void setIconResource(int i) {
        setIcon(i != 0 ? u5.d(getContext(), i) : null);
    }

    public void setIconSize(int i) {
        if (i >= 0) {
            if (this.i != i) {
                this.i = i;
                c();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("iconSize cannot be less than 0");
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.g != colorStateList) {
            this.g = colorStateList;
            c();
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.f != mode) {
            this.f = mode;
            c();
        }
    }

    public void setIconTintResource(int i) {
        setIconTint(u5.c(getContext(), i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (b()) {
            this.d.o(colorStateList);
        }
    }

    public void setRippleColorResource(int i) {
        if (b()) {
            setRippleColor(u5.c(getContext(), i));
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (b()) {
            this.d.p(colorStateList);
        }
    }

    public void setStrokeColorResource(int i) {
        if (b()) {
            setStrokeColor(u5.c(getContext(), i));
        }
    }

    public void setStrokeWidth(int i) {
        if (b()) {
            this.d.q(i);
        }
    }

    public void setStrokeWidthResource(int i) {
        if (b()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i));
        }
    }

    @Override // android.support.v7.widget.g, defpackage.u4
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (b()) {
            this.d.r(colorStateList);
        } else if (this.d != null) {
            super.setSupportBackgroundTintList(colorStateList);
        }
    }

    @Override // android.support.v7.widget.g, defpackage.u4
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (b()) {
            this.d.s(mode);
        } else if (this.d != null) {
            super.setSupportBackgroundTintMode(mode);
        }
    }

    public e0(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray h = b.h(context, attributeSet, t.W, i, s.Widget_MaterialComponents_Button, new int[0]);
        this.e = h.getDimensionPixelSize(t.g0, 0);
        this.f = c.a(h.getInt(t.j0, -1), PorterDuff.Mode.SRC_IN);
        this.g = n0.a(getContext(), h, t.i0);
        this.h = n0.b(getContext(), h, t.e0);
        this.k = h.getInteger(t.f0, 1);
        this.i = h.getDimensionPixelSize(t.h0, 0);
        g0 g0Var = new g0(this);
        this.d = g0Var;
        g0Var.k(h);
        h.recycle();
        setCompoundDrawablePadding(this.e);
        c();
    }
}
