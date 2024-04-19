package com.xiaopeng.lib.framework.netchannelmodule.remotestorage.token;
/* loaded from: classes.dex */
public final class Token {
    private final long TOKEN_EXPIRE_TIME_IN_MS;
    private final String mAccessKeyId;
    private final String mAccessKeySecret;
    private final long mActiveTimeInMs;
    private final String mSecurityToken;

    private Token() {
        this.TOKEN_EXPIRE_TIME_IN_MS = 3000000L;
        this.mSecurityToken = "";
        this.mAccessKeySecret = "";
        this.mAccessKeyId = "";
        this.mActiveTimeInMs = 0L;
    }

    public String accessKeyId() {
        return this.mAccessKeyId;
    }

    public String acessKeySecret() {
        return this.mAccessKeySecret;
    }

    public String securityToken() {
        return this.mSecurityToken;
    }

    public boolean stillFresh() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.mActiveTimeInMs;
        return currentTimeMillis > j && currentTimeMillis - j < 3000000;
    }

    public Token(String str, String str2, String str3) {
        this.TOKEN_EXPIRE_TIME_IN_MS = 3000000L;
        this.mSecurityToken = str;
        this.mAccessKeySecret = str2;
        this.mAccessKeyId = str3;
        this.mActiveTimeInMs = System.currentTimeMillis();
    }
}
