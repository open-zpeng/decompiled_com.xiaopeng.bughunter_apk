package defpackage;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import com.irdeto.securesdk.core.SSUtils;
import defpackage.w5;
import defpackage.y5;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: AnimatedStateListDrawableCompat.java */
/* renamed from: v5  reason: default package */
/* loaded from: classes.dex */
public class v5 extends y5 {
    private static final String q = v5.class.getSimpleName();
    private c r;
    private g s;
    private int t;
    private int u;
    private boolean v;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* renamed from: v5$b */
    /* loaded from: classes.dex */
    public static class b extends g {
        private final Animatable a;

        b(Animatable animatable) {
            super();
            this.a = animatable;
        }

        @Override // defpackage.v5.g
        public void c() {
            this.a.start();
        }

        @Override // defpackage.v5.g
        public void d() {
            this.a.stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* renamed from: v5$c */
    /* loaded from: classes.dex */
    public static class c extends y5.a {
        u3<Long> K;
        d4<Integer> L;

        c(c cVar, v5 v5Var, Resources resources) {
            super(cVar, v5Var, resources);
            if (cVar != null) {
                this.K = cVar.K;
                this.L = cVar.L;
                return;
            }
            this.K = new u3<>();
            this.L = new d4<>();
        }

        private static long E(int i, int i2) {
            return i2 | (i << 32);
        }

        int C(int[] iArr, Drawable drawable, int i) {
            int A = super.A(iArr, drawable);
            this.L.j(A, Integer.valueOf(i));
            return A;
        }

        int D(int i, int i2, Drawable drawable, boolean z) {
            int a = super.a(drawable);
            long E = E(i, i2);
            long j = z ? 8589934592L : 0L;
            long j2 = a;
            this.K.a(E, Long.valueOf(j2 | j));
            if (z) {
                this.K.a(E(i2, i), Long.valueOf(4294967296L | j2 | j));
            }
            return a;
        }

        int F(int i) {
            if (i < 0) {
                return 0;
            }
            return this.L.g(i, 0).intValue();
        }

        int G(int[] iArr) {
            int B = super.B(iArr);
            return B >= 0 ? B : super.B(StateSet.WILD_CARD);
        }

        int H(int i, int i2) {
            return (int) this.K.g(E(i, i2), -1L).longValue();
        }

        boolean I(int i, int i2) {
            return (this.K.g(E(i, i2), -1L).longValue() & 4294967296L) != 0;
        }

        boolean J(int i, int i2) {
            return (this.K.g(E(i, i2), -1L).longValue() & 8589934592L) != 0;
        }

        @Override // defpackage.y5.a, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new v5(this, null);
        }

        @Override // defpackage.y5.a, defpackage.w5.c
        void s() {
            this.K = this.K.clone();
            this.L = this.L.clone();
        }

        @Override // defpackage.y5.a, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new v5(this, resources);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* renamed from: v5$d */
    /* loaded from: classes.dex */
    public static class d extends g {
        private final s0 a;

        d(s0 s0Var) {
            super();
            this.a = s0Var;
        }

        @Override // defpackage.v5.g
        public void c() {
            this.a.start();
        }

        @Override // defpackage.v5.g
        public void d() {
            this.a.stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* renamed from: v5$e */
    /* loaded from: classes.dex */
    public static class e extends g {
        private final ObjectAnimator a;
        private final boolean b;

        e(AnimationDrawable animationDrawable, boolean z, boolean z2) {
            super();
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            int i = z ? numberOfFrames - 1 : 0;
            int i2 = z ? 0 : numberOfFrames - 1;
            f fVar = new f(animationDrawable, z);
            ObjectAnimator ofInt = ObjectAnimator.ofInt(animationDrawable, SSUtils.O00oOooO, i, i2);
            if (Build.VERSION.SDK_INT >= 18) {
                ofInt.setAutoCancel(true);
            }
            ofInt.setDuration(fVar.a());
            ofInt.setInterpolator(fVar);
            this.b = z2;
            this.a = ofInt;
        }

        @Override // defpackage.v5.g
        public boolean a() {
            return this.b;
        }

        @Override // defpackage.v5.g
        public void b() {
            this.a.reverse();
        }

        @Override // defpackage.v5.g
        public void c() {
            this.a.start();
        }

        @Override // defpackage.v5.g
        public void d() {
            this.a.cancel();
        }
    }

    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* renamed from: v5$f */
    /* loaded from: classes.dex */
    private static class f implements TimeInterpolator {
        private int[] a;
        private int b;
        private int c;

        f(AnimationDrawable animationDrawable, boolean z) {
            b(animationDrawable, z);
        }

        int a() {
            return this.c;
        }

        int b(AnimationDrawable animationDrawable, boolean z) {
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            this.b = numberOfFrames;
            int[] iArr = this.a;
            if (iArr == null || iArr.length < numberOfFrames) {
                this.a = new int[numberOfFrames];
            }
            int[] iArr2 = this.a;
            int i = 0;
            for (int i2 = 0; i2 < numberOfFrames; i2++) {
                int duration = animationDrawable.getDuration(z ? (numberOfFrames - i2) - 1 : i2);
                iArr2[i2] = duration;
                i += duration;
            }
            this.c = i;
            return i;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            int i = (int) ((f * this.c) + 0.5f);
            int i2 = this.b;
            int[] iArr = this.a;
            int i3 = 0;
            while (i3 < i2 && i >= iArr[i3]) {
                i -= iArr[i3];
                i3++;
            }
            return (i3 / i2) + (i3 < i2 ? i / this.c : 0.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* renamed from: v5$g */
    /* loaded from: classes.dex */
    public static abstract class g {
        private g() {
        }

        public boolean a() {
            return false;
        }

        public void b() {
        }

        public abstract void c();

        public abstract void d();
    }

    public v5() {
        this(null, null);
    }

    public static v5 l(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws IOException, XmlPullParserException {
        String name = xmlPullParser.getName();
        if (name.equals("animated-selector")) {
            v5 v5Var = new v5();
            v5Var.m(context, resources, xmlPullParser, attributeSet, theme);
            return v5Var;
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid animated-selector tag " + name);
    }

    private void n(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                return;
            }
            int depth2 = xmlPullParser.getDepth();
            if (depth2 < depth && next == 3) {
                return;
            }
            if (next == 2 && depth2 <= depth) {
                if (xmlPullParser.getName().equals("item")) {
                    p(context, resources, xmlPullParser, attributeSet, theme);
                } else if (xmlPullParser.getName().equals("transition")) {
                    q(context, resources, xmlPullParser, attributeSet, theme);
                }
            }
        }
    }

    private void o() {
        onStateChange(getState());
    }

    private int p(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        TypedArray i = u2.i(resources, theme, attributeSet, t5.L);
        int resourceId = i.getResourceId(t5.M, 0);
        int resourceId2 = i.getResourceId(t5.N, -1);
        Drawable d2 = resourceId2 > 0 ? u5.d(context, resourceId2) : null;
        i.recycle();
        int[] j = j(attributeSet);
        if (d2 == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next == 2) {
                if (xmlPullParser.getName().equals("vector")) {
                    d2 = y0.c(resources, xmlPullParser, attributeSet, theme);
                } else if (Build.VERSION.SDK_INT >= 21) {
                    d2 = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
                } else {
                    d2 = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
                }
            } else {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
            }
        }
        if (d2 != null) {
            return this.r.C(j, d2, resourceId);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
    }

    private int q(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        TypedArray i = u2.i(resources, theme, attributeSet, t5.O);
        int resourceId = i.getResourceId(t5.R, -1);
        int resourceId2 = i.getResourceId(t5.Q, -1);
        int resourceId3 = i.getResourceId(t5.P, -1);
        Drawable d2 = resourceId3 > 0 ? u5.d(context, resourceId3) : null;
        boolean z = i.getBoolean(t5.S, false);
        i.recycle();
        if (d2 == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next == 2) {
                if (xmlPullParser.getName().equals("animated-vector")) {
                    d2 = s0.a(context, resources, xmlPullParser, attributeSet, theme);
                } else if (Build.VERSION.SDK_INT >= 21) {
                    d2 = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
                } else {
                    d2 = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
                }
            } else {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
            }
        }
        if (d2 == null) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
        } else if (resourceId != -1 && resourceId2 != -1) {
            return this.r.D(resourceId, resourceId2, d2, z);
        } else {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires 'fromId' & 'toId' attributes");
        }
    }

    private boolean r(int i) {
        int c2;
        int H;
        g bVar;
        g gVar = this.s;
        if (gVar != null) {
            if (i == this.t) {
                return true;
            }
            if (i == this.u && gVar.a()) {
                gVar.b();
                this.t = this.u;
                this.u = i;
                return true;
            }
            c2 = this.t;
            gVar.d();
        } else {
            c2 = c();
        }
        this.s = null;
        this.u = -1;
        this.t = -1;
        c cVar = this.r;
        int F = cVar.F(c2);
        int F2 = cVar.F(i);
        if (F2 == 0 || F == 0 || (H = cVar.H(F, F2)) < 0) {
            return false;
        }
        boolean J = cVar.J(F, F2);
        f(H);
        Drawable current = getCurrent();
        if (current instanceof AnimationDrawable) {
            bVar = new e((AnimationDrawable) current, cVar.I(F, F2), J);
        } else if (current instanceof s0) {
            bVar = new d((s0) current);
        } else {
            if (current instanceof Animatable) {
                bVar = new b((Animatable) current);
            }
            return false;
        }
        bVar.c();
        this.s = bVar;
        this.u = c2;
        this.t = i;
        return true;
    }

    private void s(TypedArray typedArray) {
        c cVar = this.r;
        if (Build.VERSION.SDK_INT >= 21) {
            cVar.d |= typedArray.getChangingConfigurations();
        }
        cVar.y(typedArray.getBoolean(t5.H, cVar.i));
        cVar.u(typedArray.getBoolean(t5.I, cVar.l));
        cVar.v(typedArray.getInt(t5.J, cVar.A));
        cVar.w(typedArray.getInt(t5.K, cVar.B));
        setDither(typedArray.getBoolean(t5.F, cVar.x));
    }

    @Override // defpackage.y5, defpackage.w5, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    @Override // defpackage.w5, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean canApplyTheme() {
        return super.canApplyTheme();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // defpackage.y5, defpackage.w5
    public void clearMutated() {
        super.clearMutated();
        this.v = false;
    }

    @Override // defpackage.w5, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void draw(Canvas canvas) {
        super.draw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.y5, defpackage.w5
    public void g(w5.c cVar) {
        super.g(cVar);
        if (cVar instanceof c) {
            this.r = (c) cVar;
        }
    }

    @Override // defpackage.w5, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    @Override // defpackage.w5, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getChangingConfigurations() {
        return super.getChangingConfigurations();
    }

    @Override // defpackage.w5, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // defpackage.w5, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void getHotspotBounds(Rect rect) {
        super.getHotspotBounds(rect);
    }

    @Override // defpackage.w5, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getIntrinsicHeight() {
        return super.getIntrinsicHeight();
    }

    @Override // defpackage.w5, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getIntrinsicWidth() {
        return super.getIntrinsicWidth();
    }

    @Override // defpackage.w5, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // defpackage.w5, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // defpackage.w5, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    @Override // defpackage.w5, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void getOutline(Outline outline) {
        super.getOutline(outline);
    }

    @Override // defpackage.w5, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // defpackage.w5, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void invalidateDrawable(Drawable drawable) {
        super.invalidateDrawable(drawable);
    }

    @Override // defpackage.w5, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }

    @Override // defpackage.y5, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // defpackage.w5, android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        g gVar = this.s;
        if (gVar != null) {
            gVar.d();
            this.s = null;
            f(this.t);
            this.t = -1;
            this.u = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // defpackage.y5
    /* renamed from: k */
    public c i() {
        return new c(this.r, this, null);
    }

    public void m(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray i = u2.i(resources, theme, attributeSet, t5.E);
        setVisible(i.getBoolean(t5.G, true), true);
        s(i);
        h(resources);
        i.recycle();
        n(context, resources, xmlPullParser, attributeSet, theme);
        o();
    }

    @Override // defpackage.y5, defpackage.w5, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.v && super.mutate() == this) {
            this.r.s();
            this.v = true;
        }
        return this;
    }

    @Override // defpackage.w5, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean onLayoutDirectionChanged(int i) {
        return super.onLayoutDirectionChanged(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.y5, defpackage.w5, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        int G = this.r.G(iArr);
        boolean z = G != c() && (r(G) || f(G));
        Drawable current = getCurrent();
        return current != null ? z | current.setState(iArr) : z;
    }

    @Override // defpackage.w5, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        super.scheduleDrawable(drawable, runnable, j);
    }

    @Override // defpackage.w5, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAlpha(int i) {
        super.setAlpha(i);
    }

    @Override // defpackage.w5, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAutoMirrored(boolean z) {
        super.setAutoMirrored(z);
    }

    @Override // defpackage.w5, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    @Override // defpackage.w5, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setDither(boolean z) {
        super.setDither(z);
    }

    @Override // defpackage.w5, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f2, float f3) {
        super.setHotspot(f2, f3);
    }

    @Override // defpackage.w5, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    @Override // defpackage.w5, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setTintList(ColorStateList colorStateList) {
        super.setTintList(colorStateList);
    }

    @Override // defpackage.w5, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setTintMode(PorterDuff.Mode mode) {
        super.setTintMode(mode);
    }

    @Override // defpackage.w5, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        g gVar = this.s;
        if (gVar != null && (visible || z2)) {
            if (z) {
                gVar.c();
            } else {
                jumpToCurrentState();
            }
        }
        return visible;
    }

    @Override // defpackage.w5, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        super.unscheduleDrawable(drawable, runnable);
    }

    v5(c cVar, Resources resources) {
        super(null);
        this.t = -1;
        this.u = -1;
        g(new c(cVar, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }
}
