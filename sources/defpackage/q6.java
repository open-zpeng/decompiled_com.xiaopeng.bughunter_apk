package defpackage;

import java.io.IOException;
import java.util.ArrayList;
/* compiled from: ObjectTypeAdapter.java */
/* renamed from: q6  reason: default package */
/* loaded from: classes.dex */
public final class q6 extends b8<Object> {
    public static final c8 a = new a();
    private final p7 b;

    /* compiled from: ObjectTypeAdapter.java */
    /* renamed from: q6$a */
    /* loaded from: classes.dex */
    static class a implements c8 {
        a() {
        }

        @Override // defpackage.c8
        public <T> b8<T> a(p7 p7Var, m7<T> m7Var) {
            if (m7Var.a() == Object.class) {
                return new q6(p7Var, null);
            }
            return null;
        }
    }

    /* compiled from: ObjectTypeAdapter.java */
    /* renamed from: q6$b */
    /* loaded from: classes.dex */
    static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[j7.values().length];
            a = iArr;
            try {
                iArr[j7.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[j7.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[j7.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[j7.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[j7.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[j7.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private q6(p7 p7Var) {
        this.b = p7Var;
    }

    /* synthetic */ q6(p7 p7Var, a aVar) {
        this(p7Var);
    }

    @Override // defpackage.b8
    public void a(k7 k7Var, Object obj) throws IOException {
        if (obj == null) {
            k7Var.u();
            return;
        }
        b8 e = this.b.e(obj.getClass());
        if (!(e instanceof q6)) {
            e.a(k7Var, obj);
            return;
        }
        k7Var.m();
        k7Var.s();
    }

    @Override // defpackage.b8
    public Object c(i7 i7Var) throws IOException {
        switch (b.a[i7Var.t().ordinal()]) {
            case 1:
                ArrayList arrayList = new ArrayList();
                i7Var.c();
                while (i7Var.s()) {
                    arrayList.add(c(i7Var));
                }
                i7Var.l();
                return arrayList;
            case 2:
                b7 b7Var = new b7();
                i7Var.q();
                while (i7Var.s()) {
                    b7Var.put(i7Var.u(), c(i7Var));
                }
                i7Var.o();
                return b7Var;
            case 3:
                return i7Var.v();
            case 4:
                return Double.valueOf(i7Var.y());
            case 5:
                return Boolean.valueOf(i7Var.x());
            case 6:
                i7Var.w();
                return null;
            default:
                throw new IllegalStateException();
        }
    }
}
