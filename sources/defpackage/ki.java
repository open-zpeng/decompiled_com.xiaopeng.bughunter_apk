package defpackage;
/* compiled from: ObservableDoOnLifecycle.java */
/* renamed from: ki  reason: default package */
/* loaded from: classes.dex */
public final class ki<T> extends gi<T, T> {
    private final mh<? super zg> c;
    private final ih d;

    public ki(og<T> ogVar, mh<? super zg> mhVar, ih ihVar) {
        super(ogVar);
        this.c = mhVar;
        this.d = ihVar;
    }

    @Override // defpackage.og
    protected void w(sg<? super T> sgVar) {
        this.b.a(new ei(sgVar, this.c, this.d));
    }
}
