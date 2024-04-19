package com.xiaopeng.bughunter.system;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* compiled from: AppPackageAddedBroadcastReceiver.java */
/* loaded from: classes.dex */
public class a extends BroadcastReceiver {
    private String a(String str) {
        return (str == null || !str.contains("package:")) ? str : str.substring(str.indexOf(":") + 1);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.PACKAGE_ADDED")) {
            tf.a("AppPackageAddedBroadcastReceiver", "onReceive: intent = " + intent);
            String a = a(intent.getDataString());
            String c = zd.c(a);
            long currentTimeMillis = System.currentTimeMillis();
            if (zd.d(a, c)) {
                return;
            }
            vd.b().d(a, currentTimeMillis);
        }
    }
}
