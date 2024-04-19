package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
/* compiled from: MeasureSet.java */
/* renamed from: x9  reason: default package */
/* loaded from: classes.dex */
public class x9 implements Parcelable {
    public static final Parcelable.Creator<x9> CREATOR = new a();
    private List<w9> b = new ArrayList(3);

    /* compiled from: MeasureSet.java */
    /* renamed from: x9$a */
    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<x9> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public x9[] newArray(int i) {
            return new x9[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public x9 createFromParcel(Parcel parcel) {
            return x9.a(parcel);
        }
    }

    private x9() {
    }

    static x9 a(Parcel parcel) {
        x9 c = c();
        try {
            Parcelable[] readParcelableArray = parcel.readParcelableArray(x9.class.getClassLoader());
            if (readParcelableArray != null) {
                ArrayList arrayList = new ArrayList(readParcelableArray.length);
                for (Parcelable parcelable : readParcelableArray) {
                    arrayList.add((w9) parcelable);
                }
                c.b = arrayList;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return c;
    }

    public static x9 c() {
        return new x9();
    }

    public x9 b(w9 w9Var) {
        if (!this.b.contains(w9Var)) {
            this.b.add(w9Var);
        }
        return this;
    }

    public w9 d(String str) {
        for (w9 w9Var : this.b) {
            if (w9Var.d().equals(str)) {
                return w9Var;
            }
        }
        return null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<w9> e() {
        return this.b;
    }

    public void f(z9 z9Var) {
        List<w9> list = this.b;
        if (list == null || z9Var == null) {
            return;
        }
        for (w9 w9Var : list) {
            if (w9Var.b() != null && z9Var.g(w9Var.d()) == null) {
                z9Var.i(w9Var.d(), w9Var.b().doubleValue());
            }
        }
    }

    public boolean g(z9 z9Var) {
        if (this.b != null) {
            if (z9Var != null) {
                for (int i = 0; i < this.b.size(); i++) {
                    w9 w9Var = this.b.get(i);
                    if (w9Var != null) {
                        String d = w9Var.d();
                        if (!z9Var.d(d) || !w9Var.e(z9Var.g(d))) {
                            return false;
                        }
                    }
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        List<w9> list = this.b;
        if (list != null) {
            try {
                Object[] array = list.toArray();
                w9[] w9VarArr = null;
                if (array != null) {
                    w9VarArr = new w9[array.length];
                    for (int i2 = 0; i2 < array.length; i2++) {
                        w9VarArr[i2] = (w9) array[i2];
                    }
                }
                parcel.writeParcelableArray(w9VarArr, i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
