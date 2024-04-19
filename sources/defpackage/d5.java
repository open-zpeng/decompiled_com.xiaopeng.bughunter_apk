package defpackage;

import android.graphics.Rect;
import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IInputController;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IRadioController;
/* compiled from: AccessibilityNodeInfoCompat.java */
/* renamed from: d5  reason: default package */
/* loaded from: classes.dex */
public class d5 {
    private final AccessibilityNodeInfo a;
    public int b = -1;

    /* compiled from: AccessibilityNodeInfoCompat.java */
    /* renamed from: d5$a */
    /* loaded from: classes.dex */
    public static class a {
        final Object a;

        a(Object obj) {
            this.a = obj;
        }

        public static a a(int i, int i2, boolean z, int i3) {
            int i4 = Build.VERSION.SDK_INT;
            if (i4 >= 21) {
                return new a(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z, i3));
            }
            if (i4 >= 19) {
                return new a(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z));
            }
            return new a(null);
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat.java */
    /* renamed from: d5$b */
    /* loaded from: classes.dex */
    public static class b {
        final Object a;

        b(Object obj) {
            this.a = obj;
        }

        public static b a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            int i5 = Build.VERSION.SDK_INT;
            if (i5 >= 21) {
                return new b(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z, z2));
            }
            if (i5 >= 19) {
                return new b(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z));
            }
            return new b(null);
        }
    }

    private d5(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.a = accessibilityNodeInfo;
    }

    public static d5 B(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new d5(accessibilityNodeInfo);
    }

    private static String b(int i) {
        if (i != 1) {
            if (i != 2) {
                switch (i) {
                    case 4:
                        return "ACTION_SELECT";
                    case 8:
                        return "ACTION_CLEAR_SELECTION";
                    case 16:
                        return "ACTION_CLICK";
                    case 32:
                        return "ACTION_LONG_CLICK";
                    case 64:
                        return "ACTION_ACCESSIBILITY_FOCUS";
                    case 128:
                        return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
                    case IRadioController.TEF663x_PCHANNEL /* 256 */:
                        return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
                    case IInputController.KEYCODE_BACK_BUTTON /* 512 */:
                        return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
                    case 1024:
                        return "ACTION_NEXT_HTML_ELEMENT";
                    case 2048:
                        return "ACTION_PREVIOUS_HTML_ELEMENT";
                    case 4096:
                        return "ACTION_SCROLL_FORWARD";
                    case 8192:
                        return "ACTION_SCROLL_BACKWARD";
                    case 16384:
                        return "ACTION_COPY";
                    case 32768:
                        return "ACTION_PASTE";
                    case 65536:
                        return "ACTION_CUT";
                    case OSSConstants.DEFAULT_STREAM_BUFFER_SIZE /* 131072 */:
                        return "ACTION_SET_SELECTION";
                    default:
                        return "ACTION_UNKNOWN";
                }
            }
            return "ACTION_CLEAR_FOCUS";
        }
        return "ACTION_FOCUS";
    }

    public AccessibilityNodeInfo A() {
        return this.a;
    }

    public void a(int i) {
        this.a.addAction(i);
    }

    public int c() {
        return this.a.getActions();
    }

    public void d(Rect rect) {
        this.a.getBoundsInParent(rect);
    }

    public void e(Rect rect) {
        this.a.getBoundsInScreen(rect);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && d5.class == obj.getClass()) {
            d5 d5Var = (d5) obj;
            AccessibilityNodeInfo accessibilityNodeInfo = this.a;
            if (accessibilityNodeInfo == null) {
                if (d5Var.a != null) {
                    return false;
                }
            } else if (!accessibilityNodeInfo.equals(d5Var.a)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public CharSequence f() {
        return this.a.getClassName();
    }

    public CharSequence g() {
        return this.a.getContentDescription();
    }

    public CharSequence h() {
        return this.a.getPackageName();
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.a;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public CharSequence i() {
        return this.a.getText();
    }

    public String j() {
        if (Build.VERSION.SDK_INT >= 18) {
            return this.a.getViewIdResourceName();
        }
        return null;
    }

    public boolean k() {
        return this.a.isCheckable();
    }

    public boolean l() {
        return this.a.isChecked();
    }

    public boolean m() {
        return this.a.isClickable();
    }

    public boolean n() {
        return this.a.isEnabled();
    }

    public boolean o() {
        return this.a.isFocusable();
    }

    public boolean p() {
        return this.a.isFocused();
    }

    public boolean q() {
        return this.a.isLongClickable();
    }

    public boolean r() {
        return this.a.isPassword();
    }

    public boolean s() {
        return this.a.isScrollable();
    }

    public boolean t() {
        return this.a.isSelected();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        d(rect);
        sb.append("; boundsInParent: " + rect);
        e(rect);
        sb.append("; boundsInScreen: " + rect);
        sb.append("; packageName: ");
        sb.append(h());
        sb.append("; className: ");
        sb.append(f());
        sb.append("; text: ");
        sb.append(i());
        sb.append("; contentDescription: ");
        sb.append(g());
        sb.append("; viewId: ");
        sb.append(j());
        sb.append("; checkable: ");
        sb.append(k());
        sb.append("; checked: ");
        sb.append(l());
        sb.append("; focusable: ");
        sb.append(o());
        sb.append("; focused: ");
        sb.append(p());
        sb.append("; selected: ");
        sb.append(t());
        sb.append("; clickable: ");
        sb.append(m());
        sb.append("; longClickable: ");
        sb.append(q());
        sb.append("; enabled: ");
        sb.append(n());
        sb.append("; password: ");
        sb.append(r());
        sb.append("; scrollable: " + s());
        sb.append("; [");
        int c = c();
        while (c != 0) {
            int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(c);
            c &= ~numberOfTrailingZeros;
            sb.append(b(numberOfTrailingZeros));
            if (c != 0) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public void u(boolean z) {
        this.a.setCheckable(z);
    }

    public void v(boolean z) {
        this.a.setChecked(z);
    }

    public void w(CharSequence charSequence) {
        this.a.setClassName(charSequence);
    }

    public void x(Object obj) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.a.setCollectionInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionInfo) ((a) obj).a);
        }
    }

    public void y(Object obj) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.a.setCollectionItemInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionItemInfo) ((b) obj).a);
        }
    }

    public void z(boolean z) {
        this.a.setScrollable(z);
    }
}
