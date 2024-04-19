package com.xiaopeng.bughunter.system;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.xiaopeng.bughunter.App;
import com.xiaopeng.bughunter.R;
/* compiled from: UploadDataLogReceiver.java */
/* loaded from: classes.dex */
public class c extends BroadcastReceiver {
    private static xd a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UploadDataLogReceiver.java */
    /* loaded from: classes.dex */
    public static class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Toast.makeText(App.b(), App.b().getResources().getText(R.string.log_already_uploaded), 0).show();
        }
    }

    public c() {
        Log.i("UploadDataLogReceiver", "BugHunter_UploadData_UploadDataLogReceiver init");
        a = new xd();
    }

    private static boolean a(Intent intent) {
        if (fe.c()) {
            tf.l("UploadDataLogReceiver", "InternaltionVer can not upload all logs in /data/Log/log0");
            return false;
        } else if (intent != null) {
            return "com.xiaopeng.scu.ACTION_UP_LOAD_CAN_LOG_CS".equals(intent.getAction()) || "com.xiaopeng.scu.ACTION_UP_LOAD_CAN_LOG".equals(intent.getAction()) || "android.intent.action.MAIN".equals(intent.getAction());
        } else {
            return false;
        }
    }

    private void b(Context context, Intent intent) {
        d(intent);
    }

    private static void c() {
        a.a();
        Log.i("UploadDataLogReceiver", "uploadLog uploadLog finish!");
        if (Looper.myLooper() == Looper.getMainLooper()) {
            Toast.makeText(App.b(), App.b().getResources().getText(R.string.log_already_uploaded), 0).show();
        } else {
            new Handler(Looper.getMainLooper()).post(new a());
        }
    }

    public static void d(Intent intent) {
        if (a(intent)) {
            tf.l("UploadDataLogReceiver", "uploadLog by intent");
            c();
            return;
        }
        tf.l("UploadDataLogReceiver", "should not uploadLog");
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        tf.l("UploadDataLogReceiver", "BugHunter_UploadData_ action =" + action);
        if (TextUtils.isEmpty(action)) {
            return;
        }
        if ("com.xiaopeng.scu.ACTION_UP_LOAD_CAN_LOG".equals(intent.getAction())) {
            tf.l("UploadDataLogReceiver", "ACTION_CONBIND_KEY_UPLOAD_LOG");
            b(context, intent);
        } else if ("com.xiaopeng.scu.ACTION_UP_LOAD_CAN_LOG_CS".equals(intent.getAction())) {
            tf.l("UploadDataLogReceiver", "ACTION_CONBIND_KEY_UPLOAD_LOG_CS");
            b(context, intent);
        }
    }
}
