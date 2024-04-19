package defpackage;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.Comparator;
/* compiled from: KeyArraySorter.java */
/* renamed from: wa  reason: default package */
/* loaded from: classes.dex */
public class wa {
    private static wa a = new wa();
    private c b = new c();
    private b c = new b();

    /* compiled from: KeyArraySorter.java */
    /* renamed from: wa$b */
    /* loaded from: classes.dex */
    private class b implements Comparator<String> {
        private b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(String str, String str2) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return 0;
            }
            return str.compareTo(str2);
        }
    }

    /* compiled from: KeyArraySorter.java */
    /* renamed from: wa$c */
    /* loaded from: classes.dex */
    private class c implements Comparator<String> {
        private c() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(String str, String str2) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return 0;
            }
            return str.compareTo(str2) * (-1);
        }
    }

    private wa() {
    }

    public static wa a() {
        return a;
    }

    public String[] b(String[] strArr, boolean z) {
        Comparator comparator;
        if (z) {
            comparator = this.c;
        } else {
            comparator = this.b;
        }
        if (comparator == null || strArr == null || strArr.length <= 0) {
            return null;
        }
        Arrays.sort(strArr, comparator);
        return strArr;
    }
}
