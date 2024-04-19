package defpackage;

import java.lang.reflect.Field;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
/* compiled from: MqttAsyncClient.java */
/* renamed from: dk  reason: default package */
/* loaded from: classes.dex */
public class dk implements zj {
    private static final String a = "dk";
    private static final rm b = sm.a("org.eclipse.paho.client.mqttv3.internal.nls.logcat", dk.class.getName());
    private static int c = 1000;
    private static Object d = new Object();
    private String e;
    private String f;
    protected rk g;
    private Hashtable h;
    private gk i;
    private ek j;
    private hk k;
    private Object l;
    private Timer m;
    private boolean n = false;
    private ScheduledExecutorService o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MqttAsyncClient.java */
    /* renamed from: dk$a */
    /* loaded from: classes.dex */
    public class a implements yj {
        final String a;

        a(String str) {
            this.a = str;
        }

        private void a(int i) {
            dk.b.fine(dk.a, String.valueOf(this.a) + ":rescheduleReconnectCycle", "505", new Object[]{dk.this.e, String.valueOf(dk.c)});
            synchronized (dk.d) {
                if (dk.this.k.n()) {
                    if (dk.this.m != null) {
                        dk.this.m.schedule(new c(dk.this, null), i);
                    } else {
                        dk.c = i;
                        dk.this.D();
                    }
                }
            }
        }

        @Override // defpackage.yj
        public void onFailure(ck ckVar, Throwable th) {
            dk.b.fine(dk.a, this.a, "502", new Object[]{ckVar.f().b()});
            if (dk.c < 128000) {
                dk.c *= 2;
            }
            a(dk.c);
        }

        @Override // defpackage.yj
        public void onSuccess(ck ckVar) {
            dk.b.fine(dk.a, this.a, "501", new Object[]{ckVar.f().b()});
            dk.this.g.N(false);
            dk.this.E();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MqttAsyncClient.java */
    /* renamed from: dk$b */
    /* loaded from: classes.dex */
    public class b implements fk {
        final boolean a;

        b(boolean z) {
            this.a = z;
        }

        @Override // defpackage.fk
        public void connectComplete(boolean z, String str) {
        }

        @Override // defpackage.ek
        public void connectionLost(Throwable th) {
            if (this.a) {
                dk.this.g.N(true);
                dk.this.n = true;
                dk.this.D();
            }
        }

        @Override // defpackage.ek
        public void deliveryComplete(ak akVar) {
        }

        @Override // defpackage.ek
        public void messageArrived(String str, kk kkVar) throws Exception {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MqttAsyncClient.java */
    /* renamed from: dk$c */
    /* loaded from: classes.dex */
    public class c extends TimerTask {
        private c() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            dk.b.fine(dk.a, "ReconnectTask.run", "506");
            dk.this.p();
        }

        /* synthetic */ c(dk dkVar, c cVar) {
            this();
        }
    }

    public dk(String str, String str2, gk gkVar, nk nkVar, ScheduledExecutorService scheduledExecutorService) throws jk {
        b.setResourceName(str2);
        if (str2 != null) {
            int i = 0;
            int i2 = 0;
            while (i < str2.length() - 1) {
                if (c(str2.charAt(i))) {
                    i++;
                }
                i2++;
                i++;
            }
            if (i2 <= 65535) {
                hk.x(str);
                this.f = str;
                this.e = str2;
                this.i = gkVar;
                if (gkVar == null) {
                    this.i = new tm();
                }
                this.o = scheduledExecutorService;
                if (scheduledExecutorService == null) {
                    this.o = Executors.newScheduledThreadPool(10);
                }
                b.fine(a, "MqttAsyncClient", "101", new Object[]{str2, str, gkVar});
                this.i.open(str2, str);
                this.g = new rk(this, this.i, nkVar, this.o);
                this.i.close();
                this.h = new Hashtable();
                return;
            }
            throw new IllegalArgumentException("ClientId longer than 65535 characters");
        }
        throw new IllegalArgumentException("Null clientId");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        b.fine(a, "startReconnectCycle", "503", new Object[]{this.e, new Long(c)});
        Timer timer = new Timer("MQTT Reconnect: " + this.e);
        this.m = timer;
        timer.schedule(new c(this, null), (long) c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        b.fine(a, "stopReconnectCycle", "504", new Object[]{this.e});
        synchronized (d) {
            if (this.k.n()) {
                Timer timer = this.m;
                if (timer != null) {
                    timer.cancel();
                    this.m = null;
                }
                c = 1000;
            }
        }
    }

    protected static boolean c(char c2) {
        return c2 >= 55296 && c2 <= 56319;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        b.fine(a, "attemptReconnect", "500", new Object[]{this.e});
        try {
            r(this.k, this.l, new a("attemptReconnect"));
        } catch (ok e) {
            b.fine(a, "attemptReconnect", "804", null, e);
        } catch (jk e2) {
            b.fine(a, "attemptReconnect", "804", null, e2);
        }
    }

    private el s(String str, hk hkVar) throws jk, ok {
        jl jlVar;
        String[] e;
        jl jlVar2;
        String[] e2;
        rm rmVar = b;
        String str2 = a;
        rmVar.fine(str2, "createNetworkModule", "115", new Object[]{str});
        SocketFactory j = hkVar.j();
        int x = hk.x(str);
        try {
            URI uri = new URI(str);
            if (uri.getHost() == null && str.contains("_")) {
                try {
                    Field declaredField = URI.class.getDeclaredField("host");
                    declaredField.setAccessible(true);
                    declaredField.set(uri, x(str.substring(uri.getScheme().length() + 3)));
                } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException | SecurityException e3) {
                    throw zk.b(e3.getCause());
                }
            }
            String host = uri.getHost();
            int port = uri.getPort();
            if (x == 0) {
                if (port == -1) {
                    port = 1883;
                }
                if (j == null) {
                    j = SocketFactory.getDefault();
                } else if (j instanceof SSLSocketFactory) {
                    throw zk.a(32105);
                }
                hl hlVar = new hl(j, host, port, this.e);
                hlVar.d(hkVar.a());
                return hlVar;
            } else if (x == 1) {
                if (port == -1) {
                    port = 8883;
                }
                if (j == null) {
                    jlVar = new jl();
                    Properties h = hkVar.h();
                    if (h != null) {
                        jlVar.t(h, null);
                    }
                    j = jlVar.c(null);
                } else if (!(j instanceof SSLSocketFactory)) {
                    throw zk.a(32105);
                } else {
                    jlVar = null;
                }
                gl glVar = new gl((SSLSocketFactory) j, host, port, this.e);
                glVar.g(hkVar.a());
                glVar.f(hkVar.g());
                if (jlVar != null && (e = jlVar.e(null)) != null) {
                    glVar.e(e);
                }
                return glVar;
            } else if (x == 3) {
                int i = port == -1 ? 80 : port;
                if (j == null) {
                    j = SocketFactory.getDefault();
                } else if (j instanceof SSLSocketFactory) {
                    throw zk.a(32105);
                }
                ql qlVar = new ql(j, str, host, i, this.e);
                qlVar.d(hkVar.a());
                return qlVar;
            } else if (x != 4) {
                rmVar.fine(str2, "createNetworkModule", "119", new Object[]{str});
                return null;
            } else {
                int i2 = port == -1 ? 443 : port;
                if (j == null) {
                    jl jlVar3 = new jl();
                    Properties h2 = hkVar.h();
                    if (h2 != null) {
                        jlVar3.t(h2, null);
                    }
                    j = jlVar3.c(null);
                    jlVar2 = jlVar3;
                } else if (!(j instanceof SSLSocketFactory)) {
                    throw zk.a(32105);
                } else {
                    jlVar2 = null;
                }
                sl slVar = new sl((SSLSocketFactory) j, str, host, i2, this.e);
                slVar.g(hkVar.a());
                if (jlVar2 != null && (e2 = jlVar2.e(null)) != null) {
                    slVar.e(e2);
                }
                return slVar;
            }
        } catch (URISyntaxException e4) {
            throw new IllegalArgumentException("Malformed URI: " + str + ", " + e4.getMessage());
        }
    }

    private String x(String str) {
        int indexOf = str.indexOf(58);
        if (indexOf == -1) {
            indexOf = str.indexOf(47);
        }
        if (indexOf == -1) {
            indexOf = str.length();
        }
        return str.substring(0, indexOf);
    }

    public void A() throws jk {
        b.fine(a, "reconnect", "500", new Object[]{this.e});
        if (!this.g.B()) {
            if (!this.g.C()) {
                if (!this.g.E()) {
                    if (!this.g.A()) {
                        E();
                        p();
                        return;
                    }
                    throw new jk(32111);
                }
                throw new jk(32102);
            }
            throw new jk(32110);
        }
        throw zk.a(32100);
    }

    public void B(xj xjVar) {
        this.g.J(new yk(xjVar));
    }

    public void C(ek ekVar) {
        this.j = ekVar;
        this.g.I(ekVar);
    }

    public ck F(String str, int i, Object obj, yj yjVar) throws jk {
        return G(new String[]{str}, new int[]{i}, obj, yjVar);
    }

    public ck G(String[] strArr, int[] iArr, Object obj, yj yjVar) throws jk {
        if (strArr.length == iArr.length) {
            for (String str : strArr) {
                this.g.G(str);
            }
            if (b.isLoggable(5)) {
                StringBuffer stringBuffer = new StringBuffer();
                for (int i = 0; i < strArr.length; i++) {
                    if (i > 0) {
                        stringBuffer.append(", ");
                    }
                    stringBuffer.append("topic=");
                    stringBuffer.append(strArr[i]);
                    stringBuffer.append(" qos=");
                    stringBuffer.append(iArr[i]);
                    qk.b(strArr[i], true);
                }
                b.fine(a, "subscribe", "106", new Object[]{stringBuffer.toString(), obj, yjVar});
            }
            pk pkVar = new pk(b());
            pkVar.i(yjVar);
            pkVar.j(obj);
            pkVar.a.y(strArr);
            this.g.H(new km(strArr, iArr), pkVar);
            b.fine(a, "subscribe", "109");
            return pkVar;
        }
        throw new IllegalArgumentException();
    }

    @Override // defpackage.zj
    public String a() {
        return this.f;
    }

    @Override // defpackage.zj
    public String b() {
        return this.e;
    }

    public void q(boolean z) throws jk {
        rm rmVar = b;
        String str = a;
        rmVar.fine(str, "close", "113");
        this.g.n(z);
        rmVar.fine(str, "close", "114");
    }

    public ck r(hk hkVar, Object obj, yj yjVar) throws jk, ok {
        if (!this.g.B()) {
            if (!this.g.C()) {
                if (!this.g.E()) {
                    if (!this.g.A()) {
                        if (hkVar == null) {
                            hkVar = new hk();
                        }
                        hk hkVar2 = hkVar;
                        this.k = hkVar2;
                        this.l = obj;
                        boolean n = hkVar2.n();
                        rm rmVar = b;
                        String str = a;
                        Object[] objArr = new Object[8];
                        objArr[0] = Boolean.valueOf(hkVar2.o());
                        objArr[1] = new Integer(hkVar2.a());
                        objArr[2] = new Integer(hkVar2.c());
                        objArr[3] = hkVar2.k();
                        objArr[4] = hkVar2.f() == null ? "[null]" : "[notnull]";
                        objArr[5] = hkVar2.m() != null ? "[notnull]" : "[null]";
                        objArr[6] = obj;
                        objArr[7] = yjVar;
                        rmVar.fine(str, "connect", "103", objArr);
                        this.g.L(t(this.f, hkVar2));
                        this.g.M(new b(n));
                        pk pkVar = new pk(b());
                        xk xkVar = new xk(this, this.i, this.g, hkVar2, pkVar, obj, yjVar, this.n);
                        pkVar.i(xkVar);
                        pkVar.j(this);
                        ek ekVar = this.j;
                        if (ekVar instanceof fk) {
                            xkVar.b((fk) ekVar);
                        }
                        this.g.K(0);
                        xkVar.a();
                        return pkVar;
                    }
                    throw new jk(32111);
                }
                throw new jk(32102);
            }
            throw new jk(32110);
        }
        throw zk.a(32100);
    }

    protected el[] t(String str, hk hkVar) throws jk, ok {
        b.fine(a, "createNetworkModules", "116", new Object[]{str});
        String[] i = hkVar.i();
        if (i == null) {
            i = new String[]{str};
        } else if (i.length == 0) {
            i = new String[]{str};
        }
        el[] elVarArr = new el[i.length];
        for (int i2 = 0; i2 < i.length; i2++) {
            elVarArr[i2] = s(i[i2], hkVar);
        }
        b.fine(a, "createNetworkModules", "108");
        return elVarArr;
    }

    public ck u(long j, Object obj, yj yjVar) throws jk {
        rm rmVar = b;
        String str = a;
        rmVar.fine(str, "disconnect", "104", new Object[]{new Long(j), obj, yjVar});
        pk pkVar = new pk(b());
        pkVar.i(yjVar);
        pkVar.j(obj);
        try {
            this.g.r(new xl(), j, pkVar);
            rmVar.fine(str, "disconnect", "108");
            return pkVar;
        } catch (jk e) {
            b.fine(a, "disconnect", "105", null, e);
            throw e;
        }
    }

    public ck v(Object obj, yj yjVar) throws jk {
        return u(30000L, obj, yjVar);
    }

    public void w(long j, long j2, boolean z) throws jk {
        this.g.s(j, j2, z);
    }

    public boolean y() {
        return this.g.B();
    }

    public ak z(String str, kk kkVar, Object obj, yj yjVar) throws jk, mk {
        rm rmVar = b;
        String str2 = a;
        rmVar.fine(str2, "publish", "111", new Object[]{str, obj, yjVar});
        qk.b(str, false);
        ik ikVar = new ik(b());
        ikVar.i(yjVar);
        ikVar.j(obj);
        ikVar.k(kkVar);
        ikVar.a.y(new String[]{str});
        this.g.H(new hm(str, kkVar), ikVar);
        rmVar.fine(str2, "publish", "112");
        return ikVar;
    }
}
