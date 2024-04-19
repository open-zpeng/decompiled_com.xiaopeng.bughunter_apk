package defpackage;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/* compiled from: SqlDateTypeAdapter.java */
/* renamed from: s6  reason: default package */
/* loaded from: classes.dex */
public final class s6 extends b8<Date> {
    public static final c8 a = new a();
    private final DateFormat b = new SimpleDateFormat("MMM d, yyyy");

    /* compiled from: SqlDateTypeAdapter.java */
    /* renamed from: s6$a */
    /* loaded from: classes.dex */
    static class a implements c8 {
        a() {
        }

        @Override // defpackage.c8
        public <T> b8<T> a(p7 p7Var, m7<T> m7Var) {
            if (m7Var.a() == Date.class) {
                return new s6();
            }
            return null;
        }
    }

    @Override // defpackage.b8
    /* renamed from: d */
    public synchronized Date c(i7 i7Var) throws IOException {
        if (i7Var.t() == j7.NULL) {
            i7Var.w();
            return null;
        }
        try {
            return new Date(this.b.parse(i7Var.v()).getTime());
        } catch (ParseException e) {
            throw new z7(e);
        }
    }

    @Override // defpackage.b8
    /* renamed from: e */
    public synchronized void a(k7 k7Var, Date date) throws IOException {
        k7Var.j(date == null ? null : this.b.format((java.util.Date) date));
    }
}
