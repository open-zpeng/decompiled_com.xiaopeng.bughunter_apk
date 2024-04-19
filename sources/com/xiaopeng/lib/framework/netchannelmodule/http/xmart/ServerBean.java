package com.xiaopeng.lib.framework.netchannelmodule.http.xmart;

import com.google.gson.annotations.SerializedName;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.xmart.IServerBean;
/* loaded from: classes.dex */
public class ServerBean implements IServerBean {
    @SerializedName("code")
    private int mCode;
    @SerializedName("data")
    private String mData;
    @SerializedName("msg")
    private String mMsg;

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.xmart.IServerBean
    public int code() {
        return this.mCode;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.xmart.IServerBean
    public String data() {
        return this.mData;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.xmart.IServerBean
    public String message() {
        return this.mMsg;
    }

    public void code(int i) {
        this.mCode = i;
    }

    public void data(String str) {
        this.mData = str;
    }

    public void message(String str) {
        this.mMsg = str;
    }
}
