package defpackage;

import java.util.Objects;
/* compiled from: Preconditions.java */
/* renamed from: b4  reason: default package */
/* loaded from: classes.dex */
public class b4 {
    public static int a(int i) {
        if (i >= 0) {
            return i;
        }
        throw new IllegalArgumentException();
    }

    public static <T> T b(T t) {
        Objects.requireNonNull(t);
        return t;
    }

    public static <T> T c(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }
}
