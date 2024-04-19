package defpackage;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;
/* compiled from: Excluder.java */
/* renamed from: x6  reason: default package */
/* loaded from: classes.dex */
public final class x6 implements c8, Cloneable {
    public static final x6 b = new x6();
    private boolean f;
    private double c = -1.0d;
    private int d = 136;
    private boolean e = true;
    private List<g7> g = Collections.emptyList();
    private List<g7> h = Collections.emptyList();

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Excluder.java */
    /* renamed from: x6$a */
    /* loaded from: classes.dex */
    class a<T> extends b8<T> {
        private b8<T> a;
        final /* synthetic */ boolean b;
        final /* synthetic */ boolean c;
        final /* synthetic */ p7 d;
        final /* synthetic */ m7 e;

        a(boolean z, boolean z2, p7 p7Var, m7 m7Var) {
            this.b = z;
            this.c = z2;
            this.d = p7Var;
            this.e = m7Var;
        }

        private b8<T> d() {
            b8<T> b8Var = this.a;
            if (b8Var != null) {
                return b8Var;
            }
            b8<T> d = this.d.d(x6.this, this.e);
            this.a = d;
            return d;
        }

        @Override // defpackage.b8
        public void a(k7 k7Var, T t) throws IOException {
            if (this.c) {
                k7Var.u();
            } else {
                d().a(k7Var, t);
            }
        }

        @Override // defpackage.b8
        public T c(i7 i7Var) throws IOException {
            if (this.b) {
                i7Var.B();
                return null;
            }
            return d().c(i7Var);
        }
    }

    private boolean c(h6 h6Var) {
        return h6Var == null || h6Var.O000000o() <= this.c;
    }

    private boolean d(h6 h6Var, i6 i6Var) {
        return c(h6Var) && e(i6Var);
    }

    private boolean e(i6 i6Var) {
        return i6Var == null || i6Var.O000000o() > this.c;
    }

    private boolean f(Class<?> cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    private boolean i(Class<?> cls) {
        return cls.isMemberClass() && !j(cls);
    }

    private boolean j(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    @Override // defpackage.c8
    public <T> b8<T> a(p7 p7Var, m7<T> m7Var) {
        Class<? super T> a2 = m7Var.a();
        boolean g = g(a2, true);
        boolean g2 = g(a2, false);
        if (g || g2) {
            return new a(g2, g, p7Var, m7Var);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public x6 clone() {
        try {
            return (x6) super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new AssertionError();
        }
    }

    public boolean g(Class<?> cls, boolean z) {
        if (this.c == -1.0d || d((h6) cls.getAnnotation(h6.class), (i6) cls.getAnnotation(i6.class))) {
            if ((this.e || !i(cls)) && !f(cls)) {
                for (g7 g7Var : z ? this.g : this.h) {
                    if (g7Var.b(cls)) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
        return true;
    }

    public boolean h(Field field, boolean z) {
        f6 f6Var;
        if ((this.d & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.c == -1.0d || d((h6) field.getAnnotation(h6.class), (i6) field.getAnnotation(i6.class))) && !field.isSynthetic()) {
            if (!this.f || ((f6Var = (f6) field.getAnnotation(f6.class)) != null && (!z ? !f6Var.O00000Oo() : !f6Var.O000000o()))) {
                if ((this.e || !i(field.getType())) && !f(field.getType())) {
                    List<g7> list = z ? this.g : this.h;
                    if (list.isEmpty()) {
                        return false;
                    }
                    n7 n7Var = new n7(field);
                    for (g7 g7Var : list) {
                        if (g7Var.a(n7Var)) {
                            return true;
                        }
                    }
                    return false;
                }
                return true;
            }
            return true;
        }
        return true;
    }
}
