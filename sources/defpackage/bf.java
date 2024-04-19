package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: IPC.java */
/* renamed from: bf  reason: default package */
/* loaded from: classes.dex */
public interface bf extends IInterface {

    /* compiled from: IPC.java */
    /* renamed from: bf$a */
    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements bf {

        /* compiled from: IPC.java */
        /* renamed from: bf$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static class C0016a implements bf {
            private IBinder a;

            C0016a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // defpackage.bf
            public void T(String str, df dfVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.ipc.IPC");
                    obtain.writeString(str);
                    if (dfVar != null) {
                        obtain.writeInt(1);
                        dfVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.bf
            public void U(String str, cf cfVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.ipc.IPC");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(cfVar != null ? cfVar.asBinder() : null);
                    this.a.transact(1, obtain, obtain2, 0);
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

            @Override // defpackage.bf
            public void u(String str, cf cfVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.ipc.IPC");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(cfVar != null ? cfVar.asBinder() : null);
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static bf l0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaopeng.ipc.IPC");
            if (queryLocalInterface != null && (queryLocalInterface instanceof bf)) {
                return (bf) queryLocalInterface;
            }
            return new C0016a(iBinder);
        }
    }

    void T(String str, df dfVar) throws RemoteException;

    void U(String str, cf cfVar) throws RemoteException;

    void u(String str, cf cfVar) throws RemoteException;
}
