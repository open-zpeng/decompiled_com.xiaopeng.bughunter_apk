package defpackage;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
/* compiled from: StackTraceCollector.java */
/* renamed from: jf  reason: default package */
/* loaded from: classes.dex */
public class jf implements mf {
    private long a;
    private volatile a b;
    private ArrayList<StackTraceElement[]> c;
    private int[] d;
    private StackTraceElement[] e;
    private Thread f;
    private int g;
    private volatile boolean h;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: StackTraceCollector.java */
    /* renamed from: jf$a */
    /* loaded from: classes.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 54 || i == 55) {
                if (i == 54) {
                    jf.this.n();
                }
                StackTraceElement[] j = jf.this.j();
                if (jf.l(j, jf.this.e)) {
                    jf.this.k();
                } else {
                    jf.this.i(j);
                }
                if (jf.this.m()) {
                    jf.this.o(55);
                }
            }
        }
    }

    public jf(long j) {
        this.a = j;
        HandlerThread handlerThread = new HandlerThread("StackTraceCollector");
        handlerThread.setPriority(10);
        handlerThread.start();
        this.b = new a(handlerThread.getLooper());
        this.g = 3;
        this.c = new ArrayList<>(3);
        this.d = new int[this.g];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public StackTraceElement[] j() {
        if (this.f == null) {
            this.f = Looper.getMainLooper().getThread();
        }
        return this.f.getStackTrace();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        synchronized (this.c) {
            int size = this.c.size() - 1;
            int[] iArr = this.d;
            iArr[size] = iArr[size] + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean l(StackTraceElement[] stackTraceElementArr, StackTraceElement[] stackTraceElementArr2) {
        int length;
        if (stackTraceElementArr == null || stackTraceElementArr2 == null || (length = stackTraceElementArr.length) != stackTraceElementArr2.length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (!stackTraceElementArr[i].equals(stackTraceElementArr2[i])) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        synchronized (this.c) {
            if (!this.c.isEmpty()) {
                this.e = null;
                this.c.clear();
                Arrays.fill(this.d, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(int i) {
        Message obtainMessage = this.b.obtainMessage();
        obtainMessage.obj = this;
        obtainMessage.what = i;
        this.b.sendMessageDelayed(obtainMessage, this.a);
    }

    @Override // defpackage.mf
    public StackTraceElement[][] a() {
        StackTraceElement[][] stackTraceElementArr;
        synchronized (this.c) {
            stackTraceElementArr = (StackTraceElement[][]) this.c.toArray((StackTraceElement[][]) Array.newInstance(StackTraceElement.class, 0, 0));
        }
        return stackTraceElementArr;
    }

    @Override // defpackage.mf
    public int[] b() {
        int[] copyOf;
        synchronized (this.c) {
            int[] iArr = this.d;
            copyOf = Arrays.copyOf(iArr, iArr.length);
        }
        return copyOf;
    }

    public void i(StackTraceElement[] stackTraceElementArr) {
        synchronized (this.c) {
            this.e = stackTraceElementArr;
            int size = this.c.size();
            int i = this.g;
            if (size >= i) {
                int i2 = i - 1;
                int i3 = this.d[i2];
                int i4 = i2;
                for (int i5 = i2 - 1; i5 >= 1; i5--) {
                    int[] iArr = this.d;
                    if (i3 > iArr[i5]) {
                        i3 = iArr[i5];
                        i4 = i5;
                    }
                }
                this.c.remove(i4);
                while (i4 < i2) {
                    int[] iArr2 = this.d;
                    int i6 = i4 + 1;
                    iArr2[i4] = iArr2[i6];
                    i4 = i6;
                }
                this.d[i2] = 0;
            }
            this.c.add(stackTraceElementArr);
            this.d[this.c.size() - 1] = 1;
        }
    }

    public boolean m() {
        return this.h;
    }

    @Override // defpackage.mf
    public void start() {
        this.h = true;
        o(54);
    }

    @Override // defpackage.mf
    public void stop() {
        this.h = false;
        this.b.removeMessages(54);
        this.b.removeMessages(55);
    }
}
