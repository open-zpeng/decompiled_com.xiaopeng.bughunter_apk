package defpackage;

import okhttp3.Request;
import okhttp3.RequestBody;
/* compiled from: PostRequest.java */
/* renamed from: dd  reason: default package */
/* loaded from: classes.dex */
public class dd<T> extends ed<T, dd<T>> {
    public dd(String str) {
        super(str);
    }

    @Override // defpackage.hd
    public Request f(RequestBody requestBody) {
        return G(requestBody).post(requestBody).url(this.b).tag(this.e).build();
    }
}
