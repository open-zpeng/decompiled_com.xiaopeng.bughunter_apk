package defpackage;
/* compiled from: Observer.java */
/* renamed from: sg  reason: default package */
/* loaded from: classes.dex */
public interface sg<T> {
    void onComplete();

    void onError(Throwable th);

    void onNext(T t);

    void onSubscribe(zg zgVar);
}
