package defpackage;

import com.xiaopeng.lib.security.xmartv1.XmartV1Constants;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* compiled from: MD5Utils.java */
/* renamed from: if  reason: invalid class name and default package */
/* loaded from: classes.dex */
class Cif {
    public static String a(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes(XmartV1Constants.UTF8_ENCODING));
            byte[] digest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < digest.length; i++) {
                if (Integer.toHexString(digest[i] & 255).length() == 1) {
                    stringBuffer.append("0");
                    stringBuffer.append(Integer.toHexString(digest[i] & 255));
                } else {
                    stringBuffer.append(Integer.toHexString(digest[i] & 255));
                }
            }
            return stringBuffer.toString();
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException unused) {
            return "";
        }
    }
}
