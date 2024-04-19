package com.xiaopeng.lib.framework.netchannelmodule.http.xmart;

import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.xmart.IXmartResponse;
/* loaded from: classes.dex */
public class ServerResponse implements IXmartResponse {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    ad<ServerBean> mInternalResponse;

    public ServerResponse(ad<ServerBean> adVar) {
        this.mInternalResponse = adVar;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.xmart.IXmartResponse
    public int code() {
        return this.mInternalResponse.b();
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.xmart.IXmartResponse
    public Throwable getException() {
        return this.mInternalResponse.d();
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.xmart.IXmartResponse
    public String message() {
        return this.mInternalResponse.g();
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.xmart.IXmartResponse
    public ServerBean body() {
        return this.mInternalResponse.a();
    }
}
