package defpackage;

import defpackage.z8;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
/* compiled from: ReuseItemPool.java */
/* renamed from: a9  reason: default package */
/* loaded from: classes.dex */
public class a9<T extends z8> {
    private static AtomicLong a = new AtomicLong(0);
    private static AtomicLong b = new AtomicLong(0);
    private final int f = 20;
    private Integer e = null;
    private AtomicLong c = new AtomicLong(0);
    private AtomicLong d = new AtomicLong(0);
    private ConcurrentLinkedQueue<T> g = new ConcurrentLinkedQueue<>();
    private Set<Integer> h = new HashSet();

    public T a() {
        a.getAndIncrement();
        this.c.getAndIncrement();
        T poll = this.g.poll();
        if (poll != null) {
            this.h.remove(Integer.valueOf(System.identityHashCode(poll)));
            this.d.getAndIncrement();
            b.getAndIncrement();
        }
        return poll;
    }

    public void b(T t) {
        t.a();
        if (this.g.size() < 20) {
            synchronized (this.h) {
                int identityHashCode = System.identityHashCode(t);
                if (!this.h.contains(Integer.valueOf(identityHashCode))) {
                    this.h.add(Integer.valueOf(identityHashCode));
                    this.g.offer(t);
                }
            }
        }
    }
}
