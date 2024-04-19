package com.xiaopeng.xui.anims;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.view.View;
import android.view.animation.Interpolator;
import com.xiaopeng.xui.interpolator.SpringInterpolator;
/* loaded from: classes.dex */
public class XAnimator {
    private final Animator[] animators;
    private long duration;
    private Interpolator interpolator;
    private AnimatorListenerAdapter mListenerAdapter;
    private final View target;

    /* loaded from: classes.dex */
    public static class Builder {
        private AnimatorListenerAdapter adapter;
        private Animator[] animators;
        private long duration;
        private Interpolator interpolator;
        private View target;

        public Builder addListener(AnimatorListenerAdapter animatorListenerAdapter) {
            this.adapter = animatorListenerAdapter;
            return this;
        }

        public Builder animators(Animator... animatorArr) {
            this.animators = animatorArr;
            return this;
        }

        public Builder duration(long j) {
            this.duration = j;
            return this;
        }

        public Builder interpolator(Interpolator interpolator) {
            this.interpolator = interpolator;
            return this;
        }

        public void start() {
            new XAnimator(this.target, this.animators, this.duration, this.interpolator, this.adapter).start();
        }

        public Builder target(View view) {
            this.target = view;
            return this;
        }
    }

    public XAnimator(View view, Animator[] animatorArr, long j, Interpolator interpolator, AnimatorListenerAdapter animatorListenerAdapter) {
        this.target = view;
        this.animators = animatorArr;
        this.duration = j;
        if (interpolator == null) {
            this.interpolator = new SpringInterpolator();
        } else {
            this.interpolator = interpolator;
        }
        this.mListenerAdapter = animatorListenerAdapter;
    }

    public void start() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setTarget(this.target);
        animatorSet.playTogether(this.animators);
        animatorSet.setDuration(this.duration);
        animatorSet.setInterpolator(this.interpolator);
        AnimatorListenerAdapter animatorListenerAdapter = this.mListenerAdapter;
        if (animatorListenerAdapter != null) {
            animatorSet.addListener(animatorListenerAdapter);
        }
        animatorSet.start();
    }
}
