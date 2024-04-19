package defpackage;

import java.io.File;
import java.io.FilenameFilter;
/* compiled from: PersistanceFileNameFilter.java */
/* renamed from: wm  reason: default package */
/* loaded from: classes.dex */
public class wm implements FilenameFilter {
    private final String a;

    public wm(String str) {
        this.a = str;
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return str.endsWith(this.a);
    }
}
