package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.graphics.Path;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* compiled from: Transition.java */
/* renamed from: l1  reason: default package */
/* loaded from: classes.dex */
public abstract class l1 implements Cloneable {
    private static final int[] b = {2, 1, 3, 4};
    private static final f1 c = new a();
    private static ThreadLocal<p3<Animator, d>> d = new ThreadLocal<>();
    o1 H;
    private e I;
    private p3<String, String> J;
    private ArrayList<r1> x;
    private ArrayList<r1> y;
    private String e = getClass().getName();
    private long f = -1;
    long g = -1;
    private TimeInterpolator h = null;
    ArrayList<Integer> i = new ArrayList<>();
    ArrayList<View> j = new ArrayList<>();
    private ArrayList<String> k = null;
    private ArrayList<Class> l = null;
    private ArrayList<Integer> m = null;
    private ArrayList<View> n = null;
    private ArrayList<Class> o = null;
    private ArrayList<String> p = null;
    private ArrayList<Integer> q = null;
    private ArrayList<View> r = null;
    private ArrayList<Class> s = null;
    private s1 t = new s1();
    private s1 u = new s1();
    p1 v = null;
    private int[] w = b;
    private ViewGroup z = null;
    boolean A = false;
    ArrayList<Animator> B = new ArrayList<>();
    private int C = 0;
    private boolean D = false;
    private boolean E = false;
    private ArrayList<f> F = null;
    private ArrayList<Animator> G = new ArrayList<>();
    private f1 K = c;

    /* compiled from: Transition.java */
    /* renamed from: l1$a */
    /* loaded from: classes.dex */
    static class a extends f1 {
        a() {
        }

        @Override // defpackage.f1
        public Path a(float f, float f2, float f3, float f4) {
            Path path = new Path();
            path.moveTo(f, f2);
            path.lineTo(f3, f4);
            return path;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Transition.java */
    /* renamed from: l1$b */
    /* loaded from: classes.dex */
    public class b extends AnimatorListenerAdapter {
        final /* synthetic */ p3 a;

        b(p3 p3Var) {
            this.a = p3Var;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.a.remove(animator);
            l1.this.B.remove(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            l1.this.B.add(animator);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Transition.java */
    /* renamed from: l1$c */
    /* loaded from: classes.dex */
    public class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            l1.this.o();
            animator.removeListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Transition.java */
    /* renamed from: l1$d */
    /* loaded from: classes.dex */
    public static class d {
        View a;
        String b;
        r1 c;
        k2 d;
        l1 e;

        d(View view, String str, l1 l1Var, k2 k2Var, r1 r1Var) {
            this.a = view;
            this.b = str;
            this.c = r1Var;
            this.d = k2Var;
            this.e = l1Var;
        }
    }

    /* compiled from: Transition.java */
    /* renamed from: l1$e */
    /* loaded from: classes.dex */
    public static abstract class e {
    }

    /* compiled from: Transition.java */
    /* renamed from: l1$f */
    /* loaded from: classes.dex */
    public interface f {
        void a(l1 l1Var);

        void b(l1 l1Var);

        void c(l1 l1Var);

        void d(l1 l1Var);
    }

    private static boolean G(r1 r1Var, r1 r1Var2, String str) {
        Object obj = r1Var.a.get(str);
        Object obj2 = r1Var2.a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return true ^ obj.equals(obj2);
    }

    private void H(p3<View, r1> p3Var, p3<View, r1> p3Var2, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            View valueAt = sparseArray.valueAt(i);
            if (valueAt != null && F(valueAt) && (view = sparseArray2.get(sparseArray.keyAt(i))) != null && F(view)) {
                r1 r1Var = p3Var.get(valueAt);
                r1 r1Var2 = p3Var2.get(view);
                if (r1Var != null && r1Var2 != null) {
                    this.x.add(r1Var);
                    this.y.add(r1Var2);
                    p3Var.remove(valueAt);
                    p3Var2.remove(view);
                }
            }
        }
    }

    private void I(p3<View, r1> p3Var, p3<View, r1> p3Var2) {
        r1 remove;
        View view;
        for (int size = p3Var.size() - 1; size >= 0; size--) {
            View i = p3Var.i(size);
            if (i != null && F(i) && (remove = p3Var2.remove(i)) != null && (view = remove.b) != null && F(view)) {
                this.x.add(p3Var.k(size));
                this.y.add(remove);
            }
        }
    }

    private void J(p3<View, r1> p3Var, p3<View, r1> p3Var2, u3<View> u3Var, u3<View> u3Var2) {
        View f2;
        int l = u3Var.l();
        for (int i = 0; i < l; i++) {
            View m = u3Var.m(i);
            if (m != null && F(m) && (f2 = u3Var2.f(u3Var.i(i))) != null && F(f2)) {
                r1 r1Var = p3Var.get(m);
                r1 r1Var2 = p3Var2.get(f2);
                if (r1Var != null && r1Var2 != null) {
                    this.x.add(r1Var);
                    this.y.add(r1Var2);
                    p3Var.remove(m);
                    p3Var2.remove(f2);
                }
            }
        }
    }

    private void K(p3<View, r1> p3Var, p3<View, r1> p3Var2, p3<String, View> p3Var3, p3<String, View> p3Var4) {
        View view;
        int size = p3Var3.size();
        for (int i = 0; i < size; i++) {
            View m = p3Var3.m(i);
            if (m != null && F(m) && (view = p3Var4.get(p3Var3.i(i))) != null && F(view)) {
                r1 r1Var = p3Var.get(m);
                r1 r1Var2 = p3Var2.get(view);
                if (r1Var != null && r1Var2 != null) {
                    this.x.add(r1Var);
                    this.y.add(r1Var2);
                    p3Var.remove(m);
                    p3Var2.remove(view);
                }
            }
        }
    }

    private void L(s1 s1Var, s1 s1Var2) {
        p3<View, r1> p3Var = new p3<>(s1Var.a);
        p3<View, r1> p3Var2 = new p3<>(s1Var2.a);
        int i = 0;
        while (true) {
            int[] iArr = this.w;
            if (i < iArr.length) {
                int i2 = iArr[i];
                if (i2 == 1) {
                    I(p3Var, p3Var2);
                } else if (i2 == 2) {
                    K(p3Var, p3Var2, s1Var.d, s1Var2.d);
                } else if (i2 == 3) {
                    H(p3Var, p3Var2, s1Var.b, s1Var2.b);
                } else if (i2 == 4) {
                    J(p3Var, p3Var2, s1Var.c, s1Var2.c);
                }
                i++;
            } else {
                c(p3Var, p3Var2);
                return;
            }
        }
    }

    private void R(Animator animator, p3<Animator, d> p3Var) {
        if (animator != null) {
            animator.addListener(new b(p3Var));
            e(animator);
        }
    }

    private void c(p3<View, r1> p3Var, p3<View, r1> p3Var2) {
        for (int i = 0; i < p3Var.size(); i++) {
            r1 m = p3Var.m(i);
            if (F(m.b)) {
                this.x.add(m);
                this.y.add(null);
            }
        }
        for (int i2 = 0; i2 < p3Var2.size(); i2++) {
            r1 m2 = p3Var2.m(i2);
            if (F(m2.b)) {
                this.y.add(m2);
                this.x.add(null);
            }
        }
    }

    private static void d(s1 s1Var, View view, r1 r1Var) {
        s1Var.a.put(view, r1Var);
        int id = view.getId();
        if (id >= 0) {
            if (s1Var.b.indexOfKey(id) >= 0) {
                s1Var.b.put(id, null);
            } else {
                s1Var.b.put(id, view);
            }
        }
        String s = v4.s(view);
        if (s != null) {
            if (s1Var.d.containsKey(s)) {
                s1Var.d.put(s, null);
            } else {
                s1Var.d.put(s, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (s1Var.c.h(itemIdAtPosition) >= 0) {
                    View f2 = s1Var.c.f(itemIdAtPosition);
                    if (f2 != null) {
                        v4.P(f2, false);
                        s1Var.c.j(itemIdAtPosition, null);
                        return;
                    }
                    return;
                }
                v4.P(view, true);
                s1Var.c.j(itemIdAtPosition, view);
            }
        }
    }

    private void g(View view, boolean z) {
        if (view == null) {
            return;
        }
        int id = view.getId();
        ArrayList<Integer> arrayList = this.m;
        if (arrayList == null || !arrayList.contains(Integer.valueOf(id))) {
            ArrayList<View> arrayList2 = this.n;
            if (arrayList2 == null || !arrayList2.contains(view)) {
                ArrayList<Class> arrayList3 = this.o;
                if (arrayList3 != null) {
                    int size = arrayList3.size();
                    for (int i = 0; i < size; i++) {
                        if (this.o.get(i).isInstance(view)) {
                            return;
                        }
                    }
                }
                if (view.getParent() instanceof ViewGroup) {
                    r1 r1Var = new r1();
                    r1Var.b = view;
                    if (z) {
                        i(r1Var);
                    } else {
                        f(r1Var);
                    }
                    r1Var.c.add(this);
                    h(r1Var);
                    if (z) {
                        d(this.t, view, r1Var);
                    } else {
                        d(this.u, view, r1Var);
                    }
                }
                if (view instanceof ViewGroup) {
                    ArrayList<Integer> arrayList4 = this.q;
                    if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id))) {
                        ArrayList<View> arrayList5 = this.r;
                        if (arrayList5 == null || !arrayList5.contains(view)) {
                            ArrayList<Class> arrayList6 = this.s;
                            if (arrayList6 != null) {
                                int size2 = arrayList6.size();
                                for (int i2 = 0; i2 < size2; i2++) {
                                    if (this.s.get(i2).isInstance(view)) {
                                        return;
                                    }
                                }
                            }
                            ViewGroup viewGroup = (ViewGroup) view;
                            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                                g(viewGroup.getChildAt(i3), z);
                            }
                        }
                    }
                }
            }
        }
    }

    private static p3<Animator, d> w() {
        p3<Animator, d> p3Var = d.get();
        if (p3Var == null) {
            p3<Animator, d> p3Var2 = new p3<>();
            d.set(p3Var2);
            return p3Var2;
        }
        return p3Var;
    }

    public List<Class> A() {
        return this.l;
    }

    public List<View> B() {
        return this.j;
    }

    public String[] C() {
        return null;
    }

    public r1 D(View view, boolean z) {
        p1 p1Var = this.v;
        if (p1Var != null) {
            return p1Var.D(view, z);
        }
        return (z ? this.t : this.u).a.get(view);
    }

    public boolean E(r1 r1Var, r1 r1Var2) {
        if (r1Var == null || r1Var2 == null) {
            return false;
        }
        String[] C = C();
        if (C != null) {
            for (String str : C) {
                if (!G(r1Var, r1Var2, str)) {
                }
            }
            return false;
        }
        for (String str2 : r1Var.a.keySet()) {
            if (G(r1Var, r1Var2, str2)) {
            }
        }
        return false;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean F(View view) {
        ArrayList<Class> arrayList;
        ArrayList<String> arrayList2;
        int id = view.getId();
        ArrayList<Integer> arrayList3 = this.m;
        if (arrayList3 == null || !arrayList3.contains(Integer.valueOf(id))) {
            ArrayList<View> arrayList4 = this.n;
            if (arrayList4 == null || !arrayList4.contains(view)) {
                ArrayList<Class> arrayList5 = this.o;
                if (arrayList5 != null) {
                    int size = arrayList5.size();
                    for (int i = 0; i < size; i++) {
                        if (this.o.get(i).isInstance(view)) {
                            return false;
                        }
                    }
                }
                if (this.p == null || v4.s(view) == null || !this.p.contains(v4.s(view))) {
                    if ((this.i.size() == 0 && this.j.size() == 0 && (((arrayList = this.l) == null || arrayList.isEmpty()) && ((arrayList2 = this.k) == null || arrayList2.isEmpty()))) || this.i.contains(Integer.valueOf(id)) || this.j.contains(view)) {
                        return true;
                    }
                    ArrayList<String> arrayList6 = this.k;
                    if (arrayList6 == null || !arrayList6.contains(v4.s(view))) {
                        if (this.l != null) {
                            for (int i2 = 0; i2 < this.l.size(); i2++) {
                                if (this.l.get(i2).isInstance(view)) {
                                    return true;
                                }
                            }
                        }
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public void M(View view) {
        if (this.E) {
            return;
        }
        p3<Animator, d> w = w();
        int size = w.size();
        k2 e2 = c2.e(view);
        for (int i = size - 1; i >= 0; i--) {
            d m = w.m(i);
            if (m.a != null && e2.equals(m.d)) {
                z0.b(w.i(i));
            }
        }
        ArrayList<f> arrayList = this.F;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.F.clone();
            int size2 = arrayList2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ((f) arrayList2.get(i2)).a(this);
            }
        }
        this.D = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void N(ViewGroup viewGroup) {
        d dVar;
        this.x = new ArrayList<>();
        this.y = new ArrayList<>();
        L(this.t, this.u);
        p3<Animator, d> w = w();
        int size = w.size();
        k2 e2 = c2.e(viewGroup);
        for (int i = size - 1; i >= 0; i--) {
            Animator i2 = w.i(i);
            if (i2 != null && (dVar = w.get(i2)) != null && dVar.a != null && e2.equals(dVar.d)) {
                r1 r1Var = dVar.c;
                View view = dVar.a;
                r1 D = D(view, true);
                r1 s = s(view, true);
                if (!(D == null && s == null) && dVar.e.E(r1Var, s)) {
                    if (!i2.isRunning() && !i2.isStarted()) {
                        w.remove(i2);
                    } else {
                        i2.cancel();
                    }
                }
            }
        }
        n(viewGroup, this.t, this.u, this.x, this.y);
        S();
    }

    public l1 O(f fVar) {
        ArrayList<f> arrayList = this.F;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(fVar);
        if (this.F.size() == 0) {
            this.F = null;
        }
        return this;
    }

    public l1 P(View view) {
        this.j.remove(view);
        return this;
    }

    public void Q(View view) {
        if (this.D) {
            if (!this.E) {
                p3<Animator, d> w = w();
                int size = w.size();
                k2 e2 = c2.e(view);
                for (int i = size - 1; i >= 0; i--) {
                    d m = w.m(i);
                    if (m.a != null && e2.equals(m.d)) {
                        z0.c(w.i(i));
                    }
                }
                ArrayList<f> arrayList = this.F;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.F.clone();
                    int size2 = arrayList2.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        ((f) arrayList2.get(i2)).d(this);
                    }
                }
            }
            this.D = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void S() {
        Z();
        p3<Animator, d> w = w();
        Iterator<Animator> it = this.G.iterator();
        while (it.hasNext()) {
            Animator next = it.next();
            if (w.containsKey(next)) {
                Z();
                R(next, w);
            }
        }
        this.G.clear();
        o();
    }

    public l1 T(long j) {
        this.g = j;
        return this;
    }

    public void U(e eVar) {
        this.I = eVar;
    }

    public l1 V(TimeInterpolator timeInterpolator) {
        this.h = timeInterpolator;
        return this;
    }

    public void W(f1 f1Var) {
        if (f1Var == null) {
            this.K = c;
        } else {
            this.K = f1Var;
        }
    }

    public void X(o1 o1Var) {
    }

    public l1 Y(long j) {
        this.f = j;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Z() {
        if (this.C == 0) {
            ArrayList<f> arrayList = this.F;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.F.clone();
                int size = arrayList2.size();
                for (int i = 0; i < size; i++) {
                    ((f) arrayList2.get(i)).c(this);
                }
            }
            this.E = false;
        }
        this.C++;
    }

    public l1 a(f fVar) {
        if (this.F == null) {
            this.F = new ArrayList<>();
        }
        this.F.add(fVar);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a0(String str) {
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.g != -1) {
            str2 = str2 + "dur(" + this.g + ") ";
        }
        if (this.f != -1) {
            str2 = str2 + "dly(" + this.f + ") ";
        }
        if (this.h != null) {
            str2 = str2 + "interp(" + this.h + ") ";
        }
        if (this.i.size() > 0 || this.j.size() > 0) {
            String str3 = str2 + "tgts(";
            if (this.i.size() > 0) {
                for (int i = 0; i < this.i.size(); i++) {
                    if (i > 0) {
                        str3 = str3 + ", ";
                    }
                    str3 = str3 + this.i.get(i);
                }
            }
            if (this.j.size() > 0) {
                for (int i2 = 0; i2 < this.j.size(); i2++) {
                    if (i2 > 0) {
                        str3 = str3 + ", ";
                    }
                    str3 = str3 + this.j.get(i2);
                }
            }
            return str3 + ")";
        }
        return str2;
    }

    public l1 b(View view) {
        this.j.add(view);
        return this;
    }

    protected void e(Animator animator) {
        if (animator == null) {
            o();
            return;
        }
        if (p() >= 0) {
            animator.setDuration(p());
        }
        if (x() >= 0) {
            animator.setStartDelay(x());
        }
        if (r() != null) {
            animator.setInterpolator(r());
        }
        animator.addListener(new c());
        animator.start();
    }

    public abstract void f(r1 r1Var);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(r1 r1Var) {
        if (this.H != null && !r1Var.a.isEmpty()) {
            throw null;
        }
    }

    public abstract void i(r1 r1Var);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(ViewGroup viewGroup, boolean z) {
        ArrayList<String> arrayList;
        ArrayList<Class> arrayList2;
        p3<String, String> p3Var;
        k(z);
        if ((this.i.size() <= 0 && this.j.size() <= 0) || (((arrayList = this.k) != null && !arrayList.isEmpty()) || ((arrayList2 = this.l) != null && !arrayList2.isEmpty()))) {
            g(viewGroup, z);
        } else {
            for (int i = 0; i < this.i.size(); i++) {
                View findViewById = viewGroup.findViewById(this.i.get(i).intValue());
                if (findViewById != null) {
                    r1 r1Var = new r1();
                    r1Var.b = findViewById;
                    if (z) {
                        i(r1Var);
                    } else {
                        f(r1Var);
                    }
                    r1Var.c.add(this);
                    h(r1Var);
                    if (z) {
                        d(this.t, findViewById, r1Var);
                    } else {
                        d(this.u, findViewById, r1Var);
                    }
                }
            }
            for (int i2 = 0; i2 < this.j.size(); i2++) {
                View view = this.j.get(i2);
                r1 r1Var2 = new r1();
                r1Var2.b = view;
                if (z) {
                    i(r1Var2);
                } else {
                    f(r1Var2);
                }
                r1Var2.c.add(this);
                h(r1Var2);
                if (z) {
                    d(this.t, view, r1Var2);
                } else {
                    d(this.u, view, r1Var2);
                }
            }
        }
        if (z || (p3Var = this.J) == null) {
            return;
        }
        int size = p3Var.size();
        ArrayList arrayList3 = new ArrayList(size);
        for (int i3 = 0; i3 < size; i3++) {
            arrayList3.add(this.t.d.remove(this.J.i(i3)));
        }
        for (int i4 = 0; i4 < size; i4++) {
            View view2 = (View) arrayList3.get(i4);
            if (view2 != null) {
                this.t.d.put(this.J.m(i4), view2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(boolean z) {
        if (z) {
            this.t.a.clear();
            this.t.b.clear();
            this.t.c.b();
            return;
        }
        this.u.a.clear();
        this.u.b.clear();
        this.u.c.b();
    }

    @Override // 
    /* renamed from: l */
    public l1 clone() {
        try {
            l1 l1Var = (l1) super.clone();
            l1Var.G = new ArrayList<>();
            l1Var.t = new s1();
            l1Var.u = new s1();
            l1Var.x = null;
            l1Var.y = null;
            return l1Var;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public Animator m(ViewGroup viewGroup, r1 r1Var, r1 r1Var2) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(ViewGroup viewGroup, s1 s1Var, s1 s1Var2, ArrayList<r1> arrayList, ArrayList<r1> arrayList2) {
        int i;
        View view;
        Animator animator;
        r1 r1Var;
        Animator animator2;
        r1 r1Var2;
        p3<Animator, d> w = w();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            r1 r1Var3 = arrayList.get(i2);
            r1 r1Var4 = arrayList2.get(i2);
            if (r1Var3 != null && !r1Var3.c.contains(this)) {
                r1Var3 = null;
            }
            if (r1Var4 != null && !r1Var4.c.contains(this)) {
                r1Var4 = null;
            }
            if (r1Var3 != null || r1Var4 != null) {
                if (r1Var3 == null || r1Var4 == null || E(r1Var3, r1Var4)) {
                    Animator m = m(viewGroup, r1Var3, r1Var4);
                    if (m != null) {
                        if (r1Var4 != null) {
                            View view2 = r1Var4.b;
                            String[] C = C();
                            if (view2 == null || C == null || C.length <= 0) {
                                i = size;
                                animator2 = m;
                                r1Var2 = null;
                            } else {
                                r1Var2 = new r1();
                                r1Var2.b = view2;
                                r1 r1Var5 = s1Var2.a.get(view2);
                                if (r1Var5 != null) {
                                    int i3 = 0;
                                    while (i3 < C.length) {
                                        r1Var2.a.put(C[i3], r1Var5.a.get(C[i3]));
                                        i3++;
                                        m = m;
                                        size = size;
                                        r1Var5 = r1Var5;
                                    }
                                }
                                Animator animator3 = m;
                                i = size;
                                int size2 = w.size();
                                int i4 = 0;
                                while (true) {
                                    if (i4 >= size2) {
                                        animator2 = animator3;
                                        break;
                                    }
                                    d dVar = w.get(w.i(i4));
                                    if (dVar.c != null && dVar.a == view2 && dVar.b.equals(t()) && dVar.c.equals(r1Var2)) {
                                        animator2 = null;
                                        break;
                                    }
                                    i4++;
                                }
                            }
                            view = view2;
                            animator = animator2;
                            r1Var = r1Var2;
                        } else {
                            i = size;
                            view = r1Var3.b;
                            animator = m;
                            r1Var = null;
                        }
                        if (animator == null) {
                            continue;
                        } else if (this.H == null) {
                            w.put(animator, new d(view, t(), this, c2.e(viewGroup), r1Var));
                            this.G.add(animator);
                        } else {
                            throw null;
                        }
                        i2++;
                        size = i;
                    }
                    i = size;
                    i2++;
                    size = i;
                }
            }
            i = size;
            i2++;
            size = i;
        }
        if (Long.MAX_VALUE != 0) {
            for (int i5 = 0; i5 < sparseIntArray.size(); i5++) {
                Animator animator4 = this.G.get(sparseIntArray.keyAt(i5));
                animator4.setStartDelay((sparseIntArray.valueAt(i5) - Long.MAX_VALUE) + animator4.getStartDelay());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o() {
        int i = this.C - 1;
        this.C = i;
        if (i == 0) {
            ArrayList<f> arrayList = this.F;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.F.clone();
                int size = arrayList2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((f) arrayList2.get(i2)).b(this);
                }
            }
            for (int i3 = 0; i3 < this.t.c.l(); i3++) {
                View m = this.t.c.m(i3);
                if (m != null) {
                    v4.P(m, false);
                }
            }
            for (int i4 = 0; i4 < this.u.c.l(); i4++) {
                View m2 = this.u.c.m(i4);
                if (m2 != null) {
                    v4.P(m2, false);
                }
            }
            this.E = true;
        }
    }

    public long p() {
        return this.g;
    }

    public e q() {
        return this.I;
    }

    public TimeInterpolator r() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public r1 s(View view, boolean z) {
        p1 p1Var = this.v;
        if (p1Var != null) {
            return p1Var.s(view, z);
        }
        ArrayList<r1> arrayList = z ? this.x : this.y;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i = -1;
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            r1 r1Var = arrayList.get(i2);
            if (r1Var == null) {
                return null;
            }
            if (r1Var.b == view) {
                i = i2;
                break;
            }
            i2++;
        }
        if (i >= 0) {
            return (z ? this.y : this.x).get(i);
        }
        return null;
    }

    public String t() {
        return this.e;
    }

    public String toString() {
        return a0("");
    }

    public f1 u() {
        return this.K;
    }

    public o1 v() {
        return this.H;
    }

    public long x() {
        return this.f;
    }

    public List<Integer> y() {
        return this.i;
    }

    public List<String> z() {
        return this.k;
    }
}
