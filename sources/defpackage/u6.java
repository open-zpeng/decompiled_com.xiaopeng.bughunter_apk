package defpackage;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
/* compiled from: TypeAdapters.java */
/* renamed from: u6  reason: default package */
/* loaded from: classes.dex */
public final class u6 {
    public static final b8<StringBuffer> A;
    public static final c8 B;
    public static final b8<URL> C;
    public static final c8 D;
    public static final b8<URI> E;
    public static final c8 F;
    public static final b8<InetAddress> G;
    public static final c8 H;
    public static final b8<UUID> I;
    public static final c8 J;
    public static final c8 K;
    public static final b8<Calendar> L;
    public static final c8 M;
    public static final b8<Locale> N;
    public static final c8 O;
    public static final b8<d8> P;
    public static final c8 Q;
    public static final c8 R;
    public static final b8<Class> a;
    public static final c8 b;
    public static final b8<BitSet> c;
    public static final c8 d;
    public static final b8<Boolean> e;
    public static final b8<Boolean> f;
    public static final c8 g;
    public static final b8<Number> h;
    public static final c8 i;
    public static final b8<Number> j;
    public static final c8 k;
    public static final b8<Number> l;
    public static final c8 m;
    public static final b8<Number> n;
    public static final b8<Number> o;
    public static final b8<Number> p;
    public static final b8<Number> q;
    public static final c8 r;
    public static final b8<Character> s;
    public static final c8 t;
    public static final b8<String> u;
    public static final b8<BigDecimal> v;
    public static final b8<BigInteger> w;
    public static final c8 x;
    public static final b8<StringBuilder> y;
    public static final c8 z;

    /* compiled from: TypeAdapters.java */
    /* renamed from: u6$a */
    /* loaded from: classes.dex */
    static class a extends b8<URL> {
        a() {
        }

        @Override // defpackage.b8
        /* renamed from: d */
        public URL c(i7 i7Var) throws IOException {
            if (i7Var.t() == j7.NULL) {
                i7Var.w();
                return null;
            }
            String v = i7Var.v();
            if ("null".equals(v)) {
                return null;
            }
            return new URL(v);
        }

        @Override // defpackage.b8
        /* renamed from: e */
        public void a(k7 k7Var, URL url) throws IOException {
            k7Var.j(url == null ? null : url.toExternalForm());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: u6$a0 */
    /* loaded from: classes.dex */
    static class a0 extends b8<String> {
        a0() {
        }

        @Override // defpackage.b8
        /* renamed from: d */
        public String c(i7 i7Var) throws IOException {
            j7 t = i7Var.t();
            if (t != j7.NULL) {
                return t == j7.BOOLEAN ? Boolean.toString(i7Var.x()) : i7Var.v();
            }
            i7Var.w();
            return null;
        }

        @Override // defpackage.b8
        /* renamed from: e */
        public void a(k7 k7Var, String str) throws IOException {
            k7Var.j(str);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: u6$b */
    /* loaded from: classes.dex */
    static class b extends b8<URI> {
        b() {
        }

        @Override // defpackage.b8
        /* renamed from: d */
        public URI c(i7 i7Var) throws IOException {
            if (i7Var.t() == j7.NULL) {
                i7Var.w();
                return null;
            }
            try {
                String v = i7Var.v();
                if ("null".equals(v)) {
                    return null;
                }
                return new URI(v);
            } catch (URISyntaxException e) {
                throw new t7(e);
            }
        }

        @Override // defpackage.b8
        /* renamed from: e */
        public void a(k7 k7Var, URI uri) throws IOException {
            k7Var.j(uri == null ? null : uri.toASCIIString());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: u6$b0 */
    /* loaded from: classes.dex */
    static class b0 extends b8<BigDecimal> {
        b0() {
        }

        @Override // defpackage.b8
        /* renamed from: d */
        public BigDecimal c(i7 i7Var) throws IOException {
            if (i7Var.t() == j7.NULL) {
                i7Var.w();
                return null;
            }
            try {
                return new BigDecimal(i7Var.v());
            } catch (NumberFormatException e) {
                throw new z7(e);
            }
        }

        @Override // defpackage.b8
        /* renamed from: e */
        public void a(k7 k7Var, BigDecimal bigDecimal) throws IOException {
            k7Var.e(bigDecimal);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: u6$c */
    /* loaded from: classes.dex */
    static class c extends b8<BitSet> {
        c() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0038, code lost:
            if (java.lang.Integer.parseInt(r1) != 0) goto L20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x003b, code lost:
            r5 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0074, code lost:
            if (r8.C() != 0) goto L20;
         */
        @Override // defpackage.b8
        /* renamed from: d */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.util.BitSet c(defpackage.i7 r8) throws java.io.IOException {
            /*
                r7 = this;
                j7 r0 = r8.t()
                j7 r1 = defpackage.j7.NULL
                if (r0 != r1) goto Ld
                r8.w()
                r8 = 0
                return r8
            Ld:
                java.util.BitSet r0 = new java.util.BitSet
                r0.<init>()
                r8.c()
                j7 r1 = r8.t()
                r2 = 0
                r3 = r2
            L1b:
                j7 r4 = defpackage.j7.END_ARRAY
                if (r1 == r4) goto L82
                int[] r4 = defpackage.u6.q.a
                int r5 = r1.ordinal()
                r4 = r4[r5]
                r5 = 1
                if (r4 == r5) goto L70
                r6 = 2
                if (r4 == r6) goto L6b
                r6 = 3
                if (r4 != r6) goto L54
                java.lang.String r1 = r8.v()
                int r1 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.NumberFormatException -> L3d
                if (r1 == 0) goto L3b
                goto L76
            L3b:
                r5 = r2
                goto L76
            L3d:
                z7 r8 = new z7
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r2 = "Error: Expecting: bitset number value (1, 0), Found: "
                r0.append(r2)
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                r8.<init>(r0)
                throw r8
            L54:
                z7 r8 = new z7
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r2 = "Invalid bitset value type: "
                r0.append(r2)
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                r8.<init>(r0)
                throw r8
            L6b:
                boolean r5 = r8.x()
                goto L76
            L70:
                int r1 = r8.C()
                if (r1 == 0) goto L3b
            L76:
                if (r5 == 0) goto L7b
                r0.set(r3)
            L7b:
                int r3 = r3 + 1
                j7 r1 = r8.t()
                goto L1b
            L82:
                r8.l()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.u6.c.c(i7):java.util.BitSet");
        }

        @Override // defpackage.b8
        /* renamed from: e */
        public void a(k7 k7Var, BitSet bitSet) throws IOException {
            if (bitSet == null) {
                k7Var.u();
                return;
            }
            k7Var.i();
            for (int i = 0; i < bitSet.length(); i++) {
                k7Var.d(bitSet.get(i) ? 1L : 0L);
            }
            k7Var.p();
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: u6$c0 */
    /* loaded from: classes.dex */
    static class c0 extends b8<BigInteger> {
        c0() {
        }

        @Override // defpackage.b8
        /* renamed from: d */
        public BigInteger c(i7 i7Var) throws IOException {
            if (i7Var.t() == j7.NULL) {
                i7Var.w();
                return null;
            }
            try {
                return new BigInteger(i7Var.v());
            } catch (NumberFormatException e) {
                throw new z7(e);
            }
        }

        @Override // defpackage.b8
        /* renamed from: e */
        public void a(k7 k7Var, BigInteger bigInteger) throws IOException {
            k7Var.e(bigInteger);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: u6$d */
    /* loaded from: classes.dex */
    static class d extends b8<InetAddress> {
        d() {
        }

        @Override // defpackage.b8
        /* renamed from: d */
        public InetAddress c(i7 i7Var) throws IOException {
            if (i7Var.t() == j7.NULL) {
                i7Var.w();
                return null;
            }
            return InetAddress.getByName(i7Var.v());
        }

        @Override // defpackage.b8
        /* renamed from: e */
        public void a(k7 k7Var, InetAddress inetAddress) throws IOException {
            k7Var.j(inetAddress == null ? null : inetAddress.getHostAddress());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: u6$d0 */
    /* loaded from: classes.dex */
    static class d0 extends b8<StringBuilder> {
        d0() {
        }

        @Override // defpackage.b8
        /* renamed from: d */
        public StringBuilder c(i7 i7Var) throws IOException {
            if (i7Var.t() == j7.NULL) {
                i7Var.w();
                return null;
            }
            return new StringBuilder(i7Var.v());
        }

        @Override // defpackage.b8
        /* renamed from: e */
        public void a(k7 k7Var, StringBuilder sb) throws IOException {
            k7Var.j(sb == null ? null : sb.toString());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: u6$e */
    /* loaded from: classes.dex */
    static class e extends b8<UUID> {
        e() {
        }

        @Override // defpackage.b8
        /* renamed from: d */
        public UUID c(i7 i7Var) throws IOException {
            if (i7Var.t() == j7.NULL) {
                i7Var.w();
                return null;
            }
            return UUID.fromString(i7Var.v());
        }

        @Override // defpackage.b8
        /* renamed from: e */
        public void a(k7 k7Var, UUID uuid) throws IOException {
            k7Var.j(uuid == null ? null : uuid.toString());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: u6$e0 */
    /* loaded from: classes.dex */
    static class e0 extends b8<StringBuffer> {
        e0() {
        }

        @Override // defpackage.b8
        /* renamed from: d */
        public StringBuffer c(i7 i7Var) throws IOException {
            if (i7Var.t() == j7.NULL) {
                i7Var.w();
                return null;
            }
            return new StringBuffer(i7Var.v());
        }

        @Override // defpackage.b8
        /* renamed from: e */
        public void a(k7 k7Var, StringBuffer stringBuffer) throws IOException {
            k7Var.j(stringBuffer == null ? null : stringBuffer.toString());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: u6$f */
    /* loaded from: classes.dex */
    static class f implements c8 {

        /* compiled from: TypeAdapters.java */
        /* renamed from: u6$f$a */
        /* loaded from: classes.dex */
        class a extends b8<Timestamp> {
            final /* synthetic */ b8 a;

            a(b8 b8Var) {
                this.a = b8Var;
            }

            @Override // defpackage.b8
            /* renamed from: d */
            public Timestamp c(i7 i7Var) throws IOException {
                Date date = (Date) this.a.c(i7Var);
                if (date != null) {
                    return new Timestamp(date.getTime());
                }
                return null;
            }

            @Override // defpackage.b8
            /* renamed from: e */
            public void a(k7 k7Var, Timestamp timestamp) throws IOException {
                this.a.a(k7Var, timestamp);
            }
        }

        f() {
        }

        @Override // defpackage.c8
        public <T> b8<T> a(p7 p7Var, m7<T> m7Var) {
            if (m7Var.a() != Timestamp.class) {
                return null;
            }
            return new a(p7Var.e(Date.class));
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: u6$f0 */
    /* loaded from: classes.dex */
    private static final class f0<T extends Enum<T>> extends b8<T> {
        private final Map<String, T> a = new HashMap();
        private final Map<T, String> b = new HashMap();

        public f0(Class<T> cls) {
            T[] enumConstants;
            try {
                for (T t : cls.getEnumConstants()) {
                    String name = t.name();
                    g6 g6Var = (g6) cls.getField(name).getAnnotation(g6.class);
                    name = g6Var != null ? g6Var.O000000o() : name;
                    this.a.put(name, t);
                    this.b.put(t, name);
                }
            } catch (NoSuchFieldException unused) {
                throw new AssertionError();
            }
        }

        @Override // defpackage.b8
        /* renamed from: d */
        public T c(i7 i7Var) throws IOException {
            if (i7Var.t() == j7.NULL) {
                i7Var.w();
                return null;
            }
            return this.a.get(i7Var.v());
        }

        @Override // defpackage.b8
        /* renamed from: e */
        public void a(k7 k7Var, T t) throws IOException {
            k7Var.j(t == null ? null : this.b.get(t));
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: u6$g */
    /* loaded from: classes.dex */
    static class g extends b8<Calendar> {
        g() {
        }

        @Override // defpackage.b8
        /* renamed from: d */
        public Calendar c(i7 i7Var) throws IOException {
            if (i7Var.t() == j7.NULL) {
                i7Var.w();
                return null;
            }
            i7Var.q();
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (i7Var.t() != j7.END_OBJECT) {
                String u = i7Var.u();
                int C = i7Var.C();
                if ("year".equals(u)) {
                    i = C;
                } else if ("month".equals(u)) {
                    i2 = C;
                } else if ("dayOfMonth".equals(u)) {
                    i3 = C;
                } else if ("hourOfDay".equals(u)) {
                    i4 = C;
                } else if ("minute".equals(u)) {
                    i5 = C;
                } else if ("second".equals(u)) {
                    i6 = C;
                }
            }
            i7Var.o();
            return new GregorianCalendar(i, i2, i3, i4, i5, i6);
        }

        @Override // defpackage.b8
        /* renamed from: e */
        public void a(k7 k7Var, Calendar calendar) throws IOException {
            if (calendar == null) {
                k7Var.u();
                return;
            }
            k7Var.m();
            k7Var.f("year");
            k7Var.d(calendar.get(1));
            k7Var.f("month");
            k7Var.d(calendar.get(2));
            k7Var.f("dayOfMonth");
            k7Var.d(calendar.get(5));
            k7Var.f("hourOfDay");
            k7Var.d(calendar.get(11));
            k7Var.f("minute");
            k7Var.d(calendar.get(12));
            k7Var.f("second");
            k7Var.d(calendar.get(13));
            k7Var.s();
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: u6$h */
    /* loaded from: classes.dex */
    static class h extends b8<Locale> {
        h() {
        }

        @Override // defpackage.b8
        /* renamed from: d */
        public Locale c(i7 i7Var) throws IOException {
            if (i7Var.t() == j7.NULL) {
                i7Var.w();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(i7Var.v(), "_");
            String nextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String nextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String nextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            return (nextToken2 == null && nextToken3 == null) ? new Locale(nextToken) : nextToken3 == null ? new Locale(nextToken, nextToken2) : new Locale(nextToken, nextToken2, nextToken3);
        }

        @Override // defpackage.b8
        /* renamed from: e */
        public void a(k7 k7Var, Locale locale) throws IOException {
            k7Var.j(locale == null ? null : locale.toString());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: u6$i */
    /* loaded from: classes.dex */
    static class i extends b8<d8> {
        i() {
        }

        @Override // defpackage.b8
        /* renamed from: d */
        public d8 c(i7 i7Var) throws IOException {
            switch (q.a[i7Var.t().ordinal()]) {
                case 1:
                    return new x7(new a7(i7Var.v()));
                case 2:
                    return new x7(Boolean.valueOf(i7Var.x()));
                case 3:
                    return new x7(i7Var.v());
                case 4:
                    i7Var.w();
                    return u7.a;
                case 5:
                    r7 r7Var = new r7();
                    i7Var.c();
                    while (i7Var.s()) {
                        r7Var.h(c(i7Var));
                    }
                    i7Var.l();
                    return r7Var;
                case 6:
                    v7 v7Var = new v7();
                    i7Var.q();
                    while (i7Var.s()) {
                        v7Var.h(i7Var.u(), c(i7Var));
                    }
                    i7Var.o();
                    return v7Var;
                default:
                    throw new IllegalArgumentException();
            }
        }

        @Override // defpackage.b8
        /* renamed from: e */
        public void a(k7 k7Var, d8 d8Var) throws IOException {
            if (d8Var == null || d8Var.c()) {
                k7Var.u();
            } else if (d8Var.d()) {
                x7 g = d8Var.g();
                if (g.s()) {
                    k7Var.e(g.m());
                } else if (g.j()) {
                    k7Var.g(g.q());
                } else {
                    k7Var.j(g.l());
                }
            } else if (d8Var.b()) {
                k7Var.i();
                Iterator<d8> it = d8Var.f().iterator();
                while (it.hasNext()) {
                    a(k7Var, it.next());
                }
                k7Var.p();
            } else if (!d8Var.a()) {
                throw new IllegalArgumentException("Couldn't write " + d8Var.getClass());
            } else {
                k7Var.m();
                for (Map.Entry<String, d8> entry : d8Var.e().i()) {
                    k7Var.f(entry.getKey());
                    a(k7Var, entry.getValue());
                }
                k7Var.s();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypeAdapters.java */
    /* renamed from: u6$j */
    /* loaded from: classes.dex */
    public static class j implements c8 {
        j() {
        }

        @Override // defpackage.c8
        public <T> b8<T> a(p7 p7Var, m7<T> m7Var) {
            Class a = m7Var.a();
            if (!Enum.class.isAssignableFrom(a) || a == Enum.class) {
                return null;
            }
            if (!a.isEnum()) {
                a = (Class<? super Object>) a.getSuperclass();
            }
            return new f0(a);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: u6$k */
    /* loaded from: classes.dex */
    static class k extends b8<Class> {
        k() {
        }

        @Override // defpackage.b8
        /* renamed from: d */
        public Class c(i7 i7Var) throws IOException {
            if (i7Var.t() == j7.NULL) {
                i7Var.w();
                return null;
            }
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }

        @Override // defpackage.b8
        /* renamed from: e */
        public void a(k7 k7Var, Class cls) throws IOException {
            if (cls == null) {
                k7Var.u();
                return;
            }
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypeAdapters.java */
    /* renamed from: u6$l */
    /* loaded from: classes.dex */
    public static class l implements c8 {
        final /* synthetic */ Class b;
        final /* synthetic */ b8 c;

        l(Class cls, b8 b8Var) {
            this.b = cls;
            this.c = b8Var;
        }

        @Override // defpackage.c8
        public <T> b8<T> a(p7 p7Var, m7<T> m7Var) {
            if (m7Var.a() == this.b) {
                return this.c;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.b.getName() + ",adapter=" + this.c + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypeAdapters.java */
    /* renamed from: u6$m */
    /* loaded from: classes.dex */
    public static class m implements c8 {
        final /* synthetic */ Class b;
        final /* synthetic */ Class c;
        final /* synthetic */ b8 d;

        m(Class cls, Class cls2, b8 b8Var) {
            this.b = cls;
            this.c = cls2;
            this.d = b8Var;
        }

        @Override // defpackage.c8
        public <T> b8<T> a(p7 p7Var, m7<T> m7Var) {
            Class<? super T> a = m7Var.a();
            if (a == this.b || a == this.c) {
                return this.d;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.c.getName() + "+" + this.b.getName() + ",adapter=" + this.d + "]";
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: u6$n */
    /* loaded from: classes.dex */
    static class n extends b8<Boolean> {
        n() {
        }

        @Override // defpackage.b8
        /* renamed from: d */
        public Boolean c(i7 i7Var) throws IOException {
            if (i7Var.t() != j7.NULL) {
                return i7Var.t() == j7.STRING ? Boolean.valueOf(Boolean.parseBoolean(i7Var.v())) : Boolean.valueOf(i7Var.x());
            }
            i7Var.w();
            return null;
        }

        @Override // defpackage.b8
        /* renamed from: e */
        public void a(k7 k7Var, Boolean bool) throws IOException {
            if (bool == null) {
                k7Var.u();
            } else {
                k7Var.g(bool.booleanValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypeAdapters.java */
    /* renamed from: u6$o */
    /* loaded from: classes.dex */
    public static class o implements c8 {
        final /* synthetic */ Class b;
        final /* synthetic */ Class c;
        final /* synthetic */ b8 d;

        o(Class cls, Class cls2, b8 b8Var) {
            this.b = cls;
            this.c = cls2;
            this.d = b8Var;
        }

        @Override // defpackage.c8
        public <T> b8<T> a(p7 p7Var, m7<T> m7Var) {
            Class<? super T> a = m7Var.a();
            if (a == this.b || a == this.c) {
                return this.d;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.b.getName() + "+" + this.c.getName() + ",adapter=" + this.d + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypeAdapters.java */
    /* renamed from: u6$p */
    /* loaded from: classes.dex */
    public static class p implements c8 {
        final /* synthetic */ Class b;
        final /* synthetic */ b8 c;

        p(Class cls, b8 b8Var) {
            this.b = cls;
            this.c = b8Var;
        }

        @Override // defpackage.c8
        public <T> b8<T> a(p7 p7Var, m7<T> m7Var) {
            if (this.b.isAssignableFrom(m7Var.a())) {
                return this.c;
            }
            return null;
        }

        public String toString() {
            return "Factory[typeHierarchy=" + this.b.getName() + ",adapter=" + this.c + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypeAdapters.java */
    /* renamed from: u6$q */
    /* loaded from: classes.dex */
    public static /* synthetic */ class q {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[j7.values().length];
            a = iArr;
            try {
                iArr[j7.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[j7.BOOLEAN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[j7.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[j7.NULL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[j7.BEGIN_ARRAY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[j7.BEGIN_OBJECT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[j7.END_DOCUMENT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[j7.NAME.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[j7.END_OBJECT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[j7.END_ARRAY.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: u6$r */
    /* loaded from: classes.dex */
    static class r extends b8<Boolean> {
        r() {
        }

        @Override // defpackage.b8
        /* renamed from: d */
        public Boolean c(i7 i7Var) throws IOException {
            if (i7Var.t() == j7.NULL) {
                i7Var.w();
                return null;
            }
            return Boolean.valueOf(i7Var.v());
        }

        @Override // defpackage.b8
        /* renamed from: e */
        public void a(k7 k7Var, Boolean bool) throws IOException {
            k7Var.j(bool == null ? "null" : bool.toString());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: u6$s */
    /* loaded from: classes.dex */
    static class s extends b8<Number> {
        s() {
        }

        @Override // defpackage.b8
        /* renamed from: d */
        public Number c(i7 i7Var) throws IOException {
            if (i7Var.t() == j7.NULL) {
                i7Var.w();
                return null;
            }
            try {
                return Byte.valueOf((byte) i7Var.C());
            } catch (NumberFormatException e) {
                throw new z7(e);
            }
        }

        @Override // defpackage.b8
        /* renamed from: e */
        public void a(k7 k7Var, Number number) throws IOException {
            k7Var.e(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: u6$t */
    /* loaded from: classes.dex */
    static class t extends b8<Number> {
        t() {
        }

        @Override // defpackage.b8
        /* renamed from: d */
        public Number c(i7 i7Var) throws IOException {
            if (i7Var.t() == j7.NULL) {
                i7Var.w();
                return null;
            }
            try {
                return Short.valueOf((short) i7Var.C());
            } catch (NumberFormatException e) {
                throw new z7(e);
            }
        }

        @Override // defpackage.b8
        /* renamed from: e */
        public void a(k7 k7Var, Number number) throws IOException {
            k7Var.e(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: u6$u */
    /* loaded from: classes.dex */
    static class u extends b8<Number> {
        u() {
        }

        @Override // defpackage.b8
        /* renamed from: d */
        public Number c(i7 i7Var) throws IOException {
            if (i7Var.t() == j7.NULL) {
                i7Var.w();
                return null;
            }
            return Double.valueOf(i7Var.y());
        }

        @Override // defpackage.b8
        /* renamed from: e */
        public void a(k7 k7Var, Number number) throws IOException {
            k7Var.e(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: u6$v */
    /* loaded from: classes.dex */
    static class v extends b8<Number> {
        v() {
        }

        @Override // defpackage.b8
        /* renamed from: d */
        public Number c(i7 i7Var) throws IOException {
            if (i7Var.t() == j7.NULL) {
                i7Var.w();
                return null;
            }
            try {
                return Integer.valueOf(i7Var.C());
            } catch (NumberFormatException e) {
                throw new z7(e);
            }
        }

        @Override // defpackage.b8
        /* renamed from: e */
        public void a(k7 k7Var, Number number) throws IOException {
            k7Var.e(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: u6$w */
    /* loaded from: classes.dex */
    static class w extends b8<Number> {
        w() {
        }

        @Override // defpackage.b8
        /* renamed from: d */
        public Number c(i7 i7Var) throws IOException {
            if (i7Var.t() == j7.NULL) {
                i7Var.w();
                return null;
            }
            try {
                return Long.valueOf(i7Var.z());
            } catch (NumberFormatException e) {
                throw new z7(e);
            }
        }

        @Override // defpackage.b8
        /* renamed from: e */
        public void a(k7 k7Var, Number number) throws IOException {
            k7Var.e(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: u6$x */
    /* loaded from: classes.dex */
    static class x extends b8<Number> {
        x() {
        }

        @Override // defpackage.b8
        /* renamed from: d */
        public Number c(i7 i7Var) throws IOException {
            if (i7Var.t() == j7.NULL) {
                i7Var.w();
                return null;
            }
            return Float.valueOf((float) i7Var.y());
        }

        @Override // defpackage.b8
        /* renamed from: e */
        public void a(k7 k7Var, Number number) throws IOException {
            k7Var.e(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: u6$y */
    /* loaded from: classes.dex */
    static class y extends b8<Number> {
        y() {
        }

        @Override // defpackage.b8
        /* renamed from: d */
        public Number c(i7 i7Var) throws IOException {
            j7 t = i7Var.t();
            int i = q.a[t.ordinal()];
            if (i != 1) {
                if (i == 4) {
                    i7Var.w();
                    return null;
                }
                throw new z7("Expecting number, got: " + t);
            }
            return new a7(i7Var.v());
        }

        @Override // defpackage.b8
        /* renamed from: e */
        public void a(k7 k7Var, Number number) throws IOException {
            k7Var.e(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: u6$z */
    /* loaded from: classes.dex */
    static class z extends b8<Character> {
        z() {
        }

        @Override // defpackage.b8
        /* renamed from: d */
        public Character c(i7 i7Var) throws IOException {
            if (i7Var.t() == j7.NULL) {
                i7Var.w();
                return null;
            }
            String v = i7Var.v();
            if (v.length() == 1) {
                return Character.valueOf(v.charAt(0));
            }
            throw new z7("Expecting character, got: " + v);
        }

        @Override // defpackage.b8
        /* renamed from: e */
        public void a(k7 k7Var, Character ch) throws IOException {
            k7Var.j(ch == null ? null : String.valueOf(ch));
        }
    }

    static {
        k kVar = new k();
        a = kVar;
        b = b(Class.class, kVar);
        c cVar = new c();
        c = cVar;
        d = b(BitSet.class, cVar);
        n nVar = new n();
        e = nVar;
        f = new r();
        g = c(Boolean.TYPE, Boolean.class, nVar);
        s sVar = new s();
        h = sVar;
        i = c(Byte.TYPE, Byte.class, sVar);
        t tVar = new t();
        j = tVar;
        k = c(Short.TYPE, Short.class, tVar);
        v vVar = new v();
        l = vVar;
        m = c(Integer.TYPE, Integer.class, vVar);
        n = new w();
        o = new x();
        p = new u();
        y yVar = new y();
        q = yVar;
        r = b(Number.class, yVar);
        z zVar = new z();
        s = zVar;
        t = c(Character.TYPE, Character.class, zVar);
        a0 a0Var = new a0();
        u = a0Var;
        v = new b0();
        w = new c0();
        x = b(String.class, a0Var);
        d0 d0Var = new d0();
        y = d0Var;
        z = b(StringBuilder.class, d0Var);
        e0 e0Var = new e0();
        A = e0Var;
        B = b(StringBuffer.class, e0Var);
        a aVar = new a();
        C = aVar;
        D = b(URL.class, aVar);
        b bVar = new b();
        E = bVar;
        F = b(URI.class, bVar);
        d dVar = new d();
        G = dVar;
        H = d(InetAddress.class, dVar);
        e eVar = new e();
        I = eVar;
        J = b(UUID.class, eVar);
        K = new f();
        g gVar = new g();
        L = gVar;
        M = e(Calendar.class, GregorianCalendar.class, gVar);
        h hVar = new h();
        N = hVar;
        O = b(Locale.class, hVar);
        i iVar = new i();
        P = iVar;
        Q = d(d8.class, iVar);
        R = a();
    }

    public static c8 a() {
        return new j();
    }

    public static <TT> c8 b(Class<TT> cls, b8<TT> b8Var) {
        return new l(cls, b8Var);
    }

    public static <TT> c8 c(Class<TT> cls, Class<TT> cls2, b8<? super TT> b8Var) {
        return new m(cls, cls2, b8Var);
    }

    public static <TT> c8 d(Class<TT> cls, b8<TT> b8Var) {
        return new p(cls, b8Var);
    }

    public static <TT> c8 e(Class<TT> cls, Class<? extends TT> cls2, b8<? super TT> b8Var) {
        return new o(cls, cls2, b8Var);
    }
}
