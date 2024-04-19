package defpackage;

import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Properties;
/* compiled from: EnvConfig.java */
/* renamed from: dg  reason: default package */
/* loaded from: classes.dex */
public final class dg {
    private static Properties a = new Properties();

    static {
        f();
    }

    private static long a(String str) {
        try {
            String str2 = "yyyyMMdd HH:mm:ss";
            if (str.indexOf(":") < 0) {
                if (str.indexOf(" ") < 0) {
                    str2 = str.length() <= 8 ? "yyyyMMdd" : "yyyyMMddHHmmss";
                } else {
                    str2 = "yyyyMMdd HHmmss";
                }
            }
            return new SimpleDateFormat(str2).parse(str).getTime();
        } catch (Exception e) {
            e.printStackTrace();
            return -1L;
        }
    }

    public static String b(String str, String str2) {
        return c("main_host", str, str2);
    }

    public static String c(String str, String str2, String str3) {
        if (gg.f()) {
            String property = a.getProperty(str);
            if (!TextUtils.isEmpty(property)) {
                return property;
            }
        }
        return gg.h() ? str2 : str3;
    }

    public static boolean d(String str) {
        return a.containsKey(str);
    }

    public static boolean e() {
        return a.size() > 0 && d("main_host");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.lang.String] */
    private static void f() {
        FileInputStream fileInputStream;
        File file;
        BufferedInputStream bufferedInputStream;
        if (gg.f()) {
            BufferedInputStream bufferedInputStream2 = null;
            try {
                try {
                    file = new File("/sdcard/pre_env.ini");
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e) {
                e = e;
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
            }
            if (!file.exists()) {
                sf.a(null);
                sf.a(null);
                return;
            }
            fileInputStream = new FileInputStream(file);
            try {
                bufferedInputStream = new BufferedInputStream(fileInputStream);
            } catch (Exception e2) {
                e = e2;
            }
            try {
                a.load(bufferedInputStream);
                Log.w("EnvConfig", "<<<< warning, load file: pre_env.ini !!!");
                String property = a.getProperty("expired_time", null);
                boolean isEmpty = TextUtils.isEmpty(property);
                String str = property;
                if (!isEmpty) {
                    long a2 = a(property);
                    ?? r1 = (a2 > 0L ? 1 : (a2 == 0L ? 0 : -1));
                    str = r1;
                    if (r1 > 0) {
                        ?? r12 = (System.currentTimeMillis() > a2 ? 1 : (System.currentTimeMillis() == a2 ? 0 : -1));
                        str = r12;
                        if (r12 >= 0) {
                            Log.w("EnvConfig", "<<<< file pre_env.ini is expired!");
                            a.clear();
                            str = "<<<< file pre_env.ini is expired!";
                        }
                    }
                }
                sf.a(bufferedInputStream);
                bufferedInputStream2 = str;
            } catch (Exception e3) {
                e = e3;
                bufferedInputStream2 = bufferedInputStream;
                e.printStackTrace();
                sf.a(bufferedInputStream2);
                bufferedInputStream2 = bufferedInputStream2;
                sf.a(fileInputStream);
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream2 = bufferedInputStream;
                sf.a(bufferedInputStream2);
                sf.a(fileInputStream);
                throw th;
            }
            sf.a(fileInputStream);
        }
    }
}
