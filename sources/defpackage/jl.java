package defpackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Vector;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
/* compiled from: SSLSocketFactoryFactory.java */
/* renamed from: jl  reason: default package */
/* loaded from: classes.dex */
public class jl {
    private static final String[] a = {"com.ibm.ssl.protocol", "com.ibm.ssl.contextProvider", "com.ibm.ssl.keyStore", "com.ibm.ssl.keyStorePassword", "com.ibm.ssl.keyStoreType", "com.ibm.ssl.keyStoreProvider", "com.ibm.ssl.keyManager", "com.ibm.ssl.trustStore", "com.ibm.ssl.trustStorePassword", "com.ibm.ssl.trustStoreType", "com.ibm.ssl.trustStoreProvider", "com.ibm.ssl.trustManager", "com.ibm.ssl.enabledCipherSuites", "com.ibm.ssl.clientAuthentication"};
    private static final byte[] b = {-99, -89, -39, Byte.MIN_VALUE, 5, -72, -119, -100};
    private Properties d;
    private rm e = null;
    private Hashtable c = new Hashtable();

    private void a(Properties properties) throws IllegalArgumentException {
        for (String str : properties.keySet()) {
            if (!u(str)) {
                throw new IllegalArgumentException(String.valueOf(str) + " is not a valid IBM SSL property key.");
            }
        }
    }

    private void b(Properties properties) {
        String property = properties.getProperty("com.ibm.ssl.keyStorePassword");
        if (property != null && !property.startsWith("{xor}")) {
            properties.put("com.ibm.ssl.keyStorePassword", v(property.toCharArray()));
        }
        String property2 = properties.getProperty("com.ibm.ssl.trustStorePassword");
        if (property2 == null || property2.startsWith("{xor}")) {
            return;
        }
        properties.put("com.ibm.ssl.trustStorePassword", v(property2.toCharArray()));
    }

    public static char[] d(String str) {
        if (str == null) {
            return null;
        }
        try {
            byte[] a2 = kl.a(str.substring(5));
            for (int i = 0; i < a2.length; i++) {
                byte b2 = a2[i];
                byte[] bArr = b;
                a2[i] = (byte) ((b2 ^ bArr[i % bArr.length]) & 255);
            }
            return x(a2);
        } catch (Exception unused) {
            return null;
        }
    }

    private String k(String str, String str2, String str3) {
        String l = l(str, str2);
        return (l == null && str3 != null) ? System.getProperty(str3) : l;
    }

    private String l(String str, String str2) {
        String str3 = null;
        Properties properties = str != null ? (Properties) this.c.get(str) : null;
        if (properties == null || (str3 = properties.getProperty(str2)) == null) {
            Properties properties2 = this.d;
            if (properties2 == null || (str3 = properties2.getProperty(str2)) != null) {
            }
            return str3;
        }
        return str3;
    }

    private SSLContext m(String str) throws ok {
        SSLContext sSLContext;
        KeyManager[] keyManagerArr;
        TrustManager[] trustManagerArr;
        TrustManagerFactory trustManagerFactory;
        KeyManagerFactory keyManagerFactory;
        String str2 = str;
        String n = n(str);
        if (n == null) {
            n = "TLS";
        }
        rm rmVar = this.e;
        if (rmVar != null) {
            Object[] objArr = new Object[2];
            objArr[0] = str2 != null ? str2 : "null (broker defaults)";
            objArr[1] = n;
            rmVar.fine("org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory", "getSSLContext", "12000", objArr);
        }
        String f = f(str);
        try {
            if (f == null) {
                sSLContext = SSLContext.getInstance(n);
            } else {
                sSLContext = SSLContext.getInstance(n, f);
            }
            rm rmVar2 = this.e;
            if (rmVar2 != null) {
                Object[] objArr2 = new Object[2];
                objArr2[0] = str2 != null ? str2 : "null (broker defaults)";
                objArr2[1] = sSLContext.getProvider().getName();
                rmVar2.fine("org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory", "getSSLContext", "12001", objArr2);
            }
            String k = k(str2, "com.ibm.ssl.keyStore", null);
            if (k == null) {
                k = k(str2, "com.ibm.ssl.keyStore", "javax.net.ssl.keyStore");
            }
            rm rmVar3 = this.e;
            if (rmVar3 != null) {
                Object[] objArr3 = new Object[2];
                objArr3[0] = str2 != null ? str2 : "null (broker defaults)";
                objArr3[1] = k != null ? k : "null";
                rmVar3.fine("org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory", "getSSLContext", "12004", objArr3);
            }
            char[] h = h(str);
            rm rmVar4 = this.e;
            if (rmVar4 != null) {
                Object[] objArr4 = new Object[2];
                objArr4[0] = str2 != null ? str2 : "null (broker defaults)";
                objArr4[1] = h != null ? v(h) : "null";
                rmVar4.fine("org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory", "getSSLContext", "12005", objArr4);
            }
            String j = j(str);
            if (j == null) {
                j = KeyStore.getDefaultType();
            }
            rm rmVar5 = this.e;
            if (rmVar5 != null) {
                Object[] objArr5 = new Object[2];
                objArr5[0] = str2 != null ? str2 : "null (broker defaults)";
                objArr5[1] = j != null ? j : "null";
                rmVar5.fine("org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory", "getSSLContext", "12006", objArr5);
            }
            String defaultAlgorithm = KeyManagerFactory.getDefaultAlgorithm();
            String i = i(str);
            String g = g(str);
            if (g != null) {
                defaultAlgorithm = g;
            }
            if (k == null || j == null || defaultAlgorithm == null) {
                keyManagerArr = null;
            } else {
                try {
                    KeyStore keyStore = KeyStore.getInstance(j);
                    keyStore.load(new FileInputStream(k), h);
                    if (i != null) {
                        keyManagerFactory = KeyManagerFactory.getInstance(defaultAlgorithm, i);
                    } else {
                        keyManagerFactory = KeyManagerFactory.getInstance(defaultAlgorithm);
                    }
                    rm rmVar6 = this.e;
                    if (rmVar6 != null) {
                        Object[] objArr6 = new Object[2];
                        objArr6[0] = str2 != null ? str2 : "null (broker defaults)";
                        objArr6[1] = defaultAlgorithm;
                        rmVar6.fine("org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory", "getSSLContext", "12010", objArr6);
                        rm rmVar7 = this.e;
                        Object[] objArr7 = new Object[2];
                        objArr7[0] = str2 != null ? str2 : "null (broker defaults)";
                        objArr7[1] = keyManagerFactory.getProvider().getName();
                        rmVar7.fine("org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory", "getSSLContext", "12009", objArr7);
                    }
                    keyManagerFactory.init(keyStore, h);
                    keyManagerArr = keyManagerFactory.getKeyManagers();
                } catch (FileNotFoundException e) {
                    throw new ok(e);
                } catch (IOException e2) {
                    throw new ok(e2);
                } catch (KeyStoreException e3) {
                    throw new ok(e3);
                } catch (UnrecoverableKeyException e4) {
                    throw new ok(e4);
                } catch (CertificateException e5) {
                    throw new ok(e5);
                }
            }
            String p = p(str);
            rm rmVar8 = this.e;
            if (rmVar8 != null) {
                Object[] objArr8 = new Object[2];
                objArr8[0] = str2 != null ? str2 : "null (broker defaults)";
                objArr8[1] = p != null ? p : "null";
                rmVar8.fine("org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory", "getSSLContext", "12011", objArr8);
            }
            char[] q = q(str);
            rm rmVar9 = this.e;
            if (rmVar9 != null) {
                Object[] objArr9 = new Object[2];
                objArr9[0] = str2 != null ? str2 : "null (broker defaults)";
                objArr9[1] = q != null ? v(q) : "null";
                rmVar9.fine("org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory", "getSSLContext", "12012", objArr9);
            }
            String s = s(str);
            if (s == null) {
                s = KeyStore.getDefaultType();
            }
            rm rmVar10 = this.e;
            if (rmVar10 != null) {
                Object[] objArr10 = new Object[2];
                objArr10[0] = str2 != null ? str2 : "null (broker defaults)";
                objArr10[1] = s != null ? s : "null";
                rmVar10.fine("org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory", "getSSLContext", "12013", objArr10);
            }
            String defaultAlgorithm2 = TrustManagerFactory.getDefaultAlgorithm();
            String r = r(str);
            String o = o(str);
            if (o != null) {
                defaultAlgorithm2 = o;
            }
            if (p == null || s == null || defaultAlgorithm2 == null) {
                trustManagerArr = null;
            } else {
                try {
                    KeyStore keyStore2 = KeyStore.getInstance(s);
                    keyStore2.load(new FileInputStream(p), q);
                    if (r != null) {
                        trustManagerFactory = TrustManagerFactory.getInstance(defaultAlgorithm2, r);
                    } else {
                        trustManagerFactory = TrustManagerFactory.getInstance(defaultAlgorithm2);
                    }
                    rm rmVar11 = this.e;
                    if (rmVar11 != null) {
                        Object[] objArr11 = new Object[2];
                        objArr11[0] = str2 != null ? str2 : "null (broker defaults)";
                        objArr11[1] = defaultAlgorithm2;
                        rmVar11.fine("org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory", "getSSLContext", "12017", objArr11);
                        rm rmVar12 = this.e;
                        Object[] objArr12 = new Object[2];
                        if (str2 == null) {
                            str2 = "null (broker defaults)";
                        }
                        objArr12[0] = str2;
                        objArr12[1] = trustManagerFactory.getProvider().getName();
                        rmVar12.fine("org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory", "getSSLContext", "12016", objArr12);
                    }
                    trustManagerFactory.init(keyStore2);
                    trustManagerArr = trustManagerFactory.getTrustManagers();
                } catch (FileNotFoundException e6) {
                    throw new ok(e6);
                } catch (IOException e7) {
                    throw new ok(e7);
                } catch (KeyStoreException e8) {
                    throw new ok(e8);
                } catch (CertificateException e9) {
                    throw new ok(e9);
                }
            }
            sSLContext.init(keyManagerArr, trustManagerArr, null);
            return sSLContext;
        } catch (KeyManagementException e10) {
            throw new ok(e10);
        } catch (NoSuchAlgorithmException e11) {
            throw new ok(e11);
        } catch (NoSuchProviderException e12) {
            throw new ok(e12);
        }
    }

    private boolean u(String str) {
        String[] strArr;
        int i = 0;
        while (true) {
            strArr = a;
            if (i < strArr.length && !strArr[i].equals(str)) {
                i++;
            }
        }
        return i < strArr.length;
    }

    public static String v(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        byte[] w = w(cArr);
        for (int i = 0; i < w.length; i++) {
            byte b2 = w[i];
            byte[] bArr = b;
            w[i] = (byte) ((b2 ^ bArr[i % bArr.length]) & 255);
        }
        return "{xor}" + new String(kl.b(w));
    }

    public static byte[] w(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        byte[] bArr = new byte[cArr.length * 2];
        int i = 0;
        for (int i2 = 0; i2 < cArr.length; i2++) {
            int i3 = i + 1;
            bArr[i] = (byte) (cArr[i2] & 255);
            i = i3 + 1;
            bArr[i3] = (byte) ((cArr[i2] >> '\b') & 255);
        }
        return bArr;
    }

    public static char[] x(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        char[] cArr = new char[bArr.length / 2];
        int i = 0;
        int i2 = 0;
        while (i < bArr.length) {
            int i3 = i + 1;
            cArr[i2] = (char) ((bArr[i] & 255) + ((bArr[i3] & 255) << 8));
            i2++;
            i = i3 + 1;
        }
        return cArr;
    }

    public static String[] y(String str) {
        if (str == null) {
            return null;
        }
        Vector vector = new Vector();
        int indexOf = str.indexOf(44);
        int i = 0;
        while (indexOf > -1) {
            vector.add(str.substring(i, indexOf));
            i = indexOf + 1;
            indexOf = str.indexOf(44, i);
        }
        vector.add(str.substring(i));
        String[] strArr = new String[vector.size()];
        vector.toArray(strArr);
        return strArr;
    }

    public SSLSocketFactory c(String str) throws ok {
        SSLContext m = m(str);
        rm rmVar = this.e;
        if (rmVar != null) {
            Object[] objArr = new Object[2];
            objArr[0] = str != null ? str : "null (broker defaults)";
            objArr[1] = e(str) != null ? k(str, "com.ibm.ssl.enabledCipherSuites", null) : "null (using platform-enabled cipher suites)";
            rmVar.fine("org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory", "createSocketFactory", "12020", objArr);
        }
        return m.getSocketFactory();
    }

    public String[] e(String str) {
        return y(k(str, "com.ibm.ssl.enabledCipherSuites", null));
    }

    public String f(String str) {
        return k(str, "com.ibm.ssl.contextProvider", null);
    }

    public String g(String str) {
        return k(str, "com.ibm.ssl.keyManager", "ssl.KeyManagerFactory.algorithm");
    }

    public char[] h(String str) {
        String k = k(str, "com.ibm.ssl.keyStorePassword", "javax.net.ssl.keyStorePassword");
        if (k != null) {
            if (k.startsWith("{xor}")) {
                return d(k);
            }
            return k.toCharArray();
        }
        return null;
    }

    public String i(String str) {
        return k(str, "com.ibm.ssl.keyStoreProvider", null);
    }

    public String j(String str) {
        return k(str, "com.ibm.ssl.keyStoreType", "javax.net.ssl.keyStoreType");
    }

    public String n(String str) {
        return k(str, "com.ibm.ssl.protocol", null);
    }

    public String o(String str) {
        return k(str, "com.ibm.ssl.trustManager", "ssl.TrustManagerFactory.algorithm");
    }

    public String p(String str) {
        return k(str, "com.ibm.ssl.trustStore", "javax.net.ssl.trustStore");
    }

    public char[] q(String str) {
        String k = k(str, "com.ibm.ssl.trustStorePassword", "javax.net.ssl.trustStorePassword");
        if (k != null) {
            if (k.startsWith("{xor}")) {
                return d(k);
            }
            return k.toCharArray();
        }
        return null;
    }

    public String r(String str) {
        return k(str, "com.ibm.ssl.trustStoreProvider", null);
    }

    public String s(String str) {
        return k(str, "com.ibm.ssl.trustStoreType", null);
    }

    public void t(Properties properties, String str) throws IllegalArgumentException {
        a(properties);
        Properties properties2 = new Properties();
        properties2.putAll(properties);
        b(properties2);
        if (str != null) {
            this.c.put(str, properties2);
        } else {
            this.d = properties2;
        }
    }
}
