package defpackage;

import android.content.pm.PackageManager;
import com.xiaopeng.bughunter.App;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
/* compiled from: AppCheckUtil.java */
/* renamed from: zd  reason: default package */
/* loaded from: classes.dex */
public class zd {
    private static boolean a(String str) {
        if (str == null) {
            tf.a("BugHunter-CheckAppUtil", "checkPackageName: packageName is null!");
            return false;
        }
        return str.contains("com.xiaopeng");
    }

    private static boolean b(String str) {
        if (str == null) {
            tf.a("BugHunter-CheckAppUtil", "checkPackageSignature: signature is null!");
            return false;
        }
        return "52:B2:38:EC:BA:68:C2:47:4A:2A:4B:0B:12:01:D4:36:94:96:F3:1D".equals(str);
    }

    public static String c(String str) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(App.b().getPackageManager().getPackageInfo(str, 64).signatures[0].toByteArray());
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                String upperCase = Integer.toHexString(b & 255).toUpperCase(Locale.US);
                if (upperCase.length() == 1) {
                    sb.append("0");
                }
                sb.append(upperCase);
                sb.append(":");
            }
            String sb2 = sb.toString();
            return sb2.substring(0, sb2.length() - 1);
        } catch (PackageManager.NameNotFoundException | NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean d(String str, String str2) {
        tf.l("BugHunter-CheckAppUtil", "isXPApp: packageName = " + str + ", signature = " + str2);
        return a(str) && b(str2);
    }
}
