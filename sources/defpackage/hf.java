package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;
/* compiled from: IDataUploadInterface.java */
/* renamed from: hf  reason: default package */
/* loaded from: classes.dex */
public interface hf extends IInterface {

    /* compiled from: IDataUploadInterface.java */
    /* renamed from: hf$a */
    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements hf {

        /* compiled from: IDataUploadInterface.java */
        /* renamed from: hf$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static class C0041a implements hf {
            private IBinder a;

            C0041a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // defpackage.hf
            public void A(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.lib.bughunter.IDataUploadInterface");
                    obtain.writeString(str);
                    this.a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // defpackage.hf
            public void a0(List<String> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.lib.bughunter.IDataUploadInterface");
                    obtain.writeStringList(list);
                    this.a.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // defpackage.hf
            public void c0(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.lib.bughunter.IDataUploadInterface");
                    obtain.writeString(str);
                    this.a.transact(6, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // defpackage.hf
            public void l(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.lib.bughunter.IDataUploadInterface");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.a.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // defpackage.hf
            public void o(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.lib.bughunter.IDataUploadInterface");
                    obtain.writeString(str);
                    this.a.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // defpackage.hf
            public void r(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.lib.bughunter.IDataUploadInterface");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.a.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static hf l0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaopeng.lib.bughunter.IDataUploadInterface");
            if (queryLocalInterface != null && (queryLocalInterface instanceof hf)) {
                return (hf) queryLocalInterface;
            }
            return new C0041a(iBinder);
        }
    }

    void A(String str) throws RemoteException;

    void a0(List<String> list) throws RemoteException;

    void c0(String str) throws RemoteException;

    void l(String str, String str2) throws RemoteException;

    void o(String str) throws RemoteException;

    void r(String str, String str2) throws RemoteException;
}
