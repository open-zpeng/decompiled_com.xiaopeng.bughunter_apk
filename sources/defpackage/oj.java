package defpackage;

import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ExceptionHelper.java */
/* renamed from: oj  reason: default package */
/* loaded from: classes.dex */
public final class oj {
    public static final Throwable a = new a();

    /* compiled from: ExceptionHelper.java */
    /* renamed from: oj$a */
    /* loaded from: classes.dex */
    static final class a extends Throwable {
        private static final long serialVersionUID = -4649703670690200604L;

        a() {
            super("No further exceptions");
        }

        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            return this;
        }
    }

    public static <T> boolean a(AtomicReference<Throwable> atomicReference, Throwable th) {
        Throwable th2;
        do {
            th2 = atomicReference.get();
            if (th2 == a) {
                return false;
            }
        } while (!atomicReference.compareAndSet(th2, th2 == null ? th : new dh(th2, th)));
        return true;
    }

    public static <T> Throwable b(AtomicReference<Throwable> atomicReference) {
        Throwable th = atomicReference.get();
        Throwable th2 = a;
        return th != th2 ? atomicReference.getAndSet(th2) : th;
    }

    public static RuntimeException c(Throwable th) {
        if (!(th instanceof Error)) {
            if (th instanceof RuntimeException) {
                return (RuntimeException) th;
            }
            return new RuntimeException(th);
        }
        throw ((Error) th);
    }
}
