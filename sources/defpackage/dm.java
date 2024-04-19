package defpackage;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
/* compiled from: MqttPubAck.java */
/* renamed from: dm  reason: default package */
/* loaded from: classes.dex */
public class dm extends ul {
    public dm(byte b, byte[] bArr) throws IOException {
        super((byte) 4);
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        this.c = dataInputStream.readUnsignedShort();
        dataInputStream.close();
    }

    @Override // defpackage.nm
    protected byte[] t() throws jk {
        return l();
    }

    public dm(hm hmVar) {
        super((byte) 4);
        this.c = hmVar.p();
    }
}
