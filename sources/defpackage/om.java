package defpackage;

import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IRadioController;
import java.io.IOException;
import java.io.InputStream;
/* compiled from: MultiByteArrayInputStream.java */
/* renamed from: om  reason: default package */
/* loaded from: classes.dex */
public class om extends InputStream {
    private byte[] b;
    private int c;
    private int d;
    private byte[] e;
    private int f;
    private int g;
    private int h = 0;

    public om(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        this.b = bArr;
        this.e = bArr2;
        this.c = i;
        this.f = i3;
        this.d = i2;
        this.g = i4;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int i;
        int i2 = this.h;
        int i3 = this.d;
        if (i2 < i3) {
            i = this.b[this.c + i2];
        } else if (i2 >= this.g + i3) {
            return -1;
        } else {
            i = this.e[(this.f + i2) - i3];
        }
        if (i < 0) {
            i += IRadioController.TEF663x_PCHANNEL;
        }
        this.h = i2 + 1;
        return i;
    }
}
