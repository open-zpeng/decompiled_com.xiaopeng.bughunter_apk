package defpackage;

import android.content.Context;
import android.text.TextUtils;
import com.xiaopeng.lib.security.xmartv1.XmartV1Constants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Set;
/* compiled from: UrlWrapper.java */
/* renamed from: kb  reason: default package */
/* loaded from: classes.dex */
public class kb {
    private static String a(String str, String str2, String str3, String str4) throws Exception {
        String str5;
        String str6;
        Context j = ea.j();
        String c = ra.c();
        String f = ra.f();
        if (f == null) {
            f = "";
        }
        String str7 = ta.a(j).get(pb.APPVERSION.toString());
        String str8 = ta.a(j).get(pb.OS.toString());
        String str9 = ta.a(j).get(pb.UTDID.toString());
        String valueOf = String.valueOf(System.currentTimeMillis());
        sb a = ea.a();
        str5 = "1";
        String str10 = "0";
        if (!(a instanceof tb)) {
            if (a instanceof rb) {
                str10 = ((rb) a).a() ? "1" : "0";
                str5 = "0";
            } else {
                str5 = "0";
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(c);
        sb.append(f);
        sb.append(str7);
        sb.append(str8);
        sb.append("2.6.4.10_for_bc");
        sb.append(str9);
        sb.append(valueOf);
        sb.append("3.0");
        sb.append(str5);
        sb.append(str3 == null ? "" : str3);
        sb.append(str4 == null ? "" : str4);
        String sign = a.getSign(za.c(sb.toString().getBytes()));
        if (TextUtils.isEmpty(str2)) {
            str6 = "";
        } else {
            str6 = str2 + "&";
        }
        return String.format("%s?%sak=%s&av=%s&c=%s&v=%s&s=%s&d=%s&sv=%s&p=%s&t=%s&u=%s&is=%s&k=%s", str, str6, c(c), c(str7), c(f), c("3.0"), c(sign), c(str9), "2.6.4.10_for_bc", str8, valueOf, "", str5, str10);
    }

    public static String b(String str, Map<String, Object> map, Map<String, Object> map2) throws Exception {
        String a;
        String str2;
        String str3 = "";
        if (map2 != null && map2.size() > 0) {
            Set<String> keySet = map2.keySet();
            String[] strArr = new String[keySet.size()];
            keySet.toArray(strArr);
            for (String str4 : wa.a().b(strArr, true)) {
                str3 = str3 + str4 + za.c((byte[]) map2.get(str4));
            }
        }
        try {
            a = a(str, null, null, str3);
        } catch (Throwable unused) {
            a = a(fa.j(), null, null, str3);
        }
        if (TextUtils.isEmpty(fa.f)) {
            return a;
        }
        return a + "&dk=" + URLEncoder.encode(str2, XmartV1Constants.UTF8_ENCODING);
    }

    private static String c(String str) {
        if (str == null) {
            return "";
        }
        try {
            return URLEncoder.encode(str, XmartV1Constants.UTF8_ENCODING);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str;
        }
    }
}
