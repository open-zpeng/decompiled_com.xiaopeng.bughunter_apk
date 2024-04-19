package defpackage;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug;
import android.text.TextUtils;
import defpackage.lf;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.commons.io.IOUtils;
/* compiled from: BlockHandler.java */
/* renamed from: kf  reason: default package */
/* loaded from: classes.dex */
public class kf {
    private static ExecutorService a = Executors.newFixedThreadPool(1);
    private Context b;
    private mf c;
    private lf.c d;
    private StringBuilder e = new StringBuilder(4096);
    private List<String> f = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BlockHandler.java */
    /* renamed from: kf$a */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        final /* synthetic */ boolean b;
        final /* synthetic */ StackTraceElement[][] c;
        final /* synthetic */ int[] d;
        final /* synthetic */ long[] e;

        a(boolean z, StackTraceElement[][] stackTraceElementArr, int[] iArr, long[] jArr) {
            this.b = z;
            this.c = stackTraceElementArr;
            this.d = iArr;
            this.e = jArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z = !TextUtils.isEmpty(this.b ? kf.this.e() : "");
            kf.this.f.clear();
            StackTraceElement[][] stackTraceElementArr = this.c;
            if (stackTraceElementArr != null && stackTraceElementArr.length > 0) {
                int i = 0;
                for (StackTraceElement[] stackTraceElementArr2 : stackTraceElementArr) {
                    if (stackTraceElementArr2 != null && stackTraceElementArr2.length > 0) {
                        if (kf.this.e.length() > 0) {
                            kf.this.e.delete(0, kf.this.e.length());
                        }
                        StringBuilder sb = kf.this.e;
                        sb.append("-----");
                        sb.append("main");
                        sb.append(" repeat ");
                        sb.append(this.d[i]);
                        sb.append(IOUtils.LINE_SEPARATOR_UNIX);
                        for (StackTraceElement stackTraceElement : stackTraceElementArr2) {
                            StringBuilder sb2 = kf.this.e;
                            sb2.append("\tat ");
                            sb2.append(stackTraceElement.toString());
                            sb2.append(IOUtils.LINE_SEPARATOR_UNIX);
                        }
                    }
                    kf.this.f.add(kf.this.e.toString());
                    i++;
                }
            }
            String[] strArr = (String[]) kf.this.f.toArray(new String[0]);
            if (strArr.length == 0) {
                return;
            }
            kf.this.d.a(strArr, z, this.e);
        }
    }

    public kf(Context context, mf mfVar, lf.c cVar) {
        this.b = context;
        this.c = mfVar;
        this.d = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String e() {
        List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = ((ActivityManager) this.b.getSystemService("activity")).getProcessesInErrorState();
        if (processesInErrorState != null) {
            for (ActivityManager.ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
                if (processErrorStateInfo.condition == 2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(processErrorStateInfo.processName);
                    sb.append(IOUtils.LINE_SEPARATOR_UNIX);
                    sb.append(processErrorStateInfo.shortMsg);
                    sb.append(IOUtils.LINE_SEPARATOR_UNIX);
                    sb.append(processErrorStateInfo.longMsg);
                    nf.a("BlockHandler", sb.toString());
                    return sb.toString();
                }
            }
            return "";
        }
        return "";
    }

    private Runnable f(StackTraceElement[][] stackTraceElementArr, int[] iArr, boolean z, long... jArr) {
        return new a(z, stackTraceElementArr, iArr, jArr);
    }

    public void g(boolean z, long... jArr) {
        if (this.d == null || Debug.isDebuggerConnected()) {
            return;
        }
        a.execute(f(this.c.a(), this.c.b(), z, jArr));
    }

    public void h() {
        this.c.start();
    }

    public void i() {
        this.c.stop();
    }
}
