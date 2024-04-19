package defpackage;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import defpackage.w2;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: VectorDrawableCompat.java */
/* renamed from: y0  reason: default package */
/* loaded from: classes.dex */
public class y0 extends x0 {
    static final PorterDuff.Mode c = PorterDuff.Mode.SRC_IN;
    private h d;
    private PorterDuffColorFilter e;
    private ColorFilter f;
    private boolean g;
    private boolean h;
    private Drawable.ConstantState i;
    private final float[] j;
    private final Matrix k;
    private final Rect l;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat.java */
    /* renamed from: y0$b */
    /* loaded from: classes.dex */
    public static class b extends f {
        public b() {
        }

        private void f(TypedArray typedArray) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.b = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.a = w2.d(string2);
            }
        }

        @Override // defpackage.y0.f
        public boolean c() {
            return true;
        }

        public void e(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (u2.h(xmlPullParser, "pathData")) {
                TypedArray i = u2.i(resources, theme, attributeSet, r0.d);
                f(i);
                i.recycle();
            }
        }

        public b(b bVar) {
            super(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat.java */
    /* renamed from: y0$e */
    /* loaded from: classes.dex */
    public static abstract class e {
        private e() {
        }

        public boolean a() {
            return false;
        }

        public boolean b(int[] iArr) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat.java */
    /* renamed from: y0$h */
    /* loaded from: classes.dex */
    public static class h extends Drawable.ConstantState {
        int a;
        g b;
        ColorStateList c;
        PorterDuff.Mode d;
        boolean e;
        Bitmap f;
        ColorStateList g;
        PorterDuff.Mode h;
        int i;
        boolean j;
        boolean k;
        Paint l;

        public h(h hVar) {
            this.c = null;
            this.d = y0.c;
            if (hVar != null) {
                this.a = hVar.a;
                g gVar = new g(hVar.b);
                this.b = gVar;
                Paint paint = hVar.b.f;
                if (paint != null) {
                    gVar.f = new Paint(paint);
                }
                Paint paint2 = hVar.b.e;
                if (paint2 != null) {
                    this.b.e = new Paint(paint2);
                }
                this.c = hVar.c;
                this.d = hVar.d;
                this.e = hVar.e;
            }
        }

        public boolean a(int i, int i2) {
            return i == this.f.getWidth() && i2 == this.f.getHeight();
        }

        public boolean b() {
            return !this.k && this.g == this.c && this.h == this.d && this.j == this.e && this.i == this.b.getRootAlpha();
        }

        public void c(int i, int i2) {
            if (this.f == null || !a(i, i2)) {
                this.f = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                this.k = true;
            }
        }

        public void d(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f, (Rect) null, rect, e(colorFilter));
        }

        public Paint e(ColorFilter colorFilter) {
            if (f() || colorFilter != null) {
                if (this.l == null) {
                    Paint paint = new Paint();
                    this.l = paint;
                    paint.setFilterBitmap(true);
                }
                this.l.setAlpha(this.b.getRootAlpha());
                this.l.setColorFilter(colorFilter);
                return this.l;
            }
            return null;
        }

        public boolean f() {
            return this.b.getRootAlpha() < 255;
        }

        public boolean g() {
            return this.b.f();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.a;
        }

        public boolean h(int[] iArr) {
            boolean g = this.b.g(iArr);
            this.k |= g;
            return g;
        }

        public void i() {
            this.g = this.c;
            this.h = this.d;
            this.i = this.b.getRootAlpha();
            this.j = this.e;
            this.k = false;
        }

        public void j(int i, int i2) {
            this.f.eraseColor(0);
            this.b.b(new Canvas(this.f), i, i2, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new y0(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new y0(this);
        }

        public h() {
            this.c = null;
            this.d = y0.c;
            this.b = new g();
        }
    }

    y0() {
        this.h = true;
        this.j = new float[9];
        this.k = new Matrix();
        this.l = new Rect();
        this.d = new h();
    }

    static int a(int i2, float f2) {
        return (i2 & 16777215) | (((int) (Color.alpha(i2) * f2)) << 24);
    }

    public static y0 b(Resources resources, int i2, Resources.Theme theme) {
        int next;
        if (Build.VERSION.SDK_INT >= 24) {
            y0 y0Var = new y0();
            Drawable a2 = t2.a(resources, i2, theme);
            y0Var.b = a2;
            y0Var.i = new i(a2.getConstantState());
            return y0Var;
        }
        try {
            XmlResourceParser xml = resources.getXml(i2);
            AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
            while (true) {
                next = xml.next();
                if (next == 2 || next == 1) {
                    break;
                }
            }
            if (next == 2) {
                return c(resources, xml, asAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (IOException e2) {
            Log.e("VectorDrawableCompat", "parser error", e2);
            return null;
        } catch (XmlPullParserException e3) {
            Log.e("VectorDrawableCompat", "parser error", e3);
            return null;
        }
    }

    public static y0 c(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        y0 y0Var = new y0();
        y0Var.inflate(resources, xmlPullParser, attributeSet, theme);
        return y0Var;
    }

    private void e(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        h hVar = this.d;
        g gVar = hVar.b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(gVar.i);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                d dVar = (d) arrayDeque.peek();
                if ("path".equals(name)) {
                    c cVar = new c();
                    cVar.g(resources, attributeSet, theme, xmlPullParser);
                    dVar.b.add(cVar);
                    if (cVar.getPathName() != null) {
                        gVar.q.put(cVar.getPathName(), cVar);
                    }
                    z = false;
                    hVar.a = cVar.c | hVar.a;
                } else if ("clip-path".equals(name)) {
                    b bVar = new b();
                    bVar.e(resources, attributeSet, theme, xmlPullParser);
                    dVar.b.add(bVar);
                    if (bVar.getPathName() != null) {
                        gVar.q.put(bVar.getPathName(), bVar);
                    }
                    hVar.a = bVar.c | hVar.a;
                } else if ("group".equals(name)) {
                    d dVar2 = new d();
                    dVar2.c(resources, attributeSet, theme, xmlPullParser);
                    dVar.b.add(dVar2);
                    arrayDeque.push(dVar2);
                    if (dVar2.getGroupName() != null) {
                        gVar.q.put(dVar2.getGroupName(), dVar2);
                    }
                    hVar.a = dVar2.k | hVar.a;
                }
            } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z) {
            throw new XmlPullParserException("no path defined");
        }
    }

    private boolean f() {
        return Build.VERSION.SDK_INT >= 17 && isAutoMirrored() && android.support.v4.graphics.drawable.a.f(this) == 1;
    }

    private static PorterDuff.Mode g(int i2, PorterDuff.Mode mode) {
        if (i2 != 3) {
            if (i2 != 5) {
                if (i2 != 9) {
                    switch (i2) {
                        case 14:
                            return PorterDuff.Mode.MULTIPLY;
                        case 15:
                            return PorterDuff.Mode.SCREEN;
                        case 16:
                            return PorterDuff.Mode.ADD;
                        default:
                            return mode;
                    }
                }
                return PorterDuff.Mode.SRC_ATOP;
            }
            return PorterDuff.Mode.SRC_IN;
        }
        return PorterDuff.Mode.SRC_OVER;
    }

    private void i(TypedArray typedArray, XmlPullParser xmlPullParser) throws XmlPullParserException {
        h hVar = this.d;
        g gVar = hVar.b;
        hVar.d = g(u2.e(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList colorStateList = typedArray.getColorStateList(1);
        if (colorStateList != null) {
            hVar.c = colorStateList;
        }
        hVar.e = u2.a(typedArray, xmlPullParser, "autoMirrored", 5, hVar.e);
        gVar.l = u2.d(typedArray, xmlPullParser, "viewportWidth", 7, gVar.l);
        float d2 = u2.d(typedArray, xmlPullParser, "viewportHeight", 8, gVar.m);
        gVar.m = d2;
        if (gVar.l <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        } else if (d2 > 0.0f) {
            gVar.j = typedArray.getDimension(3, gVar.j);
            float dimension = typedArray.getDimension(2, gVar.k);
            gVar.k = dimension;
            if (gVar.j <= 0.0f) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
            } else if (dimension > 0.0f) {
                gVar.setAlpha(u2.d(typedArray, xmlPullParser, "alpha", 4, gVar.getAlpha()));
                String string = typedArray.getString(0);
                if (string != null) {
                    gVar.o = string;
                    gVar.q.put(string, gVar);
                }
            } else {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
            }
        } else {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
    }

    @Override // defpackage.x0, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.b;
        if (drawable != null) {
            android.support.v4.graphics.drawable.a.b(drawable);
            return false;
        }
        return false;
    }

    @Override // defpackage.x0, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object d(String str) {
        return this.d.b.q.get(str);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        copyBounds(this.l);
        if (this.l.width() <= 0 || this.l.height() <= 0) {
            return;
        }
        ColorFilter colorFilter = this.f;
        if (colorFilter == null) {
            colorFilter = this.e;
        }
        canvas.getMatrix(this.k);
        this.k.getValues(this.j);
        float abs = Math.abs(this.j[0]);
        float abs2 = Math.abs(this.j[4]);
        float abs3 = Math.abs(this.j[1]);
        float abs4 = Math.abs(this.j[3]);
        if (abs3 != 0.0f || abs4 != 0.0f) {
            abs = 1.0f;
            abs2 = 1.0f;
        }
        int min = Math.min(2048, (int) (this.l.width() * abs));
        int min2 = Math.min(2048, (int) (this.l.height() * abs2));
        if (min <= 0 || min2 <= 0) {
            return;
        }
        int save = canvas.save();
        Rect rect = this.l;
        canvas.translate(rect.left, rect.top);
        if (f()) {
            canvas.translate(this.l.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        this.l.offsetTo(0, 0);
        this.d.c(min, min2);
        if (!this.h) {
            this.d.j(min, min2);
        } else if (!this.d.b()) {
            this.d.j(min, min2);
            this.d.i();
        }
        this.d.d(canvas, colorFilter, this.l);
        canvas.restoreToCount(save);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.b;
        if (drawable != null) {
            return android.support.v4.graphics.drawable.a.d(drawable);
        }
        return this.d.b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.b;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.d.getChangingConfigurations();
    }

    @Override // defpackage.x0, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        Drawable drawable = this.b;
        if (drawable != null && Build.VERSION.SDK_INT >= 24) {
            return new i(drawable.getConstantState());
        }
        this.d.a = getChangingConfigurations();
        return this.d;
    }

    @Override // defpackage.x0, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.b;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return (int) this.d.b.k;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.b;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return (int) this.d.b.j;
    }

    @Override // defpackage.x0, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // defpackage.x0, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.b;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // defpackage.x0, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // defpackage.x0, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // defpackage.x0, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(boolean z) {
        this.h = z;
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.b;
        if (drawable != null) {
            return android.support.v4.graphics.drawable.a.h(drawable);
        }
        return this.d.e;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        h hVar;
        ColorStateList colorStateList;
        Drawable drawable = this.b;
        if (drawable != null) {
            return drawable.isStateful();
        }
        return super.isStateful() || ((hVar = this.d) != null && (hVar.g() || ((colorStateList = this.d.c) != null && colorStateList.isStateful())));
    }

    @Override // defpackage.x0, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.g && super.mutate() == this) {
            this.d = new h(this.d);
            this.g = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        Drawable drawable = this.b;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        boolean z = false;
        h hVar = this.d;
        ColorStateList colorStateList = hVar.c;
        if (colorStateList != null && (mode = hVar.d) != null) {
            this.e = updateTintFilter(this.e, colorStateList, mode);
            invalidateSelf();
            z = true;
        }
        if (hVar.g() && hVar.h(iArr)) {
            invalidateSelf();
            return true;
        }
        return z;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.setAlpha(i2);
        } else if (this.d.b.getRootAlpha() != i2) {
            this.d.b.setRootAlpha(i2);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.b;
        if (drawable != null) {
            android.support.v4.graphics.drawable.a.j(drawable, z);
        } else {
            this.d.e = z;
        }
    }

    @Override // defpackage.x0, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i2) {
        super.setChangingConfigurations(i2);
    }

    @Override // defpackage.x0, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i2, PorterDuff.Mode mode) {
        super.setColorFilter(i2, mode);
    }

    @Override // defpackage.x0, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    @Override // defpackage.x0, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f2, float f3) {
        super.setHotspot(f2, f3);
    }

    @Override // defpackage.x0, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i2, int i3, int i4, int i5) {
        super.setHotspotBounds(i2, i3, i4, i5);
    }

    @Override // defpackage.x0, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.b
    public void setTint(int i2) {
        Drawable drawable = this.b;
        if (drawable != null) {
            android.support.v4.graphics.drawable.a.n(drawable, i2);
        } else {
            setTintList(ColorStateList.valueOf(i2));
        }
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.b
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.b;
        if (drawable != null) {
            android.support.v4.graphics.drawable.a.o(drawable, colorStateList);
            return;
        }
        h hVar = this.d;
        if (hVar.c != colorStateList) {
            hVar.c = colorStateList;
            this.e = updateTintFilter(this.e, colorStateList, hVar.d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.b
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.b;
        if (drawable != null) {
            android.support.v4.graphics.drawable.a.p(drawable, mode);
            return;
        }
        h hVar = this.d;
        if (hVar.d != mode) {
            hVar.d = mode;
            this.e = updateTintFilter(this.e, hVar.c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.b;
        if (drawable != null) {
            return drawable.setVisible(z, z2);
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    PorterDuffColorFilter updateTintFilter(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat.java */
    /* renamed from: y0$f */
    /* loaded from: classes.dex */
    public static abstract class f extends e {
        protected w2.b[] a;
        String b;
        int c;

        public f() {
            super();
            this.a = null;
        }

        public boolean c() {
            return false;
        }

        public void d(Path path) {
            path.reset();
            w2.b[] bVarArr = this.a;
            if (bVarArr != null) {
                w2.b.e(bVarArr, path);
            }
        }

        public w2.b[] getPathData() {
            return this.a;
        }

        public String getPathName() {
            return this.b;
        }

        public void setPathData(w2.b[] bVarArr) {
            if (!w2.b(this.a, bVarArr)) {
                this.a = w2.f(bVarArr);
            } else {
                w2.j(this.a, bVarArr);
            }
        }

        public f(f fVar) {
            super();
            this.a = null;
            this.b = fVar.b;
            this.c = fVar.c;
            this.a = w2.f(fVar.a);
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    /* renamed from: y0$i */
    /* loaded from: classes.dex */
    private static class i extends Drawable.ConstantState {
        private final Drawable.ConstantState a;

        public i(Drawable.ConstantState constantState) {
            this.a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            y0 y0Var = new y0();
            y0Var.b = (VectorDrawable) this.a.newDrawable();
            return y0Var;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            y0 y0Var = new y0();
            y0Var.b = (VectorDrawable) this.a.newDrawable(resources);
            return y0Var;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            y0 y0Var = new y0();
            y0Var.b = (VectorDrawable) this.a.newDrawable(resources, theme);
            return y0Var;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
            return;
        }
        this.f = colorFilter;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.b;
        if (drawable != null) {
            android.support.v4.graphics.drawable.a.g(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        h hVar = this.d;
        hVar.b = new g();
        TypedArray i2 = u2.i(resources, theme, attributeSet, r0.a);
        i(i2, xmlPullParser);
        i2.recycle();
        hVar.a = getChangingConfigurations();
        hVar.k = true;
        e(resources, xmlPullParser, attributeSet, theme);
        this.e = updateTintFilter(this.e, hVar.c, hVar.d);
    }

    y0(h hVar) {
        this.h = true;
        this.j = new float[9];
        this.k = new Matrix();
        this.l = new Rect();
        this.d = hVar;
        this.e = updateTintFilter(this.e, hVar.c, hVar.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat.java */
    /* renamed from: y0$c */
    /* loaded from: classes.dex */
    public static class c extends f {
        private int[] d;
        p2 e;
        float f;
        p2 g;
        float h;
        int i;
        float j;
        float k;
        float l;
        float m;
        Paint.Cap n;
        Paint.Join o;
        float p;

        public c() {
            this.f = 0.0f;
            this.h = 1.0f;
            this.i = 0;
            this.j = 1.0f;
            this.k = 0.0f;
            this.l = 1.0f;
            this.m = 0.0f;
            this.n = Paint.Cap.BUTT;
            this.o = Paint.Join.MITER;
            this.p = 4.0f;
        }

        private Paint.Cap e(int i, Paint.Cap cap) {
            if (i != 0) {
                if (i != 1) {
                    return i != 2 ? cap : Paint.Cap.SQUARE;
                }
                return Paint.Cap.ROUND;
            }
            return Paint.Cap.BUTT;
        }

        private Paint.Join f(int i, Paint.Join join) {
            if (i != 0) {
                if (i != 1) {
                    return i != 2 ? join : Paint.Join.BEVEL;
                }
                return Paint.Join.ROUND;
            }
            return Paint.Join.MITER;
        }

        private void h(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            this.d = null;
            if (u2.h(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.b = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.a = w2.d(string2);
                }
                this.g = u2.c(typedArray, xmlPullParser, theme, "fillColor", 1, 0);
                this.j = u2.d(typedArray, xmlPullParser, "fillAlpha", 12, this.j);
                this.n = e(u2.e(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.n);
                this.o = f(u2.e(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.o);
                this.p = u2.d(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.p);
                this.e = u2.c(typedArray, xmlPullParser, theme, "strokeColor", 3, 0);
                this.h = u2.d(typedArray, xmlPullParser, "strokeAlpha", 11, this.h);
                this.f = u2.d(typedArray, xmlPullParser, "strokeWidth", 4, this.f);
                this.l = u2.d(typedArray, xmlPullParser, "trimPathEnd", 6, this.l);
                this.m = u2.d(typedArray, xmlPullParser, "trimPathOffset", 7, this.m);
                this.k = u2.d(typedArray, xmlPullParser, "trimPathStart", 5, this.k);
                this.i = u2.e(typedArray, xmlPullParser, "fillType", 13, this.i);
            }
        }

        @Override // defpackage.y0.e
        public boolean a() {
            return this.g.i() || this.e.i();
        }

        @Override // defpackage.y0.e
        public boolean b(int[] iArr) {
            return this.e.j(iArr) | this.g.j(iArr);
        }

        public void g(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray i = u2.i(resources, theme, attributeSet, r0.c);
            h(i, xmlPullParser, theme);
            i.recycle();
        }

        float getFillAlpha() {
            return this.j;
        }

        int getFillColor() {
            return this.g.e();
        }

        float getStrokeAlpha() {
            return this.h;
        }

        int getStrokeColor() {
            return this.e.e();
        }

        float getStrokeWidth() {
            return this.f;
        }

        float getTrimPathEnd() {
            return this.l;
        }

        float getTrimPathOffset() {
            return this.m;
        }

        float getTrimPathStart() {
            return this.k;
        }

        void setFillAlpha(float f) {
            this.j = f;
        }

        void setFillColor(int i) {
            this.g.k(i);
        }

        void setStrokeAlpha(float f) {
            this.h = f;
        }

        void setStrokeColor(int i) {
            this.e.k(i);
        }

        void setStrokeWidth(float f) {
            this.f = f;
        }

        void setTrimPathEnd(float f) {
            this.l = f;
        }

        void setTrimPathOffset(float f) {
            this.m = f;
        }

        void setTrimPathStart(float f) {
            this.k = f;
        }

        public c(c cVar) {
            super(cVar);
            this.f = 0.0f;
            this.h = 1.0f;
            this.i = 0;
            this.j = 1.0f;
            this.k = 0.0f;
            this.l = 1.0f;
            this.m = 0.0f;
            this.n = Paint.Cap.BUTT;
            this.o = Paint.Join.MITER;
            this.p = 4.0f;
            this.d = cVar.d;
            this.e = cVar.e;
            this.f = cVar.f;
            this.h = cVar.h;
            this.g = cVar.g;
            this.i = cVar.i;
            this.j = cVar.j;
            this.k = cVar.k;
            this.l = cVar.l;
            this.m = cVar.m;
            this.n = cVar.n;
            this.o = cVar.o;
            this.p = cVar.p;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat.java */
    /* renamed from: y0$g */
    /* loaded from: classes.dex */
    public static class g {
        private static final Matrix a = new Matrix();
        private final Path b;
        private final Path c;
        private final Matrix d;
        Paint e;
        Paint f;
        private PathMeasure g;
        private int h;
        final d i;
        float j;
        float k;
        float l;
        float m;
        int n;
        String o;
        Boolean p;
        final p3<String, Object> q;

        public g() {
            this.d = new Matrix();
            this.j = 0.0f;
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 0.0f;
            this.n = 255;
            this.o = null;
            this.p = null;
            this.q = new p3<>();
            this.i = new d();
            this.b = new Path();
            this.c = new Path();
        }

        private static float a(float f, float f2, float f3, float f4) {
            return (f * f4) - (f2 * f3);
        }

        private void c(d dVar, Matrix matrix, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            dVar.a.set(matrix);
            dVar.a.preConcat(dVar.j);
            canvas.save();
            for (int i3 = 0; i3 < dVar.b.size(); i3++) {
                e eVar = dVar.b.get(i3);
                if (eVar instanceof d) {
                    c((d) eVar, dVar.a, canvas, i, i2, colorFilter);
                } else if (eVar instanceof f) {
                    d(dVar, (f) eVar, canvas, i, i2, colorFilter);
                }
            }
            canvas.restore();
        }

        private void d(d dVar, f fVar, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            float f = i / this.l;
            float f2 = i2 / this.m;
            float min = Math.min(f, f2);
            Matrix matrix = dVar.a;
            this.d.set(matrix);
            this.d.postScale(f, f2);
            float e = e(matrix);
            if (e == 0.0f) {
                return;
            }
            fVar.d(this.b);
            Path path = this.b;
            this.c.reset();
            if (fVar.c()) {
                this.c.addPath(path, this.d);
                canvas.clipPath(this.c);
                return;
            }
            c cVar = (c) fVar;
            float f3 = cVar.k;
            if (f3 != 0.0f || cVar.l != 1.0f) {
                float f4 = cVar.m;
                float f5 = (f3 + f4) % 1.0f;
                float f6 = (cVar.l + f4) % 1.0f;
                if (this.g == null) {
                    this.g = new PathMeasure();
                }
                this.g.setPath(this.b, false);
                float length = this.g.getLength();
                float f7 = f5 * length;
                float f8 = f6 * length;
                path.reset();
                if (f7 > f8) {
                    this.g.getSegment(f7, length, path, true);
                    this.g.getSegment(0.0f, f8, path, true);
                } else {
                    this.g.getSegment(f7, f8, path, true);
                }
                path.rLineTo(0.0f, 0.0f);
            }
            this.c.addPath(path, this.d);
            if (cVar.g.l()) {
                p2 p2Var = cVar.g;
                if (this.f == null) {
                    Paint paint = new Paint(1);
                    this.f = paint;
                    paint.setStyle(Paint.Style.FILL);
                }
                Paint paint2 = this.f;
                if (p2Var.h()) {
                    Shader f9 = p2Var.f();
                    f9.setLocalMatrix(this.d);
                    paint2.setShader(f9);
                    paint2.setAlpha(Math.round(cVar.j * 255.0f));
                } else {
                    paint2.setColor(y0.a(p2Var.e(), cVar.j));
                }
                paint2.setColorFilter(colorFilter);
                this.c.setFillType(cVar.i == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                canvas.drawPath(this.c, paint2);
            }
            if (cVar.e.l()) {
                p2 p2Var2 = cVar.e;
                if (this.e == null) {
                    Paint paint3 = new Paint(1);
                    this.e = paint3;
                    paint3.setStyle(Paint.Style.STROKE);
                }
                Paint paint4 = this.e;
                Paint.Join join = cVar.o;
                if (join != null) {
                    paint4.setStrokeJoin(join);
                }
                Paint.Cap cap = cVar.n;
                if (cap != null) {
                    paint4.setStrokeCap(cap);
                }
                paint4.setStrokeMiter(cVar.p);
                if (p2Var2.h()) {
                    Shader f10 = p2Var2.f();
                    f10.setLocalMatrix(this.d);
                    paint4.setShader(f10);
                    paint4.setAlpha(Math.round(cVar.h * 255.0f));
                } else {
                    paint4.setColor(y0.a(p2Var2.e(), cVar.h));
                }
                paint4.setColorFilter(colorFilter);
                paint4.setStrokeWidth(cVar.f * min * e);
                canvas.drawPath(this.c, paint4);
            }
        }

        private float e(Matrix matrix) {
            float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float a2 = a(fArr[0], fArr[1], fArr[2], fArr[3]);
            float max = Math.max((float) Math.hypot(fArr[0], fArr[1]), (float) Math.hypot(fArr[2], fArr[3]));
            if (max > 0.0f) {
                return Math.abs(a2) / max;
            }
            return 0.0f;
        }

        public void b(Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            c(this.i, a, canvas, i, i2, colorFilter);
        }

        public boolean f() {
            if (this.p == null) {
                this.p = Boolean.valueOf(this.i.a());
            }
            return this.p.booleanValue();
        }

        public boolean g(int[] iArr) {
            return this.i.b(iArr);
        }

        public float getAlpha() {
            return getRootAlpha() / 255.0f;
        }

        public int getRootAlpha() {
            return this.n;
        }

        public void setAlpha(float f) {
            setRootAlpha((int) (f * 255.0f));
        }

        public void setRootAlpha(int i) {
            this.n = i;
        }

        public g(g gVar) {
            this.d = new Matrix();
            this.j = 0.0f;
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 0.0f;
            this.n = 255;
            this.o = null;
            this.p = null;
            p3<String, Object> p3Var = new p3<>();
            this.q = p3Var;
            this.i = new d(gVar.i, p3Var);
            this.b = new Path(gVar.b);
            this.c = new Path(gVar.c);
            this.j = gVar.j;
            this.k = gVar.k;
            this.l = gVar.l;
            this.m = gVar.m;
            this.h = gVar.h;
            this.n = gVar.n;
            this.o = gVar.o;
            String str = gVar.o;
            if (str != null) {
                p3Var.put(str, this);
            }
            this.p = gVar.p;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat.java */
    /* renamed from: y0$d */
    /* loaded from: classes.dex */
    public static class d extends e {
        final Matrix a;
        final ArrayList<e> b;
        float c;
        private float d;
        private float e;
        private float f;
        private float g;
        private float h;
        private float i;
        final Matrix j;
        int k;
        private int[] l;
        private String m;

        public d(d dVar, p3<String, Object> p3Var) {
            super();
            f bVar;
            this.a = new Matrix();
            this.b = new ArrayList<>();
            this.c = 0.0f;
            this.d = 0.0f;
            this.e = 0.0f;
            this.f = 1.0f;
            this.g = 1.0f;
            this.h = 0.0f;
            this.i = 0.0f;
            Matrix matrix = new Matrix();
            this.j = matrix;
            this.m = null;
            this.c = dVar.c;
            this.d = dVar.d;
            this.e = dVar.e;
            this.f = dVar.f;
            this.g = dVar.g;
            this.h = dVar.h;
            this.i = dVar.i;
            this.l = dVar.l;
            String str = dVar.m;
            this.m = str;
            this.k = dVar.k;
            if (str != null) {
                p3Var.put(str, this);
            }
            matrix.set(dVar.j);
            ArrayList<e> arrayList = dVar.b;
            for (int i = 0; i < arrayList.size(); i++) {
                e eVar = arrayList.get(i);
                if (eVar instanceof d) {
                    this.b.add(new d((d) eVar, p3Var));
                } else {
                    if (eVar instanceof c) {
                        bVar = new c((c) eVar);
                    } else if (eVar instanceof b) {
                        bVar = new b((b) eVar);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.b.add(bVar);
                    String str2 = bVar.b;
                    if (str2 != null) {
                        p3Var.put(str2, bVar);
                    }
                }
            }
        }

        private void d() {
            this.j.reset();
            this.j.postTranslate(-this.d, -this.e);
            this.j.postScale(this.f, this.g);
            this.j.postRotate(this.c, 0.0f, 0.0f);
            this.j.postTranslate(this.h + this.d, this.i + this.e);
        }

        private void e(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.l = null;
            this.c = u2.d(typedArray, xmlPullParser, "rotation", 5, this.c);
            this.d = typedArray.getFloat(1, this.d);
            this.e = typedArray.getFloat(2, this.e);
            this.f = u2.d(typedArray, xmlPullParser, "scaleX", 3, this.f);
            this.g = u2.d(typedArray, xmlPullParser, "scaleY", 4, this.g);
            this.h = u2.d(typedArray, xmlPullParser, "translateX", 6, this.h);
            this.i = u2.d(typedArray, xmlPullParser, "translateY", 7, this.i);
            String string = typedArray.getString(0);
            if (string != null) {
                this.m = string;
            }
            d();
        }

        @Override // defpackage.y0.e
        public boolean a() {
            for (int i = 0; i < this.b.size(); i++) {
                if (this.b.get(i).a()) {
                    return true;
                }
            }
            return false;
        }

        @Override // defpackage.y0.e
        public boolean b(int[] iArr) {
            boolean z = false;
            for (int i = 0; i < this.b.size(); i++) {
                z |= this.b.get(i).b(iArr);
            }
            return z;
        }

        public void c(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray i = u2.i(resources, theme, attributeSet, r0.b);
            e(i, xmlPullParser);
            i.recycle();
        }

        public String getGroupName() {
            return this.m;
        }

        public Matrix getLocalMatrix() {
            return this.j;
        }

        public float getPivotX() {
            return this.d;
        }

        public float getPivotY() {
            return this.e;
        }

        public float getRotation() {
            return this.c;
        }

        public float getScaleX() {
            return this.f;
        }

        public float getScaleY() {
            return this.g;
        }

        public float getTranslateX() {
            return this.h;
        }

        public float getTranslateY() {
            return this.i;
        }

        public void setPivotX(float f) {
            if (f != this.d) {
                this.d = f;
                d();
            }
        }

        public void setPivotY(float f) {
            if (f != this.e) {
                this.e = f;
                d();
            }
        }

        public void setRotation(float f) {
            if (f != this.c) {
                this.c = f;
                d();
            }
        }

        public void setScaleX(float f) {
            if (f != this.f) {
                this.f = f;
                d();
            }
        }

        public void setScaleY(float f) {
            if (f != this.g) {
                this.g = f;
                d();
            }
        }

        public void setTranslateX(float f) {
            if (f != this.h) {
                this.h = f;
                d();
            }
        }

        public void setTranslateY(float f) {
            if (f != this.i) {
                this.i = f;
                d();
            }
        }

        public d() {
            super();
            this.a = new Matrix();
            this.b = new ArrayList<>();
            this.c = 0.0f;
            this.d = 0.0f;
            this.e = 0.0f;
            this.f = 1.0f;
            this.g = 1.0f;
            this.h = 0.0f;
            this.i = 0.0f;
            this.j = new Matrix();
            this.m = null;
        }
    }
}
