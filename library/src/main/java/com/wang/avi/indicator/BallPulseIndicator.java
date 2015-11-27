package com.wang.avi.indicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.ValueAnimator;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jack on 2015/10/16.
 */
public class BallPulseIndicator extends BaseIndicatorController {

    public static final float SCALE = 1.0f;
    private static final int BASE_DELAY_MILLIS = 120;

    //scale x ,y
    private final float[] scaleFloats;
    private final int[] delays;
    private final int mCircleNumber;
    private final int mCircleSpace;

    public BallPulseIndicator(int circleNumber, int circleSpace) {
        mCircleNumber = circleNumber;
        mCircleSpace = circleSpace;
        scaleFloats = new float[mCircleNumber];
        for (int i = 0; i < mCircleNumber; i++) {
            scaleFloats[i] = SCALE;
        }
        delays = new int[mCircleNumber];
        for (int i = 0; i < mCircleNumber; i++) {
            delays[i] = BASE_DELAY_MILLIS * (i + 1);
        }
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        float radius = (getWidth() - mCircleSpace * (mCircleNumber - 1)) / (mCircleNumber * 2);
        // locate to the first circle's center point
        float x = getWidth() / 2 - (radius + mCircleSpace / 2) * (mCircleNumber - 1);
        float y = getHeight() / 2;
        for (int i = 0; i < mCircleNumber; i++) {
            canvas.save();
            float translateX = x + (radius * 2 + mCircleSpace) * i;
            canvas.translate(translateX, y);
            canvas.scale(scaleFloats[i], scaleFloats[i]);
            canvas.drawCircle(0, 0, radius, paint);
            canvas.restore();
        }
    }

    @Override
    public List<Animator> createAnimation() {
        List<Animator> animators = new ArrayList<>();
        for (int i = 0; i < mCircleNumber; i++) {
            final int index = i;

            ValueAnimator scaleAnim = ValueAnimator.ofFloat(1, 0.3f, 1);

            scaleAnim.setDuration(BASE_DELAY_MILLIS * mCircleNumber * 3 / 2);
            scaleAnim.setRepeatCount(-1);
            scaleAnim.setStartDelay(delays[i]);

            scaleAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    scaleFloats[index] = (float) animation.getAnimatedValue();
                    postInvalidate();
                }
            });
            scaleAnim.start();
            animators.add(scaleAnim);
        }
        return animators;
    }
}
