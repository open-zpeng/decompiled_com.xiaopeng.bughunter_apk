package defpackage;

import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import org.apache.commons.io.IOUtils;
/* compiled from: FileUtils.java */
/* renamed from: sf  reason: default package */
/* loaded from: classes.dex */
public class sf {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean b(String str, String str2) {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        boolean z = false;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    if (new File(str).exists()) {
                        fileInputStream = new FileInputStream(str);
                        try {
                            fileOutputStream = new FileOutputStream(str2);
                        } catch (Exception e) {
                            e = e;
                        }
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = fileInputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, read);
                            }
                            fileOutputStream.flush();
                            z = true;
                            fileOutputStream2 = fileOutputStream;
                        } catch (Exception e2) {
                            e = e2;
                            fileOutputStream2 = fileOutputStream;
                            e.printStackTrace();
                            if (fileOutputStream2 != null) {
                                try {
                                    fileOutputStream2.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            return z;
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream2 = fileOutputStream;
                            if (fileOutputStream2 != null) {
                                try {
                                    fileOutputStream2.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                            }
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } else {
                        fileInputStream = null;
                    }
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e7) {
                e = e7;
                fileInputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
        } catch (IOException e8) {
            e8.printStackTrace();
        }
        return z;
    }

    public static void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
                return;
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (int i = 0; i < listFiles.length; i++) {
                    c(listFiles[i].getAbsolutePath());
                    if (listFiles[i].isDirectory()) {
                        listFiles[i].delete();
                    }
                }
            }
            new File(str).delete();
        }
    }

    public static File d(String str, String str2) {
        File file;
        try {
            File file2 = new File(str);
            if (!file2.exists()) {
                file2.mkdirs();
            }
        } catch (Exception unused) {
        }
        File file3 = null;
        try {
            file = new File(str + str2);
        } catch (Exception e) {
            e = e;
        }
        try {
            if (file.exists()) {
                return file;
            }
            file.createNewFile();
            return file;
        } catch (Exception e2) {
            e = e2;
            file3 = file;
            e.printStackTrace();
            return file3;
        }
    }

    public static void e(String str, String str2, String str3) {
        File file;
        RandomAccessFile randomAccessFile;
        d(str2, str3);
        String str4 = str2 + str3;
        String str5 = str + IOUtils.LINE_SEPARATOR_WINDOWS;
        RandomAccessFile randomAccessFile2 = null;
        try {
            try {
                try {
                    file = new File(str4);
                    if (!file.exists()) {
                        file.getParentFile().mkdirs();
                        file.createNewFile();
                    }
                    randomAccessFile = new RandomAccessFile(file, "rwd");
                } catch (Exception e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                randomAccessFile.seek(file.length());
                randomAccessFile.write(str5.getBytes());
                randomAccessFile.close();
            } catch (Exception e2) {
                e = e2;
                randomAccessFile2 = randomAccessFile;
                tf.t("FileUtils", "writeTxtToFile error!", e);
                e.printStackTrace();
                if (randomAccessFile2 != null) {
                    randomAccessFile2.close();
                }
            } catch (Throwable th2) {
                th = th2;
                randomAccessFile2 = randomAccessFile;
                if (randomAccessFile2 != null) {
                    try {
                        randomAccessFile2.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException e4) {
            e4.printStackTrace();
        }
    }
}
