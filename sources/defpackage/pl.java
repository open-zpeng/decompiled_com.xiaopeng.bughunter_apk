package defpackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.apache.commons.io.IOUtils;
/* compiled from: WebSocketHandshake.java */
/* renamed from: pl  reason: default package */
/* loaded from: classes.dex */
public class pl {
    InputStream a;
    OutputStream b;
    String c;
    String d;
    int e;

    public pl(InputStream inputStream, OutputStream outputStream, String str, String str2, int i) {
        this.a = inputStream;
        this.b = outputStream;
        this.c = str;
        this.d = str2;
        this.e = i;
    }

    private Map b(ArrayList arrayList) {
        HashMap hashMap = new HashMap();
        for (int i = 1; i < arrayList.size(); i++) {
            String[] split = ((String) arrayList.get(i)).split(":");
            hashMap.put(split[0].toLowerCase(), split[1]);
        }
        return hashMap;
    }

    private void c(String str) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.a));
        ArrayList arrayList = new ArrayList();
        String readLine = bufferedReader.readLine();
        if (readLine != null) {
            while (!readLine.equals("")) {
                arrayList.add(readLine);
                readLine = bufferedReader.readLine();
            }
            Map b = b(arrayList);
            String str2 = (String) b.get("connection");
            if (str2 != null && !str2.equalsIgnoreCase("upgrade")) {
                String str3 = (String) b.get("upgrade");
                if (str3 != null && str3.toLowerCase().contains("websocket")) {
                    if (((String) b.get("sec-websocket-protocol")) != null) {
                        if (b.containsKey("sec-websocket-accept")) {
                            try {
                                f(str, (String) b.get("sec-websocket-accept"));
                                return;
                            } catch (NoSuchAlgorithmException e) {
                                throw new IOException(e.getMessage());
                            } catch (nl unused) {
                                throw new IOException("WebSocket Response header: Incorrect Sec-WebSocket-Key");
                            }
                        }
                        throw new IOException("WebSocket Response header: Missing Sec-WebSocket-Accept");
                    }
                    throw new IOException("WebSocket Response header: empty sec-websocket-protocol");
                }
                throw new IOException("WebSocket Response header: Incorrect upgrade.");
            }
            throw new IOException("WebSocket Response header: Incorrect connection header");
        }
        throw new IOException("WebSocket Response header: Invalid response from Server, It may not support WebSockets.");
    }

    private void d(String str) throws IOException {
        String userInfo;
        try {
            String str2 = "/mqtt";
            URI uri = new URI(this.c);
            if (uri.getRawPath() != null && !uri.getRawPath().isEmpty()) {
                str2 = uri.getRawPath();
                if (uri.getRawQuery() != null && !uri.getRawQuery().isEmpty()) {
                    str2 = String.valueOf(str2) + "?" + uri.getRawQuery();
                }
            }
            PrintWriter printWriter = new PrintWriter(this.b);
            printWriter.print("GET " + str2 + " HTTP/1.1" + IOUtils.LINE_SEPARATOR_WINDOWS);
            int i = this.e;
            if (i != 80 && i != 443) {
                printWriter.print("Host: " + this.d + ":" + this.e + IOUtils.LINE_SEPARATOR_WINDOWS);
            } else {
                printWriter.print("Host: " + this.d + IOUtils.LINE_SEPARATOR_WINDOWS);
            }
            printWriter.print("Upgrade: websocket\r\n");
            printWriter.print("Connection: Upgrade\r\n");
            printWriter.print("Sec-WebSocket-Key: " + str + IOUtils.LINE_SEPARATOR_WINDOWS);
            printWriter.print("Sec-WebSocket-Protocol: mqtt\r\n");
            printWriter.print("Sec-WebSocket-Version: 13\r\n");
            if (uri.getUserInfo() != null) {
                printWriter.print("Authorization: Basic " + ll.a(userInfo) + IOUtils.LINE_SEPARATOR_WINDOWS);
            }
            printWriter.print(IOUtils.LINE_SEPARATOR_WINDOWS);
            printWriter.flush();
        } catch (URISyntaxException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }

    private byte[] e(String str) throws NoSuchAlgorithmException {
        return MessageDigest.getInstance("SHA1").digest(str.getBytes());
    }

    private void f(String str, String str2) throws NoSuchAlgorithmException, nl {
        if (!ll.b(e(String.valueOf(str) + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11")).trim().equals(str2.trim())) {
            throw new nl();
        }
    }

    public void a() throws IOException {
        byte[] bArr = new byte[16];
        System.arraycopy(UUID.randomUUID().toString().getBytes(), 0, bArr, 0, 16);
        String b = ll.b(bArr);
        d(b);
        c(b);
    }
}
