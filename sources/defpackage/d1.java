package defpackage;

import android.graphics.Rect;
import android.support.v4.app.r;
import android.view.View;
import android.view.ViewGroup;
import defpackage.l1;
import java.util.ArrayList;
import java.util.List;
/* compiled from: FragmentTransitionSupport.java */
/* renamed from: d1  reason: default package */
/* loaded from: classes.dex */
public class d1 extends r {

    /* compiled from: FragmentTransitionSupport.java */
    /* renamed from: d1$a */
    /* loaded from: classes.dex */
    class a extends l1.e {
        final /* synthetic */ Rect a;

        a(Rect rect) {
            this.a = rect;
        }
    }

    /* compiled from: FragmentTransitionSupport.java */
    /* renamed from: d1$b */
    /* loaded from: classes.dex */
    class b implements l1.f {
        final /* synthetic */ View a;
        final /* synthetic */ ArrayList b;

        b(View view, ArrayList arrayList) {
            this.a = view;
            this.b = arrayList;
        }

        @Override // defpackage.l1.f
        public void a(l1 l1Var) {
        }

        @Override // defpackage.l1.f
        public void b(l1 l1Var) {
            l1Var.O(this);
            this.a.setVisibility(8);
            int size = this.b.size();
            for (int i = 0; i < size; i++) {
                ((View) this.b.get(i)).setVisibility(0);
            }
        }

        @Override // defpackage.l1.f
        public void c(l1 l1Var) {
        }

        @Override // defpackage.l1.f
        public void d(l1 l1Var) {
        }
    }

    /* compiled from: FragmentTransitionSupport.java */
    /* renamed from: d1$c */
    /* loaded from: classes.dex */
    class c implements l1.f {
        final /* synthetic */ Object a;
        final /* synthetic */ ArrayList b;
        final /* synthetic */ Object c;
        final /* synthetic */ ArrayList d;
        final /* synthetic */ Object e;
        final /* synthetic */ ArrayList f;

        c(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.a = obj;
            this.b = arrayList;
            this.c = obj2;
            this.d = arrayList2;
            this.e = obj3;
            this.f = arrayList3;
        }

        @Override // defpackage.l1.f
        public void a(l1 l1Var) {
        }

        @Override // defpackage.l1.f
        public void b(l1 l1Var) {
        }

        @Override // defpackage.l1.f
        public void c(l1 l1Var) {
            Object obj = this.a;
            if (obj != null) {
                d1.this.q(obj, this.b, null);
            }
            Object obj2 = this.c;
            if (obj2 != null) {
                d1.this.q(obj2, this.d, null);
            }
            Object obj3 = this.e;
            if (obj3 != null) {
                d1.this.q(obj3, this.f, null);
            }
        }

        @Override // defpackage.l1.f
        public void d(l1 l1Var) {
        }
    }

    /* compiled from: FragmentTransitionSupport.java */
    /* renamed from: d1$d */
    /* loaded from: classes.dex */
    class d extends l1.e {
        final /* synthetic */ Rect a;

        d(Rect rect) {
            this.a = rect;
        }
    }

    private static boolean B(l1 l1Var) {
        return (r.l(l1Var.y()) && r.l(l1Var.z()) && r.l(l1Var.A())) ? false : true;
    }

    @Override // android.support.v4.app.r
    public Object A(Object obj) {
        if (obj == null) {
            return null;
        }
        p1 p1Var = new p1();
        p1Var.d0((l1) obj);
        return p1Var;
    }

    @Override // android.support.v4.app.r
    public void a(Object obj, View view) {
        if (obj != null) {
            ((l1) obj).b(view);
        }
    }

    @Override // android.support.v4.app.r
    public void b(Object obj, ArrayList<View> arrayList) {
        l1 l1Var = (l1) obj;
        if (l1Var == null) {
            return;
        }
        int i = 0;
        if (l1Var instanceof p1) {
            p1 p1Var = (p1) l1Var;
            int f0 = p1Var.f0();
            while (i < f0) {
                b(p1Var.e0(i), arrayList);
                i++;
            }
        } else if (B(l1Var) || !r.l(l1Var.B())) {
        } else {
            int size = arrayList.size();
            while (i < size) {
                l1Var.b(arrayList.get(i));
                i++;
            }
        }
    }

    @Override // android.support.v4.app.r
    public void c(ViewGroup viewGroup, Object obj) {
        n1.a(viewGroup, (l1) obj);
    }

    @Override // android.support.v4.app.r
    public boolean e(Object obj) {
        return obj instanceof l1;
    }

    @Override // android.support.v4.app.r
    public Object g(Object obj) {
        if (obj != null) {
            return ((l1) obj).clone();
        }
        return null;
    }

    @Override // android.support.v4.app.r
    public Object m(Object obj, Object obj2, Object obj3) {
        l1 l1Var = (l1) obj;
        l1 l1Var2 = (l1) obj2;
        l1 l1Var3 = (l1) obj3;
        if (l1Var != null && l1Var2 != null) {
            l1Var = new p1().d0(l1Var).d0(l1Var2).k0(1);
        } else if (l1Var == null) {
            l1Var = l1Var2 != null ? l1Var2 : null;
        }
        if (l1Var3 != null) {
            p1 p1Var = new p1();
            if (l1Var != null) {
                p1Var.d0(l1Var);
            }
            p1Var.d0(l1Var3);
            return p1Var;
        }
        return l1Var;
    }

    @Override // android.support.v4.app.r
    public Object n(Object obj, Object obj2, Object obj3) {
        p1 p1Var = new p1();
        if (obj != null) {
            p1Var.d0((l1) obj);
        }
        if (obj2 != null) {
            p1Var.d0((l1) obj2);
        }
        if (obj3 != null) {
            p1Var.d0((l1) obj3);
        }
        return p1Var;
    }

    @Override // android.support.v4.app.r
    public void p(Object obj, View view) {
        if (obj != null) {
            ((l1) obj).P(view);
        }
    }

    @Override // android.support.v4.app.r
    public void q(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        l1 l1Var = (l1) obj;
        int i = 0;
        if (l1Var instanceof p1) {
            p1 p1Var = (p1) l1Var;
            int f0 = p1Var.f0();
            while (i < f0) {
                q(p1Var.e0(i), arrayList, arrayList2);
                i++;
            }
        } else if (!B(l1Var)) {
            List<View> B = l1Var.B();
            if (B.size() == arrayList.size() && B.containsAll(arrayList)) {
                int size = arrayList2 == null ? 0 : arrayList2.size();
                while (i < size) {
                    l1Var.b(arrayList2.get(i));
                    i++;
                }
                for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                    l1Var.P(arrayList.get(size2));
                }
            }
        }
    }

    @Override // android.support.v4.app.r
    public void r(Object obj, View view, ArrayList<View> arrayList) {
        ((l1) obj).a(new b(view, arrayList));
    }

    @Override // android.support.v4.app.r
    public void t(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        ((l1) obj).a(new c(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    @Override // android.support.v4.app.r
    public void u(Object obj, Rect rect) {
        if (obj != null) {
            ((l1) obj).U(new d(rect));
        }
    }

    @Override // android.support.v4.app.r
    public void v(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            k(view, rect);
            ((l1) obj).U(new a(rect));
        }
    }

    @Override // android.support.v4.app.r
    public void y(Object obj, View view, ArrayList<View> arrayList) {
        p1 p1Var = (p1) obj;
        List<View> B = p1Var.B();
        B.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            r.d(B, arrayList.get(i));
        }
        B.add(view);
        arrayList.add(view);
        b(p1Var, arrayList);
    }

    @Override // android.support.v4.app.r
    public void z(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        p1 p1Var = (p1) obj;
        if (p1Var != null) {
            p1Var.B().clear();
            p1Var.B().addAll(arrayList2);
            q(p1Var, arrayList, arrayList2);
        }
    }
}
