package defpackage;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug;
import android.text.TextUtils;
/* compiled from: ProcessUtils.java */
/* renamed from: wf  reason: default package */
/* loaded from: classes.dex */
public class wf {
    public static long a(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
            if (!TextUtils.isEmpty(runningAppProcessInfo.processName) && runningAppProcessInfo.processName.equals(context.getPackageName())) {
                Debug.MemoryInfo[] processMemoryInfo = activityManager.getProcessMemoryInfo(new int[]{runningAppProcessInfo.pid});
                return (processMemoryInfo[0].dalvikSharedDirty + processMemoryInfo[0].dalvikPrivateDirty) * 1024;
            }
        }
        return 0L;
    }

    public static long b(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    public static long c(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.totalMem;
    }
}
