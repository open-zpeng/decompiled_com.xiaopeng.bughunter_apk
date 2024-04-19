package defpackage;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* compiled from: NetworkModule.java */
/* renamed from: el  reason: default package */
/* loaded from: classes.dex */
public interface el {
    String a();

    OutputStream b() throws IOException;

    InputStream c() throws IOException;

    void start() throws IOException, jk;

    void stop() throws IOException;
}
