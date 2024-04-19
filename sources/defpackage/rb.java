package defpackage;
/* compiled from: BaseRequestAuth.java */
/* renamed from: rb  reason: default package */
/* loaded from: classes.dex */
public class rb implements sb {
    private String a;
    private String b;
    private boolean c;

    public rb(String str, String str2, boolean z) {
        this.a = null;
        this.b = null;
        this.c = false;
        this.a = str;
        this.b = str2;
        this.c = z;
    }

    public boolean a() {
        return this.c;
    }

    @Override // defpackage.sb
    public String getAppkey() {
        return this.a;
    }

    @Override // defpackage.sb
    public String getSign(String str) {
        if (this.a == null || this.b == null) {
            ya.c("BaseRequestAuth", "There is no appkey,please check it!");
            return null;
        } else if (str == null) {
            return null;
        } else {
            return za.a(za.b((str + this.b).getBytes()));
        }
    }
}
