package defpackage;
/* compiled from: MqttPersistentData.java */
/* renamed from: dl  reason: default package */
/* loaded from: classes.dex */
public class dl implements lk {
    private String a;
    private byte[] b;
    private int c;
    private int d;
    private byte[] e;
    private int f;
    private int g;

    public dl(String str, byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        this.a = null;
        this.b = null;
        this.c = 0;
        this.d = 0;
        this.e = null;
        this.f = 0;
        this.g = 0;
        this.a = str;
        this.b = bArr;
        this.c = i;
        this.d = i2;
        this.e = bArr2;
        this.f = i3;
        this.g = i4;
    }

    @Override // defpackage.lk
    public int a() {
        if (this.e == null) {
            return 0;
        }
        return this.g;
    }

    @Override // defpackage.lk
    public int b() {
        return this.c;
    }

    @Override // defpackage.lk
    public byte[] c() {
        return this.e;
    }

    @Override // defpackage.lk
    public int d() {
        return this.f;
    }

    @Override // defpackage.lk
    public byte[] e() {
        return this.b;
    }

    @Override // defpackage.lk
    public int f() {
        return this.d;
    }
}
