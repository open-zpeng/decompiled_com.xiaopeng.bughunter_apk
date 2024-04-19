package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
/* compiled from: Measure.java */
/* renamed from: w9  reason: default package */
/* loaded from: classes.dex */
public class w9 implements Parcelable {
    public static final Parcelable.Creator<w9> CREATOR = new a();
    protected Double b;
    protected Double c;
    protected String d;
    protected Double e;

    /* compiled from: Measure.java */
    /* renamed from: w9$a */
    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<w9> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public w9[] newArray(int i) {
            return new w9[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public w9 createFromParcel(Parcel parcel) {
            return w9.a(parcel);
        }
    }

    public w9(String str, Double d, Double d2, Double d3) {
        Double valueOf = Double.valueOf(0.0d);
        this.b = valueOf;
        this.c = valueOf;
        this.e = valueOf;
        this.b = d2;
        this.c = d3;
        this.d = str;
        this.e = Double.valueOf(d != null ? d.doubleValue() : 0.0d);
    }

    static w9 a(Parcel parcel) {
        try {
            boolean z = true;
            Double valueOf = !(parcel.readInt() == 0) ? Double.valueOf(parcel.readDouble()) : null;
            Double valueOf2 = !(parcel.readInt() == 0) ? Double.valueOf(parcel.readDouble()) : null;
            String readString = parcel.readString();
            if (parcel.readInt() != 0) {
                z = false;
            }
            return new w9(readString, !z ? Double.valueOf(parcel.readDouble()) : null, valueOf2, valueOf);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public Double b() {
        return this.e;
    }

    public Double c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean e(y9 y9Var) {
        Double valueOf = Double.valueOf(y9Var.f());
        return valueOf != null && (this.b == null || valueOf.doubleValue() >= this.b.doubleValue()) && (this.c == null || valueOf.doubleValue() <= this.c.doubleValue());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && w9.class == obj.getClass()) {
            w9 w9Var = (w9) obj;
            String str = this.d;
            if (str == null) {
                if (w9Var.d != null) {
                    return false;
                }
            } else if (!str.equals(w9Var.d)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.d;
        return 31 + (str == null ? 0 : str.hashCode());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        try {
            int i2 = 0;
            parcel.writeInt(this.c == null ? 0 : 1);
            Double d = this.c;
            if (d != null) {
                parcel.writeDouble(d.doubleValue());
            }
            parcel.writeInt(this.b == null ? 0 : 1);
            Double d2 = this.b;
            if (d2 != null) {
                parcel.writeDouble(d2.doubleValue());
            }
            parcel.writeString(this.d);
            if (this.e != null) {
                i2 = 1;
            }
            parcel.writeInt(i2);
            Double d3 = this.e;
            if (d3 != null) {
                parcel.writeDouble(d3.doubleValue());
            }
        } catch (Throwable unused) {
        }
    }
}
