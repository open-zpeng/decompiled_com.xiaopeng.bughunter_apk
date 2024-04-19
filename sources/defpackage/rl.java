package defpackage;

import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
/* compiled from: WebSocketReceiver.java */
/* renamed from: rl  reason: default package */
/* loaded from: classes.dex */
public class rl implements Runnable {
    private static final String b;
    private static final rm c;
    private InputStream g;
    private volatile boolean i;
    private PipedOutputStream j;
    private boolean d = false;
    private boolean e = false;
    private Object f = new Object();
    private Thread h = null;

    static {
        String name = rl.class.getName();
        b = name;
        c = sm.a("org.eclipse.paho.client.mqttv3.internal.nls.logcat", name);
    }

    public rl(InputStream inputStream, PipedInputStream pipedInputStream) throws IOException {
        this.g = inputStream;
        PipedOutputStream pipedOutputStream = new PipedOutputStream();
        this.j = pipedOutputStream;
        pipedInputStream.connect(pipedOutputStream);
    }

    private void a() {
        try {
            this.j.close();
        } catch (IOException unused) {
        }
    }

    public void b(String str) {
        c.fine(b, "start", "855");
        synchronized (this.f) {
            if (!this.d) {
                this.d = true;
                Thread thread = new Thread(this, str);
                this.h = thread;
                thread.start();
            }
        }
    }

    public void c() {
        boolean z = true;
        this.e = true;
        synchronized (this.f) {
            c.fine(b, "stop", "850");
            if (this.d) {
                this.d = false;
                this.i = false;
                a();
            } else {
                z = false;
            }
        }
        if (z && !Thread.currentThread().equals(this.h)) {
            try {
                this.h.join();
            } catch (InterruptedException unused) {
            }
        }
        this.h = null;
        c.fine(b, "stop", "851");
    }

    @Override // java.lang.Runnable
    public void run() {
        while (this.d && this.g != null) {
            try {
                c.fine(b, "run", "852");
                this.i = this.g.available() > 0;
                ol olVar = new ol(this.g);
                if (!olVar.g()) {
                    for (int i = 0; i < olVar.f().length; i++) {
                        this.j.write(olVar.f()[i]);
                    }
                    this.j.flush();
                } else if (!this.e) {
                    throw new IOException("Server sent a WebSocket Frame with the Stop OpCode");
                    break;
                }
                this.i = false;
            } catch (IOException unused) {
                c();
            }
        }
    }
}
