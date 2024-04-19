package defpackage;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* compiled from: EventTypeSampling.java */
/* renamed from: k9  reason: default package */
/* loaded from: classes.dex */
class k9 extends e9<JSONObject> {
    private s8 b;
    protected Map<String, l9> c;
    protected int d;

    public k9(s8 s8Var, int i) {
        super(i);
        this.d = -1;
        this.b = s8Var;
        this.c = Collections.synchronizedMap(new HashMap());
    }

    public boolean c(int i, String str, String str2, Map<String, String> map) {
        l9 l9Var;
        Map<String, l9> map2 = this.c;
        if (map2 == null || (l9Var = map2.get(str)) == null) {
            return i < this.a;
        }
        return l9Var.c(i, str2, map);
    }

    public void d(JSONObject jSONObject) {
        a(jSONObject);
        e(jSONObject);
        this.c.clear();
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("metrics");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    String optString = jSONObject2.optString("module");
                    if (q9.a(optString)) {
                        l9 l9Var = this.c.get(optString);
                        if (l9Var == null) {
                            l9Var = new l9(optString, this.a);
                            this.c.put(optString, l9Var);
                        }
                        l9Var.d(jSONObject2);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(JSONObject jSONObject) {
        s8 s8Var;
        ya.c("EventTypeSampling", "[updateEventTypeTriggerCount]", this, jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            int optInt = jSONObject.optInt("cacheCount");
            if (optInt <= 0 || (s8Var = this.b) == null) {
                return;
            }
            s8Var.b(optInt);
        } catch (Throwable th) {
            ya.b("EventTypeSampling", "updateTriggerCount", th);
        }
    }

    public void f(int i) {
        this.a = i;
    }
}
