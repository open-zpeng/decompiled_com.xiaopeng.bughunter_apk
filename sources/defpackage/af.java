package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
/* compiled from: SharedPreferenceHelper.java */
/* renamed from: af  reason: default package */
/* loaded from: classes.dex */
public class af {
    private static volatile af a;
    private SharedPreferences b;
    private SharedPreferences.Editor c;

    private af(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("local_data", 0);
        this.b = sharedPreferences;
        SharedPreferences.Editor edit = sharedPreferences.edit();
        this.c = edit;
        edit.apply();
    }

    public static af b(Context context) {
        if (a == null) {
            synchronized (af.class) {
                if (a == null) {
                    a = new af(context);
                }
            }
        }
        return a;
    }

    public boolean a(String str, boolean z) {
        return this.b.getBoolean(str, z);
    }

    public long c(String str, long j) {
        return this.b.getLong(str, j);
    }

    public void d(String str, boolean z) {
        this.c.putBoolean(str, z).apply();
    }

    public void e(String str, long j) {
        this.c.putLong(str, j).apply();
    }
}
