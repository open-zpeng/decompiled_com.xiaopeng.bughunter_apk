package defpackage;

import android.app.ApplicationErrorReport;
import android.car.Car;
import android.car.hardware.vcu.CarVcuManager;
import android.content.Context;
import android.os.PowerManager;
import android.os.SystemProperties;
import android.text.TextUtils;
import android.util.Log;
import com.activeandroid.Model;
import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;
import com.activeandroid.query.Update;
import com.xiaopeng.bughunter.App;
import com.xiaopeng.bughunter.bean.DevInfo;
import com.xiaopeng.bughunter.bean.ErrorInfoBean2;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.NoSuchFileException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* compiled from: ReportModel.java */
/* renamed from: sd  reason: default package */
/* loaded from: classes.dex */
public class sd implements od {
    private static Map<String, String[]> a;
    private String b;
    private IDataLog c = (IDataLog) Module.get(se.class).get(IDataLog.class);
    private boolean d = false;

    /* compiled from: ReportModel.java */
    /* renamed from: sd$a */
    /* loaded from: classes.dex */
    class a implements Runnable {
        final /* synthetic */ String b;

        a(String str) {
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            sd sdVar = sd.this;
            String str = this.b;
            sdVar.b0(str, sdVar.I(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReportModel.java */
    /* renamed from: sd$b */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        final /* synthetic */ String b;
        final /* synthetic */ List c;

        /* compiled from: ReportModel.java */
        /* renamed from: sd$b$a */
        /* loaded from: classes.dex */
        class a implements Runnable {
            final /* synthetic */ IMoleEventBuilder b;

            a(IMoleEventBuilder iMoleEventBuilder) {
                this.b = iMoleEventBuilder;
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = b.this;
                sd.this.i0(this.b, bVar.c);
            }
        }

        b(String str, List list) {
            this.b = str;
            this.c = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            IMoleEventBuilder buildMoleEvent = sd.this.c.buildMoleEvent();
            buildMoleEvent.setEvent("bug_error").setPageId("P00009").setButtonId("B001");
            buildMoleEvent.setProperty("mBrief", this.b).setProperty("mRecTime", qf.a(System.currentTimeMillis())).setProperty("mTitle", this.b).setProperty("mType", (Number) 5).setProperty("logType", (Number) 2).setProperty("srcName", "ICM").setProperty("srcType", (Number) 4).setProperty("icmVer", fe.a()).setProperty("appVer", fe.a()).setProperty("speed", Float.valueOf(sd.this.U())).setProperty("hw_version", sd.this.M());
            ag.h(2, new a(buildMoleEvent));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReportModel.java */
    /* renamed from: sd$c */
    /* loaded from: classes.dex */
    public class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            IMoleEventBuilder buildMoleEvent = sd.this.c.buildMoleEvent();
            buildMoleEvent.setEvent("bug_error").setPageId("P00009").setButtonId("B001");
            buildMoleEvent.setProperty("pm_status", ((PowerManager) App.b().getSystemService("power")).isScreenOn()).setProperty("mBrief", "systemServer error").setProperty("mRecTime", qf.a(System.currentTimeMillis())).setProperty("mTitle", "systemServer error").setProperty("mType", (Number) 3).setProperty("devInfo", sd.this.K().toString()).setProperty("logType", (Number) 2).setProperty("srcName", "com.xiaopeng.xmart.system").setProperty("srcType", (Number) 1).setProperty("appVer", gg.e()).setProperty("rebootReason", SystemProperties.get("sys.xiaopeng.reboot_reason", "")).setProperty("speed", Float.valueOf(sd.this.U())).setProperty("hw_version", sd.this.M());
            af b = af.b(App.b());
            long currentTimeMillis = System.currentTimeMillis();
            long c = b.c("last_sys_srv_fault_report_time", 0L);
            if (c == 0 || !sd.this.Z(currentTimeMillis, c)) {
                b.e("one_day_sys_srv_fault_report_count", 0L);
            }
            long c2 = b.c("one_day_sys_srv_fault_report_count", 0L);
            if (c2 < 3) {
                b.e("last_sys_srv_fault_report_time", currentTimeMillis);
                b.e("one_day_sys_srv_fault_report_count", c2 + 1);
                sd.this.h0(3, buildMoleEvent, 0L, 0);
                return;
            }
            tf.l("ReportModel", "sysErrReportCount >= MAX_SYSTEM_SERVER_FAULT_REPORT_COUNT, will not upload this system error");
        }
    }

    /* compiled from: ReportModel.java */
    /* renamed from: sd$d */
    /* loaded from: classes.dex */
    class d implements Runnable {
        final /* synthetic */ ApplicationErrorReport b;
        final /* synthetic */ Context c;

        d(ApplicationErrorReport applicationErrorReport, Context context) {
            this.b = applicationErrorReport;
            this.c = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            IMoleEventBuilder buildMoleEvent = sd.this.c.buildMoleEvent();
            buildMoleEvent.setEvent("bug_error").setPageId("P00009").setButtonId("B002");
            ApplicationErrorReport applicationErrorReport = this.b;
            ApplicationErrorReport.CrashInfo crashInfo = applicationErrorReport.crashInfo;
            if (crashInfo != null) {
                buildMoleEvent.setProperty("mBrief", crashInfo.exceptionMessage).setProperty("mInfo", this.b.crashInfo.stackTrace).setProperty("mRecTime", qf.a(this.b.time)).setProperty("mTitle", this.b.crashInfo.exceptionClassName).setProperty("mType", (Number) 1);
            } else {
                ApplicationErrorReport.AnrInfo anrInfo = applicationErrorReport.anrInfo;
                if (anrInfo != null) {
                    buildMoleEvent.setProperty("mBrief", anrInfo.cause).setProperty("mInfo", this.b.anrInfo.info).setProperty("mRecTime", qf.a(this.b.time)).setProperty("mTitle", this.b.anrInfo.activity).setProperty("mType", (Number) 2);
                } else {
                    tf.f("ReportModel", "Unknown exception, not anr either crash, throw it!");
                    if (gg.g()) {
                        throw new IllegalArgumentException("Unknown exception, not anr either crash, throw it!");
                    }
                    return;
                }
            }
            ApplicationErrorReport applicationErrorReport2 = this.b;
            String str2 = applicationErrorReport2.processName;
            try {
                str = fg.c(this.c, applicationErrorReport2.packageName);
            } catch (Exception e) {
                tf.t("ReportModel", "getAppVersion fail!", e);
                str = "Unknown";
            }
            buildMoleEvent.setProperty("logType", (Number) 2).setProperty("srcName", str2).setProperty("srcType", Integer.valueOf(this.b.systemApp ? 2 : 3)).setProperty("md5", sd.this.b).setProperty("appVer", str);
            buildMoleEvent.setProperty("pm_status", ((PowerManager) App.b().getSystemService("power")).isScreenOn());
            buildMoleEvent.setProperty("devInfo", sd.this.K().toString());
            buildMoleEvent.setProperty("speed", Float.valueOf(sd.this.U()));
            buildMoleEvent.setProperty("hw_version", sd.this.M());
            sd sdVar = sd.this;
            ApplicationErrorReport applicationErrorReport3 = this.b;
            sdVar.c0(sdVar.R(applicationErrorReport3.type, applicationErrorReport3.time), buildMoleEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReportModel.java */
    /* renamed from: sd$e */
    /* loaded from: classes.dex */
    public class e implements Runnable {
        final /* synthetic */ IMoleEventBuilder b;
        final /* synthetic */ List c;

        e(IMoleEventBuilder iMoleEventBuilder, List list) {
            this.b = iMoleEventBuilder;
            this.c = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            tf.a("ReportModel", "reportNapaError: uploadFilesAndReport");
            sd.this.i0(this.b, this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReportModel.java */
    /* renamed from: sd$f */
    /* loaded from: classes.dex */
    public class f implements Runnable {
        final /* synthetic */ ApplicationErrorReport b;

        f(ApplicationErrorReport applicationErrorReport) {
            this.b = applicationErrorReport;
        }

        @Override // java.lang.Runnable
        public void run() {
            IMoleEventBuilder buildMoleEvent = sd.this.c.buildMoleEvent();
            buildMoleEvent.setEvent("bug_error").setPageId("P00009").setButtonId("B001");
            buildMoleEvent.setProperty("pm_status", ((PowerManager) App.b().getSystemService("power")).isScreenOn()).setProperty("mBrief", "Native Process Crash").setProperty("mRecTime", qf.a(System.currentTimeMillis())).setProperty("mTitle", "Native Process Crash").setProperty("mType", (Number) 3).setProperty("devInfo", sd.this.K().toString()).setProperty("logType", (Number) 2).setProperty("srcName", this.b.processName).setProperty("srcType", (Number) 1).setProperty("appVer", gg.e()).setProperty("speed", Float.valueOf(sd.this.U())).setProperty("hw_version", sd.this.M());
            sd.this.h0(3, buildMoleEvent, 0L, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReportModel.java */
    /* renamed from: sd$g */
    /* loaded from: classes.dex */
    public class g implements Runnable {
        final /* synthetic */ long b;

        g(long j) {
            this.b = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            sd.this.J(this.b);
        }
    }

    /* compiled from: ReportModel.java */
    /* renamed from: sd$h */
    /* loaded from: classes.dex */
    class h implements Runnable {
        final /* synthetic */ ApplicationErrorReport b;
        final /* synthetic */ Context c;

        h(ApplicationErrorReport applicationErrorReport, Context context) {
            this.b = applicationErrorReport;
            this.c = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            IMoleEventBuilder buildMoleEvent = sd.this.c.buildMoleEvent();
            buildMoleEvent.setEvent("bug_error").setPageId("P00009").setButtonId("B002");
            ApplicationErrorReport applicationErrorReport = this.b;
            ApplicationErrorReport.CrashInfo crashInfo = applicationErrorReport.crashInfo;
            if (crashInfo != null) {
                buildMoleEvent.setProperty("mBrief", crashInfo.exceptionMessage).setProperty("mInfo", this.b.crashInfo.stackTrace).setProperty("mRecTime", qf.a(this.b.time)).setProperty("mTitle", this.b.crashInfo.exceptionClassName).setProperty("mType", (Number) 1);
            } else {
                ApplicationErrorReport.AnrInfo anrInfo = applicationErrorReport.anrInfo;
                if (anrInfo != null) {
                    buildMoleEvent.setProperty("mBrief", anrInfo.cause).setProperty("mInfo", this.b.anrInfo.info).setProperty("mRecTime", qf.a(this.b.time)).setProperty("mTitle", this.b.anrInfo.activity).setProperty("mType", (Number) 2);
                } else {
                    tf.f("ReportModel", "Unknown exception, not anr either crash, throw it!");
                    if (gg.g()) {
                        throw new IllegalArgumentException("Unknown exception, not anr either crash, throw it!");
                    }
                    return;
                }
            }
            ApplicationErrorReport applicationErrorReport2 = this.b;
            String str2 = applicationErrorReport2.processName;
            try {
                str = fg.c(this.c, applicationErrorReport2.packageName);
            } catch (Exception e) {
                tf.t("ReportModel", "getAppVersion fail!", e);
                str = "Unknown";
            }
            buildMoleEvent.setProperty("logType", (Number) 2).setProperty("srcName", str2).setProperty("srcType", Integer.valueOf(this.b.systemApp ? 2 : 3)).setProperty("md5", sd.this.b).setProperty("appVer", str);
            buildMoleEvent.setProperty("pm_status", ((PowerManager) App.b().getSystemService("power")).isScreenOn());
            buildMoleEvent.setProperty("devInfo", sd.this.K().toString());
            buildMoleEvent.setProperty("speed", Float.valueOf(sd.this.U()));
            buildMoleEvent.setProperty("hw_version", sd.this.M());
            if ("D55".equals(ge.g()) && "com.xiaopeng.instrument".equals(str2)) {
                buildMoleEvent.setProperty("mType", (Number) 5).setProperty("srcType", (Number) 4);
            }
            sd sdVar = sd.this;
            ApplicationErrorReport applicationErrorReport3 = this.b;
            sdVar.h0(applicationErrorReport3.type, buildMoleEvent, applicationErrorReport3.time, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReportModel.java */
    /* renamed from: sd$i */
    /* loaded from: classes.dex */
    public class i implements Runnable {
        final /* synthetic */ int b;
        final /* synthetic */ long c;
        final /* synthetic */ IMoleEventBuilder d;
        final /* synthetic */ int e;

        /* compiled from: ReportModel.java */
        /* renamed from: sd$i$a */
        /* loaded from: classes.dex */
        class a implements Runnable {
            final /* synthetic */ int b;

            a(int i) {
                this.b = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                i iVar = i.this;
                sd.this.h0(iVar.b, iVar.d, iVar.c, this.b);
            }
        }

        i(int i, long j, IMoleEventBuilder iMoleEventBuilder, int i2) {
            this.b = i;
            this.c = j;
            this.d = iMoleEventBuilder;
            this.e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            List L = sd.this.L(this.b, this.c, this.d);
            if (sd.this.Y(this.e, L)) {
                tf.l("ReportModel", "retry to get uploadFiles " + this.e + " times");
                ag.k(2, new a(this.e + 1), 1000L);
            } else if (L != null && L.size() > 0) {
                sd.this.f0(this.d, L);
                Log.d("ReportModel", "the filePaths--->" + L);
            } else {
                tf.l("ReportModel", "getErrorLogFiles return empty, start to uploadCdu");
                if (fe.c()) {
                    return;
                }
                sd.this.c.sendStatData(this.d.build());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReportModel.java */
    /* renamed from: sd$j */
    /* loaded from: classes.dex */
    public class j implements Runnable {
        final /* synthetic */ List b;
        final /* synthetic */ IMoleEventBuilder c;

        j(List list, IMoleEventBuilder iMoleEventBuilder) {
            this.b = list;
            this.c = iMoleEventBuilder;
        }

        @Override // java.lang.Runnable
        public void run() {
            List list = this.b;
            if (list != null && list.size() > 0) {
                sd.this.f0(this.c, this.b);
                Log.d("ReportModel", "the filePaths--->" + this.b);
                return;
            }
            tf.l("ReportModel", "uploadFiles are empty, start to uploadCdu");
            if (fe.c()) {
                return;
            }
            sd.this.c.sendStatData(this.c.build());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReportModel.java */
    /* renamed from: sd$k */
    /* loaded from: classes.dex */
    public class k implements FilenameFilter {
        final /* synthetic */ long a;
        final /* synthetic */ int b;

        k(long j, int i) {
            this.a = j;
            this.b = i;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            if (str.contains(String.valueOf(this.a))) {
                if (str.contains(this.b == 1 ? "crash" : "anr")) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReportModel.java */
    /* renamed from: sd$l */
    /* loaded from: classes.dex */
    public class l implements FilenameFilter {
        l() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return sd.this.a0(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReportModel.java */
    /* renamed from: sd$m */
    /* loaded from: classes.dex */
    public class m implements FilenameFilter {
        m() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.startsWith("system_server_watchdog@");
        }
    }

    /* compiled from: ReportModel.java */
    /* renamed from: sd$n */
    /* loaded from: classes.dex */
    class n implements Runnable {
        final /* synthetic */ IMoleEventBuilder b;

        n(IMoleEventBuilder iMoleEventBuilder) {
            this.b = iMoleEventBuilder;
        }

        @Override // java.lang.Runnable
        public void run() {
            sd.this.h0(4, this.b, 0L, 0);
        }
    }

    /* compiled from: ReportModel.java */
    /* renamed from: sd$o */
    /* loaded from: classes.dex */
    class o implements Runnable {
        o() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int i = SystemProperties.getInt("sys.system_server.start_count", 0);
            tf.l("ReportModel", "start_count: " + i);
            if (i > 1) {
                tf.l("ReportModel", "check system error, reportSystemServer!");
                sd.this.e0();
            }
        }
    }

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put("system reboot", new String[]{"/data/Log/log1/kernel.txt", "/data/Log/log0/last_kmsg.txt", "/data/Log/log1/radio.txt", "/data/Log/log0/radio.txt"});
        a.put("audio crash", new String[]{"/data/Log/log0/main.txt", "/data/crash/audio"});
        a.put("carservice crash", new String[]{"/data/Log/log0/radio.txt", "/data/crash/carservice"});
        a.put("ota_app_icm crash", new String[]{"/data/Log/log0/system.txt", "/data/crash/ota_app_icm"});
        a.put("ECluster crash", new String[]{"/data/Log/log0/main.txt", "/data/Log/log0/system.txt", "/data/crash/ECluster"});
        a.put("dbus-daemon crash", new String[]{"/data/crash/dbus-daemon"});
    }

    private void A(List<String> list) {
        File[] listFiles = new File("/data/system/dropbox").listFiles();
        if (listFiles == null || listFiles.length <= 0) {
            return;
        }
        for (File file : listFiles) {
            list.add(file.getAbsolutePath());
        }
    }

    private void B(List<String> list) {
        String N = N();
        if (TextUtils.isEmpty(N)) {
            return;
        }
        list.add(N);
    }

    private void C(IMoleEventBuilder iMoleEventBuilder, List<String> list, File... fileArr) {
        String str;
        if ("D55".equals(ge.g())) {
            try {
                str = new JSONObject(iMoleEventBuilder.build().toJson()).getString("srcName");
            } catch (Exception e2) {
                tf.i("ReportModel", e2);
                str = "";
            }
            if ("com.xiaopeng.instrument".equals(str)) {
                z(list, fileArr);
                D(list);
                B(list);
            }
        }
    }

    private void D(List<String> list) {
        File[] listFiles = new File("/data/tombstones/").listFiles();
        if (listFiles == null || listFiles.length <= 0) {
            return;
        }
        for (File file : listFiles) {
            list.add(file.getAbsolutePath());
        }
    }

    private void E() {
        af b2 = af.b(App.b());
        long currentTimeMillis = System.currentTimeMillis();
        long c2 = b2.c("last_check_expired_time", 0L);
        if (c2 == 0) {
            b2.e("last_check_expired_time", currentTimeMillis);
            return;
        }
        long j2 = currentTimeMillis - c2;
        if (j2 >= 604800000) {
            ag.i(new g(currentTimeMillis));
            b2.e("last_check_expired_time", currentTimeMillis);
        } else if (j2 < 0) {
            b2.e("last_check_expired_time", currentTimeMillis);
        }
    }

    private void F(int i2, int i3, af afVar) {
        boolean a2 = afVar.a("exceed_reported", false);
        this.d = a2;
        if (a2 || i2 < 30) {
            return;
        }
        this.d = true;
        afVar.d("exceed_reported", true);
        if (fe.c()) {
            return;
        }
        IDataLog iDataLog = this.c;
        iDataLog.sendStatData(iDataLog.buildStat().setEventName("bug_apperror_exceedmax_oneday").setProperty("maxValue", Integer.valueOf(i3)).build());
    }

    private ErrorInfoBean2 G(long j2, String str, String str2, int i2, int i3) {
        Model model;
        this.b = uf.a(str);
        try {
            model = new Select().from(ErrorInfoBean2.class).where("md5=? and packageName=?", this.b, str2).executeSingle();
        } catch (Exception e2) {
            tf.f("ReportModel", "select from DB occurs exception-->" + e2.getMessage());
            model = null;
        }
        if (model == null) {
            try {
                new ErrorInfoBean2(j2, this.b, 1L, str2, i2, i3, !this.d).save();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            return null;
        }
        ErrorInfoBean2 errorInfoBean2 = (ErrorInfoBean2) model;
        long count = errorInfoBean2.getCount() + 1;
        try {
            int i4 = errorInfoBean2.isReported() ? 1 : 0;
            if (!this.d && i4 == 0) {
                i4 = 1;
            }
            new Update(ErrorInfoBean2.class).set("count=?, lastTime=?, reported=?", Long.valueOf(count), Long.valueOf(j2), Integer.valueOf(i4)).where("md5=? and packageName=?", this.b, str2).execute();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return errorInfoBean2;
    }

    private boolean H() {
        FileInputStream fileInputStream;
        InputStreamReader inputStreamReader;
        Exception e2;
        IOException e3;
        NoSuchFileException e4;
        BufferedReader bufferedReader = null;
        boolean z = false;
        try {
            try {
            } catch (Throwable th) {
                th = th;
            }
        } catch (NoSuchFileException e5) {
            inputStreamReader = null;
            e4 = e5;
            fileInputStream = null;
        } catch (IOException e6) {
            inputStreamReader = null;
            e3 = e6;
            fileInputStream = null;
        } catch (Exception e7) {
            inputStreamReader = null;
            e2 = e7;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
            inputStreamReader = null;
        }
        if (fe.b()) {
            boolean c2 = ce.c("/data/Log/log0/rawdump.gz");
            sf.a(null);
            sf.a(null);
            sf.a(null);
            return c2;
        }
        fileInputStream = new FileInputStream("data/Log/log0/last_kmsg.txt");
        try {
            inputStreamReader = new InputStreamReader(fileInputStream);
            try {
                BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader);
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null || z) {
                            break;
                        } else if (readLine.contains("Kernel panic - not syncing") || readLine.contains("Watchdog bark!")) {
                            z = true;
                        }
                    } catch (NoSuchFileException e8) {
                        e4 = e8;
                        bufferedReader = bufferedReader2;
                        e4.printStackTrace();
                        sf.a(bufferedReader);
                        sf.a(inputStreamReader);
                        sf.a(fileInputStream);
                        return z;
                    } catch (IOException e9) {
                        e3 = e9;
                        bufferedReader = bufferedReader2;
                        e3.printStackTrace();
                        sf.a(bufferedReader);
                        sf.a(inputStreamReader);
                        sf.a(fileInputStream);
                        return z;
                    } catch (Exception e10) {
                        e2 = e10;
                        bufferedReader = bufferedReader2;
                        e2.printStackTrace();
                        sf.a(bufferedReader);
                        sf.a(inputStreamReader);
                        sf.a(fileInputStream);
                        return z;
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedReader = bufferedReader2;
                        sf.a(bufferedReader);
                        sf.a(inputStreamReader);
                        sf.a(fileInputStream);
                        throw th;
                    }
                }
                sf.a(bufferedReader2);
            } catch (NoSuchFileException e11) {
                e4 = e11;
            } catch (IOException e12) {
                e3 = e12;
            } catch (Exception e13) {
                e2 = e13;
            }
        } catch (NoSuchFileException e14) {
            e4 = e14;
            inputStreamReader = null;
        } catch (IOException e15) {
            e3 = e15;
            inputStreamReader = null;
        } catch (Exception e16) {
            e2 = e16;
            inputStreamReader = null;
        } catch (Throwable th4) {
            th = th4;
            inputStreamReader = null;
        }
        sf.a(inputStreamReader);
        sf.a(fileInputStream);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> I(String str) {
        ArrayList arrayList = new ArrayList();
        ce.d("/cache/icm/");
        String[] strArr = a.get(str);
        if (strArr != null && strArr.length > 0) {
            String str2 = "/data/" + str.replace(" ", "") + "_" + System.currentTimeMillis() + ".tar.gz";
            String c2 = ae.c("/system/bin/ssh -v root@172.20.1.40", str2, strArr);
            if (!ee.a(c2, "Exit status 0")) {
                tf.f("ReportModel", "execCommand fail : " + c2);
                return null;
            }
            String b2 = ae.b("root", "172.20.1.40", new String[]{str2}, "/cache/icm/");
            if (!ee.a(b2, "Exit status 0")) {
                tf.f("ReportModel", "execCommand fail : " + b2);
                return null;
            }
            String a2 = ae.a("/system/bin/ssh -v root@172.20.1.40", str2);
            if (!ee.a(a2, "Exit status 0")) {
                tf.f("ReportModel", "execCommand fail : " + a2);
            }
            arrayList.add(str2.replace("/data/", "/cache/icm/"));
            return arrayList;
        }
        tf.s("ReportModel", "relative icm crash log with tag is null");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(long j2) {
        try {
            tf.l("ReportModel", "deleteExpiredAppCrashRecord");
            new Delete().from(ErrorInfoBean2.class).where("lastTime < ?", Long.valueOf(j2 - 1296000000)).execute();
        } catch (Exception e2) {
            tf.l("ReportModel", "deleteExpiredAppCrashRecord, delete from DB occurs exception--> " + e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DevInfo K() {
        DevInfo devInfo = new DevInfo();
        devInfo.setNetworkType(vf.b(App.b()));
        devInfo.setNetworkState(vf.a(App.b()));
        devInfo.setSystemMemory(wf.c(App.b()));
        devInfo.setMemoryAllAllocated(devInfo.getSystemMemory() - wf.b(App.b()));
        devInfo.setMemoryAllocated(wf.a(App.b()));
        int[] T = T();
        if (T != null && T.length > 1) {
            devInfo.setUserCpu(T[0]);
            devInfo.setSysCpu(T[1]);
        }
        return devInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> L(int i2, long j2, IMoleEventBuilder iMoleEventBuilder) {
        File file = new File("/data/Log/log0/");
        File file2 = new File("/data/Log/log1/");
        if (i2 == 1) {
            List<String> P = P(i2, j2);
            C(iMoleEventBuilder, P, file, file2);
            return P;
        } else if (i2 != 2) {
            if (i2 == 3) {
                ArrayList arrayList = new ArrayList();
                z(arrayList, file, file2);
                A(arrayList);
                y(arrayList);
                D(arrayList);
                B(arrayList);
                return arrayList;
            } else if (i2 != 4) {
                return null;
            } else {
                ArrayList arrayList2 = new ArrayList();
                z(arrayList2, file, file2);
                if (fe.b()) {
                    arrayList2.add("/data/Log/log0/rawdump.gz");
                    return arrayList2;
                }
                return arrayList2;
            }
        } else {
            return P(i2, j2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String M() {
        String d2 = yf.d();
        Log.i("ReportModel", "getHwVersion :\t" + d2);
        return d2;
    }

    private String N() {
        File[] listFiles = new File("/data/system/dropbox").listFiles(new m());
        if (listFiles == null || listFiles.length == 0) {
            return null;
        }
        int i2 = 0;
        String replace = listFiles[0].getName().replace("system_server_watchdog@", "").replace(".txt.gz", "");
        for (int i3 = 1; i3 < listFiles.length; i3++) {
            String replace2 = listFiles[i3].getName().replace("system_server_watchdog@", "").replace(".txt.gz", "");
            if (replace2.compareTo(replace) > 0) {
                i2 = i3;
                replace = replace2;
            }
        }
        return listFiles[i2].getAbsolutePath();
    }

    private File[] O(long j2, int i2) {
        return new File("/data/system/dropbox").listFiles(new k(j2, i2));
    }

    private List<String> P(int i2, long j2) {
        ArrayList arrayList = new ArrayList();
        File[] O = O(j2, i2);
        if (O != null && O.length > 0) {
            for (File file : O) {
                arrayList.add(file.getAbsolutePath());
            }
        }
        return arrayList;
    }

    private File[] Q(File file) {
        return file.listFiles(new l());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> R(int i2, long j2) {
        List<String> P = P(i2, j2);
        String[] strArr = {"main.txt", "main.txt.1", "main.txt.01", "events.txt", "kernel.txt", "system.txt"};
        for (int i3 = 0; i3 < 6; i3++) {
            String str = "/data/Log/log0/" + strArr[i3];
            if (ce.c(str)) {
                P.add(str);
            }
        }
        P.add("/data/anr/");
        tf.a("ReportModel", "getNapaNeedFilePaths: filePaths = " + P);
        return P;
    }

    private int S(String[] strArr, int i2) {
        String str = strArr[i2];
        int lastIndexOf = str.lastIndexOf(" ");
        if (lastIndexOf > 0) {
            str = str.substring(lastIndexOf).trim();
        }
        return Integer.parseInt(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float U() {
        CarVcuManager carVcuManager;
        try {
            Car e2 = ge.e();
            if (e2 == null || (carVcuManager = (CarVcuManager) e2.getCarManager("xp_vcu")) == null) {
                return 0.0f;
            }
            return carVcuManager.getRawCarSpeed();
        } catch (Exception e3) {
            e3.printStackTrace();
            return 0.0f;
        }
    }

    private long V() {
        af b2 = af.b(App.b());
        long c2 = b2.c("one_day_crash_count", 0L) + 1;
        b2.e("one_day_crash_count", c2);
        return c2;
    }

    private long W() {
        af b2 = af.b(App.b());
        long c2 = b2.c("one_day_report_count", 0L) + 1;
        b2.e("one_day_report_count", c2);
        return c2;
    }

    private boolean X(ApplicationErrorReport applicationErrorReport) {
        String str;
        String str2;
        int i2;
        String str3;
        String str4;
        ApplicationErrorReport.CrashInfo crashInfo = applicationErrorReport.crashInfo;
        if (crashInfo != null && (str3 = crashInfo.stackTrace) != null) {
            int indexOf = str3.indexOf("at ");
            if (indexOf != -1) {
                str4 = applicationErrorReport.crashInfo.stackTrace.substring(indexOf);
            } else {
                str4 = applicationErrorReport.crashInfo.stackTrace;
            }
            str = str4;
            str2 = applicationErrorReport.packageName;
            i2 = 1;
        } else if (applicationErrorReport.anrInfo == null) {
            return false;
        } else {
            str = applicationErrorReport.anrInfo.cause + applicationErrorReport.packageName + applicationErrorReport.anrInfo.activity;
            str2 = applicationErrorReport.packageName;
            i2 = 2;
        }
        af b2 = af.b(App.b());
        if (!Z(applicationErrorReport.time, b2.c("last_crash_timestamp", 0L))) {
            tf.l("ReportModel", "first crash in this day ...");
            b2.e("one_day_report_count", 0L);
            b2.e("one_day_crash_count", 0L);
            b2.d("exceed_reported", false);
            this.d = false;
        }
        b2.e("last_crash_timestamp", applicationErrorReport.time);
        F((int) b2.c("one_day_report_count", 0L), (int) V(), b2);
        int i3 = applicationErrorReport.systemApp ? 2 : 3;
        ErrorInfoBean2 G = G(applicationErrorReport.time, str, str2, i2, i3);
        if (!this.d) {
            if (G == null) {
                return true;
            }
            boolean Z = Z(applicationErrorReport.time, G.getLastTime());
            if (!G.isReported() || !Z) {
                tf.l("ReportModel", "this is a duplicated error but not reported, duplicate count-->" + G.getCount() + "; so report it with logFile.");
                return true;
            }
        }
        if (G != null) {
            int count = (int) (G.getCount() + 1);
            tf.l("ReportModel", "Duplicated error! DB has the same errorInfo, it should be ignored! duplicate count-->" + count + "; so report it without uploading logFile.");
            g0(count, str2, G.getMd5(), i2, i3);
        }
        tf.l("ReportModel", "count of app crash reported is bigger than MAX_CRASH_COUNT, return false;");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Y(int i2, List<String> list) {
        return (list == null || list.size() == 0) && i2 < 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Z(long j2, long j3) {
        Date date = new Date(j2);
        Date date2 = new Date(j3);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        return simpleDateFormat.format(date).equals(simpleDateFormat.format(date2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a0(String str) {
        return "main.txt".equals(str) || "main.txt.1".equals(str) || "main.txt.01".equals(str) || "kernel.txt".equals(str) || "last_kmsg.txt".equals(str) || "system.txt".equals(str) || "system.txt.1".equals(str) || "events.txt".equals(str) || "events.txt.1".equals(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0(String str, List<String> list) {
        ag.h(2, new b(str, list));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0(List<String> list, IMoleEventBuilder iMoleEventBuilder) {
        ag.h(2, new e(iMoleEventBuilder, list));
    }

    private void d0(ApplicationErrorReport applicationErrorReport) {
        ag.h(2, new f(applicationErrorReport));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0() {
        ag.h(2, new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0(IMoleEventBuilder iMoleEventBuilder, List<String> list) {
        String[] f2 = be.f(list);
        String str = f2[0];
        String str2 = f2[1];
        tf.a("ReportModel", "sendStatDataAndUploadFiles: logAddress = " + str);
        iMoleEventBuilder.setProperty("address", str);
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2.replace(".zip", "_en.zip"));
        if (fe.c()) {
            return;
        }
        this.c.sendStatData(iMoleEventBuilder.build());
        this.c.sendFiles(arrayList);
    }

    private void g0(int i2, String str, String str2, int i3, int i4) {
        if (fe.c()) {
            return;
        }
        IDataLog iDataLog = this.c;
        iDataLog.sendStatData(iDataLog.buildStat().setEventName("bug_error").setProperty("count", Integer.valueOf(i2)).setProperty("srcName", str).setProperty("md5", str2).setProperty("mType", Integer.valueOf(i3)).setProperty("srcType", Integer.valueOf(i4)).setProperty("speed", Float.valueOf(U())).setProperty("hw_version", M()).build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h0(int i2, IMoleEventBuilder iMoleEventBuilder, long j2, int i3) {
        ag.k(2, new i(i2, j2, iMoleEventBuilder, i3), 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0(IMoleEventBuilder iMoleEventBuilder, List<String> list) {
        ag.k(2, new j(list, iMoleEventBuilder), 1000L);
    }

    private void y(List<String> list) {
        File[] listFiles = new File("/data/anr/").listFiles();
        if (listFiles == null || listFiles.length <= 0) {
            return;
        }
        for (File file : listFiles) {
            list.add(file.getAbsolutePath());
        }
    }

    private void z(List<String> list, File... fileArr) {
        if (fileArr == null) {
            return;
        }
        for (File file : fileArr) {
            File[] Q = Q(file);
            if (Q != null && Q.length > 0) {
                for (File file2 : Q) {
                    list.add(file2.getAbsolutePath());
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x00b6, code lost:
        if (r2 == null) goto L27;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00d4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00ca A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x00c0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int[] T() {
        /*
            Method dump skipped, instructions count: 226
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.sd.T():int[]");
    }

    @Override // defpackage.od
    public void a(Context context, ApplicationErrorReport applicationErrorReport) {
        if (applicationErrorReport == null) {
            tf.l("ReportModel", "appReport is null, return!");
        } else if (!X(applicationErrorReport)) {
            tf.l("ReportModel", "no need to report, return!");
            E();
        } else {
            W();
            E();
            ag.h(2, new h(applicationErrorReport, context));
        }
    }

    @Override // defpackage.od
    public void b(ApplicationErrorReport applicationErrorReport) {
        d0(applicationErrorReport);
    }

    @Override // defpackage.od
    public void c(Context context) {
        tf.l("ReportModel", "createSystemServerReport");
        ag.h(2, new o());
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0022 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0023  */
    @Override // defpackage.od
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d(android.content.Context r8) {
        /*
            r7 = this;
            r8 = 1
            r0 = 0
            r1 = 0
            boolean r2 = r7.H()     // Catch: java.lang.Exception -> L18
            if (r2 == 0) goto L20
            java.lang.String r0 = "ReportModel"
            java.lang.String r2 = "createKernelPanicReport"
            defpackage.tf.l(r0, r2)     // Catch: java.lang.Exception -> L15
            java.lang.String r0 = "kernel panic"
            r1 = r0
            r0 = r8
            goto L20
        L15:
            r0 = move-exception
            r2 = r8
            goto L1c
        L18:
            r2 = move-exception
            r6 = r2
            r2 = r0
            r0 = r6
        L1c:
            r0.printStackTrace()
            r0 = r2
        L20:
            if (r0 != 0) goto L23
            return
        L23:
            com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog r0 = r7.c
            com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder r0 = r0.buildMoleEvent()
            java.lang.String r2 = "bug_error"
            com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder r2 = r0.setEvent(r2)
            java.lang.String r3 = "P00009"
            com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder r2 = r2.setPageId(r3)
            java.lang.String r3 = "B001"
            r2.setButtonId(r3)
            com.xiaopeng.bughunter.App r2 = com.xiaopeng.bughunter.App.b()
            java.lang.String r3 = "power"
            java.lang.Object r2 = r2.getSystemService(r3)
            android.os.PowerManager r2 = (android.os.PowerManager) r2
            boolean r2 = r2.isScreenOn()
            java.lang.String r3 = "pm_status"
            com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder r2 = r0.setProperty(r3, r2)
            long r3 = java.lang.System.currentTimeMillis()
            java.lang.String r3 = defpackage.qf.a(r3)
            java.lang.String r4 = "mRecTime"
            com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder r2 = r2.setProperty(r4, r3)
            r3 = 4
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.String r4 = "mType"
            com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder r2 = r2.setProperty(r4, r3)
            com.xiaopeng.bughunter.bean.DevInfo r3 = r7.K()
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = "devInfo"
            com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder r2 = r2.setProperty(r4, r3)
            r3 = 2
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)
            java.lang.String r5 = "logType"
            com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder r2 = r2.setProperty(r5, r4)
            java.lang.String r4 = "srcName"
            java.lang.String r5 = "com.xiaopeng.xmart.system"
            com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder r2 = r2.setProperty(r4, r5)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            java.lang.String r4 = "srcType"
            com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder r8 = r2.setProperty(r4, r8)
            java.lang.String r2 = defpackage.gg.e()
            java.lang.String r4 = "appVer"
            com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder r8 = r8.setProperty(r4, r2)
            java.lang.String r2 = "mBrief"
            com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder r8 = r8.setProperty(r2, r1)
            java.lang.String r2 = "mTitle"
            com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder r8 = r8.setProperty(r2, r1)
            java.lang.String r1 = "sys.xiaopeng.reboot_reason"
            java.lang.String r2 = ""
            java.lang.String r1 = android.os.SystemProperties.get(r1, r2)
            java.lang.String r2 = "rebootReason"
            com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder r8 = r8.setProperty(r2, r1)
            float r1 = r7.U()
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            java.lang.String r2 = "speed"
            com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder r8 = r8.setProperty(r2, r1)
            java.lang.String r1 = r7.M()
            java.lang.String r2 = "hw_version"
            r8.setProperty(r2, r1)
            sd$n r8 = new sd$n
            r8.<init>(r0)
            defpackage.ag.h(r3, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.sd.d(android.content.Context):void");
    }

    @Override // defpackage.od
    public void e(String str) {
        tf.l("ReportModel", "createIcmCrashReport");
        ag.h(2, new a(str));
    }

    @Override // defpackage.od
    public void f(Context context, ApplicationErrorReport applicationErrorReport) {
        if (applicationErrorReport == null) {
            tf.l("ReportModel", "appReport is null, return!");
        } else if (!X(applicationErrorReport)) {
            tf.l("ReportModel", "no need to report, return!");
            E();
        } else {
            W();
            E();
            ag.h(2, new d(applicationErrorReport, context));
        }
    }
}
