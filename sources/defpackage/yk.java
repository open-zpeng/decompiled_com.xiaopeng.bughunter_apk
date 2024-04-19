package defpackage;

import java.util.ArrayList;
/* compiled from: DisconnectedMessageBuffer.java */
/* renamed from: yk  reason: default package */
/* loaded from: classes.dex */
public class yk implements Runnable {
    private static final rm b = sm.a("org.eclipse.paho.client.mqttv3.internal.nls.logcat", "DisconnectedMessageBuffer");
    private xj c;
    private bl f;
    private Object e = new Object();
    private ArrayList d = new ArrayList();

    public yk(xj xjVar) {
        this.c = xjVar;
    }

    public void a(int i) {
        synchronized (this.e) {
            this.d.remove(i);
        }
    }

    public wj b(int i) {
        wj wjVar;
        synchronized (this.e) {
            wjVar = (wj) this.d.get(i);
        }
        return wjVar;
    }

    public int c() {
        int size;
        synchronized (this.e) {
            size = this.d.size();
        }
        return size;
    }

    public boolean d() {
        return this.c.d();
    }

    public void e(nm nmVar, pk pkVar) throws jk {
        wj wjVar = new wj(nmVar, pkVar);
        synchronized (this.e) {
            if (this.d.size() < this.c.a()) {
                this.d.add(wjVar);
            } else if (this.c.c()) {
                this.d.remove(0);
                this.d.add(wjVar);
            } else {
                throw new jk(32203);
            }
        }
    }

    public void f(bl blVar) {
        this.f = blVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        b.fine("DisconnectedMessageBuffer", "run", "516");
        while (c() > 0) {
            try {
                this.f.a(b(0));
                a(0);
            } catch (jk unused) {
                b.warning("DisconnectedMessageBuffer", "run", "517");
                return;
            }
        }
    }
}
