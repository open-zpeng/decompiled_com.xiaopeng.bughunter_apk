package defpackage;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SubscriberMethodFinder.java */
/* renamed from: on  reason: default package */
/* loaded from: classes.dex */
public class on {
    private static final Map<Class<?>, List<nn>> a = new ConcurrentHashMap();
    private static final a[] b = new a[4];
    private List<sn> c;
    private final boolean d;
    private final boolean e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SubscriberMethodFinder.java */
    /* renamed from: on$a */
    /* loaded from: classes.dex */
    public static class a {
        final List<nn> a = new ArrayList();
        final Map<Class, Object> b = new HashMap();
        final Map<String, Class> c = new HashMap();
        final StringBuilder d = new StringBuilder(128);
        Class<?> e;
        Class<?> f;
        boolean g;
        rn h;

        a() {
        }

        private boolean b(Method method, Class<?> cls) {
            this.d.setLength(0);
            this.d.append(method.getName());
            StringBuilder sb = this.d;
            sb.append('>');
            sb.append(cls.getName());
            String sb2 = this.d.toString();
            Class<?> declaringClass = method.getDeclaringClass();
            Class put = this.c.put(sb2, declaringClass);
            if (put == null || put.isAssignableFrom(declaringClass)) {
                return true;
            }
            this.c.put(sb2, put);
            return false;
        }

        boolean a(Method method, Class<?> cls) {
            Object put = this.b.put(cls, method);
            if (put == null) {
                return true;
            }
            if (put instanceof Method) {
                if (b((Method) put, cls)) {
                    this.b.put(cls, this);
                } else {
                    throw new IllegalStateException();
                }
            }
            return b(method, cls);
        }

        void c(Class<?> cls) {
            this.f = cls;
            this.e = cls;
            this.g = false;
            this.h = null;
        }

        void d() {
            if (this.g) {
                this.f = null;
                return;
            }
            Class<? super Object> superclass = this.f.getSuperclass();
            this.f = superclass;
            String name = superclass.getName();
            if (name.startsWith("java.") || name.startsWith("javax.") || name.startsWith("android.")) {
                this.f = null;
            }
        }

        void e() {
            this.a.clear();
            this.b.clear();
            this.c.clear();
            this.d.setLength(0);
            this.e = null;
            this.f = null;
            this.g = false;
            this.h = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public on(List<sn> list, boolean z, boolean z2) {
        this.c = list;
        this.d = z;
        this.e = z2;
    }

    private List<nn> b(Class<?> cls) {
        nn[] a2;
        a g = g();
        g.c(cls);
        while (g.f != null) {
            rn f = f(g);
            g.h = f;
            if (f != null) {
                for (nn nnVar : f.a()) {
                    if (g.a(nnVar.a, nnVar.c)) {
                        g.a.add(nnVar);
                    }
                }
            } else {
                d(g);
            }
            g.d();
        }
        return e(g);
    }

    private List<nn> c(Class<?> cls) {
        a g = g();
        g.c(cls);
        while (g.f != null) {
            d(g);
            g.d();
        }
        return e(g);
    }

    private void d(a aVar) {
        Method[] methods;
        try {
            methods = aVar.f.getDeclaredMethods();
        } catch (Throwable unused) {
            methods = aVar.f.getMethods();
            aVar.g = true;
        }
        for (Method method : methods) {
            int modifiers = method.getModifiers();
            if ((modifiers & 1) != 0 && (modifiers & 5192) == 0) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1) {
                    ln lnVar = (ln) method.getAnnotation(ln.class);
                    if (lnVar != null) {
                        Class<?> cls = parameterTypes[0];
                        if (aVar.a(method, cls)) {
                            aVar.a.add(new nn(method, cls, lnVar.threadMode(), lnVar.priority(), lnVar.sticky()));
                        }
                    }
                } else if (this.d && method.isAnnotationPresent(ln.class)) {
                    throw new dn("@Subscribe method " + (method.getDeclaringClass().getName() + "." + method.getName()) + "must have exactly 1 parameter but has " + parameterTypes.length);
                }
            } else if (this.d && method.isAnnotationPresent(ln.class)) {
                throw new dn((method.getDeclaringClass().getName() + "." + method.getName()) + " is a illegal @Subscribe method: must be public, non-static, and non-abstract");
            }
        }
    }

    private List<nn> e(a aVar) {
        ArrayList arrayList = new ArrayList(aVar.a);
        aVar.e();
        synchronized (b) {
            int i = 0;
            while (true) {
                if (i >= 4) {
                    break;
                }
                a[] aVarArr = b;
                if (aVarArr[i] == null) {
                    aVarArr[i] = aVar;
                    break;
                }
                i++;
            }
        }
        return arrayList;
    }

    private rn f(a aVar) {
        rn rnVar = aVar.h;
        if (rnVar != null && rnVar.c() != null) {
            rn c = aVar.h.c();
            if (aVar.f == c.b()) {
                return c;
            }
        }
        List<sn> list = this.c;
        if (list != null) {
            for (sn snVar : list) {
                rn a2 = snVar.a(aVar.f);
                if (a2 != null) {
                    return a2;
                }
            }
            return null;
        }
        return null;
    }

    private a g() {
        synchronized (b) {
            for (int i = 0; i < 4; i++) {
                a[] aVarArr = b;
                a aVar = aVarArr[i];
                if (aVar != null) {
                    aVarArr[i] = null;
                    return aVar;
                }
            }
            return new a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<nn> a(Class<?> cls) {
        List<nn> b2;
        Map<Class<?>, List<nn>> map = a;
        List<nn> list = map.get(cls);
        if (list != null) {
            return list;
        }
        if (this.e) {
            b2 = c(cls);
        } else {
            b2 = b(cls);
        }
        if (!b2.isEmpty()) {
            map.put(cls, b2);
            return b2;
        }
        throw new dn("Subscriber " + cls + " and its super classes have no public methods with the @Subscribe annotation");
    }
}
