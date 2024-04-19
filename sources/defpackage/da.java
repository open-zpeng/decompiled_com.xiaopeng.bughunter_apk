package defpackage;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* compiled from: UTDimensionValueSet.java */
/* renamed from: da  reason: default package */
/* loaded from: classes.dex */
public class da extends v9 {
    private static final Set<pb> c = new a();

    /* compiled from: UTDimensionValueSet.java */
    /* renamed from: da$a */
    /* loaded from: classes.dex */
    static class a extends HashSet<pb> {
        a() {
            add(pb.PAGE);
            add(pb.ARG1);
            add(pb.ARG2);
            add(pb.ARG3);
            add(pb.ARGS);
        }
    }

    @Override // defpackage.v9, defpackage.z8
    public void a() {
        super.a();
    }

    @Override // defpackage.v9, defpackage.z8
    public void b(Object... objArr) {
        super.b(objArr);
    }

    public Integer k() {
        int i;
        String str;
        Map<String, String> map = this.b;
        if (map != null && (str = map.get(pb.EVENTID.toString())) != null) {
            try {
                i = p9.a(str);
            } catch (NumberFormatException unused) {
            }
            return Integer.valueOf(i);
        }
        i = 0;
        return Integer.valueOf(i);
    }
}
