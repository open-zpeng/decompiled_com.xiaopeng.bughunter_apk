package defpackage;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.Base64;
import android.util.TypedValue;
import android.util.Xml;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IInputController;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: FontResourcesParserCompat.java */
/* renamed from: q2  reason: default package */
/* loaded from: classes.dex */
public class q2 {

    /* compiled from: FontResourcesParserCompat.java */
    /* renamed from: q2$a */
    /* loaded from: classes.dex */
    public interface a {
    }

    /* compiled from: FontResourcesParserCompat.java */
    /* renamed from: q2$b */
    /* loaded from: classes.dex */
    public static final class b implements a {
        private final c[] a;

        public b(c[] cVarArr) {
            this.a = cVarArr;
        }

        public c[] a() {
            return this.a;
        }
    }

    /* compiled from: FontResourcesParserCompat.java */
    /* renamed from: q2$c */
    /* loaded from: classes.dex */
    public static final class c {
        private final String a;
        private int b;
        private boolean c;
        private String d;
        private int e;
        private int f;

        public c(String str, int i, boolean z, String str2, int i2, int i3) {
            this.a = str;
            this.b = i;
            this.c = z;
            this.d = str2;
            this.e = i2;
            this.f = i3;
        }

        public String a() {
            return this.a;
        }

        public int b() {
            return this.f;
        }

        public int c() {
            return this.e;
        }

        public String d() {
            return this.d;
        }

        public int e() {
            return this.b;
        }

        public boolean f() {
            return this.c;
        }
    }

    /* compiled from: FontResourcesParserCompat.java */
    /* renamed from: q2$d */
    /* loaded from: classes.dex */
    public static final class d implements a {
        private final l3 a;
        private final int b;
        private final int c;

        public d(l3 l3Var, int i, int i2) {
            this.a = l3Var;
            this.c = i;
            this.b = i2;
        }

        public int a() {
            return this.c;
        }

        public l3 b() {
            return this.a;
        }

        public int c() {
            return this.b;
        }
    }

    private static int a(TypedArray typedArray, int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            return typedArray.getType(i);
        }
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(i, typedValue);
        return typedValue.type;
    }

    public static a b(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return d(xmlPullParser, resources);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static List<List<byte[]>> c(Resources resources, int i) {
        if (i == 0) {
            return Collections.emptyList();
        }
        TypedArray obtainTypedArray = resources.obtainTypedArray(i);
        try {
            if (obtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (a(obtainTypedArray, 0) == 1) {
                for (int i2 = 0; i2 < obtainTypedArray.length(); i2++) {
                    int resourceId = obtainTypedArray.getResourceId(i2, 0);
                    if (resourceId != 0) {
                        arrayList.add(h(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(h(resources.getStringArray(i)));
            }
            return arrayList;
        } finally {
            obtainTypedArray.recycle();
        }
    }

    private static a d(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return e(xmlPullParser, resources);
        }
        g(xmlPullParser);
        return null;
    }

    private static a e(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), h.e);
        String string = obtainAttributes.getString(h.f);
        String string2 = obtainAttributes.getString(h.j);
        String string3 = obtainAttributes.getString(h.k);
        int resourceId = obtainAttributes.getResourceId(h.g, 0);
        int integer = obtainAttributes.getInteger(h.h, 1);
        int integer2 = obtainAttributes.getInteger(h.i, IInputController.KEYCODE_KNOB_WIND_SPD_UP);
        obtainAttributes.recycle();
        if (string != null && string2 != null && string3 != null) {
            while (xmlPullParser.next() != 3) {
                g(xmlPullParser);
            }
            return new d(new l3(string, string2, string3, c(resources, resourceId)), integer, integer2);
        }
        ArrayList arrayList = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("font")) {
                    arrayList.add(f(xmlPullParser, resources));
                } else {
                    g(xmlPullParser);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new b((c[]) arrayList.toArray(new c[arrayList.size()]));
    }

    private static c f(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), h.l);
        int i = h.u;
        if (!obtainAttributes.hasValue(i)) {
            i = h.n;
        }
        int i2 = obtainAttributes.getInt(i, 400);
        int i3 = h.s;
        if (!obtainAttributes.hasValue(i3)) {
            i3 = h.o;
        }
        boolean z = 1 == obtainAttributes.getInt(i3, 0);
        int i4 = h.v;
        if (!obtainAttributes.hasValue(i4)) {
            i4 = h.p;
        }
        int i5 = h.t;
        if (!obtainAttributes.hasValue(i5)) {
            i5 = h.q;
        }
        String string = obtainAttributes.getString(i5);
        int i6 = obtainAttributes.getInt(i4, 0);
        int i7 = h.r;
        if (!obtainAttributes.hasValue(i7)) {
            i7 = h.m;
        }
        int resourceId = obtainAttributes.getResourceId(i7, 0);
        String string2 = obtainAttributes.getString(i7);
        obtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            g(xmlPullParser);
        }
        return new c(string2, i2, z, string, i6, resourceId);
    }

    private static void g(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i = 1;
        while (i > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i++;
            } else if (next == 3) {
                i--;
            }
        }
    }

    private static List<byte[]> h(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(Base64.decode(str, 0));
        }
        return arrayList;
    }
}
