package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.animation.Interpolator;
import com.xiaopeng.xui.widgets.popup.XSuperPopup;
import org.xmlpull.v1.XmlPullParser;
/* compiled from: PathInterpolatorCompat.java */
/* renamed from: w0  reason: default package */
/* loaded from: classes.dex */
public class w0 implements Interpolator {
    private float[] a;
    private float[] b;

    public w0(Context context, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        this(context.getResources(), context.getTheme(), attributeSet, xmlPullParser);
    }

    private void a(float f, float f2, float f3, float f4) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f, f2, f3, f4, 1.0f, 1.0f);
        b(path);
    }

    private void b(Path path) {
        int i = 0;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int min = Math.min((int) XSuperPopup.DURATION_NORMAL, ((int) (length / 0.002f)) + 1);
        if (min > 0) {
            this.a = new float[min];
            this.b = new float[min];
            float[] fArr = new float[2];
            for (int i2 = 0; i2 < min; i2++) {
                pathMeasure.getPosTan((i2 * length) / (min - 1), fArr, null);
                this.a[i2] = fArr[0];
                this.b[i2] = fArr[1];
            }
            if (Math.abs(this.a[0]) <= 1.0E-5d && Math.abs(this.b[0]) <= 1.0E-5d) {
                int i3 = min - 1;
                if (Math.abs(this.a[i3] - 1.0f) <= 1.0E-5d && Math.abs(this.b[i3] - 1.0f) <= 1.0E-5d) {
                    float f = 0.0f;
                    int i4 = 0;
                    while (i < min) {
                        float[] fArr2 = this.a;
                        int i5 = i4 + 1;
                        float f2 = fArr2[i4];
                        if (f2 >= f) {
                            fArr2[i] = f2;
                            i++;
                            f = f2;
                            i4 = i5;
                        } else {
                            throw new IllegalArgumentException("The Path cannot loop back on itself, x :" + f2);
                        }
                    }
                    if (pathMeasure.nextContour()) {
                        throw new IllegalArgumentException("The Path should be continuous, can't have 2+ contours");
                    }
                    return;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("The Path must start at (0,0) and end at (1,1) start: ");
            sb.append(this.a[0]);
            sb.append(",");
            sb.append(this.b[0]);
            sb.append(" end:");
            int i6 = min - 1;
            sb.append(this.a[i6]);
            sb.append(",");
            sb.append(this.b[i6]);
            throw new IllegalArgumentException(sb.toString());
        }
        throw new IllegalArgumentException("The Path has a invalid length " + length);
    }

    private void c(float f, float f2) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(f, f2, 1.0f, 1.0f);
        b(path);
    }

    private void d(TypedArray typedArray, XmlPullParser xmlPullParser) {
        if (u2.h(xmlPullParser, "pathData")) {
            String g = u2.g(typedArray, xmlPullParser, "pathData", 4);
            Path e = w2.e(g);
            if (e != null) {
                b(e);
                return;
            }
            throw new InflateException("The path is null, which is created from " + g);
        } else if (u2.h(xmlPullParser, "controlX1")) {
            if (u2.h(xmlPullParser, "controlY1")) {
                float d = u2.d(typedArray, xmlPullParser, "controlX1", 0, 0.0f);
                float d2 = u2.d(typedArray, xmlPullParser, "controlY1", 1, 0.0f);
                boolean h = u2.h(xmlPullParser, "controlX2");
                if (h != u2.h(xmlPullParser, "controlY2")) {
                    throw new InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
                }
                if (!h) {
                    c(d, d2);
                    return;
                } else {
                    a(d, d2, u2.d(typedArray, xmlPullParser, "controlX2", 2, 0.0f), u2.d(typedArray, xmlPullParser, "controlY2", 3, 0.0f));
                    return;
                }
            }
            throw new InflateException("pathInterpolator requires the controlY1 attribute");
        } else {
            throw new InflateException("pathInterpolator requires the controlX1 attribute");
        }
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        if (f <= 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        int i = 0;
        int length = this.a.length - 1;
        while (length - i > 1) {
            int i2 = (i + length) / 2;
            if (f < this.a[i2]) {
                length = i2;
            } else {
                i = i2;
            }
        }
        float[] fArr = this.a;
        float f2 = fArr[length] - fArr[i];
        if (f2 == 0.0f) {
            return this.b[i];
        }
        float[] fArr2 = this.b;
        float f3 = fArr2[i];
        return f3 + (((f - fArr[i]) / f2) * (fArr2[length] - f3));
    }

    public w0(Resources resources, Resources.Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        TypedArray i = u2.i(resources, theme, attributeSet, r0.l);
        d(i, xmlPullParser);
        i.recycle();
    }
}
