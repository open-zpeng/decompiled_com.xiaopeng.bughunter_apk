package com.xiaopeng.lib.framework.netchannelmodule.http.okgoadapter;

import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.Callback;
/* loaded from: classes.dex */
public class StringCallbackAdapter extends kc {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Callback mOuterCallback;

    public StringCallbackAdapter(Callback callback) {
        this.mOuterCallback = callback;
    }

    @Override // defpackage.ic, defpackage.jc
    public void onError(ad<String> adVar) {
        super.onError(adVar);
        this.mOuterCallback.onFailure(new ResponseAdapter(adVar));
    }

    @Override // defpackage.jc
    public void onSuccess(ad<String> adVar) {
        this.mOuterCallback.onSuccess(new ResponseAdapter(adVar));
    }
}
