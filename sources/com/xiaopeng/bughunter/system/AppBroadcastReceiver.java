package com.xiaopeng.bughunter.system;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.UserHandle;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class AppBroadcastReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        tf.l("AppBroadcastReceiver", "action =" + action);
        if (!TextUtils.isEmpty(action) && "android.intent.action.BOOT_COMPLETED".equals(action)) {
            Intent intent2 = new Intent(context, ErrorInterceptService.class);
            intent2.setAction("android.intent.action.BOOT_COMPLETED");
            context.startServiceAsUser(intent2, UserHandle.CURRENT);
            context.startServiceAsUser(new Intent(context, CrashDetectService.class), UserHandle.CURRENT);
            context.startServiceAsUser(new Intent(context, KeepAliveService.class), UserHandle.CURRENT);
        }
    }
}
