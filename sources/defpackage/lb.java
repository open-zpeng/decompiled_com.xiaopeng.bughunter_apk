package defpackage;

import android.annotation.TargetApi;
import java.net.Socket;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509ExtendedTrustManager;
import javax.net.ssl.X509TrustManager;
/* compiled from: UtExtendTrustManager.java */
@TargetApi(24)
/* renamed from: lb  reason: default package */
/* loaded from: classes.dex */
class lb extends X509ExtendedTrustManager {
    private static TrustManager[] a;

    lb() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized TrustManager[] a() {
        TrustManager[] trustManagerArr;
        synchronized (lb.class) {
            if (a == null) {
                a = new TrustManager[]{new lb()};
            }
            trustManagerArr = a;
        }
        return trustManagerArr;
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        ya.c("UtExtendTrustManager", "checkClientTrusted1");
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        ya.c("UtExtendTrustManager", "checkServerTrusted1");
        if (x509CertificateArr != null && x509CertificateArr.length > 0) {
            try {
                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("X509");
                trustManagerFactory.init((KeyStore) null);
                if (trustManagerFactory.getTrustManagers() != null) {
                    for (TrustManager trustManager : trustManagerFactory.getTrustManagers()) {
                        try {
                            ((X509TrustManager) trustManager).checkServerTrusted(x509CertificateArr, str);
                        } catch (CertificateException e) {
                            for (Throwable th = e; th != null; th = th.getCause()) {
                                if ((th instanceof CertificateExpiredException) || (th instanceof CertificateNotYetValidException)) {
                                    return;
                                }
                            }
                            throw e;
                        }
                    }
                    return;
                }
                return;
            } catch (KeyStoreException e2) {
                throw new CertificateException(e2);
            } catch (NoSuchAlgorithmException e3) {
                throw new CertificateException(e3);
            }
        }
        throw new IllegalArgumentException("checkServerTrusted: X509Certificate array is null");
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }

    @Override // javax.net.ssl.X509ExtendedTrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str, Socket socket) throws CertificateException {
        ya.c("UtExtendTrustManager", "checkClientTrusted2");
        if (x509CertificateArr != null && x509CertificateArr.length != 0) {
            if (str != null && str.length() != 0) {
                try {
                    x509CertificateArr[0].checkValidity();
                    return;
                } catch (Exception unused) {
                    throw new CertificateException("Certificate not valid or trusted.");
                }
            }
            throw new IllegalArgumentException("parameter is not used");
        }
        throw new IllegalArgumentException("parameter is not used");
    }

    @Override // javax.net.ssl.X509ExtendedTrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str, SSLEngine sSLEngine) throws CertificateException {
        ya.c("UtExtendTrustManager", "checkClientTrusted3");
    }

    @Override // javax.net.ssl.X509ExtendedTrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str, Socket socket) throws CertificateException {
        ya.c("UtExtendTrustManager", "checkServerTrusted2");
    }

    @Override // javax.net.ssl.X509ExtendedTrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str, SSLEngine sSLEngine) throws CertificateException {
        ya.c("UtExtendTrustManager", "checkServerTrusted3");
    }
}
