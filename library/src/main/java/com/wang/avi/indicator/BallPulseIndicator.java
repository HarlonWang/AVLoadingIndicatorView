package com.wang.avi.indicator;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.nineoldandroids.animation.ValueAnimator;

/**
 * Created by Jack on 2015/10/16.
 */
public class BallPulseIndicator extends BaseIndicatorController{

    public static final float SCALE=1.0f;

    //scale x ,y
    private float[] scaleFloats=new float[]{SCALE,
            SCALE,
            SCALE};



    @Override
    public void draw(Canvas canvas, Paint paint) {
        float circleSpacing=4;
        float radius=(Math.min(getWidth(),getHeight())-circleSpacing*2)/6;
        float x = getWidth()/ 2-(radius*2+circleSpacing);
        float y=getHeight() / 2;
        for (int i = 0; i < 3; i++) {
            canvas.save();
            float translateX=x+(radius*2)*i+circleSpacing*i;
            canvas.translate(translateX, y);
            canvas.scale(scaleFloats[i], scaleFloats[i]);
            canvas.drawCircle(0, 0, radius, paint);
            canvas.restore();
        }
    }

    @Override
    public void createAnimation() {
        int[] delays=new int[]{120,240,360};
        for (int i = 0; i < 3; i++) {
            final int index=i;

/*            Keyframe k1=Keyframe.ofFloat(0,1);
            *//*k1.setInterpolator(new CubicBezierInterpolator(0.2, 0.68,0.18, 1.08));*//*
            k1.setInterpolator(new LinearInterpolator());
            *//*k1.setInterpolator(PathInterpolatorCompat.create(0.2f, 0.68f, 0.18f, 1.08f));*//*
            Keyframe k2=Keyframe.ofFloat(0.3f,0.3f);
            *//*k2.setInterpolator(PathInterpolatorCompat.create(0.2f, 0.68f,0.18f, 1.08f));*//*
            k2.setInterpolator(new LinearInterpolator());
            Keyframe k3=Keyframe.ofFloat(1, 1);
            PropertyValuesHolder holder=PropertyValuesHolder.ofKeyframe("scale", k1, k2, k3);
            ValueAnimator scaleAnim=ValueAnimator.ofPropertyValuesHolder(holder);*/

            ValueAnimator scaleAnim=ValueAnimator.ofFloat(1,0.3f,1);
            scaleAnim.setDuration(750);
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
        }
    }

}
