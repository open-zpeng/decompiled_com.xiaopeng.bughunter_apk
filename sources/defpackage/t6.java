package defpackage;

import defpackage.p6;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TypeAdapterRuntimeTypeWrapper.java */
/* renamed from: t6  reason: default package */
/* loaded from: classes.dex */
public final class t6<T> extends b8<T> {
    private final p7 a;
    private final b8<T> b;
    private final Type c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t6(p7 p7Var, b8<T> b8Var, Type type) {
        this.a = p7Var;
        this.b = b8Var;
        this.c = type;
    }

    private Type d(Type type, Object obj) {
        return obj != null ? (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class)) ? obj.getClass() : type : type;
    }

    @Override // defpackage.b8
    public void a(k7 k7Var, T t) throws IOException {
        b8<T> b8Var = this.b;
        Type d = d(this.c, t);
        if (d != this.c) {
            b8Var = this.a.b(m7.c(d));
            if (b8Var instanceof p6.b) {
                b8<T> b8Var2 = this.b;
                if (!(b8Var2 instanceof p6.b)) {
                    b8Var = b8Var2;
                }
            }
        }
        b8Var.a(k7Var, t);
    }

    @Override // defpackage.b8
    public T c(i7 i7Var) throws IOException {
        return this.b.c(i7Var);
    }
}
