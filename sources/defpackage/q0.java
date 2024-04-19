package defpackage;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
/* compiled from: ExtendableSavedState.java */
/* renamed from: q0  reason: default package */
/* loaded from: classes.dex */
public class q0 extends e4 {
    public static final Parcelable.Creator<q0> CREATOR = new a();
    public final c4<String, Bundle> d;

    /* compiled from: ExtendableSavedState.java */
    /* renamed from: q0$a */
    /* loaded from: classes.dex */
    static class a implements Parcelable.ClassLoaderCreator<q0> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public q0 createFromParcel(Parcel parcel) {
            return new q0(parcel, null, null);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        /* renamed from: b */
        public q0 createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return new q0(parcel, classLoader, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: c */
        public q0[] newArray(int i) {
            return new q0[i];
        }
    }

    /* synthetic */ q0(Parcel parcel, ClassLoader classLoader, a aVar) {
        this(parcel, classLoader);
    }

    public String toString() {
        return "ExtendableSavedState{" + Integer.toHexString(System.identityHashCode(this)) + " states=" + this.d + "}";
    }

    @Override // defpackage.e4, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        int size = this.d.size();
        parcel.writeInt(size);
        String[] strArr = new String[size];
        Bundle[] bundleArr = new Bundle[size];
        for (int i2 = 0; i2 < size; i2++) {
            strArr[i2] = this.d.i(i2);
            bundleArr[i2] = this.d.m(i2);
        }
        parcel.writeStringArray(strArr);
        parcel.writeTypedArray(bundleArr, 0);
    }

    public q0(Parcelable parcelable) {
        super(parcelable);
        this.d = new c4<>();
    }

    private q0(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        int readInt = parcel.readInt();
        String[] strArr = new String[readInt];
        parcel.readStringArray(strArr);
        Bundle[] bundleArr = new Bundle[readInt];
        parcel.readTypedArray(bundleArr, Bundle.CREATOR);
        this.d = new c4<>(readInt);
        for (int i = 0; i < readInt; i++) {
            this.d.put(strArr[i], bundleArr[i]);
        }
    }
}
