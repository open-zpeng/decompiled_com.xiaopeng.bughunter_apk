package defpackage;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import java.util.Locale;
import java.util.StringTokenizer;
import okhttp3.Headers;
/* compiled from: HeaderParser.java */
/* renamed from: id  reason: default package */
/* loaded from: classes.dex */
public class id {
    public static <T> void a(hd hdVar, zb<T> zbVar, ac acVar) {
        xc f;
        if (zbVar == null || acVar != ac.DEFAULT || (f = zbVar.f()) == null) {
            return;
        }
        String c = f.c(HttpHeaders.ETAG);
        if (c != null) {
            hdVar.u("If-None-Match", c);
        }
        long h = xc.h(f.c(HttpHeaders.LAST_MODIFIED));
        if (h > 0) {
            hdVar.u("If-Modified-Since", xc.b(h));
        }
    }

    public static <T> zb<T> b(Headers headers, T t, ac acVar, String str) {
        long currentTimeMillis;
        long j;
        if (acVar == ac.DEFAULT) {
            long f = xc.f(headers.get(HttpHeaders.DATE));
            currentTimeMillis = xc.g(headers.get(HttpHeaders.EXPIRES));
            String e = xc.e(headers.get(HttpHeaders.CACHE_CONTROL), headers.get("Pragma"));
            if (TextUtils.isEmpty(e) && currentTimeMillis <= 0) {
                return null;
            }
            if (TextUtils.isEmpty(e)) {
                j = 0;
            } else {
                StringTokenizer stringTokenizer = new StringTokenizer(e, ",");
                j = 0;
                while (stringTokenizer.hasMoreTokens()) {
                    String lowerCase = stringTokenizer.nextToken().trim().toLowerCase(Locale.getDefault());
                    if (lowerCase.equals("no-cache") || lowerCase.equals("no-store")) {
                        return null;
                    }
                    if (lowerCase.startsWith("max-age=")) {
                        try {
                            j = Long.parseLong(lowerCase.substring(8));
                            if (j <= 0) {
                                return null;
                            }
                        } catch (Exception e2) {
                            ld.a(e2);
                        }
                    }
                }
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            if (f <= 0) {
                f = currentTimeMillis2;
            }
            if (j > 0) {
                currentTimeMillis = f + (j * 1000);
            } else if (currentTimeMillis < 0) {
                currentTimeMillis = 0;
            }
        } else {
            currentTimeMillis = System.currentTimeMillis();
        }
        xc xcVar = new xc();
        for (String str2 : headers.names()) {
            xcVar.m(str2, headers.get(str2));
        }
        zb<T> zbVar = new zb<>();
        zbVar.k(str);
        zbVar.i(t);
        zbVar.l(currentTimeMillis);
        zbVar.m(xcVar);
        return zbVar;
    }
}
