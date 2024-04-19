package defpackage;

import android.text.TextUtils;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
/* compiled from: UtHostnameVerifier.java */
/* renamed from: mb  reason: default package */
/* loaded from: classes.dex */
class mb implements HostnameVerifier {
    public String a;

    public mb(String str) {
        this.a = str;
    }

    public String a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (TextUtils.isEmpty(this.a) || !(obj instanceof mb)) {
            return false;
        }
        String str = ((mb) obj).a;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.a.equals(str);
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        return HttpsURLConnection.getDefaultHostnameVerifier().verify(this.a, sSLSession);
    }
}
