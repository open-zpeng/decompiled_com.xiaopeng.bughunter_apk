package defpackage;

import org.json.JSONArray;
/* compiled from: ReuseJSONArray.java */
/* renamed from: b9  reason: default package */
/* loaded from: classes.dex */
public class b9 extends JSONArray implements z8 {
    @Override // defpackage.z8
    public void a() {
        for (int i = 0; i < length(); i++) {
            Object opt = opt(i);
            if (opt != null && (opt instanceof z8)) {
                y8.a().d((z8) opt);
            }
        }
    }

    @Override // defpackage.z8
    public void b(Object... objArr) {
    }
}
