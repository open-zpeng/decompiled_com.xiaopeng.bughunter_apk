package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ViewGroupOverlayApi14.java */
/* renamed from: t1  reason: default package */
/* loaded from: classes.dex */
public class t1 extends z1 implements v1 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public t1(Context context, ViewGroup viewGroup, View view) {
        super(context, viewGroup, view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static t1 g(ViewGroup viewGroup) {
        return (t1) z1.e(viewGroup);
    }

    @Override // defpackage.v1
    public void a(View view) {
        this.a.b(view);
    }

    @Override // defpackage.v1
    public void c(View view) {
        this.a.f(view);
    }
}
