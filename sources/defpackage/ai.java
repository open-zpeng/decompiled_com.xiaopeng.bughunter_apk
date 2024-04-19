package defpackage;
/* compiled from: SimpleQueue.java */
/* renamed from: ai  reason: default package */
/* loaded from: classes.dex */
public interface ai<T> {
    void clear();

    boolean isEmpty();

    boolean offer(T t);

    T poll() throws Exception;
}
