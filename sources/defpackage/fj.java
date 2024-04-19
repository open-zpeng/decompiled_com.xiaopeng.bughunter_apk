package defpackage;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
/* compiled from: RxThreadFactory.java */
/* renamed from: fj  reason: default package */
/* loaded from: classes.dex */
public final class fj extends AtomicLong implements ThreadFactory {
    private static final long serialVersionUID = -7789753024099756196L;
    final String b;
    final int c;
    final boolean d;

    /* compiled from: RxThreadFactory.java */
    /* renamed from: fj$a */
    /* loaded from: classes.dex */
    static final class a extends Thread {
        a(Runnable runnable, String str) {
            super(runnable, str);
        }
    }

    public fj(String str) {
        this(str, 5, false);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        String str = this.b + '-' + incrementAndGet();
        Thread aVar = this.d ? new a(runnable, str) : new Thread(runnable, str);
        aVar.setPriority(this.c);
        aVar.setDaemon(true);
        return aVar;
    }

    @Override // java.util.concurrent.atomic.AtomicLong
    public String toString() {
        return "RxThreadFactory[" + this.b + "]";
    }

    public fj(String str, int i) {
        this(str, i, false);
    }

    public fj(String str, int i, boolean z) {
        this.b = str;
        this.c = i;
        this.d = z;
    }
}
