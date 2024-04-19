package com.xiaopeng.xui.widgets.dialog;

import android.content.Context;
import android.graphics.Rect;
import android.text.Layout;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes.dex */
public class XDialogContentTextView extends TextView {
    private Rect mRect;

    public XDialogContentTextView(Context context) {
        this(context, null);
    }

    public int getLastLineSpace() {
        int lineCount = getLineCount() - 1;
        if (lineCount < 0) {
            return 0;
        }
        Layout layout = getLayout();
        int lineBounds = getLineBounds(lineCount, this.mRect);
        if (getMeasuredHeight() != layout.getHeight()) {
            return 0;
        }
        return this.mRect.bottom - (lineBounds + layout.getPaint().getFontMetricsInt().descent);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight() - getLastLineSpace());
    }

    public XDialogContentTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XDialogContentTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRect = new Rect();
    }
}
