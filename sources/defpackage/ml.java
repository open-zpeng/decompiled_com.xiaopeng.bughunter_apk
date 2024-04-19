package defpackage;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
/* compiled from: ExtendedByteArrayOutputStream.java */
/* renamed from: ml  reason: default package */
/* loaded from: classes.dex */
class ml extends ByteArrayOutputStream {
    final ql b;
    final sl c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ml(ql qlVar) {
        this.b = qlVar;
        this.c = null;
    }

    OutputStream a() throws IOException {
        ql qlVar = this.b;
        if (qlVar != null) {
            return qlVar.f();
        }
        sl slVar = this.c;
        if (slVar != null) {
            return slVar.i();
        }
        return null;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        ByteBuffer wrap;
        synchronized (this) {
            wrap = ByteBuffer.wrap(toByteArray());
            reset();
        }
        a().write(new ol((byte) 2, true, wrap.array()).d());
        a().flush();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ml(sl slVar) {
        this.b = null;
        this.c = slVar;
    }
}
