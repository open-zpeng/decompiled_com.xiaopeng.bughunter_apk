package defpackage;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* compiled from: ViewUtilsApi22.java */
/* renamed from: f2  reason: default package */
/* loaded from: classes.dex */
class f2 extends e2 {
    private static Method i;
    private static boolean j;

    @SuppressLint({"PrivateApi"})
    private void l() {
        if (j) {
            return;
        }
        try {
            Class cls = Integer.TYPE;
            Method declaredMethod = View.class.getDeclaredMethod("setLeftTopRightBottom", cls, cls, cls, cls);
            i = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException e) {
            Log.i("ViewUtilsApi22", "Failed to retrieve setLeftTopRightBottom method", e);
        }
        j = true;
    }

    @Override // defpackage.g2
    public void d(View view, int i2, int i3, int i4, int i5) {
        l();
        Method method = i;
        if (method != null) {
            try {
                method.invoke(view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }
}
