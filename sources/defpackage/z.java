package defpackage;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;
/* compiled from: ImageMatrixProperty.java */
/* renamed from: z  reason: default package */
/* loaded from: classes.dex */
public class z extends Property<ImageView, Matrix> {
    private final Matrix a;

    public z() {
        super(Matrix.class, "imageMatrixProperty");
        this.a = new Matrix();
    }

    @Override // android.util.Property
    /* renamed from: a */
    public Matrix get(ImageView imageView) {
        this.a.set(imageView.getImageMatrix());
        return this.a;
    }

    @Override // android.util.Property
    /* renamed from: b */
    public void set(ImageView imageView, Matrix matrix) {
        imageView.setImageMatrix(matrix);
    }
}
