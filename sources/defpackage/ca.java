package defpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* compiled from: MetricValueSet.java */
/* renamed from: ca  reason: default package */
/* loaded from: classes.dex */
public class ca implements z8 {
    private Map<aa, q8> b = Collections.synchronizedMap(new HashMap());

    @Override // defpackage.z8
    public void a() {
        for (q8 q8Var : this.b.values()) {
            y8.a().d(q8Var);
        }
        this.b.clear();
    }

    @Override // defpackage.z8
    public void b(Object... objArr) {
        if (this.b == null) {
            this.b = Collections.synchronizedMap(new HashMap());
        }
    }

    public q8 c(Integer num, String str, String str2, String str3, Class<? extends q8> cls) {
        aa aaVar;
        boolean z;
        q8 q8Var;
        boolean z2 = false;
        if (num.intValue() == s8.STAT.a()) {
            aaVar = ba.c().b(str, str2);
            z = false;
        } else {
            aaVar = (aa) y8.a().b(aa.class, str, str2, str3);
            z = true;
        }
        q8 q8Var2 = null;
        if (aaVar != null) {
            if (this.b.containsKey(aaVar)) {
                q8Var2 = this.b.get(aaVar);
                z2 = z;
            } else {
                synchronized (ca.class) {
                    q8Var = (q8) y8.a().b(cls, num, str, str2, str3);
                    this.b.put(aaVar, q8Var);
                }
                q8Var2 = q8Var;
            }
            if (z2) {
                y8.a().d(aaVar);
            }
        }
        return q8Var2;
    }

    public List<q8> d() {
        return new ArrayList(this.b.values());
    }
}
