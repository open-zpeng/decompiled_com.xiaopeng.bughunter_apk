package defpackage;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import javax.net.ssl.SSLSocketFactory;
/* compiled from: WebSocketSecureNetworkModule.java */
/* renamed from: sl  reason: default package */
/* loaded from: classes.dex */
public class sl extends gl {
    private static final rm o = sm.a("org.eclipse.paho.client.mqttv3.internal.nls.logcat", sl.class.getName());
    private PipedInputStream p;
    private rl q;
    private String r;
    private String s;
    private int t;
    private ByteArrayOutputStream u;

    public sl(SSLSocketFactory sSLSocketFactory, String str, String str2, int i, String str3) {
        super(sSLSocketFactory, str2, i, str3);
        this.u = new ml(this);
        this.r = str;
        this.s = str2;
        this.t = i;
        this.p = new PipedInputStream();
        o.setResourceName(str3);
    }

    @Override // defpackage.gl, defpackage.hl, defpackage.el
    public String a() {
        return "wss://" + this.s + ":" + this.t;
    }

    @Override // defpackage.hl, defpackage.el
    public OutputStream b() throws IOException {
        return this.u;
    }

    @Override // defpackage.hl, defpackage.el
    public InputStream c() throws IOException {
        return this.p;
    }

    InputStream h() throws IOException {
        return super.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OutputStream i() throws IOException {
        return super.b();
    }

    @Override // defpackage.gl, defpackage.hl, defpackage.el
    public void start() throws IOException, jk {
        super.start();
        new pl(super.c(), super.b(), this.r, this.s, this.t).a();
        rl rlVar = new rl(h(), this.p);
        this.q = rlVar;
        rlVar.b("WssSocketReceiver");
    }

    @Override // defpackage.hl, defpackage.el
    public void stop() throws IOException {
        i().write(new ol((byte) 8, true, "1000".getBytes()).d());
        i().flush();
        rl rlVar = this.q;
        if (rlVar != null) {
            rlVar.c();
        }
        super.stop();
    }
}
