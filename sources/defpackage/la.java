package defpackage;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.ut.mini.UTAnalytics;
import com.ut.mini.core.appstatus.UTMCAppStatusRegHelper;
import com.ut.mini.core.sign.IUTRequestAuthentication;
import com.ut.mini.internal.UTOriginalCustomHitBuilder;
import com.xiaopeng.lib.security.xmartv1.XmartV1Constants;
import java.io.UnsupportedEncodingException;
/* compiled from: UTMCStatConfig.java */
/* renamed from: la  reason: default package */
/* loaded from: classes.dex */
public class la {
    private static la a = new la();
    private Context b = null;
    private String c = null;
    private String d = null;
    private String e = null;
    private String f = null;
    private Application g = null;
    private String h = null;
    private IUTRequestAuthentication i = null;
    private boolean j = false;
    private boolean k = false;

    private la() {
    }

    public static la b() {
        return a;
    }

    private void c(String str) {
        Context context;
        this.c = str;
        if (!TextUtils.isEmpty(str)) {
            this.d = str;
        }
        if (TextUtils.isEmpty(str) || (context = this.b) == null) {
            return;
        }
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("UTCommon", 0).edit();
            edit.putString("_lun", new String(sa.c(str.getBytes(XmartV1Constants.UTF8_ENCODING), 2)));
            edit.commit();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private void d(String str) {
        Context context;
        this.e = str;
        if (!TextUtils.isEmpty(str)) {
            this.f = str;
        }
        if (TextUtils.isEmpty(str) || (context = this.b) == null) {
            return;
        }
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("UTCommon", 0).edit();
            edit.putString("_luid", new String(sa.c(str.getBytes(XmartV1Constants.UTF8_ENCODING), 2)));
            edit.commit();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private void g() {
        if (this.j || Build.VERSION.SDK_INT < 14) {
            return;
        }
        try {
            if (b().a() != null) {
                UTMCAppStatusRegHelper.registeActivityLifecycleCallbacks(b().a());
                this.j = true;
            } else {
                UTMCAppStatusRegHelper.registeActivityLifecycleCallbacks((Application) b().f().getApplicationContext());
                this.j = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("UTEngine", "You need set a application instance for UT.");
        }
    }

    public Application a() {
        return this.g;
    }

    public String e() {
        return this.h;
    }

    public Context f() {
        return this.b;
    }

    public void h(Application application) {
        this.g = application;
        g();
    }

    public void i(String str) {
        this.h = str;
    }

    public void j(Context context) {
        if (context != null) {
            this.b = context;
            SharedPreferences sharedPreferences = context.getSharedPreferences("UTCommon", 0);
            String string = sharedPreferences.getString("_lun", "");
            if (!TextUtils.isEmpty(string)) {
                try {
                    this.d = new String(sa.a(string.getBytes(), 2), XmartV1Constants.UTF8_ENCODING);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            String string2 = sharedPreferences.getString("_luid", "");
            if (!TextUtils.isEmpty(string2)) {
                try {
                    this.f = new String(sa.a(string2.getBytes(), 2), XmartV1Constants.UTF8_ENCODING);
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
            }
        }
        g();
    }

    public void k() {
        ya.e(true);
    }

    public void l(String str, String str2) {
        c(str);
        d(str2);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        UTAnalytics.getInstance().getDefaultTracker().send(new UTOriginalCustomHitBuilder("UT", 1007, str, str2, null, null).build());
    }
}
