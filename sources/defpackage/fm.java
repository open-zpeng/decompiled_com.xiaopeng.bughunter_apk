package defpackage;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
/* compiled from: MqttPubRec.java */
/* renamed from: fm  reason: default package */
/* loaded from: classes.dex */
public class fm extends ul {
    public fm(byte b, byte[] bArr) throws IOException {
        super((byte) 5);
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        this.c = dataInputStream.readUnsignedShort();
        dataInputStream.close();
    }

    @Override // defpackage.nm
    protected byte[] t() throws jk {
        return l();
    }

    public fm(hm hmVar) {
        super((byte) 5);
        this.c = hmVar.p();
    }
}
