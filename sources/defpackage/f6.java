package defpackage;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/* compiled from: Expose.java */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: f6  reason: default package */
/* loaded from: classes.dex */
public @interface f6 {
    boolean O000000o() default true;

    boolean O00000Oo() default true;
}
