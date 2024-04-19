package defpackage;
/* compiled from: Token.java */
/* renamed from: il  reason: default package */
/* loaded from: classes.dex */
public class il {
    private static final String a = "il";
    private static final rm b = sm.a("org.eclipse.paho.client.mqttv3.internal.nls.logcat", il.class.getName());
    private String l;
    private volatile boolean c = false;
    private boolean d = false;
    private boolean e = false;
    private Object f = new Object();
    private Object g = new Object();
    protected kk h = null;
    private nm i = null;
    private jk j = null;
    private String[] k = null;
    private zj m = null;
    private yj n = null;
    private Object o = null;
    private int p = 0;
    private boolean q = false;

    public il(String str) {
        b.setResourceName(str);
    }

    public void A(long j) throws jk {
        rm rmVar = b;
        String str = a;
        rmVar.fine(str, "waitForCompletion", "407", new Object[]{e(), new Long(j), this});
        if (B(j) == null && !this.c) {
            rmVar.fine(str, "waitForCompletion", "406", new Object[]{e(), this});
            jk jkVar = new jk(32000);
            this.j = jkVar;
            throw jkVar;
        }
        a();
    }

    protected nm B(long j) throws jk {
        synchronized (this.f) {
            rm rmVar = b;
            String str = a;
            Object[] objArr = new Object[7];
            objArr[0] = e();
            objArr[1] = new Long(j);
            objArr[2] = new Boolean(this.e);
            objArr[3] = new Boolean(this.c);
            jk jkVar = this.j;
            objArr[4] = jkVar == null ? "false" : "true";
            objArr[5] = this.i;
            objArr[6] = this;
            rmVar.fine(str, "waitForResponse", "400", objArr, jkVar);
            while (!this.c) {
                if (this.j == null) {
                    try {
                        b.fine(a, "waitForResponse", "408", new Object[]{e(), new Long(j)});
                        if (j <= 0) {
                            this.f.wait();
                        } else {
                            this.f.wait(j);
                        }
                    } catch (InterruptedException e) {
                        this.j = new jk(e);
                    }
                }
                if (!this.c) {
                    jk jkVar2 = this.j;
                    if (jkVar2 != null) {
                        b.fine(a, "waitForResponse", "401", null, jkVar2);
                        throw this.j;
                    } else if (j > 0) {
                        break;
                    }
                }
            }
        }
        b.fine(a, "waitForResponse", "402", new Object[]{e(), this.i});
        return this.i;
    }

    public void C() throws jk {
        boolean z;
        synchronized (this.g) {
            synchronized (this.f) {
                jk jkVar = this.j;
                if (jkVar != null) {
                    throw jkVar;
                }
            }
            while (true) {
                z = this.e;
                if (z) {
                    break;
                }
                try {
                    b.fine(a, "waitUntilSent", "409", new Object[]{e()});
                    this.g.wait();
                } catch (InterruptedException unused) {
                }
            }
            if (!z) {
                jk jkVar2 = this.j;
                if (jkVar2 == null) {
                    throw zk.a(6);
                }
                throw jkVar2;
            }
        }
    }

    public boolean a() throws jk {
        if (d() == null) {
            return true;
        }
        throw d();
    }

    public yj b() {
        return this.n;
    }

    public zj c() {
        return this.m;
    }

    public jk d() {
        return this.j;
    }

    public String e() {
        return this.l;
    }

    public kk f() {
        return this.h;
    }

    public int g() {
        return this.p;
    }

    public nm h() {
        return this.i;
    }

    public String[] i() {
        return this.k;
    }

    public Object j() {
        return this.o;
    }

    public nm k() {
        return this.i;
    }

    public boolean l() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean m() {
        return this.d;
    }

    public boolean n() {
        return this.q;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o(nm nmVar, jk jkVar) {
        b.fine(a, "markComplete", "404", new Object[]{e(), nmVar, jkVar});
        synchronized (this.f) {
            if (nmVar instanceof ul) {
                this.h = null;
            }
            this.d = true;
            this.i = nmVar;
            this.j = jkVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p() {
        b.fine(a, "notifyComplete", "404", new Object[]{e(), this.i, this.j});
        synchronized (this.f) {
            if (this.j == null && this.d) {
                this.c = true;
                this.d = false;
            } else {
                this.d = false;
            }
            this.f.notifyAll();
        }
        synchronized (this.g) {
            this.e = true;
            this.g.notifyAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q() {
        b.fine(a, "notifySent", "403", new Object[]{e()});
        synchronized (this.f) {
            this.i = null;
            this.c = false;
        }
        synchronized (this.g) {
            this.e = true;
            this.g.notifyAll();
        }
    }

    public void r(yj yjVar) {
        this.n = yjVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s(zj zjVar) {
        this.m = zjVar;
    }

    public void t(jk jkVar) {
        synchronized (this.f) {
            this.j = jkVar;
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(e());
        stringBuffer.append(" ,topics=");
        if (i() != null) {
            for (int i = 0; i < i().length; i++) {
                stringBuffer.append(i()[i]);
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append(" ,usercontext=");
        stringBuffer.append(j());
        stringBuffer.append(" ,isComplete=");
        stringBuffer.append(l());
        stringBuffer.append(" ,isNotified=");
        stringBuffer.append(n());
        stringBuffer.append(" ,exception=");
        stringBuffer.append(d());
        stringBuffer.append(" ,actioncallback=");
        stringBuffer.append(b());
        return stringBuffer.toString();
    }

    public void u(String str) {
        this.l = str;
    }

    public void v(kk kkVar) {
        this.h = kkVar;
    }

    public void w(int i) {
        this.p = i;
    }

    public void x(boolean z) {
        this.q = z;
    }

    public void y(String[] strArr) {
        this.k = strArr;
    }

    public void z(Object obj) {
        this.o = obj;
    }
}
