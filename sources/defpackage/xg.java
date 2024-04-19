package defpackage;

import android.os.Handler;
import android.os.Message;
import defpackage.tg;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
/* compiled from: HandlerScheduler.java */
/* renamed from: xg  reason: default package */
/* loaded from: classes.dex */
final class xg extends tg {
    private final Handler b;

    /* compiled from: HandlerScheduler.java */
    /* renamed from: xg$a */
    /* loaded from: classes.dex */
    private static final class a extends tg.b {
        private final Handler b;
        private volatile boolean c;

        a(Handler handler) {
            this.b = handler;
        }

        @Override // defpackage.tg.b
        public zg c(Runnable runnable, long j, TimeUnit timeUnit) {
            Objects.requireNonNull(runnable, "run == null");
            Objects.requireNonNull(timeUnit, "unit == null");
            if (this.c) {
                return ah.a();
            }
            b bVar = new b(this.b, uj.o(runnable));
            Message obtain = Message.obtain(this.b, bVar);
            obtain.obj = this;
            this.b.sendMessageDelayed(obtain, Math.max(0L, timeUnit.toMillis(j)));
            if (this.c) {
                this.b.removeCallbacks(bVar);
                return ah.a();
            }
            return bVar;
        }

        @Override // defpackage.zg
        public void dispose() {
            this.c = true;
            this.b.removeCallbacksAndMessages(this);
        }
    }

    /* compiled from: HandlerScheduler.java */
    /* renamed from: xg$b */
    /* loaded from: classes.dex */
    private static final class b implements Runnable, zg {
        private final Handler b;
        private final Runnable c;
        private volatile boolean d;

        b(Handler handler, Runnable runnable) {
            this.b = handler;
            this.c = runnable;
        }

        @Override // defpackage.zg
        public void dispose() {
            this.d = true;
            this.b.removeCallbacks(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.c.run();
            } catch (Throwable th) {
                IllegalStateException illegalStateException = new IllegalStateException("Fatal Exception thrown on Scheduler.", th);
                uj.m(illegalStateException);
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, illegalStateException);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public xg(Handler handler) {
        this.b = handler;
    }

    @Override // defpackage.tg
    public tg.b a() {
        return new a(this.b);
    }

    @Override // defpackage.tg
    public zg c(Runnable runnable, long j, TimeUnit timeUnit) {
        Objects.requireNonNull(runnable, "run == null");
        Objects.requireNonNull(timeUnit, "unit == null");
        b bVar = new b(this.b, uj.o(runnable));
        this.b.postDelayed(bVar, Math.max(0L, timeUnit.toMillis(j)));
        return bVar;
    }
}
