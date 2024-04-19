package com.xiaopeng.lib.framework.netchannelmodule.http.xmart;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.sdk.android.httpdns.HttpDns;
import com.alibaba.sdk.android.httpdns.HttpDnsService;
import com.xiaopeng.lib.framework.netchannelmodule.common.GlobalConfig;
import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import okhttp3.Dns;
/* loaded from: classes.dex */
public class TimeoutDns implements Dns {
    private static final String ACCOUNT_ID = "133084";
    private static final int MEANINGFUL_MIN_TIMEOUT = 1000;
    private static final String SECRET_KEY = "2bfcc6860a1eaa5ccfc9e54c020ba66e";
    private static final String TAG = "TimeoutDns";
    private static final String XMART_HOST = "xmart.xiaopeng.com";
    private static HttpDnsService sHttpDns = null;
    private static int sHttpDnsTimeout = 5000;
    private static boolean sInitialized = false;
    private static int sTimeout = 10000;
    private LookupService mLookupService;

    /* loaded from: classes.dex */
    private static final class Holder {
        private static final TimeoutDns INSTANCE = new TimeoutDns();

        private Holder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class LookupService {
        private static final String IP_CACHE = "ipCache";
        ExecutorService executor = Executors.newSingleThreadExecutor();
        xf sSharePrefs;

        private LookupService() {
        }

        static LookupService create() {
            return new LookupService();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public InetAddress[] getAddressByHttpDns(String str) {
            String ipByHostAsync = TimeoutDns.sHttpDns.getIpByHostAsync(str);
            tf.a(TimeoutDns.TAG, "the ip getByHostAsync is " + ipByHostAsync);
            if (!TextUtils.isEmpty(ipByHostAsync)) {
                try {
                    tf.a(TimeoutDns.TAG, "the inetAddress getByHttpDns is " + Arrays.toString(InetAddress.getAllByName(ipByHostAsync)));
                    InetAddress[] allByName = InetAddress.getAllByName(ipByHostAsync);
                    saveValidIp(allByName, str);
                    return allByName;
                } catch (UnknownHostException e) {
                    tf.t(TimeoutDns.TAG, "exception occurs when getIpsByHttpDns, and details: ", e);
                }
            }
            try {
                InetAddress[] allByName2 = InetAddress.getAllByName(str);
                tf.a(TimeoutDns.TAG, "the inetAddress getByLocalDns is " + Arrays.toString(allByName2));
                saveValidIp(allByName2, str);
                return allByName2;
            } catch (UnknownHostException e2) {
                tf.t(TimeoutDns.TAG, "exception occurs when getIpsByLocalDns, and details: ", e2);
                return getCacheAddress(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public InetAddress[] getCacheAddress(String str) {
            if (this.sSharePrefs == null) {
                this.sSharePrefs = xf.b(GlobalConfig.getApplicationContext());
            }
            xf xfVar = this.sSharePrefs;
            String f = xfVar.f(IP_CACHE + str, null);
            tf.a(TimeoutDns.TAG, "get ip from cache " + f);
            if (TextUtils.isEmpty(f)) {
                return null;
            }
            try {
                return InetAddress.getAllByName(f);
            } catch (UnknownHostException e) {
                tf.t(TimeoutDns.TAG, "exception occurs when get ip from cache, and details: ", e);
                return null;
            }
        }

        private void saveValidIp(InetAddress[] inetAddressArr, String str) {
            if (inetAddressArr == null || inetAddressArr.length == 0) {
                return;
            }
            if (this.sSharePrefs == null) {
                this.sSharePrefs = xf.b(GlobalConfig.getApplicationContext());
            }
            for (InetAddress inetAddress : inetAddressArr) {
                if ((!inetAddress.isSiteLocalAddress() && !inetAddress.isLoopbackAddress()) || inetAddress.getHostAddress().startsWith("10.")) {
                    String hostAddress = inetAddress.getHostAddress();
                    tf.a(TimeoutDns.TAG, "save valid ip " + hostAddress);
                    this.sSharePrefs.k(IP_CACHE + str, hostAddress);
                    return;
                }
            }
        }

        Future<InetAddress[]> getAllByName(final String str) {
            FutureTask futureTask = new FutureTask(new Callable<InetAddress[]>() { // from class: com.xiaopeng.lib.framework.netchannelmodule.http.xmart.TimeoutDns.LookupService.1
                @Override // java.util.concurrent.Callable
                public InetAddress[] call() {
                    try {
                        return LookupService.this.getAddressByHttpDns(str);
                    } catch (Exception e) {
                        e.printStackTrace();
                        return null;
                    }
                }
            });
            this.executor.execute(futureTask);
            return futureTask;
        }
    }

    private void checkAndInitHttpDns(Context context) {
        if (sInitialized) {
            return;
        }
        synchronized (TimeoutDns.class) {
            if (sInitialized) {
                return;
            }
            if (context != null) {
                HttpDnsService service = HttpDns.getService(context, ACCOUNT_ID, SECRET_KEY);
                sHttpDns = service;
                service.setExpiredIPEnabled(true);
                sHttpDns.setCachedIPEnabled(true);
                sHttpDns.setLogEnabled(true);
                sHttpDns.setHTTPSRequestEnabled(true);
                sHttpDns.setPreResolveAfterNetworkChanged(true);
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(XMART_HOST);
                sHttpDns.setPreResolveHosts(arrayList);
                sHttpDns.setTimeoutInterval(sHttpDnsTimeout);
                hookHttpDns();
                sInitialized = true;
                return;
            }
            throw new IllegalStateException("Not init GlobalConfig with applicationContext");
        }
    }

    public static TimeoutDns getInstance() {
        return Holder.INSTANCE;
    }

    private void hookHttpDns() {
        String[] strArr = {ra.class.getName(), ea.class.getName()};
        for (int i = 0; i < 2; i++) {
            try {
                Field[] declaredFields = Class.forName(strArr[i]).getDeclaredFields();
                int i2 = 0;
                while (true) {
                    if (i2 < declaredFields.length) {
                        Field field = declaredFields[i2];
                        if (field.getType().equals(Boolean.TYPE)) {
                            field.setAccessible(true);
                            field.set(null, Boolean.TRUE);
                        } else if (field.getType().equals(Context.class)) {
                            field.setAccessible(true);
                            field.set(null, null);
                            break;
                        }
                        i2++;
                    }
                }
            } catch (Exception e) {
                tf.a(TAG, "Try to disable httpdns log:" + e);
            }
        }
    }

    public static void timeout(int i) {
        if (i < 1000) {
            i = 1000;
        }
        sTimeout = i;
        sHttpDnsTimeout = (i * 2) / 3;
    }

    @Override // okhttp3.Dns
    public List<InetAddress> lookup(String str) throws UnknownHostException {
        checkAndInitHttpDns(GlobalConfig.getApplicationContext());
        try {
            return Arrays.asList(this.mLookupService.getAllByName(str).get(sTimeout, TimeUnit.MILLISECONDS));
        } catch (Exception unused) {
            tf.a(TAG, "get ip timeout");
            InetAddress[] cacheAddress = this.mLookupService.getCacheAddress(str);
            if (cacheAddress != null && cacheAddress.length > 0) {
                return Arrays.asList(cacheAddress);
            }
            throw new UnknownHostException();
        }
    }

    public List<InetAddress> lookupAsync(String str) throws UnknownHostException {
        try {
            checkAndInitHttpDns(GlobalConfig.getApplicationContext());
            String ipByHostAsync = sHttpDns.getIpByHostAsync(str);
            tf.a(TAG, "async get the ip getByHostAsync is " + ipByHostAsync);
            if (!TextUtils.isEmpty(ipByHostAsync)) {
                return Arrays.asList(InetAddress.getAllByName(ipByHostAsync));
            }
            return new ArrayList();
        } catch (Exception e) {
            tf.t(TAG, "exception occurs when getIpsByHttpDns, and details: ", e);
            throw new UnknownHostException(e.toString());
        }
    }

    private TimeoutDns() {
        this.mLookupService = LookupService.create();
    }

    public static int timeout() {
        return sTimeout;
    }
}
