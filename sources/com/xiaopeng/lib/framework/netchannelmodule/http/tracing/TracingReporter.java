package com.xiaopeng.lib.framework.netchannelmodule.http.tracing;

import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEventBuilder;
import com.xiaopeng.lib.framework.netchannelmodule.common.GlobalConfig;
import zipkin2.Span;
import zipkin2.reporter.Reporter;
/* loaded from: classes.dex */
public class TracingReporter implements Reporter<Span> {
    private static final String TAG = "Tracer";

    /* JADX INFO: Access modifiers changed from: package-private */
    public TracingReporter() {
        Module.register(se.class, new se(GlobalConfig.getApplicationContext()));
    }

    @Override // zipkin2.reporter.Reporter
    public void report(Span span) {
        String span2 = span.toString();
        tf.a(TAG, "report:" + span2);
        IDataLog iDataLog = (IDataLog) Module.get(se.class).get(IDataLog.class);
        IStatEventBuilder eventName = iDataLog.buildStat().setEventName("data_tracing");
        iDataLog.sendStatData(eventName.setProperty("data", "[" + span2 + "]").build());
    }
}
