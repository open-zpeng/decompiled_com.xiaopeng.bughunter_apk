package defpackage;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
/* compiled from: IOUtils.java */
/* renamed from: kd  reason: default package */
/* loaded from: classes.dex */
public class kd {
    public static void a(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Exception e) {
            ld.a(e);
        }
    }

    public static byte[] b(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        e(inputStream, byteArrayOutputStream);
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0034: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:22:0x0034 */
    public static byte[] c(Object obj) {
        ByteArrayOutputStream byteArrayOutputStream;
        ObjectOutputStream objectOutputStream;
        Closeable closeable;
        Closeable closeable2 = null;
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (Throwable th) {
                th = th;
                closeable2 = closeable;
            }
        } catch (IOException e) {
            e = e;
            byteArrayOutputStream = null;
            objectOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream = null;
        }
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream.writeObject(obj);
                objectOutputStream.flush();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                a(objectOutputStream);
                a(byteArrayOutputStream);
                return byteArray;
            } catch (IOException e2) {
                e = e2;
                ld.a(e);
                a(objectOutputStream);
                a(byteArrayOutputStream);
                return null;
            }
        } catch (IOException e3) {
            e = e3;
            objectOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            a(closeable2);
            a(byteArrayOutputStream);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v7 */
    public static Object d(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream;
        ObjectInputStream objectInputStream;
        try {
            if (bArr == 0) {
                return null;
            }
            try {
                byteArrayInputStream = new ByteArrayInputStream(bArr);
                try {
                    objectInputStream = new ObjectInputStream(byteArrayInputStream);
                    try {
                        Object readObject = objectInputStream.readObject();
                        a(objectInputStream);
                        a(byteArrayInputStream);
                        return readObject;
                    } catch (Exception e) {
                        e = e;
                        ld.a(e);
                        a(objectInputStream);
                        a(byteArrayInputStream);
                        return null;
                    }
                } catch (Exception e2) {
                    e = e2;
                    objectInputStream = null;
                } catch (Throwable th) {
                    th = th;
                    bArr = 0;
                    a(bArr);
                    a(byteArrayInputStream);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                objectInputStream = null;
                byteArrayInputStream = null;
            } catch (Throwable th2) {
                byteArrayInputStream = null;
                th = th2;
                bArr = 0;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static void e(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return;
            }
            outputStream.write(bArr, 0, read);
        }
    }
}
