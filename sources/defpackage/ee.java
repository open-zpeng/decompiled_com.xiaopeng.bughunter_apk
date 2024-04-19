package defpackage;

import java.io.IOException;
/* compiled from: ProcessUtil.java */
/* renamed from: ee  reason: default package */
/* loaded from: classes.dex */
public class ee {
    /* JADX WARN: Code restructure failed: missing block: B:34:0x007b, code lost:
        if (r7 == null) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean a(java.lang.String r7, java.lang.String r8) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "execCommand: "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "ProcessUtil"
            defpackage.tf.a(r1, r0)
            r0 = 0
            r2 = 0
            java.lang.Process r7 = b(r7)     // Catch: java.lang.Throwable -> L6b java.lang.Exception -> L6f
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L65 java.lang.Exception -> L68
            java.io.InputStream r4 = r7.getInputStream()     // Catch: java.lang.Throwable -> L65 java.lang.Exception -> L68
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L65 java.lang.Exception -> L68
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L61
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L61
        L2a:
            java.lang.String r0 = r4.readLine()     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
            if (r0 == 0) goto L4c
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
            r5.<init>()     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
            java.lang.String r6 = "readLine(): "
            r5.append(r6)     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
            r5.append(r0)     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
            defpackage.tf.a(r1, r5)     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
            boolean r0 = r0.contains(r8)     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
            if (r0 == 0) goto L2a
            r2 = 1
            goto L2a
        L4c:
            r7.waitFor()     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
            defpackage.ce.a(r3)
            defpackage.ce.a(r4)
        L55:
            r7.destroy()
            goto L7e
        L59:
            r8 = move-exception
            goto L5f
        L5b:
            r8 = move-exception
            goto L63
        L5d:
            r8 = move-exception
            r4 = r0
        L5f:
            r0 = r3
            goto L80
        L61:
            r8 = move-exception
            r4 = r0
        L63:
            r0 = r3
            goto L72
        L65:
            r8 = move-exception
            r4 = r0
            goto L80
        L68:
            r8 = move-exception
            r4 = r0
            goto L72
        L6b:
            r8 = move-exception
            r7 = r0
            r4 = r7
            goto L80
        L6f:
            r8 = move-exception
            r7 = r0
            r4 = r7
        L72:
            r8.printStackTrace()     // Catch: java.lang.Throwable -> L7f
            defpackage.ce.a(r0)
            defpackage.ce.a(r4)
            if (r7 == 0) goto L7e
            goto L55
        L7e:
            return r2
        L7f:
            r8 = move-exception
        L80:
            defpackage.ce.a(r0)
            defpackage.ce.a(r4)
            if (r7 == 0) goto L8b
            r7.destroy()
        L8b:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ee.a(java.lang.String, java.lang.String):boolean");
    }

    public static Process b(String str) {
        Process process = null;
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("/bin/sh", "-c", str);
            processBuilder.redirectErrorStream(true);
            process = processBuilder.start();
            tf.a("ProcessUtil", "execProcess:" + str);
            return process;
        } catch (IOException e) {
            e.printStackTrace();
            return process;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x005e, code lost:
        if (r5 == null) goto L17;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String c(java.lang.String r5) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
            java.lang.Runtime r2 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L50
            java.lang.Process r5 = r2.exec(r5)     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L50
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L47
            java.io.InputStream r3 = r5.getInputStream()     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L47
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L47
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3f
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3f
        L1c:
            java.lang.String r1 = r3.readLine()     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L68
            if (r1 == 0) goto L2d
            r0.append(r1)     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L68
            java.lang.String r1 = java.lang.System.lineSeparator()     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L68
            r0.append(r1)     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L68
            goto L1c
        L2d:
            r3.close()     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L68
            r5.waitFor()     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L68
            defpackage.ce.a(r2)
            defpackage.ce.a(r3)
            goto L60
        L3a:
            r1 = move-exception
            goto L55
        L3c:
            r0 = move-exception
            r3 = r1
            goto L69
        L3f:
            r3 = move-exception
            r4 = r3
            r3 = r1
            r1 = r4
            goto L55
        L44:
            r0 = move-exception
            r3 = r1
            goto L6a
        L47:
            r2 = move-exception
            r3 = r1
            r1 = r2
            r2 = r3
            goto L55
        L4c:
            r0 = move-exception
            r5 = r1
            r3 = r5
            goto L6a
        L50:
            r5 = move-exception
            r2 = r1
            r3 = r2
            r1 = r5
            r5 = r3
        L55:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L68
            defpackage.ce.a(r2)
            defpackage.ce.a(r3)
            if (r5 == 0) goto L63
        L60:
            r5.destroy()
        L63:
            java.lang.String r5 = r0.toString()
            return r5
        L68:
            r0 = move-exception
        L69:
            r1 = r2
        L6a:
            defpackage.ce.a(r1)
            defpackage.ce.a(r3)
            if (r5 == 0) goto L75
            r5.destroy()
        L75:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ee.c(java.lang.String):java.lang.String");
    }
}
