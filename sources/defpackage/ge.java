package defpackage;

import android.car.Car;
import android.content.Context;
import android.os.SystemProperties;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import java.util.HashSet;
import java.util.Set;
/* compiled from: CarApi.java */
/* renamed from: ge  reason: default package */
/* loaded from: classes.dex */
public final class ge {
    private static ie a;
    private static SparseArray<ne> b = new SparseArray<>();
    private static Set<ne> c = new HashSet();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CarApi.java */
    /* renamed from: ge$a */
    /* loaded from: classes.dex */
    public static class a implements me {
        a() {
        }

        @Override // defpackage.me
        public void a() {
        }

        @Override // defpackage.me
        public void b() {
            for (ne neVar : ge.c) {
                neVar.a();
            }
            ge.c.clear();
        }
    }

    private static void b(int i) {
        if (i != 100 && i != 101 && i != 102 && i != 103 && i != 104 && i != 105 && i != 106 && i != 107 && i != 108 && i != 109 && i != 110 && i != 111 && i != 112) {
            throw new IllegalArgumentException("Error Car API name!");
        }
    }

    private static void c(Context context) {
        Log.i("CarApi", "Bughunter execute connectCar()...");
        ie ieVar = new ie(context);
        a = ieVar;
        ieVar.h(new a());
        a.c();
    }

    private static synchronized ne d(int i) {
        ne neVar;
        synchronized (ge.class) {
            b(i);
            neVar = null;
            if (i == 103) {
                neVar = new qe();
            } else if (i == 108) {
                neVar = new re();
            }
        }
        return neVar;
    }

    public static Car e() {
        return (Car) a.d();
    }

    public static ne f(int i) {
        ne neVar = b.get(i);
        if (neVar == null) {
            neVar = d(i);
            if (a.e()) {
                neVar.a();
            } else {
                c.add(neVar);
            }
            b.put(i, neVar);
        }
        return neVar;
    }

    public static String g() {
        String str = SystemProperties.get("ro.xiaopeng.software", "");
        return !TextUtils.isEmpty(str) ? str.substring(9, 12) : str;
    }

    public static void h(Context context) {
        c(context);
    }
}
