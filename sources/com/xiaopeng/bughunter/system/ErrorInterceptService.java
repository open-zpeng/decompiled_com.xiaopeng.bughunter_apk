package com.xiaopeng.bughunter.system;

import android.app.ApplicationErrorReport;
import android.app.IntentService;
import android.content.Intent;
import com.xiaopeng.bughunter.App;
/* loaded from: classes.dex */
public class ErrorInterceptService extends IntentService {
    private ud b;

    public ErrorInterceptService() {
        super("ErrorInterceptService");
        tf.l("ErrorInterceptService", "new ErrorInterceptService");
        this.b = new yd();
    }

    private void a(Intent intent) {
        if (intent == null) {
            return;
        }
        ApplicationErrorReport applicationErrorReport = (ApplicationErrorReport) intent.getParcelableExtra("android.intent.extra.BUG_REPORT");
        if (intent.getBooleanExtra("com.xiaopeng.bughunger.extra.boolean.LOG_UPLOAD", false)) {
            tf.l("ErrorInterceptService", "handleIncomingCrashReport: isNapaError");
            this.b.f(getApplicationContext(), applicationErrorReport);
        } else if (intent.getBooleanExtra("android.intent.extra.boolean.NATIVE_REPORT", false)) {
            tf.l("ErrorInterceptService", "handleIncomingCrashReport: isNativeProcessCrash");
            this.b.b(applicationErrorReport);
        } else if (applicationErrorReport != null) {
            this.b.a(getApplicationContext(), applicationErrorReport);
        } else {
            tf.l("ErrorInterceptService", "handleIncomingCrashReport errorReport = " + ((Object) null));
        }
    }

    @Override // android.app.IntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
        tf.l("ErrorInterceptService", "onCreate");
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            tf.l("ErrorInterceptService", "action-->" + action);
            if ("android.intent.action.APP_ERROR".equals(action)) {
                a(intent);
            } else if ("android.intent.action.BOOT_COMPLETED".equals(action)) {
                this.b.c(App.b());
                this.b.d(getApplicationContext());
            }
        }
    }
}
