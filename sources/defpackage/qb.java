package defpackage;

import android.text.TextUtils;
import com.xiaopeng.lib.security.xmartv1.XmartV1Constants;
import java.io.UnsupportedEncodingException;
import java.util.Map;
/* compiled from: Log.java */
/* renamed from: qb  reason: default package */
/* loaded from: classes.dex */
public class qb {
    public int a;
    public String b;
    public String c;
    private String d;
    public String e;
    public String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private Map<String, String> k;

    public qb() {
        this.c = "3";
        this.e = null;
        this.f = "";
    }

    public String a() {
        try {
            byte[] a = sa.a(this.d.getBytes(XmartV1Constants.UTF8_ENCODING), 2);
            if (a != null) {
                return new String(db.c(a, "QrMgt8GGYI6T52ZY5AnhtxkLzb8egpFn3j5JELI8H6wtACbUnZ5cc3aYTsTRbmkAkRJeYbtx92LPBWm7nBO9UIl7y5i5MQNmUZNf5QENurR5tGyo7yJ2G0MBjWvy6iAtlAbacKP0SwOUeUWx5dsBdyhxa7Id1APtybSdDgicBDuNjI0mlZFUzZSS9dmN8lBD0WTVOMz0pRZbR3cysomRXOO1ghqjJdTcyDIxzpNAEszN8RMGjrzyU7Hjbmwi6YNK"));
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public String b() {
        return this.d;
    }

    public void c(String str) {
        if (str != null) {
            try {
                this.d = new String(sa.c(db.c(str.getBytes(), "QrMgt8GGYI6T52ZY5AnhtxkLzb8egpFn3j5JELI8H6wtACbUnZ5cc3aYTsTRbmkAkRJeYbtx92LPBWm7nBO9UIl7y5i5MQNmUZNf5QENurR5tGyo7yJ2G0MBjWvy6iAtlAbacKP0SwOUeUWx5dsBdyhxa7Id1APtybSdDgicBDuNjI0mlZFUzZSS9dmN8lBD0WTVOMz0pRZbR3cysomRXOO1ghqjJdTcyDIxzpNAEszN8RMGjrzyU7Hjbmwi6YNK"), 2), XmartV1Constants.UTF8_ENCODING);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }

    public void d(String str) {
        this.d = str;
    }

    public void e() {
        if (TextUtils.isEmpty(this.e)) {
            this.e = String.valueOf(System.currentTimeMillis());
        }
        String a = xa.a(this.g, this.b, this.h, this.i, this.j, this.k, this.f, this.e);
        ya.c("UTLog", this, a);
        c(a);
    }

    public String toString() {
        return "Log [id=" + this.a + ", eventId=" + this.b + ", index=" + this.f + "]";
    }

    public qb(String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        this.c = "3";
        this.e = null;
        this.f = "";
        this.b = str2;
        this.g = str;
        this.h = str3;
        this.i = str4;
        this.j = str5;
        this.k = map;
        this.e = String.valueOf(System.currentTimeMillis());
        e();
    }
}
