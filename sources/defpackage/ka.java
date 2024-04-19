package defpackage;

import android.text.TextUtils;
import java.util.List;
/* compiled from: CoreStatics.java */
/* renamed from: ka  reason: default package */
/* loaded from: classes.dex */
public class ka {
    private static volatile long a;
    private static long b;
    private static long c;
    private static int d;
    private static long e;
    private static long f;
    private static int g;
    private static long h;
    private static long i;
    private static long j;
    private static long k;
    private static long l;
    private static long m;
    private static long n;
    private static long o;
    private static long p;
    private static long q;
    private static long r;
    private static long s;
    private static StringBuilder t = new StringBuilder();

    public static synchronized void a() {
        synchronized (ka.class) {
            n++;
        }
    }

    public static synchronized void b() {
        synchronized (ka.class) {
            o++;
        }
    }

    public static synchronized void c() {
        synchronized (ka.class) {
            g++;
            if (a == 0 && c == 0) {
                return;
            }
            if (ea.c || g >= 6) {
                e(true);
            }
        }
    }

    public static synchronized void d(List<qb> list, int i2) {
        synchronized (ka.class) {
            if (list == null) {
                return;
            }
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                qb qbVar = list.get(i4);
                if (qbVar != null) {
                    if (!"6005".equalsIgnoreCase(qbVar.b)) {
                        i3++;
                    }
                    t.append(qbVar.f);
                    if (i4 != list.size() - 1) {
                        t.append(",");
                    }
                }
            }
            ya.c("CoreStatics", "[uploadInc]:", Long.valueOf(c), "count:", Integer.valueOf(i2));
            long j2 = c + i2;
            c = j2;
            ya.c("CoreStatics", "[uploadInc]:", Long.valueOf(j2));
            if (i3 != i2) {
                ya.a("CoreStatics", "Mutil Process Upload Error");
            }
        }
    }

    @Deprecated
    public static synchronized void e(boolean z) {
        synchronized (ka.class) {
        }
    }

    public static synchronized void f(int i2) {
        synchronized (ka.class) {
            d += i2;
        }
    }

    private static boolean g(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return "6005".equalsIgnoreCase(str.trim());
    }

    public static synchronized void h(String str) {
        synchronized (ka.class) {
            if (g(str)) {
                return;
            }
            if ("65501".equalsIgnoreCase(str)) {
                s++;
            } else if ("65133".equalsIgnoreCase(str)) {
                q++;
            } else if ("65502".equalsIgnoreCase(str)) {
                r++;
            } else if ("65503".equalsIgnoreCase(str)) {
                p++;
            }
            a++;
        }
    }

    public static synchronized void i(String str) {
        synchronized (ka.class) {
            if (g(str)) {
                return;
            }
            b++;
        }
    }

    public static synchronized void j() {
        synchronized (ka.class) {
            e++;
        }
    }

    public static synchronized void k() {
        synchronized (ka.class) {
            f++;
        }
    }

    public static synchronized void l() {
        synchronized (ka.class) {
            h++;
        }
    }

    public static synchronized void m() {
        synchronized (ka.class) {
            i++;
        }
    }

    public static synchronized void n() {
        synchronized (ka.class) {
            j++;
        }
    }

    public static synchronized void o() {
        synchronized (ka.class) {
            k++;
        }
    }

    public static synchronized void p() {
        synchronized (ka.class) {
            l++;
        }
    }

    public static synchronized void q() {
        synchronized (ka.class) {
            m++;
        }
    }
}
