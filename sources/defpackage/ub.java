package defpackage;

import java.util.Random;
/* compiled from: UploadEngine.java */
/* renamed from: ub  reason: default package */
/* loaded from: classes.dex */
public class ub {
    static ub a = new ub();
    protected long b = fa.a();
    private boolean c = false;
    private int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UploadEngine.java */
    /* renamed from: ub$a */
    /* loaded from: classes.dex */
    public class a extends vb {
        a() {
        }

        @Override // defpackage.vb
        public void a() {
            if (ub.this.c) {
                ka.c();
                ub.this.c();
                ya.c("UploadTask", "mPeriod:", Long.valueOf(ub.this.b));
                if (ib.a().h(2)) {
                    ib.a().i(2);
                }
                if (vb.k()) {
                    return;
                }
                ib.a().e(2, this, ub.this.b);
            }
        }

        @Override // defpackage.vb
        public void b() {
            ub.this.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long c() {
        long a2;
        int i;
        ya.c("UploadEngine", "UTDC.bBackground:", Boolean.valueOf(ea.c), "AppInfoUtil.isForeground(UTDC.getContext()) ", Boolean.valueOf(ra.b(ea.j())));
        boolean z = !ra.b(ea.j());
        ea.c = z;
        fa.a();
        if (z) {
            a2 = fa.f();
            i = this.d;
        } else {
            a2 = fa.a();
            i = this.d;
        }
        this.b = a2 + i;
        if (fa.g()) {
            this.b = 3000L;
        }
        return this.b;
    }

    public static ub d() {
        return a;
    }

    public void e() {
        if (this.d == 0) {
            this.d = 7000;
        } else {
            this.d = 0;
        }
    }

    public synchronized void f() {
        this.c = true;
        if (ib.a().h(2)) {
            ib.a().i(2);
        }
        c();
        Random random = new Random();
        if (!vb.k()) {
            ib.a().e(2, new a(), random.nextInt((int) this.b));
        }
    }

    public synchronized void g() {
        this.c = false;
        ib.a().i(2);
    }
}
