package defpackage;

import android.util.Base64;
import java.util.List;
/* compiled from: FontRequest.java */
/* renamed from: l3  reason: default package */
/* loaded from: classes.dex */
public final class l3 {
    private final String a;
    private final String b;
    private final String c;
    private final List<List<byte[]>> d;
    private final int e;
    private final String f;

    public l3(String str, String str2, String str3, List<List<byte[]>> list) {
        String str4 = (String) b4.b(str);
        this.a = str4;
        String str5 = (String) b4.b(str2);
        this.b = str5;
        String str6 = (String) b4.b(str3);
        this.c = str6;
        this.d = (List) b4.b(list);
        this.e = 0;
        this.f = str4 + "-" + str5 + "-" + str6;
    }

    public List<List<byte[]>> a() {
        return this.d;
    }

    public int b() {
        return this.e;
    }

    public String c() {
        return this.f;
    }

    public String d() {
        return this.a;
    }

    public String e() {
        return this.b;
    }

    public String f() {
        return this.c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.a + ", mProviderPackage: " + this.b + ", mQuery: " + this.c + ", mCertificates:");
        for (int i = 0; i < this.d.size(); i++) {
            sb.append(" [");
            List<byte[]> list = this.d.get(i);
            for (int i2 = 0; i2 < list.size(); i2++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString(list.get(i2), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.e);
        return sb.toString();
    }
}
