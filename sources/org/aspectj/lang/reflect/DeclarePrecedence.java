package org.aspectj.lang.reflect;
/* loaded from: classes.dex */
public interface DeclarePrecedence {
    AjType getDeclaringType();

    TypePattern[] getPrecedenceOrder();
}
