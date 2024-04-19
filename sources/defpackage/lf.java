package defpackage;

import android.content.Context;
import android.os.Build;
import android.view.Choreographer;
/* compiled from: Caton.java */
/* renamed from: lf  reason: default package */
/* loaded from: classes.dex */
public class lf {
    private static volatile lf a;
    static d b = d.LOOPER;

    /* compiled from: Caton.java */
    /* renamed from: lf$b */
    /* loaded from: classes.dex */
    public static class b {
        private Context c;
        private c f;
        private long a = 3000;
        private long b = 1000;
        private d d = lf.b;
        private boolean e = true;

        public b(Context context) {
            this.c = context;
        }

        lf a() {
            return new lf(this.c, this.a, this.b, this.d, this.e, this.f);
        }

        public b b(c cVar) {
            this.f = cVar;
            return this;
        }

        public b c(long j) {
            this.b = j;
            return this;
        }

        public b d(boolean z) {
            this.e = z;
            return this;
        }

        public b e(d dVar) {
            this.d = dVar;
            return this;
        }

        public b f(long j) {
            this.a = j;
            return this;
        }
    }

    /* compiled from: Caton.java */
    /* renamed from: lf$c */
    /* loaded from: classes.dex */
    public interface c {
        void a(String[] strArr, boolean z, long... jArr);
    }

    /* compiled from: Caton.java */
    /* renamed from: lf$d */
    /* loaded from: classes.dex */
    public enum d {
        LOOPER(0),
        FRAME(1);
        
        int b;

        d(int i) {
            this.b = i;
        }
    }

    public static void a(b bVar) {
        if (a == null) {
            synchronized (lf.class) {
                if (a == null) {
                    a = bVar.a();
                }
            }
        }
    }

    private lf(Context context, long j, long j2, d dVar, boolean z, c cVar) {
        long min = Math.min(Math.max(j, 200L), 400L);
        long min2 = Math.min(Math.max(j2, 200L), 400L);
        nf.b = z;
        nf.a = min;
        kf kfVar = new kf(context, new jf(min2), cVar);
        if (dVar == d.LOOPER) {
            new pf(kfVar);
        } else if (dVar == d.FRAME) {
            if (Build.VERSION.SDK_INT >= 16) {
                Choreographer.getInstance().postFrameCallback(new of(context, kfVar));
                return;
            }
            new pf(kfVar);
        }
    }
}
