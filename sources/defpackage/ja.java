package defpackage;

import android.text.TextUtils;
import org.json.JSONObject;
/* compiled from: SystemConfig.java */
/* renamed from: ja  reason: default package */
/* loaded from: classes.dex */
public class ja {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SystemConfig.java */
    /* renamed from: ja$a */
    /* loaded from: classes.dex */
    public static class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            oa.e().j();
        }
    }

    public static int a() {
        JSONObject jSONObject;
        String m = fa.m();
        if (TextUtils.isEmpty(m)) {
            return 0;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(m);
            if (jSONObject2.has("SYSTEM") && (jSONObject = jSONObject2.getJSONObject("SYSTEM")) != null && jSONObject.has("cdb")) {
                return jSONObject.getInt("cdb");
            }
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("SYSTEM")) {
                ya.c("SystemConfig", "server system config ", str);
                JSONObject optJSONObject = jSONObject.optJSONObject("SYSTEM");
                if (optJSONObject != null) {
                    try {
                        if (optJSONObject.has("bg_interval")) {
                            fa.n(optJSONObject.getInt("bg_interval") + "");
                        }
                    } catch (Throwable unused) {
                    }
                    try {
                        if (optJSONObject.has("fg_interval")) {
                            fa.o(optJSONObject.getInt("fg_interval") + "");
                        }
                    } catch (Throwable unused2) {
                    }
                    ya.c("SystemConfig", "UTDC.bSendToNewLogStore:", Boolean.valueOf(ea.g));
                    ya.c("SystemConfig", "Config.BACKGROUND_PERIOD:", Long.valueOf(fa.f()));
                    ya.c("SystemConfig", "Config.FOREGROUND_PERIOD:", Long.valueOf(fa.a()));
                    try {
                        if (optJSONObject.has("discard")) {
                            int i = optJSONObject.getInt("discard");
                            if (i == 1) {
                                fa.g = true;
                                ub.d().g();
                            } else if (i == 0) {
                                fa.g = false;
                                ub.d().f();
                            }
                        } else if (fa.g) {
                            fa.g = false;
                            ub.d().f();
                        }
                    } catch (Throwable unused3) {
                    }
                    try {
                        if (!optJSONObject.has("cdb") || optJSONObject.getInt("cdb") <= a()) {
                            return;
                        }
                        ib.a().g(new a());
                    } catch (Throwable unused4) {
                    }
                }
            }
        } catch (Throwable th) {
            ya.b("SystemConfig", "updateconfig", th);
        }
    }
}
