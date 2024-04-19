package com.xiaopeng.lib.framework.netchannelmodule.http;

import android.app.Application;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IConfig;
import com.xiaopeng.lib.framework.netchannelmodule.common.GlobalConfig;
import com.xiaopeng.lib.framework.netchannelmodule.http.okgoadapter.ResponseAdapter;
import com.xiaopeng.lib.framework.netchannelmodule.http.statistic.HttpCounter;
import com.xiaopeng.lib.framework.netchannelmodule.http.statistic.HttpEventCounter;
import com.xiaopeng.lib.framework.netchannelmodule.http.statistic.SocketCounter;
import com.xiaopeng.lib.framework.netchannelmodule.http.tracing.TracingInterceptor;
import com.xiaopeng.lib.framework.netchannelmodule.http.traffic.TrafficStatInterceptor;
import com.xiaopeng.lib.framework.netchannelmodule.http.traffic.plain.CountingPlainSocketInstrument;
import com.xiaopeng.lib.framework.netchannelmodule.http.traffic.tls.CountingTLSSocketInstrument;
import com.xiaopeng.lib.framework.netchannelmodule.http.xmart.TimeoutDns;
import defpackage.wc;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
/* loaded from: classes.dex */
public class ConfigImpl implements IConfig {
    private static final String TAG = "NetChannel.Http.ConfigImpl";
    private static wc sLoggingInterceptor = null;
    private static boolean sSetupSocketTrafficStatistic = false;
    private static TracingInterceptor sTracingInterceptor;
    private OkHttpClient.Builder mBuilder;
    private OkHttpClient mCurrentClient;
    private int mRetryCount;

    public ConfigImpl() {
        OkHttpClient i = wb.h().i();
        this.mCurrentClient = i;
        this.mBuilder = i.newBuilder();
        this.mRetryCount = wb.h().j();
        enableHttpEventReport(this.mBuilder);
    }

    private void enableHttpEventReport(OkHttpClient.Builder builder) {
        builder.eventListener(HttpEventCounter.INSTANCE.getEventListener());
    }

    private void enableHttpTrafficStatistic() {
        if (GlobalConfig.getApplicationContext() == null) {
            return;
        }
        TrafficStatInterceptor trafficStatInterceptor = TrafficStatInterceptor.getInstance();
        if (this.mBuilder.networkInterceptors() == null || this.mBuilder.networkInterceptors().contains(trafficStatInterceptor)) {
            return;
        }
        this.mBuilder.addNetworkInterceptor(trafficStatInterceptor);
    }

    public static OkHttpClient getCurrentHttpClient() {
        return wb.h().i();
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IConfig
    public IConfig addInterceptor(Interceptor interceptor) {
        this.mBuilder.addInterceptor(interceptor);
        return this;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IConfig
    public IConfig applicationContext(Application application) {
        GlobalConfig.setApplicationContext(application);
        enableTrafficStats();
        return this;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IConfig
    public void apply() {
        Module.register(se.class, new se(GlobalConfig.getApplicationContext()));
        this.mBuilder.dns(TimeoutDns.getInstance());
        wb.h().m(this.mRetryCount).l(this.mBuilder.build());
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IConfig
    public int connectTimeout() {
        return this.mCurrentClient.connectTimeoutMillis();
    }

    public IConfig disableTrafficStats() {
        if (this.mBuilder.networkInterceptors() != null) {
            this.mBuilder.networkInterceptors().remove(TrafficStatInterceptor.getInstance());
        }
        if (sSetupSocketTrafficStatistic) {
            CountingTLSSocketInstrument.reset();
            CountingPlainSocketInstrument.reset();
            sSetupSocketTrafficStatistic = false;
        }
        ResponseAdapter.enableStat(false);
        return this;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IConfig
    public int dnsTimeout() {
        return TimeoutDns.timeout();
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IConfig
    public IConfig enableLogging() {
        if (sLoggingInterceptor == null) {
            wc wcVar = new wc(TAG);
            sLoggingInterceptor = wcVar;
            wcVar.h(gg.g() ? wc.a.BODY : wc.a.BASIC);
            sLoggingInterceptor.g(Level.INFO);
            this.mBuilder.addInterceptor(sLoggingInterceptor);
        }
        return this;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IConfig
    public IConfig enableTracing() {
        if (sTracingInterceptor == null) {
            TracingInterceptor tracingInterceptor = new TracingInterceptor();
            sTracingInterceptor = tracingInterceptor;
            this.mBuilder.addInterceptor(tracingInterceptor);
        }
        return this;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IConfig
    public IConfig enableTrafficStats() {
        enableHttpTrafficStatistic();
        ResponseAdapter.enableStat(true);
        if (!sSetupSocketTrafficStatistic) {
            HttpCounter.getInstance().init();
            SocketCounter.getInstance().init();
            CountingTLSSocketInstrument.initialize();
            CountingPlainSocketInstrument.initialize();
            sSetupSocketTrafficStatistic = true;
        }
        return this;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IConfig
    public int readTimeout() {
        return this.mCurrentClient.readTimeoutMillis();
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IConfig
    public int retryCount() {
        return wb.h().j();
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IConfig
    public int writeTimeout() {
        return this.mCurrentClient.writeTimeoutMillis();
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IConfig
    public IConfig connectTimeout(int i) {
        this.mBuilder.connectTimeout(i, TimeUnit.MILLISECONDS);
        return this;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IConfig
    public IConfig dnsTimeout(int i) {
        TimeoutDns.timeout(i);
        this.mBuilder.dns(TimeoutDns.getInstance());
        return this;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IConfig
    public IConfig readTimeout(int i) {
        this.mBuilder.readTimeout(i, TimeUnit.MILLISECONDS);
        return this;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IConfig
    public IConfig retryCount(int i) {
        if (i >= 0) {
            if (i != this.mRetryCount) {
                this.mRetryCount = i;
            }
            return this;
        }
        throw new IllegalArgumentException("Invalid retry count!");
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IConfig
    public IConfig writeTimeout(int i) {
        this.mBuilder.writeTimeout(i, TimeUnit.MILLISECONDS);
        return this;
    }
}
