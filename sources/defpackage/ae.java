package defpackage;

import android.text.TextUtils;
/* compiled from: CmdGenerator.java */
/* renamed from: ae  reason: default package */
/* loaded from: classes.dex */
public class ae {
    public static String a(String str, String str2) {
        StringBuilder sb = new StringBuilder(str);
        if (ce.c("/data/etc/ssh/id_rsa")) {
            sb.append(" -i ");
            sb.append("/data/etc/ssh/id_rsa");
            sb.append(" ");
        }
        sb.append(" ");
        sb.append("\"");
        sb.append("rm ");
        sb.append(str2);
        sb.append("\"");
        return sb.toString();
    }

    public static String b(String str, String str2, String[] strArr, String str3) {
        if (strArr != null && strArr.length != 0 && !TextUtils.isEmpty(str3)) {
            StringBuilder sb = new StringBuilder("/system/bin/scp");
            sb.append(" -v ");
            if (ce.c("/data/etc/ssh/id_rsa")) {
                sb.append(" -i ");
                sb.append("/data/etc/ssh/id_rsa");
                sb.append(" ");
            }
            for (String str4 : strArr) {
                sb.append(str);
                sb.append("@");
                sb.append(str2);
                sb.append(":");
                sb.append(str4);
                sb.append(" ");
            }
            sb.append(str3);
            return sb.toString();
        }
        tf.f("CmdGenerator", "srcPath or destPath is not correct");
        return null;
    }

    public static String c(String str, String str2, String[] strArr) {
        StringBuilder sb = new StringBuilder(str);
        if (ce.c("/data/etc/ssh/id_rsa")) {
            sb.append(" -i ");
            sb.append("/data/etc/ssh/id_rsa");
            sb.append(" ");
        }
        sb.append(" ");
        sb.append("\"");
        sb.append(d(strArr, str2));
        sb.append("\"");
        return sb.toString();
    }

    public static String d(String[] strArr, String str) {
        StringBuilder sb = new StringBuilder("tar -zvcf");
        sb.append(" ");
        sb.append(str);
        for (String str2 : strArr) {
            sb.append(" ");
            sb.append(str2);
        }
        return sb.toString();
    }
}
