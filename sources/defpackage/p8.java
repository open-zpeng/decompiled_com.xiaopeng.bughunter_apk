package defpackage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* compiled from: DurationEvent.java */
/* renamed from: p8  reason: default package */
/* loaded from: classes.dex */
public class p8 extends q8 {
    private static final Long f = 300000L;
    private aa g;
    private z9 h;
    private v9 i;
    private Map<String, y9> j;
    private Long k;

    @Override // defpackage.q8, defpackage.z8
    public void a() {
        super.a();
        this.g = null;
        this.k = null;
        for (y9 y9Var : this.j.values()) {
            y8.a().d(y9Var);
        }
        this.j.clear();
        if (this.h != null) {
            y8.a().d(this.h);
            this.h = null;
        }
        if (this.i != null) {
            y8.a().d(this.i);
            this.i = null;
        }
    }

    @Override // defpackage.q8, defpackage.z8
    public void b(Object... objArr) {
        super.b(objArr);
        if (this.j == null) {
            this.j = new HashMap();
        }
        aa b = ba.c().b(this.b, this.c);
        this.g = b;
        if (b.d() != null) {
            this.i = (v9) y8.a().b(v9.class, new Object[0]);
            this.g.d().c(this.i);
        }
        this.h = (z9) y8.a().b(z9.class, new Object[0]);
    }

    public v9 d() {
        return this.i;
    }

    public z9 e() {
        return this.h;
    }

    public void f(v9 v9Var) {
        v9 v9Var2 = this.i;
        if (v9Var2 == null) {
            this.i = v9Var;
        } else {
            v9Var2.d(v9Var);
        }
    }

    public void g(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.j.isEmpty()) {
            this.k = Long.valueOf(currentTimeMillis);
        }
        this.j.put(str, (y9) y8.a().b(y9.class, Double.valueOf(currentTimeMillis), Double.valueOf(currentTimeMillis - this.k.longValue())));
    }

    public boolean h(String str) {
        y9 y9Var = this.j.get(str);
        if (y9Var != null) {
            double currentTimeMillis = System.currentTimeMillis();
            ya.c("DurationEvent", "statEvent consumeTime. module:", this.b, " monitorPoint:", this.c, " measureName:", str, " time:", Double.valueOf(currentTimeMillis - y9Var.f()));
            y9Var.k(currentTimeMillis - y9Var.f());
            y9Var.i(true);
            this.h.j(str, y9Var);
            if (this.g.e().g(this.h)) {
                return true;
            }
        }
        return false;
    }

    public boolean i() {
        long currentTimeMillis = System.currentTimeMillis();
        List<w9> e = this.g.e().e();
        if (e != null) {
            int size = e.size();
            for (int i = 0; i < size; i++) {
                w9 w9Var = e.get(i);
                if (w9Var != null) {
                    double doubleValue = w9Var.c() != null ? w9Var.c().doubleValue() : f.longValue();
                    y9 y9Var = this.j.get(w9Var.d());
                    if (y9Var != null && !y9Var.g() && currentTimeMillis - y9Var.f() > doubleValue) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
