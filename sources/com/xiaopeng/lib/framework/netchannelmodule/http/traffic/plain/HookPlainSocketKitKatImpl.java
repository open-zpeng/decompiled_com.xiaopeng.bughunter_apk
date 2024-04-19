package com.xiaopeng.lib.framework.netchannelmodule.http.traffic.plain;

import com.xiaopeng.lib.framework.netchannelmodule.http.statistic.SocketCounter;
import com.xiaopeng.lib.framework.netchannelmodule.http.traffic.CountingInputStream;
import com.xiaopeng.lib.framework.netchannelmodule.http.traffic.CountingOutputStream;
import com.xiaopeng.lib.framework.netchannelmodule.http.traffic.ICollector;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketImpl;
import java.net.SocketOptions;
/* loaded from: classes.dex */
public class HookPlainSocketKitKatImpl extends SocketImpl implements SocketOptions {
    private Field mAddress;
    private String mDomain;
    private Field mFd;
    private Method mHookAccept;
    private Method mHookAvailable;
    private Method mHookBind;
    private Method mHookClose;
    private Method mHookConnectHostPort;
    private Method mHookConnectInetAddrPort;
    private Method mHookConnectSocketAddrPort;
    private Method mHookCreate;
    private Method mHookGetFileDescriptor;
    private Method mHookGetInputStream;
    private Method mHookGetOutputStream;
    private Method mHookListen;
    private Method mHookSendUrgentData;
    private CountingInputStream mInputStream;
    private CountingOutputStream mOutputStream;
    private Field mPort;
    private final SocketImpl mSocketImpl;
    private final String TAG = "SocketImplHook";
    private ICollector mCollector = new ICollector() { // from class: com.xiaopeng.lib.framework.netchannelmodule.http.traffic.plain.HookPlainSocketKitKatImpl.1
        @Override // com.xiaopeng.lib.framework.netchannelmodule.http.traffic.ICollector
        public String getDomain() {
            return HookPlainSocketKitKatImpl.this.mDomain == null ? "" : HookPlainSocketKitKatImpl.this.mDomain;
        }
    };

    public HookPlainSocketKitKatImpl(SocketImpl socketImpl) {
        boolean z = false;
        if (socketImpl != null) {
            try {
                Class<?> cls = socketImpl.getClass();
                this.mHookCreate = cls.getDeclaredMethod("create", Boolean.TYPE);
                Class<?> cls2 = Integer.TYPE;
                this.mHookConnectHostPort = cls.getDeclaredMethod("connect", String.class, cls2);
                this.mHookConnectInetAddrPort = cls.getDeclaredMethod("connect", InetAddress.class, cls2);
                this.mHookConnectSocketAddrPort = cls.getDeclaredMethod("connect", SocketAddress.class, cls2);
                this.mHookBind = cls.getDeclaredMethod("bind", InetAddress.class, cls2);
                this.mHookListen = cls.getDeclaredMethod("listen", cls2);
                this.mHookAccept = cls.getDeclaredMethod("accept", SocketImpl.class);
                this.mHookGetInputStream = cls.getDeclaredMethod("getInputStream", new Class[0]);
                this.mHookGetOutputStream = cls.getDeclaredMethod("getOutputStream", new Class[0]);
                this.mHookAvailable = cls.getDeclaredMethod("available", new Class[0]);
                this.mHookClose = cls.getDeclaredMethod("close", new Class[0]);
                this.mHookCreate.setAccessible(true);
                this.mHookConnectHostPort.setAccessible(true);
                this.mHookConnectInetAddrPort.setAccessible(true);
                this.mHookConnectSocketAddrPort.setAccessible(true);
                this.mHookBind.setAccessible(true);
                this.mHookGetInputStream.setAccessible(true);
                this.mHookGetOutputStream.setAccessible(true);
                this.mHookAvailable.setAccessible(true);
                this.mHookClose.setAccessible(true);
                this.mHookSendUrgentData = cls.getDeclaredMethod("sendUrgentData", cls2);
                Method method = cls.getMethod("getFD$", new Class[0]);
                this.mHookGetFileDescriptor = method;
                method.setAccessible(true);
                hookSuperClassMembers(cls);
            } catch (Exception e) {
                tf.b("SocketImplHook", null, e);
            }
        }
        z = true;
        if (z) {
            this.mSocketImpl = socketImpl;
        } else {
            this.mSocketImpl = null;
        }
        ((SocketImpl) this).fd = new FileDescriptor();
    }

    private void hookSuperClassMembers(Class<?> cls) throws NoSuchFieldException {
        Class<? super Object> superclass = cls.getSuperclass();
        if (SocketImpl.class.getName().equals(superclass.getName())) {
            this.mAddress = superclass.getDeclaredField("address");
            this.mPort = superclass.getDeclaredField("port");
            this.mFd = superclass.getDeclaredField("fd");
            this.mAddress.setAccessible(true);
            this.mPort.setAccessible(true);
            this.mFd.setAccessible(true);
        }
    }

    private void syncWithImpl() {
        FileDescriptor fileDescriptor = getFileDescriptor();
        if (fileDescriptor == null || !fileDescriptor.valid()) {
            try {
                Field field = this.mFd;
                if (field != null) {
                    field.set(this.mSocketImpl, ((SocketImpl) this).fd);
                }
                Field field2 = this.mAddress;
                if (field2 != null) {
                    field2.set(this.mSocketImpl, ((SocketImpl) this).address);
                }
                Field field3 = this.mPort;
                if (field3 != null) {
                    field3.set(this.mSocketImpl, Integer.valueOf(((SocketImpl) this).port));
                }
            } catch (IllegalAccessException e) {
                tf.a("SocketImplHook", e.toString());
            }
        }
    }

    @Override // java.net.SocketImpl
    protected void accept(SocketImpl socketImpl) throws IOException {
        Method method;
        SocketImpl socketImpl2 = this.mSocketImpl;
        if (socketImpl2 != null && (method = this.mHookAccept) != null) {
            try {
                method.invoke(socketImpl2, socketImpl);
                return;
            } catch (Exception e) {
                Throwable cause = e.getCause();
                Throwable th = e;
                if (cause != null) {
                    th = e.getCause();
                }
                if (th instanceof IOException) {
                    throw ((IOException) th);
                }
                throw new IOException(th);
            }
        }
        throw new RuntimeException();
    }

    @Override // java.net.SocketImpl
    protected int available() throws IOException {
        Method method;
        SocketImpl socketImpl = this.mSocketImpl;
        if (socketImpl != null && (method = this.mHookAvailable) != null) {
            try {
                return ((Integer) method.invoke(socketImpl, new Object[0])).intValue();
            } catch (Exception e) {
                Throwable cause = e.getCause();
                Throwable th = e;
                if (cause != null) {
                    th = e.getCause();
                }
                if (th instanceof IOException) {
                    throw ((IOException) th);
                }
                throw new IOException(th);
            }
        }
        throw new RuntimeException();
    }

    @Override // java.net.SocketImpl
    protected void bind(InetAddress inetAddress, int i) throws IOException {
        Method method;
        SocketImpl socketImpl = this.mSocketImpl;
        if (socketImpl != null && (method = this.mHookBind) != null) {
            try {
                method.invoke(socketImpl, inetAddress, Integer.valueOf(i));
                ((SocketImpl) this).fd = getFileDescriptor();
                return;
            } catch (Exception e) {
                Throwable cause = e.getCause();
                Throwable th = e;
                if (cause != null) {
                    th = e.getCause();
                }
                if (th instanceof IOException) {
                    throw ((IOException) th);
                }
                throw new IOException(th);
            }
        }
        throw new RuntimeException();
    }

    @Override // java.net.SocketImpl
    protected void close() throws IOException {
        Method method;
        SocketImpl socketImpl = this.mSocketImpl;
        if (socketImpl != null && (method = this.mHookClose) != null) {
            try {
                method.invoke(socketImpl, new Object[0]);
                CountingInputStream countingInputStream = this.mInputStream;
                if (countingInputStream != null) {
                    countingInputStream.close();
                    this.mInputStream = null;
                }
                CountingOutputStream countingOutputStream = this.mOutputStream;
                if (countingOutputStream != null) {
                    countingOutputStream.close();
                    this.mOutputStream = null;
                    return;
                }
                return;
            } catch (Exception e) {
                Throwable cause = e.getCause();
                Throwable th = e;
                if (cause != null) {
                    th = e.getCause();
                }
                if (th instanceof IOException) {
                    throw ((IOException) th);
                }
                throw new IOException(th);
            }
        }
        throw new RuntimeException();
    }

    @Override // java.net.SocketImpl
    protected void connect(String str, int i) throws IOException {
        Method method;
        if (this.mAddress != null) {
            tf.a("SocketImplHook", "host=" + str + ",port=" + i);
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(":");
            sb.append(str);
            this.mDomain = sb.toString();
        }
        SocketImpl socketImpl = this.mSocketImpl;
        if (socketImpl != null && (method = this.mHookConnectHostPort) != null) {
            try {
                method.invoke(socketImpl, str, Integer.valueOf(i));
                SocketCounter.getInstance().increaseRequest(this.mDomain, 0L);
                return;
            } catch (Exception e) {
                Throwable cause = e.getCause();
                Throwable th = e;
                if (cause != null) {
                    th = e.getCause();
                }
                if (th instanceof IOException) {
                    throw ((IOException) th);
                }
                throw new IOException(th);
            }
        }
        throw new RuntimeException();
    }

    @Override // java.net.SocketImpl
    protected void create(boolean z) throws IOException {
        Method method;
        SocketImpl socketImpl = this.mSocketImpl;
        if (socketImpl != null && (method = this.mHookCreate) != null) {
            try {
                method.invoke(socketImpl, Boolean.valueOf(z));
                return;
            } catch (Exception e) {
                Throwable cause = e.getCause();
                Throwable th = e;
                if (cause != null) {
                    th = e.getCause();
                }
                if (th instanceof IOException) {
                    throw ((IOException) th);
                }
                throw new IOException(th);
            }
        }
        throw new RuntimeException();
    }

    public FileDescriptor getFD$() {
        return getFileDescriptor();
    }

    @Override // java.net.SocketImpl
    protected FileDescriptor getFileDescriptor() {
        Method method;
        SocketImpl socketImpl = this.mSocketImpl;
        if (socketImpl != null && (method = this.mHookGetFileDescriptor) != null) {
            try {
                return (FileDescriptor) method.invoke(socketImpl, new Object[0]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override // java.net.SocketImpl
    protected InputStream getInputStream() throws IOException {
        Method method;
        CountingInputStream countingInputStream = this.mInputStream;
        if (countingInputStream != null) {
            return countingInputStream;
        }
        SocketImpl socketImpl = this.mSocketImpl;
        if (socketImpl != null && (method = this.mHookGetInputStream) != null) {
            try {
                CountingInputStream countingInputStream2 = new CountingInputStream(this.mCollector, (InputStream) method.invoke(socketImpl, new Object[0]));
                this.mInputStream = countingInputStream2;
                countingInputStream2.setStatisticCounter(SocketCounter.getInstance());
                SocketCounter.getInstance().increaseSucceedWithSize(this.mDomain, 0L);
                return this.mInputStream;
            } catch (Exception e) {
                Throwable cause = e.getCause();
                Throwable th = e;
                if (cause != null) {
                    th = e.getCause();
                }
                if (th instanceof IOException) {
                    throw ((IOException) th);
                }
                throw new IOException(th);
            }
        }
        throw new RuntimeException();
    }

    @Override // java.net.SocketOptions
    public Object getOption(int i) throws SocketException {
        SocketImpl socketImpl = this.mSocketImpl;
        if (socketImpl != null) {
            return socketImpl.getOption(i);
        }
        return null;
    }

    @Override // java.net.SocketImpl
    protected OutputStream getOutputStream() throws IOException {
        Method method;
        CountingOutputStream countingOutputStream = this.mOutputStream;
        if (countingOutputStream != null) {
            return countingOutputStream;
        }
        SocketImpl socketImpl = this.mSocketImpl;
        if (socketImpl != null && (method = this.mHookGetOutputStream) != null) {
            try {
                CountingOutputStream countingOutputStream2 = new CountingOutputStream(this.mCollector, (OutputStream) method.invoke(socketImpl, new Object[0]));
                this.mOutputStream = countingOutputStream2;
                countingOutputStream2.setStatisticCounter(SocketCounter.getInstance());
                return this.mOutputStream;
            } catch (Exception e) {
                Throwable cause = e.getCause();
                Throwable th = e;
                if (cause != null) {
                    th = e.getCause();
                }
                if (th instanceof IOException) {
                    throw ((IOException) th);
                }
                throw new IOException(th);
            }
        }
        throw new RuntimeException();
    }

    @Override // java.net.SocketImpl
    protected void listen(int i) throws IOException {
        Method method;
        SocketImpl socketImpl = this.mSocketImpl;
        if (socketImpl != null && (method = this.mHookListen) != null) {
            try {
                method.invoke(socketImpl, Integer.valueOf(i));
                return;
            } catch (Exception e) {
                Throwable cause = e.getCause();
                Throwable th = e;
                if (cause != null) {
                    th = e.getCause();
                }
                if (th instanceof IOException) {
                    throw ((IOException) th);
                }
                throw new IOException(th);
            }
        }
        throw new RuntimeException();
    }

    @Override // java.net.SocketImpl
    protected void sendUrgentData(int i) throws IOException {
        Method method;
        SocketImpl socketImpl = this.mSocketImpl;
        if (socketImpl != null && (method = this.mHookSendUrgentData) != null) {
            try {
                method.invoke(socketImpl, Integer.valueOf(i));
                return;
            } catch (Exception e) {
                Throwable cause = e.getCause();
                Throwable th = e;
                if (cause != null) {
                    th = e.getCause();
                }
                if (th instanceof IOException) {
                    throw ((IOException) th);
                }
                throw new IOException(th);
            }
        }
        throw new RuntimeException();
    }

    @Override // java.net.SocketOptions
    public void setOption(int i, Object obj) throws SocketException {
        syncWithImpl();
        SocketImpl socketImpl = this.mSocketImpl;
        if (socketImpl != null) {
            socketImpl.setOption(i, obj);
        }
    }

    @Override // java.net.SocketImpl
    protected void shutdownInput() throws IOException {
    }

    @Override // java.net.SocketImpl
    protected void shutdownOutput() throws IOException {
    }

    @Override // java.net.SocketImpl
    protected boolean supportsUrgentData() {
        return false;
    }

    @Override // java.net.SocketImpl
    protected void connect(InetAddress inetAddress, int i) throws IOException {
        Method method;
        if (inetAddress != null) {
            tf.a("SocketImplHook", "InetAddr=" + inetAddress.toString() + ", port=" + i);
            StringBuilder sb = new StringBuilder();
            sb.append(inetAddress.getHostName());
            sb.append(":");
            sb.append(i);
            this.mDomain = sb.toString();
        }
        SocketImpl socketImpl = this.mSocketImpl;
        if (socketImpl != null && (method = this.mHookConnectInetAddrPort) != null) {
            try {
                method.invoke(socketImpl, inetAddress, Integer.valueOf(i));
                SocketCounter.getInstance().increaseRequest(this.mDomain, 0L);
                return;
            } catch (Exception e) {
                Throwable cause = e.getCause();
                Throwable th = e;
                if (cause != null) {
                    th = e.getCause();
                }
                if (th instanceof IOException) {
                    throw ((IOException) th);
                }
                throw new IOException(th);
            }
        }
        throw new RuntimeException();
    }

    @Override // java.net.SocketImpl
    protected void connect(SocketAddress socketAddress, int i) throws IOException {
        Method method;
        if (socketAddress != null) {
            tf.a("SocketImplHook", "SocketAddr=" + socketAddress + ",port=" + ((SocketImpl) this).port);
            this.mDomain = socketAddress.toString();
        }
        SocketImpl socketImpl = this.mSocketImpl;
        if (socketImpl != null && (method = this.mHookConnectSocketAddrPort) != null) {
            try {
                method.invoke(socketImpl, socketAddress, Integer.valueOf(i));
                SocketCounter.getInstance().increaseRequest(this.mDomain, 0L);
                return;
            } catch (Exception e) {
                Throwable cause = e.getCause();
                Throwable th = e;
                if (cause != null) {
                    th = e.getCause();
                }
                if (th instanceof IOException) {
                    throw ((IOException) th);
                }
                throw new IOException(th);
            }
        }
        throw new RuntimeException();
    }
}
