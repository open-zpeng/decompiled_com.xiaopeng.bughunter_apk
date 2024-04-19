package defpackage;

import java.util.logging.Level;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BackgroundPoster.java */
/* renamed from: an  reason: default package */
/* loaded from: classes.dex */
public final class an implements Runnable, kn {
    private final jn b = new jn();
    private final bn c;
    private volatile boolean d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(bn bnVar) {
        this.c = bnVar;
    }

    @Override // defpackage.kn
    public void a(pn pnVar, Object obj) {
        in a = in.a(pnVar, obj);
        synchronized (this) {
            this.b.a(a);
            if (!this.d) {
                this.d = true;
                this.c.d().execute(this);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        while (true) {
            try {
                in c = this.b.c(1000);
                if (c == null) {
                    synchronized (this) {
                        c = this.b.b();
                        if (c == null) {
                            return;
                        }
                    }
                }
                this.c.h(c);
            } catch (InterruptedException e) {
                fn e2 = this.c.e();
                Level level = Level.WARNING;
                e2.b(level, Thread.currentThread().getName() + " was interruppted", e);
                return;
            } finally {
                this.d = false;
            }
        }
    }
}
