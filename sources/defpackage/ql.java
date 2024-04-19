package defpackage;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import javax.net.SocketFactory;
/* compiled from: WebSocketNetworkModule.java */
/* renamed from: ql  reason: default package */
/* loaded from: classes.dex */
public class ql extends hl {
    private static final rm h = sm.a("org.eclipse.paho.client.mqttv3.internal.nls.logcat", ql.class.getName());
    private String i;
    private String j;
    private int k;
    private PipedInputStream l;
    private rl m;
    private ByteArrayOutputStream n;

    public ql(SocketFactory socketFactory, String str, String str2, int i, String str3) {
        super(socketFactory, str2, i, str3);
        this.n = new ml(this);
        this.i = str;
        this.j = str2;
        this.k = i;
        this.l = new PipedInputStream();
        h.setResourceName(str3);
    }

    @Override // defpackage.hl, defpackage.el
    public String a() {
        return "ws://" + this.j + ":" + this.k;
    }

    @Override // defpackage.hl, defpackage.el
    public OutputStream b() throws IOException {
        return this.n;
    }

    @Override // defpackage.hl, defpackage.el
    public InputStream c() throws IOException {
        return this.l;
    }

    InputStream e() throws IOException {
        return super.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OutputStream f() throws IOException {
        return super.b();
    }

    @Override // defpackage.hl, defpackage.el
    public void start() throws IOException, jk {
        super.start();
        new pl(e(), f(), this.i, this.j, this.k).a();
        rl rlVar = new rl(e(), this.l);
        this.m = rlVar;
        rlVar.b("webSocketReceiver");
    }

    @Override // defpackage.hl, defpackage.el
    public void stop() throws IOException {
        f().write(new ol((byte) 8, true, "1000".getBytes()).d());
        f().flush();
        rl rlVar = this.m;
        if (rlVar != null) {
            rlVar.c();
        }
        super.stop();
    }
}
