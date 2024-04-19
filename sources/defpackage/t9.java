package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
/* compiled from: Dimension.java */
/* renamed from: t9  reason: default package */
/* loaded from: classes.dex */
public class t9 implements Parcelable {
    public static final Parcelable.Creator<t9> CREATOR = new a();
    protected String b;
    protected String c;

    /* compiled from: Dimension.java */
    /* renamed from: t9$a */
    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<t9> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public t9[] newArray(int i) {
            return new t9[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public t9 createFromParcel(Parcel parcel) {
            return t9.a(parcel);
        }
    }

    public t9() {
        this.c = "null";
    }

    static t9 a(Parcel parcel) {
        try {
            return new t9(parcel.readString(), parcel.readString());
        } catch (Throwable unused) {
            return null;
        }
    }

    public String b() {
        return this.c;
    }

    public String c() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && t9.class == obj.getClass()) {
            t9 t9Var = (t9) obj;
            String str = this.b;
            if (str == null) {
                if (t9Var.b != null) {
                    return false;
                }
            } else if (!str.equals(t9Var.b)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.b;
        return 31 + (str == null ? 0 : str.hashCode());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.c);
        parcel.writeString(this.b);
    }

    public t9(String str, String str2) {
        this.c = "null";
        this.b = str;
        this.c = str2 == null ? "null" : str2;
    }
}
