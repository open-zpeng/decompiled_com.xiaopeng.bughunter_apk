package com.xiaopeng.lib.security.xmartv1;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.xiaopeng.lib.http.FileUtils;
import com.xiaopeng.lib.http.ICallback;
import com.xiaopeng.lib.http.Security;
import com.xiaopeng.lib.security.ISecurityModule;
import com.xiaopeng.lib.security.SecurityCommon;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.LinkedHashMap;
/* loaded from: classes.dex */
public class RandomKeySecurity implements ISecurityModule {
    private static final String INDIV_FLAG_FILE_NAME = "si_flag.dat";
    private static final String NLSS_FILE_PATH = "/mnt/vendor/private/sec/";
    private static final String TAG = "RandomKeySecurity";
    private static boolean sIsInitSuccess;
    private SharedPreferences mSecureStore;
    private ISecurityModule.UidListener mUidListener = null;
    private Context sContext;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class Holder {
        private static final RandomKeySecurity INSTANCE = new RandomKeySecurity();

        private Holder() {
        }
    }

    /* loaded from: classes.dex */
    public class SecurityKeyBean {
        public int index;
        public String key;

        public SecurityKeyBean() {
        }
    }

    public static RandomKeySecurity getInstance() {
        return Holder.INSTANCE;
    }

    @Override // com.xiaopeng.lib.security.ISecurityModule
    public void asyncGetMCUSecurityKey(ICallback<byte[], String> iCallback) {
    }

    @Override // com.xiaopeng.lib.security.ISecurityModule
    public void asyncSaveToken(final String[] strArr, final String[] strArr2, final Runnable runnable) {
        if (sIsInitSuccess) {
            ag.i(new Runnable() { // from class: com.xiaopeng.lib.security.xmartv1.RandomKeySecurity.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        RandomKeySecurity.this.saveToken(strArr, strArr2);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    runnable.run();
                }
            });
            return;
        }
        throw new IllegalStateException("RandomKeySecurity:未初始化!");
    }

    @Override // com.xiaopeng.lib.security.ISecurityModule
    public void asyncSaveTokenWithListener(final String[] strArr, final String[] strArr2, final ISecurityModule.ResultListener resultListener) {
        if (sIsInitSuccess) {
            ag.i(new Runnable() { // from class: com.xiaopeng.lib.security.xmartv1.RandomKeySecurity.3
                @Override // java.lang.Runnable
                public void run() {
                    String str;
                    ISecurityModule.ResultListener.RESULT result = ISecurityModule.ResultListener.RESULT.FAIL;
                    try {
                        RandomKeySecurity.this.saveToken(strArr, strArr2);
                        result = ISecurityModule.ResultListener.RESULT.SUCCEED;
                        str = "";
                    } catch (Throwable th) {
                        String message = th.getMessage();
                        th.printStackTrace();
                        str = message;
                    }
                    resultListener.onResult(result, str);
                }
            });
            return;
        }
        throw new IllegalStateException("RandomKeySecurity:未初始化!");
    }

    @Override // com.xiaopeng.lib.security.ISecurityModule
    public String buildTokenData(String[] strArr, byte[] bArr) {
        EncodingItem encodingItem;
        if (sIsInitSuccess) {
            byte[] encode = Base64.encode(bArr, 2);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            HashMap hashMap = new HashMap();
            ISecurityModule.UidListener uidListener = this.mUidListener;
            String currentUid = uidListener != null ? uidListener.getCurrentUid() : null;
            int i = 0;
            for (int i2 = 0; i2 < strArr.length; i2++) {
                String str = strArr[i2];
                if (!TextUtils.isEmpty(currentUid)) {
                    str = SecurityCommon.getUidIdsKey(currentUid, strArr[i2]);
                }
                String string = getString(str);
                if (TextUtils.isEmpty(string)) {
                    hashMap.put(Integer.valueOf(i2), Boolean.TRUE);
                } else {
                    hashMap.put(Integer.valueOf(i2), Boolean.FALSE);
                    linkedHashMap.put(strArr[i2], string);
                    i += strArr[i2].length() + 2 + string.length();
                }
            }
            tf.a(TAG, "buildTokenData skipListMap = " + hashMap);
            if (i > 0) {
                try {
                    ByteBuffer put = ByteBuffer.allocate(encode.length + i).put(encode);
                    for (int i3 = 0; i3 < strArr.length; i3++) {
                        if (true != ((Boolean) hashMap.get(Integer.valueOf(i3))).booleanValue()) {
                            put.put((byte) 38).put(strArr[i3].getBytes(XmartV1Constants.UTF8_ENCODING)).put((byte) 61).put(((String) linkedHashMap.get(strArr[i3])).getBytes(XmartV1Constants.UTF8_ENCODING));
                        }
                    }
                    encode = put.array();
                } catch (Exception e) {
                    tf.f(TAG, "buildTokenData ex = " + e);
                    encodingItem = null;
                }
            }
            encodingItem = EncodingItem.encode(encode);
            if (encodingItem == null || encodingItem.isEmpty()) {
                return null;
            }
            return encodingItem.encodedString();
        }
        throw new IllegalStateException("RandomKeySecurity:未初始化!");
    }

    @Override // com.xiaopeng.lib.security.ISecurityModule
    public void clearIndividualData() {
        if (SecurityCommon.checkSystemUid(this.sContext)) {
            try {
                KeyStoreHelper.cleanIndividualKeys();
                FileUtils.deleteFile("/mnt/vendor/private/sec/si_flag.dat");
                this.mSecureStore.edit().clear().commit();
                return;
            } catch (Exception e) {
                tf.a(TAG, "清除个性化失败!");
                e.printStackTrace();
                return;
            }
        }
        throw new RuntimeException("仅系统进程允许调用个性化操作!");
    }

    @Override // com.xiaopeng.lib.security.ISecurityModule
    public String cryptoDecode(String str, String str2, byte[] bArr) {
        byte[] cryptoDecodeInByteArray = cryptoDecodeInByteArray(str, str2, bArr);
        if (cryptoDecodeInByteArray != null) {
            return new String(cryptoDecodeInByteArray);
        }
        return null;
    }

    @Override // com.xiaopeng.lib.security.ISecurityModule
    public byte[] cryptoDecodeInByteArray(String str, String str2, byte[] bArr) {
        if (sIsInitSuccess) {
            return KeyStoreHelper.decryptStringWithKey(bArr, str, str2.getBytes());
        }
        throw new IllegalStateException("RandomKeySecurity:未初始化!");
    }

    @Override // com.xiaopeng.lib.security.ISecurityModule
    public String decode(String str) {
        if (sIsInitSuccess) {
            try {
                return EncodingItem.decode(str.getBytes(XmartV1Constants.UTF8_ENCODING)).rawContentString();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        throw new IllegalStateException("RandomKeySecurity:未初始化!");
    }

    @Override // com.xiaopeng.lib.security.ISecurityModule
    public void deleteString(String str) {
        this.mSecureStore.edit().remove(str).commit();
    }

    @Override // com.xiaopeng.lib.security.ISecurityModule
    public void destroy() {
    }

    @Override // com.xiaopeng.lib.security.ISecurityModule
    public String encode(String str) {
        if (sIsInitSuccess) {
            try {
                return EncodingItem.encode(str.getBytes(XmartV1Constants.UTF8_ENCODING)).encodedString();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        throw new IllegalStateException("RandomKeySecurity:未初始化!");
    }

    public String encodeWithIndex(String str, int i) {
        if (sIsInitSuccess) {
            try {
                return EncodingItem.encode(str.getBytes(XmartV1Constants.UTF8_ENCODING), i).encodedString();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        throw new IllegalStateException("RandomKeySecurity:未初始化!");
    }

    @Override // com.xiaopeng.lib.security.ISecurityModule
    public String generateIndividualDataForServer() throws Exception {
        return "";
    }

    @Override // com.xiaopeng.lib.security.ISecurityModule
    public Security.EncryptionType getEncryptionType() {
        return Security.EncryptionType.TEE_RANDOM_KEY;
    }

    @Override // com.xiaopeng.lib.security.ISecurityModule
    public String getIndividualFlag() {
        try {
            return FileUtils.readTextFile(new File("/mnt/vendor/private/sec/si_flag.dat"), 1, null);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.xiaopeng.lib.security.ISecurityModule
    public String getIndividualRequestStr() throws Exception {
        return "";
    }

    @Override // com.xiaopeng.lib.security.ISecurityModule
    public String getString(String str) {
        byte[] decryptGeneral;
        if (sIsInitSuccess) {
            String string = this.mSecureStore.getString(str, "");
            if (TextUtils.isEmpty(string) || (decryptGeneral = KeyStoreHelper.decryptGeneral(SecurityCommon.parseHexStr2Byte(string), EncodingItem.getGeneralKeyAlias())) == null || decryptGeneral.length == 0) {
                return "";
            }
            try {
                return new String(decryptGeneral, XmartV1Constants.UTF8_ENCODING);
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }
        throw new IllegalStateException("RandomKeySecurity:未初始化!");
    }

    @Override // com.xiaopeng.lib.security.ISecurityModule
    public boolean individualWithData(String str) throws Exception {
        tf.a(TAG, str);
        try {
            LinkedHashMap linkedHashMap = (LinkedHashMap) new Gson().fromJson(str, new TypeToken<LinkedHashMap<Integer, SecurityKeyBean>>() { // from class: com.xiaopeng.lib.security.xmartv1.RandomKeySecurity.1
            }.getType());
            int size = linkedHashMap.size();
            int i = XmartV1Constants.LOCAL_KEYS_NUM;
            if (size != i) {
                tf.a(TAG, "Wrong individual data with length " + linkedHashMap.size() + ", expected " + XmartV1Constants.LOCAL_KEYS_NUM);
                return false;
            }
            HashMap hashMap = new HashMap(i);
            for (Integer num : linkedHashMap.keySet()) {
                hashMap.put(XmartV1Constants.LOCAL_KEYS_PREFIX + num, Base64.decode(((SecurityKeyBean) linkedHashMap.get(num)).key, 0));
                tf.a(TAG, "Wrote security key #" + num + "!");
            }
            KeyStoreHelper.writeSecretData(hashMap);
            KeyStoreHelper.store();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.xiaopeng.lib.security.ISecurityModule
    public boolean isInitAndIndivSuccess() {
        return sIsInitSuccess && KeyStoreHelper.hasValidIndividualKeys();
    }

    @Override // com.xiaopeng.lib.security.ISecurityModule
    public boolean isInitSuccess() {
        return sIsInitSuccess;
    }

    @Override // com.xiaopeng.lib.security.ISecurityModule
    public void saveIndividualFlag() {
        try {
            FileUtils.stringToFile("/mnt/vendor/private/sec/si_flag.dat", SecurityCommon.getBuildInfoFlag());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.xiaopeng.lib.security.ISecurityModule
    public void saveMCUSecurityKey(boolean z) {
    }

    public void saveToken(String[] strArr, String[] strArr2) {
        if (strArr.length != strArr2.length) {
            tf.a(TAG, "Invalid tokens.");
            return;
        }
        for (int i = 0; i < strArr.length; i++) {
            String decode = decode(strArr2[i]);
            if (decode != null) {
                setString(strArr[i], decode);
            } else {
                throw new IllegalStateException("RandomKeySecurity: token decode failed!");
            }
        }
    }

    @Override // com.xiaopeng.lib.security.ISecurityModule
    public void setString(String str, String str2) {
        if (sIsInitSuccess) {
            if (TextUtils.isEmpty(str2)) {
                this.mSecureStore.edit().putString(str, str2).commit();
                return;
            }
            try {
                byte[] encryptGeneral = KeyStoreHelper.encryptGeneral(str2.getBytes(XmartV1Constants.UTF8_ENCODING), EncodingItem.getGeneralKeyAlias());
                if (encryptGeneral == null || encryptGeneral.length <= 0) {
                    return;
                }
                this.mSecureStore.edit().putString(str, SecurityCommon.parseByte2HexStr(encryptGeneral)).commit();
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        throw new IllegalStateException("RandomKeySecurity:未初始化!");
    }

    @Override // com.xiaopeng.lib.security.ISecurityModule
    public void setUidListener(ISecurityModule.UidListener uidListener) {
        this.mUidListener = uidListener;
    }

    @Override // com.xiaopeng.lib.security.ISecurityModule
    public RandomKeySecurity init(Context context) throws Exception {
        synchronized (RandomKeySecurity.class) {
            sIsInitSuccess = KeyStoreHelper.init();
            this.mSecureStore = context.getSharedPreferences(TAG, 0);
            this.sContext = context.getApplicationContext();
        }
        return this;
    }

    @Override // com.xiaopeng.lib.security.ISecurityModule
    public RandomKeySecurity initForIndividual(Context context) throws Exception {
        if (SecurityCommon.checkSystemUid(context)) {
            return init(context);
        }
        throw new RuntimeException("仅系统进程允许调用个性化操作!");
    }

    @Override // com.xiaopeng.lib.security.ISecurityModule
    public void asyncSaveToken(final String str, final String[] strArr, final String[] strArr2, final Runnable runnable) {
        if (sIsInitSuccess) {
            ag.i(new Runnable() { // from class: com.xiaopeng.lib.security.xmartv1.RandomKeySecurity.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        RandomKeySecurity.this.saveToken(strArr, strArr2);
                        RandomKeySecurity.this.saveToken(str, strArr, strArr2);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    runnable.run();
                }
            });
            return;
        }
        throw new IllegalStateException("RandomKeySecurity:未初始化!");
    }

    @Override // com.xiaopeng.lib.security.ISecurityModule
    public void asyncSaveTokenWithListener(final String str, final String[] strArr, final String[] strArr2, final ISecurityModule.ResultListener resultListener) {
        if (sIsInitSuccess) {
            ag.i(new Runnable() { // from class: com.xiaopeng.lib.security.xmartv1.RandomKeySecurity.5
                @Override // java.lang.Runnable
                public void run() {
                    String str2;
                    ISecurityModule.ResultListener.RESULT result = ISecurityModule.ResultListener.RESULT.FAIL;
                    try {
                        RandomKeySecurity.this.saveToken(strArr, strArr2);
                        RandomKeySecurity.this.saveToken(str, strArr, strArr2);
                        result = ISecurityModule.ResultListener.RESULT.SUCCEED;
                        str2 = "";
                    } catch (Throwable th) {
                        String message = th.getMessage();
                        th.printStackTrace();
                        str2 = message;
                    }
                    resultListener.onResult(result, str2);
                }
            });
            return;
        }
        throw new IllegalStateException("RandomKeySecurity:未初始化!");
    }

    public void saveToken(String str, String[] strArr, String[] strArr2) {
        if (strArr.length != strArr2.length) {
            tf.a(TAG, "Invalid tokens.");
            return;
        }
        for (int i = 0; i < strArr.length; i++) {
            String decode = decode(strArr2[i]);
            if (decode != null) {
                String uidIdsKey = SecurityCommon.getUidIdsKey(str, strArr[i]);
                tf.l(TAG, "saveToken key = " + uidIdsKey);
                setString(uidIdsKey, decode);
            } else {
                throw new IllegalStateException("RandomKeySecurity: token decode failed!");
            }
        }
    }
}
