package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Map;
/* compiled from: Transaction.java */
/* renamed from: k8  reason: default package */
/* loaded from: classes.dex */
public class k8 implements Parcelable {
    public static final Parcelable.Creator<k8> CREATOR = new a();
    protected Integer b;
    protected String c;
    protected String d;
    protected v9 e;
    protected String f;
    protected Map<String, String> g;

    /* compiled from: Transaction.java */
    /* renamed from: k8$a */
    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<k8> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public k8[] newArray(int i) {
            return new k8[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public k8 createFromParcel(Parcel parcel) {
            return k8.a(parcel);
        }
    }

    static k8 a(Parcel parcel) {
        k8 k8Var = new k8();
        try {
            k8Var.e = (v9) parcel.readParcelable(k8.class.getClassLoader());
            k8Var.b = Integer.valueOf(parcel.readInt());
            k8Var.c = parcel.readString();
            k8Var.d = parcel.readString();
            k8Var.f = parcel.readString();
            k8Var.g = parcel.readHashMap(k8.class.getClassLoader());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return k8Var;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.e, i);
        parcel.writeInt(this.b.intValue());
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.f);
        parcel.writeMap(this.g);
    }
}
