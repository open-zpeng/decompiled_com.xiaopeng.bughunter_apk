package defpackage;

import java.lang.reflect.Field;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: FieldNamingPolicy.java */
/* renamed from: h7  reason: default package */
/* loaded from: classes.dex */
public abstract class h7 implements o7 {
    public static final h7 O000000o;
    public static final h7 O00000Oo;
    public static final h7 O00000o;
    public static final h7 O00000o0;
    public static final h7 O00000oO;
    private static final /* synthetic */ h7[] b;

    /* compiled from: FieldNamingPolicy.java */
    /* renamed from: h7$a */
    /* loaded from: classes.dex */
    enum a extends h7 {
        a(String str, int i) {
            super(str, i, null);
        }

        @Override // defpackage.h7, defpackage.o7
        public String O000000o(Field field) {
            return field.getName();
        }
    }

    static {
        a aVar = new a("IDENTITY", 0);
        O000000o = aVar;
        h7 h7Var = new h7("UPPER_CAMEL_CASE", 1) { // from class: h7.b
            @Override // defpackage.h7, defpackage.o7
            public String O000000o(Field field) {
                return h7.d(field.getName());
            }
        };
        O00000Oo = h7Var;
        h7 h7Var2 = new h7("UPPER_CAMEL_CASE_WITH_SPACES", 2) { // from class: h7.c
            @Override // defpackage.h7, defpackage.o7
            public String O000000o(Field field) {
                return h7.d(h7.e(field.getName(), " "));
            }
        };
        O00000o0 = h7Var2;
        h7 h7Var3 = new h7("LOWER_CASE_WITH_UNDERSCORES", 3) { // from class: h7.d
            @Override // defpackage.h7, defpackage.o7
            public String O000000o(Field field) {
                return h7.e(field.getName(), "_").toLowerCase();
            }
        };
        O00000o = h7Var3;
        h7 h7Var4 = new h7("LOWER_CASE_WITH_DASHES", 4) { // from class: h7.e
            @Override // defpackage.h7, defpackage.o7
            public String O000000o(Field field) {
                return h7.e(field.getName(), "-").toLowerCase();
            }
        };
        O00000oO = h7Var4;
        b = new h7[]{aVar, h7Var, h7Var2, h7Var3, h7Var4};
    }

    private h7(String str, int i) {
    }

    /* synthetic */ h7(String str, int i, a aVar) {
        this(str, i);
    }

    private static String a(char c2, String str, int i) {
        if (i < str.length()) {
            return c2 + str.substring(i);
        }
        return String.valueOf(c2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String d(String str) {
        char charAt;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            charAt = str.charAt(i);
            if (i >= str.length() - 1 || Character.isLetter(charAt)) {
                break;
            }
            sb.append(charAt);
            i++;
        }
        if (i == str.length()) {
            return sb.toString();
        }
        if (Character.isUpperCase(charAt)) {
            return str;
        }
        sb.append(a(Character.toUpperCase(charAt), str, i + 1));
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String e(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt) && sb.length() != 0) {
                sb.append(str2);
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    public static h7 valueOf(String str) {
        return (h7) Enum.valueOf(h7.class, str);
    }

    public static h7[] values() {
        return (h7[]) b.clone();
    }

    @Override // defpackage.o7
    public abstract /* synthetic */ String O000000o(Field field);
}
