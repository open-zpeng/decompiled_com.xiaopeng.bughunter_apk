package defpackage;

import com.xiaopeng.lib.security.xmartv1.XmartV1Constants;
import defpackage.qa;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.IOUtils;
/* compiled from: UploadTask.java */
/* renamed from: vb  reason: default package */
/* loaded from: classes.dex */
public abstract class vb implements Runnable {
    private static volatile boolean b = false;
    private static boolean c = false;
    static int d;
    int e = -1;
    float f = 200.0f;
    int g = 0;

    /* JADX WARN: Code restructure failed: missing block: B:70:0x016b, code lost:
        defpackage.ab.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01e2, code lost:
        defpackage.vb.b = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void c() {
        /*
            Method dump skipped, instructions count: 493
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vb.c():void");
    }

    private int d(Boolean bool, long j) {
        if (j < 0) {
            return this.e;
        }
        float f = this.g / ((float) j);
        if (!bool.booleanValue()) {
            this.e /= 2;
            d++;
        } else if (j > 45000) {
            return this.e;
        } else {
            this.e = (int) (((f * 45000.0f) / this.f) - d);
        }
        int i = this.e;
        if (i < 1) {
            this.e = 1;
            d = 0;
        } else if (i > 350) {
            this.e = 350;
        }
        ya.c("UploadTask", "winsize:", Integer.valueOf(this.e));
        return this.e;
    }

    private qa.a e(String str, Map<String, Object> map) {
        if (str != null) {
            byte[] bArr = ua.a(2, str, map, false).b;
            ya.c("UploadTask", "url:", str);
            if (bArr != null) {
                String str2 = null;
                try {
                    str2 = new String(bArr, XmartV1Constants.UTF8_ENCODING);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                if (str2 != null) {
                    ya.c("UploadTask", "result:", str2);
                    return qa.a(str2);
                }
            }
        }
        return qa.a.a;
    }

    private List<String> f(qb qbVar) {
        return fa.c(qbVar.b);
    }

    private Map<String, Object> g(List<qb> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (int i = 0; i < list.size(); i++) {
            List<String> f = f(list.get(i));
            if (f != null) {
                for (int i2 = 0; i2 < f.size(); i2++) {
                    StringBuilder sb = (StringBuilder) hashMap.get(f.get(i2));
                    if (sb == null) {
                        sb = new StringBuilder();
                        hashMap.put(f.get(i2), sb);
                    } else {
                        sb.append(IOUtils.LINE_SEPARATOR_UNIX);
                    }
                    sb.append(list.get(i).a());
                }
            }
        }
        HashMap hashMap2 = new HashMap();
        this.g = 0;
        for (String str : hashMap.keySet()) {
            byte[] h = h(((StringBuilder) hashMap.get(str)).toString());
            hashMap2.put(str, h);
            this.g += h.length;
        }
        float size = this.g / list.size();
        this.f = size;
        ya.c("UploadTask", "averagePackageSize:", Float.valueOf(size));
        return hashMap2;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:1|2|3|4|(3:6|7|8)|9|11|12|13|14|15|(1:(0))) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private byte[] h(java.lang.String r4) {
        /*
            r3 = this;
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            r1 = 0
            java.util.zip.GZIPOutputStream r2 = new java.util.zip.GZIPOutputStream     // Catch: java.lang.Throwable -> L21 java.io.IOException -> L23
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L21 java.io.IOException -> L23
            java.lang.String r1 = "UTF-8"
            byte[] r4 = r4.getBytes(r1)     // Catch: java.lang.Throwable -> L1b java.io.IOException -> L1e
            r2.write(r4)     // Catch: java.lang.Throwable -> L1b java.io.IOException -> L1e
            r2.flush()     // Catch: java.lang.Throwable -> L1b java.io.IOException -> L1e
            r2.close()     // Catch: java.lang.Exception -> L2c
            goto L2c
        L1b:
            r4 = move-exception
            r1 = r2
            goto L3a
        L1e:
            r4 = move-exception
            r1 = r2
            goto L24
        L21:
            r4 = move-exception
            goto L3a
        L23:
            r4 = move-exception
        L24:
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L21
            if (r1 == 0) goto L2c
            r1.close()     // Catch: java.lang.Exception -> L2c
        L2c:
            byte[] r4 = r0.toByteArray()
            java.lang.String r1 = "QrMgt8GGYI6T52ZY5AnhtxkLzb8egpFn3j5JELI8H6wtACbUnZ5cc3aYTsTRbmkAkRJeYbtx92LPBWm7nBO9UIl7y5i5MQNmUZNf5QENurR5tGyo7yJ2G0MBjWvy6iAtlAbacKP0SwOUeUWx5dsBdyhxa7Id1APtybSdDgicBDuNjI0mlZFUzZSS9dmN8lBD0WTVOMz0pRZbR3cysomRXOO1ghqjJdTcyDIxzpNAEszN8RMGjrzyU7Hjbmwi6YNK"
            byte[] r4 = defpackage.db.c(r4, r1)
            r0.close()     // Catch: java.lang.Exception -> L39
        L39:
            return r4
        L3a:
            if (r1 == 0) goto L3f
            r1.close()     // Catch: java.lang.Exception -> L3f
        L3f:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vb.h(java.lang.String):byte[]");
    }

    private int i(List<qb> list) {
        if (list == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            String str = list.get(i2).b;
            if (str != null && "6005".equalsIgnoreCase(str)) {
                i++;
            }
        }
        return i;
    }

    private int j() {
        if (this.e == -1) {
            String h = bb.h();
            if ("wifi".equalsIgnoreCase(h)) {
                this.e = 20;
            } else if ("4G".equalsIgnoreCase(h)) {
                this.e = 16;
            } else if ("3G".equalsIgnoreCase(h)) {
                this.e = 12;
            } else {
                this.e = 8;
            }
        }
        return this.e;
    }

    public static boolean k() {
        return b;
    }

    public abstract void a();

    public abstract void b();

    @Override // java.lang.Runnable
    public void run() {
        try {
            c();
            a();
        } catch (Throwable unused) {
        }
    }
}
