package defpackage;

import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import defpackage.n3;
import defpackage.t2;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
/* compiled from: FontsContractCompat.java */
/* renamed from: m3  reason: default package */
/* loaded from: classes.dex */
public class m3 {
    static final v3<String, Typeface> a = new v3<>(16);
    private static final n3 b = new n3("fonts", 10, com.alibaba.sdk.android.man.crashreporter.a.a.a.b.a.r);
    static final Object c = new Object();
    static final c4<String, ArrayList<n3.d<g>>> d = new c4<>();
    private static final Comparator<byte[]> e = new d();

    /* compiled from: FontsContractCompat.java */
    /* renamed from: m3$a */
    /* loaded from: classes.dex */
    static class a implements Callable<g> {
        final /* synthetic */ Context b;
        final /* synthetic */ l3 c;
        final /* synthetic */ int d;
        final /* synthetic */ String e;

        a(Context context, l3 l3Var, int i, String str) {
            this.b = context;
            this.c = l3Var;
            this.d = i;
            this.e = str;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public g call() throws Exception {
            g f = m3.f(this.b, this.c, this.d);
            Typeface typeface = f.a;
            if (typeface != null) {
                m3.a.e(this.e, typeface);
            }
            return f;
        }
    }

    /* compiled from: FontsContractCompat.java */
    /* renamed from: m3$b */
    /* loaded from: classes.dex */
    static class b implements n3.d<g> {
        final /* synthetic */ t2.a a;
        final /* synthetic */ Handler b;

        b(t2.a aVar, Handler handler) {
            this.a = aVar;
            this.b = handler;
        }

        @Override // defpackage.n3.d
        /* renamed from: b */
        public void a(g gVar) {
            if (gVar == null) {
                this.a.a(1, this.b);
                return;
            }
            int i = gVar.b;
            if (i == 0) {
                this.a.b(gVar.a, this.b);
            } else {
                this.a.a(i, this.b);
            }
        }
    }

    /* compiled from: FontsContractCompat.java */
    /* renamed from: m3$c */
    /* loaded from: classes.dex */
    static class c implements n3.d<g> {
        final /* synthetic */ String a;

        c(String str) {
            this.a = str;
        }

        @Override // defpackage.n3.d
        /* renamed from: b */
        public void a(g gVar) {
            synchronized (m3.c) {
                c4<String, ArrayList<n3.d<g>>> c4Var = m3.d;
                ArrayList<n3.d<g>> arrayList = c4Var.get(this.a);
                if (arrayList == null) {
                    return;
                }
                c4Var.remove(this.a);
                for (int i = 0; i < arrayList.size(); i++) {
                    arrayList.get(i).a(gVar);
                }
            }
        }
    }

    /* compiled from: FontsContractCompat.java */
    /* renamed from: m3$d */
    /* loaded from: classes.dex */
    static class d implements Comparator<byte[]> {
        d() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(byte[] bArr, byte[] bArr2) {
            int i;
            int i2;
            if (bArr.length != bArr2.length) {
                i = bArr.length;
                i2 = bArr2.length;
            } else {
                for (int i3 = 0; i3 < bArr.length; i3++) {
                    if (bArr[i3] != bArr2[i3]) {
                        i = bArr[i3];
                        i2 = bArr2[i3];
                    }
                }
                return 0;
            }
            return i - i2;
        }
    }

    /* compiled from: FontsContractCompat.java */
    /* renamed from: m3$e */
    /* loaded from: classes.dex */
    public static class e {
        private final int a;
        private final f[] b;

        public e(int i, f[] fVarArr) {
            this.a = i;
            this.b = fVarArr;
        }

        public f[] a() {
            return this.b;
        }

        public int b() {
            return this.a;
        }
    }

    /* compiled from: FontsContractCompat.java */
    /* renamed from: m3$f */
    /* loaded from: classes.dex */
    public static class f {
        private final Uri a;
        private final int b;
        private final int c;
        private final boolean d;
        private final int e;

        public f(Uri uri, int i, int i2, boolean z, int i3) {
            this.a = (Uri) b4.b(uri);
            this.b = i;
            this.c = i2;
            this.d = z;
            this.e = i3;
        }

        public int a() {
            return this.e;
        }

        public int b() {
            return this.b;
        }

        public Uri c() {
            return this.a;
        }

        public int d() {
            return this.c;
        }

        public boolean e() {
            return this.d;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FontsContractCompat.java */
    /* renamed from: m3$g */
    /* loaded from: classes.dex */
    public static final class g {
        final Typeface a;
        final int b;

        g(Typeface typeface, int i) {
            this.a = typeface;
            this.b = i;
        }
    }

    private static List<byte[]> a(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature signature : signatureArr) {
            arrayList.add(signature.toByteArray());
        }
        return arrayList;
    }

    private static boolean b(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!Arrays.equals(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static e c(Context context, CancellationSignal cancellationSignal, l3 l3Var) throws PackageManager.NameNotFoundException {
        ProviderInfo h = h(context.getPackageManager(), l3Var, context.getResources());
        if (h == null) {
            return new e(1, null);
        }
        return new e(0, e(context, l3Var, h.authority, cancellationSignal));
    }

    private static List<List<byte[]>> d(l3 l3Var, Resources resources) {
        if (l3Var.a() != null) {
            return l3Var.a();
        }
        return q2.c(resources, l3Var.b());
    }

    static f[] e(Context context, l3 l3Var, String str, CancellationSignal cancellationSignal) {
        Uri withAppendedId;
        ArrayList arrayList = new ArrayList();
        Uri build = new Uri.Builder().scheme("content").authority(str).build();
        Uri build2 = new Uri.Builder().scheme("content").authority(str).appendPath("file").build();
        Cursor cursor = null;
        try {
            if (Build.VERSION.SDK_INT > 16) {
                cursor = context.getContentResolver().query(build, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{l3Var.f()}, null, cancellationSignal);
            } else {
                cursor = context.getContentResolver().query(build, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{l3Var.f()}, null);
            }
            if (cursor != null && cursor.getCount() > 0) {
                int columnIndex = cursor.getColumnIndex("result_code");
                ArrayList arrayList2 = new ArrayList();
                int columnIndex2 = cursor.getColumnIndex("_id");
                int columnIndex3 = cursor.getColumnIndex("file_id");
                int columnIndex4 = cursor.getColumnIndex("font_ttc_index");
                int columnIndex5 = cursor.getColumnIndex("font_weight");
                int columnIndex6 = cursor.getColumnIndex("font_italic");
                while (cursor.moveToNext()) {
                    int i = columnIndex != -1 ? cursor.getInt(columnIndex) : 0;
                    int i2 = columnIndex4 != -1 ? cursor.getInt(columnIndex4) : 0;
                    if (columnIndex3 == -1) {
                        withAppendedId = ContentUris.withAppendedId(build, cursor.getLong(columnIndex2));
                    } else {
                        withAppendedId = ContentUris.withAppendedId(build2, cursor.getLong(columnIndex3));
                    }
                    arrayList2.add(new f(withAppendedId, i2, columnIndex5 != -1 ? cursor.getInt(columnIndex5) : 400, columnIndex6 != -1 && cursor.getInt(columnIndex6) == 1, i));
                }
                arrayList = arrayList2;
            }
            return (f[]) arrayList.toArray(new f[0]);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    static g f(Context context, l3 l3Var, int i) {
        try {
            e c2 = c(context, null, l3Var);
            if (c2.b() == 0) {
                Typeface a2 = x2.a(context, null, c2.a(), i);
                return new g(a2, a2 != null ? 0 : -3);
            }
            return new g(null, c2.b() == 1 ? -2 : -3);
        } catch (PackageManager.NameNotFoundException unused) {
            return new g(null, -1);
        }
    }

    public static Typeface g(Context context, l3 l3Var, t2.a aVar, Handler handler, boolean z, int i, int i2) {
        String str = l3Var.c() + "-" + i2;
        Typeface d2 = a.d(str);
        if (d2 != null) {
            if (aVar != null) {
                aVar.d(d2);
            }
            return d2;
        } else if (z && i == -1) {
            g f2 = f(context, l3Var, i2);
            if (aVar != null) {
                int i3 = f2.b;
                if (i3 == 0) {
                    aVar.b(f2.a, handler);
                } else {
                    aVar.a(i3, handler);
                }
            }
            return f2.a;
        } else {
            a aVar2 = new a(context, l3Var, i2, str);
            if (z) {
                try {
                    return ((g) b.e(aVar2, i)).a;
                } catch (InterruptedException unused) {
                    return null;
                }
            }
            b bVar = aVar == null ? null : new b(aVar, handler);
            synchronized (c) {
                c4<String, ArrayList<n3.d<g>>> c4Var = d;
                if (c4Var.containsKey(str)) {
                    if (bVar != null) {
                        c4Var.get(str).add(bVar);
                    }
                    return null;
                }
                if (bVar != null) {
                    ArrayList<n3.d<g>> arrayList = new ArrayList<>();
                    arrayList.add(bVar);
                    c4Var.put(str, arrayList);
                }
                b.d(aVar2, new c(str));
                return null;
            }
        }
    }

    public static ProviderInfo h(PackageManager packageManager, l3 l3Var, Resources resources) throws PackageManager.NameNotFoundException {
        String d2 = l3Var.d();
        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(d2, 0);
        if (resolveContentProvider != null) {
            if (resolveContentProvider.packageName.equals(l3Var.e())) {
                List<byte[]> a2 = a(packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures);
                Collections.sort(a2, e);
                List<List<byte[]>> d3 = d(l3Var, resources);
                for (int i = 0; i < d3.size(); i++) {
                    ArrayList arrayList = new ArrayList(d3.get(i));
                    Collections.sort(arrayList, e);
                    if (b(a2, arrayList)) {
                        return resolveContentProvider;
                    }
                }
                return null;
            }
            throw new PackageManager.NameNotFoundException("Found content provider " + d2 + ", but package was not " + l3Var.e());
        }
        throw new PackageManager.NameNotFoundException("No package found for authority: " + d2);
    }

    public static Map<Uri, ByteBuffer> i(Context context, f[] fVarArr, CancellationSignal cancellationSignal) {
        HashMap hashMap = new HashMap();
        for (f fVar : fVarArr) {
            if (fVar.a() == 0) {
                Uri c2 = fVar.c();
                if (!hashMap.containsKey(c2)) {
                    hashMap.put(c2, d3.f(context, cancellationSignal, c2));
                }
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }
}
