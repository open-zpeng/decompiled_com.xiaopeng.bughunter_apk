package defpackage;
/* compiled from: ColumnEntity.java */
/* renamed from: pc  reason: default package */
/* loaded from: classes.dex */
public class pc {
    public String a;
    public String b;
    public String[] c;
    public boolean d;
    public boolean e;
    public boolean f;

    public pc(String... strArr) {
        this.c = strArr;
    }

    public pc(String str, String str2) {
        this(str, str2, false, false, false);
    }

    public pc(String str, String str2, boolean z, boolean z2) {
        this(str, str2, z, z2, false);
    }

    public pc(String str, String str2, boolean z, boolean z2, boolean z3) {
        this.a = str;
        this.b = str2;
        this.d = z;
        this.e = z2;
        this.f = z3;
    }
}
