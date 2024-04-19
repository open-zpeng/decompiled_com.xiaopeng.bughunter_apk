package defpackage;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
/* compiled from: AccessibilityDelegateCompat.java */
/* renamed from: f4  reason: default package */
/* loaded from: classes.dex */
public class f4 {
    private static final View.AccessibilityDelegate a = new View.AccessibilityDelegate();
    private final View.AccessibilityDelegate b = new a(this);

    /* compiled from: AccessibilityDelegateCompat.java */
    /* renamed from: f4$a */
    /* loaded from: classes.dex */
    private static final class a extends View.AccessibilityDelegate {
        private final f4 a;

        a(f4 f4Var) {
            this.a = f4Var;
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.a.a(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            e5 b = this.a.b(view);
            if (b != null) {
                return (AccessibilityNodeProvider) b.a();
            }
            return null;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.a.d(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            this.a.e(view, d5.B(accessibilityNodeInfo));
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.a.f(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.a.g(viewGroup, view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            return this.a.h(view, i, bundle);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEvent(View view, int i) {
            this.a.i(view, i);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.a.j(view, accessibilityEvent);
        }
    }

    public boolean a(View view, AccessibilityEvent accessibilityEvent) {
        return a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public e5 b(View view) {
        AccessibilityNodeProvider accessibilityNodeProvider;
        if (Build.VERSION.SDK_INT < 16 || (accessibilityNodeProvider = a.getAccessibilityNodeProvider(view)) == null) {
            return null;
        }
        return new e5(accessibilityNodeProvider);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View.AccessibilityDelegate c() {
        return this.b;
    }

    public void d(View view, AccessibilityEvent accessibilityEvent) {
        a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void e(View view, d5 d5Var) {
        a.onInitializeAccessibilityNodeInfo(view, d5Var.A());
    }

    public void f(View view, AccessibilityEvent accessibilityEvent) {
        a.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean g(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public boolean h(View view, int i, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            return a.performAccessibilityAction(view, i, bundle);
        }
        return false;
    }

    public void i(View view, int i) {
        a.sendAccessibilityEvent(view, i);
    }

    public void j(View view, AccessibilityEvent accessibilityEvent) {
        a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }
}
