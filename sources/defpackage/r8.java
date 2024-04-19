package defpackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: EventRepo.java */
/* renamed from: r8  reason: default package */
/* loaded from: classes.dex */
public class r8 {
    private static r8 a;
    private AtomicInteger d = new AtomicInteger(0);
    private AtomicInteger e = new AtomicInteger(0);
    private AtomicInteger f = new AtomicInteger(0);
    private Map<da, ca> c = new ConcurrentHashMap();
    private Map<String, p8> b = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EventRepo.java */
    /* renamed from: r8$a */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        final /* synthetic */ Map b;

        a(Map map) {
            this.b = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            r9.d(this.b);
        }
    }

    private r8() {
    }

    private q8 a(da daVar, String str, String str2, String str3, Class<? extends q8> cls) {
        Integer k;
        ca caVar;
        if (q9.a(str) && q9.a(str2) && (k = daVar.k()) != null) {
            synchronized (this.c) {
                caVar = this.c.get(daVar);
                if (caVar == null) {
                    caVar = (ca) y8.a().b(ca.class, new Object[0]);
                    this.c.put(daVar, caVar);
                }
            }
            return caVar.c(k, str, str2, str3, cls);
        }
        return null;
    }

    public static synchronized r8 b() {
        r8 r8Var;
        synchronized (r8.class) {
            if (a == null) {
                a = new r8();
            }
            r8Var = a;
        }
        return r8Var;
    }

    private da c(int i, Map<String, String> map) {
        da daVar = (da) y8.a().b(da.class, new Object[0]);
        if (map != null) {
            daVar.i(map);
        }
        daVar.j(pb.ACCESS.toString(), ea.e());
        daVar.j(pb.ACCESS_SUBTYPE.toString(), ea.g());
        daVar.j(pb.USERID.toString(), ea.h());
        daVar.j(pb.USERNICK.toString(), ea.i());
        daVar.j(pb.EVENTID.toString(), String.valueOf(i));
        return daVar;
    }

    private String d(String str, String str2) {
        aa b = ba.c().b(str, str2);
        if (b != null) {
            return b.h();
        }
        return null;
    }

    private void k(s8 s8Var, AtomicInteger atomicInteger) {
        int incrementAndGet = atomicInteger.incrementAndGet();
        ya.d("EventRepo", s8Var.toString(), " EVENT size:", String.valueOf(incrementAndGet));
        if (incrementAndGet >= s8Var.b()) {
            ya.c("EventRepo", s8Var.toString(), " event size exceed trigger count.");
            atomicInteger.set(0);
            f(s8Var.a());
        }
    }

    private void q(String str, String str2) {
        aa b = ba.c().b(str, str2);
        if (b != null) {
            b.j();
        }
    }

    public Map<da, List<q8>> e(int i) {
        HashMap hashMap = new HashMap();
        synchronized (this.c) {
            ArrayList arrayList = new ArrayList(this.c.keySet());
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                da daVar = (da) arrayList.get(i2);
                if (daVar != null && daVar.k().intValue() == i) {
                    hashMap.put(daVar, this.c.get(daVar).d());
                    this.c.remove(daVar);
                }
            }
        }
        return hashMap;
    }

    public void f(int i) {
        ib.a().g(new a(e(i)));
    }

    public void g(int i, String str, String str2, z9 z9Var, v9 v9Var, Map<String, String> map) {
        aa b = ba.c().b(str, str2);
        if (b != null) {
            if (b.d() != null) {
                b.d().c(v9Var);
            }
            if (b.e() != null) {
                b.e().f(z9Var);
            }
            da c = c(i, map);
            ((t8) a(c, str, str2, null, t8.class)).e(v9Var, z9Var);
            if (fa.g()) {
                t8 t8Var = (t8) y8.a().b(t8.class, Integer.valueOf(i), str, str2);
                t8Var.e(v9Var, z9Var);
                r9.b(c, t8Var);
            }
            k(s8.a(i), this.f);
            return;
        }
        ya.a("EventRepo", "metric is null");
    }

    public void h(int i, String str, String str2, String str3, double d, Map<String, String> map) {
        da c = c(i, map);
        ((o8) a(c, str, str2, str3, o8.class)).d(d);
        if (fa.g()) {
            o8 o8Var = (o8) y8.a().b(o8.class, Integer.valueOf(i), str, str2, str3);
            o8Var.d(d);
            r9.b(c, o8Var);
        }
        k(s8.a(i), this.e);
    }

    public void i(int i, String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        da c = c(i, map);
        n8 n8Var = (n8) a(c, str, str2, str3, n8.class);
        n8Var.f();
        n8Var.d(str4, str5);
        if (fa.g()) {
            n8 n8Var2 = (n8) y8.a().b(n8.class, Integer.valueOf(i), str, str2, str3);
            n8Var2.f();
            n8Var2.d(str4, str5);
            r9.b(c, n8Var2);
        }
        k(s8.a(i), this.d);
    }

    public void j(int i, String str, String str2, String str3, Map<String, String> map) {
        da c = c(i, map);
        ((n8) a(c, str, str2, str3, n8.class)).e();
        if (fa.g()) {
            n8 n8Var = (n8) y8.a().b(n8.class, Integer.valueOf(i), str, str2, str3);
            n8Var.e();
            r9.b(c, n8Var);
        }
        k(s8.a(i), this.d);
    }

    public void l(Integer num, String str, String str2, String str3) {
        String d = d(str, str2);
        if (d != null) {
            n(d, num, str, str2, str3);
        }
    }

    public void m(String str, Integer num, String str2, String str3, v9 v9Var) {
        p8 p8Var;
        synchronized (p8.class) {
            p8Var = this.b.get(str);
            if (p8Var == null) {
                p8Var = (p8) y8.a().b(p8.class, num, str2, str3);
                this.b.put(str, p8Var);
            }
        }
        p8Var.f(v9Var);
    }

    public void n(String str, Integer num, String str2, String str3, String str4) {
        p8 p8Var;
        aa b = ba.c().b(str2, str3);
        if (b == null || b.e() == null || b.e().d(str4) == null) {
            return;
        }
        synchronized (p8.class) {
            p8Var = this.b.get(str);
            if (p8Var == null) {
                p8Var = (p8) y8.a().b(p8.class, num, str2, str3);
                this.b.put(str, p8Var);
            }
        }
        p8Var.g(str4);
    }

    public void o(String str, String str2, String str3) {
        String d = d(str, str2);
        if (d != null) {
            p(d, str3, true, null);
        }
    }

    public void p(String str, String str2, boolean z, Map<String, String> map) {
        p8 p8Var = this.b.get(str);
        if (p8Var == null || !p8Var.h(str2)) {
            return;
        }
        this.b.remove(str);
        if (z) {
            q(p8Var.b, p8Var.c);
        }
        g(p8Var.e, p8Var.b, p8Var.c, p8Var.e(), p8Var.d(), map);
        y8.a().d(p8Var);
    }

    public void r() {
        ArrayList arrayList = new ArrayList(this.b.keySet());
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            String str = (String) arrayList.get(i);
            p8 p8Var = this.b.get(str);
            if (p8Var != null && p8Var.i()) {
                this.b.remove(str);
            }
        }
    }
}
