package defpackage;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import org.xmlpull.v1.XmlPullParser;
/* compiled from: TypedArrayUtils.java */
/* renamed from: u2  reason: default package */
/* loaded from: classes.dex */
public class u2 {
    public static boolean a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, boolean z) {
        return !h(xmlPullParser, str) ? z : typedArray.getBoolean(i, z);
    }

    public static int b(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        return !h(xmlPullParser, str) ? i2 : typedArray.getColor(i, i2);
    }

    public static p2 c(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str, int i, int i2) {
        if (h(xmlPullParser, str)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i, typedValue);
            int i3 = typedValue.type;
            if (i3 >= 28 && i3 <= 31) {
                return p2.b(typedValue.data);
            }
            p2 g = p2.g(typedArray.getResources(), typedArray.getResourceId(i, 0), theme);
            if (g != null) {
                return g;
            }
        }
        return p2.b(i2);
    }

    public static float d(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, float f) {
        return !h(xmlPullParser, str) ? f : typedArray.getFloat(i, f);
    }

    public static int e(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        return !h(xmlPullParser, str) ? i2 : typedArray.getInt(i, i2);
    }

    public static int f(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        return !h(xmlPullParser, str) ? i2 : typedArray.getResourceId(i, i2);
    }

    public static String g(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i) {
        if (h(xmlPullParser, str)) {
            return typedArray.getString(i);
        }
        return null;
    }

    public static boolean h(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null;
    }

    public static TypedArray i(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public static TypedValue j(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i) {
        if (h(xmlPullParser, str)) {
            return typedArray.peekValue(i);
        }
        return null;
    }
}
