package defpackage;

import com.xiaopeng.lib.security.xmartv1.XmartV1Constants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
/* compiled from: MqttWireMessage.java */
/* renamed from: nm  reason: default package */
/* loaded from: classes.dex */
public abstract class nm {
    private static final String[] a = {"reserved", "CONNECT", "CONNACK", "PUBLISH", "PUBACK", "PUBREC", "PUBREL", "PUBCOMP", "SUBSCRIBE", "SUBACK", "UNSUBSCRIBE", "UNSUBACK", "PINGREQ", "PINGRESP", "DISCONNECT"};
    private byte b;
    protected boolean d = false;
    protected int c = 0;

    public nm(byte b) {
        this.b = b;
    }

    private static nm g(InputStream inputStream) throws jk {
        try {
            tl tlVar = new tl(inputStream);
            DataInputStream dataInputStream = new DataInputStream(tlVar);
            int readUnsignedByte = dataInputStream.readUnsignedByte();
            byte b = (byte) (readUnsignedByte >> 4);
            byte b2 = (byte) (readUnsignedByte & 15);
            long a2 = (tlVar.a() + v(dataInputStream).a()) - tlVar.a();
            byte[] bArr = new byte[0];
            if (a2 > 0) {
                int i = (int) a2;
                byte[] bArr2 = new byte[i];
                dataInputStream.readFully(bArr2, 0, i);
                bArr = bArr2;
            }
            if (b == 1) {
                return new wl(b2, bArr);
            }
            if (b == 3) {
                return new hm(b2, bArr);
            }
            if (b == 4) {
                return new dm(b2, bArr);
            }
            if (b == 7) {
                return new em(b2, bArr);
            }
            if (b == 2) {
                return new vl(b2, bArr);
            }
            if (b == 12) {
                return new bm(b2, bArr);
            }
            if (b == 13) {
                return new cm(b2, bArr);
            }
            if (b == 8) {
                return new km(b2, bArr);
            }
            if (b == 9) {
                return new jm(b2, bArr);
            }
            if (b == 10) {
                return new mm(b2, bArr);
            }
            if (b == 11) {
                return new lm(b2, bArr);
            }
            if (b == 6) {
                return new gm(b2, bArr);
            }
            if (b == 5) {
                return new fm(b2, bArr);
            }
            if (b == 14) {
                return new xl(b2, bArr);
            }
            throw zk.a(6);
        } catch (IOException e) {
            throw new jk(e);
        }
    }

    public static nm h(lk lkVar) throws jk {
        byte[] c = lkVar.c();
        if (c == null) {
            c = new byte[0];
        }
        return g(new om(lkVar.e(), lkVar.b(), lkVar.f(), c, lkVar.d(), lkVar.a()));
    }

    public static nm i(byte[] bArr) throws jk {
        return g(new ByteArrayInputStream(bArr));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static byte[] k(long j) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        do {
            byte b = (byte) (j % 128);
            j /= 128;
            int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i2 > 0) {
                b = (byte) (b | 128);
            }
            byteArrayOutputStream.write(b);
            i++;
            if (i2 <= 0) {
                break;
            }
        } while (i < 4);
        return byteArrayOutputStream.toByteArray();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static pm v(DataInputStream dataInputStream) throws IOException {
        byte readByte;
        long j = 0;
        int i = 0;
        int i2 = 1;
        do {
            i++;
            j += (readByte & Byte.MAX_VALUE) * i2;
            i2 *= 128;
        } while ((dataInputStream.readByte() & 128) != 0);
        return new pm(j, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String j(DataInputStream dataInputStream) throws jk {
        try {
            byte[] bArr = new byte[dataInputStream.readUnsignedShort()];
            dataInputStream.readFully(bArr);
            return new String(bArr, XmartV1Constants.UTF8_ENCODING);
        } catch (IOException e) {
            throw new jk(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public byte[] l() throws jk {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeShort(this.c);
            dataOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new jk(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m(DataOutputStream dataOutputStream, String str) throws jk {
        try {
            byte[] bytes = str.getBytes(XmartV1Constants.UTF8_ENCODING);
            dataOutputStream.write((byte) ((bytes.length >>> 8) & 255));
            dataOutputStream.write((byte) ((bytes.length >>> 0) & 255));
            dataOutputStream.write(bytes);
        } catch (UnsupportedEncodingException e) {
            throw new jk(e);
        } catch (IOException e2) {
            throw new jk(e2);
        }
    }

    public byte[] n() throws jk {
        try {
            int s = ((s() & 15) << 4) ^ (q() & 15);
            byte[] t = t();
            int length = t.length + r().length;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeByte(s);
            dataOutputStream.write(k(length));
            dataOutputStream.write(t);
            dataOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new jk(e);
        }
    }

    public String o() {
        return new Integer(p()).toString();
    }

    public int p() {
        return this.c;
    }

    protected abstract byte q();

    public byte[] r() throws jk {
        return new byte[0];
    }

    public byte s() {
        return this.b;
    }

    protected abstract byte[] t() throws jk;

    public String toString() {
        return a[this.b];
    }

    public boolean u() {
        return true;
    }

    public void w(boolean z) {
        this.d = z;
    }

    public void x(int i) {
        this.c = i;
    }
}
