package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
/* compiled from: AbsSavedState.java */
/* renamed from: e4  reason: default package */
/* loaded from: classes.dex */
public abstract class e4 implements Parcelable {
    private final Parcelable c;
    public static final e4 b = new a();
    public static final Parcelable.Creator<e4> CREATOR = new b();

    /* compiled from: AbsSavedState.java */
    /* renamed from: e4$a */
    /* loaded from: classes.dex */
    static class a extends e4 {
        a() {
            super((a) null);
        }
    }

    /* compiled from: AbsSavedState.java */
    /* renamed from: e4$b */
    /* loaded from: classes.dex */
    static class b implements Parcelable.ClassLoaderCreator<e4> {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public e4 createFromParcel(Parcel parcel) {
            return createFromParcel(parcel, null);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        /* renamed from: b */
        public e4 createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return e4.b;
            }
            throw new IllegalStateException("superState must be null");
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: c */
        public e4[] newArray(int i) {
            return new e4[i];
        }
    }

    /* synthetic */ e4(a aVar) {
        this();
    }

    public final Parcelable a() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.c, i);
    }

    private e4() {
        this.c = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e4(Parcelable parcelable) {
        if (parcelable != null) {
            this.c = parcelable == b ? null : parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e4(Parcel parcel, ClassLoader classLoader) {
        Parcelable readParcelable = parcel.readParcelable(classLoader);
        this.c = readParcelable == null ? b : readParcelable;
    }
}
