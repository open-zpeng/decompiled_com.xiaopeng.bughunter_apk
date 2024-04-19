package defpackage;

import okhttp3.Request;
import okhttp3.RequestBody;
/* compiled from: HeadRequest.java */
/* renamed from: cd  reason: default package */
/* loaded from: classes.dex */
public class cd<T> extends fd<T, cd<T>> {
    public cd(String str) {
        super(str);
    }

    @Override // defpackage.hd
    public Request f(RequestBody requestBody) {
        return G(requestBody).head().url(this.b).tag(this.e).build();
    }
}
