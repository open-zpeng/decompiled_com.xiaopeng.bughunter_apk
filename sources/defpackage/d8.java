package defpackage;

import java.io.IOException;
import java.io.StringWriter;
/* compiled from: JsonElement.java */
/* renamed from: d8  reason: default package */
/* loaded from: classes.dex */
public abstract class d8 {
    public boolean a() {
        return this instanceof v7;
    }

    public boolean b() {
        return this instanceof r7;
    }

    public boolean c() {
        return this instanceof u7;
    }

    public boolean d() {
        return this instanceof x7;
    }

    public v7 e() {
        if (a()) {
            return (v7) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public r7 f() {
        if (b()) {
            return (r7) this;
        }
        throw new IllegalStateException("This is not a JSON Array.");
    }

    public x7 g() {
        if (d()) {
            return (x7) this;
        }
        throw new IllegalStateException("This is not a JSON Primitive.");
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            k7 k7Var = new k7(stringWriter);
            k7Var.l(true);
            e7.b(this, k7Var);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
