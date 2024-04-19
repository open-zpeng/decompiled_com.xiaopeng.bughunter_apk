package defpackage;

import android.content.Context;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import defpackage.m3;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
/* compiled from: TypefaceCompatApi21Impl.java */
/* renamed from: y2  reason: default package */
/* loaded from: classes.dex */
class y2 extends c3 {
    private File h(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            String readlink = Os.readlink("/proc/self/fd/" + parcelFileDescriptor.getFd());
            if (OsConstants.S_ISREG(Os.stat(readlink).st_mode)) {
                return new File(readlink);
            }
        } catch (ErrnoException unused) {
        }
        return null;
    }

    @Override // defpackage.c3
    public Typeface b(Context context, CancellationSignal cancellationSignal, m3.f[] fVarArr, int i) {
        if (fVarArr.length < 1) {
            return null;
        }
        m3.f g = g(fVarArr, i);
        try {
            ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(g.c(), "r", cancellationSignal);
            File h = h(openFileDescriptor);
            if (h != null && h.canRead()) {
                Typeface createFromFile = Typeface.createFromFile(h);
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return createFromFile;
            }
            FileInputStream fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
            try {
                Typeface c = super.c(context, fileInputStream);
                fileInputStream.close();
                openFileDescriptor.close();
                return c;
            } finally {
            }
        } catch (IOException unused) {
            return null;
        }
    }
}
