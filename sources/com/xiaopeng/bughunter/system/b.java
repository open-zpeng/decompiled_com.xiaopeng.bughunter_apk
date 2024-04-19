package com.xiaopeng.bughunter.system;

import android.content.Context;
/* compiled from: IcmCrashListener.java */
/* loaded from: classes.dex */
public class b {
    private Context a;
    private boolean b;
    private qe c;
    private ud d;
    private oe e;

    /* compiled from: IcmCrashListener.java */
    /* loaded from: classes.dex */
    class a extends oe {
        a() {
        }

        @Override // defpackage.oe
        protected void b(String str) {
            tf.l("IcmCrashListener", "onIcmCrash : " + str);
            b.this.d.e(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: IcmCrashListener.java */
    /* renamed from: com.xiaopeng.bughunter.system.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0033b {
        private static final b a = new b(null);
    }

    /* synthetic */ b(a aVar) {
        this();
    }

    public static b b() {
        return C0033b.a;
    }

    private void d() {
        tf.l("IcmCrashListener", "initCaiAPI");
        qe qeVar = (qe) ge.f(103);
        this.c = qeVar;
        qeVar.b(this.e);
    }

    public b c(Context context) {
        this.a = context;
        this.d = new yd();
        return this;
    }

    public void e() {
        if (this.b) {
            return;
        }
        if (this.a != null) {
            try {
                if (this.c == null) {
                    d();
                    this.b = true;
                    return;
                }
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        throw new RuntimeException("Not initialize yet!!");
    }

    private b() {
        this.b = false;
        this.e = new a();
    }
}
