package defpackage;

import java.util.Map;
/* compiled from: UTMCVariables.java */
/* renamed from: pa  reason: default package */
/* loaded from: classes.dex */
public class pa {
    public static final pa a = new pa();
    private boolean b = false;
    private boolean c = false;
    private String d = null;
    private Map<String, String> e = null;
    private boolean f = false;
    private boolean g = false;
    private String h = null;
    private String i = null;
    private String j = null;
    private boolean k = false;

    public static pa a() {
        return a;
    }

    public synchronized Map<String, String> b() {
        return this.e;
    }

    public synchronized void c(Map<String, String> map) {
        this.e = map;
    }

    public synchronized boolean d() {
        return this.g;
    }

    public synchronized void e(String str) {
        this.h = str;
    }

    public synchronized void f() {
        this.g = true;
    }
}
