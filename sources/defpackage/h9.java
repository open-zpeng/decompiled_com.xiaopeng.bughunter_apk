package defpackage;

import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* compiled from: AlarmModuleSampling.java */
/* renamed from: h9  reason: default package */
/* loaded from: classes.dex */
public class h9 extends l9 {
    private int d;
    private int e;

    public h9(String str, int i, int i2) {
        super(str, 0);
        int i3 = this.a;
        this.d = i3;
        this.e = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.e9
    public void a(JSONObject jSONObject) {
        super.a(jSONObject);
        int i = this.a;
        this.d = i;
        this.e = i;
        try {
            Integer valueOf = Integer.valueOf(jSONObject.getInt("successSampling"));
            if (valueOf != null) {
                this.d = valueOf.intValue();
            }
            Integer valueOf2 = Integer.valueOf(jSONObject.getInt("failSampling"));
            if (valueOf2 != null) {
                this.e = valueOf2.intValue();
            }
            ya.c("AlarmModuleSampling", "[updateSelfSampling]", jSONObject, "successSampling:", valueOf, "failSampling");
        } catch (Exception unused) {
        }
    }

    @Override // defpackage.l9
    public /* bridge */ /* synthetic */ boolean c(int i, String str, Map map) {
        return super.c(i, str, map);
    }

    @Override // defpackage.l9
    public void d(JSONObject jSONObject) {
        a(jSONObject);
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("monitorPoints");
            if (jSONArray != null) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    String string = jSONObject2.getString("monitorPoint");
                    if (q9.a(string)) {
                        m9 m9Var = this.c.get(string);
                        if (m9Var == null) {
                            m9Var = new i9(string, this.d, this.e);
                            this.c.put(string, m9Var);
                        }
                        m9Var.d(jSONObject2);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public boolean e(int i, String str, Boolean bool, Map<String, String> map) {
        m9 m9Var;
        ya.c("AlarmModuleSampling", "samplingSeed:", Integer.valueOf(i), "isSuccess:", bool, "successSampling:", Integer.valueOf(this.d), "failSampling:", Integer.valueOf(this.e));
        Map<String, m9> map2 = this.c;
        if (map2 != null && (m9Var = map2.get(str)) != null && (m9Var instanceof i9)) {
            return ((i9) m9Var).e(i, bool, map);
        }
        return f(i, bool.booleanValue());
    }

    protected boolean f(int i, boolean z) {
        return z ? i < this.d : i < this.e;
    }
}
