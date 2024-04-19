package defpackage;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
/* compiled from: MqttPubRel.java */
/* renamed from: gm  reason: default package */
/* loaded from: classes.dex */
public class gm extends am {
    public gm(fm fmVar) {
        super((byte) 6);
        x(fmVar.p());
    }

    @Override // defpackage.nm
    protected byte q() {
        return (byte) ((this.d ? 8 : 0) | 2);
    }

    @Override // defpackage.nm
    protected byte[] t() throws jk {
        return l();
    }

    @Override // defpackage.nm
    public String toString() {
        return String.valueOf(super.toString()) + " msgId " + this.c;
    }

    public gm(byte b, byte[] bArr) throws IOException {
        super((byte) 6);
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        this.c = dataInputStream.readUnsignedShort();
        dataInputStream.close();
    }
}
