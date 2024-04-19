package com.xiaopeng.bughunter.bean;
/* loaded from: classes.dex */
public class DevInfo {
    private float innerStorageAllocated;
    private float innerStorageSize;
    private long memoryAllAllocated;
    private long memoryAllocated;
    private boolean networkState;
    private int networkType;
    private float sdcardStorageAllocated;
    private float sdcardStorageSize;
    private int sysCpu;
    private long systemMemory;
    private int userCpu;

    public float getInnerStorageAllocated() {
        return this.innerStorageAllocated;
    }

    public float getInnerStorageSize() {
        return this.innerStorageSize;
    }

    public long getMemoryAllAllocated() {
        return this.memoryAllAllocated;
    }

    public float getMemoryAllocated() {
        return (float) this.memoryAllocated;
    }

    public int getNetworkType() {
        return this.networkType;
    }

    public float getSdcardStorageAllocated() {
        return this.sdcardStorageAllocated;
    }

    public float getSdcardStorageSize() {
        return this.sdcardStorageSize;
    }

    public int getSysCpu() {
        return this.sysCpu;
    }

    public long getSystemMemory() {
        return this.systemMemory;
    }

    public int getUserCpu() {
        return this.userCpu;
    }

    public boolean isNetworkState() {
        return this.networkState;
    }

    public void setInnerStorageAllocated(float f) {
        this.innerStorageAllocated = f;
    }

    public void setInnerStorageSize(float f) {
        this.innerStorageSize = f;
    }

    public void setMemoryAllAllocated(long j) {
        this.memoryAllAllocated = j;
    }

    public void setMemoryAllocated(long j) {
        this.memoryAllocated = j;
    }

    public void setNetworkState(boolean z) {
        this.networkState = z;
    }

    public void setNetworkType(int i) {
        this.networkType = i;
    }

    public void setSdcardStorageAllocated(float f) {
        this.sdcardStorageAllocated = f;
    }

    public void setSdcardStorageSize(float f) {
        this.sdcardStorageSize = f;
    }

    public void setSysCpu(int i) {
        this.sysCpu = i;
    }

    public void setSystemMemory(long j) {
        this.systemMemory = j;
    }

    public void setUserCpu(int i) {
        this.userCpu = i;
    }

    public String toString() {
        return "networkType=" + this.networkType + "#, networkState=" + this.networkState + "#, memoryAllocated=" + this.memoryAllocated + "#, memoryAllAllocated=" + this.memoryAllAllocated + "#, systemMemory=" + this.systemMemory + "#, userCpu=" + this.userCpu + "#, sysCpu=" + this.sysCpu + "#, innerStorageAllocated=" + this.innerStorageAllocated + "#, innerStorageSize=" + this.innerStorageSize + "#, sdcardStorageAllocated=" + this.sdcardStorageAllocated + "#, sdcardStorageSize=" + this.sdcardStorageSize;
    }
}
