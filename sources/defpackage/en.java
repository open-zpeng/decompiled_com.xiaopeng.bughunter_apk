package defpackage;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
/* compiled from: HandlerPoster.java */
/* renamed from: en  reason: default package */
/* loaded from: classes.dex */
public class en extends Handler implements kn {
    private final jn b;
    private final int c;
    private final bn d;
    private boolean e;

    /* JADX INFO: Access modifiers changed from: protected */
    public en(bn bnVar, Looper looper, int i) {
        super(looper);
        this.d = bnVar;
        this.c = i;
        this.b = new jn();
    }

    @Override // defpackage.kn
    public void a(pn pnVar, Object obj) {
        in a = in.a(pnVar, obj);
        synchronized (this) {
            this.b.a(a);
            if (!this.e) {
                this.e = true;
                if (!sendMessage(obtainMessage())) {
                    throw new dn("Could not send handler message");
                }
            }
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            do {
                in b = this.b.b();
                if (b == null) {
                    synchronized (this) {
                        b = this.b.b();
                        if (b == null) {
                            this.e = false;
                            return;
                        }
                    }
                }
                this.d.h(b);
            } while (SystemClock.uptimeMillis() - uptimeMillis < this.c);
            if (sendMessage(obtainMessage())) {
                this.e = true;
                return;
            }
            throw new dn("Could not send handler message");
        } finally {
            this.e = false;
        }
    }
}
