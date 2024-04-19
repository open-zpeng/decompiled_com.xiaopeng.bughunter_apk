package defpackage;

import defpackage.tg;
import java.util.concurrent.ThreadFactory;
/* compiled from: NewThreadScheduler.java */
/* renamed from: dj  reason: default package */
/* loaded from: classes.dex */
public final class dj extends tg {
    private static final fj b = new fj("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));
    final ThreadFactory c;

    public dj() {
        this(b);
    }

    @Override // defpackage.tg
    public tg.b a() {
        return new ej(this.c);
    }

    public dj(ThreadFactory threadFactory) {
        this.c = threadFactory;
    }
}
