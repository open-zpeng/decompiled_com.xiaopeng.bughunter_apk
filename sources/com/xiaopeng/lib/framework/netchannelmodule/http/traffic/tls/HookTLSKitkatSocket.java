package com.xiaopeng.lib.framework.netchannelmodule.http.traffic.tls;

import com.xiaopeng.lib.framework.netchannelmodule.http.statistic.SocketCounter;
import com.xiaopeng.lib.framework.netchannelmodule.http.traffic.CountingInputStream;
import com.xiaopeng.lib.framework.netchannelmodule.http.traffic.CountingOutputStream;
import com.xiaopeng.lib.framework.netchannelmodule.http.traffic.ICollector;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
/* loaded from: classes.dex */
public class HookTLSKitkatSocket {
    private static Constructor mInputConstruct;
    private static Field mInputField;
    private static Constructor mOutputConstruct;
    private static Field mOutputField;

    public static Socket createSocket(Socket socket, final String str) throws Exception {
        if (socket instanceof SSLSocket) {
            if (mInputConstruct == null || mOutputConstruct == null) {
                mInputConstruct = Class.forName("com.android.org.conscrypt.OpenSSLSocketImpl$SSLInputStream").getDeclaredConstructors()[0];
                mOutputConstruct = Class.forName("com.android.org.conscrypt.OpenSSLSocketImpl$SSLOutputStream").getDeclaredConstructors()[0];
                mInputField = Class.forName("com.android.org.conscrypt.OpenSSLSocketImpl").getDeclaredField("is");
                mOutputField = Class.forName("com.android.org.conscrypt.OpenSSLSocketImpl").getDeclaredField("os");
                mInputConstruct.setAccessible(true);
                mOutputConstruct.setAccessible(true);
                mInputField.setAccessible(true);
                mOutputField.setAccessible(true);
            }
            SSLSocket sSLSocket = (SSLSocket) socket;
            ICollector iCollector = new ICollector() { // from class: com.xiaopeng.lib.framework.netchannelmodule.http.traffic.tls.HookTLSKitkatSocket.1
                @Override // com.xiaopeng.lib.framework.netchannelmodule.http.traffic.ICollector
                public String getDomain() {
                    return str;
                }
            };
            KitKatTLSInputStream kitKatTLSInputStream = new KitKatTLSInputStream(iCollector, sSLSocket);
            KitKatTLSOutputStream kitKatTLSOutputStream = new KitKatTLSOutputStream(iCollector, sSLSocket);
            kitKatTLSInputStream.setStatisticCounter(SocketCounter.getInstance());
            kitKatTLSOutputStream.setStatisticCounter(SocketCounter.getInstance());
            mInputField.set(socket, kitKatTLSInputStream);
            mOutputField.set(socket, kitKatTLSOutputStream);
            return sSLSocket;
        }
        return socket;
    }

    /* loaded from: classes.dex */
    private static class KitKatTLSInputStream extends CountingInputStream {
        private SSLSocket socket;

        public KitKatTLSInputStream(ICollector iCollector, SSLSocket sSLSocket) throws IOException {
            super(iCollector, null);
            this.socket = sSLSocket;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int available() throws IOException {
            checkInputStream();
            return super.available();
        }

        public void checkInputStream() throws IOException {
            if (((FilterInputStream) this).in == null) {
                try {
                    ((FilterInputStream) this).in = (InputStream) HookTLSKitkatSocket.mInputConstruct.newInstance(this.socket);
                } catch (Exception e) {
                    e = e;
                    Throwable cause = e.getCause();
                    if (cause != null) {
                        e = cause;
                    }
                    throw new IOException(e);
                }
            }
        }

        public void increaseSuccess() {
            this.mCounter.increaseSucceedWithSize(this.mCollector.getDomain(), 0L);
        }

        @Override // com.xiaopeng.lib.framework.netchannelmodule.http.traffic.CountingInputStream, java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            checkInputStream();
            increaseSuccess();
            return super.read(bArr, i, i2);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void reset() throws IOException {
            checkInputStream();
            super.reset();
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public long skip(long j) throws IOException {
            checkInputStream();
            return super.skip(j);
        }

        @Override // com.xiaopeng.lib.framework.netchannelmodule.http.traffic.CountingInputStream, java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            checkInputStream();
            increaseSuccess();
            return super.read();
        }

        @Override // com.xiaopeng.lib.framework.netchannelmodule.http.traffic.CountingInputStream, java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr) throws IOException {
            checkInputStream();
            increaseSuccess();
            return super.read(bArr);
        }
    }

    /* loaded from: classes.dex */
    private static class KitKatTLSOutputStream extends CountingOutputStream {
        private SSLSocket socket;

        public KitKatTLSOutputStream(ICollector iCollector, SSLSocket sSLSocket) throws IOException {
            super(iCollector, null);
            this.socket = sSLSocket;
        }

        public void checkInputStream() throws IOException {
            if (((FilterOutputStream) this).out == null) {
                try {
                    ((FilterOutputStream) this).out = (OutputStream) HookTLSKitkatSocket.mOutputConstruct.newInstance(this.socket);
                } catch (Exception e) {
                    e = e;
                    Throwable cause = e.getCause();
                    if (cause != null) {
                        e = cause;
                    }
                    throw new IOException(e);
                }
            }
        }

        @Override // com.xiaopeng.lib.framework.netchannelmodule.http.traffic.CountingOutputStream, java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            checkInputStream();
            super.flush();
        }

        public void increaseSuccess() {
            this.mCounter.increaseSucceedWithSize(this.mCollector.getDomain(), 0L);
        }

        @Override // com.xiaopeng.lib.framework.netchannelmodule.http.traffic.CountingOutputStream, java.io.FilterOutputStream, java.io.OutputStream
        public void write(int i) throws IOException {
            checkInputStream();
            increaseSuccess();
            super.write(i);
        }

        @Override // com.xiaopeng.lib.framework.netchannelmodule.http.traffic.CountingOutputStream, java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            checkInputStream();
            increaseSuccess();
            super.write(bArr);
        }

        @Override // com.xiaopeng.lib.framework.netchannelmodule.http.traffic.CountingOutputStream, java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            checkInputStream();
            increaseSuccess();
            super.write(bArr, i, i2);
        }
    }
}
