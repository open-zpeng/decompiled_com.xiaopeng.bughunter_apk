package defpackage;

import java.util.concurrent.atomic.AtomicReference;
/* compiled from: CancellableDisposable.java */
/* renamed from: qh  reason: default package */
/* loaded from: classes.dex */
public final class qh extends AtomicReference<lh> implements zg {
    private static final long serialVersionUID = 5718521705281392066L;

    public qh(lh lhVar) {
        super(lhVar);
    }

    @Override // defpackage.zg
    public void dispose() {
        lh andSet;
        if (get() == null || (andSet = getAndSet(null)) == null) {
            return;
        }
        try {
            andSet.cancel();
        } catch (Exception e) {
            eh.b(e);
            uj.m(e);
        }
    }
}
