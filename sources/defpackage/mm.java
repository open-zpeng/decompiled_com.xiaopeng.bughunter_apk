package defpackage;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
/* compiled from: MqttUnsubscribe.java */
/* renamed from: mm  reason: default package */
/* loaded from: classes.dex */
public class mm extends nm {
    private String[] e;
    private int f;

    public mm(byte b, byte[] bArr) throws IOException {
        super((byte) 10);
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        this.c = dataInputStream.readUnsignedShort();
        boolean z = false;
        this.f = 0;
        this.e = new String[10];
        while (!z) {
            try {
                this.e[this.f] = j(dataInputStream);
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
        for (int i = 0; i < this.f; i++) {
            if (i > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append("\"" + this.e[i] + "\"");
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
