package org.aspectj.lang.reflect;

import org.aspectj.lang.Signature;
/* loaded from: classes.dex */
public interface CatchClauseSignature extends Signature {
    String getParameterName();

    Class getParameterType();
}
