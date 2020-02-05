package com.omega.animatedtext;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

public class AnimatedTextView extends AppCompatTextView {

    private float mStrokeScale = 0.0f;
    private float mItalicSkew = 0.0f;
    private float mOffset = 0.0f;
    private ValueAnimator mStrokeAnimator;
    private ValueAnimator mSkewAnimator;

    public AnimatedTextView(Context context) {
        this(context, null);
    }

    public AnimatedTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AnimatedTextView(Context context, AttributeSet attributeSet, int defStyleAttributes) {
        super(context, attributeSet, defStyleAttributes);

    }

    public float getStrokeScale() {
        return mStrokeScale;
    }

    public void setStrokeScale(float strokeScale) {
        mStrokeScale = strokeScale;
        invalidate();
    }

    public float getItalicSkew() {
        return mItalicSkew;
    }

    public void setItalicSkew(float italicSkew) {
        mItalicSkew = italicSkew;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.skew(-mItalicSkew, 0.0f);
        canvas.translate(mOffset, 0.0f);
        Paint p = getPaint();
        p.setStyle(Paint.Style.FILL_AND_STROKE);
        p.setStrokeWidth(mStrokeScale * getTextSize());
        super.onDraw(canvas);
    }

    public Animator createStrokeAnimator(float targetStrokeScale) {
        return createStrokeAnimator(targetStrokeScale, true);
    }

    public Animator createStrokeAnimator(float targetStrokeScale, boolean shouldEndExisting) {
        if (shouldEndExisting) endAnimation(mStrokeAnimator);
        mStrokeAnimator = ValueAnimator.ofFloat(mStrokeScale, targetStrokeScale);
        mStrokeAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                mStrokeScale = (float)valueAnimator.getAnimatedValue();
                if (mStrokeScale > 0) invalidate();
            }
        });
        return mStrokeAnimator;
    }

    public Animator createItalicAnimator(float targetSkew) {
        return createItalicAnimator(targetSkew, true);
    }

    public Animator createItalicAnimator(float targetSkew, boolean shouldEndExisting) {
        if (shouldEndExisting) endAnimation(mSkewAnimator);
        mSkewAnimator = ValueAnimator.ofFloat(mItalicSkew, targetSkew);
        mSkewAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                mItalicSkew = (float)valueAnimator.getAnimatedValue();
                calcOffset();
                if (mItalicSkew > 0) invalidate();
            }
        });
        return mSkewAnimator;
    }


    private void calcOffset() {
        mOffset = getTextSize() * (float)Math.tan(mItalicSkew);
    }

    private void endAnimation(ValueAnimator animator) {
        if (animator != null && animator.isRunning()) {
            animator.removeAllUpdateListeners();
            animator.cancel();
        }
    }
}
