package defpackage;

import java.io.IOException;
import java.io.Writer;
/* compiled from: Streams.java */
/* renamed from: e7  reason: default package */
/* loaded from: classes.dex */
public final class e7 {

    /* compiled from: Streams.java */
    /* renamed from: e7$b */
    /* loaded from: classes.dex */
    private static final class b extends Writer {
        private final Appendable b;
        private final a c;

        /* compiled from: Streams.java */
        /* renamed from: e7$b$a */
        /* loaded from: classes.dex */
        static class a implements CharSequence {
            char[] b;

            a() {
            }

            @Override // java.lang.CharSequence
            public char charAt(int i) {
                return this.b[i];
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.b.length;
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int i, int i2) {
                return new String(this.b, i, i2 - i);
            }
        }

        private b(Appendable appendable) {
            this.c = new a();
            this.b = appendable;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        @Override // java.io.Writer
        public void write(int i) throws IOException {
            this.b.append((char) i);
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) throws IOException {
            a aVar = this.c;
            aVar.b = cArr;
            this.b.append(aVar, i, i2 + i);
        }
    }

    public static Writer a(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new b(appendable);
    }

    public static void b(d8 d8Var, k7 k7Var) throws IOException {
        u6.P.a(k7Var, d8Var);
    }
}
