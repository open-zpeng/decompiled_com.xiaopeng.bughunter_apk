package defpackage;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
/* compiled from: TransitionManager.java */
/* renamed from: n1  reason: default package */
/* loaded from: classes.dex */
public class n1 {
    private static l1 a = new a1();
    private static ThreadLocal<WeakReference<p3<ViewGroup, ArrayList<l1>>>> b = new ThreadLocal<>();
    static ArrayList<ViewGroup> c = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TransitionManager.java */
    /* renamed from: n1$a */
    /* loaded from: classes.dex */
    public static class a implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {
        l1 b;
        ViewGroup c;

        /* compiled from: TransitionManager.java */
        /* renamed from: n1$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0044a extends m1 {
            final /* synthetic */ p3 a;

            C0044a(p3 p3Var) {
                this.a = p3Var;
            }

            @Override // defpackage.l1.f
            public void b(l1 l1Var) {
                ((ArrayList) this.a.get(a.this.c)).remove(l1Var);
            }
        }

        a(l1 l1Var, ViewGroup viewGroup) {
            this.b = l1Var;
            this.c = viewGroup;
        }

        private void a() {
            this.c.getViewTreeObserver().removeOnPreDrawListener(this);
            this.c.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            a();
            if (n1.c.remove(this.c)) {
                p3<ViewGroup, ArrayList<l1>> b = n1.b();
                ArrayList<l1> arrayList = b.get(this.c);
                ArrayList arrayList2 = null;
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    b.put(this.c, arrayList);
                } else if (arrayList.size() > 0) {
                    arrayList2 = new ArrayList(arrayList);
                }
                arrayList.add(this.b);
                this.b.a(new C0044a(b));
                this.b.j(this.c, false);
                if (arrayList2 != null) {
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        ((l1) it.next()).Q(this.c);
                    }
                }
                this.b.N(this.c);
                return true;
            }
            return true;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            a();
            n1.c.remove(this.c);
            ArrayList<l1> arrayList = n1.b().get(this.c);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<l1> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().Q(this.c);
                }
            }
            this.b.k(true);
        }
    }

    public static void a(ViewGroup viewGroup, l1 l1Var) {
        if (c.contains(viewGroup) || !v4.z(viewGroup)) {
            return;
        }
        c.add(viewGroup);
        if (l1Var == null) {
            l1Var = a;
        }
        l1 clone = l1Var.clone();
        d(viewGroup, clone);
        k1.c(viewGroup, null);
        c(viewGroup, clone);
    }

    static p3<ViewGroup, ArrayList<l1>> b() {
        p3<ViewGroup, ArrayList<l1>> p3Var;
        WeakReference<p3<ViewGroup, ArrayList<l1>>> weakReference = b.get();
        if (weakReference == null || (p3Var = weakReference.get()) == null) {
            p3<ViewGroup, ArrayList<l1>> p3Var2 = new p3<>();
            b.set(new WeakReference<>(p3Var2));
            return p3Var2;
        }
        return p3Var;
    }

    private static void c(ViewGroup viewGroup, l1 l1Var) {
        if (l1Var == null || viewGroup == null) {
            return;
        }
        a aVar = new a(l1Var, viewGroup);
        viewGroup.addOnAttachStateChangeListener(aVar);
        viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
    }

    private static void d(ViewGroup viewGroup, l1 l1Var) {
        ArrayList<l1> arrayList = b().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<l1> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().M(viewGroup);
            }
        }
        if (l1Var != null) {
            l1Var.j(viewGroup, true);
        }
        k1 b2 = k1.b(viewGroup);
        if (b2 != null) {
            b2.a();
        }
    }
}
