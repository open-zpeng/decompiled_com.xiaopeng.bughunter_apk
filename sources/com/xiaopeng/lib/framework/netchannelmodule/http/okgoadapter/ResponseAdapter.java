package com.xiaopeng.lib.framework.netchannelmodule.http.okgoadapter;

import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IResponse;
import com.xiaopeng.lib.framework.netchannelmodule.http.statistic.HttpCounter;
import com.xiaopeng.lib.framework.netchannelmodule.http.traffic.CountingInputStream;
import com.xiaopeng.lib.framework.netchannelmodule.http.traffic.ICollector;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import okhttp3.Response;
/* loaded from: classes.dex */
public class ResponseAdapter implements IResponse {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static volatile boolean mEnableStat;
    private ICollector mCollector;
    private String mDomain;
    private ad<String> mInternalResponse;
    private Response mRawResponse;

    public ResponseAdapter(ad adVar) {
        this.mCollector = new ICollector() { // from class: com.xiaopeng.lib.framework.netchannelmodule.http.okgoadapter.ResponseAdapter.1
            @Override // com.xiaopeng.lib.framework.netchannelmodule.http.traffic.ICollector
            public String getDomain() {
                return ResponseAdapter.this.mDomain;
            }
        };
        this.mInternalResponse = adVar;
        this.mRawResponse = null;
        this.mDomain = getDomain(null);
    }

    public static void enableStat(boolean z) {
        mEnableStat = z;
    }

    private String getDomain(Response response) {
        if (response == null || !response.isSuccessful() || response.request() == null) {
            return null;
        }
        return response.request().url().host();
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IResponse
    public String body() {
        Response response = this.mRawResponse;
        if (response == null) {
            String a = this.mInternalResponse.a();
            if (a != null && mEnableStat) {
                HttpCounter.getInstance().addReceivedSize(this.mDomain, a.length());
            }
            return a;
        }
        String str = null;
        if (response.body() == null) {
            return null;
        }
        try {
            str = this.mRawResponse.body().string();
            if (mEnableStat) {
                HttpCounter.getInstance().addReceivedSize(this.mDomain, str.length());
            }
        } catch (Exception unused) {
        }
        return str;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IResponse
    public InputStream byteStream() {
        CountingInputStream countingInputStream;
        Response response = this.mRawResponse;
        CountingInputStream countingInputStream2 = null;
        if (response == null || response.body() == null) {
            return null;
        }
        try {
            countingInputStream = new CountingInputStream(this.mCollector, this.mRawResponse.body().byteStream());
        } catch (Exception unused) {
        }
        try {
            countingInputStream.setStatisticCounter(HttpCounter.getInstance());
            return countingInputStream;
        } catch (Exception unused2) {
            countingInputStream2 = countingInputStream;
            return countingInputStream2;
        }
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IResponse
    public int code() {
        Response response = this.mRawResponse;
        if (response != null) {
            return response.code();
        }
        return this.mInternalResponse.b();
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IResponse
    public Throwable getException() {
        return this.mInternalResponse.d();
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IResponse
    public Response getRawResponse() {
        Response response = this.mRawResponse;
        return response != null ? response : this.mInternalResponse.f();
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IResponse
    public String header(String str) {
        Response response = this.mRawResponse;
        if (response == null) {
            return null;
        }
        return response.header(str);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IResponse
    public Map<String, List<String>> headers() {
        Response rawResponse = getRawResponse();
        if (rawResponse == null || rawResponse.headers() == null) {
            return null;
        }
        return rawResponse.headers().toMultimap();
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IResponse
    public String message() {
        Response response = this.mRawResponse;
        if (response == null) {
            return this.mInternalResponse.g();
        }
        return response.message();
    }

    public ResponseAdapter(Response response) {
        this.mCollector = new ICollector() { // from class: com.xiaopeng.lib.framework.netchannelmodule.http.okgoadapter.ResponseAdapter.1
            @Override // com.xiaopeng.lib.framework.netchannelmodule.http.traffic.ICollector
            public String getDomain() {
                return ResponseAdapter.this.mDomain;
            }
        };
        this.mRawResponse = response;
        ad<String> adVar = new ad<>();
        this.mInternalResponse = adVar;
        adVar.l(response);
        this.mDomain = getDomain(this.mRawResponse);
    }
}
