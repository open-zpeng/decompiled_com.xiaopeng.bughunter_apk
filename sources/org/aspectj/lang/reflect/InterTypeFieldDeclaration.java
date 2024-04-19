package org.aspectj.lang.reflect;

import java.lang.reflect.Type;
/* loaded from: classes.dex */
public interface InterTypeFieldDeclaration extends InterTypeDeclaration {
    Type getGenericType();

    String getName();

    AjType<?> getType();
}
