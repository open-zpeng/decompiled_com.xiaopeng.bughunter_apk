package com.xiaopeng.xui.widgets;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.xiaopeng.xui.R;
import com.xiaopeng.xui.theme.ThemeWatcher;
import com.xiaopeng.xui.utils.UIUtils;
/* loaded from: classes.dex */
public class XLoadingBar extends View implements ThemeWatcher.OnThemeSwitchListener {
    private AnimTask mAnimTask;
    private ValueAnimator mAnimator;
    private long mDuration;
    private int mIndeterminateDrawableDay;
    private int mIndeterminateDrawableNight;
    private Drawable mInnerDrawable;
    private Drawable mInnerDrawableDay;
    private Drawable mInnerDrawableNight;
    private int mInnerResDay;
    private int mInnerResNight;
    private boolean mIsLoading;
    private Bitmap mLoading;
    private Bitmap mLoadingDay;
    private Bitmap mLoadingNight;
    private int mOriginalSize;
    private Paint mPaint;
    private float mRotateAngle;
    private float mScale;
    private boolean mShowInnerImg;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class AnimTask implements Runnable {
        private ValueAnimator mAnimation;

        private AnimTask() {
        }

        @Override // java.lang.Runnable
        public void run() {
            XLoadingBar.this.mRotateAngle = ((Float) this.mAnimation.getAnimatedValue()).floatValue();
            XLoadingBar.this.postInvalidate();
        }

        public void setAngle(ValueAnimator valueAnimator) {
            this.mAnimation = valueAnimator;
        }
    }

    public XLoadingBar(Context context) {
        this(context, null);
    }

    private void init() {
        this.mPaint = new Paint(1);
        setIsNight();
        startRotateAnim();
    }

    private void startRotateAnim() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 360.0f);
        this.mAnimator = ofFloat;
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.xiaopeng.xui.widgets.XLoadingBar.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                XLoadingBar.this.mAnimTask.setAngle(valueAnimator);
                ag.i(XLoadingBar.this.mAnimTask);
            }
        });
        this.mAnimator.setInterpolator(new LinearInterpolator());
        this.mAnimator.setRepeatCount(-1);
        this.mAnimator.setDuration(this.mDuration);
        this.mAnimator.start();
        this.mIsLoading = true;
    }

    public void hideLoading() {
        hideLoading(true);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ThemeWatcher.getInstance().addThemeSwitchListener(this);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ThemeWatcher.getInstance().removeThemeListener(this);
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.mAnimator.removeAllUpdateListeners();
        }
        this.mIsLoading = false;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (getVisibility() == 0) {
            canvas.save();
            canvas.rotate(this.mRotateAngle, getWidth() / 2, getHeight() / 2);
            float f = this.mScale;
            canvas.scale(f, f);
            canvas.drawBitmap(this.mLoading, 0.0f, 0.0f, this.mPaint);
            canvas.restore();
            if (this.mShowInnerImg) {
                canvas.save();
                float f2 = this.mScale;
                canvas.scale(f2, f2, getWidth() / 2, getHeight() / 2);
                this.mInnerDrawable.draw(canvas);
                canvas.restore();
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i2);
        if (View.MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            size = this.mLoading.getWidth();
        }
        if (mode == Integer.MIN_VALUE) {
            size2 = this.mLoading.getHeight();
        }
        this.mScale = (Math.max(size, size2) * 1.0f) / this.mOriginalSize;
        setMeasuredDimension(size, size2);
        if (!this.mShowInnerImg || this.mInnerDrawable == null) {
            return;
        }
        int measuredWidth = (getMeasuredWidth() - this.mInnerDrawable.getIntrinsicWidth()) / 2;
        int measuredHeight = (getMeasuredHeight() - this.mInnerDrawable.getIntrinsicHeight()) / 2;
        this.mInnerDrawable.setBounds(measuredWidth, measuredHeight, this.mInnerDrawable.getIntrinsicWidth() + measuredWidth, this.mInnerDrawable.getIntrinsicHeight() + measuredHeight);
    }

    @Override // com.xiaopeng.xui.theme.ThemeWatcher.OnThemeSwitchListener
    public void onSwitchTheme(int i) {
        setIsNight();
        if (this.mShowInnerImg) {
            requestLayout();
        }
    }

    public void setDuration(long j) {
        this.mDuration = j;
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        startRotateAnim();
    }

    public void setIsNight() {
        if (ThemeWatcher.getInstance().isNight()) {
            if (this.mLoadingNight == null) {
                this.mLoadingNight = BitmapFactory.decodeResource(getResources(), this.mIndeterminateDrawableNight);
            }
            if (this.mInnerDrawableNight == null) {
                this.mInnerDrawableNight = UIUtils.getDrawable(this.mInnerResNight);
            }
            this.mLoading = this.mLoadingNight;
            this.mInnerDrawable = this.mInnerDrawableNight;
        } else {
            if (this.mLoadingDay == null) {
                this.mLoadingDay = BitmapFactory.decodeResource(getResources(), this.mIndeterminateDrawableDay);
            }
            if (this.mInnerDrawableDay == null) {
                this.mInnerDrawableDay = UIUtils.getDrawable(this.mInnerResDay);
            }
            this.mLoading = this.mLoadingDay;
            this.mInnerDrawable = this.mInnerDrawableDay;
        }
        this.mOriginalSize = Math.max(this.mLoading.getWidth(), this.mLoading.getHeight());
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            showLoading(false);
        } else {
            hideLoading(false);
        }
    }

    public void showInnerImage(boolean z) {
        this.mShowInnerImg = z;
    }

    public void showLoading() {
        showLoading(true);
    }

    public XLoadingBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void hideLoading(boolean z) {
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.mAnimator.removeAllUpdateListeners();
        }
        if (z) {
            super.setVisibility(8);
        }
        this.mIsLoading = false;
        ag.n(this.mAnimTask);
    }

    private void showLoading(boolean z) {
        if (this.mIsLoading) {
            return;
        }
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.mAnimator.removeAllUpdateListeners();
        }
        startRotateAnim();
        if (z) {
            super.setVisibility(0);
        }
    }

    public XLoadingBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDuration = 1500L;
        this.mScale = 1.0f;
        this.mAnimTask = new AnimTask();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.XLoadingBar);
        this.mIndeterminateDrawableDay = obtainStyledAttributes.getResourceId(R.styleable.XLoadingBar_xui_indeterminateDrawable_day, R.mipmap.xloading_day);
        this.mIndeterminateDrawableNight = obtainStyledAttributes.getResourceId(R.styleable.XLoadingBar_xui_indeterminateDrawable_night, R.mipmap.xloading_night);
        this.mInnerResDay = obtainStyledAttributes.getResourceId(R.styleable.XLoadingBar_xui_inner_img_day, R.mipmap.xloading_inner_img_day);
        this.mInnerResNight = obtainStyledAttributes.getResourceId(R.styleable.XLoadingBar_xui_inner_img_night, R.mipmap.xloading_inner_img_night);
        this.mShowInnerImg = obtainStyledAttributes.getBoolean(R.styleable.XLoadingBar_xui_show_inner, false);
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R.styleable.Xui_Common);
        this.mDuration = obtainStyledAttributes2.getInteger(R.styleable.Xui_Common_xui_duration, 1500);
        obtainStyledAttributes2.recycle();
        init();
    }
}
