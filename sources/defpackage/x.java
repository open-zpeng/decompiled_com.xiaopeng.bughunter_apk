package defpackage;

import android.util.Property;
import android.view.ViewGroup;
/* compiled from: ChildrenAlphaProperty.java */
/* renamed from: x  reason: default package */
/* loaded from: classes.dex */
public class x extends Property<ViewGroup, Float> {
    public static final Property<ViewGroup, Float> a = new x("childrenAlpha");

    private x(String str) {
        super(Float.class, str);
    }

    @Override // android.util.Property
    /* renamed from: a */
    public Float get(ViewGroup viewGroup) {
        Float f = (Float) viewGroup.getTag(p.mtrl_internal_children_alpha_tag);
        return f != null ? f : Float.valueOf(1.0f);
    }

    @Override // android.util.Property
    /* renamed from: b */
    public void set(ViewGroup viewGroup, Float f) {
        float floatValue = f.floatValue();
        viewGroup.setTag(p.mtrl_internal_children_alpha_tag, Float.valueOf(floatValue));
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            viewGroup.getChildAt(i).setAlpha(floatValue);
        }
    }
}
