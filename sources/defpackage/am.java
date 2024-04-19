package defpackage;
/* compiled from: MqttPersistableWireMessage.java */
/* renamed from: am  reason: default package */
/* loaded from: classes.dex */
public abstract class am extends nm implements lk {
    public am(byte b) {
        super(b);
    }

    @Override // defpackage.lk
    public int a() throws mk {
        return 0;
    }

    @Override // defpackage.lk
    public int b() throws mk {
        return 0;
    }

    @Override // defpackage.lk
    public byte[] c() throws mk {
        try {
            return r();
        } catch (jk e) {
            throw new mk(e.getCause());
        }
    }

    @Override // defpackage.lk
    public int d() throws mk {
        return 0;
    }

    @Override // defpackage.lk
    public byte[] e() throws mk {
        try {
            return n();
        } catch (jk e) {
            throw new mk(e.getCause());
        }
    }

    @Override // defpackage.lk
    public int f() throws mk {
        return e().length;
    }
}
