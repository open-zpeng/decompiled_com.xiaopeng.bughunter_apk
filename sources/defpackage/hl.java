package defpackage;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
/* compiled from: TCPNetworkModule.java */
/* renamed from: hl  reason: default package */
/* loaded from: classes.dex */
public class hl implements el {
    private static final String a = "hl";
    private static final rm b = sm.a("org.eclipse.paho.client.mqttv3.internal.nls.logcat", hl.class.getName());
    protected Socket c;
    private SocketFactory d;
    private String e;
    private int f;
    private int g;

    public hl(SocketFactory socketFactory, String str, int i, String str2) {
        b.setResourceName(str2);
        this.d = socketFactory;
        this.e = str;
        this.f = i;
    }

    @Override // defpackage.el
    public String a() {
        return "tcp://" + this.e + ":" + this.f;
    }

    @Override // defpackage.el
    public OutputStream b() throws IOException {
        return this.c.getOutputStream();
    }

    @Override // defpackage.el
    public InputStream c() throws IOException {
        return this.c.getInputStream();
    }

    public void d(int i) {
        this.g = i;
    }

    @Override // defpackage.el
    public void start() throws IOException, jk {
        try {
            b.fine(a, "start", "252", new Object[]{this.e, new Integer(this.f), new Long(this.g * 1000)});
            InetSocketAddress inetSocketAddress = new InetSocketAddress(this.e, this.f);
            SocketFactory socketFactory = this.d;
            if (socketFactory instanceof SSLSocketFactory) {
                Socket socket = new Socket();
                socket.connect(inetSocketAddress, this.g * 1000);
                this.c = ((SSLSocketFactory) this.d).createSocket(socket, this.e, this.f, true);
                return;
            }
            Socket createSocket = socketFactory.createSocket();
            this.c = createSocket;
            createSocket.connect(inetSocketAddress, this.g * 1000);
        } catch (ConnectException e) {
            b.fine(a, "start", "250", null, e);
            throw new jk(32103, e);
        }
    }

    @Override // defpackage.el
    public void stop() throws IOException {
        Socket socket = this.c;
        if (socket != null) {
            socket.shutdownInput();
            this.c.close();
        }
    }
}
