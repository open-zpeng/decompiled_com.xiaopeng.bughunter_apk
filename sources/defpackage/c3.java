package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import defpackage.m3;
import defpackage.q2;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TypefaceCompatBaseImpl.java */
/* renamed from: c3  reason: default package */
/* loaded from: classes.dex */
public class c3 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypefaceCompatBaseImpl.java */
    /* renamed from: c3$a */
    /* loaded from: classes.dex */
    public class a implements c<m3.f> {
        a() {
        }

        @Override // defpackage.c3.c
        /* renamed from: c */
        public int a(m3.f fVar) {
            return fVar.d();
        }

        @Override // defpackage.c3.c
        /* renamed from: d */
        public boolean b(m3.f fVar) {
            return fVar.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypefaceCompatBaseImpl.java */
    /* renamed from: c3$b */
    /* loaded from: classes.dex */
    public class b implements c<q2.c> {
        b() {
        }

        @Override // defpackage.c3.c
        /* renamed from: c */
        public int a(q2.c cVar) {
            return cVar.e();
        }

        @Override // defpackage.c3.c
        /* renamed from: d */
        public boolean b(q2.c cVar) {
            return cVar.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TypefaceCompatBaseImpl.java */
    /* renamed from: c3$c */
    /* loaded from: classes.dex */
    public interface c<T> {
        int a(T t);

        boolean b(T t);
    }

    private q2.c e(q2.b bVar, int i) {
        return (q2.c) f(bVar.a(), i, new b());
    }

    private static <T> T f(T[] tArr, int i, c<T> cVar) {
        int i2 = (i & 1) == 0 ? 400 : 700;
        boolean z = (i & 2) != 0;
        T t = null;
        int i3 = Integer.MAX_VALUE;
        for (T t2 : tArr) {
            int abs = (Math.abs(cVar.a(t2) - i2) * 2) + (cVar.b(t2) == z ? 0 : 1);
            if (t == null || i3 > abs) {
                t = t2;
                i3 = abs;
            }
        }
        return t;
    }

    public Typeface a(Context context, q2.b bVar, Resources resources, int i) {
        q2.c e = e(bVar, i);
        if (e == null) {
            return null;
        }
        return x2.c(context, resources, e.b(), e.a(), i);
    }

    public Typeface b(Context context, CancellationSignal cancellationSignal, m3.f[] fVarArr, int i) {
        InputStream inputStream;
        InputStream inputStream2 = null;
        if (fVarArr.length < 1) {
            return null;
        }
        try {
            inputStream = context.getContentResolver().openInputStream(g(fVarArr, i).c());
        } catch (IOException unused) {
            inputStream = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            Typeface c2 = c(context, inputStream);
            d3.a(inputStream);
            return c2;
        } catch (IOException unused2) {
            d3.a(inputStream);
            return null;
        } catch (Throwable th2) {
            th = th2;
            inputStream2 = inputStream;
            d3.a(inputStream2);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Typeface c(Context context, InputStream inputStream) {
        File e = d3.e(context);
        if (e == null) {
            return null;
        }
        try {
            if (d3.d(e, inputStream)) {
                return Typeface.createFromFile(e.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            e.delete();
        }
    }

    public Typeface d(Context context, Resources resources, int i, String str, int i2) {
        File e = d3.e(context);
        if (e == null) {
            return null;
        }
        try {
            if (d3.c(e, resources, i)) {
                return Typeface.createFromFile(e.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            e.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public m3.f g(m3.f[] fVarArr, int i) {
        return (m3.f) f(fVarArr, i, new a());
    }
}
