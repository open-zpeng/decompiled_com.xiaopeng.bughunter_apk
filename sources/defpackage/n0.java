package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
/* compiled from: MaterialResources.java */
/* renamed from: n0  reason: default package */
/* loaded from: classes.dex */
public class n0 {
    public static ColorStateList a(Context context, TypedArray typedArray, int i) {
        int resourceId;
        ColorStateList c;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (c = u5.c(context, resourceId)) == null) ? typedArray.getColorStateList(i) : c;
    }

    public static Drawable b(Context context, TypedArray typedArray, int i) {
        int resourceId;
        Drawable d;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (d = u5.d(context, resourceId)) == null) ? typedArray.getDrawable(i) : d;
    }
}
