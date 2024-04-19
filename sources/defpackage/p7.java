package defpackage;

import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* compiled from: Gson.java */
/* renamed from: p7  reason: default package */
/* loaded from: classes.dex */
public final class p7 {
    private final ThreadLocal<Map<m7<?>, f<?>>> a;
    private final Map<m7<?>, b8<?>> b;
    private final List<c8> c;
    private final y6 d;
    private final boolean e;
    private final boolean f;
    private final boolean g;
    private final boolean h;
    final s7 i;
    final y7 j;

    /* compiled from: Gson.java */
    /* renamed from: p7$a */
    /* loaded from: classes.dex */
    class a implements s7 {
        a() {
        }
    }

    /* compiled from: Gson.java */
    /* renamed from: p7$b */
    /* loaded from: classes.dex */
    class b implements y7 {
        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Gson.java */
    /* renamed from: p7$c */
    /* loaded from: classes.dex */
    public class c extends b8<Number> {
        c() {
        }

        @Override // defpackage.b8
        /* renamed from: d */
        public Double c(i7 i7Var) throws IOException {
            if (i7Var.t() == j7.NULL) {
                i7Var.w();
                return null;
            }
            return Double.valueOf(i7Var.y());
        }

        @Override // defpackage.b8
        /* renamed from: e */
        public void a(k7 k7Var, Number number) throws IOException {
            if (number == null) {
                k7Var.u();
                return;
            }
            p7.this.l(number.doubleValue());
            k7Var.e(number);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Gson.java */
    /* renamed from: p7$d */
    /* loaded from: classes.dex */
    public class d extends b8<Number> {
        d() {
        }

        @Override // defpackage.b8
        /* renamed from: d */
        public Float c(i7 i7Var) throws IOException {
            if (i7Var.t() == j7.NULL) {
                i7Var.w();
                return null;
            }
            return Float.valueOf((float) i7Var.y());
        }

        @Override // defpackage.b8
        /* renamed from: e */
        public void a(k7 k7Var, Number number) throws IOException {
            if (number == null) {
                k7Var.u();
                return;
            }
            p7.this.l(number.floatValue());
            k7Var.e(number);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Gson.java */
    /* renamed from: p7$e */
    /* loaded from: classes.dex */
    public class e extends b8<Number> {
        e() {
        }

        @Override // defpackage.b8
        /* renamed from: d */
        public Number c(i7 i7Var) throws IOException {
            if (i7Var.t() == j7.NULL) {
                i7Var.w();
                return null;
            }
            return Long.valueOf(i7Var.z());
        }

        @Override // defpackage.b8
        /* renamed from: e */
        public void a(k7 k7Var, Number number) throws IOException {
            if (number == null) {
                k7Var.u();
            } else {
                k7Var.j(number.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Gson.java */
    /* renamed from: p7$f */
    /* loaded from: classes.dex */
    public static class f<T> extends b8<T> {
        private b8<T> a;

        f() {
        }

        @Override // defpackage.b8
        public void a(k7 k7Var, T t) throws IOException {
            b8<T> b8Var = this.a;
            if (b8Var == null) {
                throw new IllegalStateException();
            }
            b8Var.a(k7Var, t);
        }

        @Override // defpackage.b8
        public T c(i7 i7Var) throws IOException {
            b8<T> b8Var = this.a;
            if (b8Var != null) {
                return b8Var.c(i7Var);
            }
            throw new IllegalStateException();
        }

        public void d(b8<T> b8Var) {
            if (this.a != null) {
                throw new AssertionError();
            }
            this.a = b8Var;
        }
    }

    public p7() {
        this(x6.b, h7.O000000o, Collections.emptyMap(), false, false, false, true, false, false, a8.O000000o, Collections.emptyList());
    }

    p7(x6 x6Var, o7 o7Var, Map<Type, q7<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, a8 a8Var, List<c8> list) {
        this.a = new ThreadLocal<>();
        this.b = Collections.synchronizedMap(new HashMap());
        this.i = new a();
        this.j = new b();
        y6 y6Var = new y6(map);
        this.d = y6Var;
        this.e = z;
        this.g = z3;
        this.f = z4;
        this.h = z5;
        ArrayList arrayList = new ArrayList();
        arrayList.add(u6.Q);
        arrayList.add(q6.a);
        arrayList.add(x6Var);
        arrayList.addAll(list);
        arrayList.add(u6.x);
        arrayList.add(u6.m);
        arrayList.add(u6.g);
        arrayList.add(u6.i);
        arrayList.add(u6.k);
        arrayList.add(u6.c(Long.TYPE, Long.class, c(a8Var)));
        arrayList.add(u6.c(Double.TYPE, Double.class, f(z6)));
        arrayList.add(u6.c(Float.TYPE, Float.class, s(z6)));
        arrayList.add(u6.r);
        arrayList.add(u6.t);
        arrayList.add(u6.z);
        arrayList.add(u6.B);
        arrayList.add(u6.b(BigDecimal.class, u6.v));
        arrayList.add(u6.b(BigInteger.class, u6.w));
        arrayList.add(u6.D);
        arrayList.add(u6.F);
        arrayList.add(u6.J);
        arrayList.add(u6.O);
        arrayList.add(u6.H);
        arrayList.add(u6.d);
        arrayList.add(m6.a);
        arrayList.add(u6.M);
        arrayList.add(r6.a);
        arrayList.add(s6.a);
        arrayList.add(u6.K);
        arrayList.add(j6.a);
        arrayList.add(u6.R);
        arrayList.add(u6.b);
        arrayList.add(new k6(y6Var));
        arrayList.add(new o6(y6Var, z2));
        arrayList.add(new p6(y6Var, o7Var, x6Var));
        this.c = Collections.unmodifiableList(arrayList);
    }

    private k7 a(Writer writer) throws IOException {
        if (this.g) {
            writer.write(")]}'\n");
        }
        k7 k7Var = new k7(writer);
        if (this.h) {
            k7Var.q("  ");
        }
        k7Var.o(this.e);
        return k7Var;
    }

    private b8<Number> c(a8 a8Var) {
        return a8Var == a8.O000000o ? u6.n : new e();
    }

    private b8<Number> f(boolean z) {
        return z ? u6.p : new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(double d2) {
        if (Double.isNaN(d2) || Double.isInfinite(d2)) {
            throw new IllegalArgumentException(d2 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private static void p(Object obj, i7 i7Var) {
        if (obj != null) {
            try {
                if (i7Var.t() == j7.END_DOCUMENT) {
                    return;
                }
                throw new t7("JSON document was not fully consumed.");
            } catch (l7 e2) {
                throw new z7(e2);
            } catch (IOException e3) {
                throw new t7(e3);
            }
        }
    }

    private b8<Number> s(boolean z) {
        return z ? u6.o : new d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> b8<T> b(m7<T> m7Var) {
        b8<T> b8Var = (b8<T>) this.b.get(m7Var);
        if (b8Var != null) {
            return b8Var;
        }
        Map<m7<?>, f<?>> map = this.a.get();
        boolean z = false;
        if (map == null) {
            map = new HashMap<>();
            this.a.set(map);
            z = true;
        }
        f<?> fVar = map.get(m7Var);
        if (fVar != null) {
            return fVar;
        }
        try {
            f<?> fVar2 = new f<>();
            map.put(m7Var, fVar2);
            for (c8 c8Var : this.c) {
                b8 b8Var2 = (b8<T>) c8Var.a(this, m7Var);
                if (b8Var2 != null) {
                    fVar2.d(b8Var2);
                    this.b.put(m7Var, b8Var2);
                    return b8Var2;
                }
            }
            throw new IllegalArgumentException("GSON cannot handle " + m7Var);
        } finally {
            map.remove(m7Var);
            if (z) {
                this.a.remove();
            }
        }
    }

    public <T> b8<T> d(c8 c8Var, m7<T> m7Var) {
        boolean z = false;
        for (c8 c8Var2 : this.c) {
            if (z) {
                b8<T> a2 = c8Var2.a(this, m7Var);
                if (a2 != null) {
                    return a2;
                }
            } else if (c8Var2 == c8Var) {
                z = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + m7Var);
    }

    public <T> b8<T> e(Class<T> cls) {
        return b(m7.e(cls));
    }

    public <T> T g(i7 i7Var, Type type) throws t7, z7 {
        boolean E = i7Var.E();
        boolean z = true;
        i7Var.e(true);
        try {
            try {
                try {
                    i7Var.t();
                    z = false;
                    T c2 = b(m7.c(type)).c(i7Var);
                    i7Var.e(E);
                    return c2;
                } catch (IOException e2) {
                    throw new z7(e2);
                }
            } catch (EOFException e3) {
                if (z) {
                    i7Var.e(E);
                    return null;
                }
                throw new z7(e3);
            } catch (IllegalStateException e4) {
                throw new z7(e4);
            }
        } catch (Throwable th) {
            i7Var.e(E);
            throw th;
        }
    }

    public <T> T h(Reader reader, Type type) throws t7, z7 {
        i7 i7Var = new i7(reader);
        T t = (T) g(i7Var, type);
        p(t, i7Var);
        return t;
    }

    public <T> T i(String str, Class<T> cls) throws z7 {
        return (T) f7.a(cls).cast(j(str, cls));
    }

    public <T> T j(String str, Type type) throws z7 {
        if (str == null) {
            return null;
        }
        return (T) h(new StringReader(str), type);
    }

    public String k(d8 d8Var) {
        StringWriter stringWriter = new StringWriter();
        o(d8Var, stringWriter);
        return stringWriter.toString();
    }

    public void n(d8 d8Var, k7 k7Var) throws t7 {
        boolean v = k7Var.v();
        k7Var.l(true);
        boolean w = k7Var.w();
        k7Var.r(this.f);
        boolean y = k7Var.y();
        k7Var.o(this.e);
        try {
            try {
                e7.b(d8Var, k7Var);
            } catch (IOException e2) {
                throw new t7(e2);
            }
        } finally {
            k7Var.l(v);
            k7Var.r(w);
            k7Var.o(y);
        }
    }

    public void o(d8 d8Var, Appendable appendable) throws t7 {
        try {
            n(d8Var, a(e7.a(appendable)));
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    public void q(Object obj, Type type, k7 k7Var) throws t7 {
        b8 b2 = b(m7.c(type));
        boolean v = k7Var.v();
        k7Var.l(true);
        boolean w = k7Var.w();
        k7Var.r(this.f);
        boolean y = k7Var.y();
        k7Var.o(this.e);
        try {
            try {
                b2.a(k7Var, obj);
            } catch (IOException e2) {
                throw new t7(e2);
            }
        } finally {
            k7Var.l(v);
            k7Var.r(w);
            k7Var.o(y);
        }
    }

    public void r(Object obj, Type type, Appendable appendable) throws t7 {
        try {
            q(obj, type, a(e7.a(appendable)));
        } catch (IOException e2) {
            throw new t7(e2);
        }
    }

    public String t(Object obj) {
        return obj == null ? k(u7.a) : u(obj, obj.getClass());
    }

    public String toString() {
        return "{serializeNulls:" + this.e + "factories:" + this.c + ",instanceCreators:" + this.d + "}";
    }

    public String u(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        r(obj, type, stringWriter);
        return stringWriter.toString();
    }
}
