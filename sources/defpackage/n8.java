package defpackage;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* compiled from: AlarmEvent.java */
/* renamed from: n8  reason: default package */
/* loaded from: classes.dex */
public class n8 extends q8 {
    public int f = 0;
    public int g = 0;
    public Map<String, String> h;
    public Map<String, Integer> i;

    @Override // defpackage.q8, defpackage.z8
    public synchronized void a() {
        super.a();
        this.f = 0;
        this.g = 0;
        Map<String, String> map = this.h;
        if (map != null) {
            map.clear();
        }
        Map<String, Integer> map2 = this.i;
        if (map2 != null) {
            map2.clear();
        }
    }

    @Override // defpackage.q8
    public synchronized JSONObject c() {
        JSONObject c;
        c = super.c();
        try {
            c.put("successCount", this.f);
            c.put("failCount", this.g);
            if (this.i != null) {
                JSONArray jSONArray = (JSONArray) y8.a().b(b9.class, new Object[0]);
                for (Map.Entry<String, Integer> entry : this.i.entrySet()) {
                    JSONObject jSONObject = (JSONObject) y8.a().b(c9.class, new Object[0]);
                    String key = entry.getKey();
                    jSONObject.put("errorCode", key);
                    jSONObject.put("errorCount", entry.getValue());
                    if (this.h.containsKey(key)) {
                        jSONObject.put("errorMsg", this.h.get(key));
                    }
                    jSONArray.put(jSONObject);
                }
                c.put("errors", jSONArray);
            }
        } catch (Exception unused) {
        }
        return c;
    }

    public synchronized void d(String str, String str2) {
        if (q9.b(str)) {
            return;
        }
        if (this.h == null) {
            this.h = new HashMap();
        }
        if (this.i == null) {
            this.i = new HashMap();
        }
        if (q9.a(str2)) {
            int i = 100;
            if (str2.length() <= 100) {
                i = str2.length();
            }
            this.h.put(str, str2.substring(0, i));
        }
        if (!this.i.containsKey(str)) {
            this.i.put(str, 1);
        } else {
            Map<String, Integer> map = this.i;
            map.put(str, Integer.valueOf(map.get(str).intValue() + 1));
        }
    }

    public synchronized void e() {
        this.f++;
    }

    public synchronized void f() {
        this.g++;
    }
}
