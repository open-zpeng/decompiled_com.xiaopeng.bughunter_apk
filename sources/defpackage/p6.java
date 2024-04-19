package defpackage;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;
/* compiled from: ReflectiveTypeAdapterFactory.java */
/* renamed from: p6  reason: default package */
/* loaded from: classes.dex */
public final class p6 implements c8 {
    private final y6 b;
    private final o7 c;
    private final x6 d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReflectiveTypeAdapterFactory.java */
    /* renamed from: p6$a */
    /* loaded from: classes.dex */
    public class a extends c {
        final b8<?> d;
        final /* synthetic */ p7 e;
        final /* synthetic */ m7 f;
        final /* synthetic */ Field g;
        final /* synthetic */ boolean h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, boolean z, boolean z2, p7 p7Var, m7 m7Var, Field field, boolean z3) {
            super(str, z, z2);
            this.e = p7Var;
            this.f = m7Var;
            this.g = field;
            this.h = z3;
            this.d = p7Var.b(m7Var);
        }

        @Override // defpackage.p6.c
        void a(i7 i7Var, Object obj) throws IOException, IllegalAccessException {
            Object c = this.d.c(i7Var);
            if (c == null && this.h) {
                return;
            }
            this.g.set(obj, c);
        }

        @Override // defpackage.p6.c
        void b(k7 k7Var, Object obj) throws IOException, IllegalAccessException {
            new t6(this.e, this.d, this.f.d()).a(k7Var, this.g.get(obj));
        }
    }

    /* compiled from: ReflectiveTypeAdapterFactory.java */
    /* renamed from: p6$b */
    /* loaded from: classes.dex */
    public static final class b<T> extends b8<T> {
        private final c7<T> a;
        private final Map<String, c> b;

        private b(c7<T> c7Var, Map<String, c> map) {
            this.a = c7Var;
            this.b = map;
        }

        /* synthetic */ b(c7 c7Var, Map map, a aVar) {
            this(c7Var, map);
        }

        @Override // defpackage.b8
        public void a(k7 k7Var, T t) throws IOException {
            if (t == null) {
                k7Var.u();
                return;
            }
            k7Var.m();
            try {
                for (c cVar : this.b.values()) {
                    if (cVar.b) {
                        k7Var.f(cVar.a);
                        cVar.b(k7Var, t);
                    }
                }
                k7Var.s();
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            }
        }

        @Override // defpackage.b8
        public T c(i7 i7Var) throws IOException {
            if (i7Var.t() == j7.NULL) {
                i7Var.w();
                return null;
            }
            T O000000o = this.a.O000000o();
            try {
                i7Var.q();
                while (i7Var.s()) {
                    c cVar = this.b.get(i7Var.u());
                    if (cVar != null && cVar.c) {
                        cVar.a(i7Var, O000000o);
                    }
                    i7Var.B();
                }
                i7Var.o();
                return O000000o;
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (IllegalStateException e2) {
                throw new z7(e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReflectiveTypeAdapterFactory.java */
    /* renamed from: p6$c */
    /* loaded from: classes.dex */
    public static abstract class c {
        final String a;
        final boolean b;
        final boolean c;

        protected c(String str, boolean z, boolean z2) {
            this.a = str;
            this.b = z;
            this.c = z2;
        }

        abstract void a(i7 i7Var, Object obj) throws IOException, IllegalAccessException;

        abstract void b(k7 k7Var, Object obj) throws IOException, IllegalAccessException;
    }

    public p6(y6 y6Var, o7 o7Var, x6 x6Var) {
        this.b = y6Var;
        this.c = o7Var;
        this.d = x6Var;
    }

    private c b(p7 p7Var, Field field, String str, m7<?> m7Var, boolean z, boolean z2) {
        return new a(str, z, z2, p7Var, m7Var, field, f7.c(m7Var.a()));
    }

    private String c(Field field) {
        g6 g6Var = (g6) field.getAnnotation(g6.class);
        return g6Var == null ? this.c.O000000o(field) : g6Var.O000000o();
    }

    private Map<String, c> d(p7 p7Var, m7<?> m7Var, Class<?> cls) {
        Field[] declaredFields;
        c cVar;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type d = m7Var.d();
        m7<?> m7Var2 = m7Var;
        Class<?> cls2 = cls;
        while (cls2 != Object.class) {
            for (Field field : cls2.getDeclaredFields()) {
                boolean e = e(field, true);
                boolean e2 = e(field, false);
                if (e || e2) {
                    field.setAccessible(true);
                    c b2 = b(p7Var, field, c(field), m7.c(w6.h(m7Var2.d(), cls2, field.getGenericType())), e, e2);
                    if (((c) linkedHashMap.put(b2.a, b2)) != null) {
                        throw new IllegalArgumentException(d + " declares multiple JSON fields named " + cVar.a);
                    }
                }
            }
            m7Var2 = m7.c(w6.h(m7Var2.d(), cls2, cls2.getGenericSuperclass()));
            cls2 = m7Var2.a();
        }
        return linkedHashMap;
    }

    @Override // defpackage.c8
    public <T> b8<T> a(p7 p7Var, m7<T> m7Var) {
        Class<? super T> a2 = m7Var.a();
        if (Object.class.isAssignableFrom(a2)) {
            return new b(this.b.a(m7Var), d(p7Var, m7Var, a2), null);
        }
        return null;
    }

    public boolean e(Field field, boolean z) {
        return (this.d.g(field.getType(), z) || this.d.h(field, z)) ? false : true;
    }
}
