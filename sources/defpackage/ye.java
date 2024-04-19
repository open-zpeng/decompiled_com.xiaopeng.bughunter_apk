package defpackage;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog;
import java.io.File;
import java.io.FilenameFilter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.io.IOUtils;
/* compiled from: DataBackupHelper.java */
/* renamed from: ye  reason: default package */
/* loaded from: classes.dex */
public class ye {
    private static volatile ye a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DataBackupHelper.java */
    /* renamed from: ye$a */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ Context d;

        a(String str, String str2, Context context) {
            this.b = str;
            this.c = str2;
            this.d = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("vehicleId", String.valueOf(yf.h()));
            jsonObject.addProperty("message", this.b);
            jsonObject.addProperty("md5", uf.a(this.b));
            byte[] bytes = new Gson().toJson((JsonElement) jsonObject).getBytes();
            ye.this.k(this.c, this.d);
            ye.this.e(this.c, this.d);
            ye.this.o(this.c, bytes, this.d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DataBackupHelper.java */
    /* renamed from: ye$b */
    /* loaded from: classes.dex */
    public class b implements FilenameFilter {
        final /* synthetic */ String a;

        b(String str) {
            this.a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.contains(this.a) && str.endsWith(".log");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DataBackupHelper.java */
    /* renamed from: ye$c */
    /* loaded from: classes.dex */
    public class c implements FilenameFilter {
        final /* synthetic */ String a;

        c(String str) {
            this.a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.contains(this.a) && str.contains(".log");
        }
    }

    private ye() {
    }

    private File d(String str, Context context) {
        String b2 = rf.b(System.currentTimeMillis());
        return new File("/sdcard/Log/" + str + "/" + context.getPackageName() + "/" + str + "_" + b2 + ".log");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str, Context context) {
        File file = new File("/sdcard/Log/" + str + "/" + context.getPackageName());
        if (!file.exists()) {
            file.mkdirs();
        }
        String[] list = file.list(new b(str));
        if (list == null) {
            return;
        }
        Arrays.sort(list);
        ArrayList arrayList = new ArrayList();
        for (String str2 : list) {
            if (l(str2)) {
                arrayList.add(str2);
                boolean delete = new File("/sdcard/Log/" + str + "/" + context.getPackageName() + "/" + str2).delete();
                StringBuilder sb = new StringBuilder();
                sb.append("file: ");
                sb.append(str2);
                sb.append(" is expired, deleted ");
                sb.append(delete);
                tf.a("DataBackupHelper", sb.toString());
            }
        }
        if (arrayList.size() > 0) {
            m(arrayList, list);
        }
    }

    private String f(String str) {
        return str.replace(".log", ".zip");
    }

    private File g(String str, Context context) {
        File[] listFiles = new File("/sdcard/Log/" + str + "/" + context.getPackageName()).listFiles(new c(str));
        if (listFiles != null && listFiles.length != 0) {
            Arrays.sort(listFiles);
            File file = listFiles[listFiles.length - 1];
            return (!j(file) || file.length() >= 10485760) ? d(str, context) : file;
        }
        tf.a("DataBackupHelper", "create a new File");
        return d(str, context);
    }

    public static ye h() {
        if (a == null) {
            synchronized (ye.class) {
                if (a == null) {
                    a = new ye();
                }
            }
        }
        return a;
    }

    private String i(String str) {
        return str.substring(str.lastIndexOf("_") - 8, str.lastIndexOf("."));
    }

    private boolean j(File file) {
        String name = file.getName();
        String b2 = rf.b(System.currentTimeMillis());
        return name.contains(b2.substring(0, b2.indexOf("_")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str, Context context) {
        File file = new File("/sdcard/Log/" + str + "/" + context.getPackageName());
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    private boolean l(String str) {
        int lastIndexOf = str.lastIndexOf("_");
        String str2 = str.substring(lastIndexOf - 8, lastIndexOf) + "_000000";
        String b2 = rf.b(System.currentTimeMillis());
        if (rf.a(b2.substring(0, 8) + "_000000") - rf.a(str2) > 604800000) {
            tf.a("DataBackupHelper", str + " EXPIRED!");
            return true;
        }
        return false;
    }

    private void m(List<String> list, String[] strArr) {
        String i;
        int size = list.size();
        String i2 = i(list.get(0));
        if (strArr.length > size) {
            i = i(strArr[size]);
        } else {
            i = i(list.get(size - 1));
        }
        IDataLog iDataLog = (IDataLog) Module.get(se.class).get(IDataLog.class);
        iDataLog.sendStatData(iDataLog.buildStat().setEventName("data_expire").setProperty("startTime", i2).setProperty("endTime", i).build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void o(String str, byte[] bArr, Context context) {
        RandomAccessFile randomAccessFile;
        File g = g(str, context);
        File file = new File(f(g.getPath()));
        if (file.exists()) {
            tf.l("DataBackupHelper", "zipFile exists, delete .zip and write .log");
            file.delete();
        }
        RandomAccessFile randomAccessFile2 = null;
        try {
            try {
                try {
                    randomAccessFile = new RandomAccessFile(g, "rw");
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e) {
                e = e;
            }
            try {
                randomAccessFile.seek(randomAccessFile.length());
                randomAccessFile.write(bArr);
                randomAccessFile.writeBytes(IOUtils.LINE_SEPARATOR_UNIX);
                randomAccessFile.getFD().sync();
                StringBuilder sb = new StringBuilder();
                sb.append("write ");
                sb.append(g);
                sb.append(" success, data.length:");
                sb.append(bArr.length);
                tf.l("DataBackupHelper", sb.toString());
                randomAccessFile.close();
                randomAccessFile2 = sb;
            } catch (Exception e2) {
                e = e2;
                randomAccessFile2 = randomAccessFile;
                tf.t("DataBackupHelper", "write file fail!", e);
                randomAccessFile2 = randomAccessFile2;
                if (randomAccessFile2 != null) {
                    randomAccessFile2.close();
                    randomAccessFile2 = randomAccessFile2;
                }
            } catch (Throwable th2) {
                th = th2;
                randomAccessFile2 = randomAccessFile;
                if (randomAccessFile2 != null) {
                    try {
                        randomAccessFile2.close();
                    } catch (Exception unused) {
                    }
                }
                throw th;
            }
        } catch (Exception unused2) {
        }
    }

    public void n(String str, String str2, Context context) {
        ag.h(0, new a(str2, str, context));
    }
}
