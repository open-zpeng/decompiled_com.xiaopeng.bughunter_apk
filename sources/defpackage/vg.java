package defpackage;

import java.util.Objects;
import java.util.concurrent.Callable;
/* compiled from: RxAndroidPlugins.java */
/* renamed from: vg  reason: default package */
/* loaded from: classes.dex */
public final class vg {
    private static volatile nh<Callable<tg>, tg> a;
    private static volatile nh<tg, tg> b;

    static <T, R> R a(nh<T, R> nhVar, T t) {
        try {
            return nhVar.apply(t);
        } catch (Throwable th) {
            throw eh.a(th);
        }
    }

    static tg b(nh<Callable<tg>, tg> nhVar, Callable<tg> callable) {
        tg tgVar = (tg) a(nhVar, callable);
        Objects.requireNonNull(tgVar, "Scheduler Callable returned null");
        return tgVar;
    }

    static tg c(Callable<tg> callable) {
        try {
            tg call = callable.call();
            if (call != null) {
                return call;
            }
            throw new NullPointerException("Scheduler Callable returned null");
        } catch (Throwable th) {
            throw eh.a(th);
        }
    }

    public static tg d(Callable<tg> callable) {
        Objects.requireNonNull(callable, "scheduler == null");
        nh<Callable<tg>, tg> nhVar = a;
        if (nhVar == null) {
            return c(callable);
        }
        return b(nhVar, callable);
    }

    public static tg e(tg tgVar) {
        Objects.requireNonNull(tgVar, "scheduler == null");
        nh<tg, tg> nhVar = b;
        return nhVar == null ? tgVar : (tg) a(nhVar, tgVar);
    }
}
