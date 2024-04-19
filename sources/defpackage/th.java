package defpackage;
/* compiled from: EmptyDisposable.java */
/* renamed from: th  reason: default package */
/* loaded from: classes.dex */
public enum th implements yh<Object> {
    INSTANCE,
    NEVER;

    public static void complete(sg<?> sgVar) {
        sgVar.onSubscribe(INSTANCE);
        sgVar.onComplete();
    }

    public static void error(Throwable th, sg<?> sgVar) {
        sgVar.onSubscribe(INSTANCE);
        sgVar.onError(th);
    }

    @Override // defpackage.ai
    public void clear() {
    }

    @Override // defpackage.zg
    public void dispose() {
    }

    public boolean isDisposed() {
        return this == INSTANCE;
    }

    @Override // defpackage.ai
    public boolean isEmpty() {
        return true;
    }

    @Override // defpackage.ai
    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // defpackage.ai
    public Object poll() throws Exception {
        return null;
    }

    @Override // defpackage.zh
    public int requestFusion(int i) {
        return i & 2;
    }

    public boolean offer(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public static void complete(ng<?> ngVar) {
        ngVar.onSubscribe(INSTANCE);
        ngVar.onComplete();
    }

    public static void error(Throwable th, kg kgVar) {
        kgVar.onSubscribe(INSTANCE);
        kgVar.onError(th);
    }

    public static void complete(kg kgVar) {
        kgVar.onSubscribe(INSTANCE);
        kgVar.onComplete();
    }

    public static void error(Throwable th, ug<?> ugVar) {
        ugVar.onSubscribe(INSTANCE);
        ugVar.onError(th);
    }

    public static void error(Throwable th, ng<?> ngVar) {
        ngVar.onSubscribe(INSTANCE);
        ngVar.onError(th);
    }
}
