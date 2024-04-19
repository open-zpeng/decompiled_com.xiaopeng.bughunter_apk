package com.xiaopeng.xui.drawable;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import com.xiaopeng.xui.interpolator.SpringInterpolator;
import com.xiaopeng.xui.utils.UIUtils;
/* loaded from: classes.dex */
public class XSpringCircleDrawable extends XGradientDrawable implements Animatable {
    private static final int TYPE_CIRCLE = 1;
    private static final int TYPE_ROUND_CORNER = 2;
    private ValueAnimator mAnimator;
    private Rect mBounds;
    private final int mDisplayType;
    private long mDuration;
    private final float mEnd;
    private final Paint mPaint;
    private float mRadius;
    private float mScale;
    private final float mStart;
    private boolean isSpring = true;
    private ValueAnimator.AnimatorUpdateListener mAnimatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.xiaopeng.xui.drawable.XSpringCircleDrawable.1
        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            XSpringCircleDrawable.this.mScale = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            XSpringCircleDrawable.this.invalidateSelf();
        }
    };

    public XSpringCircleDrawable(int i, float f, long j, float f2, float f3) {
        this.mDuration = 0L;
        this.mRadius = f;
        this.mDuration = j;
        this.mStart = f2;
        this.mEnd = f3;
        this.mScale = f2;
        this.mDisplayType = i;
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
    }

    private Rect getRealBounds() {
        if (this.mBounds == null) {
            Rect bounds = getBounds();
            Rect rect = new Rect(getPaddingLeft(), getPaddingTop(), bounds.width() - getPaddingRight(), bounds.height() - getPaddingBottom());
            this.mBounds = rect;
            setBounds(rect);
        }
        return this.mBounds;
    }

    @Override // com.xiaopeng.xui.drawable.XGradientDrawable, android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        canvas.save();
        Rect realBounds = getRealBounds();
        float f = this.mRadius;
        float min = (f == 0.0f ? Math.min(realBounds.width(), realBounds.height()) / 2 : UIUtils.dip2px(f)) * this.mScale;
        this.mPaint.setColor(getCurrentStateColor());
        int i = this.mDisplayType;
        if (i == 1) {
            int width = 0 - ((int) ((canvas.getWidth() * (this.mScale - 1.0f)) / 2.0f));
            int height = 0 - ((int) ((canvas.getHeight() * (this.mScale - 1.0f)) / 2.0f));
            int centerX = realBounds.centerX() - width;
            int centerY = realBounds.centerY() - height;
            canvas.translate(width, height);
            canvas.drawCircle(centerX, centerY, min, this.mPaint);
        } else if (i == 2) {
            float width2 = (realBounds.width() * this.mScale) / 2.0f;
            float height2 = (realBounds.height() * this.mScale) / 2.0f;
            canvas.drawRoundRect(new RectF(realBounds.centerX() - width2, realBounds.centerY() - height2, realBounds.centerX() + width2, realBounds.centerY() + height2), min, min, this.mPaint);
        }
        canvas.restore();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator != null) {
            valueAnimator.isRunning();
            return false;
        }
        return false;
    }

    public void setSpring(boolean z) {
        this.isSpring = z;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (isRunning()) {
            return;
        }
        ValueAnimator ofFloat = this.isSpring ? ValueAnimator.ofFloat(this.mStart, this.mEnd) : ValueAnimator.ofFloat(this.mEnd, this.mStart);
        this.mAnimator = ofFloat;
        ofFloat.setDuration(this.mDuration);
        this.mAnimator.setInterpolator(new SpringInterpolator());
        this.mAnimator.addUpdateListener(this.mAnimatorUpdateListener);
        this.mAnimator.start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator != null) {
            valueAnimator.removeUpdateListener(this.mAnimatorUpdateListener);
            this.mAnimator.end();
        }
    }
}
