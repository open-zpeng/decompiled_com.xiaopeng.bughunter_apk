package defpackage;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;
/* compiled from: MqttInputStream.java */
/* renamed from: yl  reason: default package */
/* loaded from: classes.dex */
public class yl extends InputStream {
    private static final String b;
    private static final rm c;
    private sk d;
    private DataInputStream e;
    private ByteArrayOutputStream f = new ByteArrayOutputStream();
    private long g = -1;
    private long h;
    private byte[] i;

    static {
        String name = yl.class.getName();
        b = name;
        c = sm.a("org.eclipse.paho.client.mqttv3.internal.nls.logcat", name);
    }

    public yl(sk skVar, InputStream inputStream) {
        this.d = null;
        this.d = skVar;
        this.e = new DataInputStream(inputStream);
    }

    private void a() throws IOException {
        int size = this.f.size();
        long j = this.h;
        int i = size + ((int) j);
        int i2 = (int) (this.g - j);
        if (i2 < 0) {
            throw new IndexOutOfBoundsException();
        }
        int i3 = 0;
        while (i3 < i2) {
            try {
                int read = this.e.read(this.i, i + i3, i2 - i3);
                this.d.w(read);
                if (read < 0) {
                    throw new EOFException();
                }
                i3 += read;
            } catch (SocketTimeoutException e) {
                this.h += i3;
                throw e;
            }
        }
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.e.available();
    }

    public nm b() throws IOException, jk {
        try {
            if (this.g < 0) {
                this.f.reset();
                byte readByte = this.e.readByte();
                this.d.w(1);
                byte b2 = (byte) ((readByte >>> 4) & 15);
                if (b2 >= 1 && b2 <= 14) {
                    this.g = nm.v(this.e).a();
                    this.f.write(readByte);
                    this.f.write(nm.k(this.g));
                    this.i = new byte[(int) (this.f.size() + this.g)];
                    this.h = 0L;
                } else {
                    throw zk.a(32108);
                }
            }
            if (this.g >= 0) {
                a();
                this.g = -1L;
                byte[] byteArray = this.f.toByteArray();
                System.arraycopy(byteArray, 0, this.i, 0, byteArray.length);
                nm i = nm.i(this.i);
                c.fine(b, "readMqttWireMessage", "501", new Object[]{i});
                return i;
            }
            return null;
        } catch (SocketTimeoutException unused) {
            return null;
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.e.close();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        return this.e.read();
    }
}
