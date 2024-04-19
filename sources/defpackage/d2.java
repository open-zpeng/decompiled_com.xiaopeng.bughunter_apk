package defpackage;

import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* compiled from: ViewUtilsApi19.java */
/* renamed from: d2  reason: default package */
/* loaded from: classes.dex */
class d2 extends g2 {
    private static Method a;
    private static boolean b;
    private static Method c;
    private static boolean d;

    private void h() {
        if (d) {
            return;
        }
        try {
            Method declaredMethod = View.class.getDeclaredMethod("getTransitionAlpha", new Class[0]);
            c = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException e) {
            Log.i("ViewUtilsApi19", "Failed to retrieve getTransitionAlpha method", e);
        }
        d = true;
    }

    private void i() {
        if (b) {
            return;
        }
        try {
            Method declaredMethod = View.class.getDeclaredMethod("setTransitionAlpha", Float.TYPE);
            a = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException e) {
            Log.i("ViewUtilsApi19", "Failed to retrieve setTransitionAlpha method", e);
        }
        b = true;
    }

    @Override // defpackage.g2
    public void a(View view) {
    }

    @Override // defpackage.g2
    public float b(View view) {
        h();
        Method method = c;
        if (method != null) {
            try {
                return ((Float) method.invoke(view, new Object[0])).floatValue();
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        }
        return super.b(view);
    }

    @Override // defpackage.g2
    public void c(View view) {
    }

    @Override // defpackage.g2
    public void e(View view, float f) {
        i();
        Method method = a;
        if (method != null) {
            try {
                method.invoke(view, Float.valueOf(f));
                return;
            } catch (IllegalAccessException unused) {
                return;
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        }
        view.setAlpha(f);
    }
}
