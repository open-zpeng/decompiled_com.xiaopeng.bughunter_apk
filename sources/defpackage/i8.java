package defpackage;

import android.app.Application;
import android.os.RemoteException;
import defpackage.f8;
import defpackage.h8;
import java.util.Map;
/* compiled from: Monitor.java */
/* renamed from: i8  reason: default package */
/* loaded from: classes.dex */
public class i8 extends h8.a {
    private Application a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i8(Application application) {
        this.a = application;
    }

    private s8 m0(int i) {
        return s8.a(i);
    }

    @Override // defpackage.h8
    public void B(String str, String str2, String str3) throws RemoteException {
        f8.d.f(str, str2, str3);
    }

    @Override // defpackage.h8
    public void C(int i) throws RemoteException {
        f8.c.d(i);
    }

    @Override // defpackage.h8
    public void E(int i) throws RemoteException {
        f8.d.h(i);
    }

    @Override // defpackage.h8
    public void G(boolean z, String str, String str2, String str3) throws RemoteException {
        f8.i(z, str, str2, str3);
    }

    @Override // defpackage.h8
    public void H() throws RemoteException {
        f8.m();
    }

    @Override // defpackage.h8
    public void I(String str, String str2, v9 v9Var, z9 z9Var, Map map) throws RemoteException {
        ya.c("Monitor", "[stat_commit3]");
        f8.d.e(str, str2, v9Var, z9Var, map);
    }

    @Override // defpackage.h8
    public void J(int i) throws RemoteException {
        f8.d.g(i);
    }

    @Override // defpackage.h8
    public void K(String str) throws RemoteException {
        f8.h(str);
    }

    @Override // defpackage.h8
    public void L(String str, String str2, double d, Map map) throws RemoteException {
        f8.d.c(str, str2, d, map);
    }

    @Override // defpackage.h8
    public void M(String str, String str2, x9 x9Var) throws RemoteException {
        f8.d(str, str2, x9Var);
    }

    @Override // defpackage.h8
    public void N(String str, String str2, String str3, String str4, Map map) throws RemoteException {
        f8.a.c(str, str2, str3, str4, map);
    }

    @Override // defpackage.h8
    public void O(String str, String str2, double d, Map map) throws RemoteException {
        f8.b.b(str, str2, d, map);
    }

    @Override // defpackage.h8
    public void P(String str, String str2, String str3, double d, Map map) throws RemoteException {
        f8.b.c(str, str2, str3, d, map);
    }

    @Override // defpackage.h8
    public void Q(int i) throws RemoteException {
        f8.c.c(i);
    }

    @Override // defpackage.h8
    public void R(Map map) throws RemoteException {
        f8.o(map);
    }

    @Override // defpackage.h8
    public void S(int i, int i2) throws RemoteException {
        f8.l(m0(i), i2);
    }

    @Override // defpackage.h8
    public void V(int i) throws RemoteException {
        f8.a.f(i);
    }

    @Override // defpackage.h8
    public void W(String str, String str2, v9 v9Var, double d, Map map) throws RemoteException {
        f8.d.d(str, str2, v9Var, d, map);
    }

    @Override // defpackage.h8
    public void X(int i) throws RemoteException {
        f8.k(i);
    }

    @Override // defpackage.h8
    public void Y(String str, String str2, x9 x9Var, u9 u9Var) throws RemoteException {
        f8.e(str, str2, x9Var, u9Var);
    }

    @Override // defpackage.h8
    public void b0(String str, String str2, String str3, String str4, String str5, Map map) throws RemoteException {
        f8.a.b(str, str2, str3, str4, str5, map);
    }

    @Override // defpackage.h8
    public void d0(int i) throws RemoteException {
        f8.b.d(i);
    }

    @Override // defpackage.h8
    public void destroy() throws RemoteException {
        f8.a();
    }

    @Override // defpackage.h8
    public void e0() throws RemoteException {
        f8.n();
    }

    @Override // defpackage.h8
    public void f(String str, String str2, double d) throws RemoteException {
        f8.c.b(str, str2, d);
    }

    @Override // defpackage.h8
    public void g(int i) throws RemoteException {
        f8.b.e(i);
    }

    @Override // defpackage.h8
    public void h(int i) throws RemoteException {
        f8.j(i);
    }

    @Override // defpackage.h8
    public boolean h0(String str, String str2) throws RemoteException {
        return f8.c.a(str, str2);
    }

    @Override // defpackage.h8
    public boolean i(String str, String str2) throws RemoteException {
        return f8.b.a(str, str2);
    }

    @Override // defpackage.h8
    public void init() throws RemoteException {
        f8.c(this.a);
    }

    @Override // defpackage.h8
    public void j(int i) throws RemoteException {
        f8.a.g(i);
    }

    @Override // defpackage.h8
    public void j0(String str, String str2, x9 x9Var, boolean z) throws RemoteException {
        f8.g(str, str2, x9Var, z);
    }

    @Override // defpackage.h8
    public void n(String str, String str2, String str3, Map map) throws RemoteException {
        f8.a.d(str, str2, str3, map);
    }

    @Override // defpackage.h8
    public void p(boolean z) throws RemoteException {
        f8.b(z);
    }

    @Override // defpackage.h8
    public void q(k8 k8Var, String str) throws RemoteException {
        l8.c(k8Var, str);
    }

    @Override // defpackage.h8
    public void t(String str, String str2, x9 x9Var, u9 u9Var, boolean z) throws RemoteException {
        f8.f(str, str2, x9Var, u9Var, z);
    }

    @Override // defpackage.h8
    public void v(String str, String str2, String str3) throws RemoteException {
        f8.d.a(str, str2, str3);
    }

    @Override // defpackage.h8
    public boolean w(String str, String str2) throws RemoteException {
        return f8.a.a(str, str2);
    }

    @Override // defpackage.h8
    public void x(String str, String str2, Map map) throws RemoteException {
        f8.a.e(str, str2, map);
    }

    @Override // defpackage.h8
    public boolean y(String str, String str2) throws RemoteException {
        return f8.d.b(str, str2);
    }

    @Override // defpackage.h8
    public void z(k8 k8Var, String str) throws RemoteException {
        l8.b(k8Var, str);
    }
}
