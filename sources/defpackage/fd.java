package defpackage;

import defpackage.fd;
import okhttp3.Request;
import okhttp3.RequestBody;
/* compiled from: NoBodyRequest.java */
/* renamed from: fd  reason: default package */
/* loaded from: classes.dex */
public abstract class fd<T, R extends fd> extends hd<T, R> {
    private static final long serialVersionUID = 1200621102761691196L;

    public fd(String str) {
        super(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Request.Builder G(RequestBody requestBody) {
        this.b = jd.c(this.c, this.j.e);
        return jd.a(new Request.Builder(), this.k);
    }

    @Override // defpackage.hd
    public RequestBody g() {
        return null;
    }
}
