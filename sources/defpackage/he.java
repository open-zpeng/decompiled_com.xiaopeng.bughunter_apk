package defpackage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* compiled from: CarApiThreadPool.java */
/* renamed from: he  reason: default package */
/* loaded from: classes.dex */
public class he {
    private static ExecutorService a = Executors.newCachedThreadPool();

    public static void a(Runnable runnable) {
        a.execute(runnable);
    }
}
