package defpackage;

import android.view.View;
import android.view.ViewParent;
/* compiled from: NestedScrollingChildHelper.java */
/* renamed from: p4  reason: default package */
/* loaded from: classes.dex */
public class p4 {
    private ViewParent a;
    private ViewParent b;
    private final View c;
    private boolean d;
    private int[] e;

    public p4(View view) {
        this.c = view;
    }

    private ViewParent g(int i) {
        if (i != 0) {
            if (i != 1) {
                return null;
            }
            return this.b;
        }
        return this.a;
    }

    private void l(int i, ViewParent viewParent) {
        if (i == 0) {
            this.a = viewParent;
        } else if (i != 1) {
        } else {
            this.b = viewParent;
        }
    }

    public boolean a(float f, float f2, boolean z) {
        ViewParent g;
        if (!j() || (g = g(0)) == null) {
            return false;
        }
        return y4.a(g, this.c, f, f2, z);
    }

    public boolean b(float f, float f2) {
        ViewParent g;
        if (!j() || (g = g(0)) == null) {
            return false;
        }
        return y4.b(g, this.c, f, f2);
    }

    public boolean c(int i, int i2, int[] iArr, int[] iArr2) {
        return d(i, i2, iArr, iArr2, 0);
    }

    public boolean d(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        ViewParent g;
        int i4;
        int i5;
        if (!j() || (g = g(i3)) == null) {
            return false;
        }
        if (i == 0 && i2 == 0) {
            if (iArr2 != null) {
                iArr2[0] = 0;
                iArr2[1] = 0;
                return false;
            }
            return false;
        }
        if (iArr2 != null) {
            this.c.getLocationInWindow(iArr2);
            i4 = iArr2[0];
            i5 = iArr2[1];
        } else {
            i4 = 0;
            i5 = 0;
        }
        if (iArr == null) {
            if (this.e == null) {
                this.e = new int[2];
            }
            iArr = this.e;
        }
        iArr[0] = 0;
        iArr[1] = 0;
        y4.c(g, this.c, i, i2, iArr, i3);
        if (iArr2 != null) {
            this.c.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i4;
            iArr2[1] = iArr2[1] - i5;
        }
        return (iArr[0] == 0 && iArr[1] == 0) ? false : true;
    }

    public boolean e(int i, int i2, int i3, int i4, int[] iArr) {
        return f(i, i2, i3, i4, iArr, 0);
    }

    public boolean f(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        ViewParent g;
        int i6;
        int i7;
        if (!j() || (g = g(i5)) == null) {
            return false;
        }
        if (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            return false;
        }
        if (iArr != null) {
            this.c.getLocationInWindow(iArr);
            i6 = iArr[0];
            i7 = iArr[1];
        } else {
            i6 = 0;
            i7 = 0;
        }
        y4.d(g, this.c, i, i2, i3, i4, i5);
        if (iArr != null) {
            this.c.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i6;
            iArr[1] = iArr[1] - i7;
        }
        return true;
    }

    public boolean h() {
        return i(0);
    }

    public boolean i(int i) {
        return g(i) != null;
    }

    public boolean j() {
        return this.d;
    }

    public void k(boolean z) {
        if (this.d) {
            v4.V(this.c);
        }
        this.d = z;
    }

    public boolean m(int i) {
        return n(i, 0);
    }

    public boolean n(int i, int i2) {
        if (i(i2)) {
            return true;
        }
        if (j()) {
            View view = this.c;
            for (ViewParent parent = this.c.getParent(); parent != null; parent = parent.getParent()) {
                if (y4.f(parent, view, this.c, i, i2)) {
                    l(i2, parent);
                    y4.e(parent, view, this.c, i, i2);
                    return true;
                }
                if (parent instanceof View) {
                    view = (View) parent;
                }
            }
            return false;
        }
        return false;
    }

    public void o() {
        p(0);
    }

    public void p(int i) {
        ViewParent g = g(i);
        if (g != null) {
            y4.g(g, this.c, i);
            l(i, null);
        }
    }
}
