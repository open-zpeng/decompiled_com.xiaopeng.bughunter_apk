package defpackage;

import java.util.Objects;
/* compiled from: $Gson$Preconditions.java */
/* renamed from: v6  reason: default package */
/* loaded from: classes.dex */
public final class v6 {
    public static <T> T a(T t) {
        Objects.requireNonNull(t);
        return t;
    }

    public static void b(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }
}
