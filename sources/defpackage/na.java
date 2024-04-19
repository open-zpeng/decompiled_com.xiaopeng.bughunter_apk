package defpackage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LogSqliteStore.java */
/* renamed from: na  reason: default package */
/* loaded from: classes.dex */
public class na implements ma {
    String a = "SELECT * FROM %s ORDER BY %s ASC LIMIT %s";
    String b = "SELECT count(*) FROM %s";
    String c = "DELETE FROM log where _id in ( select _id from log  ORDER BY _id ASC LIMIT %d )";
    a d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LogSqliteStore.java */
    /* renamed from: na$a */
    /* loaded from: classes.dex */
    public class a extends SQLiteOpenHelper {
        private AtomicInteger a;
        private SQLiteDatabase b;

        a(Context context) {
            super(context, "ut.db", (SQLiteDatabase.CursorFactory) null, 2);
            this.a = new AtomicInteger();
        }

        public synchronized void a(SQLiteDatabase sQLiteDatabase) {
            SQLiteDatabase sQLiteDatabase2;
            if (sQLiteDatabase == null) {
                return;
            }
            try {
                if (this.a.decrementAndGet() == 0 && (sQLiteDatabase2 = this.b) != null) {
                    sQLiteDatabase2.close();
                    this.b = null;
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public synchronized SQLiteDatabase getWritableDatabase() {
            try {
                if (this.a.incrementAndGet() == 1) {
                    this.b = super.getWritableDatabase();
                }
            }
            return this.b;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS log (_id INTEGER PRIMARY KEY AUTOINCREMENT, eventId TEXT,priority TEXT, streamId TEXT, time TEXT, content TEXT, _index TEXT )");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            Cursor cursor = null;
            try {
                cursor = sQLiteDatabase.rawQuery("PRAGMA journal_mode=DELETE", null);
            } catch (Throwable unused) {
            }
            na.this.f(cursor);
            super.onOpen(sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (i == 1 && i2 == 2) {
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE log ADD COLUMN _index TEXT ");
                } catch (Throwable th) {
                    ya.b("UTSqliteLogStore", "DB Upgrade Error", th);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public na(Context context) {
        this.d = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Throwable unused) {
            }
        }
    }

    @Override // defpackage.ma
    public synchronized void b(String str, String str2) {
        SQLiteDatabase writableDatabase = this.d.getWritableDatabase();
        if (writableDatabase != null) {
            writableDatabase.delete("log", str + " < ?", new String[]{String.valueOf(str2)});
            this.d.a(writableDatabase);
        } else {
            ya.c("UTSqliteLogStore", "db is null");
        }
    }

    @Override // defpackage.ma
    public synchronized int c() {
        int i;
        SQLiteDatabase writableDatabase = this.d.getWritableDatabase();
        i = 0;
        if (writableDatabase != null) {
            Cursor rawQuery = writableDatabase.rawQuery(String.format(this.b, "log"), null);
            if (rawQuery != null) {
                rawQuery.moveToFirst();
                i = rawQuery.getInt(0);
            }
            f(rawQuery);
            this.d.a(writableDatabase);
        } else {
            ya.c("UTSqliteLogStore", "db is null");
        }
        return i;
    }

    @Override // defpackage.ma
    public synchronized void clear() {
        SQLiteDatabase writableDatabase = this.d.getWritableDatabase();
        if (writableDatabase != null) {
            writableDatabase.delete("log", null, null);
            this.d.a(writableDatabase);
        }
    }

    @Override // defpackage.ma
    public void d(int i) {
        if (i <= 0) {
            return;
        }
        SQLiteDatabase writableDatabase = this.d.getWritableDatabase();
        if (writableDatabase != null) {
            try {
                writableDatabase.execSQL(String.format(this.c, Integer.valueOf(i)));
            } catch (Throwable unused) {
            }
            this.d.a(writableDatabase);
            return;
        }
        ya.c("UTSqliteLogStore", "db is null");
    }

    @Override // defpackage.ma
    /* renamed from: e */
    public synchronized ArrayList<qb> a(String str, int i) {
        ArrayList<qb> arrayList = null;
        if (i <= 0) {
            return (ArrayList) Collections.EMPTY_LIST;
        }
        ArrayList<qb> arrayList2 = new ArrayList<>(i);
        try {
            SQLiteDatabase writableDatabase = this.d.getWritableDatabase();
            if (writableDatabase != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("SELECT * FROM ");
                sb.append("log");
                if (!TextUtils.isEmpty(str)) {
                    sb.append(" WHERE ");
                    sb.append(str);
                }
                sb.append(" ORDER BY ");
                sb.append("time");
                sb.append(" ASC ");
                sb.append(" LIMIT ");
                sb.append(i + "");
                String sb2 = sb.toString();
                ya.c("UTSqliteLogStore", "sql:" + sb2);
                Cursor rawQuery = writableDatabase.rawQuery(sb2, null);
                while (rawQuery != null && rawQuery.moveToNext()) {
                    qb qbVar = new qb();
                    ya.c("UTSqliteLogStore", "pos", Integer.valueOf(rawQuery.getPosition()), "count", Integer.valueOf(rawQuery.getCount()));
                    qbVar.a = rawQuery.getInt(rawQuery.getColumnIndex("_id"));
                    qbVar.b = rawQuery.getString(rawQuery.getColumnIndex("eventId"));
                    qbVar.c = rawQuery.getString(rawQuery.getColumnIndex("priority"));
                    qbVar.d(rawQuery.getString(rawQuery.getColumnIndex("content")));
                    qbVar.e = rawQuery.getString(rawQuery.getColumnIndex("time"));
                    try {
                        qbVar.f = rawQuery.getString(rawQuery.getColumnIndex("_index"));
                    } catch (Throwable unused) {
                    }
                    arrayList2.add(qbVar);
                }
                f(rawQuery);
                this.d.a(writableDatabase);
            } else {
                ya.c("UTSqliteLogStore", "db is null");
            }
        } catch (Throwable unused2) {
            arrayList = arrayList2;
            arrayList2 = arrayList;
            return arrayList2;
        }
        return arrayList2;
    }

    @Override // defpackage.ma
    /* renamed from: a */
    public synchronized boolean mo70a(List<qb> list) {
        boolean z = true;
        if (list != null) {
            if (list.size() != 0) {
                SQLiteDatabase sQLiteDatabase = null;
                boolean z2 = false;
                try {
                    sQLiteDatabase = this.d.getWritableDatabase();
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.beginTransaction();
                        int i = 0;
                        while (true) {
                            try {
                                if (i >= list.size()) {
                                    break;
                                }
                                qb qbVar = list.get(i);
                                if (qbVar != null) {
                                    ContentValues contentValues = new ContentValues();
                                    contentValues.put("eventId", qbVar.b);
                                    contentValues.put("priority", qbVar.c);
                                    contentValues.put("content", qbVar.b());
                                    contentValues.put("time", qbVar.e);
                                    contentValues.put("_index", qbVar.f);
                                    long insert = sQLiteDatabase.insert("log", "", contentValues);
                                    if (insert == -1) {
                                        z = false;
                                        break;
                                    }
                                    ya.c("UTSqliteLogStore", "[insert] ", qbVar.f, " isSuccess:", Boolean.TRUE, "ret", Long.valueOf(insert));
                                }
                                i++;
                            } catch (Throwable th) {
                                th = th;
                                ya.b("UTSqliteLogStore", "insert error", th);
                                w8.d(th);
                                if (sQLiteDatabase != null) {
                                    try {
                                        sQLiteDatabase.setTransactionSuccessful();
                                    } catch (Throwable unused) {
                                    }
                                    try {
                                        sQLiteDatabase.endTransaction();
                                    } catch (Throwable unused2) {
                                    }
                                }
                                this.d.a(sQLiteDatabase);
                                z2 = z;
                                return z2;
                            }
                        }
                        z2 = z;
                    } else {
                        ya.c("UTSqliteLogStore", "db is null");
                    }
                    if (sQLiteDatabase != null) {
                        try {
                            sQLiteDatabase.setTransactionSuccessful();
                        } catch (Throwable unused3) {
                        }
                        try {
                            sQLiteDatabase.endTransaction();
                        } catch (Throwable unused4) {
                        }
                    }
                    this.d.a(sQLiteDatabase);
                } catch (Throwable th2) {
                    th = th2;
                    z = false;
                }
                return z2;
            }
        }
        return true;
    }

    @Override // defpackage.ma
    public synchronized int a(List<qb> list) {
        boolean z;
        int i;
        if (list != null) {
            if (list.size() != 0) {
                SQLiteDatabase writableDatabase = this.d.getWritableDatabase();
                if (writableDatabase != null) {
                    writableDatabase.beginTransaction();
                    i = 0;
                    z = true;
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        long delete = writableDatabase.delete("log", "_id=?", new String[]{list.get(i2).a + ""});
                        if (delete <= 0) {
                            ya.c("UTSqliteLogStore", "[delete]  ", Integer.valueOf(list.get(i2).a), " ret:", Long.valueOf(delete));
                            z = false;
                        } else if (!"6005".equalsIgnoreCase(list.get(i2).b)) {
                            i++;
                        }
                    }
                    try {
                        writableDatabase.setTransactionSuccessful();
                    } catch (Throwable unused) {
                    }
                    try {
                        writableDatabase.endTransaction();
                    } catch (Throwable unused2) {
                    }
                    this.d.a(writableDatabase);
                } else {
                    ya.c("UTSqliteLogStore", "db is null");
                    z = false;
                    i = 0;
                }
                ya.c("UTSqliteLogStore", "delete ", Integer.valueOf(list.size()), " isSuccess:", Boolean.valueOf(z));
                return i;
            }
        }
        return 0;
    }
}
