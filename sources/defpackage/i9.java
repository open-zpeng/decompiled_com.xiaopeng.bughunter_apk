package defpackage;

import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* compiled from: AlarmMonitorPointSampling.java */
/* renamed from: i9  reason: default package */
/* loaded from: classes.dex */
public class i9 extends m9 {
    private int d;
    private int e;

    public i9(String str, int i, int i2) {
        super(str, 0);
        this.d = i;
        this.e = i2;
    }

    @Override // defpackage.m9
    public /* bridge */ /* synthetic */ boolean c(int i, Map map) {
        return super.c(i, map);
    }

    @Override // defpackage.m9
    public void d(JSONObject jSONObject) {
        super.d(jSONObject);
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
            ya.c("AlarmMonitorPointSampling", "[updateSelfSampling]", jSONObject, "successSampling:", valueOf, "failSampling", valueOf2);
        } catch (Exception unused) {
        }
    }

    public boolean e(int i, Boolean bool, Map<String, String> map) {
        ya.c("AlarmMonitorPointSampling", "samplingSeed:", Integer.valueOf(i), "isSuccess:", bool, "successSampling:", Integer.valueOf(this.d), "failSampling:", Integer.valueOf(this.e));
        List<g9> list = this.c;
        if (list != null && map != null) {
            for (g9 g9Var : list) {
                Boolean c = g9Var.c(i, map);
                if (c != null) {
                    return c.booleanValue();
                }
            }
        }
        return f(i, bool.booleanValue());
    }

    protected boolean f(int i, boolean z) {
        return z ? i < this.d : i < this.e;
    }
}
