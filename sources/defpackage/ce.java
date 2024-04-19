package defpackage;

import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
/* compiled from: FileUtil.java */
/* renamed from: ce  reason: default package */
/* loaded from: classes.dex */
public class ce {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    public static void b(String str) {
        File[] listFiles;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            File file = new File(str);
            if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    b(file2.getAbsolutePath());
                }
            }
            if (!file.isDirectory()) {
                file.delete();
                return;
            }
            File[] listFiles2 = file.listFiles();
            if (listFiles2 == null || listFiles2.length != 0) {
                return;
            }
            file.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean c(String str) {
        boolean exists = str != null ? new File(str).exists() : false;
        tf.a("FileUtil", str + " isExistFilePath = " + exists);
        return exists;
    }

    public static boolean d(String str) {
        boolean z;
        if (str == null || str.length() <= 0) {
            z = false;
        } else {
            File file = new File(str);
            z = !file.exists() ? file.mkdirs() : true;
        }
        tf.a("FileUtil", "mkDir path=" + str + ", res=" + z);
        return z;
    }
}
