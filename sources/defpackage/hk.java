package defpackage;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
/* compiled from: MqttConnectOptions.java */
/* renamed from: hk  reason: default package */
/* loaded from: classes.dex */
public class hk {
    private String e;
    private char[] f;
    private SocketFactory g;
    private int a = 60;
    private int b = 10;
    private String c = null;
    private kk d = null;
    private Properties h = null;
    private HostnameVerifier i = null;
    private boolean j = true;
    private int k = 30;
    private String[] l = null;
    private int m = 0;
    private boolean n = false;

    public static int x(String str) {
        try {
            URI uri = new URI(str);
            if ("ws".equals(uri.getScheme())) {
                return 3;
            }
            if ("wss".equals(uri.getScheme())) {
                return 4;
            }
            if (uri.getPath() != null && !uri.getPath().isEmpty()) {
                throw new IllegalArgumentException(str);
            }
            if ("tcp".equals(uri.getScheme())) {
                return 0;
            }
            if ("ssl".equals(uri.getScheme())) {
                return 1;
            }
            if ("local".equals(uri.getScheme())) {
                return 2;
            }
            throw new IllegalArgumentException(str);
        } catch (URISyntaxException unused) {
            throw new IllegalArgumentException(str);
        }
    }

    public int a() {
        return this.k;
    }

    public Properties b() {
        Properties properties = new Properties();
        properties.put("MqttVersion", new Integer(e()));
        properties.put("CleanSession", Boolean.valueOf(o()));
        properties.put("ConTimeout", new Integer(a()));
        properties.put("KeepAliveInterval", new Integer(c()));
        properties.put("UserName", k() == null ? "null" : k());
        properties.put("WillDestination", l() == null ? "null" : l());
        if (j() == null) {
            properties.put("SocketFactory", "null");
        } else {
            properties.put("SocketFactory", j());
        }
        if (h() == null) {
            properties.put("SSLProperties", "null");
        } else {
            properties.put("SSLProperties", h());
        }
        return properties;
    }

    public int c() {
        return this.a;
    }

    public int d() {
        return this.b;
    }

    public int e() {
        return this.m;
    }

    public char[] f() {
        return this.f;
    }

    public HostnameVerifier g() {
        return this.i;
    }

    public Properties h() {
        return this.h;
    }

    public String[] i() {
        return this.l;
    }

    public SocketFactory j() {
        return this.g;
    }

    public String k() {
        return this.e;
    }

    public String l() {
        return this.c;
    }

    public kk m() {
        return this.d;
    }

    public boolean n() {
        return this.n;
    }

    public boolean o() {
        return this.j;
    }

    public void p(boolean z) {
        this.n = z;
    }

    public void q(boolean z) {
        this.j = z;
    }

    public void r(int i) {
        if (i >= 0) {
            this.k = i;
            return;
        }
        throw new IllegalArgumentException();
    }

    public void s(int i) {
        if (i >= 0) {
            this.b = i;
            return;
        }
        throw new IllegalArgumentException();
    }

    public void t(int i) throws IllegalArgumentException {
        if (i != 0 && i != 3 && i != 4) {
            throw new IllegalArgumentException();
        }
        this.m = i;
    }

    public String toString() {
        return xm.a(b(), "Connection options");
    }

    public void u(char[] cArr) {
        this.f = cArr;
    }

    public void v(SocketFactory socketFactory) {
        this.g = socketFactory;
    }

    public void w(String str) {
        if (str != null && str.trim().equals("")) {
            throw new IllegalArgumentException();
        }
        this.e = str;
    }
}
