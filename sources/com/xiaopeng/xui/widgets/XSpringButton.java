package com.xiaopeng.xui.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.xiaopeng.xui.R;
import com.xiaopeng.xui.drawable.XDrawableFactory;
import com.xiaopeng.xui.drawable.XSpringCircleDrawable;
@Deprecated
/* loaded from: classes.dex */
public final class XSpringButton extends XButton {
    private static final int SPRING_SPRING = 1;
    private static final int SPRING_ZOOM_IN = 2;
    private static final int SPRING_ZOOM_OUT = 3;
    private final int mDisplayType;
    private final int mSpring;

    public XSpringButton(Context context) {
        this(context, null, 0);
    }

    @Override // com.xiaopeng.xui.widgets.XButton
    protected Drawable newBackground() {
        XSpringCircleDrawable xSpringCircleDrawable = (XSpringCircleDrawable) XDrawableFactory.createAnimatedCircleDrawable(this.mDisplayType, getRadius(), getBackgroundColor(), getDuration(), getStrokeColor(), getStrokeWidth(), getStartScale(), getEndScale());
        xSpringCircleDrawable.setPadding(getBackgroundDrawablePaddingLeft(), getBackgroundDrawablePaddingTop(), getBackgroundDrawablePaddingRight(), getBackgroundDrawablePaddingBottom());
        return xSpringCircleDrawable;
    }

    @Override // com.xiaopeng.xui.widgets.XButton
    public void onPreJudgeInitialize() {
        if (getStartScale() == getEndScale()) {
            int i = this.mSpring;
            if (i == 1) {
                setDuration(350);
                setStartScale(1.0f);
                setEndScale(1.8f);
            } else if (i == 2) {
                setDuration(200);
                setStartScale(1.0f);
                setEndScale(1.2f);
            } else if (i == 3) {
                setDuration(200);
                setStartScale(1.0f);
                setEndScale(0.8f);
            }
        }
    }

    @Override // com.xiaopeng.xui.widgets.XButton
    protected void onPressDown() {
        XSpringCircleDrawable xSpringCircleDrawable = (XSpringCircleDrawable) getBackground();
        xSpringCircleDrawable.setSpring(true);
        xSpringCircleDrawable.start();
    }

    @Override // com.xiaopeng.xui.widgets.XButton
    protected void onPressUp() {
        XSpringCircleDrawable xSpringCircleDrawable = (XSpringCircleDrawable) getBackground();
        xSpringCircleDrawable.setSpring(false);
        xSpringCircleDrawable.start();
    }

    public XSpringButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XSpringButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Xui_Common);
        this.mDisplayType = obtainStyledAttributes.getInt(R.styleable.Xui_Common_xui_display, 2);
        this.mSpring = obtainStyledAttributes.getInt(R.styleable.Xui_Common_xui_spring, 1);
        obtainStyledAttributes.recycle();
    }
}
