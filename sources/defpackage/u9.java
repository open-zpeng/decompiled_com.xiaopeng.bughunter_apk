package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
/* compiled from: DimensionSet.java */
/* renamed from: u9  reason: default package */
/* loaded from: classes.dex */
public class u9 implements Parcelable {
    public static final Parcelable.Creator<u9> CREATOR = new a();
    private List<t9> b = new ArrayList(3);

    /* compiled from: DimensionSet.java */
    /* renamed from: u9$a */
    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<u9> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public u9[] newArray(int i) {
            return new u9[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public u9 createFromParcel(Parcel parcel) {
            return u9.a(parcel);
        }
    }

    private u9() {
    }

    static u9 a(Parcel parcel) {
        u9 b = b();
        try {
            Parcelable[] readParcelableArray = parcel.readParcelableArray(u9.class.getClassLoader());
            if (readParcelableArray != null) {
                if (b.b == null) {
                    b.b = new ArrayList();
                }
                for (int i = 0; i < readParcelableArray.length; i++) {
                    if (readParcelableArray[i] == null || !(readParcelableArray[i] instanceof t9)) {
                        ya.c("DimensionSet", "parcelables[i]:", readParcelableArray[i]);
                    } else {
                        b.b.add((t9) readParcelableArray[i]);
                    }
                }
            }
        } catch (Throwable th) {
            ya.b("DimensionSet", "[readFromParcel]", th);
        }
        return b;
    }

    public static u9 b() {
        return new u9();
    }

    public void c(v9 v9Var) {
        List<t9> list = this.b;
        if (list == null || v9Var == null) {
            return;
        }
        for (t9 t9Var : list) {
            if (t9Var.b() != null && v9Var.h(t9Var.c()) == null) {
                v9Var.j(t9Var.c(), t9Var.b());
            }
        }
    }

    public boolean d(v9 v9Var) {
        List<t9> list = this.b;
        if (list != null) {
            if (v9Var != null) {
                for (t9 t9Var : list) {
                    if (!v9Var.e(t9Var.c())) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        List<t9> list = this.b;
        if (list != null) {
            try {
                Object[] array = list.toArray();
                t9[] t9VarArr = null;
                if (array != null) {
                    t9VarArr = new t9[array.length];
                    for (int i2 = 0; i2 < array.length; i2++) {
                        t9VarArr[i2] = (t9) array[i2];
                    }
                }
                parcel.writeParcelableArray(t9VarArr, i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
