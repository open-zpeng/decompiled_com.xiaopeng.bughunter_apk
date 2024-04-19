package defpackage;
/* compiled from: Disposables.java */
/* renamed from: ah  reason: default package */
/* loaded from: classes.dex */
public final class ah {
    public static zg a() {
        return th.INSTANCE;
    }

    public static zg b(Runnable runnable) {
        xh.d(runnable, "run is null");
        return new ch(runnable);
    }
}
