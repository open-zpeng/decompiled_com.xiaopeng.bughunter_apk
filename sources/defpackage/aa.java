package defpackage;

import android.text.TextUtils;
import java.util.List;
import java.util.UUID;
/* compiled from: Metric.java */
/* renamed from: aa  reason: default package */
/* loaded from: classes.dex */
public class aa implements z8 {
    private String b;
    private String c;
    private String d;
    private boolean e;
    private String f;
    private u9 g;
    private x9 h;
    private String i;

    @Deprecated
    public aa() {
        this.f = null;
    }

    private w9 c(String str, List<w9> list) {
        if (list != null) {
            for (w9 w9Var : list) {
                if (TextUtils.equals(str, w9Var.d)) {
                    return w9Var;
                }
            }
            return null;
        }
        return null;
    }

    @Override // defpackage.z8
    public void a() {
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = false;
        this.g = null;
        this.h = null;
        this.i = null;
    }

    @Override // defpackage.z8
    public void b(Object... objArr) {
        this.b = (String) objArr[0];
        this.c = (String) objArr[1];
        if (objArr.length > 2) {
            this.d = (String) objArr[2];
        }
    }

    public u9 d() {
        return this.g;
    }

    public x9 e() {
        return this.h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            aa aaVar = (aa) obj;
            String str = this.d;
            if (str == null) {
                if (aaVar.d != null) {
                    return false;
                }
            } else if (!str.equals(aaVar.d)) {
                return false;
            }
            String str2 = this.b;
            if (str2 == null) {
                if (aaVar.b != null) {
                    return false;
                }
            } else if (!str2.equals(aaVar.b)) {
                return false;
            }
            String str3 = this.c;
            if (str3 == null) {
                if (aaVar.c != null) {
                    return false;
                }
            } else if (!str3.equals(aaVar.c)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public String f() {
        return this.b;
    }

    public String g() {
        return this.c;
    }

    public synchronized String h() {
        if (this.i == null) {
            this.i = UUID.randomUUID().toString() + "$" + this.b + "$" + this.c;
        }
        return this.i;
    }

    public int hashCode() {
        String str = this.d;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.c;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public synchronized boolean i() {
        if ("1".equalsIgnoreCase(this.f)) {
            return true;
        }
        if ("0".equalsIgnoreCase(this.f)) {
            return false;
        }
        return this.e;
    }

    public void j() {
        this.i = null;
    }

    public synchronized void k(String str) {
        this.f = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean l(defpackage.v9 r6, defpackage.z9 r7) {
        /*
            r5 = this;
            u9 r0 = r5.g
            r1 = 1
            if (r0 == 0) goto La
            boolean r6 = r0.d(r6)
            goto Lb
        La:
            r6 = r1
        Lb:
            ba r0 = defpackage.ba.c()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "config_prefix"
            r2.append(r3)
            java.lang.String r4 = r5.b
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r3)
            java.lang.String r3 = r5.c
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            aa r0 = r0.b(r2, r3)
            r2 = 0
            if (r0 == 0) goto L8a
            x9 r3 = r0.e()
            if (r3 == 0) goto L8a
            if (r7 == 0) goto L8a
            java.util.Map r3 = r7.f()
            if (r3 == 0) goto L8a
            x9 r3 = r5.h
            if (r3 == 0) goto L8a
            x9 r0 = r0.e()
            java.util.List r0 = r0.e()
            java.util.Map r1 = r7.f()
            java.util.Set r1 = r1.keySet()
            java.util.Iterator r1 = r1.iterator()
        L60:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L89
            java.lang.Object r3 = r1.next()
            java.lang.String r3 = (java.lang.String) r3
            w9 r4 = r5.c(r3, r0)
            if (r4 != 0) goto L7c
            x9 r4 = r5.h
            java.util.List r4 = r4.e()
            w9 r4 = r5.c(r3, r4)
        L7c:
            if (r4 == 0) goto L88
            y9 r3 = r7.g(r3)
            boolean r3 = r4.e(r3)
            if (r3 != 0) goto L60
        L88:
            return r2
        L89:
            return r6
        L8a:
            x9 r0 = r5.h
            if (r0 == 0) goto L99
            if (r6 == 0) goto L97
            boolean r6 = r0.g(r7)
            if (r6 == 0) goto L97
            goto L98
        L97:
            r1 = r2
        L98:
            r6 = r1
        L99:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.aa.l(v9, z9):boolean");
    }

    public aa(String str, String str2, x9 x9Var, u9 u9Var, boolean z) {
        this.f = null;
        this.b = str;
        this.c = str2;
        this.g = u9Var;
        this.h = x9Var;
        this.d = null;
        this.e = z;
    }
}
