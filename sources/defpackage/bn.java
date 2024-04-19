package defpackage;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;
/* compiled from: EventBus.java */
/* renamed from: bn  reason: default package */
/* loaded from: classes.dex */
public class bn {
    static volatile bn a;
    private static final cn b = new cn();
    private static final Map<Class<?>, List<Class<?>>> c = new HashMap();
    private final Map<Class<?>, CopyOnWriteArrayList<pn>> d;
    private final Map<Object, List<Class<?>>> e;
    private final Map<Class<?>, Object> f;
    private final ThreadLocal<c> g;
    private final gn h;
    private final kn i;
    private final an j;
    private final zm k;
    private final on l;
    private final ExecutorService m;
    private final boolean n;
    private final boolean o;
    private final boolean p;
    private final boolean q;
    private final boolean r;
    private final boolean s;
    private final int t;
    private final fn u;

    /* compiled from: EventBus.java */
    /* renamed from: bn$a */
    /* loaded from: classes.dex */
    class a extends ThreadLocal<c> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public c initialValue() {
            return new c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EventBus.java */
    /* renamed from: bn$b */
    /* loaded from: classes.dex */
    public static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[qn.values().length];
            a = iArr;
            try {
                iArr[qn.POSTING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[qn.MAIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[qn.MAIN_ORDERED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[qn.BACKGROUND.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[qn.ASYNC.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EventBus.java */
    /* renamed from: bn$c */
    /* loaded from: classes.dex */
    public static final class c {
        final List<Object> a = new ArrayList();
        boolean b;
        boolean c;
        pn d;
        Object e;
        boolean f;

        c() {
        }
    }

    public bn() {
        this(b);
    }

    static void a(List<Class<?>> list, Class<?>[] clsArr) {
        for (Class<?> cls : clsArr) {
            if (!list.contains(cls)) {
                list.add(cls);
                a(list, cls.getInterfaces());
            }
        }
    }

    private void b(pn pnVar, Object obj) {
        if (obj != null) {
            p(pnVar, obj, j());
        }
    }

    public static bn c() {
        if (a == null) {
            synchronized (bn.class) {
                if (a == null) {
                    a = new bn();
                }
            }
        }
        return a;
    }

    private void f(pn pnVar, Object obj, Throwable th) {
        if (obj instanceof mn) {
            if (this.o) {
                fn fnVar = this.u;
                Level level = Level.SEVERE;
                fnVar.b(level, "SubscriberExceptionEvent subscriber " + pnVar.a.getClass() + " threw an exception", th);
                mn mnVar = (mn) obj;
                fn fnVar2 = this.u;
                fnVar2.b(level, "Initial event " + mnVar.c + " caused exception in " + mnVar.d, mnVar.b);
            }
        } else if (!this.n) {
            if (this.o) {
                fn fnVar3 = this.u;
                Level level2 = Level.SEVERE;
                fnVar3.b(level2, "Could not dispatch event: " + obj.getClass() + " to subscribing class " + pnVar.a.getClass(), th);
            }
            if (this.q) {
                l(new mn(this, th, obj, pnVar.a));
            }
        } else {
            throw new dn("Invoking subscriber failed", th);
        }
    }

    private boolean j() {
        gn gnVar = this.h;
        if (gnVar != null) {
            return gnVar.b();
        }
        return true;
    }

    private static List<Class<?>> k(Class<?> cls) {
        List<Class<?>> list;
        Map<Class<?>, List<Class<?>>> map = c;
        synchronized (map) {
            list = map.get(cls);
            if (list == null) {
                list = new ArrayList<>();
                for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
                    list.add(cls2);
                    a(list, cls2.getInterfaces());
                }
                c.put(cls, list);
            }
        }
        return list;
    }

    private void m(Object obj, c cVar) throws Error {
        boolean n;
        Class<?> cls = obj.getClass();
        if (this.s) {
            List<Class<?>> k = k(cls);
            int size = k.size();
            n = false;
            for (int i = 0; i < size; i++) {
                n |= n(obj, cVar, k.get(i));
            }
        } else {
            n = n(obj, cVar, cls);
        }
        if (n) {
            return;
        }
        if (this.p) {
            this.u.a(Level.FINE, "No subscribers registered for event " + cls);
        }
        if (!this.r || cls == hn.class || cls == mn.class) {
            return;
        }
        l(new hn(this, obj));
    }

    private boolean n(Object obj, c cVar, Class<?> cls) {
        CopyOnWriteArrayList<pn> copyOnWriteArrayList;
        synchronized (this) {
            copyOnWriteArrayList = this.d.get(cls);
        }
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        Iterator<pn> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            pn next = it.next();
            cVar.e = obj;
            cVar.d = next;
            try {
                p(next, obj, cVar.c);
                if (cVar.f) {
                    return true;
                }
            } finally {
                cVar.e = null;
                cVar.d = null;
                cVar.f = false;
            }
        }
        return true;
    }

    private void p(pn pnVar, Object obj, boolean z) {
        int i = b.a[pnVar.b.b.ordinal()];
        if (i == 1) {
            i(pnVar, obj);
        } else if (i == 2) {
            if (z) {
                i(pnVar, obj);
            } else {
                this.i.a(pnVar, obj);
            }
        } else if (i == 3) {
            kn knVar = this.i;
            if (knVar != null) {
                knVar.a(pnVar, obj);
            } else {
                i(pnVar, obj);
            }
        } else if (i == 4) {
            if (z) {
                this.j.a(pnVar, obj);
            } else {
                i(pnVar, obj);
            }
        } else if (i == 5) {
            this.k.a(pnVar, obj);
        } else {
            throw new IllegalStateException("Unknown thread mode: " + pnVar.b.b);
        }
    }

    private void r(Object obj, nn nnVar) {
        Class<?> cls = nnVar.c;
        pn pnVar = new pn(obj, nnVar);
        CopyOnWriteArrayList<pn> copyOnWriteArrayList = this.d.get(cls);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            this.d.put(cls, copyOnWriteArrayList);
        } else if (copyOnWriteArrayList.contains(pnVar)) {
            throw new dn("Subscriber " + obj.getClass() + " already registered to event " + cls);
        }
        int size = copyOnWriteArrayList.size();
        for (int i = 0; i <= size; i++) {
            if (i == size || nnVar.d > copyOnWriteArrayList.get(i).b.d) {
                copyOnWriteArrayList.add(i, pnVar);
                break;
            }
        }
        List<Class<?>> list = this.e.get(obj);
        if (list == null) {
            list = new ArrayList<>();
            this.e.put(obj, list);
        }
        list.add(cls);
        if (nnVar.e) {
            if (this.s) {
                for (Map.Entry<Class<?>, Object> entry : this.f.entrySet()) {
                    if (cls.isAssignableFrom(entry.getKey())) {
                        b(pnVar, entry.getValue());
                    }
                }
                return;
            }
            b(pnVar, this.f.get(cls));
        }
    }

    private void t(Object obj, Class<?> cls) {
        CopyOnWriteArrayList<pn> copyOnWriteArrayList = this.d.get(cls);
        if (copyOnWriteArrayList != null) {
            int size = copyOnWriteArrayList.size();
            int i = 0;
            while (i < size) {
                pn pnVar = copyOnWriteArrayList.get(i);
                if (pnVar.a == obj) {
                    pnVar.c = false;
                    copyOnWriteArrayList.remove(i);
                    i--;
                    size--;
                }
                i++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ExecutorService d() {
        return this.m;
    }

    public fn e() {
        return this.u;
    }

    public boolean g(Class<?> cls) {
        CopyOnWriteArrayList<pn> copyOnWriteArrayList;
        List<Class<?>> k = k(cls);
        if (k != null) {
            int size = k.size();
            for (int i = 0; i < size; i++) {
                Class<?> cls2 = k.get(i);
                synchronized (this) {
                    copyOnWriteArrayList = this.d.get(cls2);
                }
                if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(in inVar) {
        Object obj = inVar.b;
        pn pnVar = inVar.c;
        in.b(inVar);
        if (pnVar.c) {
            i(pnVar, obj);
        }
    }

    void i(pn pnVar, Object obj) {
        try {
            pnVar.b.a.invoke(pnVar.a, obj);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Unexpected exception", e);
        } catch (InvocationTargetException e2) {
            f(pnVar, obj, e2.getCause());
        }
    }

    public void l(Object obj) {
        c cVar = this.g.get();
        List<Object> list = cVar.a;
        list.add(obj);
        if (cVar.b) {
            return;
        }
        cVar.c = j();
        cVar.b = true;
        if (cVar.f) {
            throw new dn("Internal error. Abort state was not reset");
        }
        while (true) {
            try {
                if (list.isEmpty()) {
                    return;
                }
                m(list.remove(0), cVar);
            } finally {
                cVar.b = false;
                cVar.c = false;
            }
        }
    }

    public void o(Object obj) {
        synchronized (this.f) {
            this.f.put(obj.getClass(), obj);
        }
        l(obj);
    }

    public void q(Object obj) {
        List<nn> a2 = this.l.a(obj.getClass());
        synchronized (this) {
            for (nn nnVar : a2) {
                r(obj, nnVar);
            }
        }
    }

    public synchronized void s(Object obj) {
        List<Class<?>> list = this.e.get(obj);
        if (list != null) {
            for (Class<?> cls : list) {
                t(obj, cls);
            }
            this.e.remove(obj);
        } else {
            fn fnVar = this.u;
            Level level = Level.WARNING;
            fnVar.a(level, "Subscriber to unregister was not registered before: " + obj.getClass());
        }
    }

    public String toString() {
        return "EventBus[indexCount=" + this.t + ", eventInheritance=" + this.s + "]";
    }

    bn(cn cnVar) {
        this.g = new a();
        this.u = cnVar.b();
        this.d = new HashMap();
        this.e = new HashMap();
        this.f = new ConcurrentHashMap();
        gn c2 = cnVar.c();
        this.h = c2;
        this.i = c2 != null ? c2.a(this) : null;
        this.j = new an(this);
        this.k = new zm(this);
        List<sn> list = cnVar.k;
        this.t = list != null ? list.size() : 0;
        this.l = new on(cnVar.k, cnVar.i, cnVar.h);
        this.o = cnVar.b;
        this.p = cnVar.c;
        this.q = cnVar.d;
        this.r = cnVar.e;
        this.n = cnVar.f;
        this.s = cnVar.g;
        this.m = cnVar.j;
    }
}
