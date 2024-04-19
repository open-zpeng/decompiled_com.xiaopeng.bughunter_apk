package defpackage;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
/* compiled from: SelfDestructiveThread.java */
/* renamed from: n3  reason: default package */
/* loaded from: classes.dex */
public class n3 {
    private HandlerThread b;
    private Handler c;
    private final int f;
    private final int g;
    private final String h;
    private final Object a = new Object();
    private Handler.Callback e = new a();
    private int d = 0;

    /* compiled from: SelfDestructiveThread.java */
    /* renamed from: n3$a */
    /* loaded from: classes.dex */
    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                n3.this.a();
                return true;
            } else if (i != 1) {
                return true;
            } else {
                n3.this.b((Runnable) message.obj);
                return true;
            }
        }
    }

    /* compiled from: SelfDestructiveThread.java */
    /* renamed from: n3$b */
    /* loaded from: classes.dex */
    class b implements Runnable {
        final /* synthetic */ Callable b;
        final /* synthetic */ Handler c;
        final /* synthetic */ d d;

        /* compiled from: SelfDestructiveThread.java */
        /* renamed from: n3$b$a */
        /* loaded from: classes.dex */
        class a implements Runnable {
            final /* synthetic */ Object b;

            a(Object obj) {
                this.b = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.d.a(this.b);
            }
        }

        b(Callable callable, Handler handler, d dVar) {
            this.b = callable;
            this.c = handler;
            this.d = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            try {
                obj = this.b.call();
            } catch (Exception unused) {
                obj = null;
            }
            this.c.post(new a(obj));
        }
    }

    /* compiled from: SelfDestructiveThread.java */
    /* renamed from: n3$c */
    /* loaded from: classes.dex */
    class c implements Runnable {
        final /* synthetic */ AtomicReference b;
        final /* synthetic */ Callable c;
        final /* synthetic */ ReentrantLock d;
        final /* synthetic */ AtomicBoolean e;
        final /* synthetic */ Condition f;

        c(AtomicReference atomicReference, Callable callable, ReentrantLock reentrantLock, AtomicBoolean atomicBoolean, Condition condition) {
            this.b = atomicReference;
            this.c = callable;
            this.d = reentrantLock;
            this.e = atomicBoolean;
            this.f = condition;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.b.set(this.c.call());
            } catch (Exception unused) {
            }
            this.d.lock();
            try {
                this.e.set(false);
                this.f.signal();
            } finally {
                this.d.unlock();
            }
        }
    }

    /* compiled from: SelfDestructiveThread.java */
    /* renamed from: n3$d */
    /* loaded from: classes.dex */
    public interface d<T> {
        void a(T t);
    }

    public n3(String str, int i, int i2) {
        this.h = str;
        this.g = i;
        this.f = i2;
    }

    private void c(Runnable runnable) {
        synchronized (this.a) {
            if (this.b == null) {
                HandlerThread handlerThread = new HandlerThread(this.h, this.g);
                this.b = handlerThread;
                handlerThread.start();
                this.c = new Handler(this.b.getLooper(), this.e);
                this.d++;
            }
            this.c.removeMessages(0);
            Handler handler = this.c;
            handler.sendMessage(handler.obtainMessage(1, runnable));
        }
    }

    void a() {
        synchronized (this.a) {
            if (this.c.hasMessages(1)) {
                return;
            }
            this.b.quit();
            this.b = null;
            this.c = null;
        }
    }

    void b(Runnable runnable) {
        runnable.run();
        synchronized (this.a) {
            this.c.removeMessages(0);
            Handler handler = this.c;
            handler.sendMessageDelayed(handler.obtainMessage(0), this.f);
        }
    }

    public <T> void d(Callable<T> callable, d<T> dVar) {
        c(new b(callable, new Handler(), dVar));
    }

    public <T> T e(Callable<T> callable, int i) throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition newCondition = reentrantLock.newCondition();
        AtomicReference atomicReference = new AtomicReference();
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        c(new c(atomicReference, callable, reentrantLock, atomicBoolean, newCondition));
        reentrantLock.lock();
        try {
            if (!atomicBoolean.get()) {
                return (T) atomicReference.get();
            }
            long nanos = TimeUnit.MILLISECONDS.toNanos(i);
            do {
                try {
                    nanos = newCondition.awaitNanos(nanos);
                } catch (InterruptedException unused) {
                }
                if (!atomicBoolean.get()) {
                    return (T) atomicReference.get();
                }
            } while (nanos > 0);
            throw new InterruptedException("timeout");
        } finally {
            reentrantLock.unlock();
        }
    }
}
