package com.xiaopeng.lib.http;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.google.gson.Gson;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.http.logging.HttpLoggingInterceptor;
import com.xiaopeng.lib.http.server.ServerBean;
import com.xiaopeng.lib.http.tls.HostNameVerifier;
import com.xiaopeng.lib.http.tls.SSLHelper;
import com.xiaopeng.lib.security.SecurityCommon;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class HttpsUtils {
    private static final String ACTION_BROADCAST_CLIENT_SSL_UPDATE = "com.xiaopeng.action.CLIENT_SSL_UPDATE";
    private static final String TAG = "HttpsUtils";
    private static boolean sIsInitialized = false;

    @Deprecated
    /* loaded from: classes.dex */
    public interface ISSLSocketFactoryWrapper {
        SSLSocketFactory createFactoryWrapper(SSLSocketFactory sSLSocketFactory);
    }

    public static String buildBody(Map<String, String> map) {
        try {
            HashMap hashMap = new HashMap(1);
            hashMap.put("sData", Security.encode(new Gson().toJson(map)));
            return new Gson().toJson(hashMap);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String buildBodyWithAllToken(Map<String, String> map) {
        try {
            HashMap hashMap = new HashMap(1);
            hashMap.put("sData", Security.buildTokenData(Security.TOKEN_ALL, new Gson().toJson(map).getBytes()));
            return new Gson().toJson(hashMap);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String buildBodyWithToken(Map<String, String> map) {
        try {
            HashMap hashMap = new HashMap(1);
            hashMap.put("sData", Security.buildTokenData(Security.TOKEN_AC, new Gson().toJson(map).getBytes()));
            return new Gson().toJson(hashMap);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static OkHttpClient buildOkHttpClient(Context context) {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(TAG);
        httpLoggingInterceptor.setPrintLevel((gg.g() || Build.TYPE.equals("userdebug")) ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.BASIC);
        httpLoggingInterceptor.setColorLevel(Level.INFO);
        return new OkHttpClient.Builder().sslSocketFactory(SSLHelper.getTLS2SocketFactory(context), SSLHelper.getX509TrustManager(context)).connectionSpecs(SSLHelper.getConnectionSpecs()).connectionPool(new ConnectionPool()).addInterceptor(httpLoggingInterceptor).readTimeout(30L, TimeUnit.SECONDS).hostnameVerifier(HostNameVerifier.INSTANCE).build();
    }

    public static String decodeBody(ServerBean serverBean) {
        if (serverBean != null && !TextUtils.isEmpty(serverBean.getData())) {
            try {
                String string = new JSONObject(serverBean.getData()).getString("sData");
                if (TextUtils.isEmpty(string)) {
                    Log.d(TAG, "sData is null");
                    return null;
                }
                return Security.decode(string);
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
        Log.d(TAG, "decodeBody bean is null");
        return null;
    }

    public static synchronized void destroy() {
        synchronized (HttpsUtils.class) {
            Security.destroy();
        }
    }

    public static OkHttpClient getOkhttpClient() {
        return wb.h().i();
    }

    public static SSLSocketFactory getTLS2SocketFactory(Context context) {
        return SSLHelper.getTLS2SocketFactory(context);
    }

    public static synchronized boolean init(Application application, boolean z) {
        synchronized (HttpsUtils.class) {
            if (sIsInitialized) {
                return true;
            }
            SecurityCommon.checkSystemUid(application);
            if (z && !Security.isInitSuccess()) {
                Security.init(application);
                if (!Security.isInitSuccessWithoutIndiv()) {
                    tf.s(TAG, "!Security.isInitSuccessWithoutIndiv, return false!");
                    return sIsInitialized;
                }
            }
            Module.register(ig.class, new ig(application));
            initOkHttpClient(application);
            if (SSLHelper.getX509TrustManager(application) == null) {
                tf.s(TAG, "KeyManager init fail, return false!");
                return sIsInitialized;
            }
            sIsInitialized = true;
            return true;
        }
    }

    private static void initOkHttpClient(Application application) {
        tf.a(TAG, "start to initOkHttpClient!!!");
        registerBroadcast(application);
        wb.h().k(application).l(buildOkHttpClient(application));
        tf.a(TAG, "finish initOkHttpClient!!!");
    }

    public static boolean isInitSuccess() {
        return sIsInitialized;
    }

    private static void registerBroadcast(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_BROADCAST_CLIENT_SSL_UPDATE);
        intentFilter.setPriority(Integer.MAX_VALUE);
        context.registerReceiver(new BroadcastReceiver() { // from class: com.xiaopeng.lib.http.HttpsUtils.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                Log.e(HttpsUtils.TAG, "ACTION_BROADCAST_CLIENT_SSL_UPDATE");
                try {
                    wb.h().l(HttpsUtils.buildOkHttpClient(context2));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, intentFilter);
    }

    public static void setHttpInitEventListener(ef efVar) {
        ff.c(efVar);
    }

    @Deprecated
    public static void setSSLSocketFactoryWrapper(ISSLSocketFactoryWrapper iSSLSocketFactoryWrapper) {
    }

    public static void setSSLSocketWrapper(SSLHelper.ISSLSocketWrapper iSSLSocketWrapper) {
        SSLHelper.setSSLSocketWrapper(iSSLSocketWrapper);
    }
}
