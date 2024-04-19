package com.xiaopeng.lib.themeswitch;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes.dex */
public class ThreadPoolHelper {
    private static final String TAG = "ThreadPoolHelper";
    private static volatile ThreadPoolHelper sInstance;
    private static Handler sMainThreadHandler = new Handler(Looper.getMainLooper());
    private ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

    private ThreadPoolHelper() {
    }

    public static ThreadPoolHelper getInstance() {
        if (sInstance == null) {
            synchronized (ThreadPoolHelper.class) {
                if (sInstance == null) {
                    sInstance = new ThreadPoolHelper();
                }
            }
        }
        return sInstance;
    }

    public static void postBackground(final Runnable runnable) {
        if (runnable == null) {
            return;
        }
        getInstance().execute(new Runnable() { // from class: com.xiaopeng.lib.themeswitch.ThreadPoolHelper.1
            @Override // java.lang.Runnable
            public void run() {
                Process.setThreadPriority(10);
                runnable.run();
            }
        });
    }

    public static void postMainThread(Runnable runnable) {
        sMainThreadHandler.post(runnable);
    }

    public void execute(Runnable runnable) {
        this.cachedThreadPool.execute(runnable);
    }

    public static void postMainThread(Runnable runnable, long j) {
        sMainThreadHandler.postDelayed(runnable, j);
    }
}
