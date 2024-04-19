package defpackage;

import java.util.ArrayList;
import java.util.List;
/* compiled from: MetricRepo.java */
/* renamed from: ba  reason: default package */
/* loaded from: classes.dex */
public class ba {
    private static ba a;
    public List<aa> b;

    private ba(int i) {
        this.b = new ArrayList(i);
    }

    public static ba c() {
        if (a == null) {
            a = new ba(3);
        }
        return a;
    }

    public void a(aa aaVar) {
        if (this.b.contains(aaVar)) {
            return;
        }
        this.b.add(aaVar);
    }

    public aa b(String str, String str2) {
        List<aa> list;
        if (str != null && str2 != null && (list = this.b) != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                aa aaVar = this.b.get(i);
                if (aaVar != null && aaVar.f().equals(str) && aaVar.g().equals(str2)) {
                    return aaVar;
                }
            }
        }
        return null;
    }

    public boolean d(aa aaVar) {
        if (this.b.contains(aaVar)) {
            return this.b.remove(aaVar);
        }
        return true;
    }
}
