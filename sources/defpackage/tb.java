package defpackage;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;
/* compiled from: SecurityRequestAuth.java */
/* renamed from: tb  reason: default package */
/* loaded from: classes.dex */
public class tb implements sb {
    private String a;
    private String b;
    private Object c = null;
    private Object d = null;
    private Class e = null;
    private Field f = null;
    private Field g = null;
    private Field h = null;
    private Method i = null;
    private int j = 1;
    private boolean k = false;

    public tb(String str, String str2) {
        this.a = null;
        this.a = str;
        this.b = str2;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004a A[Catch: all -> 0x00c7, TRY_ENTER, TRY_LEAVE, TryCatch #6 {, blocks: (B:3:0x0001, B:39:0x00cf, B:15:0x0041, B:17:0x004a, B:23:0x0082, B:35:0x00ab, B:28:0x0099, B:21:0x0078), top: B:53:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private synchronized void a() {
        /*
            Method dump skipped, instructions count: 214
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.tb.a():void");
    }

    @Override // defpackage.sb
    public String getAppkey() {
        return this.a;
    }

    @Override // defpackage.sb
    public String getSign(String str) {
        Class cls;
        if (!this.k) {
            a();
        }
        if (this.a == null) {
            ya.c("SecurityRequestAuth", "There is no appkey,please check it!");
            return null;
        } else if (str == null || this.c == null || (cls = this.e) == null || this.f == null || this.g == null || this.h == null || this.i == null || this.d == null) {
            return null;
        } else {
            try {
                Object newInstance = cls.newInstance();
                this.f.set(newInstance, this.a);
                ((Map) this.g.get(newInstance)).put("INPUT", str);
                this.h.set(newInstance, Integer.valueOf(this.j));
                return (String) this.i.invoke(this.d, newInstance, this.b);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}
