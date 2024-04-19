package defpackage;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
/* compiled from: MqttOutputStream.java */
/* renamed from: zl  reason: default package */
/* loaded from: classes.dex */
public class zl extends OutputStream {
    private static final String b;
    private static final rm c;
    private sk d;
    private BufferedOutputStream e;

    static {
        String name = zl.class.getName();
        b = name;
        c = sm.a("org.eclipse.paho.client.mqttv3.internal.nls.logcat", name);
    }

    public zl(sk skVar, OutputStream outputStream) {
        this.d = null;
        this.d = skVar;
        this.e = new BufferedOutputStream(outputStream);
    }

    public void a(nm nmVar) throws IOException, jk {
        byte[] n = nmVar.n();
        byte[] r = nmVar.r();
        this.e.write(n, 0, n.length);
        this.d.A(n.length);
        int i = 0;
        while (i < r.length) {
            int min = Math.min(1024, r.length - i);
            this.e.write(r, i, min);
            i += 1024;
            this.d.A(min);
        }
        c.fine(b, "write", "529", new Object[]{nmVar});
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.e.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.e.flush();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        this.e.write(bArr);
        this.d.A(bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.e.write(bArr, i, i2);
        this.d.A(i2);
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        this.e.write(i);
    }
}
