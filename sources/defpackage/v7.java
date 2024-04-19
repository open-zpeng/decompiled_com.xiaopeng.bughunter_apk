package defpackage;

import java.util.Map;
import java.util.Set;
/* compiled from: JsonObject.java */
/* renamed from: v7  reason: default package */
/* loaded from: classes.dex */
public final class v7 extends d8 {
    private final b7<String, d8> a = new b7<>();

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof v7) && ((v7) obj).a.equals(this.a));
    }

    public void h(String str, d8 d8Var) {
        if (d8Var == null) {
            d8Var = u7.a;
        }
        this.a.put(str, d8Var);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public Set<Map.Entry<String, d8>> i() {
        return this.a.entrySet();
    }
}
