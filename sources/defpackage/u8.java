package defpackage;

import java.util.HashMap;
import java.util.Map;
/* compiled from: UTEvent.java */
/* renamed from: u8  reason: default package */
/* loaded from: classes.dex */
public class u8 implements z8 {
    public String b;
    public int c;
    public String d;
    public String e;
    public String f;
    public Map<String, String> g;

    @Override // defpackage.z8
    public void a() {
        this.b = null;
        this.c = 0;
        this.d = null;
        this.e = null;
        this.f = null;
        Map<String, String> map = this.g;
        if (map != null) {
            map.clear();
        }
    }

    @Override // defpackage.z8
    public void b(Object... objArr) {
        if (this.g == null) {
            this.g = new HashMap();
        }
    }
}
