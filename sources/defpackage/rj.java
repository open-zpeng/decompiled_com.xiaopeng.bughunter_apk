package defpackage;
/* compiled from: Pow2.java */
/* renamed from: rj  reason: default package */
/* loaded from: classes.dex */
public final class rj {
    public static int a(int i) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i - 1));
    }
}
