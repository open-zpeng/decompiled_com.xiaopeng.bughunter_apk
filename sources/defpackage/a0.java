package defpackage;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;
/* compiled from: MatrixEvaluator.java */
/* renamed from: a0  reason: default package */
/* loaded from: classes.dex */
public class a0 implements TypeEvaluator<Matrix> {
    private final float[] a = new float[9];
    private final float[] b = new float[9];
    private final Matrix c = new Matrix();

    @Override // android.animation.TypeEvaluator
    /* renamed from: a */
    public Matrix evaluate(float f, Matrix matrix, Matrix matrix2) {
        matrix.getValues(this.a);
        matrix2.getValues(this.b);
        for (int i = 0; i < 9; i++) {
            float[] fArr = this.b;
            float f2 = fArr[i];
            float[] fArr2 = this.a;
            fArr[i] = fArr2[i] + ((f2 - fArr2[i]) * f);
        }
        this.c.setValues(this.b);
        return this.c;
    }
}
