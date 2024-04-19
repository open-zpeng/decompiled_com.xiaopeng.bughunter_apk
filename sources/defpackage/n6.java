package defpackage;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
/* compiled from: JsonTreeWriter.java */
/* renamed from: n6  reason: default package */
/* loaded from: classes.dex */
public final class n6 extends k7 {
    private static final Writer m = new a();
    private static final x7 n = new x7("closed");
    private final List<d8> o;
    private String p;
    private d8 q;

    /* compiled from: JsonTreeWriter.java */
    /* renamed from: n6$a */
    /* loaded from: classes.dex */
    static class a extends Writer {
        a() {
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) {
            throw new AssertionError();
        }
    }

    public n6() {
        super(m);
        this.o = new ArrayList();
        this.q = u7.a;
    }

    private void C(d8 d8Var) {
        if (this.p != null) {
            if (!d8Var.c() || y()) {
                ((v7) D()).h(this.p, d8Var);
            }
            this.p = null;
        } else if (this.o.isEmpty()) {
            this.q = d8Var;
        } else {
            d8 D = D();
            if (!(D instanceof r7)) {
                throw new IllegalStateException();
            }
            ((r7) D).h(d8Var);
        }
    }

    private d8 D() {
        List<d8> list = this.o;
        return list.get(list.size() - 1);
    }

    public d8 B() {
        if (this.o.isEmpty()) {
            return this.q;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.o);
    }

    @Override // defpackage.k7, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.o.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.o.add(n);
    }

    @Override // defpackage.k7
    public k7 d(long j) throws IOException {
        C(new x7(Long.valueOf(j)));
        return this;
    }

    @Override // defpackage.k7
    public k7 e(Number number) throws IOException {
        if (number == null) {
            return u();
        }
        if (!v()) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        C(new x7(number));
        return this;
    }

    @Override // defpackage.k7
    public k7 f(String str) throws IOException {
        if (this.o.isEmpty() || this.p != null) {
            throw new IllegalStateException();
        }
        if (D() instanceof v7) {
            this.p = str;
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // defpackage.k7, java.io.Flushable
    public void flush() throws IOException {
    }

    @Override // defpackage.k7
    public k7 g(boolean z) throws IOException {
        C(new x7(Boolean.valueOf(z)));
        return this;
    }

    @Override // defpackage.k7
    public k7 i() throws IOException {
        r7 r7Var = new r7();
        C(r7Var);
        this.o.add(r7Var);
        return this;
    }

    @Override // defpackage.k7
    public k7 j(String str) throws IOException {
        if (str == null) {
            return u();
        }
        C(new x7(str));
        return this;
    }

    @Override // defpackage.k7
    public k7 m() throws IOException {
        v7 v7Var = new v7();
        C(v7Var);
        this.o.add(v7Var);
        return this;
    }

    @Override // defpackage.k7
    public k7 p() throws IOException {
        if (this.o.isEmpty() || this.p != null) {
            throw new IllegalStateException();
        }
        if (D() instanceof r7) {
            List<d8> list = this.o;
            list.remove(list.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // defpackage.k7
    public k7 s() throws IOException {
        if (this.o.isEmpty() || this.p != null) {
            throw new IllegalStateException();
        }
        if (D() instanceof v7) {
            List<d8> list = this.o;
            list.remove(list.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // defpackage.k7
    public k7 u() throws IOException {
        C(u7.a);
        return this;
    }
}
