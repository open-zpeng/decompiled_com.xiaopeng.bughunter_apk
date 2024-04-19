package defpackage;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CleanTask.java */
/* renamed from: x8  reason: default package */
/* loaded from: classes.dex */
public class x8 implements Runnable {
    private static boolean b = false;
    private static long c = 300000;
    private static x8 d;

    private x8() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a() {
        ib.a().i(5);
        b = false;
        d = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b() {
        if (b) {
            return;
        }
        ya.c("CleanTask", "init TimeoutEventManager");
        d = new x8();
        ib.a().e(5, d, c);
        b = true;
    }

    @Override // java.lang.Runnable
    public void run() {
        ya.c("CleanTask", "clean TimeoutEvent");
        r8.b().r();
        ib.a().e(5, d, c);
    }
}
