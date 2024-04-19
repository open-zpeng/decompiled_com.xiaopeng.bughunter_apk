package defpackage;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
/* compiled from: MqttConnack.java */
/* renamed from: vl  reason: default package */
/* loaded from: classes.dex */
public class vl extends ul {
    private int e;
    private boolean f;

    public vl(byte b, byte[] bArr) throws IOException {
        super((byte) 2);
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        this.f = (dataInputStream.readUnsignedByte() & 1) == 1;
        this.e = dataInputStream.readUnsignedByte();
        dataInputStream.close();
    }

    @Override // defpackage.nm
    public String o() {
        return "Con";
    }

    @Override // defpackage.nm
    protected byte[] t() throws jk {
        return new byte[0];
    }

    @Override // defpackage.ul, defpackage.nm
    public String toString() {
        return String.valueOf(super.toString()) + " session present:" + this.f + " return code: " + this.e;
    }

    @Override // defpackage.nm
    public boolean u() {
        return false;
    }

    public int y() {
        return this.e;
    }
}
