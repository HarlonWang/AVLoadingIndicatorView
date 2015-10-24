package com.wang.avi.indicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.OvershootInterpolator;

import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.animation.ValueAnimator;

/**
 * Created by Jack on 2015/10/17.
 */
public class BallRotateIndicator extends BaseIndicatorController{

    float scaleFloat=0.5f;


    @Override
    public void draw(Canvas canvas, Paint paint) {
        float radius=getWidth()/10;
        float x = getWidth()/ 2;
        float y=getHeight()/2;

        canvas.save();
        canvas.translate(x - radius * 2 - radius, y);
        canvas.scale(scaleFloat, scaleFloat);
        canvas.drawCircle(0, 0, radius, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(x, y);
        canvas.scale(scaleFloat, scaleFloat);
        canvas.drawCircle(0, 0, radius, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(x + radius * 2 + radius, y);
        canvas.scale(scaleFloat, scaleFloat);
        canvas.drawCircle(0,0,radius, paint);
        canvas.restore();
    }

    @Override
    public void createAnimation() {
        ValueAnimator scaleAnim=ValueAnimator.ofFloat(0.5f,1,0.5f);
        scaleAnim.setDuration(1000);
        scaleAnim.setRepeatCount(-1);
        scaleAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                scaleFloat = (float) animation.getAnimatedValue();
                postInvalidate();
            }
        });
        scaleAnim.start();

        ObjectAnimator rotateAnim=ObjectAnimator.ofFloat(getTarget(),"rotation",0,180,360);
        rotateAnim.setDuration(1000);
        rotateAnim.setRepeatCount(-1);
        rotateAnim.start();

    }


}
