package defpackage;
/* compiled from: CacheException.java */
/* renamed from: tc  reason: default package */
/* loaded from: classes.dex */
public class tc extends Exception {
    private static final long serialVersionUID = 845628123701073013L;

    public tc(String str) {
        super(str);
    }

    public static tc a(String str) {
        return new tc("the http response code is 304, but the cache with cacheKey = " + str + " is null or expired!");
    }
}
