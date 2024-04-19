package defpackage;

import java.util.Enumeration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
/* compiled from: ClientComms.java */
/* renamed from: rk  reason: default package */
/* loaded from: classes.dex */
public class rk {
    private static final String a = "rk";
    private static final rm b = sm.a("org.eclipse.paho.client.mqttv3.internal.nls.logcat", rk.class.getName());
    private zj c;
    private int d;
    private el[] e;
    private uk f;
    private vk g;
    private tk h;
    private sk i;
    private hk j;
    private gk k;
    private nk l;
    private wk m;
    private byte o;
    private yk s;
    private ExecutorService t;
    private boolean n = false;
    private Object p = new Object();
    private boolean q = false;
    private boolean r = false;

    /* compiled from: ClientComms.java */
    /* renamed from: rk$a */
    /* loaded from: classes.dex */
    private class a implements Runnable {
        rk b;
        pk c;
        wl d;
        private String e;

        a(rk rkVar, pk pkVar, wl wlVar, ExecutorService executorService) {
            this.b = null;
            this.b = rkVar;
            this.c = pkVar;
            this.d = wlVar;
            this.e = "MQTT Con: " + rk.this.t().b();
        }

        void a() {
            rk.this.t.execute(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            Thread.currentThread().setName(this.e);
            rk.b.fine(rk.a, "connectBG:run", "220");
            jk e = null;
            try {
                for (ik ikVar : rk.this.m.c()) {
                    ikVar.a.t(null);
                }
                rk.this.m.m(this.c, this.d);
                el elVar = rk.this.e[rk.this.d];
                elVar.start();
                rk.this.f = new uk(this.b, rk.this.i, rk.this.m, elVar.c());
                rk.this.f.a("MQTT Rec: " + rk.this.t().b(), rk.this.t);
                rk.this.g = new vk(this.b, rk.this.i, rk.this.m, elVar.b());
                rk.this.g.b("MQTT Snd: " + rk.this.t().b(), rk.this.t);
                rk.this.h.p("MQTT Call: " + rk.this.t().b(), rk.this.t);
                rk.this.z(this.d, this.c);
            } catch (jk e2) {
                e = e2;
                rk.b.fine(rk.a, "connectBG:run", "212", null, e);
            } catch (Exception e3) {
                rk.b.fine(rk.a, "connectBG:run", "209", null, e3);
                e = zk.b(e3);
            }
            if (e != null) {
                rk.this.O(this.c, e);
            }
        }
    }

    /* compiled from: ClientComms.java */
    /* renamed from: rk$b */
    /* loaded from: classes.dex */
    private class b implements Runnable {
        xl b;
        long c;
        pk d;
        private String e;

        b(xl xlVar, long j, pk pkVar, ExecutorService executorService) {
            this.b = xlVar;
            this.c = j;
            this.d = pkVar;
        }

        void a() {
            this.e = "MQTT Disc: " + rk.this.t().b();
            rk.this.t.execute(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            Thread.currentThread().setName(this.e);
            rk.b.fine(rk.a, "disconnectBG:run", "221");
            rk.this.i.C(this.c);
            try {
                rk.this.z(this.b, this.d);
                this.d.a.C();
            } catch (jk unused) {
            } catch (Throwable th) {
                this.d.a.o(null, null);
                rk.this.O(this.d, null);
                throw th;
            }
            this.d.a.o(null, null);
            rk.this.O(this.d, null);
        }
    }

    /* compiled from: ClientComms.java */
    /* renamed from: rk$c */
    /* loaded from: classes.dex */
    class c implements bl {
        final String a;

        c(String str) {
            this.a = str;
        }

        @Override // defpackage.bl
        public void a(wj wjVar) throws jk {
            if (rk.this.B()) {
                while (rk.this.i.j() >= rk.this.i.m() - 1) {
                    Thread.yield();
                }
                rk.b.fine(rk.a, this.a, "510", new Object[]{wjVar.a().o()});
                rk.this.z(wjVar.a(), wjVar.b());
                rk.this.i.N(wjVar.a());
                return;
            }
            rk.b.fine(rk.a, this.a, "208");
            throw zk.a(32104);
        }
    }

    public rk(zj zjVar, gk gkVar, nk nkVar, ExecutorService executorService) throws jk {
        this.o = (byte) 3;
        this.o = (byte) 3;
        this.c = zjVar;
        this.k = gkVar;
        this.l = nkVar;
        nkVar.b(this);
        this.t = executorService;
        this.m = new wk(t().b());
        this.h = new tk(this);
        sk skVar = new sk(gkVar, this.m, this.h, this, nkVar);
        this.i = skVar;
        this.h.n(skVar);
        b.setResourceName(t().b());
    }

    private void P() {
        this.t.shutdown();
        try {
            ExecutorService executorService = this.t;
            TimeUnit timeUnit = TimeUnit.SECONDS;
            if (executorService.awaitTermination(1L, timeUnit)) {
                return;
            }
            this.t.shutdownNow();
            if (this.t.awaitTermination(1L, timeUnit)) {
                return;
            }
            b.fine(a, "shutdownExecutorService", "executorService did not terminate");
        } catch (InterruptedException unused) {
            this.t.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

    private pk x(pk pkVar, jk jkVar) {
        b.fine(a, "handleOldTokens", "222");
        pk pkVar2 = null;
        if (pkVar != null) {
            try {
                if (this.m.e(pkVar.a.e()) == null) {
                    this.m.l(pkVar, pkVar.a.e());
                }
            } catch (Exception unused) {
            }
        }
        Enumeration elements = this.i.F(jkVar).elements();
        while (elements.hasMoreElements()) {
            pk pkVar3 = (pk) elements.nextElement();
            if (!pkVar3.a.e().equals("Disc") && !pkVar3.a.e().equals("Con")) {
                this.h.a(pkVar3);
            }
            pkVar2 = pkVar3;
        }
        return pkVar2;
    }

    private void y(Exception exc) {
        jk jkVar;
        b.fine(a, "handleRunException", "804", null, exc);
        if (!(exc instanceof jk)) {
            jkVar = new jk(32109, exc);
        } else {
            jkVar = (jk) exc;
        }
        O(null, jkVar);
    }

    public boolean A() {
        boolean z;
        synchronized (this.p) {
            z = this.o == 4;
        }
        return z;
    }

    public boolean B() {
        boolean z;
        synchronized (this.p) {
            z = this.o == 0;
        }
        return z;
    }

    public boolean C() {
        boolean z;
        synchronized (this.p) {
            z = true;
            if (this.o != 1) {
                z = false;
            }
        }
        return z;
    }

    public boolean D() {
        boolean z;
        synchronized (this.p) {
            z = this.o == 3;
        }
        return z;
    }

    public boolean E() {
        boolean z;
        synchronized (this.p) {
            z = this.o == 2;
        }
        return z;
    }

    public void F() {
        if (this.s != null) {
            b.fine(a, "notifyConnect", "509");
            this.s.f(new c("notifyConnect"));
            this.t.execute(this.s);
        }
    }

    public void G(String str) {
        this.h.k(str);
    }

    public void H(nm nmVar, pk pkVar) throws jk {
        if (!B() && ((B() || !(nmVar instanceof wl)) && (!E() || !(nmVar instanceof xl)))) {
            if (this.s != null) {
                b.fine(a, "sendNoWait", "508", new Object[]{nmVar.o()});
                if (this.s.d()) {
                    this.i.B(nmVar);
                }
                this.s.e(nmVar, pkVar);
                return;
            }
            b.fine(a, "sendNoWait", "208");
            throw zk.a(32104);
        }
        yk ykVar = this.s;
        if (ykVar != null && ykVar.c() != 0) {
            b.fine(a, "sendNoWait", "507", new Object[]{nmVar.o()});
            if (this.s.d()) {
                this.i.B(nmVar);
            }
            this.s.e(nmVar, pkVar);
            return;
        }
        z(nmVar, pkVar);
    }

    public void I(ek ekVar) {
        this.h.m(ekVar);
    }

    public void J(yk ykVar) {
        this.s = ykVar;
    }

    public void K(int i) {
        this.d = i;
    }

    public void L(el[] elVarArr) {
        this.e = elVarArr;
    }

    public void M(fk fkVar) {
        this.h.o(fkVar);
    }

    public void N(boolean z) {
        this.r = z;
    }

    public void O(pk pkVar, jk jkVar) {
        tk tkVar;
        gk gkVar;
        el elVar;
        synchronized (this.p) {
            if (!this.n && !this.q && !A()) {
                this.n = true;
                b.fine(a, "shutdownConnection", "216");
                boolean z = B() || E();
                this.o = (byte) 2;
                if (pkVar != null && !pkVar.h()) {
                    pkVar.a.t(jkVar);
                }
                tk tkVar2 = this.h;
                if (tkVar2 != null) {
                    tkVar2.q();
                }
                uk ukVar = this.f;
                if (ukVar != null) {
                    ukVar.b();
                }
                try {
                    el[] elVarArr = this.e;
                    if (elVarArr != null && (elVar = elVarArr[this.d]) != null) {
                        elVar.stop();
                    }
                } catch (Exception unused) {
                }
                this.m.h(new jk(32102));
                pk x = x(pkVar, jkVar);
                try {
                    this.i.h(jkVar);
                    if (this.i.k()) {
                        this.h.l();
                    }
                } catch (Exception unused2) {
                }
                vk vkVar = this.g;
                if (vkVar != null) {
                    vkVar.c();
                }
                nk nkVar = this.l;
                if (nkVar != null) {
                    nkVar.stop();
                }
                try {
                    if (this.s == null && (gkVar = this.k) != null) {
                        gkVar.close();
                    }
                } catch (Exception unused3) {
                }
                synchronized (this.p) {
                    b.fine(a, "shutdownConnection", "217");
                    this.o = (byte) 3;
                    this.n = false;
                }
                boolean z2 = x != null;
                tk tkVar3 = this.h;
                if (z2 & (tkVar3 != null)) {
                    tkVar3.a(x);
                }
                if (z && (tkVar = this.h) != null) {
                    tkVar.b(jkVar);
                }
                synchronized (this.p) {
                    if (this.q) {
                        try {
                            n(true);
                        } catch (Exception unused4) {
                        }
                    }
                }
            }
        }
    }

    public pk m(yj yjVar) {
        try {
            return this.i.a(yjVar);
        } catch (jk e) {
            y(e);
            return null;
        } catch (Exception e2) {
            y(e2);
            return null;
        }
    }

    public void n(boolean z) throws jk {
        synchronized (this.p) {
            if (!A()) {
                if (!D() || z) {
                    b.fine(a, "close", "224");
                    if (!C()) {
                        if (!B()) {
                            if (E()) {
                                this.q = true;
                                return;
                            }
                        } else {
                            throw zk.a(32100);
                        }
                    } else {
                        throw new jk(32110);
                    }
                }
                this.o = (byte) 4;
                P();
                this.i.d();
                this.i = null;
                this.h = null;
                this.k = null;
                this.g = null;
                this.l = null;
                this.f = null;
                this.e = null;
                this.j = null;
                this.m = null;
            }
        }
    }

    public void o(hk hkVar, pk pkVar) throws jk {
        synchronized (this.p) {
            if (D() && !this.q) {
                b.fine(a, "connect", "214");
                this.o = (byte) 1;
                this.j = hkVar;
                wl wlVar = new wl(this.c.b(), this.j.e(), this.j.o(), this.j.c(), this.j.k(), this.j.f(), this.j.m(), this.j.l());
                this.i.L(this.j.c());
                this.i.K(this.j.o());
                this.i.M(this.j.d());
                this.m.g();
                new a(this, pkVar, wlVar, this.t).a();
            } else {
                b.fine(a, "connect", "207", new Object[]{new Byte(this.o)});
                if (!A() && !this.q) {
                    if (!C()) {
                        if (E()) {
                            throw new jk(32102);
                        }
                        throw zk.a(32100);
                    }
                    throw new jk(32110);
                }
                throw new jk(32111);
            }
        }
    }

    public void p(vl vlVar, jk jkVar) throws jk {
        int y = vlVar.y();
        synchronized (this.p) {
            if (y == 0) {
                b.fine(a, "connectComplete", "215");
                this.o = (byte) 0;
                return;
            }
            b.fine(a, "connectComplete", "204", new Object[]{new Integer(y)});
            throw jkVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q(hm hmVar) throws mk {
        this.i.g(hmVar);
    }

    public void r(xl xlVar, long j, pk pkVar) throws jk {
        synchronized (this.p) {
            if (!A()) {
                if (!D()) {
                    if (!E()) {
                        if (Thread.currentThread() != this.h.e()) {
                            b.fine(a, "disconnect", "218");
                            this.o = (byte) 2;
                            new b(xlVar, j, pkVar, this.t).a();
                        } else {
                            b.fine(a, "disconnect", "210");
                            throw zk.a(32107);
                        }
                    } else {
                        b.fine(a, "disconnect", "219");
                        throw zk.a(32102);
                    }
                } else {
                    b.fine(a, "disconnect", "211");
                    throw zk.a(32101);
                }
            } else {
                b.fine(a, "disconnect", "223");
                throw zk.a(32111);
            }
        }
    }

    public void s(long j, long j2, boolean z) throws jk {
        sk skVar = this.i;
        if (skVar != null) {
            skVar.C(j);
        }
        pk pkVar = new pk(this.c.b());
        if (z) {
            try {
                z(new xl(), pkVar);
                pkVar.c(j2);
            } catch (Exception unused) {
            } catch (Throwable th) {
                pkVar.a.o(null, null);
                O(pkVar, null);
                throw th;
            }
        }
        pkVar.a.o(null, null);
        O(pkVar, null);
    }

    public zj t() {
        return this.c;
    }

    public long u() {
        return this.i.l();
    }

    public int v() {
        return this.d;
    }

    public el[] w() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z(nm nmVar, pk pkVar) throws jk {
        rm rmVar = b;
        String str = a;
        rmVar.fine(str, "internalSend", "200", new Object[]{nmVar.o(), nmVar, pkVar});
        if (pkVar.f() == null) {
            pkVar.a.s(t());
            try {
                this.i.J(nmVar, pkVar);
                return;
            } catch (jk e) {
                if (nmVar instanceof hm) {
                    this.i.O((hm) nmVar);
                }
                throw e;
            }
        }
        rmVar.fine(str, "internalSend", "213", new Object[]{nmVar.o(), nmVar, pkVar});
        throw new jk(32201);
    }
}
