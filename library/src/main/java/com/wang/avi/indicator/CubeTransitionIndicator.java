package com.wang.avi.indicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.animation.LinearInterpolator;

import com.nineoldandroids.animation.ValueAnimator;

/**
 * Created by Jack on 2015/10/18.
 */
public class CubeTransitionIndicator extends BaseIndicatorController {

    float[] translateX=new float[2],translateY=new float[2];
    float degrees,scaleFloat=1.0f;

    @Override
    public void draw(Canvas canvas, Paint paint) {
        float rWidth=getWidth()/5;
        float rHeight=getHeight()/5;
        for (int i = 0; i < 2; i++) {
            canvas.save();
            canvas.translate(translateX[i], translateY[i]);
            canvas.rotate(degrees);
            canvas.scale(scaleFloat,scaleFloat);
            RectF rectF=new RectF(-rWidth/2,-rHeight/2,rWidth/2,rHeight/2);
            canvas.drawRect(rectF,paint);
            canvas.restore();
        }
    }

    @Override
    public void createAnimation() {
        float startX=getWidth()/5;
        float startY=getHeight()/5;
        for (int i = 0; i < 2; i++) {
            final int index=i;
            translateX[index]=startX;
            ValueAnimator translationXAnim=ValueAnimator.ofFloat(startX,getWidth()-startX,getWidth()-startX, startX,startX);
            if (i==1){
                translationXAnim=ValueAnimator.ofFloat(getWidth()-startX,startX,startX, getWidth()-startX,getWidth()-startX);
            }
            translationXAnim.setInterpolator(new LinearInterpolator());
            translationXAnim.setDuration(1600);
            translationXAnim.setRepeatCount(-1);
            translationXAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    translateX[index] = (float) animation.getAnimatedValue();
                    postInvalidate();
                }
            });
            translationXAnim.start();
            translateY[index]=startY;
            ValueAnimator translationYAnim=ValueAnimator.ofFloat(startY,startY,getHeight()-startY,getHeight()- startY,startY);
            if (i==1){
                translationYAnim=ValueAnimator.ofFloat(getHeight()-startY,getHeight()-startY,startY,startY,getHeight()-startY);
            }
            translationYAnim.setDuration(1600);
            translationYAnim.setInterpolator(new LinearInterpolator());
            translationYAnim.setRepeatCount(-1);
            translationYAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    translateY[index] = (float) animation.getAnimatedValue();
                    postInvalidate();
                }
            });
            translationYAnim.start();
        }

        ValueAnimator scaleAnim=ValueAnimator.ofFloat(1,0.5f,1,0.5f,1);
        scaleAnim.setDuration(1600);
        scaleAnim.setInterpolator(new LinearInterpolator());
        scaleAnim.setRepeatCount(-1);
        scaleAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                scaleFloat = (float) animation.getAnimatedValue();
                postInvalidate();
            }
        });
        scaleAnim.start();

        ValueAnimator rotateAnim=ValueAnimator.ofFloat(0,180,360,1.5f*360,2*360);
        rotateAnim.setDuration(1600);
        rotateAnim.setInterpolator(new LinearInterpolator());
        rotateAnim.setRepeatCount(-1);
        rotateAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                degrees = (float) animation.getAnimatedValue();
                postInvalidate();
            }
        });
        rotateAnim.start();
    }
}
