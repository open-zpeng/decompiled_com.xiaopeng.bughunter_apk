package defpackage;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
/* compiled from: BaseDao.java */
/* renamed from: nc  reason: default package */
/* loaded from: classes.dex */
public abstract class nc<T> {
    protected static String a;
    protected Lock b;
    protected SQLiteOpenHelper c;
    protected SQLiteDatabase d;

    public nc(SQLiteOpenHelper sQLiteOpenHelper) {
        a = getClass().getSimpleName();
        this.b = qc.a;
        this.c = sQLiteOpenHelper;
        this.d = e();
    }

    protected final void a(SQLiteDatabase sQLiteDatabase, Cursor cursor) {
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
            return;
        }
        sQLiteDatabase.close();
    }

    public boolean b(String str, String[] strArr) {
        String str2;
        long currentTimeMillis = System.currentTimeMillis();
        this.b.lock();
        try {
            try {
                this.d.beginTransaction();
                this.d.delete(d(), str, strArr);
                this.d.setTransactionSuccessful();
                return true;
            } catch (Exception e) {
                ld.a(e);
                this.d.endTransaction();
                this.b.unlock();
                String str3 = a;
                ld.b(str3, (System.currentTimeMillis() - currentTimeMillis) + " delete");
                return false;
            }
        } finally {
            this.d.endTransaction();
            this.b.unlock();
            str2 = a;
            ld.b(str2, (System.currentTimeMillis() - currentTimeMillis) + " delete");
        }
    }

    public abstract ContentValues c(T t);

    public abstract String d();

    public SQLiteDatabase e() {
        return this.c.getWritableDatabase();
    }

    public abstract T f(Cursor cursor);

    public List<T> g(String str, String[] strArr) {
        return h(null, str, strArr, null, null, null, null);
    }

    public List<T> h(String[] strArr, String str, String[] strArr2, String str2, String str3, String str4, String str5) {
        Cursor cursor;
        String str6;
        StringBuilder sb;
        long currentTimeMillis = System.currentTimeMillis();
        this.b.lock();
        ArrayList arrayList = new ArrayList();
        try {
            this.d.beginTransaction();
            cursor = this.d.query(d(), strArr, str, strArr2, str2, str3, str4, str5);
            while (!cursor.isClosed() && cursor.moveToNext()) {
                try {
                    try {
                        arrayList.add(f(cursor));
                    } catch (Exception e) {
                        e = e;
                        ld.a(e);
                        a(null, cursor);
                        this.d.endTransaction();
                        this.b.unlock();
                        str6 = a;
                        sb = new StringBuilder();
                        sb.append(System.currentTimeMillis() - currentTimeMillis);
                        sb.append(" query");
                        ld.b(str6, sb.toString());
                        return arrayList;
                    }
                } catch (Throwable th) {
                    th = th;
                    a(null, cursor);
                    this.d.endTransaction();
                    this.b.unlock();
                    ld.b(a, (System.currentTimeMillis() - currentTimeMillis) + " query");
                    throw th;
                }
            }
            this.d.setTransactionSuccessful();
            a(null, cursor);
            this.d.endTransaction();
            this.b.unlock();
            str6 = a;
            sb = new StringBuilder();
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            a(null, cursor);
            this.d.endTransaction();
            this.b.unlock();
            ld.b(a, (System.currentTimeMillis() - currentTimeMillis) + " query");
            throw th;
        }
        sb.append(System.currentTimeMillis() - currentTimeMillis);
        sb.append(" query");
        ld.b(str6, sb.toString());
        return arrayList;
    }

    public boolean i(T t) {
        String str;
        if (t == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.b.lock();
        try {
            this.d.beginTransaction();
            this.d.replace(d(), null, c(t));
            this.d.setTransactionSuccessful();
            return true;
        } catch (Exception e) {
            ld.a(e);
            return false;
        } finally {
            this.d.endTransaction();
            this.b.unlock();
            str = a;
            ld.b(str, (System.currentTimeMillis() - currentTimeMillis) + " replaceT");
        }
    }
}
