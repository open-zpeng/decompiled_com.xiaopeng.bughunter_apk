package defpackage;

import android.content.Context;
import com.alibaba.sdk.android.man.crashreporter.a.a.a.b.a;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.json.JSONObject;
/* compiled from: SampleRules.java */
/* renamed from: n9  reason: default package */
/* loaded from: classes.dex */
public class n9 {
    private static final String a = null;
    private static n9 b;
    private Map<s8, k9> c = new HashMap();
    private int d;
    private String e;

    private n9() {
        s8[] values;
        for (s8 s8Var : s8.values()) {
            if (s8Var == s8.ALARM) {
                this.c.put(s8Var, new j9(s8Var, s8Var.e()));
            } else {
                this.c.put(s8Var, new k9(s8Var, s8Var.e()));
            }
        }
    }

    public static n9 a() {
        if (b == null) {
            synchronized (n9.class) {
                if (b == null) {
                    b = new n9();
                }
            }
        }
        return b;
    }

    public static boolean d(s8 s8Var, String str, String str2) {
        return a().h(s8Var, str, str2, null);
    }

    public static boolean e(s8 s8Var, String str, String str2, Map<String, String> map) {
        return a().h(s8Var, str, str2, map);
    }

    public static boolean f(String str, String str2, Boolean bool, Map<String, String> map) {
        return a().i(str, str2, bool, map);
    }

    public void b(Context context) {
        j();
    }

    public void c(s8 s8Var, int i) {
        k9 k9Var = this.c.get(s8Var);
        if (k9Var != null) {
            k9Var.f(i);
        }
    }

    public void g(String str) {
        String str2;
        s8[] values;
        ya.c("SampleRules", "config:", str);
        synchronized (this) {
            if (!q9.b(str) && ((str2 = this.e) == null || !str2.equals(str))) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    for (s8 s8Var : s8.values()) {
                        JSONObject optJSONObject = jSONObject.optJSONObject(s8Var.toString());
                        k9 k9Var = this.c.get(s8Var);
                        if (optJSONObject != null && k9Var != null) {
                            ya.c(a, s8Var, optJSONObject);
                            k9Var.d(optJSONObject);
                        }
                    }
                    this.e = str;
                } catch (Throwable unused) {
                }
            }
        }
    }

    public boolean h(s8 s8Var, String str, String str2, Map<String, String> map) {
        k9 k9Var = this.c.get(s8Var);
        if (k9Var != null) {
            return k9Var.c(this.d, str, str2, map);
        }
        return false;
    }

    public boolean i(String str, String str2, Boolean bool, Map<String, String> map) {
        k9 k9Var = this.c.get(s8.ALARM);
        if (k9Var == null || !(k9Var instanceof j9)) {
            return false;
        }
        return ((j9) k9Var).g(this.d, str, str2, bool, map);
    }

    public void j() {
        this.d = new Random(System.currentTimeMillis()).nextInt(a.r);
    }
}
