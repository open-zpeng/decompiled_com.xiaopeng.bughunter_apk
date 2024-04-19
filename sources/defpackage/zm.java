package defpackage;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AsyncPoster.java */
/* renamed from: zm  reason: default package */
/* loaded from: classes.dex */
public class zm implements Runnable, kn {
    private final jn b = new jn();
    private final bn c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zm(bn bnVar) {
        this.c = bnVar;
    }

    @Override // defpackage.kn
    public void a(pn pnVar, Object obj) {
        this.b.a(in.a(pnVar, obj));
        this.c.d().execute(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        in b = this.b.b();
        if (b != null) {
            this.c.h(b);
            return;
        }
        throw new IllegalStateException("No pending post available");
    }
}
