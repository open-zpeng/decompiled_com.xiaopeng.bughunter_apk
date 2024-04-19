package defpackage;

import android.os.SystemProperties;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.irdeto.securesdk.core.SSUtils;
import com.xiaopeng.bughunter.App;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.remotestorage.Callback;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.remotestorage.IRemoteStorage;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.remotestorage.StorageException;
import com.xiaopeng.lib.framework.netchannelmodule.NetworkChannelsEntry;
import com.xiaopeng.lib.framework.netchannelmodule.http.xmart.bizapi.BizConstants;
import com.xiaopeng.lib.http.CommonUtils;
import com.xiaopeng.lib.http.Security;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* compiled from: KeyPressModel.java */
/* renamed from: rd  reason: default package */
/* loaded from: classes.dex */
public class rd {
    private static final String a;
    private static final String b;
    private static final boolean c;
    private static String d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: KeyPressModel.java */
    /* renamed from: rd$a */
    /* loaded from: classes.dex */
    public class a implements Callback {
        final /* synthetic */ File a;

        a(File file) {
            this.a = file;
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.remotestorage.Callback
        public void onFailure(String str, String str2, StorageException storageException) {
            rd.this.e(this.a, storageException);
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.remotestorage.Callback
        public void onStart(String str, String str2) {
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.remotestorage.Callback
        public void onSuccess(String str, String str2) {
            rd.this.f(this.a);
        }
    }

    static {
        String str = gg.h() ? "xp-log-local" : "xp-log";
        a = str;
        b = "http://" + str + ".oss-cn-hangzhou.aliyuncs.com/";
        c = gg.g();
    }

    public rd() {
        App.b().c();
    }

    private int d(String[] strArr, int i) {
        String str = strArr[i];
        int lastIndexOf = str.lastIndexOf(" ");
        if (lastIndexOf > 0) {
            str = str.substring(lastIndexOf).trim();
        }
        return Integer.parseInt(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(File file, Exception exc) {
        sf.c(file.getAbsolutePath());
        tf.t("KeyPressModel", "upload keyPressLog failed and exception: ", exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(File file) {
        sf.c(file.getAbsolutePath());
        tf.l("KeyPressModel", "upload " + file.getAbsolutePath() + " successfully");
    }

    /* JADX WARN: Code restructure failed: missing block: B:72:0x02d9, code lost:
        if (r17 == null) goto L51;
     */
    /* JADX WARN: Removed duplicated region for block: B:79:0x02f0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void g(java.util.List<java.lang.String> r24) {
        /*
            Method dump skipped, instructions count: 756
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.rd.g(java.util.List):void");
    }

    private void h(String str, List<String> list) {
        long currentTimeMillis;
        try {
            File f = bg.f("/data/Log/keyPressLog.zip", list);
            File file = new File("/data/Log/KeyPressLog_en.zip");
            if (!eg.c(f, file, "@!chxpzi#0109$+/")) {
                tf.s("KeyPressModel", "encrypt KeyPressLog failed");
                sf.c("/data/Log/keyPressLog.zip");
                sf.c("/data/Log/KeyPressLog_en.zip");
                return;
            }
            sf.c("/data/Log/keyPressLog.zip");
            tf.l("KeyPressModel", "keyPress triggers to upload file:" + f.getAbsolutePath());
            IRemoteStorage iRemoteStorage = (IRemoteStorage) Module.get(NetworkChannelsEntry.class).get(IRemoteStorage.class);
            try {
                iRemoteStorage.initWithContext(App.b());
                String str2 = "log/" + gg.e() + "/" + rf.c(currentTimeMillis) + "/" + yf.c() + "/" + System.currentTimeMillis() + "_en.zip";
                HashMap hashMap = new HashMap();
                hashMap.put("callbackUrl", "https://v-callback.xiaopeng.com/oss/vehicle/oss/callback/feedback");
                HashMap hashMap2 = new HashMap();
                hashMap2.put("address", b + str2);
                hashMap2.put(SSUtils.O0000Ooo, yf.g());
                hashMap2.put("vid", String.valueOf(yf.h()));
                hashMap2.put("device", yf.c());
                try {
                    hashMap2.put("vmodel", hg.a());
                    hashMap2.put("stage_type", App.b().c().getHardwareCarStage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                hashMap2.put("mcu_ver", TextUtils.isEmpty(d) ? c() : d);
                long currentTimeMillis2 = System.currentTimeMillis();
                hashMap2.put("timestamp", String.valueOf(currentTimeMillis2));
                hashMap2.put("app_id", CommonUtils.CAR_APP_ID);
                hashMap2.put("timer", String.valueOf(currentTimeMillis2));
                hashMap2.put("type", String.valueOf(1));
                hashMap2.put("sid", yf.f());
                hashMap2.put("network", String.valueOf(vf.b(App.b())));
                hashMap2.put("msg", str);
                hashMap2.put("sign", Security.sign(App.b(), hashMap2, currentTimeMillis2));
                String json = new Gson().toJson(hashMap2);
                if (c) {
                    tf.l("KeyPressModel", "callbackBody--->" + json);
                }
                hashMap.put("callbackBody", json);
                hashMap.put("callbackBodyType", BizConstants.CONTENT_TYPE_JSON);
                try {
                    iRemoteStorage.uploadWithPathAndCallback(a, str2, file.getAbsolutePath(), new a(file), hashMap);
                } catch (Exception e2) {
                    e(file, e2);
                }
            } catch (Exception e3) {
                tf.f("KeyPressModel", "Failed to initialize the remote storage:" + e3);
                sf.c("/data/Log/KeyPressLog_en.zip");
            }
        } catch (IOException e4) {
            tf.s("KeyPressModel", "exception occurs when zip KeyPressLog: " + e4);
        }
    }

    public String c() {
        String str = SystemProperties.get("sys.mcu.version");
        d = str;
        return str;
    }

    public void i() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("/data/Log/log0");
        g(arrayList);
    }
}
