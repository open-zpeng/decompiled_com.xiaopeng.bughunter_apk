package defpackage;

import java.util.concurrent.Callable;
/* compiled from: Schedulers.java */
/* renamed from: vj  reason: default package */
/* loaded from: classes.dex */
public final class vj {
    static final tg a = uj.h(new h());
    static final tg b = uj.e(new b());
    static final tg c = uj.f(new c());
    static final tg d = kj.d();
    static final tg e = uj.g(new f());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Schedulers.java */
    /* renamed from: vj$a */
    /* loaded from: classes.dex */
    public static final class a {
        static final tg a = new bj();
    }

    /* compiled from: Schedulers.java */
    /* renamed from: vj$b */
    /* loaded from: classes.dex */
    static final class b implements Callable<tg> {
        b() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public tg call() throws Exception {
            return a.a;
        }
    }

    /* compiled from: Schedulers.java */
    /* renamed from: vj$c */
    /* loaded from: classes.dex */
    static final class c implements Callable<tg> {
        c() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public tg call() throws Exception {
            return d.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Schedulers.java */
    /* renamed from: vj$d */
    /* loaded from: classes.dex */
    public static final class d {
        static final tg a = new cj();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Schedulers.java */
    /* renamed from: vj$e */
    /* loaded from: classes.dex */
    public static final class e {
        static final tg a = new dj();
    }

    /* compiled from: Schedulers.java */
    /* renamed from: vj$f */
    /* loaded from: classes.dex */
    static final class f implements Callable<tg> {
        f() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public tg call() throws Exception {
            return e.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Schedulers.java */
    /* renamed from: vj$g */
    /* loaded from: classes.dex */
    public static final class g {
        static final tg a = new jj();
    }

    /* compiled from: Schedulers.java */
    /* renamed from: vj$h */
    /* loaded from: classes.dex */
    static final class h implements Callable<tg> {
        h() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public tg call() throws Exception {
            return g.a;
        }
    }

    public static tg a() {
        return uj.l(b);
    }

    public static tg b() {
        return uj.n(c);
    }

    public static tg c() {
        return d;
    }
}
