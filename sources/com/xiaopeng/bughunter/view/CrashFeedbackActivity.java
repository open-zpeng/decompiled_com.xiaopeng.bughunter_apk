package com.xiaopeng.bughunter.view;

import android.app.Activity;
import android.app.ApplicationErrorReport;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.xiaopeng.bughunter.R;
/* loaded from: classes.dex */
public class CrashFeedbackActivity extends Activity {
    private static final String b = CrashFeedbackActivity.class.getSimpleName();
    ApplicationErrorReport c;
    Button d;
    Button e;
    TextView f;
    TextView g;
    ViewGroup h;
    private BroadcastReceiver i = new a();

    /* loaded from: classes.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            CrashFeedbackActivity.this.g();
        }
    }

    /* loaded from: classes.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CrashFeedbackActivity.this.finish();
        }
    }

    /* loaded from: classes.dex */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CrashFeedbackActivity.this.h();
        }
    }

    private String c() {
        ApplicationErrorReport.AnrInfo anrInfo;
        String str;
        String str2;
        ApplicationErrorReport applicationErrorReport = this.c;
        if (applicationErrorReport != null) {
            int i = applicationErrorReport.type;
            if (i != 1) {
                return (i != 2 || (anrInfo = applicationErrorReport.anrInfo) == null || (str = anrInfo.info) == null) ? "" : str;
            }
            ApplicationErrorReport.CrashInfo crashInfo = applicationErrorReport.crashInfo;
            return (crashInfo == null || (str2 = crashInfo.stackTrace) == null) ? "" : str2;
        }
        return "";
    }

    private String d() {
        ApplicationErrorReport applicationErrorReport = this.c;
        if (applicationErrorReport == null) {
            return "";
        }
        int i = applicationErrorReport.type;
        if (i == 1) {
            return "[CRASH] " + this.c.packageName + " threw " + this.c.crashInfo.exceptionClassName;
        } else if (i == 2) {
            return "[ANR] " + this.c.packageName + " ANR reason:  " + this.c.anrInfo.cause;
        } else {
            return "";
        }
    }

    private void e(Intent intent) {
        if (intent == null) {
            return;
        }
        this.c = (ApplicationErrorReport) intent.getParcelableExtra("android.intent.extra.BUG_REPORT");
        this.f.setText(d());
        this.g.setText(c());
    }

    private boolean f() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        boolean f = f();
        String str = b;
        Log.d(str, "onNetworkAvailabilityChange(), available: " + f);
        ViewGroup viewGroup = this.h;
        if (viewGroup != null) {
            viewGroup.setVisibility(f ? 8 : 0);
        }
        Button button = this.e;
        if (button != null) {
            button.setEnabled(f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        finish();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.submit_crash);
        this.d = (Button) findViewById(R.id.cancel);
        this.e = (Button) findViewById(R.id.submit);
        this.f = (TextView) findViewById(R.id.subject);
        this.g = (TextView) findViewById(R.id.content);
        this.h = (ViewGroup) findViewById(R.id.no_network_warning);
        this.d.setOnClickListener(new b());
        this.e.setOnClickListener(new c());
        e(getIntent());
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        e(intent);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        unregisterReceiver(this.i);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        registerReceiver(this.i, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        g();
    }
}
