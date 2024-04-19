package defpackage;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Property;
import java.util.WeakHashMap;
/* compiled from: DrawableAlphaProperty.java */
/* renamed from: y  reason: default package */
/* loaded from: classes.dex */
public class y extends Property<Drawable, Integer> {
    public static final Property<Drawable, Integer> a = new y();
    private final WeakHashMap<Drawable, Integer> b;

    private y() {
        super(Integer.class, "drawableAlphaCompat");
        this.b = new WeakHashMap<>();
    }

    @Override // android.util.Property
    /* renamed from: a */
    public Integer get(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 19) {
            return Integer.valueOf(drawable.getAlpha());
        }
        if (this.b.containsKey(drawable)) {
            return this.b.get(drawable);
        }
        return 255;
    }

    @Override // android.util.Property
    /* renamed from: b */
    public void set(Drawable drawable, Integer num) {
        if (Build.VERSION.SDK_INT < 19) {
            this.b.put(drawable, num);
        }
        drawable.setAlpha(num.intValue());
    }
}
