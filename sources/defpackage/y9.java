package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
/* compiled from: MeasureValue.java */
/* renamed from: y9  reason: default package */
/* loaded from: classes.dex */
public class y9 implements Parcelable, z8 {
    public static final Parcelable.Creator<y9> CREATOR = new a();
    private boolean b;
    private Double c;
    private double d;

    /* compiled from: MeasureValue.java */
    /* renamed from: y9$a */
    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<y9> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public y9[] newArray(int i) {
            return new y9[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public y9 createFromParcel(Parcel parcel) {
            return y9.c(parcel);
        }
    }

    static y9 c(Parcel parcel) {
        y9 y9Var = null;
        try {
            boolean z = parcel.readInt() != 0;
            Double valueOf = Double.valueOf(parcel.readDouble());
            double readDouble = parcel.readDouble();
            y9Var = d();
            y9Var.b = z;
            y9Var.c = valueOf;
            y9Var.d = readDouble;
            return y9Var;
        } catch (Throwable th) {
            th.printStackTrace();
            return y9Var;
        }
    }

    public static y9 d() {
        return (y9) y8.a().b(y9.class, new Object[0]);
    }

    @Override // defpackage.z8
    public synchronized void a() {
        this.d = 0.0d;
        this.c = null;
        this.b = false;
    }

    @Override // defpackage.z8
    public synchronized void b(Object... objArr) {
        if (objArr == null) {
            return;
        }
        if (objArr.length > 0) {
            this.d = ((Double) objArr[0]).doubleValue();
        }
        if (objArr.length > 1) {
            this.c = (Double) objArr[1];
            this.b = false;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Double e() {
        return this.c;
    }

    public double f() {
        return this.d;
    }

    public boolean g() {
        return this.b;
    }

    public synchronized void h(y9 y9Var) {
        if (y9Var == null) {
            return;
        }
        try {
            this.d += y9Var.f();
            if (y9Var.e() != null) {
                if (this.c == null) {
                    this.c = Double.valueOf(0.0d);
                }
                this.c = Double.valueOf(this.c.doubleValue() + y9Var.e().doubleValue());
            }
        } catch (Throwable unused) {
        }
    }

    public void i(boolean z) {
        this.b = z;
    }

    public void j(double d) {
        this.c = Double.valueOf(d);
    }

    public void k(double d) {
        this.d = d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        try {
            parcel.writeInt(this.b ? 1 : 0);
            Double d = this.c;
            parcel.writeDouble(d == null ? 0.0d : d.doubleValue());
            parcel.writeDouble(this.d);
        } catch (Throwable unused) {
        }
    }
}
