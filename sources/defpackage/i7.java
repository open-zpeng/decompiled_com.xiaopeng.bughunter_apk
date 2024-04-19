package defpackage;

import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.util.Objects;
/* compiled from: JsonReader.java */
/* renamed from: i7  reason: default package */
/* loaded from: classes.dex */
public class i7 implements Closeable {
    private static final char[] b = ")]}'\n".toCharArray();
    private final Reader c;
    private boolean d = false;
    private final char[] e = new char[1024];
    private int f = 0;
    private int g = 0;
    private int h = 0;
    private int i = 0;
    private int j = 0;
    private long k;
    private int l;
    private String m;
    private int[] n;
    private int o;

    /* compiled from: JsonReader.java */
    /* renamed from: i7$a */
    /* loaded from: classes.dex */
    static class a extends z6 {
        a() {
        }

        @Override // defpackage.z6
        public void a(i7 i7Var) throws IOException {
            int i;
            if (i7Var instanceof l6) {
                ((l6) i7Var).Q();
                return;
            }
            int i2 = i7Var.j;
            if (i2 == 0) {
                i2 = i7Var.D();
            }
            if (i2 == 13) {
                i = 9;
            } else if (i2 == 12) {
                i = 8;
            } else if (i2 != 14) {
                throw new IllegalStateException("Expected a name but was " + i7Var.t() + "  at line " + i7Var.I() + " column " + i7Var.K());
            } else {
                i = 10;
            }
            i7Var.j = i;
        }
    }

    static {
        z6.a = new a();
    }

    public i7(Reader reader) {
        int[] iArr = new int[32];
        this.n = iArr;
        this.o = 0;
        this.o = 0 + 1;
        iArr[0] = 6;
        Objects.requireNonNull(reader, "in == null");
        this.c = reader;
    }

    private int A() throws IOException {
        int i;
        String str;
        String str2;
        char c = this.e[this.f];
        if (c == 't' || c == 'T') {
            i = 5;
            str = "true";
            str2 = "TRUE";
        } else if (c == 'f' || c == 'F') {
            i = 6;
            str = "false";
            str2 = "FALSE";
        } else if (c != 'n' && c != 'N') {
            return 0;
        } else {
            i = 7;
            str = "null";
            str2 = "NULL";
        }
        int length = str.length();
        for (int i2 = 1; i2 < length; i2++) {
            if (this.f + i2 >= this.g && !m(i2 + 1)) {
                return 0;
            }
            char c2 = this.e[this.f + i2];
            if (c2 != str.charAt(i2) && c2 != str2.charAt(i2)) {
                return 0;
            }
        }
        if ((this.f + length < this.g || m(length + 1)) && f(this.e[this.f + length])) {
            return 0;
        }
        this.f += length;
        this.j = i;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int D() throws IOException {
        int i;
        int i2;
        int[] iArr = this.n;
        int i3 = this.o;
        int i4 = iArr[i3 - 1];
        if (i4 == 1) {
            iArr[i3 - 1] = 2;
        } else if (i4 != 2) {
            if (i4 == 3 || i4 == 5) {
                iArr[i3 - 1] = 4;
                if (i4 == 5 && (i2 = i(true)) != 44) {
                    if (i2 != 59) {
                        if (i2 == 125) {
                            this.j = 2;
                            return 2;
                        }
                        throw j("Unterminated object");
                    }
                    J();
                }
                int i5 = i(true);
                if (i5 == 34) {
                    i = 13;
                } else if (i5 == 39) {
                    J();
                    i = 12;
                } else if (i5 == 125) {
                    if (i4 != 5) {
                        this.j = 2;
                        return 2;
                    }
                    throw j("Expected name");
                } else {
                    J();
                    this.f--;
                    if (!f((char) i5)) {
                        throw j("Expected name");
                    }
                    i = 14;
                }
            } else if (i4 == 4) {
                iArr[i3 - 1] = 5;
                int i6 = i(true);
                if (i6 != 58) {
                    if (i6 != 61) {
                        throw j("Expected ':'");
                    }
                    J();
                    if (this.f < this.g || m(1)) {
                        char[] cArr = this.e;
                        int i7 = this.f;
                        if (cArr[i7] == '>') {
                            this.f = i7 + 1;
                        }
                    }
                }
            } else if (i4 == 6) {
                if (this.d) {
                    N();
                }
                this.n[this.o - 1] = 7;
            } else if (i4 == 7) {
                if (i(false) == -1) {
                    i = 17;
                } else {
                    J();
                    this.f--;
                }
            } else if (i4 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
            this.j = i;
            return i;
        } else {
            int i8 = i(true);
            if (i8 != 44) {
                if (i8 != 59) {
                    if (i8 == 93) {
                        this.j = 4;
                        return 4;
                    }
                    throw j("Unterminated array");
                }
                J();
            }
        }
        int i9 = i(true);
        if (i9 != 34) {
            if (i9 == 39) {
                J();
                this.j = 8;
                return 8;
            }
            if (i9 != 44 && i9 != 59) {
                if (i9 == 91) {
                    this.j = 3;
                    return 3;
                } else if (i9 != 93) {
                    if (i9 == 123) {
                        this.j = 1;
                        return 1;
                    }
                    this.f--;
                    if (this.o == 1) {
                        J();
                    }
                    int A = A();
                    if (A != 0) {
                        return A;
                    }
                    int G = G();
                    if (G != 0) {
                        return G;
                    }
                    if (!f(this.e[this.f])) {
                        throw j("Expected value");
                    }
                    J();
                    i = 10;
                } else if (i4 == 1) {
                    this.j = 4;
                    return 4;
                }
            }
            if (i4 == 1 || i4 == 2) {
                J();
                this.f--;
                this.j = 7;
                return 7;
            }
            throw j("Unexpected value");
        }
        if (this.o == 1) {
            J();
        }
        i = 9;
        this.j = i;
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x004a, code lost:
        J();
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String F() throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
        L2:
            r2 = r0
        L3:
            int r3 = r6.f
            int r4 = r3 + r2
            int r5 = r6.g
            if (r4 >= r5) goto L4e
            char[] r4 = r6.e
            int r3 = r3 + r2
            char r3 = r4[r3]
            r4 = 9
            if (r3 == r4) goto L5c
            r4 = 10
            if (r3 == r4) goto L5c
            r4 = 12
            if (r3 == r4) goto L5c
            r4 = 13
            if (r3 == r4) goto L5c
            r4 = 32
            if (r3 == r4) goto L5c
            r4 = 35
            if (r3 == r4) goto L4a
            r4 = 44
            if (r3 == r4) goto L5c
            r4 = 47
            if (r3 == r4) goto L4a
            r4 = 61
            if (r3 == r4) goto L4a
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L5c
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L5c
            r4 = 58
            if (r3 == r4) goto L5c
            r4 = 59
            if (r3 == r4) goto L4a
            switch(r3) {
                case 91: goto L5c;
                case 92: goto L4a;
                case 93: goto L5c;
                default: goto L47;
            }
        L47:
            int r2 = r2 + 1
            goto L3
        L4a:
            r6.J()
            goto L5c
        L4e:
            char[] r3 = r6.e
            int r3 = r3.length
            if (r2 >= r3) goto L5e
            int r3 = r2 + 1
            boolean r3 = r6.m(r3)
            if (r3 == 0) goto L5c
            goto L3
        L5c:
            r0 = r2
            goto L78
        L5e:
            if (r1 != 0) goto L65
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
        L65:
            char[] r3 = r6.e
            int r4 = r6.f
            r1.append(r3, r4, r2)
            int r3 = r6.f
            int r3 = r3 + r2
            r6.f = r3
            r2 = 1
            boolean r2 = r6.m(r2)
            if (r2 != 0) goto L2
        L78:
            if (r1 != 0) goto L84
            java.lang.String r1 = new java.lang.String
            char[] r2 = r6.e
            int r3 = r6.f
            r1.<init>(r2, r3, r0)
            goto L8f
        L84:
            char[] r2 = r6.e
            int r3 = r6.f
            r1.append(r2, r3, r0)
            java.lang.String r1 = r1.toString()
        L8f:
            int r2 = r6.f
            int r2 = r2 + r0
            r6.f = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.i7.F():java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x0093, code lost:
        if (f(r14) != false) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0095, code lost:
        if (r9 != 2) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0097, code lost:
        if (r10 == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x009d, code lost:
        if (r11 != Long.MIN_VALUE) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x009f, code lost:
        if (r13 == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00a1, code lost:
        if (r13 == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00a4, code lost:
        r11 = -r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00a5, code lost:
        r18.k = r11;
        r18.f += r8;
        r1 = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00ae, code lost:
        r18.j = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00b0, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00b1, code lost:
        if (r9 == 2) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00b4, code lost:
        if (r9 == 4) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00b7, code lost:
        if (r9 != 7) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00ba, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00bc, code lost:
        r18.l = r8;
        r1 = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00c1, code lost:
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int G() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 239
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.i7.G():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0048, code lost:
        J();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void H() throws java.io.IOException {
        /*
            r4 = this;
        L0:
            r0 = 0
        L1:
            int r1 = r4.f
            int r2 = r1 + r0
            int r3 = r4.g
            if (r2 >= r3) goto L51
            char[] r2 = r4.e
            int r1 = r1 + r0
            char r1 = r2[r1]
            r2 = 9
            if (r1 == r2) goto L4b
            r2 = 10
            if (r1 == r2) goto L4b
            r2 = 12
            if (r1 == r2) goto L4b
            r2 = 13
            if (r1 == r2) goto L4b
            r2 = 32
            if (r1 == r2) goto L4b
            r2 = 35
            if (r1 == r2) goto L48
            r2 = 44
            if (r1 == r2) goto L4b
            r2 = 47
            if (r1 == r2) goto L48
            r2 = 61
            if (r1 == r2) goto L48
            r2 = 123(0x7b, float:1.72E-43)
            if (r1 == r2) goto L4b
            r2 = 125(0x7d, float:1.75E-43)
            if (r1 == r2) goto L4b
            r2 = 58
            if (r1 == r2) goto L4b
            r2 = 59
            if (r1 == r2) goto L48
            switch(r1) {
                case 91: goto L4b;
                case 92: goto L48;
                case 93: goto L4b;
                default: goto L45;
            }
        L45:
            int r0 = r0 + 1
            goto L1
        L48:
            r4.J()
        L4b:
            int r1 = r4.f
            int r1 = r1 + r0
            r4.f = r1
            return
        L51:
            int r1 = r1 + r0
            r4.f = r1
            r0 = 1
            boolean r0 = r4.m(r0)
            if (r0 != 0) goto L0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.i7.H():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int I() {
        return this.h + 1;
    }

    private void J() throws IOException {
        if (!this.d) {
            throw j("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int K() {
        return (this.f - this.i) + 1;
    }

    private void L() throws IOException {
        char c;
        do {
            if (this.f >= this.g && !m(1)) {
                return;
            }
            char[] cArr = this.e;
            int i = this.f;
            int i2 = i + 1;
            this.f = i2;
            c = cArr[i];
            if (c == '\n') {
                this.h++;
                this.i = i2;
                return;
            }
        } while (c != '\r');
    }

    private char M() throws IOException {
        int i;
        int i2;
        if (this.f != this.g || m(1)) {
            char[] cArr = this.e;
            int i3 = this.f;
            int i4 = i3 + 1;
            this.f = i4;
            char c = cArr[i3];
            if (c == '\n') {
                this.h++;
                this.i = i4;
            } else if (c == 'b') {
                return '\b';
            } else {
                if (c == 'f') {
                    return '\f';
                }
                if (c == 'n') {
                    return '\n';
                }
                if (c == 'r') {
                    return '\r';
                }
                if (c == 't') {
                    return '\t';
                }
                if (c == 'u') {
                    if (i4 + 4 <= this.g || m(4)) {
                        char c2 = 0;
                        int i5 = this.f;
                        int i6 = i5 + 4;
                        while (i5 < i6) {
                            char c3 = this.e[i5];
                            char c4 = (char) (c2 << 4);
                            if (c3 < '0' || c3 > '9') {
                                if (c3 >= 'a' && c3 <= 'f') {
                                    i = c3 - 'a';
                                } else if (c3 < 'A' || c3 > 'F') {
                                    throw new NumberFormatException("\\u" + new String(this.e, this.f, 4));
                                } else {
                                    i = c3 - 'A';
                                }
                                i2 = i + 10;
                            } else {
                                i2 = c3 - '0';
                            }
                            c2 = (char) (c4 + i2);
                            i5++;
                        }
                        this.f += 4;
                        return c2;
                    }
                    throw j("Unterminated escape sequence");
                }
            }
            return c;
        }
        throw j("Unterminated escape sequence");
    }

    private void N() throws IOException {
        i(true);
        int i = this.f - 1;
        this.f = i;
        char[] cArr = b;
        if (i + cArr.length > this.g && !m(cArr.length)) {
            return;
        }
        int i2 = 0;
        while (true) {
            char[] cArr2 = b;
            if (i2 >= cArr2.length) {
                this.f += cArr2.length;
                return;
            } else if (this.e[this.f + i2] != cArr2[i2]) {
                return;
            } else {
                i2++;
            }
        }
    }

    private void d(int i) {
        int i2 = this.o;
        int[] iArr = this.n;
        if (i2 == iArr.length) {
            int[] iArr2 = new int[i2 * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.n = iArr2;
        }
        int[] iArr3 = this.n;
        int i3 = this.o;
        this.o = i3 + 1;
        iArr3[i3] = i;
    }

    private boolean f(char c) throws IOException {
        if (c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ') {
            return false;
        }
        if (c != '#') {
            if (c == ',') {
                return false;
            }
            if (c != '/' && c != '=') {
                if (c == '{' || c == '}' || c == ':') {
                    return false;
                }
                if (c != ';') {
                    switch (c) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        J();
        return false;
    }

    private boolean g(String str) throws IOException {
        while (true) {
            if (this.f + str.length() > this.g && !m(str.length())) {
                return false;
            }
            char[] cArr = this.e;
            int i = this.f;
            if (cArr[i] != '\n') {
                for (int i2 = 0; i2 < str.length(); i2++) {
                    if (this.e[this.f + i2] != str.charAt(i2)) {
                        break;
                    }
                }
                return true;
            }
            this.h++;
            this.i = i + 1;
            this.f++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x005f, code lost:
        if (r1 != '/') goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0061, code lost:
        r7.f = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0064, code lost:
        if (r4 != r2) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0066, code lost:
        r7.f = r4 - 1;
        r2 = m(2);
        r7.f++;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0073, code lost:
        if (r2 != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0075, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0076, code lost:
        J();
        r2 = r7.f;
        r3 = r0[r2];
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007f, code lost:
        if (r3 == '*') goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0081, code lost:
        if (r3 == '/') goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0083, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0084, code lost:
        r7.f = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x008d, code lost:
        r7.f = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0097, code lost:
        if (g("*\/") == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00a4, code lost:
        throw j("Unterminated comment");
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00a5, code lost:
        r7.f = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00a9, code lost:
        if (r1 != '#') goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00ab, code lost:
        J();
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00af, code lost:
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int i(boolean r8) throws java.io.IOException {
        /*
            r7 = this;
            char[] r0 = r7.e
        L2:
            int r1 = r7.f
        L4:
            int r2 = r7.g
        L6:
            r3 = 1
            if (r1 != r2) goto L40
            r7.f = r1
            boolean r1 = r7.m(r3)
            if (r1 != 0) goto L3c
            if (r8 != 0) goto L15
            r8 = -1
            return r8
        L15:
            java.io.EOFException r8 = new java.io.EOFException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "End of input at line "
            r0.append(r1)
            int r1 = r7.I()
            r0.append(r1)
            java.lang.String r1 = " column "
            r0.append(r1)
            int r1 = r7.K()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r8.<init>(r0)
            throw r8
        L3c:
            int r1 = r7.f
            int r2 = r7.g
        L40:
            int r4 = r1 + 1
            char r1 = r0[r1]
            r5 = 10
            if (r1 != r5) goto L50
            int r1 = r7.h
            int r1 = r1 + r3
            r7.h = r1
            r7.i = r4
            goto Lb0
        L50:
            r5 = 32
            if (r1 == r5) goto Lb0
            r5 = 13
            if (r1 == r5) goto Lb0
            r5 = 9
            if (r1 != r5) goto L5d
            goto Lb0
        L5d:
            r5 = 47
            if (r1 != r5) goto La5
            r7.f = r4
            r6 = 2
            if (r4 != r2) goto L76
            int r4 = r4 + (-1)
            r7.f = r4
            boolean r2 = r7.m(r6)
            int r4 = r7.f
            int r4 = r4 + r3
            r7.f = r4
            if (r2 != 0) goto L76
            return r1
        L76:
            r7.J()
            int r2 = r7.f
            char r3 = r0[r2]
            r4 = 42
            if (r3 == r4) goto L8d
            if (r3 == r5) goto L84
            return r1
        L84:
            int r2 = r2 + 1
            r7.f = r2
        L88:
            r7.L()
            goto L2
        L8d:
            int r2 = r2 + 1
            r7.f = r2
        */
        //  java.lang.String r1 = "*/"
        /*
            boolean r1 = r7.g(r1)
            if (r1 == 0) goto L9e
            int r1 = r7.f
            int r1 = r1 + r6
            goto L4
        L9e:
            java.lang.String r8 = "Unterminated comment"
            java.io.IOException r8 = r7.j(r8)
            throw r8
        La5:
            r2 = 35
            r7.f = r4
            if (r1 != r2) goto Laf
            r7.J()
            goto L88
        Laf:
            return r1
        Lb0:
            r1 = r4
            goto L6
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.i7.i(boolean):int");
    }

    private IOException j(String str) throws IOException {
        throw new l7(str + " at line " + I() + " column " + K());
    }

    private String k(char c) throws IOException {
        char[] cArr = this.e;
        StringBuilder sb = new StringBuilder();
        while (true) {
            int i = this.f;
            int i2 = this.g;
            while (true) {
                if (i < i2) {
                    int i3 = i + 1;
                    char c2 = cArr[i];
                    if (c2 == c) {
                        this.f = i3;
                        sb.append(cArr, i, (i3 - i) - 1);
                        return sb.toString();
                    } else if (c2 == '\\') {
                        this.f = i3;
                        sb.append(cArr, i, (i3 - i) - 1);
                        sb.append(M());
                        break;
                    } else {
                        if (c2 == '\n') {
                            this.h++;
                            this.i = i3;
                        }
                        i = i3;
                    }
                } else {
                    sb.append(cArr, i, i - i);
                    this.f = i;
                    if (!m(1)) {
                        throw j("Unterminated string");
                    }
                }
            }
        }
    }

    private boolean m(int i) throws IOException {
        int i2;
        int i3;
        char[] cArr = this.e;
        int i4 = this.i;
        int i5 = this.f;
        this.i = i4 - i5;
        int i6 = this.g;
        if (i6 != i5) {
            int i7 = i6 - i5;
            this.g = i7;
            System.arraycopy(cArr, i5, cArr, 0, i7);
        } else {
            this.g = 0;
        }
        this.f = 0;
        do {
            Reader reader = this.c;
            int i8 = this.g;
            int read = reader.read(cArr, i8, cArr.length - i8);
            if (read == -1) {
                return false;
            }
            i2 = this.g + read;
            this.g = i2;
            if (this.h == 0 && (i3 = this.i) == 0 && i2 > 0 && cArr[0] == 65279) {
                this.f++;
                this.i = i3 + 1;
                i++;
                continue;
            }
        } while (i2 < i);
        return true;
    }

    private void r(char c) throws IOException {
        char[] cArr = this.e;
        while (true) {
            int i = this.f;
            int i2 = this.g;
            while (true) {
                if (i < i2) {
                    int i3 = i + 1;
                    char c2 = cArr[i];
                    if (c2 == c) {
                        this.f = i3;
                        return;
                    } else if (c2 == '\\') {
                        this.f = i3;
                        M();
                        break;
                    } else {
                        if (c2 == '\n') {
                            this.h++;
                            this.i = i3;
                        }
                        i = i3;
                    }
                } else {
                    this.f = i;
                    if (!m(1)) {
                        throw j("Unterminated string");
                    }
                }
            }
        }
    }

    public void B() throws IOException {
        char c;
        int i = 0;
        do {
            int i2 = this.j;
            if (i2 == 0) {
                i2 = D();
            }
            if (i2 == 3) {
                d(1);
            } else if (i2 == 1) {
                d(3);
            } else {
                if (i2 == 4 || i2 == 2) {
                    this.o--;
                    i--;
                } else if (i2 == 14 || i2 == 10) {
                    H();
                } else {
                    if (i2 == 8 || i2 == 12) {
                        c = '\'';
                    } else if (i2 == 9 || i2 == 13) {
                        c = '\"';
                    } else if (i2 == 16) {
                        this.f += this.l;
                    }
                    r(c);
                }
                this.j = 0;
            }
            i++;
            this.j = 0;
        } while (i != 0);
    }

    public int C() throws IOException {
        int i = this.j;
        if (i == 0) {
            i = D();
        }
        if (i == 15) {
            long j = this.k;
            int i2 = (int) j;
            if (j == i2) {
                this.j = 0;
                return i2;
            }
            throw new NumberFormatException("Expected an int but was " + this.k + " at line " + I() + " column " + K());
        }
        if (i == 16) {
            this.m = new String(this.e, this.f, this.l);
            this.f += this.l;
        } else if (i != 8 && i != 9) {
            throw new IllegalStateException("Expected an int but was " + t() + " at line " + I() + " column " + K());
        } else {
            String k = k(i == 8 ? '\'' : '\"');
            this.m = k;
            try {
                int parseInt = Integer.parseInt(k);
                this.j = 0;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        }
        this.j = 11;
        double parseDouble = Double.parseDouble(this.m);
        int i3 = (int) parseDouble;
        if (i3 == parseDouble) {
            this.m = null;
            this.j = 0;
            return i3;
        }
        throw new NumberFormatException("Expected an int but was " + this.m + " at line " + I() + " column " + K());
    }

    public final boolean E() {
        return this.d;
    }

    public void c() throws IOException {
        int i = this.j;
        if (i == 0) {
            i = D();
        }
        if (i == 3) {
            d(1);
            this.j = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_ARRAY but was " + t() + " at line " + I() + " column " + K());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.j = 0;
        this.n[0] = 8;
        this.o = 1;
        this.c.close();
    }

    public final void e(boolean z) {
        this.d = z;
    }

    public void l() throws IOException {
        int i = this.j;
        if (i == 0) {
            i = D();
        }
        if (i == 4) {
            this.o--;
            this.j = 0;
            return;
        }
        throw new IllegalStateException("Expected END_ARRAY but was " + t() + " at line " + I() + " column " + K());
    }

    public void o() throws IOException {
        int i = this.j;
        if (i == 0) {
            i = D();
        }
        if (i == 2) {
            this.o--;
            this.j = 0;
            return;
        }
        throw new IllegalStateException("Expected END_OBJECT but was " + t() + " at line " + I() + " column " + K());
    }

    public void q() throws IOException {
        int i = this.j;
        if (i == 0) {
            i = D();
        }
        if (i == 1) {
            d(3);
            this.j = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + t() + " at line " + I() + " column " + K());
    }

    public boolean s() throws IOException {
        int i = this.j;
        if (i == 0) {
            i = D();
        }
        return (i == 2 || i == 4) ? false : true;
    }

    public j7 t() throws IOException {
        int i = this.j;
        if (i == 0) {
            i = D();
        }
        switch (i) {
            case 1:
                return j7.BEGIN_OBJECT;
            case 2:
                return j7.END_OBJECT;
            case 3:
                return j7.BEGIN_ARRAY;
            case 4:
                return j7.END_ARRAY;
            case 5:
            case 6:
                return j7.BOOLEAN;
            case 7:
                return j7.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return j7.STRING;
            case 12:
            case 13:
            case 14:
                return j7.NAME;
            case 15:
            case 16:
                return j7.NUMBER;
            case 17:
                return j7.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public String toString() {
        return getClass().getSimpleName() + " at line " + I() + " column " + K();
    }

    public String u() throws IOException {
        char c;
        String k;
        int i = this.j;
        if (i == 0) {
            i = D();
        }
        if (i == 14) {
            k = F();
        } else {
            if (i == 12) {
                c = '\'';
            } else if (i != 13) {
                throw new IllegalStateException("Expected a name but was " + t() + " at line " + I() + " column " + K());
            } else {
                c = '\"';
            }
            k = k(c);
        }
        this.j = 0;
        return k;
    }

    public String v() throws IOException {
        String str;
        char c;
        int i = this.j;
        if (i == 0) {
            i = D();
        }
        if (i == 10) {
            str = F();
        } else {
            if (i == 8) {
                c = '\'';
            } else if (i == 9) {
                c = '\"';
            } else if (i == 11) {
                str = this.m;
                this.m = null;
            } else if (i == 15) {
                str = Long.toString(this.k);
            } else if (i != 16) {
                throw new IllegalStateException("Expected a string but was " + t() + " at line " + I() + " column " + K());
            } else {
                str = new String(this.e, this.f, this.l);
                this.f += this.l;
            }
            str = k(c);
        }
        this.j = 0;
        return str;
    }

    public void w() throws IOException {
        int i = this.j;
        if (i == 0) {
            i = D();
        }
        if (i == 7) {
            this.j = 0;
            return;
        }
        throw new IllegalStateException("Expected null but was " + t() + " at line " + I() + " column " + K());
    }

    public boolean x() throws IOException {
        int i = this.j;
        if (i == 0) {
            i = D();
        }
        if (i == 5) {
            this.j = 0;
            return true;
        } else if (i == 6) {
            this.j = 0;
            return false;
        } else {
            throw new IllegalStateException("Expected a boolean but was " + t() + " at line " + I() + " column " + K());
        }
    }

    public double y() throws IOException {
        String k;
        int i = this.j;
        if (i == 0) {
            i = D();
        }
        if (i == 15) {
            this.j = 0;
            return this.k;
        }
        if (i == 16) {
            this.m = new String(this.e, this.f, this.l);
            this.f += this.l;
        } else {
            if (i == 8 || i == 9) {
                k = k(i == 8 ? '\'' : '\"');
            } else if (i == 10) {
                k = F();
            } else if (i != 11) {
                throw new IllegalStateException("Expected a double but was " + t() + " at line " + I() + " column " + K());
            }
            this.m = k;
        }
        this.j = 11;
        double parseDouble = Double.parseDouble(this.m);
        if (this.d || !(Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            this.m = null;
            this.j = 0;
            return parseDouble;
        }
        throw new l7("JSON forbids NaN and infinities: " + parseDouble + " at line " + I() + " column " + K());
    }

    public long z() throws IOException {
        int i = this.j;
        if (i == 0) {
            i = D();
        }
        if (i == 15) {
            this.j = 0;
            return this.k;
        }
        if (i == 16) {
            this.m = new String(this.e, this.f, this.l);
            this.f += this.l;
        } else if (i != 8 && i != 9) {
            throw new IllegalStateException("Expected a long but was " + t() + " at line " + I() + " column " + K());
        } else {
            String k = k(i == 8 ? '\'' : '\"');
            this.m = k;
            try {
                long parseLong = Long.parseLong(k);
                this.j = 0;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        }
        this.j = 11;
        double parseDouble = Double.parseDouble(this.m);
        long j = (long) parseDouble;
        if (j == parseDouble) {
            this.m = null;
            this.j = 0;
            return j;
        }
        throw new NumberFormatException("Expected a long but was " + this.m + " at line " + I() + " column " + K());
    }
}
