package defpackage;

import java.io.IOException;
import java.io.InputStream;
/* compiled from: CountingInputStream.java */
/* renamed from: tl  reason: default package */
/* loaded from: classes.dex */
public class tl extends InputStream {
    private InputStream b;
    private int c = 0;

    public tl(InputStream inputStream) {
        this.b = inputStream;
    }

    public int a() {
        return this.c;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int read = this.b.read();
        if (read != -1) {
            this.c++;
        }
        return read;
    }
}
