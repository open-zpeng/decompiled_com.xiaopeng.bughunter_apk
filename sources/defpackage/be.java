package defpackage;

import com.xiaopeng.bughunter.App;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.remotestorage.Callback;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.remotestorage.IRemoteStorage;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.remotestorage.StorageException;
import com.xiaopeng.lib.framework.netchannelmodule.NetworkChannelsEntry;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
/* compiled from: FileUploadHelper.java */
/* renamed from: be  reason: default package */
/* loaded from: classes.dex */
public class be {
    public static final String a;
    public static final String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FileUploadHelper.java */
    /* renamed from: be$a */
    /* loaded from: classes.dex */
    public static class a implements Callback {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.remotestorage.Callback
        public void onFailure(String str, String str2, StorageException storageException) {
            be.b(str2);
            tf.f("FileUploadHelper", "upload file-->" + this.a + " failed; the error mesaage-->" + storageException.getMessage());
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.remotestorage.Callback
        public void onStart(String str, String str2) {
            tf.a("FileUploadHelper", "start uploading " + this.a);
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.remotestorage.Callback
        public void onSuccess(String str, String str2) {
            be.b(str2);
            tf.a("FileUploadHelper", "upload successfully: " + this.a);
        }
    }

    static {
        String str = gg.h() ? "xp-log-local" : "xp-log";
        a = str;
        b = "http://" + str + ".oss-cn-hangzhou.aliyuncs.com/";
    }

    private static void a(File file, boolean z) {
        if (z) {
            try {
                file.delete();
                System.gc();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected static synchronized void b(String str) {
        synchronized (be.class) {
            try {
                sf.c(str);
                tf.a("FileUploadHelper", "delete " + str + " success");
            } catch (Exception e) {
                tf.a("FileUploadHelper", "delete " + str + " failed. Cause-->" + e.getMessage());
            }
        }
    }

    private static String c(long j, String str) {
        String str2 = "/sdcard/Log/upload-zip/" + str;
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str2 + "/" + j + ".zip";
    }

    private static String d(long j, String str) {
        return b + (str.substring(str.indexOf("/") + 1) + "/" + j + "_en.zip");
    }

    private static String e(long j, String str) {
        return String.format("%s%s.%s/%s/%s", "http://", "xp-authhub", "oss-cn-hangzhou.aliyuncs.com", "xp-vsoc", str.substring(str.indexOf("/") + 1) + "/" + j + "_en.zip");
    }

    public static String[] f(List<String> list) {
        File file;
        long currentTimeMillis = System.currentTimeMillis();
        String str = a + "/log/" + gg.e() + "/" + rf.c(currentTimeMillis) + "/" + yf.c();
        String d = d(currentTimeMillis, str);
        String c = c(currentTimeMillis, str);
        try {
            file = bg.d(c, list);
        } catch (IOException e) {
            e.printStackTrace();
            file = null;
        }
        a(file, eg.c(file, new File(c.replace(".zip", "_en.zip")), "@!chxpzi#0109$+/"));
        return new String[]{d, c};
    }

    public static String[] g(List<String> list) {
        File file;
        long currentTimeMillis = System.currentTimeMillis();
        String str = "xp-vsoc/" + gg.e() + "/" + rf.c(currentTimeMillis) + "/" + yf.c();
        String e = e(currentTimeMillis, str);
        String c = c(currentTimeMillis, str);
        String format = String.format(Locale.getDefault(), "%s/%d.zip", str, Long.valueOf(currentTimeMillis));
        tf.a("FileUploadHelper", "makeUploadInfoAndTargetFileForVSOC: objectKey = " + format);
        try {
            file = bg.d(c, list);
        } catch (IOException e2) {
            e2.printStackTrace();
            file = null;
        }
        String replace = c.replace(".zip", "_en.zip");
        a(file, eg.c(file, new File(replace), "@!chxpzi#0109$+/"));
        return new String[]{e, replace, format};
    }

    public static synchronized void h(String str, String str2) {
        synchronized (be.class) {
            IRemoteStorage iRemoteStorage = (IRemoteStorage) Module.get(NetworkChannelsEntry.class).get(IRemoteStorage.class);
            try {
                iRemoteStorage.initWithCategoryAndContext(App.b());
            } catch (Exception e) {
                tf.f("FileUploadHelper", "Failed to initialize the remote storage:" + e);
            }
            try {
                i(str, str2, iRemoteStorage, new a(str));
            } catch (Exception e2) {
                tf.b("FileUploadHelper", "exception occurs, exception-->", e2);
            }
        }
    }

    protected static void i(String str, String str2, IRemoteStorage iRemoteStorage, Callback callback) throws Exception {
        iRemoteStorage.uploadWithPathAndCallback("xp-authhub", str2, str, callback);
    }
}
