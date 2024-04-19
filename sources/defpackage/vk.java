package defpackage;

import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
/* compiled from: CommsSender.java */
/* renamed from: vk  reason: default package */
/* loaded from: classes.dex */
public class vk implements Runnable {
    private static final String b;
    private static final rm c;
    private sk f;
    private zl g;
    private rk h;
    private wk i;
    private String k;
    private Future m;
    private boolean d = false;
    private Object e = new Object();
    private Thread j = null;
    private final Semaphore l = new Semaphore(1);

    static {
        String name = vk.class.getName();
        b = name;
        c = sm.a("org.eclipse.paho.client.mqttv3.internal.nls.logcat", name);
    }

    public vk(rk rkVar, sk skVar, wk wkVar, OutputStream outputStream) {
        this.f = null;
        this.h = null;
        this.i = null;
        this.g = new zl(skVar, outputStream);
        this.h = rkVar;
        this.f = skVar;
        this.i = wkVar;
        c.setResourceName(rkVar.t().b());
    }

    private void a(nm nmVar, Exception exc) {
        jk jkVar;
        c.fine(b, "handleRunException", "804", null, exc);
        if (!(exc instanceof jk)) {
            jkVar = new jk(32109, exc);
        } else {
            jkVar = (jk) exc;
        }
        this.d = false;
        this.h.O(null, jkVar);
    }

    public void b(String str, ExecutorService executorService) {
        this.k = str;
        synchronized (this.e) {
            if (!this.d) {
                this.d = true;
                this.m = executorService.submit(this);
            }
        }
    }

    public void c() {
        Semaphore semaphore;
        synchronized (this.e) {
            Future future = this.m;
            if (future != null) {
                future.cancel(true);
            }
            c.fine(b, "stop", "800");
            if (this.d) {
                this.d = false;
                if (!Thread.currentThread().equals(this.j)) {
                    while (this.d) {
                        try {
                            this.f.u();
                            this.l.tryAcquire(100L, TimeUnit.MILLISECONDS);
                        } catch (InterruptedException unused) {
                            semaphore = this.l;
                        } catch (Throwable th) {
                            this.l.release();
                            throw th;
                        }
                    }
                    semaphore = this.l;
                    semaphore.release();
                }
            }
            this.j = null;
            c.fine(b, "stop", "801");
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Thread currentThread = Thread.currentThread();
        this.j = currentThread;
        currentThread.setName(this.k);
        try {
            this.l.acquire();
            nm nmVar = null;
            while (this.d && this.g != null) {
                try {
                    try {
                        nmVar = this.f.i();
                        if (nmVar != null) {
                            c.fine(b, "run", "802", new Object[]{nmVar.o(), nmVar});
                            if (nmVar instanceof ul) {
                                this.g.a(nmVar);
                                this.g.flush();
                            } else {
                                pk f = this.i.f(nmVar);
                                if (f != null) {
                                    synchronized (f) {
                                        this.g.a(nmVar);
                                        try {
                                            this.g.flush();
                                        } catch (IOException e) {
                                            if (!(nmVar instanceof xl)) {
                                                throw e;
                                                break;
                                            }
                                        }
                                        this.f.z(nmVar);
                                    }
                                } else {
                                    continue;
                                }
                            }
                        } else {
                            c.fine(b, "run", "803");
                            this.d = false;
                        }
                    } catch (jk e2) {
                        a(nmVar, e2);
                    } catch (Exception e3) {
                        a(nmVar, e3);
                    }
                } catch (Throwable th) {
                    this.d = false;
                    this.l.release();
                    throw th;
                }
            }
            this.d = false;
            this.l.release();
            c.fine(b, "run", "805");
        } catch (InterruptedException unused) {
            this.d = false;
        }
    }
}
