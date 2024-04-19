package defpackage;

import java.lang.reflect.Method;
/* compiled from: SubscriberMethod.java */
/* renamed from: nn  reason: default package */
/* loaded from: classes.dex */
public class nn {
    final Method a;
    final qn b;
    final Class<?> c;
    final int d;
    final boolean e;
    String f;

    public nn(Method method, Class<?> cls, qn qnVar, int i, boolean z) {
        this.a = method;
        this.b = qnVar;
        this.c = cls;
        this.d = i;
        this.e = z;
    }

    private synchronized void a() {
        if (this.f == null) {
            StringBuilder sb = new StringBuilder(64);
            sb.append(this.a.getDeclaringClass().getName());
            sb.append('#');
            sb.append(this.a.getName());
            sb.append('(');
            sb.append(this.c.getName());
            this.f = sb.toString();
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof nn) {
            a();
            nn nnVar = (nn) obj;
            nnVar.a();
            return this.f.equals(nnVar.f);
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
