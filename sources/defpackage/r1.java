package defpackage;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.io.IOUtils;
/* compiled from: TransitionValues.java */
/* renamed from: r1  reason: default package */
/* loaded from: classes.dex */
public class r1 {
    public View b;
    public final Map<String, Object> a = new HashMap();
    final ArrayList<l1> c = new ArrayList<>();

    public boolean equals(Object obj) {
        if (obj instanceof r1) {
            r1 r1Var = (r1) obj;
            return this.b == r1Var.b && this.a.equals(r1Var.a);
        }
        return false;
    }

    public int hashCode() {
        return (this.b.hashCode() * 31) + this.a.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.b + IOUtils.LINE_SEPARATOR_UNIX) + "    values:";
        for (String str2 : this.a.keySet()) {
            str = str + "    " + str2 + ": " + this.a.get(str2) + IOUtils.LINE_SEPARATOR_UNIX;
        }
        return str;
    }
}
