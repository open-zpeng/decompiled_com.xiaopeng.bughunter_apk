package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: IPCCallback.java */
/* renamed from: cf  reason: default package */
/* loaded from: classes.dex */
public interface cf extends IInterface {

    /* compiled from: IPCCallback.java */
    /* renamed from: cf$a */
    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements cf {
        private static final String DESCRIPTOR = "com.xiaopeng.ipc.IPCCallback";
        static final int TRANSACTION_onReceive = 1;

        /* compiled from: IPCCallback.java */
        /* renamed from: cf$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static class C0017a implements cf {
            private IBinder a;

            C0017a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }
        }

        public a() {
            attachInterface(this, DESCRIPTOR);
        }

        public static cf asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof cf)) {
                return (cf) queryLocalInterface;
            }
            return new C0017a(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            onReceive(parcel.readInt() != 0 ? df.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            return true;
        }
    }

    void onReceive(df dfVar) throws RemoteException;
}
