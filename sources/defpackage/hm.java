package defpackage;

import com.xiaopeng.lib.security.xmartv1.XmartV1Constants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
/* compiled from: MqttPublish.java */
/* renamed from: hm  reason: default package */
/* loaded from: classes.dex */
public class hm extends am {
    private kk e;
    private String f;
    private byte[] g;

    public hm(String str, kk kkVar) {
        super((byte) 3);
        this.g = null;
        this.f = str;
        this.e = kkVar;
    }

    protected static byte[] y(kk kkVar) {
        return kkVar.b();
    }

    public String A() {
        return this.f;
    }

    @Override // defpackage.am, defpackage.lk
    public int a() {
        try {
            return r().length;
        } catch (jk unused) {
            return 0;
        }
    }

    @Override // defpackage.nm
    protected byte q() {
        byte c = (byte) (this.e.c() << 1);
        if (this.e.e()) {
            c = (byte) (c | 1);
        }
        return (this.e.d() || this.d) ? (byte) (c | 8) : c;
    }

    @Override // defpackage.nm
    public byte[] r() throws jk {
        if (this.g == null) {
            this.g = y(this.e);
        }
        return this.g;
    }

    @Override // defpackage.nm
    protected byte[] t() throws jk {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            m(dataOutputStream, this.f);
            if (this.e.c() > 0) {
                dataOutputStream.writeShort(this.c);
            }
            dataOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new jk(e);
        }
    }

    @Override // defpackage.nm
    public String toString() {
        String str;
        StringBuffer stringBuffer = new StringBuffer();
        byte[] b = this.e.b();
        int min = Math.min(b.length, 20);
        for (int i = 0; i < min; i++) {
            String hexString = Integer.toHexString(b[i]);
            if (hexString.length() == 1) {
                hexString = "0" + hexString;
            }
            stringBuffer.append(hexString);
        }
        try {
            str = new String(b, 0, min, XmartV1Constants.UTF8_ENCODING);
        } catch (Exception unused) {
            str = "?";
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append(super.toString());
        stringBuffer2.append(" qos:");
        stringBuffer2.append(this.e.c());
        if (this.e.c() > 0) {
            stringBuffer2.append(" msgId:");
            stringBuffer2.append(this.c);
        }
        stringBuffer2.append(" retained:");
        stringBuffer2.append(this.e.e());
        stringBuffer2.append(" dup:");
        stringBuffer2.append(this.d);
        stringBuffer2.append(" topic:\"");
        stringBuffer2.append(this.f);
        stringBuffer2.append("\"");
        stringBuffer2.append(" payload:[hex:");
        stringBuffer2.append(stringBuffer);
        stringBuffer2.append(" utf8:\"");
        stringBuffer2.append(str);
        stringBuffer2.append("\"");
        stringBuffer2.append(" length:");
        stringBuffer2.append(b.length);
        stringBuffer2.append("]");
        return stringBuffer2.toString();
    }

    @Override // defpackage.nm
    public boolean u() {
        return true;
    }

    @Override // defpackage.nm
    public void x(int i) {
        super.x(i);
        kk kkVar = this.e;
        if (kkVar instanceof im) {
            ((im) kkVar).l(i);
        }
    }

    public kk z() {
        return this.e;
    }

    public hm(byte b, byte[] bArr) throws jk, IOException {
        super((byte) 3);
        this.g = null;
        im imVar = new im();
        this.e = imVar;
        imVar.i(3 & (b >> 1));
        if ((b & 1) == 1) {
            this.e.j(true);
        }
        if ((b & 8) == 8) {
            ((im) this.e).f(true);
        }
        tl tlVar = new tl(new ByteArrayInputStream(bArr));
        DataInputStream dataInputStream = new DataInputStream(tlVar);
        this.f = j(dataInputStream);
        if (this.e.c() > 0) {
            this.c = dataInputStream.readUnsignedShort();
        }
        byte[] bArr2 = new byte[bArr.length - tlVar.a()];
        dataInputStream.readFully(bArr2);
        dataInputStream.close();
        this.e.h(bArr2);
    }
}
