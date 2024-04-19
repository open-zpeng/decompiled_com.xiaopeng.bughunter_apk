package defpackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;
/* compiled from: MqttDefaultFilePersistence.java */
/* renamed from: um  reason: default package */
/* loaded from: classes.dex */
public class um implements gk {
    private static FilenameFilter a;
    private File b;
    private File c = null;
    private al d = null;

    public um(String str) {
        this.b = new File(str);
    }

    private void a() throws mk {
        if (this.c == null) {
            throw new mk();
        }
    }

    private static FilenameFilter b() {
        if (a == null) {
            a = new wm(".msg");
        }
        return a;
    }

    private File[] c() throws mk {
        a();
        File[] listFiles = this.c.listFiles(b());
        if (listFiles != null) {
            return listFiles;
        }
        throw new mk();
    }

    private boolean d(char c) {
        return Character.isJavaIdentifierPart(c) || c == '-';
    }

    private void e(File file) throws mk {
        File[] listFiles = file.listFiles(new vm(".bup"));
        if (listFiles != null) {
            for (int i = 0; i < listFiles.length; i++) {
                File file2 = new File(file, listFiles[i].getName().substring(0, listFiles[i].getName().length() - 4));
                if (!listFiles[i].renameTo(file2)) {
                    file2.delete();
                    listFiles[i].renameTo(file2);
                }
            }
            return;
        }
        throw new mk();
    }

    @Override // defpackage.gk
    public void clear() throws mk {
        a();
        for (File file : c()) {
            file.delete();
        }
        this.c.delete();
    }

    @Override // defpackage.gk
    public void close() throws mk {
        synchronized (this) {
            al alVar = this.d;
            if (alVar != null) {
                alVar.a();
            }
            if (c().length == 0) {
                this.c.delete();
            }
            this.c = null;
        }
    }

    @Override // defpackage.gk
    public boolean containsKey(String str) throws mk {
        a();
        File file = this.c;
        return new File(file, String.valueOf(str) + ".msg").exists();
    }

    @Override // defpackage.gk
    public lk get(String str) throws mk {
        a();
        try {
            File file = this.c;
            FileInputStream fileInputStream = new FileInputStream(new File(file, String.valueOf(str) + ".msg"));
            int available = fileInputStream.available();
            byte[] bArr = new byte[available];
            for (int i = 0; i < available; i += fileInputStream.read(bArr, i, available - i)) {
            }
            fileInputStream.close();
            return new dl(str, bArr, 0, available, null, 0, 0);
        } catch (IOException e) {
            throw new mk(e);
        }
    }

    @Override // defpackage.gk
    public Enumeration keys() throws mk {
        String name;
        a();
        File[] c = c();
        Vector vector = new Vector(c.length);
        for (File file : c) {
            vector.addElement(file.getName().substring(0, name.length() - 4));
        }
        return vector.elements();
    }

    @Override // defpackage.gk
    public void open(String str, String str2) throws mk {
        if (this.b.exists() && !this.b.isDirectory()) {
            throw new mk();
        }
        if (!this.b.exists() && !this.b.mkdirs()) {
            throw new mk();
        }
        if (this.b.canWrite()) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < str.length(); i++) {
                char charAt = str.charAt(i);
                if (d(charAt)) {
                    stringBuffer.append(charAt);
                }
            }
            stringBuffer.append("-");
            for (int i2 = 0; i2 < str2.length(); i2++) {
                char charAt2 = str2.charAt(i2);
                if (d(charAt2)) {
                    stringBuffer.append(charAt2);
                }
            }
            synchronized (this) {
                if (this.c == null) {
                    File file = new File(this.b, stringBuffer.toString());
                    this.c = file;
                    if (!file.exists()) {
                        this.c.mkdir();
                    }
                }
                try {
                    this.d = new al(this.c, ".lck");
                } catch (Exception unused) {
                }
                e(this.c);
            }
            return;
        }
        throw new mk();
    }

    @Override // defpackage.gk
    public void put(String str, lk lkVar) throws mk {
        a();
        File file = this.c;
        File file2 = new File(file, String.valueOf(str) + ".msg");
        File file3 = this.c;
        File file4 = new File(file3, String.valueOf(str) + ".msg.bup");
        if (file2.exists() && !file2.renameTo(file4)) {
            file4.delete();
            file2.renameTo(file4);
        }
        try {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                fileOutputStream.write(lkVar.e(), lkVar.b(), lkVar.f());
                if (lkVar.c() != null) {
                    fileOutputStream.write(lkVar.c(), lkVar.d(), lkVar.a());
                }
                fileOutputStream.getFD().sync();
                fileOutputStream.close();
                if (file4.exists()) {
                    file4.delete();
                }
            } catch (IOException e) {
                throw new mk(e);
            }
        } finally {
            if (file4.exists() && !file4.renameTo(file2)) {
                file2.delete();
                file4.renameTo(file2);
            }
        }
    }

    @Override // defpackage.gk
    public void remove(String str) throws mk {
        a();
        File file = this.c;
        File file2 = new File(file, String.valueOf(str) + ".msg");
        if (file2.exists()) {
            file2.delete();
        }
    }
}
