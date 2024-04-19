package defpackage;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import defpackage.i3;
/* compiled from: ResultReceiver.java */
/* renamed from: j3  reason: default package */
/* loaded from: classes.dex */
public class j3 implements Parcelable {
    public static final Parcelable.Creator<j3> CREATOR = new a();
    final boolean b = false;
    final Handler c = null;
    i3 d;

    /* compiled from: ResultReceiver.java */
    /* renamed from: j3$a */
    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<j3> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public j3 createFromParcel(Parcel parcel) {
            return new j3(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public j3[] newArray(int i) {
            return new j3[i];
        }
    }

    /* compiled from: ResultReceiver.java */
    /* renamed from: j3$b */
    /* loaded from: classes.dex */
    class b extends i3.a {
        b() {
        }

        @Override // defpackage.i3
        public void i0(int i, Bundle bundle) {
            j3 j3Var = j3.this;
            Handler handler = j3Var.c;
            if (handler != null) {
                handler.post(new c(i, bundle));
            } else {
                j3Var.a(i, bundle);
            }
        }
    }

    /* compiled from: ResultReceiver.java */
    /* renamed from: j3$c */
    /* loaded from: classes.dex */
    class c implements Runnable {
        final int b;
        final Bundle c;

        c(int i, Bundle bundle) {
            this.b = i;
            this.c = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            j3.this.a(this.b, this.c);
        }
    }

    j3(Parcel parcel) {
        this.d = i3.a.l0(parcel.readStrongBinder());
    }

    protected void a(int i, Bundle bundle) {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        synchronized (this) {
            if (this.d == null) {
                this.d = new b();
            }
            parcel.writeStrongBinder(this.d.asBinder());
        }
    }
}
