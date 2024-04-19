package defpackage;

import java.io.IOException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
/* compiled from: SSLNetworkModule.java */
/* renamed from: gl  reason: default package */
/* loaded from: classes.dex */
public class gl extends hl {
    private static final String h = "gl";
    private static final rm i = sm.a("org.eclipse.paho.client.mqttv3.internal.nls.logcat", gl.class.getName());
    private String[] j;
    private int k;
    private HostnameVerifier l;
    private String m;
    private int n;

    public gl(SSLSocketFactory sSLSocketFactory, String str, int i2, String str2) {
        super(sSLSocketFactory, str, i2, str2);
        this.m = str;
        this.n = i2;
        i.setResourceName(str2);
    }

    @Override // defpackage.hl, defpackage.el
    public String a() {
        return "ssl://" + this.m + ":" + this.n;
    }

    public void e(String[] strArr) {
        this.j = strArr;
        if (this.c == null || strArr == null) {
            return;
        }
        if (i.isLoggable(5)) {
            String str = "";
            for (int i2 = 0; i2 < strArr.length; i2++) {
                if (i2 > 0) {
                    str = String.valueOf(str) + ",";
                }
                str = String.valueOf(str) + strArr[i2];
            }
            i.fine(h, "setEnabledCiphers", "260", new Object[]{str});
        }
        ((SSLSocket) this.c).setEnabledCipherSuites(strArr);
    }

    public void f(HostnameVerifier hostnameVerifier) {
        this.l = hostnameVerifier;
    }

    public void g(int i2) {
        super.d(i2);
        this.k = i2;
    }

    @Override // defpackage.hl, defpackage.el
    public void start() throws IOException, jk {
        super.start();
        e(this.j);
        int soTimeout = this.c.getSoTimeout();
        this.c.setSoTimeout(this.k * 1000);
        ((SSLSocket) this.c).startHandshake();
        if (this.l != null) {
            this.l.verify(this.m, ((SSLSocket) this.c).getSession());
        }
        this.c.setSoTimeout(soTimeout);
    }
}
