package defpackage;

import java.util.concurrent.TimeUnit;
/* compiled from: Observable.java */
/* renamed from: og  reason: default package */
/* loaded from: classes.dex */
public abstract class og<T> implements rg<T> {
    private og<T> A(long j, TimeUnit timeUnit, rg<? extends T> rgVar, tg tgVar) {
        xh.d(timeUnit, "timeUnit is null");
        xh.d(tgVar, "scheduler is null");
        return uj.j(new yi(this, j, timeUnit, tgVar, rgVar));
    }

    public static <T> og<T> B(rg<T> rgVar) {
        xh.d(rgVar, "source is null");
        if (rgVar instanceof og) {
            return uj.j((og) rgVar);
        }
        return uj.j(new oi(rgVar));
    }

    public static int b() {
        return mg.a();
    }

    public static <T> og<T> c(rg<? extends T>... rgVarArr) {
        if (rgVarArr.length == 0) {
            return i();
        }
        if (rgVarArr.length == 1) {
            return B(rgVarArr[0]);
        }
        return uj.j(new hi(k(rgVarArr), wh.b(), b(), nj.BOUNDARY));
    }

    public static <T> og<T> d(qg<T> qgVar) {
        xh.d(qgVar, "source is null");
        return uj.j(new ii(qgVar));
    }

    private og<T> f(mh<? super T> mhVar, mh<? super Throwable> mhVar2, ih ihVar, ih ihVar2) {
        xh.d(mhVar, "onNext is null");
        xh.d(mhVar2, "onError is null");
        xh.d(ihVar, "onComplete is null");
        xh.d(ihVar2, "onAfterTerminate is null");
        return uj.j(new ji(this, mhVar, mhVar2, ihVar, ihVar2));
    }

    public static <T> og<T> i() {
        return uj.j(li.b);
    }

    public static <T> og<T> k(T... tArr) {
        xh.d(tArr, "items is null");
        if (tArr.length == 0) {
            return i();
        }
        if (tArr.length == 1) {
            return l(tArr[0]);
        }
        return uj.j(new ni(tArr));
    }

    public static <T> og<T> l(T t) {
        xh.d(t, "The item is null");
        return uj.j(new pi(t));
    }

    @Override // defpackage.rg
    public final void a(sg<? super T> sgVar) {
        xh.d(sgVar, "observer is null");
        try {
            sg<? super T> p = uj.p(this, sgVar);
            xh.d(p, "Plugin returned null Observer");
            w(p);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            eh.b(th);
            uj.m(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public final og<T> e(ih ihVar) {
        return g(wh.a(), ihVar);
    }

    public final og<T> g(mh<? super zg> mhVar, ih ihVar) {
        xh.d(mhVar, "onSubscribe is null");
        xh.d(ihVar, "onDispose is null");
        return uj.j(new ki(this, mhVar, ihVar));
    }

    public final og<T> h(mh<? super T> mhVar) {
        mh<? super Throwable> a = wh.a();
        ih ihVar = wh.c;
        return f(mhVar, a, ihVar, ihVar);
    }

    public final og<T> j(ph<? super T> phVar) {
        xh.d(phVar, "predicate is null");
        return uj.j(new mi(this, phVar));
    }

    public final <R> og<R> m(nh<? super T, ? extends R> nhVar) {
        xh.d(nhVar, "mapper is null");
        return uj.j(new qi(this, nhVar));
    }

    public final og<T> n(tg tgVar) {
        return o(tgVar, false, b());
    }

    public final og<T> o(tg tgVar, boolean z, int i) {
        xh.d(tgVar, "scheduler is null");
        xh.e(i, "bufferSize");
        return uj.j(new ri(this, tgVar, z, i));
    }

    public final sj<T> p() {
        return si.E(this);
    }

    public final og<T> q(long j, ph<? super Throwable> phVar) {
        if (j >= 0) {
            xh.d(phVar, "predicate is null");
            return uj.j(new ui(this, j, phVar));
        }
        throw new IllegalArgumentException("times >= 0 required but it was " + j);
    }

    public final og<T> r(ph<? super Throwable> phVar) {
        return q(Long.MAX_VALUE, phVar);
    }

    public final og<T> s() {
        return p().D();
    }

    public final og<T> t(T t) {
        xh.d(t, "item is null");
        return c(l(t), this);
    }

    public final zg u(mh<? super T> mhVar) {
        return v(mhVar, wh.f, wh.c, wh.a());
    }

    public final zg v(mh<? super T> mhVar, mh<? super Throwable> mhVar2, ih ihVar, mh<? super zg> mhVar3) {
        xh.d(mhVar, "onNext is null");
        xh.d(mhVar2, "onError is null");
        xh.d(ihVar, "onComplete is null");
        xh.d(mhVar3, "onSubscribe is null");
        fi fiVar = new fi(mhVar, mhVar2, ihVar, mhVar3);
        a(fiVar);
        return fiVar;
    }

    protected abstract void w(sg<? super T> sgVar);

    public final og<T> x(tg tgVar) {
        xh.d(tgVar, "scheduler is null");
        return uj.j(new wi(this, tgVar));
    }

    public final og<T> y(long j) {
        if (j >= 0) {
            return uj.j(new xi(this, j));
        }
        throw new IllegalArgumentException("count >= 0 required but it was " + j);
    }

    public final og<T> z(long j, TimeUnit timeUnit) {
        return A(j, timeUnit, null, vj.a());
    }
}
