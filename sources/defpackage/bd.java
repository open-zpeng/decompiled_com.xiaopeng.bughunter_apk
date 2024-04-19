package defpackage;

import okhttp3.Request;
import okhttp3.RequestBody;
/* compiled from: GetRequest.java */
/* renamed from: bd  reason: default package */
/* loaded from: classes.dex */
public class bd<T> extends fd<T, bd<T>> {
    public bd(String str) {
        super(str);
    }

    @Override // defpackage.hd
    public Request f(RequestBody requestBody) {
        return G(requestBody).get().url(this.b).tag(this.e).build();
    }
}
