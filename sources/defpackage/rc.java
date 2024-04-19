package defpackage;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
/* compiled from: DBUtils.java */
/* renamed from: rc  reason: default package */
/* loaded from: classes.dex */
public class rc {
    public static boolean a(SQLiteDatabase sQLiteDatabase, sc scVar) {
        if (b(sQLiteDatabase, scVar.a)) {
            Cursor rawQuery = sQLiteDatabase.rawQuery("select * from " + scVar.a, null);
            if (rawQuery == null) {
                return false;
            }
            try {
                int c = scVar.c();
                if (c == rawQuery.getColumnCount()) {
                    for (int i = 0; i < c; i++) {
                        if (scVar.d(rawQuery.getColumnName(i)) == -1) {
                            return true;
                        }
                    }
                    return false;
                }
                return true;
            } finally {
                rawQuery.close();
            }
        }
        return true;
    }

    public static boolean b(SQLiteDatabase sQLiteDatabase, String str) {
        int i;
        if (str == null || sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
            return false;
        }
        Cursor cursor = null;
        try {
            try {
                cursor = sQLiteDatabase.rawQuery("SELECT COUNT(*) FROM sqlite_master WHERE type = ? AND name = ?", new String[]{"table", str});
            } catch (Exception e) {
                ld.a(e);
                if (cursor != null) {
                    cursor.close();
                }
                i = 0;
            }
            if (!cursor.moveToFirst()) {
                cursor.close();
                return false;
            }
            i = cursor.getInt(0);
            cursor.close();
            return i > 0;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }
}
