package defpackage;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.xiaopeng.lib.security.xmartv1.XmartV1Constants;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
/* compiled from: HttpLoggingInterceptor.java */
/* renamed from: wc  reason: default package */
/* loaded from: classes.dex */
public class wc implements Interceptor {
    private static final Charset a = Charset.forName(XmartV1Constants.UTF8_ENCODING);
    private volatile a b = a.NONE;
    private Level c;
    private Logger d;

    /* compiled from: HttpLoggingInterceptor.java */
    /* renamed from: wc$a */
    /* loaded from: classes.dex */
    public enum a {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    public wc(String str) {
        this.d = Logger.getLogger(str);
    }

    private void a(Request request) {
        try {
            RequestBody body = request.newBuilder().build().body();
            if (body == null) {
                return;
            }
            Buffer buffer = new Buffer();
            body.writeTo(buffer);
            Charset b = b(body.contentType());
            d("\tbody:" + buffer.readString(b));
        } catch (Exception e) {
            ld.a(e);
        }
    }

    private static Charset b(MediaType mediaType) {
        Charset charset = mediaType != null ? mediaType.charset(a) : a;
        return charset == null ? a : charset;
    }

    private static boolean c(MediaType mediaType) {
        if (mediaType == null) {
            return false;
        }
        if (mediaType.type() == null || !mediaType.type().equals("text")) {
            String subtype = mediaType.subtype();
            if (subtype != null) {
                String lowerCase = subtype.toLowerCase();
                if (lowerCase.contains("x-www-form-urlencoded") || lowerCase.contains("json") || lowerCase.contains("xml") || lowerCase.contains("html")) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    private void d(String str) {
        this.d.log(this.c, str);
    }

    private void e(Request request, Connection connection) throws IOException {
        StringBuilder sb;
        a aVar = this.b;
        a aVar2 = a.BODY;
        boolean z = aVar == aVar2;
        boolean z2 = this.b == aVar2 || this.b == a.HEADERS;
        RequestBody body = request.body();
        boolean z3 = body != null;
        Protocol protocol = connection != null ? connection.protocol() : Protocol.HTTP_1_1;
        try {
            try {
                d("--> " + request.method() + ' ' + request.url() + ' ' + protocol);
                if (z2) {
                    if (z3) {
                        if (body.contentType() != null) {
                            d("\tContent-Type: " + body.contentType());
                        }
                        if (body.contentLength() != -1) {
                            d("\tContent-Length: " + body.contentLength());
                        }
                    }
                    Headers headers = request.headers();
                    int size = headers.size();
                    for (int i = 0; i < size; i++) {
                        String name = headers.name(i);
                        if (!"Content-Type".equalsIgnoreCase(name) && !HttpHeaders.CONTENT_LENGTH.equalsIgnoreCase(name)) {
                            d("\t" + name + ": " + headers.value(i));
                        }
                    }
                    d(" ");
                    if (z && z3) {
                        if (c(body.contentType())) {
                            a(request);
                        } else {
                            d("\tbody: maybe [binary body], omitted!");
                        }
                    }
                }
                sb = new StringBuilder();
            } catch (Exception e) {
                ld.a(e);
                sb = new StringBuilder();
            }
            sb.append("--> END ");
            sb.append(request.method());
            d(sb.toString());
        } catch (Throwable th) {
            d("--> END " + request.method());
            throw th;
        }
    }

    private Response f(Response response, long j) {
        Headers headers;
        Response build = response.newBuilder().build();
        ResponseBody body = build.body();
        a aVar = this.b;
        a aVar2 = a.BODY;
        boolean z = true;
        boolean z2 = aVar == aVar2;
        if (this.b != aVar2 && this.b != a.HEADERS) {
            z = false;
        }
        try {
            try {
                d("<-- " + build.code() + ' ' + build.message() + ' ' + build.request().url() + " (" + j + "ms）");
                if (z) {
                    int size = build.headers().size();
                    for (int i = 0; i < size; i++) {
                        d("\t" + headers.name(i) + ": " + headers.value(i));
                    }
                    d(" ");
                    if (z2 && okhttp3.internal.http.HttpHeaders.hasBody(build)) {
                        if (body == null) {
                            return response;
                        }
                        if (c(body.contentType())) {
                            byte[] b = kd.b(body.byteStream());
                            d("\tbody:" + new String(b, b(body.contentType())));
                            return response.newBuilder().body(ResponseBody.create(body.contentType(), b)).build();
                        }
                        d("\tbody: maybe [binary body], omitted!");
                    }
                }
            } catch (Exception e) {
                ld.a(e);
            }
            return response;
        } finally {
            d("<-- END HTTP");
        }
    }

    public void g(Level level) {
        this.c = level;
    }

    public void h(a aVar) {
        Objects.requireNonNull(this.b, "printLevel == null. Use Level.NONE instead.");
        this.b = aVar;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        if (this.b == a.NONE) {
            return chain.proceed(request);
        }
        e(request, chain.connection());
        long nanoTime = System.nanoTime();
        try {
            return f(chain.proceed(request), TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime));
        } catch (Exception e) {
            d("<-- HTTP FAILED: " + e);
            throw e;
        }
    }
}
