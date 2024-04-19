package defpackage;

import java.util.concurrent.Callable;
/* compiled from: ObservableEmpty.java */
/* renamed from: li  reason: default package */
/* loaded from: classes.dex */
public final class li extends og<Object> implements Callable {
    public static final og<Object> b = new li();

    private li() {
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        return null;
    }

    @Override // defpackage.og
    protected void w(sg<? super Object> sgVar) {
        th.complete(sgVar);
    }
}
