package defpackage;

import android.text.TextUtils;
import com.xiaopeng.lib.security.xmartv1.XmartV1Constants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
/* compiled from: StringUtils.java */
/* renamed from: gb  reason: default package */
/* loaded from: classes.dex */
public class gb {
    public static Map<String, String> a(Map<String, String> map) {
        if (map != null) {
            HashMap hashMap = new HashMap();
            for (String str : map.keySet()) {
                if (str instanceof String) {
                    String str2 = map.get(str);
                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                        try {
                            hashMap.put(URLEncoder.encode(str, XmartV1Constants.UTF8_ENCODING), URLEncoder.encode(str2, XmartV1Constants.UTF8_ENCODING));
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            return hashMap;
        }
        return map;
    }

    public static String b(Object obj) {
        if (obj != null) {
            if (obj instanceof String) {
                return (String) obj;
            }
            if (obj instanceof Integer) {
                return "" + ((Integer) obj).intValue();
            } else if (obj instanceof Long) {
                return "" + ((Long) obj).longValue();
            } else if (obj instanceof Double) {
                return "" + ((Double) obj).doubleValue();
            } else if (obj instanceof Float) {
                return "" + ((Float) obj).floatValue();
            } else if (obj instanceof Short) {
                return "" + ((int) ((Short) obj).shortValue());
            } else if (obj instanceof Byte) {
                return "" + ((int) ((Byte) obj).byteValue());
            } else if (obj instanceof Boolean) {
                return ((Boolean) obj).toString();
            } else {
                if (obj instanceof Character) {
                    return ((Character) obj).toString();
                }
                return obj.toString();
            }
        }
        return "";
    }

    public static String c(Map<String, String> map) {
        if (map != null) {
            boolean z = true;
            StringBuffer stringBuffer = new StringBuffer();
            for (String str : map.keySet()) {
                String b = b(map.get(str));
                String b2 = b(str);
                if (b != null && b2 != null) {
                    if (z) {
                        stringBuffer.append(b2 + "=" + b);
                        z = false;
                    } else {
                        stringBuffer.append(",");
                        stringBuffer.append(b2 + "=" + b);
                    }
                }
            }
            return stringBuffer.toString();
        }
        return null;
    }
}
