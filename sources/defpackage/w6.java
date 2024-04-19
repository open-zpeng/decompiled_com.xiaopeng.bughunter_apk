package defpackage;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;
/* compiled from: $Gson$Types.java */
/* renamed from: w6  reason: default package */
/* loaded from: classes.dex */
public final class w6 {
    static final Type[] a = new Type[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: $Gson$Types.java */
    /* renamed from: w6$a */
    /* loaded from: classes.dex */
    public static final class a implements Serializable, GenericArrayType {
        private final Type b;

        public a(Type type) {
            this.b = w6.p(type);
        }

        public boolean equals(Object obj) {
            return (obj instanceof GenericArrayType) && w6.k(this, (GenericArrayType) obj);
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.b;
        }

        public int hashCode() {
            return this.b.hashCode();
        }

        public String toString() {
            return w6.s(this.b) + "[]";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: $Gson$Types.java */
    /* renamed from: w6$b */
    /* loaded from: classes.dex */
    public static final class b implements Serializable, ParameterizedType {
        private final Type b;
        private final Type c;
        private final Type[] d;

        public b(Type type, Type type2, Type... typeArr) {
            int i = 0;
            if (type2 instanceof Class) {
                Class cls = (Class) type2;
                boolean z = true;
                v6.b(type != null || cls.getEnclosingClass() == null);
                if (type != null && cls.getEnclosingClass() == null) {
                    z = false;
                }
                v6.b(z);
            }
            this.b = type == null ? null : w6.p(type);
            this.c = w6.p(type2);
            this.d = (Type[]) typeArr.clone();
            while (true) {
                Type[] typeArr2 = this.d;
                if (i >= typeArr2.length) {
                    return;
                }
                v6.a(typeArr2[i]);
                w6.v(this.d[i]);
                Type[] typeArr3 = this.d;
                typeArr3[i] = w6.p(typeArr3[i]);
                i++;
            }
        }

        public boolean equals(Object obj) {
            return (obj instanceof ParameterizedType) && w6.k(this, (ParameterizedType) obj);
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return (Type[]) this.d.clone();
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return this.b;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.c;
        }

        public int hashCode() {
            return (Arrays.hashCode(this.d) ^ this.c.hashCode()) ^ w6.l(this.b);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder((this.d.length + 1) * 30);
            sb.append(w6.s(this.c));
            if (this.d.length == 0) {
                return sb.toString();
            }
            sb.append("<");
            sb.append(w6.s(this.d[0]));
            for (int i = 1; i < this.d.length; i++) {
                sb.append(", ");
                sb.append(w6.s(this.d[i]));
            }
            sb.append(">");
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: $Gson$Types.java */
    /* renamed from: w6$c */
    /* loaded from: classes.dex */
    public static final class c implements Serializable, WildcardType {
        private final Type b;
        private final Type c;

        public c(Type[] typeArr, Type[] typeArr2) {
            v6.b(typeArr2.length <= 1);
            v6.b(typeArr.length == 1);
            if (typeArr2.length != 1) {
                v6.a(typeArr[0]);
                w6.v(typeArr[0]);
                this.c = null;
                this.b = w6.p(typeArr[0]);
                return;
            }
            v6.a(typeArr2[0]);
            w6.v(typeArr2[0]);
            v6.b(typeArr[0] == Object.class);
            this.c = w6.p(typeArr2[0]);
            this.b = Object.class;
        }

        public boolean equals(Object obj) {
            return (obj instanceof WildcardType) && w6.k(this, (WildcardType) obj);
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            Type type = this.c;
            return type != null ? new Type[]{type} : w6.a;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return new Type[]{this.b};
        }

        public int hashCode() {
            Type type = this.c;
            return (type != null ? type.hashCode() + 31 : 1) ^ (this.b.hashCode() + 31);
        }

        public String toString() {
            StringBuilder sb;
            Type type;
            if (this.c != null) {
                sb = new StringBuilder();
                sb.append("? super ");
                type = this.c;
            } else if (this.b == Object.class) {
                return "?";
            } else {
                sb = new StringBuilder();
                sb.append("? extends ");
                type = this.b;
            }
            sb.append(w6.s(type));
            return sb.toString();
        }
    }

    private static int b(Object[] objArr, Object obj) {
        for (int i = 0; i < objArr.length; i++) {
            if (obj.equals(objArr[i])) {
                return i;
            }
        }
        throw new NoSuchElementException();
    }

    private static Class<?> c(TypeVariable<?> typeVariable) {
        Object genericDeclaration = typeVariable.getGenericDeclaration();
        if (genericDeclaration instanceof Class) {
            return (Class) genericDeclaration;
        }
        return null;
    }

    public static GenericArrayType d(Type type) {
        return new a(type);
    }

    public static ParameterizedType e(Type type, Type type2, Type... typeArr) {
        return new b(type, type2, typeArr);
    }

    public static Type f(Type type, Class<?> cls) {
        Type m = m(type, cls, Collection.class);
        if (m instanceof WildcardType) {
            m = ((WildcardType) m).getUpperBounds()[0];
        }
        return m instanceof ParameterizedType ? ((ParameterizedType) m).getActualTypeArguments()[0] : Object.class;
    }

    static Type g(Type type, Class<?> cls, Class<?> cls2) {
        if (cls2 == cls) {
            return type;
        }
        if (cls2.isInterface()) {
            Class<?>[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            for (int i = 0; i < length; i++) {
                if (interfaces[i] == cls2) {
                    return cls.getGenericInterfaces()[i];
                }
                if (cls2.isAssignableFrom(interfaces[i])) {
                    return g(cls.getGenericInterfaces()[i], interfaces[i], cls2);
                }
            }
        }
        if (!cls.isInterface()) {
            while (cls != Object.class) {
                Class<? super Object> superclass = cls.getSuperclass();
                if (superclass == cls2) {
                    return cls.getGenericSuperclass();
                }
                if (cls2.isAssignableFrom(superclass)) {
                    return g(cls.getGenericSuperclass(), superclass, cls2);
                }
                cls = superclass;
            }
        }
        return cls2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
        r10 = r10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.reflect.Type h(java.lang.reflect.Type r8, java.lang.Class<?> r9, java.lang.reflect.Type r10) {
        /*
        L0:
            boolean r0 = r10 instanceof java.lang.reflect.TypeVariable
            if (r0 == 0) goto Lf
            java.lang.reflect.TypeVariable r10 = (java.lang.reflect.TypeVariable) r10
            java.lang.reflect.Type r0 = i(r8, r9, r10)
            if (r0 != r10) goto Ld
            return r0
        Ld:
            r10 = r0
            goto L0
        Lf:
            boolean r0 = r10 instanceof java.lang.Class
            if (r0 == 0) goto L2c
            r0 = r10
            java.lang.Class r0 = (java.lang.Class) r0
            boolean r1 = r0.isArray()
            if (r1 == 0) goto L2c
            java.lang.Class r10 = r0.getComponentType()
            java.lang.reflect.Type r8 = h(r8, r9, r10)
            if (r10 != r8) goto L27
            goto L2b
        L27:
            java.lang.reflect.GenericArrayType r0 = d(r8)
        L2b:
            return r0
        L2c:
            boolean r0 = r10 instanceof java.lang.reflect.GenericArrayType
            if (r0 == 0) goto L42
            java.lang.reflect.GenericArrayType r10 = (java.lang.reflect.GenericArrayType) r10
            java.lang.reflect.Type r0 = r10.getGenericComponentType()
            java.lang.reflect.Type r8 = h(r8, r9, r0)
            if (r0 != r8) goto L3d
            goto L41
        L3d:
            java.lang.reflect.GenericArrayType r10 = d(r8)
        L41:
            return r10
        L42:
            boolean r0 = r10 instanceof java.lang.reflect.ParameterizedType
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L82
            java.lang.reflect.ParameterizedType r10 = (java.lang.reflect.ParameterizedType) r10
            java.lang.reflect.Type r0 = r10.getOwnerType()
            java.lang.reflect.Type r3 = h(r8, r9, r0)
            if (r3 == r0) goto L56
            r0 = r1
            goto L57
        L56:
            r0 = r2
        L57:
            java.lang.reflect.Type[] r4 = r10.getActualTypeArguments()
            int r5 = r4.length
        L5c:
            if (r2 >= r5) goto L77
            r6 = r4[r2]
            java.lang.reflect.Type r6 = h(r8, r9, r6)
            r7 = r4[r2]
            if (r6 == r7) goto L74
            if (r0 != 0) goto L72
            java.lang.Object r0 = r4.clone()
            r4 = r0
            java.lang.reflect.Type[] r4 = (java.lang.reflect.Type[]) r4
            r0 = r1
        L72:
            r4[r2] = r6
        L74:
            int r2 = r2 + 1
            goto L5c
        L77:
            if (r0 == 0) goto L81
            java.lang.reflect.Type r8 = r10.getRawType()
            java.lang.reflect.ParameterizedType r10 = e(r3, r8, r4)
        L81:
            return r10
        L82:
            boolean r0 = r10 instanceof java.lang.reflect.WildcardType
            if (r0 == 0) goto Lb4
            java.lang.reflect.WildcardType r10 = (java.lang.reflect.WildcardType) r10
            java.lang.reflect.Type[] r0 = r10.getLowerBounds()
            java.lang.reflect.Type[] r3 = r10.getUpperBounds()
            int r4 = r0.length
            if (r4 != r1) goto La2
            r1 = r0[r2]
            java.lang.reflect.Type r8 = h(r8, r9, r1)
            r9 = r0[r2]
            if (r8 == r9) goto Lb4
            java.lang.reflect.WildcardType r8 = q(r8)
            return r8
        La2:
            int r0 = r3.length
            if (r0 != r1) goto Lb4
            r0 = r3[r2]
            java.lang.reflect.Type r8 = h(r8, r9, r0)
            r9 = r3[r2]
            if (r8 == r9) goto Lb4
            java.lang.reflect.WildcardType r8 = n(r8)
            return r8
        Lb4:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.w6.h(java.lang.reflect.Type, java.lang.Class, java.lang.reflect.Type):java.lang.reflect.Type");
    }

    static Type i(Type type, Class<?> cls, TypeVariable<?> typeVariable) {
        Class<?> c2 = c(typeVariable);
        if (c2 == null) {
            return typeVariable;
        }
        Type g = g(type, cls, c2);
        if (g instanceof ParameterizedType) {
            return ((ParameterizedType) g).getActualTypeArguments()[b(c2.getTypeParameters(), typeVariable)];
        }
        return typeVariable;
    }

    static boolean j(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static boolean k(Type type, Type type2) {
        if (type == type2) {
            return true;
        }
        if (type instanceof Class) {
            return type.equals(type2);
        }
        if (type instanceof ParameterizedType) {
            if (type2 instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                ParameterizedType parameterizedType2 = (ParameterizedType) type2;
                return j(parameterizedType.getOwnerType(), parameterizedType2.getOwnerType()) && parameterizedType.getRawType().equals(parameterizedType2.getRawType()) && Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments());
            }
            return false;
        } else if (type instanceof GenericArrayType) {
            if (type2 instanceof GenericArrayType) {
                return k(((GenericArrayType) type).getGenericComponentType(), ((GenericArrayType) type2).getGenericComponentType());
            }
            return false;
        } else if (type instanceof WildcardType) {
            if (type2 instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) type;
                WildcardType wildcardType2 = (WildcardType) type2;
                return Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) && Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds());
            }
            return false;
        } else if ((type instanceof TypeVariable) && (type2 instanceof TypeVariable)) {
            TypeVariable typeVariable = (TypeVariable) type;
            TypeVariable typeVariable2 = (TypeVariable) type2;
            return typeVariable.getGenericDeclaration() == typeVariable2.getGenericDeclaration() && typeVariable.getName().equals(typeVariable2.getName());
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int l(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    static Type m(Type type, Class<?> cls, Class<?> cls2) {
        v6.b(cls2.isAssignableFrom(cls));
        return h(type, cls, g(type, cls, cls2));
    }

    public static WildcardType n(Type type) {
        return new c(new Type[]{type}, a);
    }

    public static Type[] o(Type type, Class<?> cls) {
        if (type == Properties.class) {
            return new Type[]{String.class, String.class};
        }
        Type m = m(type, cls, Map.class);
        return m instanceof ParameterizedType ? ((ParameterizedType) m).getActualTypeArguments() : new Type[]{Object.class, Object.class};
    }

    public static Type p(Type type) {
        if (type instanceof Class) {
            Class cls = (Class) type;
            return cls.isArray() ? new a(p(cls.getComponentType())) : cls;
        } else if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            return new b(parameterizedType.getOwnerType(), parameterizedType.getRawType(), parameterizedType.getActualTypeArguments());
        } else if (type instanceof GenericArrayType) {
            return new a(((GenericArrayType) type).getGenericComponentType());
        } else {
            if (type instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) type;
                return new c(wildcardType.getUpperBounds(), wildcardType.getLowerBounds());
            }
            return type;
        }
    }

    public static WildcardType q(Type type) {
        return new c(new Type[]{Object.class}, new Type[]{type});
    }

    public static Class<?> r(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            v6.b(rawType instanceof Class);
            return (Class) rawType;
        } else if (type instanceof GenericArrayType) {
            return Array.newInstance(r(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
        } else {
            if (type instanceof TypeVariable) {
                return Object.class;
            }
            if (type instanceof WildcardType) {
                return r(((WildcardType) type).getUpperBounds()[0]);
            }
            String name = type == null ? "null" : type.getClass().getName();
            throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + name);
        }
    }

    public static String s(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    public static Type t(Type type) {
        return type instanceof GenericArrayType ? ((GenericArrayType) type).getGenericComponentType() : ((Class) type).getComponentType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void v(Type type) {
        v6.b(((type instanceof Class) && ((Class) type).isPrimitive()) ? false : true);
    }
}
