package defpackage;
/* compiled from: Subscriber.java */
/* renamed from: tn  reason: default package */
/* loaded from: classes.dex */
public interface tn<T> {
    void a(un unVar);

    void onComplete();

    void onError(Throwable th);

    void onNext(T t);
}
