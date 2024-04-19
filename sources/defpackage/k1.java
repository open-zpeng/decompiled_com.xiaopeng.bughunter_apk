package defpackage;

import android.view.View;
import android.view.ViewGroup;
/* compiled from: Scene.java */
/* renamed from: k1  reason: default package */
/* loaded from: classes.dex */
public class k1 {
    private ViewGroup a;
    private Runnable b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static k1 b(View view) {
        return (k1) view.getTag(i1.transition_current_scene);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(View view, k1 k1Var) {
        view.setTag(i1.transition_current_scene, k1Var);
    }

    public void a() {
        Runnable runnable;
        if (b(this.a) != this || (runnable = this.b) == null) {
            return;
        }
        runnable.run();
    }
}
