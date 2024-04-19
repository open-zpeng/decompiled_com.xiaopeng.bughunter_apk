package defpackage;
/* compiled from: CacheCall.java */
/* renamed from: xb  reason: default package */
/* loaded from: classes.dex */
public class xb<T> implements yb<T> {
    private cc<T> a;
    private hd<T, ? extends hd> b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CacheCall.java */
    /* renamed from: xb$a */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ac.values().length];
            a = iArr;
            try {
                iArr[ac.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ac.NO_CACHE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ac.IF_NONE_CACHE_REQUEST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ac.FIRST_CACHE_THEN_REQUEST.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[ac.REQUEST_FAILED_READ_CACHE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public xb(hd<T, ? extends hd> hdVar) {
        this.a = null;
        this.b = hdVar;
        this.a = c();
    }

    private cc<T> c() {
        int i = a.a[this.b.j().ordinal()];
        if (i == 1) {
            this.a = new dc(this.b);
        } else if (i == 2) {
            this.a = new fc(this.b);
        } else if (i == 3) {
            this.a = new gc(this.b);
        } else if (i == 4) {
            this.a = new ec(this.b);
        } else if (i == 5) {
            this.a = new hc(this.b);
        }
        if (this.b.k() != null) {
            this.a = this.b.k();
        }
        jd.b(this.a, "policy == null");
        return this.a;
    }

    @Override // defpackage.yb
    public void a(jc<T> jcVar) {
        jd.b(jcVar, "callback == null");
        this.a.b(this.a.a(), jcVar);
    }

    /* renamed from: b */
    public yb<T> clone() {
        return new xb(this.b);
    }
}
