package defpackage;

import android.os.Looper;
/* compiled from: MainThreadSupport.java */
/* renamed from: gn  reason: default package */
/* loaded from: classes.dex */
public interface gn {

    /* compiled from: MainThreadSupport.java */
    /* renamed from: gn$a */
    /* loaded from: classes.dex */
    public static class a implements gn {
        private final Looper a;

        public a(Looper looper) {
            this.a = looper;
        }

        @Override // defpackage.gn
        public kn a(bn bnVar) {
            return new en(bnVar, this.a, 10);
        }

        @Override // defpackage.gn
        public boolean b() {
            return this.a == Looper.myLooper();
        }
    }

    kn a(bn bnVar);

    boolean b();
}
