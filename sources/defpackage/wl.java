package defpackage;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
/* compiled from: MqttConnect.java */
/* renamed from: wl  reason: default package */
/* loaded from: classes.dex */
public class wl extends nm {
    private String e;
    private boolean f;
    private kk g;
    private String h;
    private char[] i;
    private int j;
    private String k;
    private int l;

    public wl(byte b, byte[] bArr) throws IOException, jk {
        super((byte) 1);
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        j(dataInputStream);
        dataInputStream.readByte();
        dataInputStream.readByte();
        this.j = dataInputStream.readUnsignedShort();
        this.e = j(dataInputStream);
        dataInputStream.close();
    }

    @Override // defpackage.nm
    public String o() {
        return "Con";
    }

    @Override // defpackage.nm
    protected byte q() {
        return (byte) 0;
    }

    @Override // defpackage.nm
    public byte[] r() throws jk {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            m(dataOutputStream, this.e);
            if (this.g != null) {
                m(dataOutputStream, this.k);
                dataOutputStream.writeShort(this.g.b().length);
                dataOutputStream.write(this.g.b());
            }
            String str = this.h;
            if (str != null) {
                m(dataOutputStream, str);
                char[] cArr = this.i;
                if (cArr != null) {
                    m(dataOutputStream, new String(cArr));
                }
            }
            dataOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new jk(e);
        }
    }

    @Override // defpackage.nm
    protected byte[] t() throws jk {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            int i = this.l;
            if (i == 3) {
                m(dataOutputStream, "MQIsdp");
            } else if (i == 4) {
                m(dataOutputStream, "MQTT");
            }
            dataOutputStream.write(this.l);
            byte b = this.f ? (byte) 2 : (byte) 0;
            kk kkVar = this.g;
            if (kkVar != null) {
                b = (byte) (((byte) (b | 4)) | (kkVar.c() << 3));
                if (this.g.e()) {
                    b = (byte) (b | 32);
                }
            }
            if (this.h != null) {
                b = (byte) (b | 128);
                if (this.i != null) {
                    b = (byte) (b | 64);
                }
            }
            dataOutputStream.write(b);
            dataOutputStream.writeShort(this.j);
            dataOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new jk(e);
        }
    }

    @Override // defpackage.nm
    public String toString() {
        return String.valueOf(super.toString()) + " clientId " + this.e + " keepAliveInterval " + this.j;
    }

    @Override // defpackage.nm
    public boolean u() {
        return false;
    }

    public wl(String str, int i, boolean z, int i2, String str2, char[] cArr, kk kkVar, String str3) {
        super((byte) 1);
        this.e = str;
        this.f = z;
        this.j = i2;
        this.h = str2;
        this.i = cArr;
        this.g = kkVar;
        this.k = str3;
        this.l = i;
    }
}
