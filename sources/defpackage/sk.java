package defpackage;

import java.io.EOFException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
/* compiled from: ClientState.java */
/* renamed from: sk  reason: default package */
/* loaded from: classes.dex */
public class sk {
    private static final String a = "sk";
    private static final rm b = sm.a("org.eclipse.paho.client.mqttv3.internal.nls.logcat", sk.class.getName());
    private Hashtable A;
    private Hashtable B;
    private Hashtable C;
    private nk D;
    private Hashtable d;
    private volatile Vector e;
    private volatile Vector f;
    private wk g;
    private rk h;
    private tk i;
    private long j;
    private boolean k;
    private gk l;
    private int n;
    private int o;
    private nm v;
    private Hashtable z;
    private int c = 0;
    private int m = 0;
    private Object p = new Object();
    private Object q = new Object();
    private boolean r = false;
    private long s = 0;
    private long t = 0;
    private long u = 0;
    private Object w = new Object();
    private int x = 0;
    private boolean y = false;

    /* JADX INFO: Access modifiers changed from: protected */
    public sk(gk gkVar, wk wkVar, tk tkVar, rk rkVar, nk nkVar) throws jk {
        this.h = null;
        this.i = null;
        this.n = 0;
        this.o = 0;
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = null;
        this.D = null;
        rm rmVar = b;
        rmVar.setResourceName(rkVar.t().b());
        rmVar.finer(a, "<Init>", "");
        this.d = new Hashtable();
        this.f = new Vector();
        this.z = new Hashtable();
        this.A = new Hashtable();
        this.B = new Hashtable();
        this.C = new Hashtable();
        this.v = new bm();
        this.o = 0;
        this.n = 0;
        this.l = gkVar;
        this.i = tkVar;
        this.g = wkVar;
        this.h = rkVar;
        this.D = nkVar;
        I();
    }

    private Vector D(Vector vector) {
        Vector vector2 = new Vector();
        if (vector.size() == 0) {
            return vector2;
        }
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i < vector.size()) {
            int p = ((nm) vector.elementAt(i)).p();
            int i5 = p - i2;
            if (i5 > i3) {
                i4 = i;
                i3 = i5;
            }
            i++;
            i2 = p;
        }
        int i6 = (65535 - i2) + ((nm) vector.elementAt(0)).p() > i3 ? 0 : i4;
        for (int i7 = i6; i7 < vector.size(); i7++) {
            vector2.addElement(vector.elementAt(i7));
        }
        for (int i8 = 0; i8 < i6; i8++) {
            vector2.addElement(vector.elementAt(i8));
        }
        return vector2;
    }

    private synchronized void E(int i) {
        this.d.remove(new Integer(i));
    }

    private void G() {
        this.e = new Vector(this.m);
        this.f = new Vector();
        Enumeration keys = this.z.keys();
        while (keys.hasMoreElements()) {
            Object nextElement = keys.nextElement();
            nm nmVar = (nm) this.z.get(nextElement);
            if (nmVar instanceof hm) {
                b.fine(a, "restoreInflightMessages", "610", new Object[]{nextElement});
                nmVar.w(true);
                s(this.e, (hm) nmVar);
            } else if (nmVar instanceof gm) {
                b.fine(a, "restoreInflightMessages", "611", new Object[]{nextElement});
                s(this.f, (gm) nmVar);
            }
        }
        Enumeration keys2 = this.A.keys();
        while (keys2.hasMoreElements()) {
            Object nextElement2 = keys2.nextElement();
            hm hmVar = (hm) this.A.get(nextElement2);
            hmVar.w(true);
            b.fine(a, "restoreInflightMessages", "612", new Object[]{nextElement2});
            s(this.e, hmVar);
        }
        Enumeration keys3 = this.B.keys();
        while (keys3.hasMoreElements()) {
            Object nextElement3 = keys3.nextElement();
            b.fine(a, "restoreInflightMessages", "512", new Object[]{nextElement3});
            s(this.e, (hm) this.B.get(nextElement3));
        }
        this.f = D(this.f);
        this.e = D(this.e);
    }

    private nm H(String str, lk lkVar) throws jk {
        nm nmVar;
        try {
            nmVar = nm.h(lkVar);
        } catch (jk e) {
            b.fine(a, "restoreMessage", "602", new Object[]{str}, e);
            if (!(e.getCause() instanceof EOFException)) {
                throw e;
            }
            if (str != null) {
                this.l.remove(str);
            }
            nmVar = null;
        }
        b.fine(a, "restoreMessage", "601", new Object[]{str, nmVar});
        return nmVar;
    }

    private void f() {
        synchronized (this.p) {
            int i = this.n - 1;
            this.n = i;
            b.fine(a, "decrementInFlight", "646", new Object[]{new Integer(i)});
            if (!b()) {
                this.p.notifyAll();
            }
        }
    }

    private synchronized int n() throws jk {
        int i;
        int i2 = this.c;
        int i3 = 0;
        do {
            int i4 = this.c + 1;
            this.c = i4;
            if (i4 > 65535) {
                this.c = 1;
            }
            i = this.c;
            if (i == i2 && (i3 = i3 + 1) == 2) {
                throw zk.a(32001);
            }
        } while (this.d.containsKey(new Integer(i)));
        Integer num = new Integer(this.c);
        this.d.put(num, num);
        return this.c;
    }

    private String o(nm nmVar) {
        return "r-" + nmVar.p();
    }

    private String p(nm nmVar) {
        return "sb-" + nmVar.p();
    }

    private String q(nm nmVar) {
        return "sc-" + nmVar.p();
    }

    private String r(nm nmVar) {
        return "s-" + nmVar.p();
    }

    private void s(Vector vector, nm nmVar) {
        int p = nmVar.p();
        for (int i = 0; i < vector.size(); i++) {
            if (((nm) vector.elementAt(i)).p() > p) {
                vector.insertElementAt(nmVar, i);
                return;
            }
        }
        vector.addElement(nmVar);
    }

    public void A(int i) {
        if (i > 0) {
            this.s = System.currentTimeMillis();
        }
        b.fine(a, "notifySentBytes", "643", new Object[]{new Integer(i)});
    }

    public void B(nm nmVar) {
        String p = p(nmVar);
        try {
            nmVar.x(n());
            String p2 = p(nmVar);
            try {
                this.l.put(p2, (hm) nmVar);
            } catch (mk unused) {
                b.fine(a, "persistBufferedMessage", "515");
                this.l.open(this.h.t().b(), this.h.t().a());
                this.l.put(p2, (hm) nmVar);
            }
            b.fine(a, "persistBufferedMessage", "513", new Object[]{p2});
        } catch (jk unused2) {
            b.warning(a, "persistBufferedMessage", "513", new Object[]{p});
        }
    }

    public void C(long j) {
        if (j > 0) {
            rm rmVar = b;
            String str = a;
            rmVar.fine(str, "quiesce", "637", new Object[]{new Long(j)});
            synchronized (this.p) {
                this.r = true;
            }
            this.i.j();
            u();
            synchronized (this.q) {
                try {
                    int b2 = this.g.b();
                    if (b2 > 0 || this.f.size() > 0 || !this.i.h()) {
                        rmVar.fine(str, "quiesce", "639", new Object[]{new Integer(this.n), new Integer(this.f.size()), new Integer(this.o), new Integer(b2)});
                        this.q.wait(j);
                    }
                } catch (InterruptedException unused) {
                }
            }
            synchronized (this.p) {
                this.e.clear();
                this.f.clear();
                this.r = false;
                this.n = 0;
            }
            b.fine(a, "quiesce", "640");
        }
    }

    public Vector F(jk jkVar) {
        b.fine(a, "resolveOldTokens", "632", new Object[]{jkVar});
        if (jkVar == null) {
            jkVar = new jk(32102);
        }
        Vector d = this.g.d();
        Enumeration elements = d.elements();
        while (elements.hasMoreElements()) {
            pk pkVar = (pk) elements.nextElement();
            synchronized (pkVar) {
                if (!pkVar.h() && !pkVar.a.m() && pkVar.g() == null) {
                    pkVar.a.t(jkVar);
                }
            }
            if (!(pkVar instanceof ik)) {
                this.g.i(pkVar.a.e());
            }
        }
        return d;
    }

    protected void I() throws jk {
        Enumeration keys = this.l.keys();
        int i = this.c;
        Vector vector = new Vector();
        b.fine(a, "restoreState", "600");
        while (keys.hasMoreElements()) {
            String str = (String) keys.nextElement();
            nm H = H(str, this.l.get(str));
            if (H != null) {
                if (str.startsWith("r-")) {
                    b.fine(a, "restoreState", "604", new Object[]{str, H});
                    this.C.put(new Integer(H.p()), H);
                } else if (str.startsWith("s-")) {
                    hm hmVar = (hm) H;
                    i = Math.max(hmVar.p(), i);
                    if (this.l.containsKey(q(hmVar))) {
                        gm gmVar = (gm) H(str, this.l.get(q(hmVar)));
                        if (gmVar != null) {
                            b.fine(a, "restoreState", "605", new Object[]{str, H});
                            this.z.put(new Integer(gmVar.p()), gmVar);
                        } else {
                            b.fine(a, "restoreState", "606", new Object[]{str, H});
                        }
                    } else {
                        hmVar.w(true);
                        if (hmVar.z().c() == 2) {
                            b.fine(a, "restoreState", "607", new Object[]{str, H});
                            this.z.put(new Integer(hmVar.p()), hmVar);
                        } else {
                            b.fine(a, "restoreState", "608", new Object[]{str, H});
                            this.A.put(new Integer(hmVar.p()), hmVar);
                        }
                    }
                    this.g.k(hmVar).a.s(this.h.t());
                    this.d.put(new Integer(hmVar.p()), new Integer(hmVar.p()));
                } else if (str.startsWith("sb-")) {
                    hm hmVar2 = (hm) H;
                    i = Math.max(hmVar2.p(), i);
                    if (hmVar2.z().c() == 2) {
                        b.fine(a, "restoreState", "607", new Object[]{str, H});
                        this.z.put(new Integer(hmVar2.p()), hmVar2);
                    } else if (hmVar2.z().c() == 1) {
                        b.fine(a, "restoreState", "608", new Object[]{str, H});
                        this.A.put(new Integer(hmVar2.p()), hmVar2);
                    } else {
                        b.fine(a, "restoreState", "511", new Object[]{str, H});
                        this.B.put(new Integer(hmVar2.p()), hmVar2);
                        this.l.remove(str);
                    }
                    this.g.k(hmVar2).a.s(this.h.t());
                    this.d.put(new Integer(hmVar2.p()), new Integer(hmVar2.p()));
                } else if (str.startsWith("sc-") && !this.l.containsKey(r((gm) H))) {
                    vector.addElement(str);
                }
            }
        }
        Enumeration elements = vector.elements();
        while (elements.hasMoreElements()) {
            String str2 = (String) elements.nextElement();
            b.fine(a, "restoreState", "609", new Object[]{str2});
            this.l.remove(str2);
        }
        this.c = i;
    }

    public void J(nm nmVar, pk pkVar) throws jk {
        if (nmVar.u() && nmVar.p() == 0) {
            if ((nmVar instanceof hm) && ((hm) nmVar).z().c() != 0) {
                nmVar.x(n());
            } else if ((nmVar instanceof dm) || (nmVar instanceof fm) || (nmVar instanceof gm) || (nmVar instanceof em) || (nmVar instanceof km) || (nmVar instanceof jm) || (nmVar instanceof mm) || (nmVar instanceof lm)) {
                nmVar.x(n());
            }
        }
        if (pkVar != null) {
            try {
                pkVar.a.w(nmVar.p());
            } catch (Exception unused) {
            }
        }
        if (nmVar instanceof hm) {
            synchronized (this.p) {
                int i = this.n;
                if (i < this.m) {
                    kk z = ((hm) nmVar).z();
                    b.fine(a, "send", "628", new Object[]{new Integer(nmVar.p()), new Integer(z.c()), nmVar});
                    int c = z.c();
                    if (c == 1) {
                        this.A.put(new Integer(nmVar.p()), nmVar);
                        this.l.put(r(nmVar), (hm) nmVar);
                    } else if (c == 2) {
                        this.z.put(new Integer(nmVar.p()), nmVar);
                        this.l.put(r(nmVar), (hm) nmVar);
                    }
                    this.g.m(pkVar, nmVar);
                    this.e.addElement(nmVar);
                    this.p.notifyAll();
                } else {
                    b.fine(a, "send", "613", new Object[]{new Integer(i)});
                    throw new jk(32202);
                }
            }
            return;
        }
        b.fine(a, "send", "615", new Object[]{new Integer(nmVar.p()), nmVar});
        if (nmVar instanceof wl) {
            synchronized (this.p) {
                this.g.m(pkVar, nmVar);
                this.f.insertElementAt(nmVar, 0);
                this.p.notifyAll();
            }
            return;
        }
        if (nmVar instanceof bm) {
            this.v = nmVar;
        } else if (nmVar instanceof gm) {
            this.z.put(new Integer(nmVar.p()), nmVar);
            this.l.put(q(nmVar), (gm) nmVar);
        } else if (nmVar instanceof em) {
            this.l.remove(o(nmVar));
        }
        synchronized (this.p) {
            if (!(nmVar instanceof ul)) {
                this.g.m(pkVar, nmVar);
            }
            this.f.addElement(nmVar);
            this.p.notifyAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void K(boolean z) {
        this.k = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void L(long j) {
        this.j = j * 1000;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void M(int i) {
        this.m = i;
        this.e = new Vector(i);
    }

    public void N(nm nmVar) {
        try {
            b.fine(a, "unPersistBufferedMessage", "517", new Object[]{nmVar.o()});
            this.l.remove(p(nmVar));
        } catch (mk unused) {
            b.fine(a, "unPersistBufferedMessage", "518", new Object[]{nmVar.o()});
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void O(hm hmVar) throws mk {
        synchronized (this.p) {
            b.fine(a, "undo", "618", new Object[]{new Integer(hmVar.p()), new Integer(hmVar.z().c())});
            if (hmVar.z().c() == 1) {
                this.A.remove(new Integer(hmVar.p()));
            } else {
                this.z.remove(new Integer(hmVar.p()));
            }
            this.e.removeElement(hmVar);
            this.l.remove(r(hmVar));
            this.g.j(hmVar);
            if (hmVar.z().c() > 0) {
                E(hmVar.p());
                hmVar.x(0);
            }
            b();
        }
    }

    public pk a(yj yjVar) throws jk {
        long max;
        pk pkVar;
        rm rmVar = b;
        String str = a;
        rmVar.fine(str, "checkForActivity", "616", new Object[0]);
        synchronized (this.q) {
            if (this.r) {
                return null;
            }
            l();
            if (!this.y || this.j <= 0) {
                return null;
            }
            long currentTimeMillis = System.currentTimeMillis();
            synchronized (this.w) {
                int i = this.x;
                if (i > 0) {
                    long j = this.j;
                    if (currentTimeMillis - this.t >= 100 + j) {
                        rmVar.severe(str, "checkForActivity", "619", new Object[]{new Long(j), new Long(this.s), new Long(this.t), new Long(currentTimeMillis), new Long(this.u)});
                        throw zk.a(32000);
                    }
                }
                if (i == 0) {
                    long j2 = this.j;
                    if (currentTimeMillis - this.s >= 2 * j2) {
                        rmVar.severe(str, "checkForActivity", "642", new Object[]{new Long(j2), new Long(this.s), new Long(this.t), new Long(currentTimeMillis), new Long(this.u)});
                        throw zk.a(32002);
                    }
                }
                if ((i == 0 && currentTimeMillis - this.t >= this.j - 100) || currentTimeMillis - this.s >= this.j - 100) {
                    rmVar.fine(str, "checkForActivity", "620", new Object[]{new Long(this.j), new Long(this.s), new Long(this.t)});
                    pk pkVar2 = new pk(this.h.t().b());
                    if (yjVar != null) {
                        pkVar2.i(yjVar);
                    }
                    this.g.m(pkVar2, this.v);
                    this.f.insertElementAt(this.v, 0);
                    max = l();
                    u();
                    pkVar = pkVar2;
                } else {
                    rmVar.fine(str, "checkForActivity", "634", null);
                    max = Math.max(1L, l() - (currentTimeMillis - this.s));
                    pkVar = null;
                }
            }
            rmVar.fine(str, "checkForActivity", "624", new Object[]{new Long(max)});
            this.D.a(max);
            return pkVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean b() {
        int b2 = this.g.b();
        if (this.r && b2 == 0 && this.f.size() == 0 && this.i.h()) {
            b.fine(a, "checkQuiesceLock", "626", new Object[]{new Boolean(this.r), new Integer(this.n), new Integer(this.f.size()), new Integer(this.o), Boolean.valueOf(this.i.h()), new Integer(b2)});
            synchronized (this.q) {
                this.q.notifyAll();
            }
            return true;
        }
        return false;
    }

    protected void c() throws jk {
        b.fine(a, "clearState", ">");
        this.l.clear();
        this.d.clear();
        this.e.clear();
        this.f.clear();
        this.z.clear();
        this.A.clear();
        this.B.clear();
        this.C.clear();
        this.g.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        this.d.clear();
        if (this.e != null) {
            this.e.clear();
        }
        this.f.clear();
        this.z.clear();
        this.A.clear();
        this.B.clear();
        this.C.clear();
        this.g.a();
        this.d = null;
        this.e = null;
        this.f = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = null;
        this.g = null;
        this.i = null;
        this.h = null;
        this.l = null;
        this.v = null;
    }

    public void e() {
        b.fine(a, "connected", "631");
        this.y = true;
        this.D.start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(hm hmVar) throws mk {
        b.fine(a, "deliveryComplete", "641", new Object[]{new Integer(hmVar.p())});
        this.l.remove(o(hmVar));
        this.C.remove(new Integer(hmVar.p()));
    }

    public void h(jk jkVar) {
        b.fine(a, "disconnected", "633", new Object[]{jkVar});
        this.y = false;
        try {
            if (this.k) {
                c();
            }
            this.e.clear();
            this.f.clear();
            synchronized (this.w) {
                this.x = 0;
            }
        } catch (jk unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public nm i() throws jk {
        synchronized (this.p) {
            nm nmVar = null;
            while (nmVar == null) {
                if ((this.e.isEmpty() && this.f.isEmpty()) || (this.f.isEmpty() && this.n >= this.m)) {
                    try {
                        rm rmVar = b;
                        String str = a;
                        rmVar.fine(str, "get", "644");
                        this.p.wait();
                        rmVar.fine(str, "get", "647");
                    } catch (InterruptedException unused) {
                    }
                }
                if (!this.y && (this.f.isEmpty() || !(((nm) this.f.elementAt(0)) instanceof wl))) {
                    b.fine(a, "get", "621");
                    return null;
                } else if (!this.f.isEmpty()) {
                    nmVar = (nm) this.f.remove(0);
                    if (nmVar instanceof gm) {
                        int i = this.o + 1;
                        this.o = i;
                        b.fine(a, "get", "617", new Object[]{new Integer(i)});
                    }
                    b();
                } else if (!this.e.isEmpty()) {
                    if (this.n < this.m) {
                        nmVar = (nm) this.e.elementAt(0);
                        this.e.removeElementAt(0);
                        int i2 = this.n + 1;
                        this.n = i2;
                        b.fine(a, "get", "623", new Object[]{new Integer(i2)});
                    } else {
                        b.fine(a, "get", "622");
                    }
                }
            }
            return nmVar;
        }
    }

    public int j() {
        return this.n;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean k() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long l() {
        return this.j;
    }

    public int m() {
        return this.m;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void t(pk pkVar) throws jk {
        nm k = pkVar.a.k();
        if (k == null || !(k instanceof ul)) {
            return;
        }
        rm rmVar = b;
        String str = a;
        rmVar.fine(str, "notifyComplete", "629", new Object[]{new Integer(k.p()), pkVar, k});
        ul ulVar = (ul) k;
        if (ulVar instanceof dm) {
            this.l.remove(r(k));
            this.l.remove(p(k));
            this.A.remove(new Integer(ulVar.p()));
            f();
            E(k.p());
            this.g.j(k);
            rmVar.fine(str, "notifyComplete", "650", new Object[]{new Integer(ulVar.p())});
        } else if (ulVar instanceof em) {
            this.l.remove(r(k));
            this.l.remove(q(k));
            this.l.remove(p(k));
            this.z.remove(new Integer(ulVar.p()));
            this.o--;
            f();
            E(k.p());
            this.g.j(k);
            rmVar.fine(str, "notifyComplete", "645", new Object[]{new Integer(ulVar.p()), new Integer(this.o)});
        }
        b();
    }

    public void u() {
        synchronized (this.p) {
            b.fine(a, "notifyQueueLock", "638");
            this.p.notifyAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void v(ul ulVar) throws jk {
        this.t = System.currentTimeMillis();
        rm rmVar = b;
        String str = a;
        rmVar.fine(str, "notifyReceivedAck", "627", new Object[]{new Integer(ulVar.p()), ulVar});
        pk f = this.g.f(ulVar);
        if (f == null) {
            rmVar.fine(str, "notifyReceivedAck", "662", new Object[]{new Integer(ulVar.p())});
        } else if (ulVar instanceof fm) {
            J(new gm((fm) ulVar), f);
        } else if (!(ulVar instanceof dm) && !(ulVar instanceof em)) {
            if (ulVar instanceof cm) {
                synchronized (this.w) {
                    this.x = Math.max(0, this.x - 1);
                    y(ulVar, f, null);
                    if (this.x == 0) {
                        this.g.j(ulVar);
                    }
                }
                rmVar.fine(str, "notifyReceivedAck", "636", new Object[]{new Integer(this.x)});
            } else if (ulVar instanceof vl) {
                vl vlVar = (vl) ulVar;
                int y = vlVar.y();
                if (y == 0) {
                    synchronized (this.p) {
                        if (this.k) {
                            c();
                            this.g.m(f, ulVar);
                        }
                        this.o = 0;
                        this.n = 0;
                        G();
                        e();
                    }
                    this.h.p(vlVar, null);
                    y(ulVar, f, null);
                    this.g.j(ulVar);
                    synchronized (this.p) {
                        this.p.notifyAll();
                    }
                } else {
                    throw zk.a(y);
                }
            } else {
                y(ulVar, f, null);
                E(ulVar.p());
                this.g.j(ulVar);
            }
        } else {
            y(ulVar, f, null);
        }
        b();
    }

    public void w(int i) {
        if (i > 0) {
            this.t = System.currentTimeMillis();
        }
        b.fine(a, "notifyReceivedBytes", "630", new Object[]{new Integer(i)});
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void x(nm nmVar) throws jk {
        this.t = System.currentTimeMillis();
        b.fine(a, "notifyReceivedMsg", "651", new Object[]{new Integer(nmVar.p()), nmVar});
        if (this.r) {
            return;
        }
        if (nmVar instanceof hm) {
            hm hmVar = (hm) nmVar;
            int c = hmVar.z().c();
            if (c == 0 || c == 1) {
                tk tkVar = this.i;
                if (tkVar != null) {
                    tkVar.i(hmVar);
                }
            } else if (c != 2) {
            } else {
                this.l.put(o(nmVar), hmVar);
                this.C.put(new Integer(hmVar.p()), hmVar);
                J(new fm(hmVar), null);
            }
        } else if (nmVar instanceof gm) {
            hm hmVar2 = (hm) this.C.get(new Integer(nmVar.p()));
            if (hmVar2 != null) {
                tk tkVar2 = this.i;
                if (tkVar2 != null) {
                    tkVar2.i(hmVar2);
                    return;
                }
                return;
            }
            J(new em(nmVar.p()), null);
        }
    }

    protected void y(nm nmVar, pk pkVar, jk jkVar) {
        pkVar.a.o(nmVar, jkVar);
        pkVar.a.p();
        if (nmVar != null && (nmVar instanceof ul) && !(nmVar instanceof fm)) {
            b.fine(a, "notifyResult", "648", new Object[]{pkVar.a.e(), nmVar, jkVar});
            this.i.a(pkVar);
        }
        if (nmVar == null) {
            b.fine(a, "notifyResult", "649", new Object[]{pkVar.a.e(), jkVar});
            this.i.a(pkVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void z(nm nmVar) {
        int i;
        this.s = System.currentTimeMillis();
        rm rmVar = b;
        String str = a;
        rmVar.fine(str, "notifySent", "625", new Object[]{nmVar.o()});
        pk f = this.g.f(nmVar);
        f.a.q();
        if (nmVar instanceof bm) {
            synchronized (this.w) {
                long currentTimeMillis = System.currentTimeMillis();
                synchronized (this.w) {
                    this.u = currentTimeMillis;
                    i = this.x + 1;
                    this.x = i;
                }
                rmVar.fine(str, "notifySent", "635", new Object[]{new Integer(i)});
            }
        } else if ((nmVar instanceof hm) && ((hm) nmVar).z().c() == 0) {
            f.a.o(null, null);
            this.i.a(f);
            f();
            E(nmVar.p());
            this.g.j(nmVar);
            b();
        }
    }
}
