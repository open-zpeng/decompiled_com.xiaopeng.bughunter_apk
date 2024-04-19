package defpackage;
/* compiled from: OnErrorNotImplementedException.java */
/* renamed from: fh  reason: default package */
/* loaded from: classes.dex */
public final class fh extends RuntimeException {
    private static final long serialVersionUID = -6298857009889503852L;

    public fh(Throwable th) {
        super(th != null ? th.getMessage() : null, th == null ? new NullPointerException() : th);
    }
}
