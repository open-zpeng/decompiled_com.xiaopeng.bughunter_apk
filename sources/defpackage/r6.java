package defpackage;

import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/* compiled from: TimeTypeAdapter.java */
/* renamed from: r6  reason: default package */
/* loaded from: classes.dex */
public final class r6 extends b8<Time> {
    public static final c8 a = new a();
    private final DateFormat b = new SimpleDateFormat("hh:mm:ss a");

    /* compiled from: TimeTypeAdapter.java */
    /* renamed from: r6$a */
    /* loaded from: classes.dex */
    static class a implements c8 {
        a() {
        }

        @Override // defpackage.c8
        public <T> b8<T> a(p7 p7Var, m7<T> m7Var) {
            if (m7Var.a() == Time.class) {
                return new r6();
            }
            return null;
        }
    }

    @Override // defpackage.b8
    /* renamed from: d */
    public synchronized Time c(i7 i7Var) throws IOException {
        if (i7Var.t() == j7.NULL) {
            i7Var.w();
            return null;
        }
        try {
            return new Time(this.b.parse(i7Var.v()).getTime());
        } catch (ParseException e) {
            throw new z7(e);
        }
    }

    @Override // defpackage.b8
    /* renamed from: e */
    public synchronized void a(k7 k7Var, Time time) throws IOException {
        k7Var.j(time == null ? null : this.b.format((Date) time));
    }
}
