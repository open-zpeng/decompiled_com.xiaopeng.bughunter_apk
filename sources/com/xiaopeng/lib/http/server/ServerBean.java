package com.xiaopeng.lib.http.server;

import com.google.gson.annotations.SerializedName;
/* loaded from: classes.dex */
public class ServerBean {
    @SerializedName("code")
    private int mCode;
    @SerializedName("data")
    private String mData;
    @SerializedName("msg")
    private String mMsg;

    public int getCode() {
        return this.mCode;
    }

    public String getData() {
        return this.mData;
    }

    public String getMsg() {
        return this.mMsg;
    }

    public void setCode(int i) {
        this.mCode = i;
    }

    public void setData(String str) {
        this.mData = str;
    }

    public void setMsg(String str) {
        this.mMsg = str;
    }
}
