package defpackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* compiled from: StatEvent.java */
/* renamed from: t8  reason: default package */
/* loaded from: classes.dex */
public class t8 extends q8 {
    private aa f;
    private Map<v9, a> g;

    /* compiled from: StatEvent.java */
    /* renamed from: t8$a */
    /* loaded from: classes.dex */
    public class a {
        private int a = 0;
        private int b = 0;
        private List<z9> c = new ArrayList();

        public a() {
        }

        private z9 b(z9 z9Var) {
            List<w9> e;
            z9 z9Var2 = (z9) y8.a().b(z9.class, new Object[0]);
            if (t8.this.f != null && t8.this.f.e() != null && (e = t8.this.f.e().e()) != null) {
                int size = e.size();
                for (int i = 0; i < size; i++) {
                    w9 w9Var = e.get(i);
                    if (w9Var != null) {
                        y9 y9Var = (y9) y8.a().b(y9.class, new Object[0]);
                        y9 g = z9Var.g(w9Var.d());
                        if (g.e() != null) {
                            y9Var.j(g.e().doubleValue());
                        }
                        y9Var.k(g.f());
                        z9Var2.j(w9Var.d(), y9Var);
                    }
                }
            }
            return z9Var2;
        }

        public List<Map<String, Map<String, Double>>> c() {
            Map<String, y9> f;
            List<z9> list = this.c;
            if (list == null || list.isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                z9 z9Var = this.c.get(i);
                if (z9Var != null && (f = z9Var.f()) != null && !f.isEmpty()) {
                    HashMap hashMap = new HashMap();
                    for (Map.Entry<String, y9> entry : f.entrySet()) {
                        HashMap hashMap2 = new HashMap();
                        String key = entry.getKey();
                        y9 value = entry.getValue();
                        hashMap2.put("value", Double.valueOf(value.f()));
                        if (value.e() != null) {
                            hashMap2.put("offset", value.e());
                        }
                        hashMap.put(key, hashMap2);
                    }
                    arrayList.add(hashMap);
                }
            }
            return arrayList;
        }

        public void d(z9 z9Var) {
            if (z9Var != null) {
                if (t8.this.f != null && t8.this.f.i()) {
                    this.c.add(b(z9Var));
                } else if (this.c.isEmpty()) {
                    this.c.add(b(z9Var));
                } else {
                    this.c.get(0).h(z9Var);
                }
            }
        }

        public void f() {
            this.a++;
        }

        public void g() {
            this.b++;
        }
    }

    @Override // defpackage.q8, defpackage.z8
    public synchronized void a() {
        super.a();
        this.f = null;
        for (v9 v9Var : this.g.keySet()) {
            y8.a().d(v9Var);
        }
        this.g.clear();
    }

    @Override // defpackage.q8, defpackage.z8
    public void b(Object... objArr) {
        super.b(objArr);
        if (this.g == null) {
            this.g = new HashMap();
        }
        this.f = ba.c().b(this.b, this.c);
    }

    @Override // defpackage.q8
    public synchronized JSONObject c() {
        JSONObject c;
        Set<String> keySet;
        c = super.c();
        try {
            aa aaVar = this.f;
            if (aaVar != null) {
                c.put("isCommitDetail", String.valueOf(aaVar.i()));
            }
            JSONArray jSONArray = (JSONArray) y8.a().b(b9.class, new Object[0]);
            Map<v9, a> map = this.g;
            if (map != null) {
                for (Map.Entry<v9, a> entry : map.entrySet()) {
                    JSONObject jSONObject = (JSONObject) y8.a().b(c9.class, new Object[0]);
                    v9 key = entry.getKey();
                    a value = entry.getValue();
                    Object valueOf = Integer.valueOf(value.a);
                    Object valueOf2 = Integer.valueOf(value.b);
                    jSONObject.put("count", valueOf);
                    jSONObject.put("noise", valueOf2);
                    jSONObject.put("dimensions", key != null ? new JSONObject(key.g()) : "");
                    List<Map<String, Map<String, Double>>> c2 = value.c();
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i = 0; i < c2.size(); i++) {
                        JSONObject jSONObject2 = new JSONObject();
                        Map<String, Map<String, Double>> map2 = c2.get(i);
                        if (map2 != null && (keySet = map2.keySet()) != null) {
                            for (String str : keySet) {
                                if (map2.get(str) != null) {
                                    jSONObject2.put(str, new JSONObject(map2.get(str)));
                                } else {
                                    jSONObject2.put(str, "");
                                }
                            }
                        }
                        jSONArray2.put(jSONObject2);
                    }
                    jSONObject.put("measures", jSONArray2);
                    jSONArray.put(jSONObject);
                }
            }
            c.put("values", jSONArray);
        } catch (Exception unused) {
        }
        return c;
    }

    public synchronized void e(v9 v9Var, z9 z9Var) {
        a aVar;
        if (v9Var == null) {
            v9 v9Var2 = (v9) y8.a().b(v9.class, new Object[0]);
            v9Var2.d(v9Var);
            v9Var = v9Var2;
        }
        if (this.g.containsKey(v9Var)) {
            aVar = this.g.get(v9Var);
        } else {
            v9 v9Var3 = (v9) y8.a().b(v9.class, new Object[0]);
            v9Var3.d(v9Var);
            a aVar2 = new a();
            this.g.put(v9Var3, aVar2);
            aVar = aVar2;
        }
        aa aaVar = this.f;
        if (aaVar != null ? aaVar.l(v9Var, z9Var) : false) {
            aVar.f();
            aVar.d(z9Var);
        } else {
            aVar.g();
            if (this.f.i()) {
                aVar.d(z9Var);
            }
        }
        ya.c("StatEvent", "entity  count:", Integer.valueOf(aVar.a), " noise:", Integer.valueOf(aVar.b));
    }
}
