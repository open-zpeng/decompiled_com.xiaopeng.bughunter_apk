package defpackage;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: IResultReceiver.java */
/* renamed from: i3  reason: default package */
/* loaded from: classes.dex */
public interface i3 extends IInterface {

    /* compiled from: IResultReceiver.java */
    /* renamed from: i3$a */
    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements i3 {

        /* compiled from: IResultReceiver.java */
        /* renamed from: i3$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static class C0043a implements i3 {
            private IBinder a;

            C0043a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }
        }

        public a() {
            attachInterface(this, "android.support.v4.os.IResultReceiver");
        }

        public static i3 l0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("android.support.v4.os.IResultReceiver");
            if (queryLocalInterface != null && (queryLocalInterface instanceof i3)) {
                return (i3) queryLocalInterface;
            }
            return new C0043a(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("android.support.v4.os.IResultReceiver");
                i0(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("android.support.v4.os.IResultReceiver");
                return true;
            }
        }
    }

    void i0(int i, Bundle bundle) throws RemoteException;
}
