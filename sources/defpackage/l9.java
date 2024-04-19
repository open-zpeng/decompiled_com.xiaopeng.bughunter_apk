package defpackage;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* compiled from: ModuleSampling.java */
/* renamed from: l9  reason: default package */
/* loaded from: classes.dex */
class l9 extends e9<JSONObject> {
    private String b;
    protected Map<String, m9> c;

    public l9(String str, int i) {
        super(i);
        this.b = str;
        this.c = new HashMap();
    }

    public boolean c(int i, String str, Map<String, String> map) {
        m9 m9Var;
        Map<String, m9> map2 = this.c;
        if (map2 != null && (m9Var = map2.get(str)) != null) {
            return m9Var.c(i, map);
        }
        return b(i);
    }

    public void d(JSONObject jSONObject) {
        a(jSONObject);
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("monitorPoints");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    String optString = jSONObject2.optString("monitorPoint");
                    String optString2 = jSONObject2.optString("metric_comment_detail");
                    if (q9.a(optString)) {
                        m9 m9Var = this.c.get(optString);
                        if (m9Var == null) {
                            m9Var = new m9(optString, this.a);
                            this.c.put(optString, m9Var);
                        }
                        m9Var.d(jSONObject2);
                        aa b = ba.c().b(this.b, optString);
                        if (b != null) {
                            b.k(optString2);
                        }
                        Object opt = jSONObject2.opt("measures");
                        if (opt instanceof JSONArray) {
                            JSONArray jSONArray = (JSONArray) opt;
                            x9 c = x9.c();
                            int length = jSONArray.length();
                            for (int i2 = 0; i2 < length; i2++) {
                                JSONObject jSONObject3 = jSONArray.getJSONObject(i2);
                                if (jSONObject3 != null) {
                                    String optString3 = jSONObject3.optString("name");
                                    Double valueOf = Double.valueOf(jSONObject3.optDouble("min"));
                                    Double valueOf2 = Double.valueOf(jSONObject3.optDouble("max"));
                                    if (optString3 != null && valueOf != null && valueOf2 != null) {
                                        c.b(new w9(optString3, Double.valueOf(0.0d), valueOf, valueOf2));
                                    }
                                }
                            }
                            aa b2 = ba.c().b("config_prefix" + this.b, "config_prefix" + optString);
                            if (b2 != null) {
                                ba.c().d(b2);
                            }
                            ba.c().a(new s9("config_prefix" + this.b, "config_prefix" + optString, c));
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
    }
}
