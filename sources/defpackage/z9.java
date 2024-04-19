package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.LinkedHashMap;
import java.util.Map;
/* compiled from: MeasureValueSet.java */
/* renamed from: z9  reason: default package */
/* loaded from: classes.dex */
public class z9 implements Parcelable, z8 {
    public static final Parcelable.Creator<z9> CREATOR = new a();
    private Map<String, y9> b = new LinkedHashMap();

    /* compiled from: MeasureValueSet.java */
    /* renamed from: z9$a */
    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<z9> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public z9[] newArray(int i) {
            return new z9[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public z9 createFromParcel(Parcel parcel) {
            return z9.c(parcel);
        }
    }

    static z9 c(Parcel parcel) {
        try {
            z9 e = e();
            try {
                e.b = parcel.readHashMap(v9.class.getClassLoader());
                return e;
            } catch (Throwable unused) {
                return e;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static z9 e() {
        return (z9) y8.a().b(z9.class, new Object[0]);
    }

    @Override // defpackage.z8
    public void a() {
        for (y9 y9Var : this.b.values()) {
            y8.a().d(y9Var);
        }
        this.b.clear();
    }

    @Override // defpackage.z8
    public void b(Object... objArr) {
        if (this.b == null) {
            this.b = new LinkedHashMap();
        }
    }

    public boolean d(String str) {
        return this.b.containsKey(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Map<String, y9> f() {
        return this.b;
    }

    public y9 g(String str) {
        return this.b.get(str);
    }

    public void h(z9 z9Var) {
        for (String str : this.b.keySet()) {
            this.b.get(str).h(z9Var.g(str));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public z9 i(String str, double d) {
        this.b.put(str, y8.a().b(y9.class, Double.valueOf(d)));
        return this;
    }

    public void j(String str, y9 y9Var) {
        this.b.put(str, y9Var);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeMap(this.b);
    }
}
