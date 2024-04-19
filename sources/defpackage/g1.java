package defpackage;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;
/* compiled from: PathProperty.java */
/* renamed from: g1  reason: default package */
/* loaded from: classes.dex */
class g1<T> extends Property<T, Float> {
    private final Property<T, PointF> a;
    private final PathMeasure b;
    private final float c;
    private final float[] d;
    private final PointF e;
    private float f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g1(Property<T, PointF> property, Path path) {
        super(Float.class, property.getName());
        this.d = new float[2];
        this.e = new PointF();
        this.a = property;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        this.b = pathMeasure;
        this.c = pathMeasure.getLength();
    }

    @Override // android.util.Property
    /* renamed from: a */
    public Float get(T t) {
        return Float.valueOf(this.f);
    }

    @Override // android.util.Property
    /* renamed from: b */
    public void set(T t, Float f) {
        this.f = f.floatValue();
        this.b.getPosTan(this.c * f.floatValue(), this.d, null);
        PointF pointF = this.e;
        float[] fArr = this.d;
        pointF.x = fArr[0];
        pointF.y = fArr[1];
        this.a.set(t, pointF);
    }
}
