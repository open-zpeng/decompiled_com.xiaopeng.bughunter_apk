package defpackage;

import android.content.Context;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;
/* compiled from: ExceptionEventBuilder.java */
/* renamed from: w8  reason: default package */
/* loaded from: classes.dex */
public class w8 {
    private static String a(Throwable th) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(th.getClass().getName());
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace != null) {
            for (StackTraceElement stackTraceElement : stackTrace) {
                sb.append(stackTraceElement.toString());
            }
        }
        String sb2 = sb.toString();
        return q9.b(sb2) ? th.toString() : sb2;
    }

    private static JSONObject b(Context context, Throwable th) throws IOException {
        JSONObject jSONObject = (JSONObject) y8.a().b(c9.class, new Object[0]);
        if (context != null) {
            try {
                jSONObject.put("pname", ra.a(context));
            } catch (Exception unused) {
            }
        }
        jSONObject.put("page", "APPMONITOR");
        jSONObject.put("monitorPoint", "sdk-exception");
        jSONObject.put("arg", th.getClass().getSimpleName());
        jSONObject.put("successCount", 0);
        jSONObject.put("failCount", 1);
        ArrayList arrayList = new ArrayList();
        String a = a(th);
        if (a != null) {
            JSONObject jSONObject2 = (JSONObject) y8.a().b(c9.class, new Object[0]);
            jSONObject2.put("errorCode", a);
            jSONObject2.put("errorCount", 1);
            arrayList.add(jSONObject2);
        }
        jSONObject.put("errors", arrayList);
        return jSONObject;
    }

    public static void c(Context context, Throwable th) {
        if (th != null) {
            try {
                u8 u8Var = (u8) y8.a().b(u8.class, new Object[0]);
                s8 s8Var = s8.ALARM;
                u8Var.c = s8Var.a();
                HashMap hashMap = new HashMap();
                hashMap.put("meta", j8.a());
                b9 b9Var = (b9) y8.a().b(b9.class, new Object[0]);
                b9Var.put(b(context, th));
                hashMap.put("data", b9Var);
                u8Var.g.put(s8Var.m110a(), new JSONObject(hashMap).toString());
                u8Var.d = "APPMONITOR";
                u8Var.e = "sdk-exception";
                r9.a(u8Var);
                y8.a().d(b9Var);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public static void d(Throwable th) {
        c(null, th);
    }
}
