package defpackage;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/* compiled from: Subscribe.java */
@Target({ElementType.METHOD})
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: ln  reason: default package */
/* loaded from: classes.dex */
public @interface ln {
    int priority() default 0;

    boolean sticky() default false;

    qn threadMode() default qn.POSTING;
}
