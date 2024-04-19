package defpackage;

import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: Event.java */
/* renamed from: q8  reason: default package */
/* loaded from: classes.dex */
public abstract class q8 implements z8 {
    public String b;
    public String c;
    public String d;
    public int e;

    @Override // defpackage.z8
    public void a() {
        this.e = 0;
        this.b = null;
        this.c = null;
        this.d = null;
    }

    @Override // defpackage.z8
    public void b(Object... objArr) {
        this.e = ((Integer) objArr[0]).intValue();
        this.b = (String) objArr[1];
        this.c = (String) objArr[2];
        if (objArr.length <= 3 || objArr[3] == null) {
            return;
        }
        this.d = (String) objArr[3];
    }

    public JSONObject c() {
        JSONObject jSONObject = (JSONObject) y8.a().b(c9.class, new Object[0]);
        try {
            jSONObject.put("page", this.b);
            jSONObject.put("monitorPoint", this.c);
            String str = this.d;
            if (str != null) {
                jSONObject.put("arg", str);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
