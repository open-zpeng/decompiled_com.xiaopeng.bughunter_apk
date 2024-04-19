package defpackage;

import com.google.gson.Gson;
/* compiled from: GlobalGsonInstance.java */
/* renamed from: ze  reason: default package */
/* loaded from: classes.dex */
public class ze {
    private Gson a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: GlobalGsonInstance.java */
    /* renamed from: ze$b */
    /* loaded from: classes.dex */
    public static class b {
        static final ze a = new ze();
    }

    public static ze b() {
        return b.a;
    }

    public Gson a() {
        return this.a;
    }

    private ze() {
        this.a = new Gson();
    }
}
