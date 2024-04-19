package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* compiled from: JsonArray.java */
/* renamed from: r7  reason: default package */
/* loaded from: classes.dex */
public final class r7 extends d8 implements Iterable<d8> {
    private final List<d8> b = new ArrayList();

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof r7) && ((r7) obj).b.equals(this.b));
    }

    public void h(d8 d8Var) {
        if (d8Var == null) {
            d8Var = u7.a;
        }
        this.b.add(d8Var);
    }

    public int hashCode() {
        return this.b.hashCode();
    }

    @Override // java.lang.Iterable
    public Iterator<d8> iterator() {
        return this.b.iterator();
    }
}
