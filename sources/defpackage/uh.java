package defpackage;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* compiled from: ListCompositeDisposable.java */
/* renamed from: uh  reason: default package */
/* loaded from: classes.dex */
public final class uh implements zg, rh {
    List<zg> b;
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
            List<zg> list = this.b;
            if (list != null && list.remove(zgVar)) {
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
                    List list = this.b;
                    if (list == null) {
                        list = new LinkedList();
                        this.b = list;
                    }
                    list.add(zgVar);
                    return true;
                }
            }
        }
        zgVar.dispose();
        return false;
    }

    void d(List<zg> list) {
        if (list == null) {
            return;
        }
        ArrayList arrayList = null;
        for (zg zgVar : list) {
            try {
                zgVar.dispose();
            } catch (Throwable th) {
                eh.b(th);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(th);
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
            List<zg> list = this.b;
            this.b = null;
            d(list);
        }
    }
}
