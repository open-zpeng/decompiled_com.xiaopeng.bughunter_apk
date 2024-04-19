package defpackage;
/* compiled from: SimpleBase64Encoder.java */
/* renamed from: kl  reason: default package */
/* loaded from: classes.dex */
public class kl {
    private static final char[] a = "./0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();

    public static byte[] a(String str) {
        byte[] bytes = str.getBytes();
        int length = bytes.length;
        byte[] bArr = new byte[(length * 3) / 4];
        int i = 0;
        int i2 = 0;
        while (true) {
            if (length < 4) {
                break;
            }
            long c = c(bytes, i, 4);
            length -= 4;
            i += 4;
            for (int i3 = 2; i3 >= 0; i3--) {
                bArr[i2 + i3] = (byte) (c & 255);
                c >>= 8;
            }
            i2 += 3;
        }
        if (length == 3) {
            long c2 = c(bytes, i, 3);
            for (int i4 = 1; i4 >= 0; i4--) {
                bArr[i2 + i4] = (byte) (c2 & 255);
                c2 >>= 8;
            }
        }
        if (length == 2) {
            bArr[i2] = (byte) (c(bytes, i, 2) & 255);
        }
        return bArr;
    }

    public static String b(byte[] bArr) {
        int length = bArr.length;
        StringBuffer stringBuffer = new StringBuffer(((length + 2) / 3) * 4);
        int i = 0;
        while (length >= 3) {
            stringBuffer.append(d(((bArr[i] & 255) << 16) | ((bArr[i + 1] & 255) << 8) | (bArr[i + 2] & 255), 4));
            i += 3;
            length -= 3;
        }
        if (length == 2) {
            stringBuffer.append(d(((bArr[i] & 255) << 8) | (bArr[i + 1] & 255), 3));
        }
        if (length == 1) {
            stringBuffer.append(d(bArr[i] & 255, 2));
        }
        return stringBuffer.toString();
    }

    private static final long c(byte[] bArr, int i, int i2) {
        int i3 = 0;
        long j = 0;
        while (i2 > 0) {
            i2--;
            int i4 = i + 1;
            byte b = bArr[i];
            long j2 = b == 47 ? 1L : 0L;
            if (b >= 48 && b <= 57) {
                j2 = (b + 2) - 48;
            }
            if (b >= 65 && b <= 90) {
                j2 = (b + 12) - 65;
            }
            if (b >= 97 && b <= 122) {
                j2 = (b + 38) - 97;
            }
            j += j2 << i3;
            i3 += 6;
            i = i4;
        }
        return j;
    }

    private static final String d(long j, int i) {
        StringBuffer stringBuffer = new StringBuffer(i);
        while (i > 0) {
            i--;
            stringBuffer.append(a[(int) (63 & j)]);
            j >>= 6;
        }
        return stringBuffer.toString();
    }
}
