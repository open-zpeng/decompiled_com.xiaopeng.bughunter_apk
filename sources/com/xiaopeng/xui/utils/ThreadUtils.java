package com.xiaopeng.xui.utils;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class ThreadUtils {
    private static final int CORE_THREADS = 0;
    private static final int MAX_THREADS = 1000;
    private static final long MAX_ALIVE = 60;
    private static ExecutorService mExecutor = new ThreadPoolExecutor(0, 1000, (long) MAX_ALIVE, TimeUnit.SECONDS, new SynchronousQueue(), new DefaultThreadFactory());

    /* loaded from: classes.dex */
    static class DefaultThreadFactory implements ThreadFactory {
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final ThreadGroup group;
        private final String namePrefix;
        private final AtomicInteger threadNumber = new AtomicInteger(1);

        DefaultThreadFactory() {
            SecurityManager securityManager = System.getSecurityManager();
            this.group = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.namePrefix = "xui-" + poolNumber.getAndIncrement() + "-thread-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            ThreadGroup threadGroup = this.group;
            Thread thread = new Thread(threadGroup, runnable, this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }
    }

    public static void runInBackground(Runnable runnable) {
        mExecutor.submit(runnable);
    }

    public static void runOnMainThread(Runnable runnable) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
        } else {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    public static void runOnMainThread(Runnable runnable, long j) {
        new Handler(Looper.getMainLooper()).postDelayed(runnable, j);
    }
}
