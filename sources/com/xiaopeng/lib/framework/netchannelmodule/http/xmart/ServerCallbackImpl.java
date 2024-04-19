package com.xiaopeng.lib.framework.netchannelmodule.http.xmart;

import okhttp3.Response;
/* loaded from: classes.dex */
public abstract class ServerCallbackImpl extends ic<ServerBean> implements jc<ServerBean> {
    private ServerConverter convert = new ServerConverter();

    @Override // defpackage.jc
    public abstract /* synthetic */ void onSuccess(ad<T> adVar);

    @Override // defpackage.lc
    public ServerBean convertResponse(Response response) throws Throwable {
        ServerBean convertResponse = this.convert.convertResponse(response);
        response.close();
        return convertResponse;
    }
}
