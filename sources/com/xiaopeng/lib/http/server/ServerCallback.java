package com.xiaopeng.lib.http.server;

import okhttp3.Response;
/* loaded from: classes.dex */
public abstract class ServerCallback extends ic<ServerBean> implements jc<ServerBean> {
    public static final int CODE_SUCCESS = 200;
    private ServerConvert convert = new ServerConvert();

    @Override // defpackage.jc
    public abstract /* synthetic */ void onSuccess(ad<T> adVar);

    @Override // defpackage.lc
    public ServerBean convertResponse(Response response) throws Throwable {
        ServerBean convertResponse = this.convert.convertResponse(response);
        response.close();
        return convertResponse;
    }
}
