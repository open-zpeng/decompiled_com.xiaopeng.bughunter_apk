package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.Map;
/* compiled from: IMonitor.java */
/* renamed from: h8  reason: default package */
/* loaded from: classes.dex */
public interface h8 extends IInterface {

    /* compiled from: IMonitor.java */
    /* renamed from: h8$a */
    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements h8 {

        /* compiled from: IMonitor.java */
        /* renamed from: h8$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static class C0040a implements h8 {
            private IBinder a;

            C0040a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // defpackage.h8
            public void G(boolean z, String str, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.h8
            public void H() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    this.a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.h8
            public void K(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeString(str);
                    this.a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.h8
            public void R(Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeMap(map);
                    this.a.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // defpackage.h8
            public void e0() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    this.a.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.h8
            public void init() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.h8
            public void t(String str, String str2, x9 x9Var, u9 u9Var, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    int i = 1;
                    if (x9Var != null) {
                        obtain.writeInt(1);
                        x9Var.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (u9Var != null) {
                        obtain.writeInt(1);
                        u9Var.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.a.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.alibaba.mtl.appmonitor.IMonitor");
        }

        public static h8 l0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.alibaba.mtl.appmonitor.IMonitor");
            if (queryLocalInterface != null && (queryLocalInterface instanceof h8)) {
                return (h8) queryLocalInterface;
            }
            return new C0040a(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        init();
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        p(parcel.readInt() != 0);
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        G(parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        K(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        H();
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        h(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        X(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 8:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        S(parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 9:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        M(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? x9.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        return true;
                    case 10:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        j0(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? x9.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0);
                        parcel2.writeNoException();
                        return true;
                    case 11:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        Y(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? x9.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? u9.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        return true;
                    case 12:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        t(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? x9.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? u9.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0);
                        parcel2.writeNoException();
                        return true;
                    case 13:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        R(parcel.readHashMap(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        return true;
                    case 14:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        e0();
                        parcel2.writeNoException();
                        return true;
                    case 15:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        destroy();
                        parcel2.writeNoException();
                        return true;
                    case 16:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        g(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 17:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        d0(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 18:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        boolean i3 = i(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(i3 ? 1 : 0);
                        return true;
                    case 19:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        O(parcel.readString(), parcel.readString(), parcel.readDouble(), parcel.readHashMap(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        return true;
                    case 20:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        P(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readDouble(), parcel.readHashMap(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        return true;
                    case 21:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        C(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 22:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        Q(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 23:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        boolean h0 = h0(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(h0 ? 1 : 0);
                        return true;
                    case 24:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        f(parcel.readString(), parcel.readString(), parcel.readDouble());
                        parcel2.writeNoException();
                        return true;
                    case 25:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        j(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 26:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        V(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 27:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        boolean w = w(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(w ? 1 : 0);
                        return true;
                    case 28:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        x(parcel.readString(), parcel.readString(), parcel.readHashMap(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        return true;
                    case 29:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        n(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readHashMap(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        return true;
                    case 30:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        N(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readHashMap(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        return true;
                    case 31:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        b0(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readHashMap(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        return true;
                    case 32:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        v(parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 33:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        B(parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 34:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        E(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 35:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        J(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 36:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        boolean y = y(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(y ? 1 : 0);
                        return true;
                    case 37:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        L(parcel.readString(), parcel.readString(), parcel.readDouble(), parcel.readHashMap(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        return true;
                    case 38:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        W(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? v9.CREATOR.createFromParcel(parcel) : null, parcel.readDouble(), parcel.readHashMap(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        return true;
                    case 39:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        I(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? v9.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? z9.CREATOR.createFromParcel(parcel) : null, parcel.readHashMap(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        return true;
                    case 40:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        z(parcel.readInt() != 0 ? k8.CREATOR.createFromParcel(parcel) : null, parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 41:
                        parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                        q(parcel.readInt() != 0 ? k8.CREATOR.createFromParcel(parcel) : null, parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            }
            parcel2.writeString("com.alibaba.mtl.appmonitor.IMonitor");
            return true;
        }
    }

    void B(String str, String str2, String str3) throws RemoteException;

    void C(int i) throws RemoteException;

    void E(int i) throws RemoteException;

    void G(boolean z, String str, String str2, String str3) throws RemoteException;

    void H() throws RemoteException;

    void I(String str, String str2, v9 v9Var, z9 z9Var, Map map) throws RemoteException;

    void J(int i) throws RemoteException;

    void K(String str) throws RemoteException;

    void L(String str, String str2, double d, Map map) throws RemoteException;

    void M(String str, String str2, x9 x9Var) throws RemoteException;

    void N(String str, String str2, String str3, String str4, Map map) throws RemoteException;

    void O(String str, String str2, double d, Map map) throws RemoteException;

    void P(String str, String str2, String str3, double d, Map map) throws RemoteException;

    void Q(int i) throws RemoteException;

    void R(Map map) throws RemoteException;

    void S(int i, int i2) throws RemoteException;

    void V(int i) throws RemoteException;

    void W(String str, String str2, v9 v9Var, double d, Map map) throws RemoteException;

    void X(int i) throws RemoteException;

    void Y(String str, String str2, x9 x9Var, u9 u9Var) throws RemoteException;

    void b0(String str, String str2, String str3, String str4, String str5, Map map) throws RemoteException;

    void d0(int i) throws RemoteException;

    void destroy() throws RemoteException;

    void e0() throws RemoteException;

    void f(String str, String str2, double d) throws RemoteException;

    void g(int i) throws RemoteException;

    void h(int i) throws RemoteException;

    boolean h0(String str, String str2) throws RemoteException;

    boolean i(String str, String str2) throws RemoteException;

    void init() throws RemoteException;

    void j(int i) throws RemoteException;

    void j0(String str, String str2, x9 x9Var, boolean z) throws RemoteException;

    void n(String str, String str2, String str3, Map map) throws RemoteException;

    void p(boolean z) throws RemoteException;

    void q(k8 k8Var, String str) throws RemoteException;

    void t(String str, String str2, x9 x9Var, u9 u9Var, boolean z) throws RemoteException;

    void v(String str, String str2, String str3) throws RemoteException;

    boolean w(String str, String str2) throws RemoteException;

    void x(String str, String str2, Map map) throws RemoteException;

    boolean y(String str, String str2) throws RemoteException;

    void z(k8 k8Var, String str) throws RemoteException;
}
