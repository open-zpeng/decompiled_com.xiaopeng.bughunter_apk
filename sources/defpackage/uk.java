package defpackage;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
/* compiled from: CommsReceiver.java */
/* renamed from: uk  reason: default package */
/* loaded from: classes.dex */
public class uk implements Runnable {
    private static final String b;
    private static final rm c;
    private sk f;
    private rk g;
    private yl h;
    private wk i;
    private volatile boolean k;
    private String m;
    private Future n;
    private boolean d = false;
    private Object e = new Object();
    private Thread j = null;
    private final Semaphore l = new Semaphore(1);

    static {
        String name = uk.class.getName();
        b = name;
        c = sm.a("org.eclipse.paho.client.mqttv3.internal.nls.logcat", name);
    }

    public uk(rk rkVar, sk skVar, wk wkVar, InputStream inputStream) {
        this.f = null;
        this.g = null;
        this.i = null;
        this.h = new yl(skVar, inputStream);
        this.g = rkVar;
        this.f = skVar;
        this.i = wkVar;
        c.setResourceName(rkVar.t().b());
    }

    public void a(String str, ExecutorService executorService) {
        this.m = str;
        c.fine(b, "start", "855");
        synchronized (this.e) {
            if (!this.d) {
                this.d = true;
                this.n = executorService.submit(this);
            }
        }
    }

    public void b() {
        Semaphore semaphore;
        synchronized (this.e) {
            Future future = this.n;
            if (future != null) {
                future.cancel(true);
            }
            c.fine(b, "stop", "850");
            if (this.d) {
                this.d = false;
                this.k = false;
                if (!Thread.currentThread().equals(this.j)) {
                    try {
                        this.l.acquire();
                        semaphore = this.l;
                    } catch (InterruptedException unused) {
                        semaphore = this.l;
                    }
                    semaphore.release();
                }
            }
        }
        this.j = null;
        c.fine(b, "stop", "851");
    }

    @Override // java.lang.Runnable
    public void run() {
        Thread currentThread = Thread.currentThread();
        this.j = currentThread;
        currentThread.setName(this.m);
        try {
            this.l.acquire();
            pk pkVar = null;
            while (this.d && this.h != null) {
                try {
                    try {
                        try {
                            rm rmVar = c;
                            String str = b;
                            rmVar.fine(str, "run", "852");
                            this.k = this.h.available() > 0;
                            nm b2 = this.h.b();
                            this.k = false;
                            if (b2 instanceof ul) {
                                pkVar = this.i.f(b2);
                                if (pkVar != null) {
                                    synchronized (pkVar) {
                                        this.f.v((ul) b2);
                                    }
                                } else {
                                    if (!(b2 instanceof fm) && !(b2 instanceof em) && !(b2 instanceof dm)) {
                                        throw new jk(6);
                                    }
                                    rmVar.fine(str, "run", "857");
                                }
                            } else if (b2 != null) {
                                this.f.x(b2);
                            }
                        } catch (jk e) {
                            c.fine(b, "run", "856", null, e);
                            this.d = false;
                            this.g.O(pkVar, e);
                        }
                    } catch (IOException e2) {
                        c.fine(b, "run", "853");
                        this.d = false;
                        if (!this.g.E()) {
                            this.g.O(pkVar, new jk(32109, e2));
                        }
                    }
                } finally {
                    this.k = false;
                    this.l.release();
                }
            }
            c.fine(b, "run", "854");
        } catch (InterruptedException unused) {
            this.d = false;
        }
    }
}
