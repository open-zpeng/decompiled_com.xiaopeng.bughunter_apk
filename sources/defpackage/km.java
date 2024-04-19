package defpackage;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
/* compiled from: MqttSubscribe.java */
/* renamed from: km  reason: default package */
/* loaded from: classes.dex */
public class km extends nm {
    private String[] e;
    private int[] f;
    private int g;

    public km(byte b, byte[] bArr) throws IOException {
        super((byte) 8);
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        this.c = dataInputStream.readUnsignedShort();
        boolean z = false;
        this.g = 0;
        this.e = new String[10];
        this.f = new int[10];
        while (!z) {
            try {
                this.e[this.g] = j(dataInputStream);
                int[] iArr = this.f;
                int i = this.g;
                this.g = i + 1;
                iArr[i] = dataInputStream.readByte();
            } catch (Exception unused) {
                z = true;
            }
        }
        dataInputStream.close();
    }

    @Override // defpackage.nm
    protected byte q() {
        return (byte) ((this.d ? 8 : 0) | 2);
    }

    @Override // defpackage.nm
    public byte[] r() throws jk {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            int i = 0;
            while (true) {
                String[] strArr = this.e;
                if (i >= strArr.length) {
                    dataOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
                m(dataOutputStream, strArr[i]);
                dataOutputStream.writeByte(this.f[i]);
                i++;
            }
        } catch (IOException e) {
            throw new jk(e);
        }
    }

    @Override // defpackage.nm
    protected byte[] t() throws jk {
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

    @Override // defpackage.nm
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(super.toString());
        stringBuffer.append(" names:[");
        for (int i = 0; i < this.g; i++) {
            if (i > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append("\"");
            stringBuffer.append(this.e[i]);
            stringBuffer.append("\"");
        }
        stringBuffer.append("] qos:[");
        for (int i2 = 0; i2 < this.g; i2++) {
            if (i2 > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(this.f[i2]);
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public km(String[] strArr, int[] iArr) {
        super((byte) 8);
        this.e = strArr;
        this.f = iArr;
        if (strArr.length == iArr.length) {
            this.g = strArr.length;
            for (int i : iArr) {
                kk.k(i);
            }
            return;
        }
        throw new IllegalArgumentException();
    }
}
