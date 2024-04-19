package defpackage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.irdeto.securesdk.core.SSUtils;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* compiled from: DBHelper.java */
/* renamed from: qc  reason: default package */
/* loaded from: classes.dex */
class qc extends SQLiteOpenHelper {
    static final Lock a = new ReentrantLock();
    private sc b;
    private sc c;
    private sc d;
    private sc e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public qc() {
        this(wb.h().f());
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(this.b.b());
        sQLiteDatabase.execSQL(this.c.b());
        sQLiteDatabase.execSQL(this.d.b());
        sQLiteDatabase.execSQL(this.e.b());
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        onUpgrade(sQLiteDatabase, i, i2);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (rc.a(sQLiteDatabase, this.b)) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS cache");
        }
        if (rc.a(sQLiteDatabase, this.c)) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS cookie");
        }
        if (rc.a(sQLiteDatabase, this.d)) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS download");
        }
        if (rc.a(sQLiteDatabase, this.e)) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS upload");
        }
        onCreate(sQLiteDatabase);
    }

    qc(Context context) {
        super(context, "okgo.db", (SQLiteDatabase.CursorFactory) null, 1);
        this.b = new sc(SSUtils.O00000o0);
        this.c = new sc("cookie");
        this.d = new sc("download");
        this.e = new sc("upload");
        this.b.a(new pc("key", "VARCHAR", true, true)).a(new pc("localExpire", "INTEGER")).a(new pc("head", "BLOB")).a(new pc("data", "BLOB"));
        this.c.a(new pc("host", "VARCHAR")).a(new pc("name", "VARCHAR")).a(new pc("domain", "VARCHAR")).a(new pc("cookie", "BLOB")).a(new pc("host", "name", "domain"));
        this.d.a(new pc("tag", "VARCHAR", true, true)).a(new pc("url", "VARCHAR")).a(new pc("folder", "VARCHAR")).a(new pc("filePath", "VARCHAR")).a(new pc("fileName", "VARCHAR")).a(new pc("fraction", "VARCHAR")).a(new pc("totalSize", "INTEGER")).a(new pc("currentSize", "INTEGER")).a(new pc("status", "INTEGER")).a(new pc("priority", "INTEGER")).a(new pc("date", "INTEGER")).a(new pc("request", "BLOB")).a(new pc("extra1", "BLOB")).a(new pc("extra2", "BLOB")).a(new pc("extra3", "BLOB"));
        this.e.a(new pc("tag", "VARCHAR", true, true)).a(new pc("url", "VARCHAR")).a(new pc("folder", "VARCHAR")).a(new pc("filePath", "VARCHAR")).a(new pc("fileName", "VARCHAR")).a(new pc("fraction", "VARCHAR")).a(new pc("totalSize", "INTEGER")).a(new pc("currentSize", "INTEGER")).a(new pc("status", "INTEGER")).a(new pc("priority", "INTEGER")).a(new pc("date", "INTEGER")).a(new pc("request", "BLOB")).a(new pc("extra1", "BLOB")).a(new pc("extra2", "BLOB")).a(new pc("extra3", "BLOB"));
    }
}
