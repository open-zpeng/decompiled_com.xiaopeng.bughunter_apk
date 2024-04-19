package defpackage;
/* compiled from: AbsCallback.java */
/* renamed from: ic  reason: default package */
/* loaded from: classes.dex */
public abstract class ic<T> implements jc<T> {
    public void downloadProgress(zc zcVar) {
    }

    @Override // defpackage.jc
    public void onCacheSuccess(ad<T> adVar) {
    }

    @Override // defpackage.jc
    public void onError(ad<T> adVar) {
        ld.a(adVar.d());
    }

    @Override // defpackage.jc
    public void onFinish() {
    }

    @Override // defpackage.jc
    public void onStart(hd<T, ? extends hd> hdVar) {
    }

    @Override // defpackage.jc
    public void uploadProgress(zc zcVar) {
    }
}
