package defpackage;

import android.annotation.SuppressLint;
import android.os.SystemProperties;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
/* compiled from: IntrusionDetectModel.java */
/* renamed from: pd  reason: default package */
/* loaded from: classes.dex */
public class pd implements nd {
    private IDataLog a = (IDataLog) Module.get(se.class).get(IDataLog.class);
    private volatile CountDownLatch b;
    private volatile boolean c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IntrusionDetectModel.java */
    /* renamed from: pd$a */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        final /* synthetic */ String b;
        final /* synthetic */ long c;

        a(String str, long j) {
            this.b = str;
            this.c = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (ce.c("/sdcard/IntrusionDetection/")) {
                    ce.b("/sdcard/IntrusionDetection/");
                }
                ce.d("/sdcard/IntrusionDetection/");
                File file = new File("/data/local/tmp/ps.txt");
                if (file.exists()) {
                    file.createNewFile();
                }
                String c = ee.c("cat proc/meminfo");
                if (pd.this.j(this.b, this.c)) {
                    pd.this.l(c, this.b, this.c);
                }
                if (file.exists()) {
                    file.delete();
                }
                pd.this.b.countDown();
            } catch (Exception e) {
                pd.this.b.countDown();
                e.printStackTrace();
            }
        }
    }

    /* compiled from: IntrusionDetectModel.java */
    /* renamed from: pd$b */
    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (pd.this.c) {
                tf.a("BugHunter-IntrusionDetectModel", "collectSystemInfo is time out");
                pd.this.c = false;
                pd.this.b.countDown();
            }
        }
    }

    private void i(String str, long j) {
        ag.m(new a(str, j), 60000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j(String str, long j) {
        n();
        int i = 0;
        do {
            try {
                Thread.sleep(200L);
                if (SystemProperties.getBoolean("sys.xp.dumpcoreinfo.end", false)) {
                    sf.b("/data/local/tmp/ps.txt", "/sdcard/IntrusionDetection/process_info.txt");
                    return true;
                }
                i++;
            } catch (InterruptedException e) {
                b(str, j);
                e.printStackTrace();
                return false;
            }
        } while (i != 10);
        tf.a("BugHunter-IntrusionDetectModel", "Waiting trigger is time out!");
        b(str, j);
        return false;
    }

    @SuppressLint({"DefaultLocale"})
    private IMoleEventBuilder k(String str, long j) {
        tf.a("BugHunter-IntrusionDetectModel", String.format("getSystemInfoStatData: vincode = %s, cduID = %s, installedTime = %d, packageName = %s", yf.g(), yf.c(), Long.valueOf(j), str));
        return this.a.buildMoleEvent().setEvent("system_resources_info").setPageId("P00001").setButtonId("B001").setProperty("installedTime", Long.valueOf(j)).setProperty("packageName", str).setProperty("vincode", yf.g()).setProperty("cduId", yf.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(String str, String str2, long j) {
        try {
            sf.e(str, "/sdcard/IntrusionDetection/", "memory_info.txt");
            tf.a("BugHunter-IntrusionDetectModel", "saveInfo2LocalStorage: save memory_info.txt success!");
            ArrayList arrayList = new ArrayList();
            arrayList.add("/sdcard/IntrusionDetection/");
            m(k(str2, j), arrayList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void m(IMoleEventBuilder iMoleEventBuilder, List<String> list) {
        String[] g = be.g(list);
        String str = g[0];
        String str2 = g[1];
        String str3 = g[2];
        tf.a("BugHunter-IntrusionDetectModel", "sendStatDataAndUploadFiles: logAddress = " + str);
        iMoleEventBuilder.setProperty("address", str);
        this.a.sendStatData(iMoleEventBuilder.build());
        be.h(str2, str3);
    }

    private void n() {
        sf.e("p", "/sys/touch_debug/", "is_trigger");
    }

    @Override // defpackage.nd
    public void a(String str, long j) {
        this.b = new CountDownLatch(1);
        this.c = true;
        try {
            i(str, j);
            b bVar = new b();
            ag.m(bVar, 90000L);
            this.b.await();
            ag.n(bVar);
            this.c = false;
        } catch (Exception e) {
            this.c = false;
            e.printStackTrace();
        }
    }

    @Override // defpackage.nd
    public void b(String str, long j) {
        this.a.sendStatData(k(str, j).setProperty("address", "").build());
    }

    @Override // defpackage.nd
    public boolean c() {
        return this.c;
    }
}
