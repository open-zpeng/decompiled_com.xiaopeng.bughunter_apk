package defpackage;

import android.car.Car;
/* compiled from: IntrusionDetectPresenter.java */
/* renamed from: vd  reason: default package */
/* loaded from: classes.dex */
public class vd {
    private static volatile vd a;
    private nd b = new pd();

    /* compiled from: IntrusionDetectPresenter.java */
    /* renamed from: vd$a */
    /* loaded from: classes.dex */
    class a implements Runnable {
        final /* synthetic */ String b;
        final /* synthetic */ long c;

        a(String str, long j) {
            this.b = str;
            this.c = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            vd.this.b.a(this.b, this.c);
        }
    }

    private vd() {
    }

    public static vd b() {
        if (a == null) {
            synchronized (vd.class) {
                if (a == null) {
                    a = new vd();
                }
            }
        }
        return a;
    }

    private boolean c() {
        String xpCduType = Car.getXpCduType();
        xpCduType.hashCode();
        return xpCduType.equals("Q9");
    }

    public void d(String str, long j) {
        if (!c()) {
            tf.l("IntrusionDetectPresenter", "The car type is not supported!");
            return;
        }
        tf.a("IntrusionDetectPresenter", "uploadSystemInfo: Time = " + System.currentTimeMillis());
        if (this.b.c()) {
            tf.l("IntrusionDetectPresenter", "uploadSystemInfo is running, return!");
            this.b.b(str, j);
            return;
        }
        ag.i(new a(str, j));
    }
}
