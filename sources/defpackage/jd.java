package defpackage;

import defpackage.yc;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
/* compiled from: HttpUtils.java */
/* renamed from: jd  reason: default package */
/* loaded from: classes.dex */
public class jd {
    public static Request.Builder a(Request.Builder builder, xc xcVar) {
        if (xcVar.e.isEmpty()) {
            return builder;
        }
        Headers.Builder builder2 = new Headers.Builder();
        try {
            for (Map.Entry<String, String> entry : xcVar.e.entrySet()) {
                builder2.add(entry.getKey(), entry.getValue());
            }
        } catch (Exception e) {
            ld.a(e);
        }
        builder.headers(builder2.build());
        return builder;
    }

    public static <T> T b(T t, String str) {
        Objects.requireNonNull(t, str);
        return t;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0032 A[Catch: UnsupportedEncodingException -> 0x0077, TryCatch #0 {UnsupportedEncodingException -> 0x0077, blocks: (B:2:0x0000, B:6:0x0014, B:9:0x001b, B:11:0x0024, B:12:0x002c, B:14:0x0032, B:15:0x0042, B:17:0x0048, B:18:0x0069, B:10:0x0021), top: B:23:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String c(java.lang.String r6, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r7) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.io.UnsupportedEncodingException -> L77
            r0.<init>()     // Catch: java.io.UnsupportedEncodingException -> L77
            r0.append(r6)     // Catch: java.io.UnsupportedEncodingException -> L77
            r1 = 38
            int r1 = r6.indexOf(r1)     // Catch: java.io.UnsupportedEncodingException -> L77
            java.lang.String r2 = "&"
            if (r1 > 0) goto L21
            r1 = 63
            int r1 = r6.indexOf(r1)     // Catch: java.io.UnsupportedEncodingException -> L77
            if (r1 <= 0) goto L1b
            goto L21
        L1b:
            java.lang.String r1 = "?"
            r0.append(r1)     // Catch: java.io.UnsupportedEncodingException -> L77
            goto L24
        L21:
            r0.append(r2)     // Catch: java.io.UnsupportedEncodingException -> L77
        L24:
            java.util.Set r7 = r7.entrySet()     // Catch: java.io.UnsupportedEncodingException -> L77
            java.util.Iterator r7 = r7.iterator()     // Catch: java.io.UnsupportedEncodingException -> L77
        L2c:
            boolean r1 = r7.hasNext()     // Catch: java.io.UnsupportedEncodingException -> L77
            if (r1 == 0) goto L69
            java.lang.Object r1 = r7.next()     // Catch: java.io.UnsupportedEncodingException -> L77
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch: java.io.UnsupportedEncodingException -> L77
            java.lang.Object r3 = r1.getValue()     // Catch: java.io.UnsupportedEncodingException -> L77
            java.util.List r3 = (java.util.List) r3     // Catch: java.io.UnsupportedEncodingException -> L77
            java.util.Iterator r3 = r3.iterator()     // Catch: java.io.UnsupportedEncodingException -> L77
        L42:
            boolean r4 = r3.hasNext()     // Catch: java.io.UnsupportedEncodingException -> L77
            if (r4 == 0) goto L2c
            java.lang.Object r4 = r3.next()     // Catch: java.io.UnsupportedEncodingException -> L77
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.io.UnsupportedEncodingException -> L77
            java.lang.String r5 = "UTF-8"
            java.lang.String r4 = java.net.URLEncoder.encode(r4, r5)     // Catch: java.io.UnsupportedEncodingException -> L77
            java.lang.Object r5 = r1.getKey()     // Catch: java.io.UnsupportedEncodingException -> L77
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.io.UnsupportedEncodingException -> L77
            r0.append(r5)     // Catch: java.io.UnsupportedEncodingException -> L77
            java.lang.String r5 = "="
            r0.append(r5)     // Catch: java.io.UnsupportedEncodingException -> L77
            r0.append(r4)     // Catch: java.io.UnsupportedEncodingException -> L77
            r0.append(r2)     // Catch: java.io.UnsupportedEncodingException -> L77
            goto L42
        L69:
            int r7 = r0.length()     // Catch: java.io.UnsupportedEncodingException -> L77
            int r7 = r7 + (-1)
            r0.deleteCharAt(r7)     // Catch: java.io.UnsupportedEncodingException -> L77
            java.lang.String r6 = r0.toString()     // Catch: java.io.UnsupportedEncodingException -> L77
            return r6
        L77:
            r7 = move-exception
            defpackage.ld.a(r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.jd.c(java.lang.String, java.util.Map):java.lang.String");
    }

    public static RequestBody d(yc ycVar, boolean z) {
        if (ycVar.f.isEmpty() && !z) {
            FormBody.Builder builder = new FormBody.Builder();
            for (String str : ycVar.e.keySet()) {
                for (String str2 : ycVar.e.get(str)) {
                    builder.add(str, str2);
                }
            }
            return builder.build();
        }
        MultipartBody.Builder type = new MultipartBody.Builder().setType(MultipartBody.FORM);
        if (!ycVar.e.isEmpty()) {
            for (Map.Entry<String, List<String>> entry : ycVar.e.entrySet()) {
                for (String str3 : entry.getValue()) {
                    type.addFormDataPart(entry.getKey(), str3);
                }
            }
        }
        for (Map.Entry<String, List<yc.a>> entry2 : ycVar.f.entrySet()) {
            for (yc.a aVar : entry2.getValue()) {
                type.addFormDataPart(entry2.getKey(), aVar.c, RequestBody.create(aVar.d, aVar.b));
            }
        }
        return type.build();
    }

    public static MediaType e(String str) {
        String contentTypeFor = URLConnection.getFileNameMap().getContentTypeFor(str.replace("#", ""));
        if (contentTypeFor == null) {
            return yc.d;
        }
        return MediaType.parse(contentTypeFor);
    }

    public static void f(Runnable runnable) {
        wb.h().g().post(runnable);
    }
}
