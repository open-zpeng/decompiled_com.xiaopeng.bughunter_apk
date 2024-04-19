package defpackage;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* compiled from: DefaultTaskExecutor.java */
/* renamed from: b  reason: default package */
/* loaded from: classes.dex */
public class b extends c {
    private final Object a = new Object();
    private ExecutorService b = Executors.newFixedThreadPool(2);
    private volatile Handler c;

    @Override // defpackage.c
    public void a(Runnable runnable) {
        this.b.execute(runnable);
    }

    @Override // defpackage.c
    public boolean b() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    @Override // defpackage.c
    public void c(Runnable runnable) {
        if (this.c == null) {
            synchronized (this.a) {
                if (this.c == null) {
                    this.c = new Handler(Looper.getMainLooper());
                }
            }
        }
        this.c.post(runnable);
    }
}
