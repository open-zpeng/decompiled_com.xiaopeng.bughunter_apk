package defpackage;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.util.Pair;
import com.xiaopeng.bughunter.App;
import com.xiaopeng.xui.widgets.window.XWindowUtil;
import java.util.HashMap;
import java.util.List;
/* compiled from: KeepAliveModel.java */
/* renamed from: qd  reason: default package */
/* loaded from: classes.dex */
public class qd {
    private static HashMap<String, String> a;
    private static HashMap<String, Pair<String, Intent>> b;

    /* compiled from: KeepAliveModel.java */
    /* renamed from: qd$a */
    /* loaded from: classes.dex */
    class a implements Runnable {
        final /* synthetic */ String b;

        a(String str) {
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            qd.this.e(this.b);
        }
    }

    static {
        HashMap<String, String> hashMap = new HashMap<>(2, 1.0f);
        a = hashMap;
        hashMap.put(XWindowUtil.AI, "com.xiaopeng.aiassistant.home.BridgeActivity");
        a.put(XWindowUtil.CAR_AUTOPILOT, "com.xiaopeng.autopilot.base.MainActivity");
        a.put("com.xiaopeng.data.uploader", "com.xiaopeng.data.uploader.MainActivity");
        HashMap<String, Pair<String, Intent>> hashMap2 = new HashMap<>();
        b = hashMap2;
        hashMap2.put(XWindowUtil.AI, new Pair<>("receiver", de.a("intent:#Intent;action=com.xiaopeng.aiassistant.XP_WAKE_UP;package=com.xiaopeng.aiassistant;end")));
        b.put("com.xiaopeng.aiavatarservice", new Pair<>("service", de.a("intent:#Intent;component=com.xiaopeng.aiavatarservice/com.xiaopeng.aiavatarservice.AvatarService;end")));
    }

    @SuppressLint({"NewApi"})
    private boolean d(String str, Intent intent) {
        if (intent == null) {
            return false;
        }
        App b2 = App.b();
        PackageManager packageManager = b2.getPackageManager();
        str.hashCode();
        if (str.equals("receiver")) {
            List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 0);
            if (queryBroadcastReceivers != null && !queryBroadcastReceivers.isEmpty()) {
                try {
                    tf.l("KeepAliveModel", "try to sendBroadcast:" + intent);
                    b2.sendBroadcast(intent);
                } catch (Throwable th) {
                    tf.g("KeepAliveModel", "startService:" + intent, th);
                    return false;
                }
            } else {
                tf.l("KeepAliveModel", "sendBroadcast not found:" + intent);
                return false;
            }
        } else if (!str.equals("service")) {
            return false;
        } else {
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (queryIntentServices != null && !queryIntentServices.isEmpty()) {
                try {
                    tf.l("KeepAliveModel", "try to startForegroundService:" + intent);
                    b2.startForegroundService(intent);
                } catch (Throwable th2) {
                    tf.g("KeepAliveModel", "startForegroundService:" + intent, th2);
                    return false;
                }
            } else {
                tf.l("KeepAliveModel", "startForegroundService not found:" + intent);
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str) {
        tf.l("KeepAliveModel", "Try to launch " + str);
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setComponent(new ComponentName(str, a.get(str)));
        intent.setFlags(268435456);
        try {
            App.b().startActivity(intent);
        } catch (ActivityNotFoundException e) {
            throw new RuntimeException("Wrong activity setting!!!" + e);
        }
    }

    public void b(Intent intent) {
        tf.l("KeepAliveModel", "Bind " + intent.getPackage());
    }

    public void c(Intent intent) {
        String str = intent.getPackage();
        tf.l("KeepAliveModel", "Unbind " + str);
        Pair<String, Intent> pair = b.get(str);
        if ((pair != null ? d((String) pair.first, (Intent) pair.second) : false) || !a.containsKey(str)) {
            return;
        }
        ag.l(new a(str));
    }
}
