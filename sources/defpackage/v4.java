package defpackage;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.SparseArray;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.WindowManager;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: ViewCompat.java */
/* renamed from: v4  reason: default package */
/* loaded from: classes.dex */
public class v4 {
    private static Field b;
    private static boolean c;
    private static Field d;
    private static boolean e;
    private static WeakHashMap<View, String> f;
    private static ThreadLocal<Rect> i;
    private static final AtomicInteger a = new AtomicInteger(1);
    private static WeakHashMap<View, z4> g = null;
    private static boolean h = false;

    /* compiled from: ViewCompat.java */
    /* renamed from: v4$a */
    /* loaded from: classes.dex */
    static class a implements View.OnApplyWindowInsetsListener {
        final /* synthetic */ t4 a;

        a(t4 t4Var) {
            this.a = t4Var;
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            return (WindowInsets) a5.f(this.a.a(view, a5.g(windowInsets)));
        }
    }

    /* compiled from: ViewCompat.java */
    /* renamed from: v4$b */
    /* loaded from: classes.dex */
    public interface b {
        boolean a(View view, KeyEvent keyEvent);
    }

    /* compiled from: ViewCompat.java */
    /* renamed from: v4$c */
    /* loaded from: classes.dex */
    static class c {
        private static final ArrayList<WeakReference<View>> a = new ArrayList<>();
        private WeakHashMap<View, Boolean> b = null;
        private SparseArray<WeakReference<View>> c = null;
        private WeakReference<KeyEvent> d = null;

        c() {
        }

        static c a(View view) {
            int i = g.b;
            c cVar = (c) view.getTag(i);
            if (cVar == null) {
                c cVar2 = new c();
                view.setTag(i, cVar2);
                return cVar2;
            }
            return cVar;
        }

        private View c(View view, KeyEvent keyEvent) {
            WeakHashMap<View, Boolean> weakHashMap = this.b;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        View c = c(viewGroup.getChildAt(childCount), keyEvent);
                        if (c != null) {
                            return c;
                        }
                    }
                }
                if (e(view, keyEvent)) {
                    return view;
                }
            }
            return null;
        }

        private SparseArray<WeakReference<View>> d() {
            if (this.c == null) {
                this.c = new SparseArray<>();
            }
            return this.c;
        }

        private boolean e(View view, KeyEvent keyEvent) {
            ArrayList arrayList = (ArrayList) view.getTag(g.c);
            if (arrayList != null) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (((b) arrayList.get(size)).a(view, keyEvent)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }

        private void g() {
            WeakHashMap<View, Boolean> weakHashMap = this.b;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList<WeakReference<View>> arrayList = a;
            if (arrayList.isEmpty()) {
                return;
            }
            synchronized (arrayList) {
                if (this.b == null) {
                    this.b = new WeakHashMap<>();
                }
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ArrayList<WeakReference<View>> arrayList2 = a;
                    View view = arrayList2.get(size).get();
                    if (view == null) {
                        arrayList2.remove(size);
                    } else {
                        this.b.put(view, Boolean.TRUE);
                        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                            this.b.put((View) parent, Boolean.TRUE);
                        }
                    }
                }
            }
        }

        boolean b(View view, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                g();
            }
            View c = c(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (c != null && !KeyEvent.isModifierKey(keyCode)) {
                    d().put(keyCode, new WeakReference<>(c));
                }
            }
            return c != null;
        }

        boolean f(KeyEvent keyEvent) {
            int indexOfKey;
            WeakReference<KeyEvent> weakReference = this.d;
            if (weakReference == null || weakReference.get() != keyEvent) {
                this.d = new WeakReference<>(keyEvent);
                WeakReference<View> weakReference2 = null;
                SparseArray<WeakReference<View>> d = d();
                if (keyEvent.getAction() == 1 && (indexOfKey = d.indexOfKey(keyEvent.getKeyCode())) >= 0) {
                    weakReference2 = d.valueAt(indexOfKey);
                    d.removeAt(indexOfKey);
                }
                if (weakReference2 == null) {
                    weakReference2 = d.get(keyEvent.getKeyCode());
                }
                if (weakReference2 != null) {
                    View view = weakReference2.get();
                    if (view != null && v4.y(view)) {
                        e(view, keyEvent);
                    }
                    return true;
                }
                return false;
            }
            return false;
        }
    }

    public static boolean A(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.isNestedScrollingEnabled();
        }
        if (view instanceof o4) {
            return ((o4) view).isNestedScrollingEnabled();
        }
        return false;
    }

    public static boolean B(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.isPaddingRelative();
        }
        return false;
    }

    public static void C(View view, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 23) {
            view.offsetLeftAndRight(i2);
        } else if (i3 >= 21) {
            Rect j = j();
            boolean z = false;
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                j.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z = !j.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
            a(view, i2);
            if (z && j.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(j);
            }
        } else {
            a(view, i2);
        }
    }

    public static void D(View view, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 23) {
            view.offsetTopAndBottom(i2);
        } else if (i3 >= 21) {
            Rect j = j();
            boolean z = false;
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                j.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z = !j.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
            b(view, i2);
            if (z && j.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(j);
            }
        } else {
            b(view, i2);
        }
    }

    public static void E(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postInvalidateOnAnimation();
        } else {
            view.postInvalidate();
        }
    }

    public static void F(View view, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimation(runnable);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay());
        }
    }

    public static void G(View view, Runnable runnable, long j) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimationDelayed(runnable, j);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay() + j);
        }
    }

    public static void H(View view) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 20) {
            view.requestApplyInsets();
        } else if (i2 >= 16) {
            view.requestFitSystemWindows();
        }
    }

    public static void I(View view, f4 f4Var) {
        view.setAccessibilityDelegate(f4Var == null ? null : f4Var.c());
    }

    public static void J(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    public static void K(View view, ColorStateList colorStateList) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            view.setBackgroundTintList(colorStateList);
            if (i2 == 21) {
                Drawable background = view.getBackground();
                boolean z = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
                if (background == null || !z) {
                    return;
                }
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                view.setBackground(background);
            }
        } else if (view instanceof u4) {
            ((u4) view).setSupportBackgroundTintList(colorStateList);
        }
    }

    public static void L(View view, PorterDuff.Mode mode) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            view.setBackgroundTintMode(mode);
            if (i2 == 21) {
                Drawable background = view.getBackground();
                boolean z = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
                if (background == null || !z) {
                    return;
                }
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                view.setBackground(background);
            }
        } else if (view instanceof u4) {
            ((u4) view).setSupportBackgroundTintMode(mode);
        }
    }

    public static void M(View view, Rect rect) {
        if (Build.VERSION.SDK_INT >= 18) {
            view.setClipBounds(rect);
        }
    }

    public static void N(View view, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setElevation(f2);
        }
    }

    @Deprecated
    public static void O(View view, boolean z) {
        view.setFitsSystemWindows(z);
    }

    public static void P(View view, boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setHasTransientState(z);
        }
    }

    public static void Q(View view, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 19) {
            view.setImportantForAccessibility(i2);
        } else if (i3 >= 16) {
            if (i2 == 4) {
                i2 = 2;
            }
            view.setImportantForAccessibility(i2);
        }
    }

    public static void R(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setImportantForAutofill(i2);
        }
    }

    public static void S(View view, t4 t4Var) {
        if (Build.VERSION.SDK_INT >= 21) {
            if (t4Var == null) {
                view.setOnApplyWindowInsetsListener(null);
            } else {
                view.setOnApplyWindowInsetsListener(new a(t4Var));
            }
        }
    }

    public static void T(View view, int i2, int i3, int i4, int i5) {
        if (Build.VERSION.SDK_INT >= 17) {
            view.setPaddingRelative(i2, i3, i4, i5);
        } else {
            view.setPadding(i2, i3, i4, i5);
        }
    }

    public static void U(View view, String str) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setTransitionName(str);
            return;
        }
        if (f == null) {
            f = new WeakHashMap<>();
        }
        f.put(view, str);
    }

    public static void V(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.stopNestedScroll();
        } else if (view instanceof o4) {
            ((o4) view).stopNestedScroll();
        }
    }

    public static void W(View view, int i2) {
        if (view instanceof n4) {
            ((n4) view).f(i2);
        } else if (i2 == 0) {
            V(view);
        }
    }

    private static void X(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }

    private static void a(View view, int i2) {
        view.offsetLeftAndRight(i2);
        if (view.getVisibility() == 0) {
            X(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                X((View) parent);
            }
        }
    }

    private static void b(View view, int i2) {
        view.offsetTopAndBottom(i2);
        if (view.getVisibility() == 0) {
            X(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                X((View) parent);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return c.a(view).b(view, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean d(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return c.a(view).f(keyEvent);
    }

    public static ColorStateList e(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintList();
        }
        if (view instanceof u4) {
            return ((u4) view).getSupportBackgroundTintList();
        }
        return null;
    }

    public static PorterDuff.Mode f(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintMode();
        }
        if (view instanceof u4) {
            return ((u4) view).getSupportBackgroundTintMode();
        }
        return null;
    }

    public static Rect g(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return view.getClipBounds();
        }
        return null;
    }

    public static Display h(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getDisplay();
        }
        if (y(view)) {
            return ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay();
        }
        return null;
    }

    public static float i(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getElevation();
        }
        return 0.0f;
    }

    private static Rect j() {
        if (i == null) {
            i = new ThreadLocal<>();
        }
        Rect rect = i.get();
        if (rect == null) {
            rect = new Rect();
            i.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    public static boolean k(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getFitsSystemWindows();
        }
        return false;
    }

    public static int l(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getImportantForAccessibility();
        }
        return 0;
    }

    @SuppressLint({"InlinedApi"})
    public static int m(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return view.getImportantForAutofill();
        }
        return 0;
    }

    public static int n(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getLayoutDirection();
        }
        return 0;
    }

    public static int o(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumHeight();
        }
        if (!e) {
            try {
                Field declaredField = View.class.getDeclaredField("mMinHeight");
                d = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            e = true;
        }
        Field field = d;
        if (field != null) {
            try {
                return ((Integer) field.get(view)).intValue();
            } catch (Exception unused2) {
                return 0;
            }
        }
        return 0;
    }

    public static int p(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumWidth();
        }
        if (!c) {
            try {
                Field declaredField = View.class.getDeclaredField("mMinWidth");
                b = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            c = true;
        }
        Field field = b;
        if (field != null) {
            try {
                return ((Integer) field.get(view)).intValue();
            } catch (Exception unused2) {
                return 0;
            }
        }
        return 0;
    }

    public static int q(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getPaddingEnd();
        }
        return view.getPaddingRight();
    }

    public static int r(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getPaddingStart();
        }
        return view.getPaddingLeft();
    }

    public static String s(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getTransitionName();
        }
        WeakHashMap<View, String> weakHashMap = f;
        if (weakHashMap == null) {
            return null;
        }
        return weakHashMap.get(view);
    }

    public static int t(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getWindowSystemUiVisibility();
        }
        return 0;
    }

    public static float u(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getZ();
        }
        return 0.0f;
    }

    public static boolean v(View view) {
        if (Build.VERSION.SDK_INT >= 15) {
            return view.hasOnClickListeners();
        }
        return false;
    }

    public static boolean w(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.hasOverlappingRendering();
        }
        return true;
    }

    public static boolean x(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.hasTransientState();
        }
        return false;
    }

    public static boolean y(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.isAttachedToWindow();
        }
        return view.getWindowToken() != null;
    }

    public static boolean z(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.isLaidOut();
        }
        return view.getWidth() > 0 && view.getHeight() > 0;
    }
}
