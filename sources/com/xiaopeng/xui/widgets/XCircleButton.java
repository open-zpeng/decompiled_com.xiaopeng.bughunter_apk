package com.xiaopeng.xui.widgets;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.xiaopeng.xui.R;
import com.xiaopeng.xui.interpolator.SpringInterpolator;
/* loaded from: classes.dex */
public class XCircleButton extends XButton {
    private static final int SPRING_SPRING = 1;
    private static final int SPRING_ZOOM_IN = 2;
    private static final int SPRING_ZOOM_OUT = 3;
    private ValueAnimator mAnimator;
    private ValueAnimator.AnimatorUpdateListener mAnimatorUpdateListener;
    private float mScale;
    private final int mSpring;

    public XCircleButton(Context context) {
        this(context, null);
    }

    @Override // com.xiaopeng.xui.widgets.XButton
    protected void onDrawBackground(Canvas canvas) {
        Drawable originalBackground = getOriginalBackground();
        if (originalBackground != null) {
            int width = canvas.getWidth();
            int height = canvas.getHeight();
            float f = this.mScale;
            int i = (int) (width * f);
            int i2 = (int) (f * height);
            int i3 = (width - i) / 2;
            int i4 = (height - i2) / 2;
            originalBackground.setBounds(new Rect(i3, i4, i + i3, i2 + i4));
            originalBackground.setState(getDrawableState());
            originalBackground.draw(canvas);
        }
    }

    @Override // com.xiaopeng.xui.widgets.XButton
    public void onPreJudgeInitialize() {
        if (getStartScale() == getEndScale()) {
            int i = this.mSpring;
            if (i == 1) {
                setDuration(350);
                setStartScale(1.0f);
                setEndScale(2.0f);
            } else if (i == 2) {
                setDuration(200);
                setStartScale(1.0f);
                setEndScale(1.2f);
            } else if (i == 3) {
                setDuration(200);
                setStartScale(1.0f);
                setEndScale(0.8f);
            } else {
                setDuration(350);
                setStartScale(0.5f);
                setEndScale(0.9f);
            }
        }
        this.mScale = getStartScale();
    }

    @Override // com.xiaopeng.xui.widgets.XButton
    protected void onPressDown() {
        stop();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(getStartScale(), getEndScale());
        this.mAnimator = ofFloat;
        ofFloat.setDuration(getDuration());
        this.mAnimator.setInterpolator(new SpringInterpolator());
        this.mAnimator.addUpdateListener(this.mAnimatorUpdateListener);
        this.mAnimator.start();
    }

    @Override // com.xiaopeng.xui.widgets.XButton
    protected void onPressUp() {
        stop();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(getEndScale(), getStartScale());
        this.mAnimator = ofFloat;
        ofFloat.setDuration(getDuration());
        this.mAnimator.setInterpolator(new SpringInterpolator());
        this.mAnimator.addUpdateListener(this.mAnimatorUpdateListener);
        this.mAnimator.start();
    }

    public void stop() {
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator != null) {
            valueAnimator.removeUpdateListener(this.mAnimatorUpdateListener);
            this.mAnimator.end();
            this.mAnimator = null;
        }
    }

    @Override // com.xiaopeng.xui.widgets.XButton
    protected boolean useReplacedBackground() {
        return true;
    }

    public XCircleButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XCircleButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mAnimatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.xiaopeng.xui.widgets.XCircleButton.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                XCircleButton.this.mScale = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                XCircleButton.this.invalidate();
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Xui_Common);
        this.mSpring = obtainStyledAttributes.getInt(R.styleable.Xui_Common_xui_spring, 1);
        obtainStyledAttributes.recycle();
    }
}
