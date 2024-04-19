package defpackage;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* compiled from: AccurateSampling.java */
/* renamed from: g9  reason: default package */
/* loaded from: classes.dex */
public class g9 extends e9<JSONObject> {
    private Map<String, f9> b;

    public g9(int i) {
        super(i);
        this.b = new HashMap();
    }

    public Boolean c(int i, Map<String, String> map) {
        Map<String, f9> map2;
        if (map == null || (map2 = this.b) == null) {
            return null;
        }
        for (String str : map2.keySet()) {
            if (!this.b.get(str).a(map.get(str))) {
                return null;
            }
        }
        return Boolean.valueOf(b(i));
    }

    public void d(JSONObject jSONObject) {
        a(jSONObject);
    }
}
