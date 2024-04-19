package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.Choreographer;
import android.view.WindowManager;
/* compiled from: FPSFrameCallBack.java */
@SuppressLint({"NewApi"})
/* renamed from: of  reason: default package */
/* loaded from: classes.dex */
public class of implements Choreographer.FrameCallback {
    private static long a;
    private static long b;
    private long c;
    private long d;
    private kf e;

    public of(Context context, kf kfVar) {
        long a2 = 1.0E9f / a(context);
        this.d = a2;
        b = ((nf.a * 1000) * 1000) / a2;
        a = 5000000000L / a2;
        nf.a("FPSFrameCallBack", "SKIPPED_FRAME_WARNING_LIMIT : " + b + " ,SKIPPED_FRAME_ANR_TRIGGER : " + a);
        this.e = kfVar;
    }

    private float a(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRefreshRate();
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        long j2 = this.c;
        if (j2 == 0) {
            this.c = j;
            Choreographer.getInstance().postFrameCallback(this);
            return;
        }
        long j3 = j - j2;
        long j4 = this.d;
        if (j3 >= j4) {
            long j5 = j3 / j4;
            if (j5 >= b) {
                nf.a("FPSFrameCallBack", "Skipped " + j5 + " frames!  The application may be doing too much work on its main thread.");
                this.e.g(j5 >= a, j5);
            }
        }
        this.c = j;
        Choreographer.getInstance().postFrameCallback(this);
    }
}
