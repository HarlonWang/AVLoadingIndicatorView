package com.wang.avi.indicators;

import android.graphics.Canvas;
import android.graphics.Paint;

import android.animation.ValueAnimator;
import com.wang.avi.Indicator;

import java.util.ArrayList;

/**
 * Created by Jack on 2015/10/16.
 */
public class BallGridPulseIndicator extends Indicator {

    public static final int ALPHA=255;

    public static final float SCALE=1.0f;

    int[] alphas=new int[]{ALPHA,
            ALPHA,
            ALPHA,
            ALPHA,
            ALPHA,
            ALPHA,
            ALPHA,
            ALPHA,
            ALPHA};

    float[] scaleFloats=new float[]{SCALE,
            SCALE,
            SCALE,
            SCALE,
            SCALE,
            SCALE,
            SCALE,
            SCALE,
            SCALE};



    @Override
    public void draw(Canvas canvas, Paint paint) {
        float circleSpacing=4;
        float radius=(getWidth()-circleSpacing*4)/6;
        float x = getWidth()/ 2-(radius*2+circleSpacing);
        float y = getWidth()/ 2-(radius*2+circleSpacing);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                canvas.save();
                float translateX=x+(radius*2)*j+circleSpacing*j;
                float translateY=y+(radius*2)*i+circleSpacing*i;
                canvas.translate(translateX, translateY);
                canvas.scale(scaleFloats[3 * i + j], scaleFloats[3 * i + j]);
                paint.setAlpha(alphas[3 * i + j]);
                canvas.drawCircle(0, 0, radius, paint);
                canvas.restore();
            }
        }
    }

    @Override
    public ArrayList<ValueAnimator> onCreateAnimators() {
        ArrayList<ValueAnimator> animators=new ArrayList<>();
        int[] durations={720, 1020, 1280, 1420, 1450, 1180, 870, 1450, 1060};
        int[] delays= {-60, 250, -170, 480, 310, 30, 460, 780, 450};

        for (int i = 0; i < 9; i++) {
            final int index=i;
            ValueAnimator scaleAnim=ValueAnimator.ofFloat(1,0.5f,1);
            scaleAnim.setDuration(durations[i]);
            scaleAnim.setRepeatCount(-1);
            scaleAnim.setStartDelay(delays[i]);
            addUpdateListener(scaleAnim,new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    scaleFloats[index] = (float) animation.getAnimatedValue();
                    postInvalidate();
                }
            });

            ValueAnimator alphaAnim=ValueAnimator.ofInt(255, 210, 122, 255);
            alphaAnim.setDuration(durations[i]);
            alphaAnim.setRepeatCount(-1);
            alphaAnim.setStartDelay(delays[i]);
            addUpdateListener(alphaAnim,new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    alphas[index] = (int) animation.getAnimatedValue();
                    postInvalidate();
                }
            });
            animators.add(scaleAnim);
            animators.add(alphaAnim);
        }
        return animators;
    }

}
