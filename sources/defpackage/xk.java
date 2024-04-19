package defpackage;
/* compiled from: ConnectActionListener.java */
/* renamed from: xk  reason: default package */
/* loaded from: classes.dex */
public class xk implements yj {
    private gk a;
    private dk b;
    private rk c;
    private hk d;
    private pk e;
    private Object f;
    private yj g;
    private int h;
    private fk i;
    private boolean j;

    public xk(dk dkVar, gk gkVar, rk rkVar, hk hkVar, pk pkVar, Object obj, yj yjVar, boolean z) {
        this.a = gkVar;
        this.b = dkVar;
        this.c = rkVar;
        this.d = hkVar;
        this.e = pkVar;
        this.f = obj;
        this.g = yjVar;
        this.h = hkVar.e();
        this.j = z;
    }

    public void a() throws mk {
        pk pkVar = new pk(this.b.b());
        pkVar.i(this);
        pkVar.j(this);
        this.a.open(this.b.b(), this.b.a());
        if (this.d.o()) {
            this.a.clear();
        }
        if (this.d.e() == 0) {
            this.d.t(4);
        }
        try {
            this.c.o(this.d, pkVar);
        } catch (jk e) {
            onFailure(pkVar, e);
        }
    }

    public void b(fk fkVar) {
        this.i = fkVar;
    }

    @Override // defpackage.yj
    public void onFailure(ck ckVar, Throwable th) {
        jk jkVar;
        int length = this.c.w().length;
        int v = this.c.v() + 1;
        if (v >= length && (this.h != 0 || this.d.e() != 4)) {
            if (this.h == 0) {
                this.d.t(0);
            }
            if (th instanceof jk) {
                jkVar = (jk) th;
            } else {
                jkVar = new jk(th);
            }
            this.e.a.o(null, jkVar);
            this.e.a.p();
            this.e.a.s(this.b);
            if (this.g != null) {
                this.e.j(this.f);
                this.g.onFailure(this.e, th);
                return;
            }
            return;
        }
        if (this.h == 0) {
            if (this.d.e() == 4) {
                this.d.t(3);
            } else {
                this.d.t(4);
                this.c.K(v);
            }
        } else {
            this.c.K(v);
        }
        try {
            a();
        } catch (mk e) {
            onFailure(ckVar, e);
        }
    }

    @Override // defpackage.yj
    public void onSuccess(ck ckVar) {
        if (this.h == 0) {
            this.d.t(0);
        }
        this.e.a.o(ckVar.d(), null);
        this.e.a.p();
        this.e.a.s(this.b);
        this.c.F();
        if (this.g != null) {
            this.e.j(this.f);
            this.g.onSuccess(this.e);
        }
        if (this.i != null) {
            this.i.connectComplete(this.j, this.c.w()[this.c.v()].a());
        }
    }
}
