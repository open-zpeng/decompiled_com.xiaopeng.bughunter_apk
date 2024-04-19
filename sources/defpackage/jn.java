package defpackage;
/* compiled from: PendingPostQueue.java */
/* renamed from: jn  reason: default package */
/* loaded from: classes.dex */
final class jn {
    private in a;
    private in b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(in inVar) {
        try {
            if (inVar != null) {
                in inVar2 = this.b;
                if (inVar2 != null) {
                    inVar2.d = inVar;
                    this.b = inVar;
                } else if (this.a == null) {
                    this.b = inVar;
                    this.a = inVar;
                } else {
                    throw new IllegalStateException("Head present, but no tail");
                }
                notifyAll();
            } else {
                throw new NullPointerException("null cannot be enqueued");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized in b() {
        in inVar;
        inVar = this.a;
        if (inVar != null) {
            in inVar2 = inVar.d;
            this.a = inVar2;
            if (inVar2 == null) {
                this.b = null;
            }
        }
        return inVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized in c(int i) throws InterruptedException {
        if (this.a == null) {
            wait(i);
        }
        return b();
    }
}
