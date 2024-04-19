package defpackage;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
/* compiled from: CommsCallback.java */
/* renamed from: tk  reason: default package */
/* loaded from: classes.dex */
public class tk implements Runnable {
    private static final String b;
    private static final rm c;
    private ek d;
    private fk e;
    private rk g;
    private Thread m;
    private sk p;
    private String r;
    private Future t;
    public boolean j = false;
    private boolean k = false;
    private Object l = new Object();
    private Object n = new Object();
    private Object o = new Object();
    private boolean q = false;
    private final Semaphore s = new Semaphore(1);
    private Vector h = new Vector(10);
    private Vector i = new Vector(10);
    private Hashtable f = new Hashtable();

    static {
        String name = tk.class.getName();
        b = name;
        c = sm.a("org.eclipse.paho.client.mqttv3.internal.nls.logcat", name);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public tk(rk rkVar) {
        this.g = rkVar;
        c.setResourceName(rkVar.t().b());
    }

    private void f(pk pkVar) throws jk {
        synchronized (pkVar) {
            c.fine(b, "handleActionComplete", "705", new Object[]{pkVar.a.e()});
            if (pkVar.h()) {
                this.p.t(pkVar);
            }
            pkVar.a.p();
            if (!pkVar.a.n()) {
                if (this.d != null && (pkVar instanceof ik) && pkVar.h()) {
                    this.d.deliveryComplete((ik) pkVar);
                }
                d(pkVar);
            }
            if (pkVar.h() && ((pkVar instanceof ik) || (pkVar.e() instanceof yj))) {
                pkVar.a.x(true);
            }
        }
    }

    private void g(hm hmVar) throws jk, Exception {
        String A = hmVar.A();
        c.fine(b, "handleMessage", "713", new Object[]{new Integer(hmVar.p()), A});
        c(A, hmVar.p(), hmVar.z());
        if (this.q) {
            return;
        }
        if (hmVar.z().c() == 1) {
            this.g.z(new dm(hmVar), new pk(this.g.t().b()));
        } else if (hmVar.z().c() == 2) {
            this.g.q(hmVar);
            em emVar = new em(hmVar);
            rk rkVar = this.g;
            rkVar.z(emVar, new pk(rkVar.t().b()));
        }
    }

    public void a(pk pkVar) {
        if (this.j) {
            this.i.addElement(pkVar);
            synchronized (this.n) {
                c.fine(b, "asyncOperationComplete", "715", new Object[]{pkVar.a.e()});
                this.n.notifyAll();
            }
            return;
        }
        try {
            f(pkVar);
        } catch (Throwable th) {
            c.fine(b, "asyncOperationComplete", "719", null, th);
            this.g.O(null, new jk(th));
        }
    }

    public void b(jk jkVar) {
        try {
            if (this.d != null && jkVar != null) {
                c.fine(b, "connectionLost", "708", new Object[]{jkVar});
                this.d.connectionLost(jkVar);
            }
            fk fkVar = this.e;
            if (fkVar == null || jkVar == null) {
                return;
            }
            fkVar.connectionLost(jkVar);
        } catch (Throwable th) {
            c.fine(b, "connectionLost", "720", new Object[]{th});
        }
    }

    protected boolean c(String str, int i, kk kkVar) throws Exception {
        Enumeration keys = this.f.keys();
        boolean z = false;
        while (keys.hasMoreElements()) {
            String str2 = (String) keys.nextElement();
            if (qk.a(str2, str)) {
                kkVar.g(i);
                ((bk) this.f.get(str2)).messageArrived(str, kkVar);
                z = true;
            }
        }
        if (this.d == null || z) {
            return z;
        }
        kkVar.g(i);
        this.d.messageArrived(str, kkVar);
        return true;
    }

    public void d(pk pkVar) {
        yj e;
        if (pkVar == null || (e = pkVar.e()) == null) {
            return;
        }
        if (pkVar.g() == null) {
            c.fine(b, "fireActionEvent", "716", new Object[]{pkVar.a.e()});
            e.onSuccess(pkVar);
            return;
        }
        c.fine(b, "fireActionEvent", "716", new Object[]{pkVar.a.e()});
        e.onFailure(pkVar, pkVar.g());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Thread e() {
        return this.m;
    }

    public boolean h() {
        return this.k && this.i.size() == 0 && this.h.size() == 0;
    }

    public void i(hm hmVar) {
        if (this.d != null || this.f.size() > 0) {
            synchronized (this.o) {
                while (this.j && !this.k && this.h.size() >= 10) {
                    try {
                        c.fine(b, "messageArrived", "709");
                        this.o.wait(200L);
                    } catch (InterruptedException unused) {
                    }
                }
            }
            if (this.k) {
                return;
            }
            this.h.addElement(hmVar);
            synchronized (this.n) {
                c.fine(b, "messageArrived", "710");
                this.n.notifyAll();
            }
        }
    }

    public void j() {
        this.k = true;
        synchronized (this.o) {
            c.fine(b, "quiesce", "711");
            this.o.notifyAll();
        }
    }

    public void k(String str) {
        this.f.remove(str);
    }

    public void l() {
        this.f.clear();
    }

    public void m(ek ekVar) {
        this.d = ekVar;
    }

    public void n(sk skVar) {
        this.p = skVar;
    }

    public void o(fk fkVar) {
        this.e = fkVar;
    }

    public void p(String str, ExecutorService executorService) {
        this.r = str;
        synchronized (this.l) {
            if (!this.j) {
                this.h.clear();
                this.i.clear();
                this.j = true;
                this.k = false;
                this.t = executorService.submit(this);
            }
        }
    }

    public void q() {
        Semaphore semaphore;
        synchronized (this.l) {
            Future future = this.t;
            if (future != null) {
                future.cancel(true);
            }
            if (this.j) {
                rm rmVar = c;
                String str = b;
                rmVar.fine(str, "stop", "700");
                this.j = false;
                if (!Thread.currentThread().equals(this.m)) {
                    try {
                        synchronized (this.n) {
                            rmVar.fine(str, "stop", "701");
                            this.n.notifyAll();
                        }
                        this.s.acquire();
                        semaphore = this.s;
                    } catch (InterruptedException unused) {
                        semaphore = this.s;
                    }
                    semaphore.release();
                }
            }
            this.m = null;
            c.fine(b, "stop", "703");
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        pk pkVar;
        hm hmVar;
        Thread currentThread = Thread.currentThread();
        this.m = currentThread;
        currentThread.setName(this.r);
        try {
            this.s.acquire();
            while (this.j) {
                try {
                    try {
                        synchronized (this.n) {
                            if (this.j && this.h.isEmpty() && this.i.isEmpty()) {
                                c.fine(b, "run", "704");
                                this.n.wait();
                            }
                        }
                    } catch (Throwable th) {
                        try {
                            rm rmVar = c;
                            String str = b;
                            rmVar.fine(str, "run", "714", null, th);
                            this.j = false;
                            this.g.O(null, new jk(th));
                            this.s.release();
                            synchronized (this.o) {
                                rmVar.fine(str, "run", "706");
                                this.o.notifyAll();
                            }
                        } catch (Throwable th2) {
                            this.s.release();
                            synchronized (this.o) {
                                c.fine(b, "run", "706");
                                this.o.notifyAll();
                                throw th2;
                            }
                        }
                    }
                } catch (InterruptedException unused) {
                }
                if (this.j) {
                    synchronized (this.i) {
                        if (this.i.isEmpty()) {
                            pkVar = null;
                        } else {
                            pkVar = (pk) this.i.elementAt(0);
                            this.i.removeElementAt(0);
                        }
                    }
                    if (pkVar != null) {
                        f(pkVar);
                    }
                    synchronized (this.h) {
                        if (this.h.isEmpty()) {
                            hmVar = null;
                        } else {
                            hmVar = (hm) this.h.elementAt(0);
                            this.h.removeElementAt(0);
                        }
                    }
                    if (hmVar != null) {
                        g(hmVar);
                    }
                }
                if (this.k) {
                    this.p.b();
                }
                this.s.release();
                synchronized (this.o) {
                    c.fine(b, "run", "706");
                    this.o.notifyAll();
                }
            }
        } catch (InterruptedException unused2) {
            this.j = false;
        }
    }
}
