package defpackage;
/* compiled from: Subscription.java */
/* renamed from: pn  reason: default package */
/* loaded from: classes.dex */
final class pn {
    final Object a;
    final nn b;
    volatile boolean c = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public pn(Object obj, nn nnVar) {
        this.a = obj;
        this.b = nnVar;
    }

    public boolean equals(Object obj) {
        if (obj instanceof pn) {
            pn pnVar = (pn) obj;
            return this.a == pnVar.a && this.b.equals(pnVar.b);
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode() + this.b.f.hashCode();
    }
}
