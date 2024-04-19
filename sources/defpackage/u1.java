package defpackage;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
/* compiled from: ViewGroupOverlayApi18.java */
/* renamed from: u1  reason: default package */
/* loaded from: classes.dex */
class u1 implements v1 {
    private final ViewGroupOverlay a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u1(ViewGroup viewGroup) {
        this.a = viewGroup.getOverlay();
    }

    @Override // defpackage.v1
    public void a(View view) {
        this.a.add(view);
    }

    @Override // defpackage.b2
    public void b(Drawable drawable) {
        this.a.add(drawable);
    }

    @Override // defpackage.v1
    public void c(View view) {
        this.a.remove(view);
    }

    @Override // defpackage.b2
    public void d(Drawable drawable) {
        this.a.remove(drawable);
    }
}
