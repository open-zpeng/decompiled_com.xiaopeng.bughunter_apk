package defpackage;

import android.content.ContentValues;
import android.database.Cursor;
import java.io.Serializable;
/* compiled from: CacheEntity.java */
/* renamed from: zb  reason: default package */
/* loaded from: classes.dex */
public class zb<T> implements Serializable {
    private static final long serialVersionUID = -4337711009801627866L;
    private String b;
    private long c;
    private xc d;
    private T e;
    private boolean f;

    public static <T> ContentValues b(zb<T> zbVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("key", zbVar.d());
        contentValues.put("localExpire", Long.valueOf(zbVar.e()));
        contentValues.put("head", kd.c(zbVar.f()));
        contentValues.put("data", kd.c(zbVar.c()));
        return contentValues;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> zb<T> h(Cursor cursor) {
        zb<T> zbVar = (zb<T>) new zb();
        zbVar.k(cursor.getString(cursor.getColumnIndex("key")));
        zbVar.l(cursor.getLong(cursor.getColumnIndex("localExpire")));
        zbVar.m((xc) kd.d(cursor.getBlob(cursor.getColumnIndex("head"))));
        zbVar.i(kd.d(cursor.getBlob(cursor.getColumnIndex("data"))));
        return zbVar;
    }

    public boolean a(ac acVar, long j, long j2) {
        return acVar == ac.DEFAULT ? e() < j2 : j != -1 && e() + j < j2;
    }

    public T c() {
        return this.e;
    }

    public String d() {
        return this.b;
    }

    public long e() {
        return this.c;
    }

    public xc f() {
        return this.d;
    }

    public boolean g() {
        return this.f;
    }

    public void i(T t) {
        this.e = t;
    }

    public void j(boolean z) {
        this.f = z;
    }

    public void k(String str) {
        this.b = str;
    }

    public void l(long j) {
        this.c = j;
    }

    public void m(xc xcVar) {
        this.d = xcVar;
    }

    public String toString() {
        return "CacheEntity{key='" + this.b + "', responseHeaders=" + this.d + ", data=" + this.e + ", localExpire=" + this.c + '}';
    }
}
