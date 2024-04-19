package defpackage;

import android.os.Build;
import android.view.accessibility.AccessibilityManager;
/* compiled from: AccessibilityManagerCompat.java */
/* renamed from: c5  reason: default package */
/* loaded from: classes.dex */
public final class c5 {

    /* compiled from: AccessibilityManagerCompat.java */
    /* renamed from: c5$a */
    /* loaded from: classes.dex */
    public interface a {
        void onTouchExplorationStateChanged(boolean z);
    }

    /* compiled from: AccessibilityManagerCompat.java */
    /* renamed from: c5$b */
    /* loaded from: classes.dex */
    private static class b implements AccessibilityManager.TouchExplorationStateChangeListener {
        final a a;

        b(a aVar) {
            this.a = aVar;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            return this.a.equals(((b) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
        public void onTouchExplorationStateChanged(boolean z) {
            this.a.onTouchExplorationStateChanged(z);
        }
    }

    public static boolean a(AccessibilityManager accessibilityManager, a aVar) {
        if (Build.VERSION.SDK_INT < 19 || aVar == null) {
            return false;
        }
        return accessibilityManager.addTouchExplorationStateChangeListener(new b(aVar));
    }

    public static boolean b(AccessibilityManager accessibilityManager, a aVar) {
        if (Build.VERSION.SDK_INT < 19 || aVar == null) {
            return false;
        }
        return accessibilityManager.removeTouchExplorationStateChangeListener(new b(aVar));
    }
}
