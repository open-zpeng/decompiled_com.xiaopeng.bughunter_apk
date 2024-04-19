package defpackage;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BackgroundTrigger.java */
/* renamed from: m8  reason: default package */
/* loaded from: classes.dex */
public class m8 implements Runnable {
    private static boolean b = false;
    private static boolean c = false;
    private Application d;
    private boolean e = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BackgroundTrigger.java */
    @TargetApi(14)
    /* renamed from: m8$a */
    /* loaded from: classes.dex */
    public class a implements Application.ActivityLifecycleCallbacks {
        private Runnable a;

        a(Runnable runnable) {
            this.a = runnable;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            ib.a().i(4);
            ib.a().e(4, this.a, 60000L);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            ib.a().i(4);
            ib.a().e(4, this.a, 60000L);
        }
    }

    public m8(Application application) {
        this.d = application;
    }

    private static boolean a(Context context) {
        String a2 = ra.a(context);
        ya.c("BackgroundTrigger", "[checkRuningProcess]:", a2);
        return (TextUtils.isEmpty(a2) || a2.indexOf(":") == -1) ? false : true;
    }

    @TargetApi(14)
    public static void b(Application application) {
        if (b) {
            return;
        }
        ya.c("BackgroundTrigger", "init BackgroundTrigger");
        c = a(application.getApplicationContext());
        m8 m8Var = new m8(application);
        if (c) {
            ib.a().e(4, m8Var, 60000L);
        } else if (Build.VERSION.SDK_INT >= 14) {
            application.registerActivityLifecycleCallbacks(new a(m8Var));
        }
        b = true;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i = 0;
        ya.c("BackgroundTrigger", "[bg check]");
        boolean b2 = ra.b(this.d.getApplicationContext());
        if (this.e != b2) {
            this.e = b2;
            if (b2) {
                n9.a().j();
                s8[] values = s8.values();
                int length = values.length;
                while (i < length) {
                    s8 s8Var = values[i];
                    f8.l(s8Var, s8Var.c());
                    i++;
                }
                ea.l();
            } else {
                s8[] values2 = s8.values();
                int length2 = values2.length;
                while (i < length2) {
                    s8 s8Var2 = values2[i];
                    f8.l(s8Var2, s8Var2.d());
                    i++;
                }
                f8.m();
                ea.k();
            }
        }
        if (c) {
            ib.a().e(4, this, 60000L);
        }
    }
}
