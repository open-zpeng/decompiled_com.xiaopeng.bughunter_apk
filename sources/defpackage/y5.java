package defpackage;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import defpackage.w5;
/* compiled from: StateListDrawable.java */
/* renamed from: y5  reason: default package */
/* loaded from: classes.dex */
class y5 extends w5 {
    private a o;
    private boolean p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StateListDrawable.java */
    /* renamed from: y5$a */
    /* loaded from: classes.dex */
    public static class a extends w5.c {
        int[][] J;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(a aVar, y5 y5Var, Resources resources) {
            super(aVar, y5Var, resources);
            if (aVar != null) {
                this.J = aVar.J;
            } else {
                this.J = new int[g()];
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int A(int[] iArr, Drawable drawable) {
            int a = a(drawable);
            this.J[a] = iArr;
            return a;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int B(int[] iArr) {
            int[][] iArr2 = this.J;
            int i = i();
            for (int i2 = 0; i2 < i; i2++) {
                if (StateSet.stateSetMatches(iArr2[i2], iArr)) {
                    return i2;
                }
            }
            return -1;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new y5(this, null);
        }

        @Override // defpackage.w5.c
        public void p(int i, int i2) {
            super.p(i, i2);
            int[][] iArr = new int[i2];
            System.arraycopy(this.J, 0, iArr, 0, i);
            this.J = iArr;
        }

        @Override // defpackage.w5.c
        void s() {
            int[][] iArr = this.J;
            int[][] iArr2 = new int[iArr.length];
            for (int length = iArr.length - 1; length >= 0; length--) {
                int[][] iArr3 = this.J;
                iArr2[length] = iArr3[length] != null ? (int[]) iArr3[length].clone() : null;
            }
            this.J = iArr2;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new y5(this, resources);
        }
    }

    y5(a aVar, Resources resources) {
        g(new a(aVar, this, resources));
        onStateChange(getState());
    }

    @Override // defpackage.w5, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // defpackage.w5
    public void clearMutated() {
        super.clearMutated();
        this.p = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.w5
    public void g(w5.c cVar) {
        super.g(cVar);
        if (cVar instanceof a) {
            this.o = (a) cVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // defpackage.w5
    /* renamed from: i */
    public a b() {
        return new a(this.o, this, null);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] j(AttributeSet attributeSet) {
        int attributeCount = attributeSet.getAttributeCount();
        int[] iArr = new int[attributeCount];
        int i = 0;
        for (int i2 = 0; i2 < attributeCount; i2++) {
            int attributeNameResource = attributeSet.getAttributeNameResource(i2);
            if (attributeNameResource != 0 && attributeNameResource != 16842960 && attributeNameResource != 16843161) {
                int i3 = i + 1;
                if (!attributeSet.getAttributeBooleanValue(i2, false)) {
                    attributeNameResource = -attributeNameResource;
                }
                iArr[i] = attributeNameResource;
                i = i3;
            }
        }
        return StateSet.trimStateSet(iArr, i);
    }

    @Override // defpackage.w5, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.p && super.mutate() == this) {
            this.o.s();
            this.p = true;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.w5, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        int B = this.o.B(iArr);
        if (B < 0) {
            B = this.o.B(StateSet.WILD_CARD);
        }
        return f(B) || onStateChange;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public y5(a aVar) {
        if (aVar != null) {
            g(aVar);
        }
    }
}
