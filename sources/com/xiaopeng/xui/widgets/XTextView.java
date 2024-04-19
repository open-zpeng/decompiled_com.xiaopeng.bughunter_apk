package com.xiaopeng.xui.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;
import com.xiaopeng.xui.R;
import com.xiaopeng.xui.font.XFontHelper;
import com.xiaopeng.xui.utils.L;
/* loaded from: classes.dex */
public class XTextView extends TextView {
    private static final String TAG = "XTextView";
    private Paint mBaseLinePaint;
    private final boolean mShowGuideLine;

    public XTextView(Context context) {
        this(context, null, 0);
    }

    private void applyTypeface() {
        setTypeface(XFontHelper.getAssetsTypeface(getContext(), "xpnumber.ttf"));
    }

    private Paint getBaseLinePaint() {
        if (this.mBaseLinePaint == null) {
            Paint paint = new Paint();
            this.mBaseLinePaint = paint;
            paint.setColor(-65536);
        }
        return this.mBaseLinePaint;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mShowGuideLine) {
            Paint.FontMetricsInt fontMetricsInt = getPaint().getFontMetricsInt();
            canvas.drawLine(0.0f, getBaseline() + fontMetricsInt.bottom, getRight(), getBaseline() + fontMetricsInt.bottom, getPaint());
            canvas.drawLine(0.0f, getBaseline() + fontMetricsInt.top, getRight(), getBaseline() + fontMetricsInt.top, getPaint());
            canvas.drawLine(0.0f, getBaseline(), getRight(), getBaseline(), getBaseLinePaint());
            L.e(TAG, "font \nbottom:" + getPaint().getFontMetricsInt().bottom + " \ndescent:" + getPaint().getFontMetricsInt().descent + " \nascent:" + getPaint().getFontMetricsInt().ascent + " \ntop:" + getPaint().getFontMetricsInt().top + " \nheight:" + getHeight() + " \nscaleX:" + getTextScaleX() + " \nsize:" + getTextSize() + " \nbaseline:" + getBaseline());
        }
    }

    public XTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mShowGuideLine = context.obtainStyledAttributes(attributeSet, R.styleable.Xui_Common).getBoolean(R.styleable.Xui_Common_xui_showGuideLine, false);
        applyTypeface();
    }
}
