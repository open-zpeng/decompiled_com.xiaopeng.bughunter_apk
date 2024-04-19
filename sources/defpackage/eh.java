package defpackage;
/* compiled from: Exceptions.java */
/* renamed from: eh  reason: default package */
/* loaded from: classes.dex */
public final class eh {
    public static RuntimeException a(Throwable th) {
        throw oj.c(th);
    }

    public static void b(Throwable th) {
        if (!(th instanceof VirtualMachineError)) {
            if (!(th instanceof ThreadDeath)) {
                if (th instanceof LinkageError) {
                    throw ((LinkageError) th);
                }
                return;
            }
            throw ((ThreadDeath) th);
        }
        throw ((VirtualMachineError) th);
    }
}
