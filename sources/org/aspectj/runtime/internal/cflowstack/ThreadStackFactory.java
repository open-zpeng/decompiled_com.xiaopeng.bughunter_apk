package org.aspectj.runtime.internal.cflowstack;
/* loaded from: classes.dex */
public interface ThreadStackFactory {
    ThreadCounter getNewThreadCounter();

    ThreadStack getNewThreadStack();
}
