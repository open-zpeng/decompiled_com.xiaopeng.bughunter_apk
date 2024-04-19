package defpackage;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.Xml;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: ColorStateListInflaterCompat.java */
/* renamed from: o2  reason: default package */
/* loaded from: classes.dex */
public final class o2 {
    public static ColorStateList a(Resources resources, XmlPullParser xmlPullParser, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return b(resources, xmlPullParser, asAttributeSet, theme);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static ColorStateList b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        String name = xmlPullParser.getName();
        if (name.equals("selector")) {
            return c(resources, xmlPullParser, attributeSet, theme);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid color state list tag " + name);
    }

    private static ColorStateList c(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth;
        int i = 1;
        int depth2 = xmlPullParser.getDepth() + 1;
        int[][] iArr = new int[20];
        int[] iArr2 = new int[20];
        int i2 = 0;
        while (true) {
            int next = xmlPullParser.next();
            if (next == i || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals("item")) {
                TypedArray e = e(resources, theme, attributeSet, h.a);
                int color = e.getColor(h.b, -65281);
                float f = 1.0f;
                int i3 = h.c;
                if (e.hasValue(i3)) {
                    f = e.getFloat(i3, 1.0f);
                } else {
                    int i4 = h.d;
                    if (e.hasValue(i4)) {
                        f = e.getFloat(i4, 1.0f);
                    }
                }
                e.recycle();
                int attributeCount = attributeSet.getAttributeCount();
                int[] iArr3 = new int[attributeCount];
                int i5 = 0;
                for (int i6 = 0; i6 < attributeCount; i6++) {
                    int attributeNameResource = attributeSet.getAttributeNameResource(i6);
                    if (attributeNameResource != 16843173 && attributeNameResource != 16843551 && attributeNameResource != f.a) {
                        int i7 = i5 + 1;
                        if (!attributeSet.getAttributeBooleanValue(i6, false)) {
                            attributeNameResource = -attributeNameResource;
                        }
                        iArr3[i5] = attributeNameResource;
                        i5 = i7;
                    }
                }
                int[] trimStateSet = StateSet.trimStateSet(iArr3, i5);
                int d = d(color, f);
                if (i2 != 0) {
                    int length = trimStateSet.length;
                }
                iArr2 = s2.a(iArr2, i2, d);
                iArr = (int[][]) s2.b(iArr, i2, trimStateSet);
                i2++;
            }
            i = 1;
        }
        int[] iArr4 = new int[i2];
        int[][] iArr5 = new int[i2];
        System.arraycopy(iArr2, 0, iArr4, 0, i2);
        System.arraycopy(iArr, 0, iArr5, 0, i2);
        return new ColorStateList(iArr5, iArr4);
    }

    private static int d(int i, float f) {
        return (i & 16777215) | (Math.round(Color.alpha(i) * f) << 24);
    }

    private static TypedArray e(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }
}
