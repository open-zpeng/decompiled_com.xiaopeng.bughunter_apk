package defpackage;

import com.xiaopeng.bughunter.App;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog;
/* compiled from: CrashDetectModel.java */
/* renamed from: md  reason: default package */
/* loaded from: classes.dex */
public class md {
    private final String a = "flag_system_crash";

    private void c() {
        xf.b(App.b()).j("flag_system_crash", 1);
    }

    public void a() {
        IDataLog iDataLog = (IDataLog) Module.get(se.class).get(IDataLog.class);
        if (xf.b(App.b()).c("flag_system_crash") == 1) {
            if (!fe.c()) {
                iDataLog.sendStatData(iDataLog.buildStat().setEventName("crash_detect").setProperty("reboot", true).setProperty("is_eng", gg.g()).build());
            }
        } else if (!fe.c()) {
            iDataLog.sendStatData(iDataLog.buildStat().setEventName("crash_detect").setProperty("reboot", false).setProperty("is_eng", gg.g()).build());
        }
        c();
    }

    public void b() {
        xf.b(App.b()).j("flag_system_crash", 0);
    }
}
