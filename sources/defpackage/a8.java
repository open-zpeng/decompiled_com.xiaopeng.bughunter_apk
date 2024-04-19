package defpackage;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: LongSerializationPolicy.java */
/* renamed from: a8  reason: default package */
/* loaded from: classes.dex */
public abstract class a8 {
    public static final a8 O000000o;
    public static final a8 O00000Oo;
    private static final /* synthetic */ a8[] b;

    /* compiled from: LongSerializationPolicy.java */
    /* renamed from: a8$a */
    /* loaded from: classes.dex */
    enum a extends a8 {
        a(String str, int i) {
            super(str, i, null);
        }

        @Override // defpackage.a8
        public d8 O000000o(Long l) {
            return new x7(l);
        }
    }

    static {
        a aVar = new a("DEFAULT", 0);
        O000000o = aVar;
        a8 a8Var = new a8("STRING", 1) { // from class: a8.b
            @Override // defpackage.a8
            public d8 O000000o(Long l) {
                return new x7(String.valueOf(l));
            }
        };
        O00000Oo = a8Var;
        b = new a8[]{aVar, a8Var};
    }

    private a8(String str, int i) {
    }

    /* synthetic */ a8(String str, int i, a aVar) {
        this(str, i);
    }

    public static a8 valueOf(String str) {
        return (a8) Enum.valueOf(a8.class, str);
    }

    public static a8[] values() {
        return (a8[]) b.clone();
    }

    public abstract d8 O000000o(Long l);
}
