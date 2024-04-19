package defpackage;

import java.io.File;
import java.io.FileFilter;
/* compiled from: PersistanceFileFilter.java */
/* renamed from: vm  reason: default package */
/* loaded from: classes.dex */
public class vm implements FileFilter {
    private final String a;

    public vm(String str) {
        this.a = str;
    }

    @Override // java.io.FileFilter
    public boolean accept(File file) {
        return file.getName().endsWith(this.a);
    }
}
