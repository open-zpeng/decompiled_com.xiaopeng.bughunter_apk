package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
/* compiled from: SharedPreferencesUtils.java */
/* renamed from: xf  reason: default package */
/* loaded from: classes.dex */
public class xf {
    private static volatile xf a;
    private static int b;
    private SharedPreferences c;
    private SharedPreferences.Editor d;

    private xf(Context context, String str, int i) {
        str = TextUtils.isEmpty(str) ? context.getPackageName() : str;
        str = TextUtils.isEmpty(str) ? "shared_pref" : str;
        Log.v("SharedPreferencesUtils", "spName=" + str);
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        this.c = sharedPreferences;
        SharedPreferences.Editor edit = sharedPreferences.edit();
        this.d = edit;
        edit.apply();
    }

    public static xf b(Context context) {
        g(context);
        return a;
    }

    private static void g(Context context) {
        h(context, null);
    }

    private static void h(Context context, String str) {
        if (a == null) {
            synchronized (xf.class) {
                if (a == null) {
                    a = new xf(context.getApplicationContext(), str, 0);
                    b++;
                }
            }
        }
    }

    public float a(String str, float f) {
        return this.c.getFloat(str, f);
    }

    public int c(String str) {
        return d(str, -1);
    }

    public int d(String str, int i) {
        return this.c.getInt(str, i);
    }

    public String e(String str) {
        return f(str, null);
    }

    public String f(String str, String str2) {
        return this.c.getString(str, str2);
    }

    public void i(String str, float f) {
        this.d.putFloat(str, f).commit();
    }

    public void j(String str, int i) {
        this.d.putInt(str, i).commit();
    }

    public void k(String str, String str2) {
        this.d.putString(str, str2).commit();
    }
}
