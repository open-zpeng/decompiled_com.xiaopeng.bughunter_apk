package defpackage;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Callable;
/* compiled from: AndroidSchedulers.java */
/* renamed from: wg  reason: default package */
/* loaded from: classes.dex */
public final class wg {
    private static final tg a = vg.d(new a());

    /* compiled from: AndroidSchedulers.java */
    /* renamed from: wg$a */
    /* loaded from: classes.dex */
    static class a implements Callable<tg> {
        a() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public tg call() throws Exception {
            return b.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AndroidSchedulers.java */
    /* renamed from: wg$b */
    /* loaded from: classes.dex */
    public static final class b {
        static final tg a = new xg(new Handler(Looper.getMainLooper()));
    }

    private wg() {
        throw new AssertionError("No instances.");
    }

    public static tg a() {
        return vg.e(a);
    }
}
