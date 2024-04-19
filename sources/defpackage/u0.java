package defpackage;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import defpackage.w2;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: AnimatorInflaterCompat.java */
/* renamed from: u0  reason: default package */
/* loaded from: classes.dex */
public class u0 {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AnimatorInflaterCompat.java */
    /* renamed from: u0$a */
    /* loaded from: classes.dex */
    public static class a implements TypeEvaluator<w2.b[]> {
        private w2.b[] a;

        a() {
        }

        @Override // android.animation.TypeEvaluator
        /* renamed from: a */
        public w2.b[] evaluate(float f, w2.b[] bVarArr, w2.b[] bVarArr2) {
            if (w2.b(bVarArr, bVarArr2)) {
                w2.b[] bVarArr3 = this.a;
                if (bVarArr3 == null || !w2.b(bVarArr3, bVarArr)) {
                    this.a = w2.f(bVarArr);
                }
                for (int i = 0; i < bVarArr.length; i++) {
                    this.a[i].d(bVarArr[i], bVarArr2[i], f);
                }
                return this.a;
            }
            throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
        }
    }

    private static Animator a(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, float f) throws XmlPullParserException, IOException {
        return b(context, resources, theme, xmlPullParser, Xml.asAttributeSet(xmlPullParser), null, 0, f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.animation.Animator b(android.content.Context r18, android.content.res.Resources r19, android.content.res.Resources.Theme r20, org.xmlpull.v1.XmlPullParser r21, android.util.AttributeSet r22, android.animation.AnimatorSet r23, int r24, float r25) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 265
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.u0.b(android.content.Context, android.content.res.Resources, android.content.res.Resources$Theme, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.animation.AnimatorSet, int, float):android.animation.Animator");
    }

    private static Keyframe c(Keyframe keyframe, float f) {
        if (keyframe.getType() == Float.TYPE) {
            return Keyframe.ofFloat(f);
        }
        if (keyframe.getType() == Integer.TYPE) {
            return Keyframe.ofInt(f);
        }
        return Keyframe.ofObject(f);
    }

    private static void d(Keyframe[] keyframeArr, float f, int i, int i2) {
        float f2 = f / ((i2 - i) + 2);
        while (i <= i2) {
            keyframeArr[i].setFraction(keyframeArr[i - 1].getFraction() + f2);
            i++;
        }
    }

    private static PropertyValuesHolder e(TypedArray typedArray, int i, int i2, int i3, String str) {
        int i4;
        int i5;
        int i6;
        float f;
        PropertyValuesHolder ofFloat;
        float f2;
        float f3;
        PropertyValuesHolder ofObject;
        TypedValue peekValue = typedArray.peekValue(i2);
        boolean z = peekValue != null;
        int i7 = z ? peekValue.type : 0;
        TypedValue peekValue2 = typedArray.peekValue(i3);
        boolean z2 = peekValue2 != null;
        int i8 = z2 ? peekValue2.type : 0;
        if (i == 4) {
            i = ((z && h(i7)) || (z2 && h(i8))) ? 3 : 0;
        }
        boolean z3 = i == 0;
        PropertyValuesHolder propertyValuesHolder = null;
        if (i == 2) {
            String string = typedArray.getString(i2);
            String string2 = typedArray.getString(i3);
            w2.b[] d = w2.d(string);
            w2.b[] d2 = w2.d(string2);
            if (d == null && d2 == null) {
                return null;
            }
            if (d == null) {
                if (d2 != null) {
                    return PropertyValuesHolder.ofObject(str, new a(), d2);
                }
                return null;
            }
            a aVar = new a();
            if (d2 != null) {
                if (w2.b(d, d2)) {
                    ofObject = PropertyValuesHolder.ofObject(str, aVar, d, d2);
                } else {
                    throw new InflateException(" Can't morph from " + string + " to " + string2);
                }
            } else {
                ofObject = PropertyValuesHolder.ofObject(str, aVar, d);
            }
            return ofObject;
        }
        v0 a2 = i == 3 ? v0.a() : null;
        if (z3) {
            if (z) {
                if (i7 == 5) {
                    f2 = typedArray.getDimension(i2, 0.0f);
                } else {
                    f2 = typedArray.getFloat(i2, 0.0f);
                }
                if (z2) {
                    if (i8 == 5) {
                        f3 = typedArray.getDimension(i3, 0.0f);
                    } else {
                        f3 = typedArray.getFloat(i3, 0.0f);
                    }
                    ofFloat = PropertyValuesHolder.ofFloat(str, f2, f3);
                } else {
                    ofFloat = PropertyValuesHolder.ofFloat(str, f2);
                }
            } else {
                if (i8 == 5) {
                    f = typedArray.getDimension(i3, 0.0f);
                } else {
                    f = typedArray.getFloat(i3, 0.0f);
                }
                ofFloat = PropertyValuesHolder.ofFloat(str, f);
            }
            propertyValuesHolder = ofFloat;
        } else if (z) {
            if (i7 == 5) {
                i5 = (int) typedArray.getDimension(i2, 0.0f);
            } else if (h(i7)) {
                i5 = typedArray.getColor(i2, 0);
            } else {
                i5 = typedArray.getInt(i2, 0);
            }
            if (z2) {
                if (i8 == 5) {
                    i6 = (int) typedArray.getDimension(i3, 0.0f);
                } else if (h(i8)) {
                    i6 = typedArray.getColor(i3, 0);
                } else {
                    i6 = typedArray.getInt(i3, 0);
                }
                propertyValuesHolder = PropertyValuesHolder.ofInt(str, i5, i6);
            } else {
                propertyValuesHolder = PropertyValuesHolder.ofInt(str, i5);
            }
        } else if (z2) {
            if (i8 == 5) {
                i4 = (int) typedArray.getDimension(i3, 0.0f);
            } else if (h(i8)) {
                i4 = typedArray.getColor(i3, 0);
            } else {
                i4 = typedArray.getInt(i3, 0);
            }
            propertyValuesHolder = PropertyValuesHolder.ofInt(str, i4);
        }
        if (propertyValuesHolder == null || a2 == null) {
            return propertyValuesHolder;
        }
        propertyValuesHolder.setEvaluator(a2);
        return propertyValuesHolder;
    }

    private static int f(TypedArray typedArray, int i, int i2) {
        TypedValue peekValue = typedArray.peekValue(i);
        boolean z = peekValue != null;
        int i3 = z ? peekValue.type : 0;
        TypedValue peekValue2 = typedArray.peekValue(i2);
        boolean z2 = peekValue2 != null;
        return ((z && h(i3)) || (z2 && h(z2 ? peekValue2.type : 0))) ? 3 : 0;
    }

    private static int g(Resources resources, Resources.Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        TypedArray i = u2.i(resources, theme, attributeSet, r0.j);
        int i2 = 0;
        TypedValue j = u2.j(i, xmlPullParser, "value", 0);
        if ((j != null) && h(j.type)) {
            i2 = 3;
        }
        i.recycle();
        return i2;
    }

    private static boolean h(int i) {
        return i >= 28 && i <= 31;
    }

    public static Animator i(Context context, int i) throws Resources.NotFoundException {
        if (Build.VERSION.SDK_INT >= 24) {
            return AnimatorInflater.loadAnimator(context, i);
        }
        return j(context, context.getResources(), context.getTheme(), i);
    }

    public static Animator j(Context context, Resources resources, Resources.Theme theme, int i) throws Resources.NotFoundException {
        return k(context, resources, theme, i, 1.0f);
    }

    public static Animator k(Context context, Resources resources, Resources.Theme theme, int i, float f) throws Resources.NotFoundException {
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                try {
                    xmlResourceParser = resources.getAnimation(i);
                    return a(context, resources, theme, xmlResourceParser, f);
                } catch (XmlPullParserException e) {
                    Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
                    notFoundException.initCause(e);
                    throw notFoundException;
                }
            } catch (IOException e2) {
                Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
                notFoundException2.initCause(e2);
                throw notFoundException2;
            }
        } finally {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        }
    }

    private static ValueAnimator l(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, ValueAnimator valueAnimator, float f, XmlPullParser xmlPullParser) throws Resources.NotFoundException {
        TypedArray i = u2.i(resources, theme, attributeSet, r0.g);
        TypedArray i2 = u2.i(resources, theme, attributeSet, r0.k);
        if (valueAnimator == null) {
            valueAnimator = new ValueAnimator();
        }
        q(valueAnimator, i, i2, f, xmlPullParser);
        int f2 = u2.f(i, xmlPullParser, "interpolator", 0, 0);
        if (f2 > 0) {
            valueAnimator.setInterpolator(t0.b(context, f2));
        }
        i.recycle();
        if (i2 != null) {
            i2.recycle();
        }
        return valueAnimator;
    }

    private static Keyframe m(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, int i, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        Keyframe ofInt;
        TypedArray i2 = u2.i(resources, theme, attributeSet, r0.j);
        float d = u2.d(i2, xmlPullParser, "fraction", 3, -1.0f);
        TypedValue j = u2.j(i2, xmlPullParser, "value", 0);
        boolean z = j != null;
        if (i == 4) {
            i = (z && h(j.type)) ? 3 : 0;
        }
        if (z) {
            if (i != 0) {
                ofInt = (i == 1 || i == 3) ? Keyframe.ofInt(d, u2.e(i2, xmlPullParser, "value", 0, 0)) : null;
            } else {
                ofInt = Keyframe.ofFloat(d, u2.d(i2, xmlPullParser, "value", 0, 0.0f));
            }
        } else if (i == 0) {
            ofInt = Keyframe.ofFloat(d);
        } else {
            ofInt = Keyframe.ofInt(d);
        }
        int f = u2.f(i2, xmlPullParser, "interpolator", 1, 0);
        if (f > 0) {
            ofInt.setInterpolator(t0.b(context, f));
        }
        i2.recycle();
        return ofInt;
    }

    private static ObjectAnimator n(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, float f, XmlPullParser xmlPullParser) throws Resources.NotFoundException {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        l(context, resources, theme, attributeSet, objectAnimator, f, xmlPullParser);
        return objectAnimator;
    }

    private static PropertyValuesHolder o(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, String str, int i) throws XmlPullParserException, IOException {
        int size;
        PropertyValuesHolder propertyValuesHolder = null;
        ArrayList arrayList = null;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 3 || next == 1) {
                break;
            } else if (xmlPullParser.getName().equals("keyframe")) {
                if (i == 4) {
                    i = g(resources, theme, Xml.asAttributeSet(xmlPullParser), xmlPullParser);
                }
                Keyframe m = m(context, resources, theme, Xml.asAttributeSet(xmlPullParser), i, xmlPullParser);
                if (m != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(m);
                }
                xmlPullParser.next();
            }
        }
        if (arrayList != null && (size = arrayList.size()) > 0) {
            Keyframe keyframe = (Keyframe) arrayList.get(0);
            Keyframe keyframe2 = (Keyframe) arrayList.get(size - 1);
            float fraction = keyframe2.getFraction();
            if (fraction < 1.0f) {
                if (fraction < 0.0f) {
                    keyframe2.setFraction(1.0f);
                } else {
                    arrayList.add(arrayList.size(), c(keyframe2, 1.0f));
                    size++;
                }
            }
            float fraction2 = keyframe.getFraction();
            if (fraction2 != 0.0f) {
                if (fraction2 < 0.0f) {
                    keyframe.setFraction(0.0f);
                } else {
                    arrayList.add(0, c(keyframe, 0.0f));
                    size++;
                }
            }
            Keyframe[] keyframeArr = new Keyframe[size];
            arrayList.toArray(keyframeArr);
            for (int i2 = 0; i2 < size; i2++) {
                Keyframe keyframe3 = keyframeArr[i2];
                if (keyframe3.getFraction() < 0.0f) {
                    if (i2 == 0) {
                        keyframe3.setFraction(0.0f);
                    } else {
                        int i3 = size - 1;
                        if (i2 == i3) {
                            keyframe3.setFraction(1.0f);
                        } else {
                            int i4 = i2;
                            for (int i5 = i2 + 1; i5 < i3 && keyframeArr[i5].getFraction() < 0.0f; i5++) {
                                i4 = i5;
                            }
                            d(keyframeArr, keyframeArr[i4 + 1].getFraction() - keyframeArr[i2 - 1].getFraction(), i2, i4);
                        }
                    }
                }
            }
            propertyValuesHolder = PropertyValuesHolder.ofKeyframe(str, keyframeArr);
            if (i == 3) {
                propertyValuesHolder.setEvaluator(v0.a());
            }
        }
        return propertyValuesHolder;
    }

    private static PropertyValuesHolder[] p(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        int i;
        PropertyValuesHolder[] propertyValuesHolderArr = null;
        ArrayList arrayList = null;
        while (true) {
            int eventType = xmlPullParser.getEventType();
            if (eventType == 3 || eventType == 1) {
                break;
            } else if (eventType != 2) {
                xmlPullParser.next();
            } else {
                if (xmlPullParser.getName().equals("propertyValuesHolder")) {
                    TypedArray i2 = u2.i(resources, theme, attributeSet, r0.i);
                    String g = u2.g(i2, xmlPullParser, "propertyName", 3);
                    int e = u2.e(i2, xmlPullParser, "valueType", 2, 4);
                    PropertyValuesHolder o = o(context, resources, theme, xmlPullParser, g, e);
                    if (o == null) {
                        o = e(i2, e, 0, 1, g);
                    }
                    if (o != null) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(o);
                    }
                    i2.recycle();
                }
                xmlPullParser.next();
            }
        }
        if (arrayList != null) {
            int size = arrayList.size();
            propertyValuesHolderArr = new PropertyValuesHolder[size];
            for (i = 0; i < size; i++) {
                propertyValuesHolderArr[i] = (PropertyValuesHolder) arrayList.get(i);
            }
        }
        return propertyValuesHolderArr;
    }

    private static void q(ValueAnimator valueAnimator, TypedArray typedArray, TypedArray typedArray2, float f, XmlPullParser xmlPullParser) {
        long e = u2.e(typedArray, xmlPullParser, "duration", 1, 300);
        long e2 = u2.e(typedArray, xmlPullParser, "startOffset", 2, 0);
        int e3 = u2.e(typedArray, xmlPullParser, "valueType", 7, 4);
        if (u2.h(xmlPullParser, "valueFrom") && u2.h(xmlPullParser, "valueTo")) {
            if (e3 == 4) {
                e3 = f(typedArray, 5, 6);
            }
            PropertyValuesHolder e4 = e(typedArray, e3, 5, 6, "");
            if (e4 != null) {
                valueAnimator.setValues(e4);
            }
        }
        valueAnimator.setDuration(e);
        valueAnimator.setStartDelay(e2);
        valueAnimator.setRepeatCount(u2.e(typedArray, xmlPullParser, "repeatCount", 3, 0));
        valueAnimator.setRepeatMode(u2.e(typedArray, xmlPullParser, "repeatMode", 4, 1));
        if (typedArray2 != null) {
            r(valueAnimator, typedArray2, e3, f, xmlPullParser);
        }
    }

    private static void r(ValueAnimator valueAnimator, TypedArray typedArray, int i, float f, XmlPullParser xmlPullParser) {
        ObjectAnimator objectAnimator = (ObjectAnimator) valueAnimator;
        String g = u2.g(typedArray, xmlPullParser, "pathData", 1);
        if (g != null) {
            String g2 = u2.g(typedArray, xmlPullParser, "propertyXName", 2);
            String g3 = u2.g(typedArray, xmlPullParser, "propertyYName", 3);
            if (i != 2) {
            }
            if (g2 == null && g3 == null) {
                throw new InflateException(typedArray.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
            }
            s(w2.e(g), objectAnimator, f * 0.5f, g2, g3);
            return;
        }
        objectAnimator.setPropertyName(u2.g(typedArray, xmlPullParser, "propertyName", 0));
    }

    private static void s(Path path, ObjectAnimator objectAnimator, float f, String str, String str2) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        ArrayList arrayList = new ArrayList();
        float f2 = 0.0f;
        arrayList.add(Float.valueOf(0.0f));
        float f3 = 0.0f;
        do {
            f3 += pathMeasure.getLength();
            arrayList.add(Float.valueOf(f3));
        } while (pathMeasure.nextContour());
        PathMeasure pathMeasure2 = new PathMeasure(path, false);
        int min = Math.min(100, ((int) (f3 / f)) + 1);
        float[] fArr = new float[min];
        float[] fArr2 = new float[min];
        float[] fArr3 = new float[2];
        float f4 = f3 / (min - 1);
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= min) {
                break;
            }
            pathMeasure2.getPosTan(f2 - ((Float) arrayList.get(i2)).floatValue(), fArr3, null);
            fArr[i] = fArr3[0];
            fArr2[i] = fArr3[1];
            f2 += f4;
            int i3 = i2 + 1;
            if (i3 < arrayList.size() && f2 > ((Float) arrayList.get(i3)).floatValue()) {
                pathMeasure2.nextContour();
                i2 = i3;
            }
            i++;
        }
        PropertyValuesHolder ofFloat = str != null ? PropertyValuesHolder.ofFloat(str, fArr) : null;
        PropertyValuesHolder ofFloat2 = str2 != null ? PropertyValuesHolder.ofFloat(str2, fArr2) : null;
        if (ofFloat == null) {
            objectAnimator.setValues(ofFloat2);
        } else if (ofFloat2 == null) {
            objectAnimator.setValues(ofFloat);
        } else {
            objectAnimator.setValues(ofFloat, ofFloat2);
        }
    }
}
