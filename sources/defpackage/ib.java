package defpackage;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IInputController;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: TaskExecutor.java */
/* renamed from: ib  reason: default package */
/* loaded from: classes.dex */
public class ib {
    private static ThreadPoolExecutor a = null;
    private static int b = 1;
    private static int c = 3;
    private static int d = 10;
    private static int e = 60;
    public static ib f;
    private static final AtomicInteger g = new AtomicInteger();
    private HandlerThread h;
    private Handler i;

    /* compiled from: TaskExecutor.java */
    /* renamed from: ib$a */
    /* loaded from: classes.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            try {
                Object obj = message.obj;
                if (obj == null || !(obj instanceof Runnable)) {
                    return;
                }
                ib.f().submit((Runnable) message.obj);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TaskExecutor.java */
    /* renamed from: ib$b */
    /* loaded from: classes.dex */
    public static class b implements ThreadFactory {
        private int b;

        public b(int i) {
            this.b = i;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            int andIncrement = ib.g.getAndIncrement();
            Thread thread = new Thread(runnable, "AppMonitor:" + andIncrement);
            thread.setPriority(this.b);
            return thread;
        }
    }

    private ib() {
        HandlerThread handlerThread = new HandlerThread("AppMonitor");
        this.h = handlerThread;
        handlerThread.start();
        this.i = new a(this.h.getLooper());
    }

    public static synchronized ib a() {
        ib ibVar;
        synchronized (ib.class) {
            if (f == null) {
                f = new ib();
            }
            ibVar = f;
        }
        return ibVar;
    }

    private static synchronized ThreadPoolExecutor b() {
        ThreadPoolExecutor threadPoolExecutor;
        synchronized (ib.class) {
            if (a == null) {
                a = c(b, c, d, e, IInputController.KEYCODE_KNOB_WIND_SPD_UP);
            }
            threadPoolExecutor = a;
        }
        return threadPoolExecutor;
    }

    @TargetApi(9)
    private static ThreadPoolExecutor c(int i, int i2, int i3, int i4, int i5) {
        LinkedBlockingQueue linkedBlockingQueue;
        if (i5 > 0) {
            linkedBlockingQueue = new LinkedBlockingQueue(i5);
        } else {
            linkedBlockingQueue = new LinkedBlockingQueue();
        }
        b bVar = new b(i);
        return new ThreadPoolExecutor(i2, i3, i4, TimeUnit.SECONDS, linkedBlockingQueue, bVar, new ThreadPoolExecutor.DiscardOldestPolicy());
    }

    static /* synthetic */ ThreadPoolExecutor f() {
        return b();
    }

    public final void e(int i, Runnable runnable, long j) {
        try {
            Message obtain = Message.obtain(this.i, i);
            obtain.obj = runnable;
            this.i.sendMessageDelayed(obtain, j);
        } catch (Exception e2) {
            w8.d(e2);
        }
    }

    public void g(Runnable runnable) {
        try {
            b().submit(runnable);
        } catch (Throwable unused) {
        }
    }

    public final boolean h(int i) {
        return this.i.hasMessages(i);
    }

    public final void i(int i) {
        this.i.removeMessages(i);
    }
}
