package defpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* compiled from: HostConfigMgr.java */
/* renamed from: ia  reason: default package */
/* loaded from: classes.dex */
public class ia {
    private static ia a = new ia();
    private Map<String, ha> b = Collections.synchronizedMap(new HashMap());
    private String c;

    public static ia a() {
        return a;
    }

    public Map<String, ha> b() {
        return this.b;
    }

    public void c(String str) {
        JSONObject jSONObject;
        ya.c("HostConfigMgr", "host config:" + str);
        if (str != null) {
            try {
                JSONObject jSONObject2 = new JSONObject(str);
                JSONObject jSONObject3 = jSONObject2.getJSONObject("content");
                if (jSONObject3 != null && (jSONObject = jSONObject3.getJSONObject("hosts")) != null) {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (next != null) {
                            ha haVar = new ha();
                            JSONObject jSONObject4 = jSONObject.getJSONObject(next);
                            if (jSONObject4 != null) {
                                haVar.c = next.substring(1);
                                haVar.a = jSONObject4.getString("host");
                                JSONArray jSONArray = jSONObject4.getJSONArray("eids");
                                if (jSONArray != null) {
                                    haVar.b = new ArrayList<>();
                                    for (int i = 0; i < jSONArray.length(); i++) {
                                        haVar.b.add(jSONArray.getString(i));
                                    }
                                }
                            }
                            this.b.put(haVar.c + "", haVar);
                        }
                    }
                }
                this.c = jSONObject2.getString("timestamp");
            } catch (Throwable unused) {
            }
        }
    }
}
