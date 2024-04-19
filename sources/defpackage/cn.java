package defpackage;

import android.os.Looper;
import defpackage.fn;
import defpackage.gn;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* compiled from: EventBusBuilder.java */
/* renamed from: cn  reason: default package */
/* loaded from: classes.dex */
public class cn {
    private static final ExecutorService a = Executors.newCachedThreadPool();
    boolean f;
    boolean h;
    boolean i;
    List<sn> k;
    fn l;
    gn m;
    boolean b = true;
    boolean c = true;
    boolean d = true;
    boolean e = true;
    boolean g = true;
    ExecutorService j = a;

    Object a() {
        try {
            return Looper.getMainLooper();
        } catch (RuntimeException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public fn b() {
        fn fnVar = this.l;
        return fnVar != null ? fnVar : (!fn.a.c() || a() == null) ? new fn.b() : new fn.a("EventBus");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public gn c() {
        Object a2;
        gn gnVar = this.m;
        if (gnVar != null) {
            return gnVar;
        }
        if (!fn.a.c() || (a2 = a()) == null) {
            return null;
        }
        return new gn.a((Looper) a2);
    }
}
