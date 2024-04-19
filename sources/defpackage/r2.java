package defpackage;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import java.io.IOException;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GradientColorInflaterCompat.java */
/* renamed from: r2  reason: default package */
/* loaded from: classes.dex */
public final class r2 {
    private static a a(a aVar, int i, int i2, boolean z, int i3) {
        if (aVar != null) {
            return aVar;
        }
        if (z) {
            return new a(i, i3, i2);
        }
        return new a(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Shader b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws IOException, XmlPullParserException {
        String name = xmlPullParser.getName();
        if (name.equals("gradient")) {
            TypedArray i = u2.i(resources, theme, attributeSet, h.w);
            float d = u2.d(i, xmlPullParser, "startX", h.F, 0.0f);
            float d2 = u2.d(i, xmlPullParser, "startY", h.G, 0.0f);
            float d3 = u2.d(i, xmlPullParser, "endX", h.H, 0.0f);
            float d4 = u2.d(i, xmlPullParser, "endY", h.I, 0.0f);
            float d5 = u2.d(i, xmlPullParser, "centerX", h.A, 0.0f);
            float d6 = u2.d(i, xmlPullParser, "centerY", h.B, 0.0f);
            int e = u2.e(i, xmlPullParser, "type", h.z, 0);
            int b = u2.b(i, xmlPullParser, "startColor", h.x, 0);
            boolean h = u2.h(xmlPullParser, "centerColor");
            int b2 = u2.b(i, xmlPullParser, "centerColor", h.E, 0);
            int b3 = u2.b(i, xmlPullParser, "endColor", h.y, 0);
            int e2 = u2.e(i, xmlPullParser, "tileMode", h.D, 0);
            float d7 = u2.d(i, xmlPullParser, "gradientRadius", h.C, 0.0f);
            i.recycle();
            a a2 = a(c(resources, xmlPullParser, attributeSet, theme), b, b3, h, b2);
            if (e != 1) {
                if (e != 2) {
                    return new LinearGradient(d, d2, d3, d4, a2.a, a2.b, d(e2));
                }
                return new SweepGradient(d5, d6, a2.a, a2.b);
            } else if (d7 > 0.0f) {
                return new RadialGradient(d5, d6, d7, a2.a, a2.b, d(e2));
            } else {
                throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
            }
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid gradient color tag " + name);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0085, code lost:
        throw new org.xmlpull.v1.XmlPullParserException(r10.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static defpackage.r2.a c(android.content.res.Resources r9, org.xmlpull.v1.XmlPullParser r10, android.util.AttributeSet r11, android.content.res.Resources.Theme r12) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            int r0 = r10.getDepth()
            r1 = 1
            int r0 = r0 + r1
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 20
            r2.<init>(r3)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>(r3)
        L12:
            int r3 = r10.next()
            if (r3 == r1) goto L86
            int r5 = r10.getDepth()
            if (r5 >= r0) goto L21
            r6 = 3
            if (r3 == r6) goto L86
        L21:
            r6 = 2
            if (r3 == r6) goto L25
            goto L12
        L25:
            if (r5 > r0) goto L12
            java.lang.String r3 = r10.getName()
            java.lang.String r5 = "item"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L34
            goto L12
        L34:
            int[] r3 = defpackage.h.J
            android.content.res.TypedArray r3 = defpackage.u2.i(r9, r12, r11, r3)
            int r5 = defpackage.h.K
            boolean r6 = r3.hasValue(r5)
            int r7 = defpackage.h.L
            boolean r8 = r3.hasValue(r7)
            if (r6 == 0) goto L66
            if (r8 == 0) goto L66
            r6 = 0
            int r5 = r3.getColor(r5, r6)
            r6 = 0
            float r6 = r3.getFloat(r7, r6)
            r3.recycle()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)
            r4.add(r3)
            java.lang.Float r3 = java.lang.Float.valueOf(r6)
            r2.add(r3)
            goto L12
        L66:
            org.xmlpull.v1.XmlPullParserException r9 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r10 = r10.getPositionDescription()
            r11.append(r10)
            java.lang.String r10 = ": <item> tag requires a 'color' attribute and a 'offset' "
            r11.append(r10)
            java.lang.String r10 = "attribute!"
            r11.append(r10)
            java.lang.String r10 = r11.toString()
            r9.<init>(r10)
            throw r9
        L86:
            int r9 = r4.size()
            if (r9 <= 0) goto L92
            r2$a r9 = new r2$a
            r9.<init>(r4, r2)
            return r9
        L92:
            r9 = 0
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.r2.c(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):r2$a");
    }

    private static Shader.TileMode d(int i) {
        if (i != 1) {
            if (i != 2) {
                return Shader.TileMode.CLAMP;
            }
            return Shader.TileMode.MIRROR;
        }
        return Shader.TileMode.REPEAT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GradientColorInflaterCompat.java */
    /* renamed from: r2$a */
    /* loaded from: classes.dex */
    public static final class a {
        final int[] a;
        final float[] b;

        a(List<Integer> list, List<Float> list2) {
            int size = list.size();
            this.a = new int[size];
            this.b = new float[size];
            for (int i = 0; i < size; i++) {
                this.a[i] = list.get(i).intValue();
                this.b[i] = list2.get(i).floatValue();
            }
        }

        a(int i, int i2) {
            this.a = new int[]{i, i2};
            this.b = new float[]{0.0f, 1.0f};
        }

        a(int i, int i2, int i3) {
            this.a = new int[]{i, i2, i3};
            this.b = new float[]{0.0f, 0.5f, 1.0f};
        }
    }
}
