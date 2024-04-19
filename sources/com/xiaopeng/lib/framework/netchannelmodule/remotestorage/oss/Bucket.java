package com.xiaopeng.lib.framework.netchannelmodule.remotestorage.oss;

import android.os.SystemProperties;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.remotestorage.IRemoteStorage;
/* loaded from: classes.dex */
public class Bucket {
    public static String BUCKET_AND_ENDPOINT = null;
    public static String END_POINT = null;
    public static final String END_POINT_DOMAIN = "oss-cn-hangzhou.aliyuncs.com/";
    public static final String END_POINT_DOMAIN_INT = "oss-eu-central-1.aliyuncs.com/";
    private static final long MAX_LOG_LENGTH = 20971520;
    private static final String SCHEMA = "https://";
    public static String TOKEN_URL_V5;
    private String mRootName;
    private String mUrl;

    /* renamed from: com.xiaopeng.lib.framework.netchannelmodule.remotestorage.oss.Bucket$1  reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$xiaopeng$lib$framework$moduleinterface$netchannelmodule$remotestorage$IRemoteStorage$CATEGORY;

        static {
            int[] iArr = new int[IRemoteStorage.CATEGORY.values().length];
            $SwitchMap$com$xiaopeng$lib$framework$moduleinterface$netchannelmodule$remotestorage$IRemoteStorage$CATEGORY = iArr;
            try {
                iArr[IRemoteStorage.CATEGORY.CAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$xiaopeng$lib$framework$moduleinterface$netchannelmodule$remotestorage$IRemoteStorage$CATEGORY[IRemoteStorage.CATEGORY.CDU.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes.dex */
    private static final class CanBucket extends Bucket {
        private static final String CAN_BUCKET_NAME = "xmart-can-service-log";

        /* synthetic */ CanBucket(AnonymousClass1 anonymousClass1) {
            this();
        }

        private CanBucket() {
            super(CAN_BUCKET_NAME);
        }
    }

    /* loaded from: classes.dex */
    private static final class CduBucket extends Bucket {
        private static final String CDU_BUCKET_NAME = "xmart-cdu-service-log";

        /* synthetic */ CduBucket(AnonymousClass1 anonymousClass1) {
            this();
        }

        private CduBucket() {
            super(CDU_BUCKET_NAME);
        }
    }

    static {
        TOKEN_URL_V5 = cg.d + "/v5/aliyun/token";
        END_POINT = "https://oss-cn-hangzhou.aliyuncs.com/";
        BUCKET_AND_ENDPOINT = "https://%s.oss-cn-hangzhou.aliyuncs.com/";
        try {
            boolean z = !getVersionInCountryCode().contains("ZH");
            tf.l("Bucket", "Version = " + getVersionInCountryCode() + ", international = " + z);
            if (z) {
                TOKEN_URL_V5 = "https://xmart-eu.xiaopeng.com/biz/v5/aliyun/token";
                END_POINT = "https://oss-eu-central-1.aliyuncs.com/";
                BUCKET_AND_ENDPOINT = "https://%s.oss-eu-central-1.aliyuncs.com/";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Bucket(String str) {
        this.mRootName = str;
        this.mUrl = String.format(BUCKET_AND_ENDPOINT, str);
    }

    public static Bucket get(IRemoteStorage.CATEGORY category) {
        int i = AnonymousClass1.$SwitchMap$com$xiaopeng$lib$framework$moduleinterface$netchannelmodule$remotestorage$IRemoteStorage$CATEGORY[category.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return new CduBucket(null);
            }
            throw new RuntimeException("Wrong bucket was specified!");
        }
        return new CanBucket(null);
    }

    public static String getVersionInCountryCode() throws Exception {
        String str = SystemProperties.get("ro.xiaopeng.software", "");
        return ("".equals(str) || str == null || str.length() < 9) ? str : str.substring(7, 9);
    }

    public String generateObjectKey(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        return this.mRootName + "/" + str + "/" + gg.e() + "/" + rf.c(currentTimeMillis) + "/" + yf.h() + "/" + currentTimeMillis + ".zip";
    }

    public long getMaxObjectSize() {
        return MAX_LOG_LENGTH;
    }

    public String getRootName() {
        return this.mRootName;
    }

    public String getUrl() {
        return this.mUrl;
    }

    private Bucket() {
    }
}
