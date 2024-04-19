package defpackage;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
/* compiled from: MqttUnsubAck.java */
/* renamed from: lm  reason: default package */
/* loaded from: classes.dex */
public class lm extends ul {
    public lm(byte b, byte[] bArr) throws IOException {
        super((byte) 11);
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        this.c = dataInputStream.readUnsignedShort();
        dataInputStream.close();
    }

    @Override // defpackage.nm
    protected byte[] t() throws jk {
        return new byte[0];
    }
}
