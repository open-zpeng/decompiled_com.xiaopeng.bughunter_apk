package defpackage;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
/* compiled from: TintableBackgroundView.java */
/* renamed from: u4  reason: default package */
/* loaded from: classes.dex */
public interface u4 {
    ColorStateList getSupportBackgroundTintList();

    PorterDuff.Mode getSupportBackgroundTintMode();

    void setSupportBackgroundTintList(ColorStateList colorStateList);

    void setSupportBackgroundTintMode(PorterDuff.Mode mode);
}
