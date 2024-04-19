package defpackage;

import android.text.TextUtils;
import java.util.Set;
/* compiled from: AccurateSampleCondition.java */
/* renamed from: f9  reason: default package */
/* loaded from: classes.dex */
public class f9 {
    private Set<String> a;
    private a b;

    /* compiled from: AccurateSampleCondition.java */
    /* renamed from: f9$a */
    /* loaded from: classes.dex */
    private enum a {
        IN,
        NOT_IN
    }

    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        boolean contains = this.a.contains(str);
        return this.b == a.IN ? contains : !contains;
    }
}
