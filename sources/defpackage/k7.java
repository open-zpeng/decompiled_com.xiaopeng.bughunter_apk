package defpackage;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.util.Objects;
import org.apache.commons.io.IOUtils;
/* compiled from: JsonWriter.java */
/* renamed from: k7  reason: default package */
/* loaded from: classes.dex */
public class k7 implements Closeable, Flushable {
    private static final String[] b = new String[128];
    private static final String[] c;
    private final Writer d;
    private int[] e = new int[32];
    private int f = 0;
    private String g;
    private String h;
    private boolean i;
    private boolean j;
    private String k;
    private boolean l;

    static {
        for (int i = 0; i <= 31; i++) {
            b[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        String[] strArr = b;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        c = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public k7(Writer writer) {
        h(6);
        this.h = ":";
        this.l = true;
        Objects.requireNonNull(writer, "out == null");
        this.d = writer;
    }

    private void A() throws IOException {
        int a = a();
        if (a == 5) {
            this.d.write(44);
        } else if (a != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        z();
        k(4);
    }

    private int a() {
        int i = this.f;
        if (i != 0) {
            return this.e[i - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private k7 b(int i, int i2, String str) throws IOException {
        int a = a();
        if (a == i2 || a == i) {
            if (this.k != null) {
                throw new IllegalStateException("Dangling name: " + this.k);
            }
            this.f--;
            if (a == i2) {
                z();
            }
            this.d.write(str);
            return this;
        }
        throw new IllegalStateException("Nesting problem.");
    }

    private k7 c(int i, String str) throws IOException {
        t(true);
        h(i);
        this.d.write(str);
        return this;
    }

    private void h(int i) {
        int i2 = this.f;
        int[] iArr = this.e;
        if (i2 == iArr.length) {
            int[] iArr2 = new int[i2 * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.e = iArr2;
        }
        int[] iArr3 = this.e;
        int i3 = this.f;
        this.f = i3 + 1;
        iArr3[i3] = i;
    }

    private void k(int i) {
        this.e[this.f - 1] = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void n(java.lang.String r9) throws java.io.IOException {
        /*
            r8 = this;
            boolean r0 = r8.j
            if (r0 == 0) goto L7
            java.lang.String[] r0 = defpackage.k7.c
            goto L9
        L7:
            java.lang.String[] r0 = defpackage.k7.b
        L9:
            java.io.Writer r1 = r8.d
            java.lang.String r2 = "\""
            r1.write(r2)
            int r1 = r9.length()
            r3 = 0
            r4 = r3
        L16:
            if (r3 >= r1) goto L45
            char r5 = r9.charAt(r3)
            r6 = 128(0x80, float:1.794E-43)
            if (r5 >= r6) goto L25
            r5 = r0[r5]
            if (r5 != 0) goto L32
            goto L42
        L25:
            r6 = 8232(0x2028, float:1.1535E-41)
            if (r5 != r6) goto L2c
            java.lang.String r5 = "\\u2028"
            goto L32
        L2c:
            r6 = 8233(0x2029, float:1.1537E-41)
            if (r5 != r6) goto L42
            java.lang.String r5 = "\\u2029"
        L32:
            if (r4 >= r3) goto L3b
            java.io.Writer r6 = r8.d
            int r7 = r3 - r4
            r6.write(r9, r4, r7)
        L3b:
            java.io.Writer r4 = r8.d
            r4.write(r5)
            int r4 = r3 + 1
        L42:
            int r3 = r3 + 1
            goto L16
        L45:
            if (r4 >= r1) goto L4d
            java.io.Writer r0 = r8.d
            int r1 = r1 - r4
            r0.write(r9, r4, r1)
        L4d:
            java.io.Writer r9 = r8.d
            r9.write(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.k7.n(java.lang.String):void");
    }

    private void t(boolean z) throws IOException {
        int a = a();
        if (a == 1) {
            k(2);
        } else if (a != 2) {
            if (a == 4) {
                this.d.append((CharSequence) this.h);
                k(5);
                return;
            }
            if (a != 6) {
                if (a != 7) {
                    throw new IllegalStateException("Nesting problem.");
                }
                if (!this.i) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            if (!this.i && !z) {
                throw new IllegalStateException("JSON must start with an array or an object.");
            }
            k(7);
            return;
        } else {
            this.d.append(',');
        }
        z();
    }

    private void x() throws IOException {
        if (this.k != null) {
            A();
            n(this.k);
            this.k = null;
        }
    }

    private void z() throws IOException {
        if (this.g == null) {
            return;
        }
        this.d.write(IOUtils.LINE_SEPARATOR_UNIX);
        int i = this.f;
        for (int i2 = 1; i2 < i; i2++) {
            this.d.write(this.g);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.d.close();
        int i = this.f;
        if (i > 1 || (i == 1 && this.e[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f = 0;
    }

    public k7 d(long j) throws IOException {
        x();
        t(false);
        this.d.write(Long.toString(j));
        return this;
    }

    public k7 e(Number number) throws IOException {
        if (number == null) {
            return u();
        }
        x();
        String obj = number.toString();
        if (this.i || !(obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            t(false);
            this.d.append((CharSequence) obj);
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
    }

    public k7 f(String str) throws IOException {
        Objects.requireNonNull(str, "name == null");
        if (this.k == null) {
            if (this.f != 0) {
                this.k = str;
                return this;
            }
            throw new IllegalStateException("JsonWriter is closed.");
        }
        throw new IllegalStateException();
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        if (this.f == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.d.flush();
    }

    public k7 g(boolean z) throws IOException {
        x();
        t(false);
        this.d.write(z ? "true" : "false");
        return this;
    }

    public k7 i() throws IOException {
        x();
        return c(1, "[");
    }

    public k7 j(String str) throws IOException {
        if (str == null) {
            return u();
        }
        x();
        t(false);
        n(str);
        return this;
    }

    public final void l(boolean z) {
        this.i = z;
    }

    public k7 m() throws IOException {
        x();
        return c(3, "{");
    }

    public final void o(boolean z) {
        this.l = z;
    }

    public k7 p() throws IOException {
        return b(1, 2, "]");
    }

    public final void q(String str) {
        String str2;
        if (str.length() == 0) {
            this.g = null;
            str2 = ":";
        } else {
            this.g = str;
            str2 = ": ";
        }
        this.h = str2;
    }

    public final void r(boolean z) {
        this.j = z;
    }

    public k7 s() throws IOException {
        return b(3, 5, "}");
    }

    public k7 u() throws IOException {
        if (this.k != null) {
            if (!this.l) {
                this.k = null;
                return this;
            }
            x();
        }
        t(false);
        this.d.write("null");
        return this;
    }

    public boolean v() {
        return this.i;
    }

    public final boolean w() {
        return this.j;
    }

    public final boolean y() {
        return this.l;
    }
}
