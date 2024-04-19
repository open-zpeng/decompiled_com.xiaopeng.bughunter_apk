package defpackage;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import defpackage.h8;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* compiled from: AppMonitor.java */
/* renamed from: e8  reason: default package */
/* loaded from: classes.dex */
public final class e8 {
    private static Application a;
    protected static j b;
    private static HandlerThread c;
    private static volatile boolean d;
    protected static h8 e;
    private static String i;
    private static String j;
    private static boolean k;
    private static String l;
    private static Context n;
    private static String p;
    private static Object f = new Object();
    private static List<h> g = Collections.synchronizedList(new ArrayList());
    private static boolean h = false;
    private static i m = i.Local;
    private static ServiceConnection o = new c();
    private static Map<String, ?> q = Collections.synchronizedMap(new HashMap());

    /* compiled from: AppMonitor.java */
    /* renamed from: e8$a */
    /* loaded from: classes.dex */
    static class a implements Runnable {
        final /* synthetic */ Map b;

        a(Map map) {
            this.b = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                e8.e.R(this.b);
            } catch (RemoteException e) {
                e8.h(e);
            }
        }
    }

    /* compiled from: AppMonitor.java */
    /* renamed from: e8$b */
    /* loaded from: classes.dex */
    static class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                e8.e.e0();
            } catch (RemoteException e) {
                e8.h(e);
            }
        }
    }

    /* compiled from: AppMonitor.java */
    /* renamed from: e8$c */
    /* loaded from: classes.dex */
    static class c implements ServiceConnection {

        /* compiled from: AppMonitor.java */
        /* renamed from: e8$c$a */
        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e8.q();
            }
        }

        c() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            j jVar;
            if (i.Service == e8.m) {
                e8.e = h8.a.l0(iBinder);
                if (e8.h && (jVar = e8.b) != null) {
                    jVar.postAtFrontOfQueue(new a());
                }
            }
            synchronized (e8.f) {
                e8.f.notifyAll();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            ya.c("AppMonitor", "[onServiceDisconnected]");
            synchronized (e8.f) {
                e8.f.notifyAll();
            }
            boolean unused = e8.h = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AppMonitor.java */
    /* renamed from: e8$d */
    /* loaded from: classes.dex */
    public static class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                e8.e.init();
            } catch (RemoteException unused) {
                e8.g();
                try {
                    e8.e.init();
                } catch (Throwable unused2) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AppMonitor.java */
    /* renamed from: e8$e */
    /* loaded from: classes.dex */
    public static class e implements Runnable {
        final /* synthetic */ boolean b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;

        e(boolean z, String str, String str2, String str3) {
            this.b = z;
            this.c = str;
            this.d = str2;
            this.e = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                e8.e.G(this.b, this.c, this.d, this.e);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AppMonitor.java */
    /* renamed from: e8$f */
    /* loaded from: classes.dex */
    public static class f implements Runnable {
        final /* synthetic */ String b;

        f(String str) {
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                e8.e.K(this.b);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AppMonitor.java */
    /* renamed from: e8$g */
    /* loaded from: classes.dex */
    public static class g implements Runnable {
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ x9 d;
        final /* synthetic */ u9 e;
        final /* synthetic */ boolean f;

        g(String str, String str2, x9 x9Var, u9 u9Var, boolean z) {
            this.b = str;
            this.c = str2;
            this.d = x9Var;
            this.e = u9Var;
            this.f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ya.c("AppMonitor", "register stat event. module: ", this.b, " monitorPoint: ", this.c);
                e8.e.t(this.b, this.c, this.d, this.e, this.f);
            } catch (RemoteException e) {
                e8.h(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AppMonitor.java */
    /* renamed from: e8$h */
    /* loaded from: classes.dex */
    public static class h {
        public String a;
        public String b;
        public x9 c;
        public u9 d;
        public boolean e;

        h() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AppMonitor.java */
    /* renamed from: e8$i */
    /* loaded from: classes.dex */
    public enum i {
        Local,
        Service
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AppMonitor.java */
    /* renamed from: e8$j */
    /* loaded from: classes.dex */
    public static class j extends Handler {
        private boolean a;

        public j(Looper looper) {
            super(looper);
            this.a = false;
        }

        public void a(Runnable runnable) {
            if (runnable == null) {
                return;
            }
            try {
                Message obtain = Message.obtain();
                obtain.what = 1;
                obtain.obj = runnable;
                sendMessage(obtain);
            } catch (Throwable unused) {
            }
        }

        public void b(boolean z) {
            this.a = true;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                if (this.a) {
                    this.a = false;
                    synchronized (e8.f) {
                        try {
                            e8.f.wait(5000L);
                        } catch (InterruptedException unused) {
                            e8.g();
                        }
                    }
                }
                Object obj = message.obj;
                if (obj != null && (obj instanceof Runnable)) {
                    ((Runnable) obj).run();
                }
            } catch (Throwable unused2) {
            }
            super.handleMessage(message);
        }
    }

    private static Runnable c() {
        return new d();
    }

    private static Runnable d(String str) {
        return new f(str);
    }

    private static Runnable e(String str, String str2, x9 x9Var, u9 u9Var, boolean z) {
        return new g(str, str2, x9Var, u9Var, z);
    }

    private static Runnable f(boolean z, String str, String str2, String str3) {
        return new e(z, str, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g() {
        e = new i8(a);
        m = i.Local;
        ya.a("AppMonitor", "Start AppMonitor Service failed,AppMonitor run in local Mode...");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h(Exception exc) {
        ya.b("AppMonitor", "", exc);
        if (exc instanceof DeadObjectException) {
            q();
        }
    }

    private static boolean i() {
        Application application = a;
        if (application == null) {
            return false;
        }
        boolean bindService = application.getApplicationContext().bindService(new Intent(a.getApplicationContext(), g8.class), o, 1);
        if (!bindService) {
            g();
        }
        ya.c("AppMonitor", "bindsuccess:", Boolean.valueOf(bindService));
        return bindService;
    }

    public static boolean o() {
        if (!d) {
            ya.c("AppMonitor", "Please call UTAnalytics.getInstance().setAppApplicationInstance()||.setAppApplicationInstance4sdk() before call other method");
        }
        return d;
    }

    public static synchronized void p(Application application) {
        synchronized (e8.class) {
            ya.c("AppMonitor", "[init]");
            try {
                if (!d) {
                    a = application;
                    if (application != null) {
                        n = application.getApplicationContext();
                    }
                    HandlerThread handlerThread = new HandlerThread("AppMonitor_Client");
                    c = handlerThread;
                    handlerThread.start();
                    b = new j(c.getLooper());
                    if (m == i.Local) {
                        g();
                    } else if (i()) {
                        b.b(true);
                    }
                    c().run();
                    d = true;
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void q() {
        synchronized (e8.class) {
            ya.c("AppMonitor", "[restart]");
            try {
                if (h) {
                    h = false;
                    g();
                    c().run();
                    f(k, j, l, p).run();
                    d(i).run();
                    synchronized (g) {
                        for (int i2 = 0; i2 < g.size(); i2++) {
                            h hVar = g.get(i2);
                            if (hVar != null) {
                                try {
                                    e(hVar.a, hVar.b, hVar.c, hVar.d, hVar.e).run();
                                } catch (Throwable unused) {
                                }
                            }
                        }
                    }
                }
            } catch (Throwable unused2) {
            }
        }
    }

    public static void r(String str) {
        if (o()) {
            b.a(d(str));
            i = str;
        }
    }

    public static void s(boolean z, String str, String str2, String str3) {
        if (o()) {
            b.a(f(z, str, str2, str3));
            k = z;
            j = str;
            l = str2;
            p = str3;
        }
    }

    public static void t() {
        if (o()) {
            b.a(new b());
        }
    }

    public static void u(Map<String, String> map) {
        if (o()) {
            b.a(new a(map));
        }
    }
}
