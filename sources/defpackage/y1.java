package defpackage;

import android.util.Log;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* compiled from: ViewGroupUtilsApi18.java */
/* renamed from: y1  reason: default package */
/* loaded from: classes.dex */
class y1 {
    private static Method a;
    private static boolean b;

    private static void a() {
        if (b) {
            return;
        }
        try {
            Method declaredMethod = ViewGroup.class.getDeclaredMethod("suppressLayout", Boolean.TYPE);
            a = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException e) {
            Log.i("ViewUtilsApi18", "Failed to retrieve suppressLayout method", e);
        }
        b = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(ViewGroup viewGroup, boolean z) {
        a();
        Method method = a;
        if (method != null) {
            try {
                method.invoke(viewGroup, Boolean.valueOf(z));
            } catch (IllegalAccessException e) {
                Log.i("ViewUtilsApi18", "Failed to invoke suppressLayout method", e);
            } catch (InvocationTargetException e2) {
                Log.i("ViewUtilsApi18", "Error invoking suppressLayout method", e2);
            }
        }
    }
}
