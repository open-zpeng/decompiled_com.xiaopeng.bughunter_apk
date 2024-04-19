package defpackage;

import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* compiled from: AlarmSampling.java */
/* renamed from: j9  reason: default package */
/* loaded from: classes.dex */
public class j9 extends k9 {
    String e;
    private int f;
    private int g;

    public j9(s8 s8Var, int i) {
        super(s8Var, i);
        this.e = "AlarmSampling";
        this.f = 0;
        this.g = 0;
        this.f = i;
        this.g = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.e9
    public void a(JSONObject jSONObject) {
        super.a(jSONObject);
        int i = this.a;
        this.f = i;
        this.g = i;
        try {
            Integer valueOf = Integer.valueOf(jSONObject.getInt("successSampling"));
            if (valueOf != null) {
                this.f = valueOf.intValue();
            }
            Integer valueOf2 = Integer.valueOf(jSONObject.getInt("failSampling"));
            if (valueOf2 != null) {
                this.g = valueOf2.intValue();
            }
        } catch (Exception unused) {
        }
    }

    @Override // defpackage.k9
    public /* bridge */ /* synthetic */ boolean c(int i, String str, String str2, Map map) {
        return super.c(i, str, str2, map);
    }

    @Override // defpackage.k9
    public void d(JSONObject jSONObject) {
        a(jSONObject);
        e(jSONObject);
        this.c.clear();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("metrics");
            if (jSONArray != null) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    String string = jSONObject2.getString("module");
                    if (q9.a(string)) {
                        l9 l9Var = this.c.get(string);
                        if (l9Var == null) {
                            l9Var = new h9(string, this.f, this.g);
                            this.c.put(string, l9Var);
                        }
                        l9Var.d(jSONObject2);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // defpackage.k9
    public void f(int i) {
        super.f(i);
        this.f = i;
        this.g = i;
    }

    public boolean g(int i, String str, String str2, Boolean bool, Map<String, String> map) {
        l9 l9Var;
        String str3 = this.e;
        ya.c(str3, "samplingSeed:", Integer.valueOf(i), "isSuccess:", bool, "successSampling:", Integer.valueOf(this.f), "failSampling:" + this.g);
        Map<String, l9> map2 = this.c;
        if (map2 == null || (l9Var = map2.get(str)) == null || !(l9Var instanceof h9)) {
            return bool.booleanValue() ? i < this.f : i < this.g;
        }
        return ((h9) l9Var).e(i, str2, bool, map);
    }
}
