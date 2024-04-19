package defpackage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.reflect.Method;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ViewOverlayApi14.java */
/* renamed from: z1  reason: default package */
/* loaded from: classes.dex */
public class z1 implements b2 {
    protected a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewOverlayApi14.java */
    /* renamed from: z1$a */
    /* loaded from: classes.dex */
    public static class a extends ViewGroup {
        static Method b;
        ViewGroup c;
        View d;
        ArrayList<Drawable> e;
        z1 f;

        static {
            try {
                Class cls = Integer.TYPE;
                b = ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", cls, cls, Rect.class);
            } catch (NoSuchMethodException unused) {
            }
        }

        a(Context context, ViewGroup viewGroup, View view, z1 z1Var) {
            super(context);
            this.e = null;
            this.c = viewGroup;
            this.d = view;
            setRight(viewGroup.getWidth());
            setBottom(viewGroup.getHeight());
            viewGroup.addView(this);
            this.f = z1Var;
        }

        private void c(int[] iArr) {
            int[] iArr2 = new int[2];
            int[] iArr3 = new int[2];
            this.c.getLocationOnScreen(iArr2);
            this.d.getLocationOnScreen(iArr3);
            iArr[0] = iArr3[0] - iArr2[0];
            iArr[1] = iArr3[1] - iArr2[1];
        }

        public void a(Drawable drawable) {
            if (this.e == null) {
                this.e = new ArrayList<>();
            }
            if (this.e.contains(drawable)) {
                return;
            }
            this.e.add(drawable);
            invalidate(drawable.getBounds());
            drawable.setCallback(this);
        }

        public void b(View view) {
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != this.c && viewGroup.getParent() != null && v4.y(viewGroup)) {
                    int[] iArr = new int[2];
                    int[] iArr2 = new int[2];
                    viewGroup.getLocationOnScreen(iArr);
                    this.c.getLocationOnScreen(iArr2);
                    v4.C(view, iArr[0] - iArr2[0]);
                    v4.D(view, iArr[1] - iArr2[1]);
                }
                viewGroup.removeView(view);
                if (view.getParent() != null) {
                    viewGroup.removeView(view);
                }
            }
            super.addView(view, getChildCount() - 1);
        }

        boolean d() {
            ArrayList<Drawable> arrayList;
            return getChildCount() == 0 && ((arrayList = this.e) == null || arrayList.size() == 0);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            this.c.getLocationOnScreen(iArr);
            this.d.getLocationOnScreen(iArr2);
            canvas.translate(iArr2[0] - iArr[0], iArr2[1] - iArr[1]);
            canvas.clipRect(new Rect(0, 0, this.d.getWidth(), this.d.getHeight()));
            super.dispatchDraw(canvas);
            ArrayList<Drawable> arrayList = this.e;
            int size = arrayList == null ? 0 : arrayList.size();
            for (int i = 0; i < size; i++) {
                this.e.get(i).draw(canvas);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        public void e(Drawable drawable) {
            ArrayList<Drawable> arrayList = this.e;
            if (arrayList != null) {
                arrayList.remove(drawable);
                invalidate(drawable.getBounds());
                drawable.setCallback(null);
            }
        }

        public void f(View view) {
            super.removeView(view);
            if (d()) {
                this.c.removeView(this);
            }
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
            if (this.c != null) {
                rect.offset(iArr[0], iArr[1]);
                if (this.c instanceof ViewGroup) {
                    iArr[0] = 0;
                    iArr[1] = 0;
                    int[] iArr2 = new int[2];
                    c(iArr2);
                    rect.offset(iArr2[0], iArr2[1]);
                    return super.invalidateChildInParent(iArr, rect);
                }
                invalidate(rect);
                return null;
            }
            return null;
        }

        @Override // android.view.View, android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            invalidate(drawable.getBounds());
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        }

        @Override // android.view.View
        protected boolean verifyDrawable(Drawable drawable) {
            ArrayList<Drawable> arrayList;
            return super.verifyDrawable(drawable) || ((arrayList = this.e) != null && arrayList.contains(drawable));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public z1(Context context, ViewGroup viewGroup, View view) {
        this.a = new a(context, viewGroup, view, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static z1 e(View view) {
        ViewGroup f = f(view);
        if (f != null) {
            int childCount = f.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = f.getChildAt(i);
                if (childAt instanceof a) {
                    return ((a) childAt).f;
                }
            }
            return new t1(f.getContext(), f, view);
        }
        return null;
    }

    static ViewGroup f(View view) {
        while (view != null) {
            if (view.getId() == 16908290 && (view instanceof ViewGroup)) {
                return (ViewGroup) view;
            }
            if (view.getParent() instanceof ViewGroup) {
                view = (ViewGroup) view.getParent();
            }
        }
        return null;
    }

    @Override // defpackage.b2
    public void b(Drawable drawable) {
        this.a.a(drawable);
    }

    @Override // defpackage.b2
    public void d(Drawable drawable) {
        this.a.e(drawable);
    }
}
