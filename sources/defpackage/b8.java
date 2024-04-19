package defpackage;

import java.io.IOException;
/* compiled from: TypeAdapter.java */
/* renamed from: b8  reason: default package */
/* loaded from: classes.dex */
public abstract class b8<T> {
    public abstract void a(k7 k7Var, T t) throws IOException;

    public final d8 b(T t) {
        try {
            n6 n6Var = new n6();
            a(n6Var, t);
            return n6Var.B();
        } catch (IOException e) {
            throw new t7(e);
        }
    }

    public abstract T c(i7 i7Var) throws IOException;
}
