package defpackage;

import java.util.concurrent.atomic.AtomicReference;
/* compiled from: AtomicThrowable.java */
/* renamed from: mj  reason: default package */
/* loaded from: classes.dex */
public final class mj extends AtomicReference<Throwable> {
    private static final long serialVersionUID = 3949248817947090603L;

    public boolean a(Throwable th) {
        return oj.a(this, th);
    }

    public Throwable b() {
        return oj.b(this);
    }
}
