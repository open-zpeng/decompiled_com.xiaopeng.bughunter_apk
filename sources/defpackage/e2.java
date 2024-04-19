package defpackage;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* compiled from: ViewUtilsApi21.java */
/* renamed from: e2  reason: default package */
/* loaded from: classes.dex */
class e2 extends d2 {
    private static Method e;
    private static boolean f;
    private static Method g;
    private static boolean h;

    private void j() {
        if (f) {
            return;
        }
        try {
            Method declaredMethod = View.class.getDeclaredMethod("transformMatrixToGlobal", Matrix.class);
            e = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException e2) {
            Log.i("ViewUtilsApi21", "Failed to retrieve transformMatrixToGlobal method", e2);
        }
        f = true;
    }

    private void k() {
        if (h) {
            return;
        }
        try {
            Method declaredMethod = View.class.getDeclaredMethod("transformMatrixToLocal", Matrix.class);
            g = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException e2) {
            Log.i("ViewUtilsApi21", "Failed to retrieve transformMatrixToLocal method", e2);
        }
        h = true;
    }

    @Override // defpackage.g2
    public void f(View view, Matrix matrix) {
        j();
        Method method = e;
        if (method != null) {
            try {
                method.invoke(view, matrix);
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
    }

    @Override // defpackage.g2
    public void g(View view, Matrix matrix) {
        k();
        Method method = g;
        if (method != null) {
            try {
                method.invoke(view, matrix);
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
    }
}
