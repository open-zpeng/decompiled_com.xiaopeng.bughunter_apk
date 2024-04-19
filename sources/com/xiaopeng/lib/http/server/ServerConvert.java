package com.xiaopeng.lib.http.server;

import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ServerConvert implements lc<ServerBean> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // defpackage.lc
    public ServerBean convertResponse(Response response) throws Throwable {
        ResponseBody body = response.body();
        if (body != null) {
            ServerBean serverBean = new ServerBean();
            JSONObject jSONObject = new JSONObject(body.string());
            serverBean.setCode(jSONObject.getInt("code"));
            try {
                serverBean.setData(jSONObject.getString("data"));
            } catch (Throwable unused) {
            }
            try {
                serverBean.setMsg(jSONObject.getString("msg"));
            } catch (Throwable unused2) {
            }
            return serverBean;
        }
        throw new IllegalStateException("null");
    }
}
