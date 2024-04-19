package defpackage;

import android.os.SystemClock;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* compiled from: Progress.java */
/* renamed from: zc  reason: default package */
/* loaded from: classes.dex */
public class zc implements Serializable {
    private static final long serialVersionUID = 6353658567594109891L;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public float g;
    public long i;
    public transient long j;
    public int k;
    private transient long n;
    private transient long o = SystemClock.elapsedRealtime();
    public long h = -1;
    public int l = 0;
    public long m = System.currentTimeMillis();
    private transient List<Long> p = new ArrayList();

    /* compiled from: Progress.java */
    /* renamed from: zc$a */
    /* loaded from: classes.dex */
    public interface a {
        void a(zc zcVar);
    }

    private long a(long j) {
        this.p.add(Long.valueOf(j));
        if (this.p.size() > 10) {
            this.p.remove(0);
        }
        long j2 = 0;
        for (Long l : this.p) {
            j2 = ((float) j2) + ((float) l.longValue());
        }
        return j2 / this.p.size();
    }

    public static zc b(zc zcVar, long j, long j2, a aVar) {
        zcVar.h = j2;
        zcVar.i += j;
        zcVar.n += j;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j3 = zcVar.o;
        if ((elapsedRealtime - j3 >= wb.a) || zcVar.i == j2) {
            long j4 = elapsedRealtime - j3;
            if (j4 == 0) {
                j4 = 1;
            }
            zcVar.g = (((float) zcVar.i) * 1.0f) / ((float) j2);
            zcVar.j = zcVar.a((zcVar.n * 1000) / j4);
            zcVar.o = elapsedRealtime;
            zcVar.n = 0L;
            if (aVar != null) {
                aVar.a(zcVar);
            }
        }
        return zcVar;
    }

    public static zc c(zc zcVar, long j, a aVar) {
        return b(zcVar, j, zcVar.h, aVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zc.class != obj.getClass()) {
            return false;
        }
        String str = this.b;
        String str2 = ((zc) obj).b;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public int hashCode() {
        String str = this.b;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "Progress{fraction=" + this.g + ", totalSize=" + this.h + ", currentSize=" + this.i + ", speed=" + this.j + ", status=" + this.k + ", priority=" + this.l + ", folder=" + this.d + ", filePath=" + this.e + ", fileName=" + this.f + ", tag=" + this.b + ", url=" + this.c + '}';
    }
}
