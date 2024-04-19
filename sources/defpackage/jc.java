package defpackage;
/* compiled from: Callback.java */
/* renamed from: jc  reason: default package */
/* loaded from: classes.dex */
public interface jc<T> extends lc<T> {
    void onCacheSuccess(ad<T> adVar);

    void onError(ad<T> adVar);

    void onFinish();

    void onStart(hd<T, ? extends hd> hdVar);

    void onSuccess(ad<T> adVar);

    void uploadProgress(zc zcVar);
}
