package com.xiaopeng.xui.widgets.popup;

import android.view.View;
/* loaded from: classes.dex */
class Coordinates {
    int bottom;
    int left;
    int right;
    int top;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Coordinates(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = iArr[0];
        this.left = i;
        this.right = i + view.getWidth();
        int i2 = iArr[1];
        this.top = i2;
        this.bottom = i2 + view.getHeight();
    }
}
