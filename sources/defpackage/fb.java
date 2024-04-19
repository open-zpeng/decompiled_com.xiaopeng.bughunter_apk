package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
/* compiled from: SpSetting.java */
/* renamed from: fb  reason: default package */
/* loaded from: classes.dex */
public class fb {
    public static void a(Context context, String str, String str2) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor edit;
        if (context == null || (sharedPreferences = context.getSharedPreferences("ut_setting", 4)) == null || (edit = sharedPreferences.edit()) == null) {
            return;
        }
        edit.putString(str, str2);
        edit.apply();
    }

    public static String b(Context context, String str) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getSharedPreferences("ut_setting", 4)) == null) {
            return null;
        }
        return sharedPreferences.getString(str, null);
    }
}
