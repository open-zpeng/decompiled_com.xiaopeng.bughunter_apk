package defpackage;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Printer;
/* compiled from: UILooperObserver.java */
/* renamed from: pf  reason: default package */
/* loaded from: classes.dex */
public class pf implements Printer {
    private long a = 0;
    private long b = 0;
    private kf c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UILooperObserver.java */
    /* renamed from: pf$a */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x0058  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0074  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0080 A[Catch: InvocationTargetException -> 0x009d, IllegalAccessException -> 0x00a7, TryCatch #9 {IllegalAccessException -> 0x00a7, InvocationTargetException -> 0x009d, blocks: (B:37:0x0075, B:40:0x0080, B:42:0x008e, B:44:0x0097, B:43:0x0094), top: B:53:0x0075 }] */
        /* JADX WARN: Removed duplicated region for block: B:61:0x007f A[SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r10 = this;
                java.lang.String r0 = "UILooperObserver"
                android.os.Looper r1 = android.os.Looper.getMainLooper()
                r2 = 0
                r3 = 1
                r4 = 0
                java.lang.Class r5 = r1.getClass()     // Catch: java.lang.IllegalAccessException -> L3b java.lang.NoSuchMethodException -> L42 java.lang.NoSuchFieldException -> L49
                java.lang.String r6 = "mQueue"
                java.lang.reflect.Field r5 = r5.getDeclaredField(r6)     // Catch: java.lang.IllegalAccessException -> L3b java.lang.NoSuchMethodException -> L42 java.lang.NoSuchFieldException -> L49
                r5.setAccessible(r3)     // Catch: java.lang.IllegalAccessException -> L3b java.lang.NoSuchMethodException -> L42 java.lang.NoSuchFieldException -> L49
                java.lang.Object r1 = r5.get(r1)     // Catch: java.lang.IllegalAccessException -> L3b java.lang.NoSuchMethodException -> L42 java.lang.NoSuchFieldException -> L49
                android.os.MessageQueue r1 = (android.os.MessageQueue) r1     // Catch: java.lang.IllegalAccessException -> L3b java.lang.NoSuchMethodException -> L42 java.lang.NoSuchFieldException -> L49
                java.lang.Class r5 = r1.getClass()     // Catch: java.lang.IllegalAccessException -> L32 java.lang.NoSuchMethodException -> L35 java.lang.NoSuchFieldException -> L38
                java.lang.String r6 = "next"
                java.lang.Class[] r7 = new java.lang.Class[r4]     // Catch: java.lang.IllegalAccessException -> L32 java.lang.NoSuchMethodException -> L35 java.lang.NoSuchFieldException -> L38
                java.lang.reflect.Method r5 = r5.getDeclaredMethod(r6, r7)     // Catch: java.lang.IllegalAccessException -> L32 java.lang.NoSuchMethodException -> L35 java.lang.NoSuchFieldException -> L38
                r5.setAccessible(r3)     // Catch: java.lang.IllegalAccessException -> L2c java.lang.NoSuchMethodException -> L2e java.lang.NoSuchFieldException -> L30
                goto L4f
            L2c:
                r6 = move-exception
                goto L3e
            L2e:
                r6 = move-exception
                goto L45
            L30:
                r6 = move-exception
                goto L4c
            L32:
                r6 = move-exception
                r5 = r2
                goto L3e
            L35:
                r6 = move-exception
                r5 = r2
                goto L45
            L38:
                r6 = move-exception
                r5 = r2
                goto L4c
            L3b:
                r6 = move-exception
                r1 = r2
                r5 = r1
            L3e:
                r6.printStackTrace()
                goto L4f
            L42:
                r6 = move-exception
                r1 = r2
                r5 = r1
            L45:
                r6.printStackTrace()
                goto L4f
            L49:
                r6 = move-exception
                r1 = r2
                r5 = r1
            L4c:
                r6.printStackTrace()
            L4f:
                android.os.Binder.clearCallingIdentity()
                int r6 = android.os.Build.VERSION.SDK_INT
                r7 = 21
                if (r6 < r7) goto L74
                android.os.Message r6 = android.os.Message.obtain()
                java.lang.Class r7 = r6.getClass()     // Catch: java.lang.NoSuchMethodException -> L69
                java.lang.String r8 = "recycleUnchecked"
                java.lang.Class[] r9 = new java.lang.Class[r4]     // Catch: java.lang.NoSuchMethodException -> L69
                java.lang.reflect.Method r2 = r7.getDeclaredMethod(r8, r9)     // Catch: java.lang.NoSuchMethodException -> L69
                goto L6d
            L69:
                r7 = move-exception
                r7.printStackTrace()
            L6d:
                r2.setAccessible(r3)
                r6.recycle()
                goto L75
            L74:
                r3 = r4
            L75:
                java.lang.Object[] r6 = new java.lang.Object[r4]     // Catch: java.lang.reflect.InvocationTargetException -> L9d java.lang.IllegalAccessException -> La7
                java.lang.Object r6 = r5.invoke(r1, r6)     // Catch: java.lang.reflect.InvocationTargetException -> L9d java.lang.IllegalAccessException -> La7
                android.os.Message r6 = (android.os.Message) r6     // Catch: java.lang.reflect.InvocationTargetException -> L9d java.lang.IllegalAccessException -> La7
                if (r6 != 0) goto L80
                return
            L80:
                pf r7 = defpackage.pf.this     // Catch: java.lang.reflect.InvocationTargetException -> L9d java.lang.IllegalAccessException -> La7
                defpackage.pf.a(r7)     // Catch: java.lang.reflect.InvocationTargetException -> L9d java.lang.IllegalAccessException -> La7
                android.os.Handler r7 = r6.getTarget()     // Catch: java.lang.reflect.InvocationTargetException -> L9d java.lang.IllegalAccessException -> La7
                r7.dispatchMessage(r6)     // Catch: java.lang.reflect.InvocationTargetException -> L9d java.lang.IllegalAccessException -> La7
                if (r3 == 0) goto L94
                java.lang.Object[] r7 = new java.lang.Object[r4]     // Catch: java.lang.reflect.InvocationTargetException -> L9d java.lang.IllegalAccessException -> La7
                r2.invoke(r6, r7)     // Catch: java.lang.reflect.InvocationTargetException -> L9d java.lang.IllegalAccessException -> La7
                goto L97
            L94:
                r6.recycle()     // Catch: java.lang.reflect.InvocationTargetException -> L9d java.lang.IllegalAccessException -> La7
            L97:
                pf r6 = defpackage.pf.this     // Catch: java.lang.reflect.InvocationTargetException -> L9d java.lang.IllegalAccessException -> La7
                defpackage.pf.b(r6)     // Catch: java.lang.reflect.InvocationTargetException -> L9d java.lang.IllegalAccessException -> La7
                goto L75
            L9d:
                r1 = move-exception
                r1.printStackTrace()
                java.lang.String r1 = "lib_Bughunter InvocationTargetException"
                android.util.Log.e(r0, r1)
                goto Lb0
            La7:
                r1 = move-exception
                r1.printStackTrace()
                java.lang.String r1 = "lib_Bughunter IllegalAccessException"
                android.util.Log.e(r0, r1)
            Lb0:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.pf.a.run():void");
        }
    }

    public pf(kf kfVar) {
        this.c = kfVar;
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.a = SystemClock.uptimeMillis();
        this.b = SystemClock.currentThreadTimeMillis();
        this.c.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.a != 0) {
            long uptimeMillis = SystemClock.uptimeMillis() - this.a;
            long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis() - this.b;
            this.c.i();
            if (uptimeMillis > nf.a) {
                this.c.g(uptimeMillis >= 5000, uptimeMillis, currentThreadTimeMillis);
            }
        }
    }

    private void e() {
        new Handler(Looper.getMainLooper()).post(new a());
    }

    @Override // android.util.Printer
    public void println(String str) {
        if (str.startsWith(">>>>> Dispatching to")) {
            c();
        } else if (str.startsWith("<<<<< Finished to")) {
            d();
        }
    }
}
