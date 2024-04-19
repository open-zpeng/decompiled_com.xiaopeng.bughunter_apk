package com.xiaopeng.xui.widgets.popup;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;
import com.xiaopeng.xui.interpolator.EaseCubicInterpolator;
import com.xiaopeng.xui.interpolator.SpringInterpolator;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
class DefaultXPopupAnimator implements XPopupAnimator {
    private Map<View, Animator> mAnimaOutMap = new HashMap();

    @Override // com.xiaopeng.xui.widgets.popup.XPopupAnimator
    public void breakAnimator(View view) {
        if (this.mAnimaOutMap.containsKey(view)) {
            Animator animator = this.mAnimaOutMap.get(view);
            animator.removeAllListeners();
            animator.cancel();
            this.mAnimaOutMap.remove(view);
        }
    }

    @Override // com.xiaopeng.xui.widgets.popup.XPopupAnimator
    public void popout(final View view, final AnimatorListenerAdapter animatorListenerAdapter) {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.5f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.5f));
        ofPropertyValuesHolder.setDuration(1000L);
        ofPropertyValuesHolder.setInterpolator(new SpringInterpolator());
        ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("alpha", 1.0f, 0.0f));
        ofPropertyValuesHolder2.setDuration(150L);
        ofPropertyValuesHolder2.setInterpolator(new EaseCubicInterpolator(0.2f, 0.0f, 0.2f, 1.0f));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.xiaopeng.xui.widgets.popup.DefaultXPopupAnimator.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                view.setVisibility(8);
                if (DefaultXPopupAnimator.this.mAnimaOutMap.containsKey(view)) {
                    DefaultXPopupAnimator.this.mAnimaOutMap.remove(view);
                }
                AnimatorListenerAdapter animatorListenerAdapter2 = animatorListenerAdapter;
                if (animatorListenerAdapter2 != null) {
                    animatorListenerAdapter2.onAnimationEnd(animator);
                }
            }
        });
        animatorSet.playTogether(ofPropertyValuesHolder, ofPropertyValuesHolder2);
        animatorSet.start();
        this.mAnimaOutMap.put(view, animatorSet);
    }

    @Override // com.xiaopeng.xui.widgets.popup.XPopupAnimator
    public void popup(View view) {
        view.setAlpha(0.0f);
        view.setVisibility(0);
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("scaleX", 0.5f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.5f, 1.0f));
        ofPropertyValuesHolder.setDuration(1000L);
        ofPropertyValuesHolder.setInterpolator(new SpringInterpolator());
        ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f));
        ofPropertyValuesHolder2.setDuration(200L);
        ofPropertyValuesHolder2.setInterpolator(new EaseCubicInterpolator(0.2f, 0.0f, 0.2f, 1.0f));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofPropertyValuesHolder, ofPropertyValuesHolder2);
        animatorSet.start();
    }
}
