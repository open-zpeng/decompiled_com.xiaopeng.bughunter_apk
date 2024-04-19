package defpackage;

import java.io.IOException;
/* compiled from: MqttPingReq.java */
/* renamed from: bm  reason: default package */
/* loaded from: classes.dex */
public class bm extends nm {
    public bm() {
        super((byte) 12);
    }

    @Override // defpackage.nm
    public String o() {
        return "Ping";
    }

    @Override // defpackage.nm
    protected byte q() {
        return (byte) 0;
    }

    @Override // defpackage.nm
    protected byte[] t() throws jk {
        return new byte[0];
    }

    @Override // defpackage.nm
    public boolean u() {
        return false;
    }

    public bm(byte b, byte[] bArr) throws IOException {
        super((byte) 12);
    }
}
