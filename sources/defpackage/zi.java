package defpackage;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* compiled from: SpscLinkedArrayQueue.java */
/* renamed from: zi  reason: default package */
/* loaded from: classes.dex */
public final class zi<T> implements ai {
    static final int b = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object c = new Object();
    int e;
    long f;
    final int g;
    AtomicReferenceArray<Object> h;
    final int i;
    AtomicReferenceArray<Object> j;
    final AtomicLong d = new AtomicLong();
    final AtomicLong k = new AtomicLong();

    public zi(int i) {
        int a = rj.a(Math.max(8, i));
        int i2 = a - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(a + 1);
        this.h = atomicReferenceArray;
        this.g = i2;
        a(a);
        this.j = atomicReferenceArray;
        this.i = i2;
        this.f = i2 - 1;
        o(0L);
    }

    private void a(int i) {
        this.e = Math.min(i / 4, b);
    }

    private static int b(int i) {
        return i;
    }

    private static int c(long j, int i) {
        return b(((int) j) & i);
    }

    private long d() {
        return this.k.get();
    }

    private long e() {
        return this.d.get();
    }

    private long f() {
        return this.k.get();
    }

    private static <E> Object g(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        return atomicReferenceArray.get(i);
    }

    private AtomicReferenceArray<Object> h(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        int b2 = b(i);
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) g(atomicReferenceArray, b2);
        m(atomicReferenceArray, b2, null);
        return atomicReferenceArray2;
    }

    private long i() {
        return this.d.get();
    }

    private T j(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.j = atomicReferenceArray;
        int c2 = c(j, i);
        T t = (T) g(atomicReferenceArray, c2);
        if (t != null) {
            m(atomicReferenceArray, c2, null);
            l(j + 1);
        }
        return t;
    }

    private void k(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i, T t, long j2) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.h = atomicReferenceArray2;
        this.f = (j2 + j) - 1;
        m(atomicReferenceArray2, i, t);
        n(atomicReferenceArray, atomicReferenceArray2);
        m(atomicReferenceArray, i, c);
        o(j + 1);
    }

    private void l(long j) {
        this.k.lazySet(j);
    }

    private static void m(AtomicReferenceArray<Object> atomicReferenceArray, int i, Object obj) {
        atomicReferenceArray.lazySet(i, obj);
    }

    private void n(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        m(atomicReferenceArray, b(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private void o(long j) {
        this.d.lazySet(j);
    }

    private boolean p(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j, int i) {
        m(atomicReferenceArray, i, t);
        o(j + 1);
        return true;
    }

    @Override // defpackage.ai
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // defpackage.ai
    public boolean isEmpty() {
        return i() == f();
    }

    @Override // defpackage.ai
    public boolean offer(T t) {
        Objects.requireNonNull(t, "Null is not a valid element");
        AtomicReferenceArray<Object> atomicReferenceArray = this.h;
        long e = e();
        int i = this.g;
        int c2 = c(e, i);
        if (e < this.f) {
            return p(atomicReferenceArray, t, e, c2);
        }
        long j = this.e + e;
        if (g(atomicReferenceArray, c(j, i)) == null) {
            this.f = j - 1;
            return p(atomicReferenceArray, t, e, c2);
        } else if (g(atomicReferenceArray, c(1 + e, i)) == null) {
            return p(atomicReferenceArray, t, e, c2);
        } else {
            k(atomicReferenceArray, e, c2, t, i);
            return true;
        }
    }

    @Override // defpackage.ai
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.j;
        long d = d();
        int i = this.i;
        int c2 = c(d, i);
        T t = (T) g(atomicReferenceArray, c2);
        boolean z = t == c;
        if (t == null || z) {
            if (z) {
                return j(h(atomicReferenceArray, i + 1), d, i);
            }
            return null;
        }
        m(atomicReferenceArray, c2, null);
        l(d + 1);
        return t;
    }
}
