package defpackage;

import org.json.JSONObject;
/* compiled from: AbstractSampling.java */
/* renamed from: e9  reason: default package */
/* loaded from: classes.dex */
public abstract class e9<T extends JSONObject> {
    protected int a;

    public e9(int i) {
        this.a = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(T t) {
        try {
            Integer valueOf = Integer.valueOf(t.getInt("sampling"));
            if (valueOf != null) {
                this.a = valueOf.intValue();
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean b(int i) {
        return i < this.a;
    }
}
