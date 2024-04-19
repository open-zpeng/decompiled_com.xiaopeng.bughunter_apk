package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.LinkedHashMap;
import java.util.Map;
/* compiled from: DimensionValueSet.java */
/* renamed from: v9  reason: default package */
/* loaded from: classes.dex */
public class v9 implements Parcelable, z8 {
    public static final Parcelable.Creator<v9> CREATOR = new a();
    protected Map<String, String> b;

    /* compiled from: DimensionValueSet.java */
    /* renamed from: v9$a */
    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<v9> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public v9[] newArray(int i) {
            return new v9[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public v9 createFromParcel(Parcel parcel) {
            return v9.c(parcel);
        }
    }

    @Deprecated
    public v9() {
        if (this.b == null) {
            this.b = new LinkedHashMap();
        }
    }

    static v9 c(Parcel parcel) {
        v9 v9Var;
        try {
            v9Var = f();
            try {
                v9Var.b = parcel.readHashMap(v9.class.getClassLoader());
            } catch (Throwable th) {
                th = th;
                th.printStackTrace();
                return v9Var;
            }
        } catch (Throwable th2) {
            th = th2;
            v9Var = null;
        }
        return v9Var;
    }

    public static v9 f() {
        return (v9) y8.a().b(v9.class, new Object[0]);
    }

    public void a() {
        this.b.clear();
    }

    public void b(Object... objArr) {
        if (this.b == null) {
            this.b = new LinkedHashMap();
        }
    }

    public v9 d(v9 v9Var) {
        Map<String, String> g;
        if (v9Var != null && (g = v9Var.g()) != null) {
            for (Map.Entry<String, String> entry : g.entrySet()) {
                this.b.put(entry.getKey(), entry.getValue() != null ? entry.getValue() : "null");
            }
        }
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean e(String str) {
        return this.b.containsKey(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            v9 v9Var = (v9) obj;
            Map<String, String> map = this.b;
            if (map == null) {
                if (v9Var.b != null) {
                    return false;
                }
            } else if (!map.equals(v9Var.b)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public Map<String, String> g() {
        return this.b;
    }

    public String h(String str) {
        return this.b.get(str);
    }

    public int hashCode() {
        Map<String, String> map = this.b;
        return 31 + (map == null ? 0 : map.hashCode());
    }

    public void i(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.b.put(entry.getKey(), entry.getValue() != null ? entry.getValue() : "null");
        }
    }

    public v9 j(String str, String str2) {
        Map<String, String> map = this.b;
        if (str2 == null) {
            str2 = "null";
        }
        map.put(str, str2);
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeMap(this.b);
    }
}
