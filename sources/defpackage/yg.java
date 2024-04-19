package defpackage;

import java.util.ArrayList;
/* compiled from: CompositeDisposable.java */
/* renamed from: yg  reason: default package */
/* loaded from: classes.dex */
public final class yg implements zg, rh {
    qj<zg> b;
    volatile boolean c;

    @Override // defpackage.rh
    public boolean a(zg zgVar) {
        xh.d(zgVar, "Disposable item is null");
        if (this.c) {
            return false;
        }
        synchronized (this) {
            if (this.c) {
                return false;
            }
            qj<zg> qjVar = this.b;
            if (qjVar != null && qjVar.e(zgVar)) {
                return true;
            }
            return false;
        }
    }

    @Override // defpackage.rh
    public boolean b(zg zgVar) {
        if (a(zgVar)) {
            zgVar.dispose();
            return true;
        }
        return false;
    }

    @Override // defpackage.rh
    public boolean c(zg zgVar) {
        xh.d(zgVar, "d is null");
        if (!this.c) {
            synchronized (this) {
                if (!this.c) {
                    qj<zg> qjVar = this.b;
                    if (qjVar == null) {
                        qjVar = new qj<>();
                        this.b = qjVar;
                    }
                    qjVar.a(zgVar);
                    return true;
                }
            }
        }
        zgVar.dispose();
        return false;
    }

    void d(qj<zg> qjVar) {
        Object[] b;
        if (qjVar == null) {
            return;
        }
        ArrayList arrayList = null;
        for (Object obj : qjVar.b()) {
            if (obj instanceof zg) {
                try {
                    ((zg) obj).dispose();
                } catch (Throwable th) {
                    eh.b(th);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th);
                }
            }
        }
        if (arrayList != null) {
            if (arrayList.size() == 1) {
                throw oj.c((Throwable) arrayList.get(0));
            }
            throw new dh(arrayList);
        }
    }

    @Override // defpackage.zg
    public void dispose() {
        if (this.c) {
            return;
        }
        synchronized (this) {
            if (this.c) {
                return;
            }
            this.c = true;
            qj<zg> qjVar = this.b;
            this.b = null;
            d(qjVar);
        }
    }

    public boolean e() {
        return this.c;
    }
}
