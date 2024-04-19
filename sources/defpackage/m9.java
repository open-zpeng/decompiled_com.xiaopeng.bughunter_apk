package defpackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* compiled from: MonitorPointSampling.java */
/* renamed from: m9  reason: default package */
/* loaded from: classes.dex */
class m9 extends e9<JSONObject> {
    private String b;
    protected List<g9> c;

    public m9(String str, int i) {
        super(i);
        this.b = str;
    }

    public boolean c(int i, Map<String, String> map) {
        List<g9> list = this.c;
        if (list != null && map != null) {
            for (g9 g9Var : list) {
                Boolean c = g9Var.c(i, map);
                if (c != null) {
                    return c.booleanValue();
                }
            }
        }
        return b(i);
    }

    public void d(JSONObject jSONObject) {
        a(jSONObject);
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("extra");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    g9 g9Var = new g9(this.a);
                    if (this.c == null) {
                        this.c = new ArrayList();
                    }
                    this.c.add(g9Var);
                    g9Var.d(jSONObject2);
                }
            }
        } catch (Exception unused) {
        }
    }
}
