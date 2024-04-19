package defpackage;

import java.math.BigInteger;
/* compiled from: JsonPrimitive.java */
/* renamed from: x7  reason: default package */
/* loaded from: classes.dex */
public final class x7 extends d8 {
    private static final Class<?>[] a = {Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class};
    private Object b;

    public x7(Boolean bool) {
        h(bool);
    }

    public x7(Number number) {
        h(number);
    }

    public x7(String str) {
        h(str);
    }

    private static boolean i(x7 x7Var) {
        Object obj = x7Var.b;
        if (obj instanceof Number) {
            Number number = (Number) obj;
            return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
        }
        return false;
    }

    private static boolean k(Object obj) {
        if (obj instanceof String) {
            return true;
        }
        Class<?> cls = obj.getClass();
        for (Class<?> cls2 : a) {
            if (cls2.isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || x7.class != obj.getClass()) {
            return false;
        }
        x7 x7Var = (x7) obj;
        if (this.b == null) {
            return x7Var.b == null;
        } else if (i(this) && i(x7Var)) {
            return m().longValue() == x7Var.m().longValue();
        } else {
            Object obj2 = this.b;
            if ((obj2 instanceof Number) && (x7Var.b instanceof Number)) {
                double doubleValue = m().doubleValue();
                double doubleValue2 = x7Var.m().doubleValue();
                if (doubleValue != doubleValue2) {
                    return Double.isNaN(doubleValue) && Double.isNaN(doubleValue2);
                }
                return true;
            }
            return obj2.equals(x7Var.b);
        }
    }

    void h(Object obj) {
        if (obj instanceof Character) {
            obj = String.valueOf(((Character) obj).charValue());
        } else {
            v6.b((obj instanceof Number) || k(obj));
        }
        this.b = obj;
    }

    public int hashCode() {
        long doubleToLongBits;
        if (this.b == null) {
            return 31;
        }
        if (i(this)) {
            doubleToLongBits = m().longValue();
        } else {
            Object obj = this.b;
            if (!(obj instanceof Number)) {
                return obj.hashCode();
            }
            doubleToLongBits = Double.doubleToLongBits(m().doubleValue());
        }
        return (int) ((doubleToLongBits >>> 32) ^ doubleToLongBits);
    }

    public boolean j() {
        return this.b instanceof Boolean;
    }

    public String l() {
        return s() ? m().toString() : j() ? r().toString() : (String) this.b;
    }

    public Number m() {
        Object obj = this.b;
        return obj instanceof String ? new a7((String) obj) : (Number) obj;
    }

    public double n() {
        return s() ? m().doubleValue() : Double.parseDouble(l());
    }

    public int o() {
        return s() ? m().intValue() : Integer.parseInt(l());
    }

    public long p() {
        return s() ? m().longValue() : Long.parseLong(l());
    }

    public boolean q() {
        return j() ? r().booleanValue() : Boolean.parseBoolean(l());
    }

    Boolean r() {
        return (Boolean) this.b;
    }

    public boolean s() {
        return this.b instanceof Number;
    }

    public boolean t() {
        return this.b instanceof String;
    }
}
