package defpackage;

import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import defpackage.l1;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.io.IOUtils;
/* compiled from: TransitionSet.java */
/* renamed from: p1  reason: default package */
/* loaded from: classes.dex */
public class p1 extends l1 {
    int N;
    private ArrayList<l1> L = new ArrayList<>();
    private boolean M = true;
    boolean O = false;
    private int P = 0;

    /* compiled from: TransitionSet.java */
    /* renamed from: p1$a */
    /* loaded from: classes.dex */
    class a extends m1 {
        final /* synthetic */ l1 a;

        a(l1 l1Var) {
            this.a = l1Var;
        }

        @Override // defpackage.l1.f
        public void b(l1 l1Var) {
            this.a.S();
            l1Var.O(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TransitionSet.java */
    /* renamed from: p1$b */
    /* loaded from: classes.dex */
    public static class b extends m1 {
        p1 a;

        b(p1 p1Var) {
            this.a = p1Var;
        }

        @Override // defpackage.l1.f
        public void b(l1 l1Var) {
            p1 p1Var = this.a;
            int i = p1Var.N - 1;
            p1Var.N = i;
            if (i == 0) {
                p1Var.O = false;
                p1Var.o();
            }
            l1Var.O(this);
        }

        @Override // defpackage.m1, defpackage.l1.f
        public void c(l1 l1Var) {
            p1 p1Var = this.a;
            if (p1Var.O) {
                return;
            }
            p1Var.Z();
            this.a.O = true;
        }
    }

    private void m0() {
        b bVar = new b(this);
        Iterator<l1> it = this.L.iterator();
        while (it.hasNext()) {
            it.next().a(bVar);
        }
        this.N = this.L.size();
    }

    @Override // defpackage.l1
    public void M(View view) {
        super.M(view);
        int size = this.L.size();
        for (int i = 0; i < size; i++) {
            this.L.get(i).M(view);
        }
    }

    @Override // defpackage.l1
    public void Q(View view) {
        super.Q(view);
        int size = this.L.size();
        for (int i = 0; i < size; i++) {
            this.L.get(i).Q(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.l1
    public void S() {
        if (this.L.isEmpty()) {
            Z();
            o();
            return;
        }
        m0();
        if (!this.M) {
            for (int i = 1; i < this.L.size(); i++) {
                this.L.get(i - 1).a(new a(this.L.get(i)));
            }
            l1 l1Var = this.L.get(0);
            if (l1Var != null) {
                l1Var.S();
                return;
            }
            return;
        }
        Iterator<l1> it = this.L.iterator();
        while (it.hasNext()) {
            it.next().S();
        }
    }

    @Override // defpackage.l1
    public void U(l1.e eVar) {
        super.U(eVar);
        this.P |= 8;
        int size = this.L.size();
        for (int i = 0; i < size; i++) {
            this.L.get(i).U(eVar);
        }
    }

    @Override // defpackage.l1
    public void W(f1 f1Var) {
        super.W(f1Var);
        this.P |= 4;
        for (int i = 0; i < this.L.size(); i++) {
            this.L.get(i).W(f1Var);
        }
    }

    @Override // defpackage.l1
    public void X(o1 o1Var) {
        super.X(o1Var);
        this.P |= 2;
        int size = this.L.size();
        for (int i = 0; i < size; i++) {
            this.L.get(i).X(o1Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // defpackage.l1
    public String a0(String str) {
        String a0 = super.a0(str);
        for (int i = 0; i < this.L.size(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(a0);
            sb.append(IOUtils.LINE_SEPARATOR_UNIX);
            sb.append(this.L.get(i).a0(str + "  "));
            a0 = sb.toString();
        }
        return a0;
    }

    @Override // defpackage.l1
    /* renamed from: b0 */
    public p1 a(l1.f fVar) {
        return (p1) super.a(fVar);
    }

    @Override // defpackage.l1
    /* renamed from: c0 */
    public p1 b(View view) {
        for (int i = 0; i < this.L.size(); i++) {
            this.L.get(i).b(view);
        }
        return (p1) super.b(view);
    }

    public p1 d0(l1 l1Var) {
        this.L.add(l1Var);
        l1Var.v = this;
        long j = this.g;
        if (j >= 0) {
            l1Var.T(j);
        }
        if ((this.P & 1) != 0) {
            l1Var.V(r());
        }
        if ((this.P & 2) != 0) {
            l1Var.X(v());
        }
        if ((this.P & 4) != 0) {
            l1Var.W(u());
        }
        if ((this.P & 8) != 0) {
            l1Var.U(q());
        }
        return this;
    }

    public l1 e0(int i) {
        if (i < 0 || i >= this.L.size()) {
            return null;
        }
        return this.L.get(i);
    }

    @Override // defpackage.l1
    public void f(r1 r1Var) {
        if (F(r1Var.b)) {
            Iterator<l1> it = this.L.iterator();
            while (it.hasNext()) {
                l1 next = it.next();
                if (next.F(r1Var.b)) {
                    next.f(r1Var);
                    r1Var.c.add(next);
                }
            }
        }
    }

    public int f0() {
        return this.L.size();
    }

    @Override // defpackage.l1
    /* renamed from: g0 */
    public p1 O(l1.f fVar) {
        return (p1) super.O(fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // defpackage.l1
    public void h(r1 r1Var) {
        super.h(r1Var);
        int size = this.L.size();
        for (int i = 0; i < size; i++) {
            this.L.get(i).h(r1Var);
        }
    }

    @Override // defpackage.l1
    /* renamed from: h0 */
    public p1 P(View view) {
        for (int i = 0; i < this.L.size(); i++) {
            this.L.get(i).P(view);
        }
        return (p1) super.P(view);
    }

    @Override // defpackage.l1
    public void i(r1 r1Var) {
        if (F(r1Var.b)) {
            Iterator<l1> it = this.L.iterator();
            while (it.hasNext()) {
                l1 next = it.next();
                if (next.F(r1Var.b)) {
                    next.i(r1Var);
                    r1Var.c.add(next);
                }
            }
        }
    }

    @Override // defpackage.l1
    /* renamed from: i0 */
    public p1 T(long j) {
        super.T(j);
        if (this.g >= 0) {
            int size = this.L.size();
            for (int i = 0; i < size; i++) {
                this.L.get(i).T(j);
            }
        }
        return this;
    }

    @Override // defpackage.l1
    /* renamed from: j0 */
    public p1 V(TimeInterpolator timeInterpolator) {
        this.P |= 1;
        ArrayList<l1> arrayList = this.L;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.L.get(i).V(timeInterpolator);
            }
        }
        return (p1) super.V(timeInterpolator);
    }

    public p1 k0(int i) {
        if (i == 0) {
            this.M = true;
        } else if (i == 1) {
            this.M = false;
        } else {
            throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i);
        }
        return this;
    }

    @Override // defpackage.l1
    /* renamed from: l */
    public l1 clone() {
        p1 p1Var = (p1) super.clone();
        p1Var.L = new ArrayList<>();
        int size = this.L.size();
        for (int i = 0; i < size; i++) {
            p1Var.d0(this.L.get(i).clone());
        }
        return p1Var;
    }

    @Override // defpackage.l1
    /* renamed from: l0 */
    public p1 Y(long j) {
        return (p1) super.Y(j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.l1
    public void n(ViewGroup viewGroup, s1 s1Var, s1 s1Var2, ArrayList<r1> arrayList, ArrayList<r1> arrayList2) {
        long x = x();
        int size = this.L.size();
        for (int i = 0; i < size; i++) {
            l1 l1Var = this.L.get(i);
            if (x > 0 && (this.M || i == 0)) {
                long x2 = l1Var.x();
                if (x2 > 0) {
                    l1Var.Y(x2 + x);
                } else {
                    l1Var.Y(x);
                }
            }
            l1Var.n(viewGroup, s1Var, s1Var2, arrayList, arrayList2);
        }
    }
}
