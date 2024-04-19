package com.xiaopeng.bughunter.bean;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
@Table(name = "t_error_info_2")
/* loaded from: classes.dex */
public class ErrorInfoBean2 extends Model {
    @Column(name = "count")
    private long count;
    @Column(name = "type")
    private int errorType;
    @Column(name = "lastTime")
    private long lastTime;
    @Column(name = "md5")
    private String md5;
    @Column(name = "packageName")
    private String packageName;
    @Column(name = "reported")
    private boolean reported;
    @Column(name = "srcType")
    private int srcType;

    public ErrorInfoBean2() {
    }

    public long getCount() {
        return this.count;
    }

    public int getErrorType() {
        return this.errorType;
    }

    public long getLastTime() {
        return this.lastTime;
    }

    public String getMd5() {
        return this.md5;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public int getSrcType() {
        return this.srcType;
    }

    public boolean isReported() {
        return this.reported;
    }

    public void setCount(long j) {
        this.count = j;
    }

    public void setErrorType(int i) {
        this.errorType = i;
    }

    public void setLastTime(long j) {
        this.lastTime = j;
    }

    public void setMd5(String str) {
        this.md5 = str;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setReported(boolean z) {
        this.reported = z;
    }

    public void setSrcType(int i) {
        this.srcType = i;
    }

    public ErrorInfoBean2(String str, long j, String str2, int i, int i2, boolean z) {
        this.md5 = str;
        this.count = j;
        this.packageName = str2;
        this.errorType = i;
        this.srcType = i2;
        this.reported = z;
        this.lastTime = System.currentTimeMillis();
    }

    public ErrorInfoBean2(long j, String str, long j2, String str2, int i, int i2, boolean z) {
        this.md5 = str;
        this.count = j2;
        this.packageName = str2;
        this.errorType = i;
        this.srcType = i2;
        this.reported = z;
        this.lastTime = j;
    }
}
