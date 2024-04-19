package defpackage;
/* compiled from: MqttToken.java */
/* renamed from: pk  reason: default package */
/* loaded from: classes.dex */
public class pk implements ck {
    public il a;

    public pk() {
        this.a = null;
    }

    @Override // defpackage.ck
    public int a() {
        return this.a.g();
    }

    @Override // defpackage.ck
    public String[] b() {
        return this.a.i();
    }

    @Override // defpackage.ck
    public void c(long j) throws jk {
        this.a.A(j);
    }

    @Override // defpackage.ck
    public nm d() {
        return this.a.h();
    }

    @Override // defpackage.ck
    public yj e() {
        return this.a.b();
    }

    @Override // defpackage.ck
    public zj f() {
        return this.a.c();
    }

    public jk g() {
        return this.a.d();
    }

    public boolean h() {
        return this.a.l();
    }

    public void i(yj yjVar) {
        this.a.r(yjVar);
    }

    public void j(Object obj) {
        this.a.z(obj);
    }

    public pk(String str) {
        this.a = null;
        this.a = new il(str);
    }
}
