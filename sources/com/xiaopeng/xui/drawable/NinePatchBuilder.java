package com.xiaopeng.xui.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.NinePatch;
import android.graphics.drawable.NinePatchDrawable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class NinePatchBuilder {
    Bitmap bitmap;
    int height;
    Resources resources;
    int width;
    private ArrayList<Integer> xRegions = new ArrayList<>();
    private ArrayList<Integer> yRegions = new ArrayList<>();

    public NinePatchBuilder(Resources resources, Bitmap bitmap) {
        this.width = bitmap.getWidth();
        this.height = bitmap.getHeight();
        this.bitmap = bitmap;
        this.resources = resources;
    }

    public NinePatchBuilder addXCenteredRegion(int i) {
        int i2 = (this.width - i) / 2;
        this.xRegions.add(Integer.valueOf(i2));
        this.xRegions.add(Integer.valueOf(i2 + i));
        return this;
    }

    public NinePatchBuilder addXRegion(int i, int i2) {
        this.xRegions.add(Integer.valueOf(i));
        this.xRegions.add(Integer.valueOf(i + i2));
        return this;
    }

    public NinePatchBuilder addXRegionPoints(int i, int i2) {
        this.xRegions.add(Integer.valueOf(i));
        this.xRegions.add(Integer.valueOf(i2));
        return this;
    }

    public NinePatchBuilder addYCenteredRegion(int i) {
        int i2 = (this.height - i) / 2;
        this.yRegions.add(Integer.valueOf(i2));
        this.yRegions.add(Integer.valueOf(i2 + i));
        return this;
    }

    public NinePatchBuilder addYRegion(int i, int i2) {
        this.yRegions.add(Integer.valueOf(i));
        this.yRegions.add(Integer.valueOf(i + i2));
        return this;
    }

    public NinePatchBuilder addYRegionPoints(int i, int i2) {
        this.yRegions.add(Integer.valueOf(i));
        this.yRegions.add(Integer.valueOf(i2));
        return this;
    }

    public NinePatchDrawable build() {
        NinePatch buildNinePatch = buildNinePatch();
        if (buildNinePatch != null) {
            return new NinePatchDrawable(this.resources, buildNinePatch);
        }
        return null;
    }

    public byte[] buildChunk() {
        if (this.xRegions.size() == 0) {
            this.xRegions.add(0);
            this.xRegions.add(Integer.valueOf(this.width));
        }
        if (this.yRegions.size() == 0) {
            this.yRegions.add(0);
            this.yRegions.add(Integer.valueOf(this.height));
        }
        ByteBuffer order = ByteBuffer.allocate((this.xRegions.size() + 8 + this.yRegions.size() + 9) * 4).order(ByteOrder.nativeOrder());
        order.put((byte) 1);
        order.put((byte) this.xRegions.size());
        order.put((byte) this.yRegions.size());
        order.put((byte) 9);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        Iterator<Integer> it = this.xRegions.iterator();
        while (it.hasNext()) {
            order.putInt(it.next().intValue());
        }
        Iterator<Integer> it2 = this.yRegions.iterator();
        while (it2.hasNext()) {
            order.putInt(it2.next().intValue());
        }
        for (int i = 0; i < 9; i++) {
            order.putInt(1);
        }
        return order.array();
    }

    public NinePatch buildNinePatch() {
        byte[] buildChunk = buildChunk();
        Bitmap bitmap = this.bitmap;
        if (bitmap != null) {
            return new NinePatch(bitmap, buildChunk, null);
        }
        return null;
    }

    public NinePatchBuilder addXRegion(float f, float f2) {
        int i = (int) (f * this.width);
        this.xRegions.add(Integer.valueOf(i));
        this.xRegions.add(Integer.valueOf(i + ((int) (f2 * this.width))));
        return this;
    }

    public NinePatchBuilder addXRegionPoints(float f, float f2) {
        this.xRegions.add(Integer.valueOf((int) (f * this.width)));
        this.xRegions.add(Integer.valueOf((int) (f2 * this.width)));
        return this;
    }

    public NinePatchBuilder addYRegion(float f, float f2) {
        int i = (int) (f * this.height);
        this.yRegions.add(Integer.valueOf(i));
        this.yRegions.add(Integer.valueOf(i + ((int) (f2 * this.height))));
        return this;
    }

    public NinePatchBuilder addYRegionPoints(float f, float f2) {
        this.yRegions.add(Integer.valueOf((int) (f * this.height)));
        this.yRegions.add(Integer.valueOf((int) (f2 * this.height)));
        return this;
    }

    public NinePatchBuilder addXCenteredRegion(float f) {
        int i = this.width;
        int i2 = (int) (f * i);
        int i3 = (i - i2) / 2;
        this.xRegions.add(Integer.valueOf(i3));
        this.xRegions.add(Integer.valueOf(i3 + i2));
        return this;
    }

    public NinePatchBuilder addYCenteredRegion(float f) {
        int i = this.height;
        int i2 = (int) (f * i);
        int i3 = (i - i2) / 2;
        this.yRegions.add(Integer.valueOf(i3));
        this.yRegions.add(Integer.valueOf(i3 + i2));
        return this;
    }

    public NinePatchBuilder(int i, int i2) {
        this.width = i;
        this.height = i2;
    }
}
