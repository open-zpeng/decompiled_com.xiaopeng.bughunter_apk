package defpackage;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UploadTask.java */
/* renamed from: d9  reason: default package */
/* loaded from: classes.dex */
public class d9 implements Runnable {
    private static boolean b = false;
    private static Map<Integer, d9> c;
    private int d;
    private int e;
    private long f = System.currentTimeMillis();

    private d9(int i, int i2) {
        this.d = 180000;
        this.e = i;
        this.d = i2;
    }

    private static int a(int i) {
        if (i != 65133) {
            switch (i) {
                case 65501:
                    return 6;
                case 65502:
                    return 9;
                case 65503:
                    return 10;
                default:
                    return 0;
            }
        }
        return 11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(int i, int i2) {
        ya.c("CommitTask", "[setStatisticsInterval] eventId" + i + " statisticsInterval:" + i2);
        synchronized (c) {
            d9 d9Var = c.get(Integer.valueOf(i));
            if (d9Var == null) {
                if (i2 > 0) {
                    d9 d9Var2 = new d9(i, i2 * 1000);
                    c.put(Integer.valueOf(i), d9Var2);
                    ya.c("CommitTask", "post next eventId" + i + ": uploadTask.interval " + d9Var2.d);
                    ib.a().e(a(i), d9Var2, (long) d9Var2.d);
                }
            } else if (i2 > 0) {
                int i3 = i2 * 1000;
                if (d9Var.d != i3) {
                    ib.a().i(a(i));
                    d9Var.d = i3;
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = d9Var.d - (currentTimeMillis - d9Var.f);
                    if (j < 0) {
                        j = 0;
                    }
                    ya.c("CommitTask", d9Var + "post next eventId" + i + " next:" + j + "  uploadTask.interval: " + d9Var.d);
                    ib.a().e(a(i), d9Var, j);
                    d9Var.f = currentTimeMillis;
                }
            } else {
                ya.c("CommitTask", "uploadTasks.size:" + c.size());
                c.remove(Integer.valueOf(i));
                ya.c("CommitTask", "uploadTasks.size:" + c.size());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c() {
        for (s8 s8Var : s8.values()) {
            r8.b().f(s8Var.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d() {
        for (s8 s8Var : s8.values()) {
            ib.a().i(a(s8Var.a()));
        }
        b = false;
        c = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e() {
        s8[] values;
        if (b) {
            return;
        }
        ya.c("CommitTask", "init StatisticsAlarmEvent");
        c = new ConcurrentHashMap();
        for (s8 s8Var : s8.values()) {
            if (s8Var.isOpen()) {
                int a = s8Var.a();
                d9 d9Var = new d9(a, s8Var.c() * 1000);
                c.put(Integer.valueOf(a), d9Var);
                ib.a().e(a(a), d9Var, d9Var.d);
            }
        }
        b = true;
    }

    @Override // java.lang.Runnable
    public void run() {
        ya.c("CommitTask", "check&commit event:", Integer.valueOf(this.e));
        r8.b().f(this.e);
        if (c.containsValue(this)) {
            this.f = System.currentTimeMillis();
            ya.c("CommitTask", "next:" + this.e);
            ib.a().e(a(this.e), this, (long) this.d);
        }
    }
}
