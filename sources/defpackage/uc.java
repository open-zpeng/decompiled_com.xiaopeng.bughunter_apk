package defpackage;
/* compiled from: HttpException.java */
/* renamed from: uc  reason: default package */
/* loaded from: classes.dex */
public class uc extends RuntimeException {
    private static final long serialVersionUID = 8773734741709178425L;

    public uc(String str) {
        super(str);
    }

    public static uc a(String str) {
        return new uc(str);
    }

    public static uc b() {
        return new uc("network error! http response code is 404 or 5xx!");
    }
}
