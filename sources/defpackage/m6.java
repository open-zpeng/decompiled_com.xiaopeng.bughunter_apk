package defpackage;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
/* compiled from: DateTypeAdapter.java */
/* renamed from: m6  reason: default package */
/* loaded from: classes.dex */
public final class m6 extends b8<Date> {
    public static final c8 a = new a();
    private final DateFormat b = DateFormat.getDateTimeInstance(2, 2, Locale.US);
    private final DateFormat c = DateFormat.getDateTimeInstance(2, 2);
    private final DateFormat d = f();

    /* compiled from: DateTypeAdapter.java */
    /* renamed from: m6$a */
    /* loaded from: classes.dex */
    static class a implements c8 {
        a() {
        }

        @Override // defpackage.c8
        public <T> b8<T> a(p7 p7Var, m7<T> m7Var) {
            if (m7Var.a() == Date.class) {
                return new m6();
            }
            return null;
        }
    }

    private static DateFormat f() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat;
    }

    private synchronized Date g(String str) {
        try {
            try {
                try {
                } catch (ParseException unused) {
                    return this.d.parse(str);
                }
            } catch (ParseException e) {
                throw new z7(str, e);
            }
        } catch (ParseException unused2) {
            return this.b.parse(str);
        }
        return this.c.parse(str);
    }

    @Override // defpackage.b8
    /* renamed from: d */
    public Date c(i7 i7Var) throws IOException {
        if (i7Var.t() == j7.NULL) {
            i7Var.w();
            return null;
        }
        return g(i7Var.v());
    }

    @Override // defpackage.b8
    /* renamed from: e */
    public synchronized void a(k7 k7Var, Date date) throws IOException {
        if (date == null) {
            k7Var.u();
        } else {
            k7Var.j(this.b.format(date));
        }
    }
}
