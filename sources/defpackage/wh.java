package defpackage;

import java.util.Comparator;
import java.util.concurrent.Callable;
/* compiled from: Functions.java */
/* renamed from: wh  reason: default package */
/* loaded from: classes.dex */
public final class wh {
    static final nh<Object, Object> a = new g();
    public static final Runnable b = new d();
    public static final ih c = new a();
    static final mh<Object> d = new b();
    public static final mh<Throwable> e = new e();
    public static final mh<Throwable> f = new k();
    public static final oh g = new c();
    static final ph<Object> h = new l();
    static final ph<Object> i = new f();
    static final Callable<Object> j = new j();
    static final Comparator<Object> k = new i();
    public static final mh<un> l = new h();

    /* compiled from: Functions.java */
    /* renamed from: wh$a */
    /* loaded from: classes.dex */
    static final class a implements ih {
        a() {
        }

        @Override // defpackage.ih
        public void run() {
        }

        public String toString() {
            return "EmptyAction";
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: wh$b */
    /* loaded from: classes.dex */
    static final class b implements mh<Object> {
        b() {
        }

        @Override // defpackage.mh
        public void accept(Object obj) {
        }

        public String toString() {
            return "EmptyConsumer";
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: wh$c */
    /* loaded from: classes.dex */
    static final class c implements oh {
        c() {
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: wh$d */
    /* loaded from: classes.dex */
    static final class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
        }

        public String toString() {
            return "EmptyRunnable";
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: wh$e */
    /* loaded from: classes.dex */
    static final class e implements mh<Throwable> {
        e() {
        }

        @Override // defpackage.mh
        /* renamed from: a */
        public void accept(Throwable th) {
            uj.m(th);
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: wh$f */
    /* loaded from: classes.dex */
    static final class f implements ph<Object> {
        f() {
        }

        @Override // defpackage.ph
        public boolean test(Object obj) {
            return false;
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: wh$g */
    /* loaded from: classes.dex */
    static final class g implements nh<Object, Object> {
        g() {
        }

        @Override // defpackage.nh
        public Object apply(Object obj) {
            return obj;
        }

        public String toString() {
            return "IdentityFunction";
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: wh$h */
    /* loaded from: classes.dex */
    static final class h implements mh<un> {
        h() {
        }

        @Override // defpackage.mh
        /* renamed from: a */
        public void accept(un unVar) throws Exception {
            unVar.request(Long.MAX_VALUE);
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: wh$i */
    /* loaded from: classes.dex */
    static final class i implements Comparator<Object> {
        i() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: wh$j */
    /* loaded from: classes.dex */
    static final class j implements Callable<Object> {
        j() {
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return null;
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: wh$k */
    /* loaded from: classes.dex */
    static final class k implements mh<Throwable> {
        k() {
        }

        @Override // defpackage.mh
        /* renamed from: a */
        public void accept(Throwable th) {
            uj.m(new fh(th));
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: wh$l */
    /* loaded from: classes.dex */
    static final class l implements ph<Object> {
        l() {
        }

        @Override // defpackage.ph
        public boolean test(Object obj) {
            return true;
        }
    }

    public static <T> mh<T> a() {
        return (mh<T>) d;
    }

    public static <T> nh<T, T> b() {
        return (nh<T, T>) a;
    }
}
