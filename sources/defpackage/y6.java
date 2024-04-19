package defpackage;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
/* compiled from: ConstructorConstructor.java */
/* renamed from: y6  reason: default package */
/* loaded from: classes.dex */
public final class y6 {
    private final Map<Type, q7<?>> a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* renamed from: y6$a */
    /* loaded from: classes.dex */
    public class a<T> implements c7<T> {
        a() {
        }

        @Override // defpackage.c7
        public T O000000o() {
            return (T) new LinkedList();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* renamed from: y6$b */
    /* loaded from: classes.dex */
    public class b<T> implements c7<T> {
        b() {
        }

        @Override // defpackage.c7
        public T O000000o() {
            return (T) new ArrayList();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* renamed from: y6$c */
    /* loaded from: classes.dex */
    public class c<T> implements c7<T> {
        c() {
        }

        @Override // defpackage.c7
        public T O000000o() {
            return (T) new TreeMap();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* renamed from: y6$d */
    /* loaded from: classes.dex */
    class d<T> implements c7<T> {
        final /* synthetic */ q7 a;
        final /* synthetic */ Type b;

        d(q7 q7Var, Type type) {
            this.a = q7Var;
            this.b = type;
        }

        @Override // defpackage.c7
        public T O000000o() {
            return (T) this.a.a(this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* renamed from: y6$e */
    /* loaded from: classes.dex */
    public class e<T> implements c7<T> {
        e() {
        }

        @Override // defpackage.c7
        public T O000000o() {
            return (T) new LinkedHashMap();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* renamed from: y6$f */
    /* loaded from: classes.dex */
    public class f<T> implements c7<T> {
        f() {
        }

        @Override // defpackage.c7
        public T O000000o() {
            return (T) new b7();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* renamed from: y6$g */
    /* loaded from: classes.dex */
    public class g<T> implements c7<T> {
        private final d7 a = d7.a();
        final /* synthetic */ Class b;
        final /* synthetic */ Type c;

        g(Class cls, Type type) {
            this.b = cls;
            this.c = type;
        }

        @Override // defpackage.c7
        public T O000000o() {
            try {
                return (T) this.a.b(this.b);
            } catch (Exception e) {
                throw new RuntimeException("Unable to invoke no-args constructor for " + this.c + ". Register an InstanceCreator with Gson for this type may fix this problem.", e);
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* renamed from: y6$h */
    /* loaded from: classes.dex */
    class h<T> implements c7<T> {
        final /* synthetic */ q7 a;
        final /* synthetic */ Type b;

        h(q7 q7Var, Type type) {
            this.a = q7Var;
            this.b = type;
        }

        @Override // defpackage.c7
        public T O000000o() {
            return (T) this.a.a(this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* renamed from: y6$i */
    /* loaded from: classes.dex */
    public class i<T> implements c7<T> {
        final /* synthetic */ Constructor a;

        i(Constructor constructor) {
            this.a = constructor;
        }

        @Override // defpackage.c7
        public T O000000o() {
            try {
                return (T) this.a.newInstance(null);
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (InstantiationException e2) {
                throw new RuntimeException("Failed to invoke " + this.a + " with no args", e2);
            } catch (InvocationTargetException e3) {
                throw new RuntimeException("Failed to invoke " + this.a + " with no args", e3.getTargetException());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* renamed from: y6$j */
    /* loaded from: classes.dex */
    public class j<T> implements c7<T> {
        j() {
        }

        @Override // defpackage.c7
        public T O000000o() {
            return (T) new TreeSet();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* renamed from: y6$k */
    /* loaded from: classes.dex */
    public class k<T> implements c7<T> {
        final /* synthetic */ Type a;

        k(Type type) {
            this.a = type;
        }

        @Override // defpackage.c7
        public T O000000o() {
            Type type = this.a;
            if (!(type instanceof ParameterizedType)) {
                throw new t7("Invalid EnumSet type: " + this.a.toString());
            }
            Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (type2 instanceof Class) {
                return (T) EnumSet.noneOf((Class) type2);
            }
            throw new t7("Invalid EnumSet type: " + this.a.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* renamed from: y6$l */
    /* loaded from: classes.dex */
    public class l<T> implements c7<T> {
        l() {
        }

        @Override // defpackage.c7
        public T O000000o() {
            return (T) new LinkedHashSet();
        }
    }

    public y6(Map<Type, q7<?>> map) {
        this.a = map;
    }

    private <T> c7<T> b(Class<? super T> cls) {
        try {
            Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return new i(declaredConstructor);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private <T> c7<T> c(Type type, Class<? super T> cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            return SortedSet.class.isAssignableFrom(cls) ? new j() : EnumSet.class.isAssignableFrom(cls) ? new k(type) : Set.class.isAssignableFrom(cls) ? new l() : Queue.class.isAssignableFrom(cls) ? new a() : new b();
        } else if (Map.class.isAssignableFrom(cls)) {
            return SortedMap.class.isAssignableFrom(cls) ? new c() : (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(m7.c(((ParameterizedType) type).getActualTypeArguments()[0]).a())) ? new f() : new e();
        } else {
            return null;
        }
    }

    private <T> c7<T> d(Type type, Class<? super T> cls) {
        return new g(cls, type);
    }

    public <T> c7<T> a(m7<T> m7Var) {
        Type d2 = m7Var.d();
        Class<? super T> a2 = m7Var.a();
        q7<?> q7Var = this.a.get(d2);
        if (q7Var != null) {
            return new d(q7Var, d2);
        }
        q7<?> q7Var2 = this.a.get(a2);
        if (q7Var2 != null) {
            return new h(q7Var2, d2);
        }
        c7<T> b2 = b(a2);
        if (b2 != null) {
            return b2;
        }
        c7<T> c2 = c(d2, a2);
        return c2 != null ? c2 : d(d2, a2);
    }

    public String toString() {
        return this.a.toString();
    }
}
