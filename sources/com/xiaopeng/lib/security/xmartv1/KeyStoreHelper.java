package com.xiaopeng.lib.security.xmartv1;

import android.os.Build;
import android.security.keystore.KeyProtection;
import android.text.TextUtils;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes.dex */
public final class KeyStoreHelper {
    private static String TAG = "KeyStoreHelper";
    private static KeyStore sKeyStore;
    private static boolean sUsedDefaultKeyStore;
    private static String PASSWORD = uf.a(XmartV1Constants.KEY_MANAGER_PASSWORD);
    private static String KEY_STORE_PATH = "/private/sec/XpengAndroidKeyStore";
    private static HashMap<String, SecretKey> sSecretKeyMap = new HashMap<>();

    public static boolean cleanIndividualKeys() throws KeyStoreException {
        if (sKeyStore == null) {
            tf.a(TAG, "KeyStore was not initialized!");
            return false;
        }
        for (int i = 0; i < XmartV1Constants.LOCAL_KEYS_NUM; i++) {
            try {
                KeyStore keyStore = sKeyStore;
                if (keyStore.containsAlias(XmartV1Constants.LOCAL_KEYS_PREFIX + i)) {
                    KeyStore keyStore2 = sKeyStore;
                    keyStore2.deleteEntry(XmartV1Constants.LOCAL_KEYS_PREFIX + i);
                }
            } catch (Exception e) {
                tf.c(TAG, e);
                throw e;
            }
        }
        return true;
    }

    public static byte[] decryptGeneral(byte[] bArr, String str) {
        try {
            SecretKey secretKey = getSecretKey(str);
            if (secretKey == null) {
                return null;
            }
            return decryptInternal(bArr, secretKey);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static byte[] decryptInternal(byte[] bArr, SecretKey secretKey) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        try {
            Cipher cipher = Cipher.getInstance(XmartV1Constants.AES_GCM_NO_PADDING);
            cipher.init(2, secretKey, getParamsSpec(XmartV1Constants.FIXED_IV));
            return cipher.doFinal(bArr);
        } catch (Exception e) {
            tf.c(TAG, e);
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] decryptString(byte[] bArr, String str, byte[] bArr2) {
        if (bArr == null || bArr.length == 0 || TextUtils.isEmpty(str)) {
            return null;
        }
        return decryptWithStream(new ByteArrayInputStream(bArr), str, bArr2);
    }

    public static byte[] decryptStringWithKey(byte[] bArr, String str, byte[] bArr2) {
        if (bArr == null || bArr.length == 0 || bArr2 == null || bArr2.length == 0) {
            return null;
        }
        return decryptWithStreamAndKey(new ByteArrayInputStream(bArr), new SecretKeySpec(str.getBytes(), "AES"), bArr2);
    }

    public static byte[] decryptWithByteBuffer(ByteBuffer byteBuffer, String str, byte[] bArr) {
        if (byteBuffer == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return decryptWithStream(new ByteBufferInputStream(byteBuffer), str, bArr);
    }

    private static byte[] decryptWithStream(InputStream inputStream, String str, byte[] bArr) {
        if (inputStream == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            SecretKey secretKey = getSecretKey(str);
            if (secretKey == null) {
                return null;
            }
            return decryptWithStreamAndKey(inputStream, secretKey, bArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static byte[] decryptWithStreamAndKey(InputStream inputStream, SecretKey secretKey, byte[] bArr) {
        byte[] bArr2 = null;
        if (inputStream != null && bArr != null && bArr.length != 0) {
            try {
                Cipher cipher = Cipher.getInstance(XmartV1Constants.AES_GCM_NO_PADDING);
                cipher.init(2, secretKey, getParamsSpec(bArr));
                CipherInputStream cipherInputStream = new CipherInputStream(inputStream, cipher);
                ArrayList arrayList = new ArrayList();
                while (true) {
                    int read = cipherInputStream.read();
                    if (read == -1) {
                        break;
                    }
                    arrayList.add(Byte.valueOf((byte) read));
                }
                int size = arrayList.size();
                bArr2 = new byte[size];
                for (int i = 0; i < size; i++) {
                    bArr2[i] = ((Byte) arrayList.get(i)).byteValue();
                }
            } catch (Exception e) {
                String str = TAG;
                tf.a(str, "Exception:" + e);
            }
        }
        return bArr2;
    }

    public static byte[] encryptGeneral(byte[] bArr, String str) {
        try {
            SecretKey secretKey = getSecretKey(str);
            if (secretKey == null) {
                return null;
            }
            return encryptInternal(bArr, secretKey);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static byte[] encryptInternal(byte[] bArr, SecretKey secretKey, byte[] bArr2) {
        byte[] bArr3 = null;
        if (bArr == null || bArr.length == 0 || bArr2 == null || bArr2.length == 0) {
            return null;
        }
        try {
            Cipher cipher = Cipher.getInstance(XmartV1Constants.AES_GCM_NO_PADDING);
            cipher.init(1, secretKey, getParamsSpec(bArr2));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            CipherOutputStream cipherOutputStream = new CipherOutputStream(byteArrayOutputStream, cipher);
            cipherOutputStream.write(bArr);
            cipherOutputStream.close();
            bArr3 = byteArrayOutputStream.toByteArray();
            sf.a(byteArrayOutputStream);
            return bArr3;
        } catch (Exception e) {
            tf.c(TAG, e);
            e.printStackTrace();
            return bArr3;
        }
    }

    public static byte[] encryptString(byte[] bArr, String str, byte[] bArr2) {
        if (bArr == null || bArr.length == 0 || TextUtils.isEmpty(str) || bArr2 == null || bArr2.length == 0) {
            return null;
        }
        try {
            SecretKey secretKey = getSecretKey(str);
            if (secretKey == null) {
                return null;
            }
            return encryptInternal(bArr, secretKey, bArr2);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] encryptWithKey(byte[] bArr, String str, byte[] bArr2) {
        return encryptInternal(bArr, new SecretKeySpec(str.getBytes(), "AES"), bArr2);
    }

    private static AlgorithmParameterSpec getParamsSpec(byte[] bArr) {
        if (Build.VERSION.SDK_INT < 21) {
            return new IvParameterSpec(bArr, 0, bArr.length);
        }
        return new GCMParameterSpec(128, bArr);
    }

    private static SecretKey getSecretKey(String str) throws Exception {
        if (!sKeyStore.containsAlias(str)) {
            String str2 = TAG;
            tf.a(str2, "Not found the key " + str);
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        SecretKey secretKey = sSecretKeyMap.get(str);
        if (secretKey == null) {
            secretKey = (SecretKey) sKeyStore.getKey(str, null);
            sSecretKeyMap.put(str, secretKey);
        }
        if (secretKey == null) {
            String str3 = TAG;
            tf.a(str3, "Failed to load secret key:" + str);
            return null;
        }
        String str4 = TAG;
        Log.i(str4, "cost time:\t" + (System.currentTimeMillis() - currentTimeMillis));
        return secretKey;
    }

    public static boolean hasValidIndividualKeys() {
        boolean z = false;
        if (sKeyStore == null) {
            tf.a(TAG, "KeyStore was not initialized!");
            return false;
        }
        int i = 0;
        while (true) {
            try {
                if (i >= XmartV1Constants.LOCAL_KEYS_NUM) {
                    z = true;
                    break;
                }
                if (!sKeyStore.containsAlias(XmartV1Constants.LOCAL_KEYS_PREFIX + i)) {
                    break;
                }
                i++;
            } catch (Exception e) {
                tf.c(TAG, e);
            }
        }
        if (!z) {
            ff.b().a(6000, "no valid individual keys");
        }
        return z;
    }

    public static boolean init() {
        if (sKeyStore != null) {
            return true;
        }
        boolean loadWithXmartKeyStore = loadWithXmartKeyStore();
        if (!loadWithXmartKeyStore) {
            ff.b().a(6001, "failed to init xmart keystore");
            loadWithXmartKeyStore = loadWithDefaultKeyStore();
            if (!loadWithXmartKeyStore) {
                ff.b().a(6002, "failed to init default keystore");
            }
        }
        return loadWithXmartKeyStore;
    }

    private static boolean loadWithDefaultKeyStore() {
        FileInputStream fileInputStream = null;
        boolean z = false;
        try {
            try {
                sKeyStore = KeyStore.getInstance(KeyStore.getDefaultType());
                if (new File(KEY_STORE_PATH).exists()) {
                    FileInputStream fileInputStream2 = new FileInputStream(KEY_STORE_PATH);
                    try {
                        sKeyStore.load(fileInputStream2, PASSWORD.toCharArray());
                        fileInputStream = fileInputStream2;
                    } catch (Exception e) {
                        e = e;
                        fileInputStream = fileInputStream2;
                        tf.a(TAG, "Failed to load default key store, reason:" + e);
                        sf.a(fileInputStream);
                        return z;
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                        sf.a(fileInputStream);
                        throw th;
                    }
                } else {
                    sKeyStore.load(null);
                }
                try {
                    sUsedDefaultKeyStore = true;
                    sf.a(fileInputStream);
                    return true;
                } catch (Exception e2) {
                    z = true;
                    e = e2;
                    tf.a(TAG, "Failed to load default key store, reason:" + e);
                    sf.a(fileInputStream);
                    return z;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    private static boolean loadWithXmartKeyStore() {
        boolean z;
        Exception e;
        try {
            KeyStore keyStore = KeyStore.getInstance(XmartV1Constants.KEY_STORE_TYPE);
            sKeyStore = keyStore;
            keyStore.load(null);
            z = true;
        } catch (Exception e2) {
            z = false;
            e = e2;
        }
        try {
            sUsedDefaultKeyStore = false;
        } catch (Exception e3) {
            e = e3;
            tf.a(TAG, "Failed to load key store, reason:" + e);
            return z;
        }
        return z;
    }

    private static boolean saveKeyStoreToFile() {
        FileOutputStream fileOutputStream;
        Throwable th;
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(KEY_STORE_PATH);
            try {
                sKeyStore.store(fileOutputStream, PASSWORD.toCharArray());
                sf.a(fileOutputStream);
                return true;
            } catch (Exception unused) {
                fileOutputStream2 = fileOutputStream;
                sf.a(fileOutputStream2);
                return false;
            } catch (Throwable th2) {
                th = th2;
                sf.a(fileOutputStream);
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th3) {
            fileOutputStream = null;
            th = th3;
        }
    }

    public static void store() {
        if (sUsedDefaultKeyStore) {
            saveKeyStoreToFile();
        }
    }

    public static void writeSecretData(Map<String, byte[]> map) throws Exception {
        if (sKeyStore == null) {
            init();
        }
        if (map.size() == XmartV1Constants.LOCAL_KEYS_NUM) {
            KeyProtection build = Build.VERSION.SDK_INT >= 23 ? new KeyProtection.Builder(3).setBlockModes("GCM").setEncryptionPaddings("NoPadding").setRandomizedEncryptionRequired(false).build() : null;
            for (String str : map.keySet()) {
                sKeyStore.setEntry(str, new KeyStore.SecretKeyEntry(new SecretKeySpec(map.get(str), "AES")), build);
            }
            return;
        }
        throw new RuntimeException("Illegal security keys!!!!");
    }

    /* loaded from: classes.dex */
    private static final class ByteBufferInputStream extends InputStream {
        ByteBuffer buf;

        public ByteBufferInputStream(ByteBuffer byteBuffer) {
            this.buf = byteBuffer;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            if (this.buf.hasRemaining()) {
                return this.buf.get() & 255;
            }
            return -1;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            if (this.buf.hasRemaining()) {
                int min = Math.min(i2, this.buf.remaining());
                this.buf.get(bArr, i, min);
                return min;
            }
            return -1;
        }
    }

    private static byte[] encryptInternal(byte[] bArr, SecretKey secretKey) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        try {
            Cipher cipher = Cipher.getInstance(XmartV1Constants.AES_GCM_NO_PADDING);
            cipher.init(1, secretKey, getParamsSpec(XmartV1Constants.FIXED_IV));
            return cipher.doFinal(bArr);
        } catch (Exception e) {
            tf.c(TAG, e);
            e.printStackTrace();
            return null;
        }
    }
}
