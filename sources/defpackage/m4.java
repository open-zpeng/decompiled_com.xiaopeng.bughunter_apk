package defpackage;

import android.view.MotionEvent;
/* compiled from: MotionEventCompat.java */
/* renamed from: m4  reason: default package */
/* loaded from: classes.dex */
public final class m4 {
    public static boolean a(MotionEvent motionEvent, int i) {
        return (motionEvent.getSource() & i) == i;
    }
}
