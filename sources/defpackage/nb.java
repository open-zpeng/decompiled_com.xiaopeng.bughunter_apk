package defpackage;

import android.net.SSLCertificateSocketFactory;
import android.net.SSLSessionCache;
import android.os.Build;
import android.text.TextUtils;
import com.alibaba.sdk.android.man.crashreporter.a.a.a.b.a;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
/* compiled from: UtSslSocketFactory.java */
/* renamed from: nb  reason: default package */
/* loaded from: classes.dex */
class nb extends SSLSocketFactory {
    private Method a = null;
    private String b;

    public nb(String str) {
        this.b = str;
    }

    public String a() {
        return this.b;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket() throws IOException {
        return null;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) throws IOException {
        return null;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        return null;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        return null;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        return null;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        ya.c("UtSslSocketFactory", "bizHost", this.b, "host", str, "port", Integer.valueOf(i), "autoClose", Boolean.valueOf(z));
        if (!TextUtils.isEmpty(this.b)) {
            ya.c("UtSslSocketFactory", "customized createSocket. host: " + this.b);
            try {
                SSLCertificateSocketFactory sSLCertificateSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getDefault(a.r, new SSLSessionCache(ea.j()));
                int i2 = Build.VERSION.SDK_INT;
                if (i2 < 24) {
                    sSLCertificateSocketFactory.setTrustManagers(ob.a());
                } else {
                    sSLCertificateSocketFactory.setTrustManagers(lb.a());
                }
                SSLSocket sSLSocket = (SSLSocket) sSLCertificateSocketFactory.createSocket(socket, this.b, i, z);
                sSLSocket.setEnabledProtocols(sSLSocket.getSupportedProtocols());
                if (i2 < 17) {
                    try {
                        if (this.a == null) {
                            Method method = sSLSocket.getClass().getMethod("setHostname", String.class);
                            this.a = method;
                            method.setAccessible(true);
                        }
                        this.a.invoke(sSLSocket, this.b);
                    } catch (Exception unused) {
                    }
                } else {
                    sSLCertificateSocketFactory.setUseSessionTickets(sSLSocket, true);
                    sSLCertificateSocketFactory.setHostname(sSLSocket, this.b);
                }
                sSLSocket.startHandshake();
                return sSLSocket;
            } catch (Throwable th) {
                throw new IOException("createSocket exception: " + th);
            }
        }
        throw new IOException("SDK set empty bizHost");
    }

    public boolean equals(Object obj) {
        if (TextUtils.isEmpty(this.b) || !(obj instanceof nb)) {
            return false;
        }
        String str = ((nb) obj).b;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.b.equals(str);
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return new String[0];
    }
}
