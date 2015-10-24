package com.wang.avi.indicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.animation.LinearInterpolator;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.animation.PropertyValuesHolder;

/**
 * Created by Jack on 2015/10/16.
 */
public class SquareSpinIndicator extends BaseIndicatorController {

    @Override
    public void draw(Canvas canvas, Paint paint) {
        canvas.drawRect(new RectF(getWidth()/5,getHeight()/5,getWidth()*4/5,getHeight()*4/5),paint);

        /*Path path=new Path();
        path.moveTo(0,getHeight());
        path.lineTo(getWidth(), getHeight());
        path.lineTo(getWidth()/2,0);
        path.close();
        canvas.drawPath(path, paint);*/
    }

    @Override
    public void createAnimation() {
        /*ObjectAnimator rotationXAnimation=ObjectAnimator.ofFloat(getTarget(), "rotationX",0,180,180,0,0);
        rotationXAnimation.setDuration(3000);

        ObjectAnimator rotationYAnimation=ObjectAnimator.ofFloat(getTarget(), "rotationY",0,0,180,180,0);
        rotationYAnimation.setDuration(3000);

        final AnimatorSet animatorSet=new AnimatorSet();
        animatorSet.playTogether(rotationXAnimation,rotationYAnimation);
        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationRepeat(Animator animation) {
                super.onAnimationRepeat(animation);
                System.out.println("onAnimationRepeat");
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                System.out.println("onAnimationEnd(");
                animatorSet.start();
            }
        });
        animatorSet.start();*/


        /*PropertyValuesHolder rotation1=PropertyValuesHolder.ofFloat("rotationX",0,180,0,0,0);
        PropertyValuesHolder rotation2=PropertyValuesHolder.ofFloat("rotationX",0,0,180,0,0);
        PropertyValuesHolder rotation3=PropertyValuesHolder.ofFloat("rotationY",0,0,180,0,0);
        PropertyValuesHolder rotation4=PropertyValuesHolder.ofFloat("rotationY",0,0,0,180,0);*/

        PropertyValuesHolder rotation5=PropertyValuesHolder.ofFloat("rotationX",0,180,180,0,0);
        PropertyValuesHolder rotation6=PropertyValuesHolder.ofFloat("rotationY",0,0,180,180,0);
        ObjectAnimator animator=ObjectAnimator.ofPropertyValuesHolder(getTarget(), rotation6,rotation5);
        animator.setInterpolator(new LinearInterpolator());
        animator.setRepeatCount(-1);
        animator.setDuration(2500);
        animator.start();
    }
}
