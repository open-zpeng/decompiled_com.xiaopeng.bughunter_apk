package defpackage;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* compiled from: UnsafeAllocator.java */
/* renamed from: d7  reason: default package */
/* loaded from: classes.dex */
public abstract class d7 {

    /* compiled from: UnsafeAllocator.java */
    /* renamed from: d7$a */
    /* loaded from: classes.dex */
    static class a extends d7 {
        final /* synthetic */ Method a;
        final /* synthetic */ Object b;

        a(Method method, Object obj) {
            this.a = method;
            this.b = obj;
        }

        @Override // defpackage.d7
        public <T> T b(Class<T> cls) throws Exception {
            return (T) this.a.invoke(this.b, cls);
        }
    }

    /* compiled from: UnsafeAllocator.java */
    /* renamed from: d7$b */
    /* loaded from: classes.dex */
    static class b extends d7 {
        final /* synthetic */ Method a;

        b(Method method) {
            this.a = method;
        }

        @Override // defpackage.d7
        public <T> T b(Class<T> cls) throws Exception {
            return (T) this.a.invoke(null, cls, Object.class);
        }
    }

    /* compiled from: UnsafeAllocator.java */
    /* renamed from: d7$c */
    /* loaded from: classes.dex */
    static class c extends d7 {
        final /* synthetic */ Method a;
        final /* synthetic */ int b;

        c(Method method, int i) {
            this.a = method;
            this.b = i;
        }

        @Override // defpackage.d7
        public <T> T b(Class<T> cls) throws Exception {
            return (T) this.a.invoke(null, cls, Integer.valueOf(this.b));
        }
    }

    /* compiled from: UnsafeAllocator.java */
    /* renamed from: d7$d */
    /* loaded from: classes.dex */
    static class d extends d7 {
        d() {
        }

        @Override // defpackage.d7
        public <T> T b(Class<T> cls) {
            throw new UnsupportedOperationException("Cannot allocate " + cls);
        }
    }

    public static d7 a() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return new a(cls.getMethod("allocateInstance", Class.class), declaredField.get(null));
        } catch (Exception unused) {
            try {
                try {
                    Method declaredMethod = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                    declaredMethod.setAccessible(true);
                    return new b(declaredMethod);
                } catch (Exception unused2) {
                    return new d();
                }
            } catch (Exception unused3) {
                Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                declaredMethod2.setAccessible(true);
                int intValue = ((Integer) declaredMethod2.invoke(null, Object.class)).intValue();
                Method declaredMethod3 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
                declaredMethod3.setAccessible(true);
                return new c(declaredMethod3, intValue);
            }
        }
    }

    public abstract <T> T b(Class<T> cls) throws Exception;
}
