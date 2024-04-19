package defpackage;

import java.io.Serializable;
/* compiled from: NotificationLite.java */
/* renamed from: pj  reason: default package */
/* loaded from: classes.dex */
public enum pj {
    COMPLETE;

    /* compiled from: NotificationLite.java */
    /* renamed from: pj$a */
    /* loaded from: classes.dex */
    static final class a implements Serializable {
        private static final long serialVersionUID = -7482590109178395495L;
        final zg b;

        a(zg zgVar) {
            this.b = zgVar;
        }

        public String toString() {
            return "NotificationLite.Disposable[" + this.b + "]";
        }
    }

    /* compiled from: NotificationLite.java */
    /* renamed from: pj$b */
    /* loaded from: classes.dex */
    static final class b implements Serializable {
        private static final long serialVersionUID = -8759979445933046293L;
        final Throwable b;

        b(Throwable th) {
            this.b = th;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return xh.c(this.b, ((b) obj).b);
            }
            return false;
        }

        public int hashCode() {
            return this.b.hashCode();
        }

        public String toString() {
            return "NotificationLite.Error[" + this.b + "]";
        }
    }

    /* compiled from: NotificationLite.java */
    /* renamed from: pj$c */
    /* loaded from: classes.dex */
    static final class c implements Serializable {
        private static final long serialVersionUID = -1322257508628817540L;
        final un b;

        c(un unVar) {
            this.b = unVar;
        }

        public String toString() {
            return "NotificationLite.Subscription[" + this.b + "]";
        }
    }

    public static <T> boolean accept(Object obj, tn<? super T> tnVar) {
        if (obj == COMPLETE) {
            tnVar.onComplete();
            return true;
        } else if (obj instanceof b) {
            tnVar.onError(((b) obj).b);
            return true;
        } else {
            tnVar.onNext(obj);
            return false;
        }
    }

    public static <T> boolean acceptFull(Object obj, tn<? super T> tnVar) {
        if (obj == COMPLETE) {
            tnVar.onComplete();
            return true;
        } else if (obj instanceof b) {
            tnVar.onError(((b) obj).b);
            return true;
        } else if (obj instanceof c) {
            tnVar.a(((c) obj).b);
            return false;
        } else {
            tnVar.onNext(obj);
            return false;
        }
    }

    public static Object complete() {
        return COMPLETE;
    }

    public static Object disposable(zg zgVar) {
        return new a(zgVar);
    }

    public static Object error(Throwable th) {
        return new b(th);
    }

    public static zg getDisposable(Object obj) {
        return ((a) obj).b;
    }

    public static Throwable getError(Object obj) {
        return ((b) obj).b;
    }

    public static un getSubscription(Object obj) {
        return ((c) obj).b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T getValue(Object obj) {
        return obj;
    }

    public static boolean isComplete(Object obj) {
        return obj == COMPLETE;
    }

    public static boolean isDisposable(Object obj) {
        return obj instanceof a;
    }

    public static boolean isError(Object obj) {
        return obj instanceof b;
    }

    public static boolean isSubscription(Object obj) {
        return obj instanceof c;
    }

    public static <T> Object next(T t) {
        return t;
    }

    public static Object subscription(un unVar) {
        return new c(unVar);
    }

    @Override // java.lang.Enum
    public String toString() {
        return "NotificationLite.Complete";
    }

    public static <T> boolean accept(Object obj, sg<? super T> sgVar) {
        if (obj == COMPLETE) {
            sgVar.onComplete();
            return true;
        } else if (obj instanceof b) {
            sgVar.onError(((b) obj).b);
            return true;
        } else {
            sgVar.onNext(obj);
            return false;
        }
    }

    public static <T> boolean acceptFull(Object obj, sg<? super T> sgVar) {
        if (obj == COMPLETE) {
            sgVar.onComplete();
            return true;
        } else if (obj instanceof b) {
            sgVar.onError(((b) obj).b);
            return true;
        } else if (obj instanceof a) {
            sgVar.onSubscribe(((a) obj).b);
            return false;
        } else {
            sgVar.onNext(obj);
            return false;
        }
    }
}
