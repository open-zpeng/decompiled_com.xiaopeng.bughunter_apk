package defpackage;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
/* compiled from: HttpsUtils.java */
/* renamed from: vc  reason: default package */
/* loaded from: classes.dex */
public class vc {
    public static X509TrustManager a = new a();
    public static HostnameVerifier b = new b();

    /* compiled from: HttpsUtils.java */
    /* renamed from: vc$a */
    /* loaded from: classes.dex */
    static class a implements X509TrustManager {
        a() {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    /* compiled from: HttpsUtils.java */
    /* renamed from: vc$b */
    /* loaded from: classes.dex */
    static class b implements HostnameVerifier {
        b() {
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    }

    /* compiled from: HttpsUtils.java */
    /* renamed from: vc$c */
    /* loaded from: classes.dex */
    public static class c {
        public SSLSocketFactory a;
        public X509TrustManager b;
    }

    private static X509TrustManager a(TrustManager[] trustManagerArr) {
        for (TrustManager trustManager : trustManagerArr) {
            if (trustManager instanceof X509TrustManager) {
                return (X509TrustManager) trustManager;
            }
        }
        return null;
    }

    public static c b() {
        return c(null, null, null, new InputStream[0]);
    }

    private static c c(X509TrustManager x509TrustManager, InputStream inputStream, String str, InputStream... inputStreamArr) {
        c cVar = new c();
        try {
            KeyManager[] d = d(inputStream, str);
            TrustManager[] e = e(inputStreamArr);
            if (x509TrustManager == null) {
                if (e != null) {
                    x509TrustManager = a(e);
                } else {
                    x509TrustManager = a;
                }
            }
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(d, new TrustManager[]{x509TrustManager}, null);
            cVar.a = sSLContext.getSocketFactory();
            cVar.b = x509TrustManager;
            return cVar;
        } catch (KeyManagementException e2) {
            throw new AssertionError(e2);
        } catch (NoSuchAlgorithmException e3) {
            throw new AssertionError(e3);
        }
    }

    private static KeyManager[] d(InputStream inputStream, String str) {
        if (inputStream != null && str != null) {
            try {
                KeyStore keyStore = KeyStore.getInstance("BKS");
                keyStore.load(inputStream, str.toCharArray());
                KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
                keyManagerFactory.init(keyStore, str.toCharArray());
                return keyManagerFactory.getKeyManagers();
            } catch (Exception e) {
                ld.a(e);
            }
        }
        return null;
    }

    private static TrustManager[] e(InputStream... inputStreamArr) {
        if (inputStreamArr != null && inputStreamArr.length > 0) {
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
                keyStore.load(null);
                int length = inputStreamArr.length;
                int i = 0;
                int i2 = 0;
                while (i < length) {
                    InputStream inputStream = inputStreamArr[i];
                    int i3 = i2 + 1;
                    keyStore.setCertificateEntry(Integer.toString(i2), certificateFactory.generateCertificate(inputStream));
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            ld.a(e);
                        }
                    }
                    i++;
                    i2 = i3;
                }
                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                trustManagerFactory.init(keyStore);
                return trustManagerFactory.getTrustManagers();
            } catch (Exception e2) {
                ld.a(e2);
            }
        }
        return null;
    }
}
