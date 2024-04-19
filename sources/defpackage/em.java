package defpackage;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
/* compiled from: MqttPubComp.java */
/* renamed from: em  reason: default package */
/* loaded from: classes.dex */
public class em extends ul {
    public em(byte b, byte[] bArr) throws IOException {
        super((byte) 7);
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        this.c = dataInputStream.readUnsignedShort();
        dataInputStream.close();
    }

    @Override // defpackage.nm
    protected byte[] t() throws jk {
        return l();
    }

    public em(hm hmVar) {
        super((byte) 7);
        this.c = hmVar.p();
    }

    public em(int i) {
        super((byte) 7);
        this.c = i;
    }
}
