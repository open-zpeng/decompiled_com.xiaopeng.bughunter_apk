package defpackage;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* compiled from: FileLock.java */
/* renamed from: al  reason: default package */
/* loaded from: classes.dex */
public class al {
    private File a;
    private RandomAccessFile b;
    private Object c;

    public al(File file, String str) throws Exception {
        this.a = new File(file, str);
        if (zk.c("java.nio.channels.FileLock")) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(this.a, "rw");
                this.b = randomAccessFile;
                Object invoke = randomAccessFile.getClass().getMethod("getChannel", new Class[0]).invoke(this.b, new Object[0]);
                this.c = invoke.getClass().getMethod("tryLock", new Class[0]).invoke(invoke, new Object[0]);
            } catch (IllegalAccessException unused) {
                this.c = null;
            } catch (IllegalArgumentException unused2) {
                this.c = null;
            } catch (NoSuchMethodException unused3) {
                this.c = null;
            }
            if (this.c != null) {
                return;
            }
            a();
            throw new Exception("Problem obtaining file lock");
        }
    }

    public void a() {
        try {
            Object obj = this.c;
            if (obj != null) {
                obj.getClass().getMethod("release", new Class[0]).invoke(this.c, new Object[0]);
                this.c = null;
            }
        } catch (Exception unused) {
        }
        RandomAccessFile randomAccessFile = this.b;
        if (randomAccessFile != null) {
            try {
                randomAccessFile.close();
            } catch (IOException unused2) {
            }
            this.b = null;
        }
        File file = this.a;
        if (file != null && file.exists()) {
            this.a.delete();
        }
        this.a = null;
    }
}
