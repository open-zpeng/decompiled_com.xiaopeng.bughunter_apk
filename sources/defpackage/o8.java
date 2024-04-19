package defpackage;

import org.json.JSONObject;
/* compiled from: CountEvent.java */
/* renamed from: o8  reason: default package */
/* loaded from: classes.dex */
public class o8 extends q8 {
    public int f;
    public double g;

    @Override // defpackage.q8, defpackage.z8
    public synchronized void b(Object... objArr) {
        super.b(objArr);
        this.g = 0.0d;
        this.f = 0;
    }

    @Override // defpackage.q8
    public synchronized JSONObject c() {
        JSONObject c;
        c = super.c();
        try {
            c.put("count", this.f);
            c.put("value", this.g);
        } catch (Exception unused) {
        }
        return c;
    }

    public synchronized void d(double d) {
        this.g += d;
        this.f++;
    }
}
