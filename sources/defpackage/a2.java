package defpackage;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;
/* compiled from: ViewOverlayApi18.java */
/* renamed from: a2  reason: default package */
/* loaded from: classes.dex */
class a2 implements b2 {
    private final ViewOverlay a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a2(View view) {
        this.a = view.getOverlay();
    }

    @Override // defpackage.b2
    public void b(Drawable drawable) {
        this.a.add(drawable);
    }

    @Override // defpackage.b2
    public void d(Drawable drawable) {
        this.a.remove(drawable);
    }
}
