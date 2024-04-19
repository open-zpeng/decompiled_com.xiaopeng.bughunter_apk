package defpackage;

import java.util.concurrent.Executor;
/* compiled from: ArchTaskExecutor.java */
/* renamed from: a  reason: default package */
/* loaded from: classes.dex */
public class a extends c {
    private static volatile a a;
    private static final Executor b = new ExecutorC0000a();
    private static final Executor c = new b();
    private c d;
    private c e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ArchTaskExecutor.java */
    /* renamed from: a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class ExecutorC0000a implements Executor {
        ExecutorC0000a() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a.d().c(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ArchTaskExecutor.java */
    /* renamed from: a$b */
    /* loaded from: classes.dex */
    public static class b implements Executor {
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a.d().a(runnable);
        }
    }

    private a() {
        defpackage.b bVar = new defpackage.b();
        this.e = bVar;
        this.d = bVar;
    }

    public static a d() {
        if (a != null) {
            return a;
        }
        synchronized (a.class) {
            if (a == null) {
                a = new a();
            }
        }
        return a;
    }

    @Override // defpackage.c
    public void a(Runnable runnable) {
        this.d.a(runnable);
    }

    @Override // defpackage.c
    public boolean b() {
        return this.d.b();
    }

    @Override // defpackage.c
    public void c(Runnable runnable) {
        this.d.c(runnable);
    }
}
