package org.aspectj.lang.reflect;
/* loaded from: classes.dex */
public interface DeclareSoft {
    AjType getDeclaringType();

    PointcutExpression getPointcutExpression();

    AjType getSoftenedExceptionType() throws ClassNotFoundException;
}
