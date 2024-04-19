package defpackage;
/* compiled from: MqttException.java */
/* renamed from: jk  reason: default package */
/* loaded from: classes.dex */
public class jk extends Exception {
    private static final long serialVersionUID = 300;
    private int b;
    private Throwable c;

    public jk(int i) {
        this.b = i;
    }

    public int a() {
        return this.b;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.c;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return cl.b(this.b);
    }

    @Override // java.lang.Throwable
    public String toString() {
        String str = String.valueOf(getMessage()) + " (" + this.b + ")";
        if (this.c != null) {
            return String.valueOf(str) + " - " + this.c.toString();
        }
        return str;
    }

    public jk(Throwable th) {
        this.b = 0;
        this.c = th;
    }

    public jk(int i, Throwable th) {
        this.b = i;
        this.c = th;
    }
}
