package defpackage;

import java.math.BigDecimal;
/* compiled from: LazilyParsedNumber.java */
/* renamed from: a7  reason: default package */
/* loaded from: classes.dex */
public final class a7 extends Number {
    private final String b;

    public a7(String str) {
        this.b = str;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return Double.parseDouble(this.b);
    }

    @Override // java.lang.Number
    public float floatValue() {
        return Float.parseFloat(this.b);
    }

    @Override // java.lang.Number
    public int intValue() {
        try {
            try {
                return Integer.parseInt(this.b);
            } catch (NumberFormatException unused) {
                return (int) Long.parseLong(this.b);
            }
        } catch (NumberFormatException unused2) {
            return new BigDecimal(this.b).intValue();
        }
    }

    @Override // java.lang.Number
    public long longValue() {
        try {
            return Long.parseLong(this.b);
        } catch (NumberFormatException unused) {
            return new BigDecimal(this.b).longValue();
        }
    }

    public String toString() {
        return this.b;
    }
}
