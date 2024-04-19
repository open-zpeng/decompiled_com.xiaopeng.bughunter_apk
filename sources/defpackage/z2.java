package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import defpackage.m3;
import defpackage.q2;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;
/* compiled from: TypefaceCompatApi24Impl.java */
/* renamed from: z2  reason: default package */
/* loaded from: classes.dex */
class z2 extends c3 {
    private static final Class a;
    private static final Constructor b;
    private static final Method c;
    private static final Method d;

    static {
        Class<?> cls;
        Method method;
        Method method2;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            Class<?> cls2 = Integer.TYPE;
            method2 = cls.getMethod("addFontWeightStyle", ByteBuffer.class, cls2, List.class, cls2, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi24Impl", e.getClass().getName(), e);
            cls = null;
            method = null;
            method2 = null;
        }
        b = constructor;
        a = cls;
        c = method2;
        d = method;
    }

    private static boolean h(Object obj, ByteBuffer byteBuffer, int i, int i2, boolean z) {
        try {
            return ((Boolean) c.invoke(obj, byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private static Typeface i(Object obj) {
        try {
            Object newInstance = Array.newInstance(a, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) d.invoke(null, newInstance);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean j() {
        Method method = c;
        if (method == null) {
            Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return method != null;
    }

    private static Object k() {
        try {
            return b.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // defpackage.c3
    public Typeface a(Context context, q2.b bVar, Resources resources, int i) {
        q2.c[] a2;
        Object k = k();
        for (q2.c cVar : bVar.a()) {
            ByteBuffer b2 = d3.b(context, resources, cVar.b());
            if (b2 == null || !h(k, b2, cVar.c(), cVar.e(), cVar.f())) {
                return null;
            }
        }
        return i(k);
    }

    @Override // defpackage.c3
    public Typeface b(Context context, CancellationSignal cancellationSignal, m3.f[] fVarArr, int i) {
        Object k = k();
        c4 c4Var = new c4();
        for (m3.f fVar : fVarArr) {
            Uri c2 = fVar.c();
            ByteBuffer byteBuffer = (ByteBuffer) c4Var.get(c2);
            if (byteBuffer == null) {
                byteBuffer = d3.f(context, cancellationSignal, c2);
                c4Var.put(c2, byteBuffer);
            }
            if (!h(k, byteBuffer, fVar.b(), fVar.d(), fVar.e())) {
                return null;
            }
        }
        return Typeface.create(i(k), i);
    }
}
