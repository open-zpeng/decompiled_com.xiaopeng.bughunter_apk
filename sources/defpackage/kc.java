package defpackage;

import okhttp3.Response;
/* compiled from: StringCallback.java */
/* renamed from: kc  reason: default package */
/* loaded from: classes.dex */
public abstract class kc extends ic<String> {
    private mc convert = new mc();

    @Override // defpackage.lc
    public String convertResponse(Response response) throws Throwable {
        String convertResponse = this.convert.convertResponse(response);
        response.close();
        return convertResponse;
    }
}
