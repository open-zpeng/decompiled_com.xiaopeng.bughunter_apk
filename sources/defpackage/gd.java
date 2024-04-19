package defpackage;

import defpackage.zc;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;
/* compiled from: ProgressRequestBody.java */
/* renamed from: gd  reason: default package */
/* loaded from: classes.dex */
public class gd<T> extends RequestBody {
    private RequestBody a;
    private jc<T> b;
    private c c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ProgressRequestBody.java */
    /* renamed from: gd$a */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        final /* synthetic */ zc b;

        a(zc zcVar) {
            this.b = zcVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (gd.this.b != null) {
                gd.this.b.uploadProgress(this.b);
            }
        }
    }

    /* compiled from: ProgressRequestBody.java */
    /* renamed from: gd$b */
    /* loaded from: classes.dex */
    private final class b extends ForwardingSink {
        private zc b;

        /* compiled from: ProgressRequestBody.java */
        /* renamed from: gd$b$a */
        /* loaded from: classes.dex */
        class a implements zc.a {
            a() {
            }

            @Override // defpackage.zc.a
            public void a(zc zcVar) {
                if (gd.this.c != null) {
                    gd.this.c.uploadProgress(zcVar);
                } else {
                    gd.this.d(zcVar);
                }
            }
        }

        b(Sink sink) {
            super(sink);
            zc zcVar = new zc();
            this.b = zcVar;
            zcVar.h = gd.this.contentLength();
        }

        @Override // okio.ForwardingSink, okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            super.write(buffer, j);
            zc.c(this.b, j, new a());
        }
    }

    /* compiled from: ProgressRequestBody.java */
    /* renamed from: gd$c */
    /* loaded from: classes.dex */
    public interface c {
        void uploadProgress(zc zcVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public gd(RequestBody requestBody, jc<T> jcVar) {
        this.a = requestBody;
        this.b = jcVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(zc zcVar) {
        jd.f(new a(zcVar));
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        try {
            return this.a.contentLength();
        } catch (IOException e) {
            ld.a(e);
            return -1L;
        }
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return this.a.contentType();
    }

    public void e(c cVar) {
        this.c = cVar;
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        BufferedSink buffer = Okio.buffer(new b(bufferedSink));
        this.a.writeTo(buffer);
        buffer.flush();
    }
}
