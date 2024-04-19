package defpackage;

import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* compiled from: JsonTreeReader.java */
/* renamed from: l6  reason: default package */
/* loaded from: classes.dex */
public final class l6 extends i7 {
    private static final Reader p = new a();
    private static final Object q = new Object();
    private final List<Object> r;

    /* compiled from: JsonTreeReader.java */
    /* renamed from: l6$a */
    /* loaded from: classes.dex */
    static class a extends Reader {
        a() {
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            throw new AssertionError();
        }
    }

    private void O(j7 j7Var) throws IOException {
        if (t() == j7Var) {
            return;
        }
        throw new IllegalStateException("Expected " + j7Var + " but was " + t());
    }

    private Object P() {
        List<Object> list = this.r;
        return list.get(list.size() - 1);
    }

    private Object R() {
        List<Object> list = this.r;
        return list.remove(list.size() - 1);
    }

    @Override // defpackage.i7
    public void B() throws IOException {
        if (t() == j7.NAME) {
            u();
        } else {
            R();
        }
    }

    @Override // defpackage.i7
    public int C() throws IOException {
        j7 t = t();
        j7 j7Var = j7.NUMBER;
        if (t == j7Var || t == j7.STRING) {
            int o = ((x7) P()).o();
            R();
            return o;
        }
        throw new IllegalStateException("Expected " + j7Var + " but was " + t);
    }

    public void Q() throws IOException {
        O(j7.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) P()).next();
        this.r.add(entry.getValue());
        this.r.add(new x7((String) entry.getKey()));
    }

    @Override // defpackage.i7
    public void c() throws IOException {
        O(j7.BEGIN_ARRAY);
        this.r.add(((r7) P()).iterator());
    }

    @Override // defpackage.i7, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.r.clear();
        this.r.add(q);
    }

    @Override // defpackage.i7
    public void l() throws IOException {
        O(j7.END_ARRAY);
        R();
        R();
    }

    @Override // defpackage.i7
    public void o() throws IOException {
        O(j7.END_OBJECT);
        R();
        R();
    }

    @Override // defpackage.i7
    public void q() throws IOException {
        O(j7.BEGIN_OBJECT);
        this.r.add(((v7) P()).i().iterator());
    }

    @Override // defpackage.i7
    public boolean s() throws IOException {
        j7 t = t();
        return (t == j7.END_OBJECT || t == j7.END_ARRAY) ? false : true;
    }

    @Override // defpackage.i7
    public j7 t() throws IOException {
        if (this.r.isEmpty()) {
            return j7.END_DOCUMENT;
        }
        Object P = P();
        if (P instanceof Iterator) {
            List<Object> list = this.r;
            boolean z = list.get(list.size() - 2) instanceof v7;
            Iterator it = (Iterator) P;
            if (!it.hasNext()) {
                return z ? j7.END_OBJECT : j7.END_ARRAY;
            } else if (z) {
                return j7.NAME;
            } else {
                this.r.add(it.next());
                return t();
            }
        } else if (P instanceof v7) {
            return j7.BEGIN_OBJECT;
        } else {
            if (P instanceof r7) {
                return j7.BEGIN_ARRAY;
            }
            if (!(P instanceof x7)) {
                if (P instanceof u7) {
                    return j7.NULL;
                }
                if (P == q) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
            x7 x7Var = (x7) P;
            if (x7Var.t()) {
                return j7.STRING;
            }
            if (x7Var.j()) {
                return j7.BOOLEAN;
            }
            if (x7Var.s()) {
                return j7.NUMBER;
            }
            throw new AssertionError();
        }
    }

    @Override // defpackage.i7
    public String toString() {
        return l6.class.getSimpleName();
    }

    @Override // defpackage.i7
    public String u() throws IOException {
        O(j7.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) P()).next();
        this.r.add(entry.getValue());
        return (String) entry.getKey();
    }

    @Override // defpackage.i7
    public String v() throws IOException {
        j7 t = t();
        j7 j7Var = j7.STRING;
        if (t == j7Var || t == j7.NUMBER) {
            return ((x7) R()).l();
        }
        throw new IllegalStateException("Expected " + j7Var + " but was " + t);
    }

    @Override // defpackage.i7
    public void w() throws IOException {
        O(j7.NULL);
        R();
    }

    @Override // defpackage.i7
    public boolean x() throws IOException {
        O(j7.BOOLEAN);
        return ((x7) R()).q();
    }

    @Override // defpackage.i7
    public double y() throws IOException {
        j7 t = t();
        j7 j7Var = j7.NUMBER;
        if (t != j7Var && t != j7.STRING) {
            throw new IllegalStateException("Expected " + j7Var + " but was " + t);
        }
        double n = ((x7) P()).n();
        if (E() || !(Double.isNaN(n) || Double.isInfinite(n))) {
            R();
            return n;
        }
        throw new NumberFormatException("JSON forbids NaN and infinities: " + n);
    }

    @Override // defpackage.i7
    public long z() throws IOException {
        j7 t = t();
        j7 j7Var = j7.NUMBER;
        if (t == j7Var || t == j7.STRING) {
            long p2 = ((x7) P()).p();
            R();
            return p2;
        }
        throw new IllegalStateException("Expected " + j7Var + " but was " + t);
    }
}
