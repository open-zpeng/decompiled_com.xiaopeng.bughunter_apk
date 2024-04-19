package defpackage;

import com.xiaopeng.xui.widgets.popup.XSuperPopup;
/* compiled from: DisconnectedBufferOptions.java */
/* renamed from: xj  reason: default package */
/* loaded from: classes.dex */
public class xj {
    private int a = XSuperPopup.DURATION_LONG;
    private boolean b = false;
    private boolean c = false;
    private boolean d = false;

    public int a() {
        return this.a;
    }

    public boolean b() {
        return this.b;
    }

    public boolean c() {
        return this.d;
    }

    public boolean d() {
        return this.c;
    }

    public void e(boolean z) {
        this.b = z;
    }

    public void f(int i) {
        if (i >= 1) {
            this.a = i;
            return;
        }
        throw new IllegalArgumentException();
    }

    public void g(boolean z) {
        this.d = z;
    }

    public void h(boolean z) {
        this.c = z;
    }
}
