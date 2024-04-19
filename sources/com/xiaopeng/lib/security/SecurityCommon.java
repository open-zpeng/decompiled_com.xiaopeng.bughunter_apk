package com.xiaopeng.lib.security;

import android.content.Context;
import android.util.Base64;
/* loaded from: classes.dex */
public final class SecurityCommon {
    private static final String TAG = "SecurityCommon";
    private static Boolean sIsSystemUid;

    public static String base64UrlEncode(byte[] bArr) {
        return new String(Base64.encode(bArr, 11)).split("=")[0].replace('+', '-').replace('/', '_');
    }

    public static boolean checkSystemUid(Context context) {
        if (sIsSystemUid == null) {
            if (context == null) {
                return false;
            }
            try {
                sIsSystemUid = Boolean.valueOf(context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).uid == 1000);
            } catch (Exception e) {
                tf.t(TAG, "init uid error!", e);
                sIsSystemUid = Boolean.FALSE;
            }
        }
        return sIsSystemUid.booleanValue();
    }

    public static String getBuildInfoFlag() {
        return gg.h() ? "1" : "2";
    }

    public static String getUidIdsKey(String str, String str2) {
        return str + "-" + str2;
    }

    public static String parseByte2HexStr(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            stringBuffer.append("0123456789ABCDEF".charAt((bArr[i] >> 4) & 15));
            stringBuffer.append("0123456789ABCDEF".charAt(bArr[i] & 15));
        }
        return stringBuffer.toString();
    }

    public static byte[] parseHexStr2Byte(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = Integer.valueOf(str.substring(i2, i2 + 2), 16).byteValue();
        }
        return bArr;
    }
}
