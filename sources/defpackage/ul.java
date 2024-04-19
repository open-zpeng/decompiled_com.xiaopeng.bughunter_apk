package defpackage;
/* compiled from: MqttAck.java */
/* renamed from: ul  reason: default package */
/* loaded from: classes.dex */
public abstract class ul extends nm {
    public ul(byte b) {
        super(b);
    }

    @Override // defpackage.nm
    protected byte q() {
        return (byte) 0;
    }

    @Override // defpackage.nm
    public String toString() {
        return String.valueOf(super.toString()) + " msgId " + this.c;
    }
}
