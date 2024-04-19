package defpackage;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: AnimatedVectorDrawableCompat.java */
/* renamed from: s0  reason: default package */
/* loaded from: classes.dex */
public class s0 extends x0 implements Animatable {
    private b c;
    private Context d;
    private ArgbEvaluator e;
    private Animator.AnimatorListener f;
    ArrayList<?> g;
    final Drawable.Callback h;

    /* compiled from: AnimatedVectorDrawableCompat.java */
    /* renamed from: s0$a */
    /* loaded from: classes.dex */
    class a implements Drawable.Callback {
        a() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            s0.this.invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            s0.this.scheduleSelf(runnable, j);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            s0.this.unscheduleSelf(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AnimatedVectorDrawableCompat.java */
    /* renamed from: s0$b */
    /* loaded from: classes.dex */
    public static class b extends Drawable.ConstantState {
        int a;
        y0 b;
        AnimatorSet c;
        ArrayList<Animator> d;
        p3<Animator, String> e;

        public b(Context context, b bVar, Drawable.Callback callback, Resources resources) {
            if (bVar != null) {
                this.a = bVar.a;
                y0 y0Var = bVar.b;
                if (y0Var != null) {
                    Drawable.ConstantState constantState = y0Var.getConstantState();
                    if (resources != null) {
                        this.b = (y0) constantState.newDrawable(resources);
                    } else {
                        this.b = (y0) constantState.newDrawable();
                    }
                    y0 y0Var2 = (y0) this.b.mutate();
                    this.b = y0Var2;
                    y0Var2.setCallback(callback);
                    this.b.setBounds(bVar.b.getBounds());
                    this.b.h(false);
                }
                ArrayList<Animator> arrayList = bVar.d;
                if (arrayList != null) {
                    int size = arrayList.size();
                    this.d = new ArrayList<>(size);
                    this.e = new p3<>(size);
                    for (int i = 0; i < size; i++) {
                        Animator animator = bVar.d.get(i);
                        Animator clone = animator.clone();
                        String str = bVar.e.get(animator);
                        clone.setTarget(this.b.d(str));
                        this.d.add(clone);
                        this.e.put(clone, str);
                    }
                    a();
                }
            }
        }

        public void a() {
            if (this.c == null) {
                this.c = new AnimatorSet();
            }
            this.c.playTogether(this.d);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    s0() {
        this(null, null, null);
    }

    public static s0 a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        s0 s0Var = new s0(context);
        s0Var.inflate(resources, xmlPullParser, attributeSet, theme);
        return s0Var;
    }

    private void b(String str, Animator animator) {
        animator.setTarget(this.c.b.d(str));
        if (Build.VERSION.SDK_INT < 21) {
            c(animator);
        }
        b bVar = this.c;
        if (bVar.d == null) {
            bVar.d = new ArrayList<>();
            this.c.e = new p3<>();
        }
        this.c.d.add(animator);
        this.c.e.put(animator, str);
    }

    private void c(Animator animator) {
        ArrayList<Animator> childAnimations;
        if ((animator instanceof AnimatorSet) && (childAnimations = ((AnimatorSet) animator).getChildAnimations()) != null) {
            for (int i = 0; i < childAnimations.size(); i++) {
                c(childAnimations.get(i));
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.e == null) {
                    this.e = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.e);
            }
        }
    }

    @Override // defpackage.x0, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.b;
        if (drawable != null) {
            android.support.v4.graphics.drawable.a.a(drawable, theme);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.b;
        if (drawable != null) {
            return android.support.v4.graphics.drawable.a.b(drawable);
        }
        return false;
    }

    @Override // defpackage.x0, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        this.c.b.draw(canvas);
        if (this.c.c.isStarted()) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.b;
        if (drawable != null) {
            return android.support.v4.graphics.drawable.a.d(drawable);
        }
        return this.c.b.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.b;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.c.a;
    }

    @Override // defpackage.x0, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        Drawable drawable = this.b;
        if (drawable == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new c(drawable.getConstantState());
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
        return this.c.b.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.b;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return this.c.b.getIntrinsicWidth();
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
        return this.c.b.getOpacity();
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

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.b;
        if (drawable != null) {
            android.support.v4.graphics.drawable.a.g(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    TypedArray i = u2.i(resources, theme, attributeSet, r0.e);
                    int resourceId = i.getResourceId(0, 0);
                    if (resourceId != 0) {
                        y0 b2 = y0.b(resources, resourceId, theme);
                        b2.h(false);
                        b2.setCallback(this.h);
                        y0 y0Var = this.c.b;
                        if (y0Var != null) {
                            y0Var.setCallback(null);
                        }
                        this.c.b = b2;
                    }
                    i.recycle();
                } else if ("target".equals(name)) {
                    TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, r0.f);
                    String string = obtainAttributes.getString(0);
                    int resourceId2 = obtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        Context context = this.d;
                        if (context != null) {
                            b(string, u0.i(context, resourceId2));
                        } else {
                            obtainAttributes.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                    obtainAttributes.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
        this.c.a();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.b;
        if (drawable != null) {
            return android.support.v4.graphics.drawable.a.h(drawable);
        }
        return this.c.b.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        Drawable drawable = this.b;
        if (drawable != null) {
            return ((AnimatedVectorDrawable) drawable).isRunning();
        }
        return this.c.c.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        Drawable drawable = this.b;
        if (drawable != null) {
            return drawable.isStateful();
        }
        return this.c.b.isStateful();
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
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.c.b.setBounds(rect);
        }
    }

    @Override // defpackage.x0, android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        Drawable drawable = this.b;
        if (drawable != null) {
            return drawable.setLevel(i);
        }
        return this.c.b.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        Drawable drawable = this.b;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        return this.c.b.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.setAlpha(i);
        } else {
            this.c.b.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.b;
        if (drawable != null) {
            android.support.v4.graphics.drawable.a.j(drawable, z);
        } else {
            this.c.b.setAutoMirrored(z);
        }
    }

    @Override // defpackage.x0, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    @Override // defpackage.x0, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i, PorterDuff.Mode mode) {
        super.setColorFilter(i, mode);
    }

    @Override // defpackage.x0, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    @Override // defpackage.x0, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    @Override // defpackage.x0, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    @Override // defpackage.x0, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.b
    public void setTint(int i) {
        Drawable drawable = this.b;
        if (drawable != null) {
            android.support.v4.graphics.drawable.a.n(drawable, i);
        } else {
            this.c.b.setTint(i);
        }
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.b
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.b;
        if (drawable != null) {
            android.support.v4.graphics.drawable.a.o(drawable, colorStateList);
        } else {
            this.c.b.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.b
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.b;
        if (drawable != null) {
            android.support.v4.graphics.drawable.a.p(drawable, mode);
        } else {
            this.c.b.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.b;
        if (drawable != null) {
            return drawable.setVisible(z, z2);
        }
        this.c.b.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable drawable = this.b;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
        } else if (this.c.c.isStarted()) {
        } else {
            this.c.c.start();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        Drawable drawable = this.b;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.c.c.end();
        }
    }

    private s0(Context context) {
        this(context, null, null);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.c.b.setColorFilter(colorFilter);
        }
    }

    /* compiled from: AnimatedVectorDrawableCompat.java */
    /* renamed from: s0$c */
    /* loaded from: classes.dex */
    private static class c extends Drawable.ConstantState {
        private final Drawable.ConstantState a;

        public c(Drawable.ConstantState constantState) {
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
            s0 s0Var = new s0();
            Drawable newDrawable = this.a.newDrawable();
            s0Var.b = newDrawable;
            newDrawable.setCallback(s0Var.h);
            return s0Var;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            s0 s0Var = new s0();
            Drawable newDrawable = this.a.newDrawable(resources);
            s0Var.b = newDrawable;
            newDrawable.setCallback(s0Var.h);
            return s0Var;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            s0 s0Var = new s0();
            Drawable newDrawable = this.a.newDrawable(resources, theme);
            s0Var.b = newDrawable;
            newDrawable.setCallback(s0Var.h);
            return s0Var;
        }
    }

    private s0(Context context, b bVar, Resources resources) {
        this.e = null;
        this.f = null;
        this.g = null;
        a aVar = new a();
        this.h = aVar;
        this.d = context;
        if (bVar != null) {
            this.c = bVar;
        } else {
            this.c = new b(context, bVar, aVar, resources);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        inflate(resources, xmlPullParser, attributeSet, null);
    }
}
