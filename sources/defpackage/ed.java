package defpackage;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import defpackage.ed;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
/* compiled from: BodyRequest.java */
/* renamed from: ed  reason: default package */
/* loaded from: classes.dex */
public abstract class ed<T, R extends ed> extends hd<T, R> {
    private static final long serialVersionUID = -6459175248476927501L;
    protected transient MediaType r;
    protected String s;
    protected byte[] t;
    protected transient File u;
    protected boolean v;
    protected boolean w;
    protected RequestBody x;

    public ed(String str) {
        super(str);
        this.v = false;
        this.w = false;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        String str = (String) objectInputStream.readObject();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.r = MediaType.parse(str);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        MediaType mediaType = this.r;
        objectOutputStream.writeObject(mediaType == null ? "" : mediaType.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Request.Builder G(RequestBody requestBody) {
        try {
            u(HttpHeaders.CONTENT_LENGTH, String.valueOf(requestBody.contentLength()));
        } catch (IOException e) {
            ld.a(e);
        }
        return jd.a(new Request.Builder(), this.k);
    }

    public R H(boolean z) {
        this.v = z;
        return this;
    }

    public R I(String str, File file) {
        this.j.f(str, file);
        return this;
    }

    public R J(File file) {
        this.u = file;
        this.r = jd.e(file.getName());
        return this;
    }

    public R K(String str) {
        this.s = str;
        this.r = yc.c;
        return this;
    }

    @Override // defpackage.hd
    public RequestBody g() {
        MediaType mediaType;
        MediaType mediaType2;
        MediaType mediaType3;
        if (this.w) {
            this.b = jd.c(this.c, this.j.e);
        }
        RequestBody requestBody = this.x;
        if (requestBody != null) {
            return requestBody;
        }
        String str = this.s;
        if (str == null || (mediaType3 = this.r) == null) {
            byte[] bArr = this.t;
            if (bArr == null || (mediaType2 = this.r) == null) {
                File file = this.u;
                return (file == null || (mediaType = this.r) == null) ? jd.d(this.j, this.v) : RequestBody.create(mediaType, file);
            }
            return RequestBody.create(mediaType2, bArr);
        }
        return RequestBody.create(mediaType3, str);
    }
}
