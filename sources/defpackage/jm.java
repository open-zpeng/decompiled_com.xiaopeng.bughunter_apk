package defpackage;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
/* compiled from: MqttSuback.java */
/* renamed from: jm  reason: default package */
/* loaded from: classes.dex */
public class jm extends ul {
    private int[] e;

    public jm(byte b, byte[] bArr) throws IOException {
        super((byte) 9);
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        this.c = dataInputStream.readUnsignedShort();
        this.e = new int[bArr.length - 2];
        int i = 0;
        for (int read = dataInputStream.read(); read != -1; read = dataInputStream.read()) {
            this.e[i] = read;
            i++;
        }
        dataInputStream.close();
    }

    @Override // defpackage.nm
    protected byte[] t() throws jk {
        return new byte[0];
    }

    @Override // defpackage.ul, defpackage.nm
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(super.toString());
        stringBuffer.append(" granted Qos");
        for (int i = 0; i < this.e.length; i++) {
            stringBuffer.append(" ");
            stringBuffer.append(this.e[i]);
        }
        return stringBuffer.toString();
    }
}
