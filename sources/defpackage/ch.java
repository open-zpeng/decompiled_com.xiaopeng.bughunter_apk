package defpackage;
/* compiled from: RunnableDisposable.java */
/* renamed from: ch  reason: default package */
/* loaded from: classes.dex */
final class ch extends bh<Runnable> {
    private static final long serialVersionUID = -8219729196779211169L;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ch(Runnable runnable) {
        super(runnable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.bh
    /* renamed from: c */
    public void b(Runnable runnable) {
        runnable.run();
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public String toString() {
        return "RunnableDisposable(disposed=" + a() + ", " + get() + ")";
    }
}
