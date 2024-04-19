package defpackage;

import java.util.Objects;
/* compiled from: ObjectHelper.java */
/* renamed from: xh  reason: default package */
/* loaded from: classes.dex */
public final class xh {
    static final kh<Object, Object> a = new a();

    /* compiled from: ObjectHelper.java */
    /* renamed from: xh$a */
    /* loaded from: classes.dex */
    static final class a implements kh<Object, Object> {
        a() {
        }
    }

    public static int a(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i > i2 ? 1 : 0;
    }

    public static int b(long j, long j2) {
        int i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
        if (i < 0) {
            return -1;
        }
        return i > 0 ? 1 : 0;
    }

    public static boolean c(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static <T> T d(T t, String str) {
        Objects.requireNonNull(t, str);
        return t;
    }

    public static int e(int i, String str) {
        if (i > 0) {
            return i;
        }
        throw new IllegalArgumentException(str + " > 0 required but it was " + i);
    }
}
