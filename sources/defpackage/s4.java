package defpackage;

import android.view.View;
import android.view.ViewGroup;
/* compiled from: NestedScrollingParentHelper.java */
/* renamed from: s4  reason: default package */
/* loaded from: classes.dex */
public class s4 {
    private final ViewGroup a;
    private int b;

    public s4(ViewGroup viewGroup) {
        this.a = viewGroup;
    }

    public int a() {
        return this.b;
    }

    public void b(View view, View view2, int i) {
        c(view, view2, i, 0);
    }

    public void c(View view, View view2, int i, int i2) {
        this.b = i;
    }

    public void d(View view, int i) {
        this.b = 0;
    }
}
