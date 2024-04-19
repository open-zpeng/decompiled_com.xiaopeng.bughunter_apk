package com.ut.mini.core.appstatus;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ScheduledFuture;
@TargetApi(14)
/* loaded from: classes.dex */
public class UTMCAppStatusMonitor implements Application.ActivityLifecycleCallbacks {
    private static UTMCAppStatusMonitor a;
    private int K = 0;
    private boolean T = false;

    /* renamed from: a  reason: collision with other field name */
    private ScheduledFuture<?> f131a = null;
    private Object e = new Object();
    private List<UTMCAppStatusCallbacks> m = new LinkedList();
    private Object f = new Object();

    /* loaded from: classes.dex */
    private class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            UTMCAppStatusMonitor.this.T = false;
            synchronized (UTMCAppStatusMonitor.this.f) {
                for (UTMCAppStatusCallbacks uTMCAppStatusCallbacks : UTMCAppStatusMonitor.this.m) {
                    uTMCAppStatusCallbacks.onSwitchBackground();
                }
            }
        }

        private a() {
        }
    }

    private UTMCAppStatusMonitor() {
    }

    private void J() {
        synchronized (this.e) {
            ib.a().i(11);
        }
    }

    public static synchronized UTMCAppStatusMonitor getInstance() {
        UTMCAppStatusMonitor uTMCAppStatusMonitor;
        synchronized (UTMCAppStatusMonitor.class) {
            if (a == null) {
                a = new UTMCAppStatusMonitor();
            }
            uTMCAppStatusMonitor = a;
        }
        return uTMCAppStatusMonitor;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        synchronized (this.f) {
            for (UTMCAppStatusCallbacks uTMCAppStatusCallbacks : this.m) {
                uTMCAppStatusCallbacks.onActivityCreated(activity, bundle);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        synchronized (this.f) {
            for (UTMCAppStatusCallbacks uTMCAppStatusCallbacks : this.m) {
                uTMCAppStatusCallbacks.onActivityDestroyed(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        synchronized (this.f) {
            for (UTMCAppStatusCallbacks uTMCAppStatusCallbacks : this.m) {
                uTMCAppStatusCallbacks.onActivityPaused(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        synchronized (this.f) {
            for (UTMCAppStatusCallbacks uTMCAppStatusCallbacks : this.m) {
                uTMCAppStatusCallbacks.onActivityResumed(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        synchronized (this.f) {
            for (UTMCAppStatusCallbacks uTMCAppStatusCallbacks : this.m) {
                uTMCAppStatusCallbacks.onActivitySaveInstanceState(activity, bundle);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        J();
        this.K++;
        if (!this.T) {
            synchronized (this.f) {
                for (UTMCAppStatusCallbacks uTMCAppStatusCallbacks : this.m) {
                    uTMCAppStatusCallbacks.onSwitchForeground();
                }
            }
        }
        this.T = true;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        int i = this.K - 1;
        this.K = i;
        if (i == 0) {
            J();
            ib.a().e(11, new a(), 1000L);
        }
    }

    public void registerAppStatusCallbacks(UTMCAppStatusCallbacks uTMCAppStatusCallbacks) {
        if (uTMCAppStatusCallbacks != null) {
            synchronized (this.f) {
                this.m.add(uTMCAppStatusCallbacks);
            }
        }
    }

    public void unregisterAppStatusCallbacks(UTMCAppStatusCallbacks uTMCAppStatusCallbacks) {
        if (uTMCAppStatusCallbacks != null) {
            synchronized (this.f) {
                this.m.remove(uTMCAppStatusCallbacks);
            }
        }
    }
}
