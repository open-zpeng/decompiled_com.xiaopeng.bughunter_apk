package defpackage;

import java.util.Objects;
/* compiled from: MqttMessage.java */
/* renamed from: kk  reason: default package */
/* loaded from: classes.dex */
public class kk {
    private byte[] c;
    private int g;
    private boolean b = true;
    private int d = 1;
    private boolean e = false;
    private boolean f = false;

    public kk() {
        h(new byte[0]);
    }

    public static void k(int i) {
        if (i < 0 || i > 2) {
            throw new IllegalArgumentException();
        }
    }

    protected void a() throws IllegalStateException {
        if (!this.b) {
            throw new IllegalStateException();
        }
    }

    public byte[] b() {
        return this.c;
    }

    public int c() {
        return this.d;
    }

    public boolean d() {
        return this.f;
    }

    public boolean e() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(boolean z) {
        this.f = z;
    }

    public void g(int i) {
        this.g = i;
    }

    public void h(byte[] bArr) {
        a();
        Objects.requireNonNull(bArr);
        this.c = bArr;
    }

    public void i(int i) {
        a();
        k(i);
        this.d = i;
    }

    public void j(boolean z) {
        a();
        this.e = z;
    }

    public String toString() {
        return new String(this.c);
    }

    public kk(byte[] bArr) {
        h(bArr);
    }
}
