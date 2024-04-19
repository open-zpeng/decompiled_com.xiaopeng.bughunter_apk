package defpackage;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* compiled from: Primitives.java */
/* renamed from: f7  reason: default package */
/* loaded from: classes.dex */
public final class f7 {
    private static final Map<Class<?>, Class<?>> a;
    private static final Map<Class<?>, Class<?>> b;

    static {
        HashMap hashMap = new HashMap(16);
        HashMap hashMap2 = new HashMap(16);
        b(hashMap, hashMap2, Boolean.TYPE, Boolean.class);
        b(hashMap, hashMap2, Byte.TYPE, Byte.class);
        b(hashMap, hashMap2, Character.TYPE, Character.class);
        b(hashMap, hashMap2, Double.TYPE, Double.class);
        b(hashMap, hashMap2, Float.TYPE, Float.class);
        b(hashMap, hashMap2, Integer.TYPE, Integer.class);
        b(hashMap, hashMap2, Long.TYPE, Long.class);
        b(hashMap, hashMap2, Short.TYPE, Short.class);
        b(hashMap, hashMap2, Void.TYPE, Void.class);
        a = Collections.unmodifiableMap(hashMap);
        b = Collections.unmodifiableMap(hashMap2);
    }

    public static <T> Class<T> a(Class<T> cls) {
        Class<T> cls2 = (Class<T>) a.get(v6.a(cls));
        return cls2 == null ? cls : cls2;
    }

    private static void b(Map<Class<?>, Class<?>> map, Map<Class<?>, Class<?>> map2, Class<?> cls, Class<?> cls2) {
        map.put(cls, cls2);
        map2.put(cls2, cls);
    }

    public static boolean c(Type type) {
        return a.containsKey(type);
    }
}
