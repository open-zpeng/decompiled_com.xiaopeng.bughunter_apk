package defpackage;
/* compiled from: InitEventHolder.java */
/* renamed from: ff  reason: default package */
/* loaded from: classes.dex */
public class ff implements ef {
    private static volatile ff a = new ff();
    private ef b;

    public static ef b() {
        return a;
    }

    public static void c(ef efVar) {
        a.b = efVar;
    }

    @Override // defpackage.ef
    public void a(int i, String str) {
        ef efVar = this.b;
        if (efVar != null) {
            efVar.a(i, str);
        }
    }
}
