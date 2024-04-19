package defpackage;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* compiled from: LogStoreMgr.java */
/* renamed from: oa  reason: default package */
/* loaded from: classes.dex */
public class oa {
    private static oa a;
    private static int b;
    private static final Object c = new Object();
    private List<qb> e = new CopyOnWriteArrayList();
    private Runnable f = new a();
    private ma d = new na(ea.j());

    /* compiled from: LogStoreMgr.java */
    /* renamed from: oa$a */
    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            oa.this.a();
        }
    }

    /* compiled from: LogStoreMgr.java */
    /* renamed from: oa$b */
    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            oa.this.b();
            int c = oa.this.d.c();
            if (c > 9000) {
                oa.this.k(c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LogStoreMgr.java */
    /* renamed from: oa$c */
    /* loaded from: classes.dex */
    public class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ya.c("LogStoreMgr", "CleanLogTask");
            int c = oa.this.d.c();
            if (c > 9000) {
                oa.this.k(c);
            }
        }
    }

    private oa() {
        ub.d().f();
        ib.a().g(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, -3);
        this.d.b("time", String.valueOf(calendar.getTimeInMillis()));
    }

    public static synchronized oa e() {
        oa oaVar;
        synchronized (oa.class) {
            if (a == null) {
                a = new oa();
            }
            oaVar = a;
        }
        return oaVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(int i) {
        if (i > 9000) {
            this.d.d((i - 9000) + 1000);
        }
    }

    public synchronized void a() {
        ya.c("LogStoreMgr", "[store]");
        ArrayList arrayList = null;
        try {
            synchronized (this.e) {
                if (this.e.size() > 0) {
                    arrayList = new ArrayList(this.e);
                    this.e.clear();
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                this.d.mo70a((List<qb>) arrayList);
            }
        } catch (Throwable unused) {
        }
    }

    public int c(List<qb> list) {
        ya.c("LogStoreMgr", list);
        return this.d.a(list);
    }

    public List<qb> f(String str, int i) {
        List<qb> a2 = this.d.a(str, i);
        ya.c("LogStoreMgr", "[get]", a2);
        return a2;
    }

    public void i(qb qbVar) {
        ya.c("LogStoreMgr", "[add] :", qbVar.f);
        ka.i(qbVar.b);
        this.e.add(qbVar);
        if (this.e.size() >= 100) {
            ib.a().i(1);
            ib.a().e(1, this.f, 0L);
        } else if (!ib.a().h(1)) {
            ib.a().e(1, this.f, 5000L);
        }
        synchronized (c) {
            int i = b + 1;
            b = i;
            if (i > 5000) {
                b = 0;
                ib.a().g(new c());
            }
        }
    }

    public void j() {
        ya.c("LogStoreMgr", "[clear]");
        this.d.clear();
        this.e.clear();
    }
}
