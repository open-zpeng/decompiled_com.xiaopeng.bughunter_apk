package defpackage;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
/* compiled from: ThreadUtils.java */
/* renamed from: ag  reason: default package */
/* loaded from: classes.dex */
public class ag {
    private static final ExecutorService a = Executors.newFixedThreadPool(4, new d(null).f("order-%d").e(false).d());
    private static ConcurrentHashMap<Object, c> b = new ConcurrentHashMap<>();
    private static Handler c;
    private static volatile HandlerThread d;
    private static Handler e;
    private static volatile HandlerThread f;
    private static Handler g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ThreadUtils.java */
    /* renamed from: ag$a */
    /* loaded from: classes.dex */
    public static class a implements Runnable {
        final /* synthetic */ Runnable b;
        final /* synthetic */ Runnable c;
        final /* synthetic */ boolean d;
        final /* synthetic */ Looper e;

        a(Runnable runnable, Runnable runnable2, boolean z, Looper looper) {
            this.b = runnable;
            this.c = runnable2;
            this.d = z;
            this.e = looper;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.b.run();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (this.c != null) {
                if (this.d || this.e == ag.c.getLooper()) {
                    ag.c.post(this.c);
                } else {
                    new Handler(this.e).post(this.c);
                }
            }
            tf.a("ThreadUtils", "remove task: " + this.b);
            ag.b.remove(this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ThreadUtils.java */
    /* renamed from: ag$b */
    /* loaded from: classes.dex */
    public static class b implements Runnable {
        final /* synthetic */ Runnable b;
        final /* synthetic */ boolean c;
        final /* synthetic */ Looper d;
        final /* synthetic */ Handler e;
        final /* synthetic */ Runnable f;

        /* compiled from: ThreadUtils.java */
        /* renamed from: ag$b$a */
        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.b.run();
                b bVar = b.this;
                bVar.e.post(bVar.f);
            }
        }

        /* compiled from: ThreadUtils.java */
        /* renamed from: ag$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class RunnableC0001b implements Runnable {
            RunnableC0001b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.b.run();
                b bVar = b.this;
                bVar.e.post(bVar.f);
            }
        }

        b(Runnable runnable, boolean z, Looper looper, Handler handler, Runnable runnable2) {
            this.b = runnable;
            this.c = z;
            this.d = looper;
            this.e = handler;
            this.f = runnable2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.b != null) {
                if (this.c || this.d == ag.c.getLooper()) {
                    ag.c.post(new a());
                    return;
                } else {
                    new Handler(this.d).post(new RunnableC0001b());
                    return;
                }
            }
            this.f.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ThreadUtils.java */
    /* renamed from: ag$c */
    /* loaded from: classes.dex */
    public static class c {
        private Runnable a;
        private Integer b;

        public c(Runnable runnable, Integer num) {
            this.a = runnable;
            this.b = num;
        }

        public Runnable a() {
            return this.a;
        }

        public int b() {
            return this.b.intValue();
        }
    }

    private static synchronized void c() {
        synchronized (ag.class) {
            if (d == null) {
                d = new HandlerThread("BackgroundHandler", 10);
                d.start();
                e = new Handler(d.getLooper());
            }
        }
    }

    private static synchronized void d() {
        synchronized (ag.class) {
            if (c == null) {
                c = new Handler(Looper.getMainLooper());
            }
        }
    }

    private static synchronized void e() {
        synchronized (ag.class) {
            if (f == null) {
                f = new HandlerThread("NormalHandler", 0);
                f.start();
                g = new Handler(f.getLooper());
            }
        }
    }

    private static void f(int i, Runnable runnable, Runnable runnable2, Runnable runnable3, boolean z, long j) {
        Handler handler;
        if (runnable2 == null) {
            return;
        }
        if (c == null) {
            d();
        }
        if (i == 0) {
            if (d == null) {
                c();
            }
            handler = e;
        } else if (i == 1) {
            handler = c;
        } else if (i != 2) {
            handler = c;
        } else {
            if (f == null) {
                e();
            }
            handler = g;
        }
        if (handler == null) {
            handler = c;
        }
        Looper looper = null;
        if (!z && (looper = Looper.myLooper()) == null) {
            looper = c.getLooper();
        }
        Looper looper2 = looper;
        a aVar = new a(runnable2, runnable3, z, looper2);
        b bVar = new b(runnable, z, looper2, handler, aVar);
        if (runnable == null) {
            b.put(runnable2, new c(bVar, Integer.valueOf(i)));
        } else {
            b.put(runnable2, new c(aVar, Integer.valueOf(i)));
        }
        tf.a("ThreadUtils", "put task: " + runnable2);
        handler.postDelayed(bVar, j);
    }

    public static Looper g(int i) {
        if (i == 0) {
            c();
            return d.getLooper();
        } else if (i == 1) {
            d();
            return c.getLooper();
        } else if (i == 2) {
            e();
            return g.getLooper();
        } else {
            throw new IllegalArgumentException("invalid threadType:" + i);
        }
    }

    public static void h(int i, Runnable runnable) {
        f(i, null, runnable, null, false, 0L);
    }

    public static void i(Runnable runnable) {
        f(0, null, runnable, null, false, 0L);
    }

    public static void j(Runnable runnable, long j) {
        f(0, null, runnable, null, false, j);
    }

    public static void k(int i, Runnable runnable, long j) {
        f(i, null, runnable, null, false, j);
    }

    public static void l(Runnable runnable) {
        f(2, null, runnable, null, false, 0L);
    }

    public static void m(Runnable runnable, long j) {
        f(2, null, runnable, null, false, j);
    }

    public static void n(Runnable runnable) {
        c remove;
        Runnable a2;
        Handler handler;
        if (runnable == null || (remove = b.remove(runnable)) == null || (a2 = remove.a()) == null) {
            return;
        }
        int b2 = remove.b();
        if (b2 == 0) {
            Handler handler2 = e;
            if (handler2 != null) {
                handler2.removeCallbacks(a2);
            }
        } else if (b2 != 1) {
            if (b2 == 2 && (handler = g) != null) {
                handler.removeCallbacks(a2);
            }
        } else {
            Handler handler3 = c;
            if (handler3 != null) {
                handler3.removeCallbacks(a2);
            }
        }
    }

    /* compiled from: ThreadUtils.java */
    /* renamed from: ag$d */
    /* loaded from: classes.dex */
    private static class d {
        private String a;
        private boolean b;
        private ThreadFactory c;
        private String d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ThreadUtils.java */
        /* renamed from: ag$d$a */
        /* loaded from: classes.dex */
        public class a implements ThreadFactory {
            a() {
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread newThread = (d.this.c != null ? d.this.c : Executors.defaultThreadFactory()).newThread(runnable);
                AtomicLong atomicLong = d.this.d != null ? new AtomicLong(0L) : null;
                if (d.this.d != null) {
                    newThread.setName(String.format(Locale.ROOT, d.this.d, Long.valueOf(atomicLong.getAndIncrement())));
                }
                newThread.setDaemon(d.this.b);
                return newThread;
            }
        }

        private d() {
            this.a = "newFixedThreadPool";
            this.b = false;
        }

        ThreadFactory d() {
            return new a();
        }

        d e(boolean z) {
            this.b = z;
            return this;
        }

        d f(String str) {
            this.d = str;
            return this;
        }

        /* synthetic */ d(zf zfVar) {
            this();
        }
    }
}
