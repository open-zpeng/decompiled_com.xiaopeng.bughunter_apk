package defpackage;

import java.util.concurrent.Callable;
/* compiled from: RxJavaPlugins.java */
/* renamed from: uj  reason: default package */
/* loaded from: classes.dex */
public final class uj {
    static volatile mh<? super Throwable> a;
    static volatile nh<? super Runnable, ? extends Runnable> b;
    static volatile nh<? super Callable<tg>, ? extends tg> c;
    static volatile nh<? super Callable<tg>, ? extends tg> d;
    static volatile nh<? super Callable<tg>, ? extends tg> e;
    static volatile nh<? super Callable<tg>, ? extends tg> f;
    static volatile nh<? super tg, ? extends tg> g;
    static volatile nh<? super tg, ? extends tg> h;
    static volatile nh<? super og, ? extends og> i;
    static volatile nh<? super sj, ? extends sj> j;
    static volatile jh<? super og, ? super sg, ? extends sg> k;

    static <T, U, R> R a(jh<T, U, R> jhVar, T t, U u) {
        try {
            return jhVar.a(t, u);
        } catch (Throwable th) {
            throw oj.c(th);
        }
    }

    static <T, R> R b(nh<T, R> nhVar, T t) {
        try {
            return nhVar.apply(t);
        } catch (Throwable th) {
            throw oj.c(th);
        }
    }

    static tg c(nh<? super Callable<tg>, ? extends tg> nhVar, Callable<tg> callable) {
        return (tg) xh.d(b(nhVar, callable), "Scheduler Callable result can't be null");
    }

    static tg d(Callable<tg> callable) {
        try {
            return (tg) xh.d(callable.call(), "Scheduler Callable result can't be null");
        } catch (Throwable th) {
            throw oj.c(th);
        }
    }

    public static tg e(Callable<tg> callable) {
        xh.d(callable, "Scheduler Callable can't be null");
        nh<? super Callable<tg>, ? extends tg> nhVar = c;
        if (nhVar == null) {
            return d(callable);
        }
        return c(nhVar, callable);
    }

    public static tg f(Callable<tg> callable) {
        xh.d(callable, "Scheduler Callable can't be null");
        nh<? super Callable<tg>, ? extends tg> nhVar = e;
        if (nhVar == null) {
            return d(callable);
        }
        return c(nhVar, callable);
    }

    public static tg g(Callable<tg> callable) {
        xh.d(callable, "Scheduler Callable can't be null");
        nh<? super Callable<tg>, ? extends tg> nhVar = f;
        if (nhVar == null) {
            return d(callable);
        }
        return c(nhVar, callable);
    }

    public static tg h(Callable<tg> callable) {
        xh.d(callable, "Scheduler Callable can't be null");
        nh<? super Callable<tg>, ? extends tg> nhVar = d;
        if (nhVar == null) {
            return d(callable);
        }
        return c(nhVar, callable);
    }

    static boolean i(Throwable th) {
        return (th instanceof fh) || (th instanceof IllegalStateException) || (th instanceof NullPointerException) || (th instanceof IllegalArgumentException) || (th instanceof dh);
    }

    public static <T> og<T> j(og<T> ogVar) {
        nh<? super og, ? extends og> nhVar = i;
        return nhVar != null ? (og) b(nhVar, ogVar) : ogVar;
    }

    public static <T> sj<T> k(sj<T> sjVar) {
        nh<? super sj, ? extends sj> nhVar = j;
        return nhVar != null ? (sj) b(nhVar, sjVar) : sjVar;
    }

    public static tg l(tg tgVar) {
        nh<? super tg, ? extends tg> nhVar = g;
        return nhVar == null ? tgVar : (tg) b(nhVar, tgVar);
    }

    public static void m(Throwable th) {
        mh<? super Throwable> mhVar = a;
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        } else if (!i(th)) {
            th = new hh(th);
        }
        if (mhVar != null) {
            try {
                mhVar.accept(th);
                return;
            } catch (Throwable th2) {
                th2.printStackTrace();
                q(th2);
            }
        }
        th.printStackTrace();
        q(th);
    }

    public static tg n(tg tgVar) {
        nh<? super tg, ? extends tg> nhVar = h;
        return nhVar == null ? tgVar : (tg) b(nhVar, tgVar);
    }

    public static Runnable o(Runnable runnable) {
        xh.d(runnable, "run is null");
        nh<? super Runnable, ? extends Runnable> nhVar = b;
        return nhVar == null ? runnable : (Runnable) b(nhVar, runnable);
    }

    public static <T> sg<? super T> p(og<T> ogVar, sg<? super T> sgVar) {
        jh<? super og, ? super sg, ? extends sg> jhVar = k;
        return jhVar != null ? (sg) a(jhVar, ogVar, sgVar) : sgVar;
    }

    static void q(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }
}
