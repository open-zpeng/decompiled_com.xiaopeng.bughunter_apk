package com.xiaopeng.lib.framework.netchannelmodule.http.xmart;

import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.xmart.IServerCallback;
import com.xiaopeng.lib.framework.netchannelmodule.http.okgoadapter.BasePostRequestAdapter;
/* loaded from: classes.dex */
public class ServerRequest extends BasePostRequestAdapter<ServerBean> {

    /* loaded from: classes.dex */
    public class ServerCallbackImplAdapter extends ServerCallbackImpl {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private IServerCallback mOuterCallback;

        public ServerCallbackImplAdapter(IServerCallback iServerCallback) {
            this.mOuterCallback = iServerCallback;
        }

        @Override // defpackage.ic, defpackage.jc
        public void onError(ad<ServerBean> adVar) {
            super.onError(adVar);
            this.mOuterCallback.onFailure(new ServerResponse(adVar));
        }

        @Override // com.xiaopeng.lib.framework.netchannelmodule.http.xmart.ServerCallbackImpl, defpackage.jc
        public void onSuccess(ad<ServerBean> adVar) {
            this.mOuterCallback.onSuccess(new ServerResponse(adVar));
        }
    }

    public ServerRequest(String str) {
        super(str);
    }

    @Override // com.xiaopeng.lib.framework.netchannelmodule.http.okgoadapter.BasePostRequestAdapter, com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IRequest
    public void execute(IServerCallback iServerCallback) {
        super.execute(new ServerCallbackImplAdapter(iServerCallback));
    }
}
