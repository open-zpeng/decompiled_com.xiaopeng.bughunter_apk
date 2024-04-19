package defpackage;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* compiled from: TypeToken.java */
/* renamed from: m7  reason: default package */
/* loaded from: classes.dex */
public class m7<T> {
    final Class<? super T> a;
    final Type b;
    final int c;

    protected m7() {
        Type b = b(m7.class);
        this.b = b;
        this.a = (Class<? super T>) w6.r(b);
        this.c = b.hashCode();
    }

    m7(Type type) {
        Type p = w6.p((Type) v6.a(type));
        this.b = p;
        this.a = (Class<? super T>) w6.r(p);
        this.c = p.hashCode();
    }

    static Type b(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (genericSuperclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        return w6.p(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
    }

    public static m7<?> c(Type type) {
        return new m7<>(type);
    }

    public static <T> m7<T> e(Class<T> cls) {
        return new m7<>(cls);
    }

    public final Class<? super T> a() {
        return this.a;
    }

    public final Type d() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof m7) && w6.k(this.b, ((m7) obj).b);
    }

    public final int hashCode() {
        return this.c;
    }

    public final String toString() {
        return w6.s(this.b);
    }
}
