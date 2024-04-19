package defpackage;

import java.util.concurrent.atomic.AtomicReference;
/* compiled from: SequentialDisposable.java */
/* renamed from: vh  reason: default package */
/* loaded from: classes.dex */
public final class vh extends AtomicReference<zg> implements zg {
    private static final long serialVersionUID = -754898800686245608L;

    public boolean a() {
        return sh.isDisposed(get());
    }

    public boolean b(zg zgVar) {
        return sh.replace(this, zgVar);
    }

    public boolean c(zg zgVar) {
        return sh.set(this, zgVar);
    }

    @Override // defpackage.zg
    public void dispose() {
        sh.dispose(this);
    }
}
