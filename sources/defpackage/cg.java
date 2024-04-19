package defpackage;
/* compiled from: CommonConfig.java */
/* renamed from: cg  reason: default package */
/* loaded from: classes.dex */
public class cg {
    public static final String a = "car.xmart.com/" + gg.e();
    public static String b = dg.b("https://10.0.13.28:8553", "https://xmart.xiaopeng.com");
    public static String c = dg.b("https://10.0.13.28:8556", "https://xmart-eu.xiaopeng.com");
    public static final String d;

    static {
        if (hg.c()) {
            d = c + "/biz";
            return;
        }
        d = b + "/biz";
    }
}
