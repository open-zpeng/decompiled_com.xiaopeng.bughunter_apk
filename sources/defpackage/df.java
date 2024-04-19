package defpackage;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
/* compiled from: IpcMessage.java */
/* renamed from: df  reason: default package */
/* loaded from: classes.dex */
public class df implements Parcelable {
    public static final Parcelable.Creator<df> CREATOR = new a();
    String b;
    int c;
    Bundle d;

    /* compiled from: IpcMessage.java */
    /* renamed from: df$a */
    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<df> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public df createFromParcel(Parcel parcel) {
            return new df(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public df[] newArray(int i) {
            return new df[i];
        }
    }

    public df() {
    }

    public int a() {
        return this.c;
    }

    public String b() {
        return this.b;
    }

    public Bundle c() {
        return this.d;
    }

    public void d(int i) {
        this.c = i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void e(String str) {
        this.b = str;
    }

    public void f(Bundle bundle) {
        this.d = bundle;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.b);
        parcel.writeInt(this.c);
        parcel.writeBundle(this.d);
    }

    protected df(Parcel parcel) {
        this.b = parcel.readString();
        this.c = parcel.readInt();
        this.d = parcel.readBundle();
    }
}
