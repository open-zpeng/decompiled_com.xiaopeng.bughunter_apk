package defpackage;

import android.graphics.Matrix;
import android.view.View;
import android.view.ViewParent;
/* compiled from: ViewUtilsBase.java */
/* renamed from: g2  reason: default package */
/* loaded from: classes.dex */
class g2 {
    public void a(View view) {
        if (view.getVisibility() == 0) {
            view.setTag(i1.save_non_transition_alpha, null);
        }
    }

    public float b(View view) {
        Float f = (Float) view.getTag(i1.save_non_transition_alpha);
        if (f != null) {
            return view.getAlpha() / f.floatValue();
        }
        return view.getAlpha();
    }

    public void c(View view) {
        int i = i1.save_non_transition_alpha;
        if (view.getTag(i) == null) {
            view.setTag(i, Float.valueOf(view.getAlpha()));
        }
    }

    public void d(View view, int i, int i2, int i3, int i4) {
        view.setLeft(i);
        view.setTop(i2);
        view.setRight(i3);
        view.setBottom(i4);
    }

    public void e(View view, float f) {
        Float f2 = (Float) view.getTag(i1.save_non_transition_alpha);
        if (f2 != null) {
            view.setAlpha(f2.floatValue() * f);
        } else {
            view.setAlpha(f);
        }
    }

    public void f(View view, Matrix matrix) {
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            f(view2, matrix);
            matrix.preTranslate(-view2.getScrollX(), -view2.getScrollY());
        }
        matrix.preTranslate(view.getLeft(), view.getTop());
        Matrix matrix2 = view.getMatrix();
        if (matrix2.isIdentity()) {
            return;
        }
        matrix.preConcat(matrix2);
    }

    public void g(View view, Matrix matrix) {
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            g(view2, matrix);
            matrix.postTranslate(view2.getScrollX(), view2.getScrollY());
        }
        matrix.postTranslate(view.getLeft(), view.getTop());
        Matrix matrix2 = view.getMatrix();
        if (matrix2.isIdentity()) {
            return;
        }
        Matrix matrix3 = new Matrix();
        if (matrix2.invert(matrix3)) {
            matrix.postConcat(matrix3);
        }
    }
}
