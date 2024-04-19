package defpackage;
/* compiled from: IcmCrashCallbackAdapter.java */
/* renamed from: oe  reason: default package */
/* loaded from: classes.dex */
public class oe extends je {
    public static final int[] a = {554702429};

    @Override // defpackage.je
    @Deprecated
    protected final void a(int i, Object obj) {
        tf.l("IcmCrashCallbackAdapter", "BugHunter IcmCrashCallbackAdapter propertyId = " + i);
        if (i == 554702429 && (obj instanceof String)) {
            b((String) obj);
        }
    }

    protected void b(String str) {
        throw null;
    }
}
