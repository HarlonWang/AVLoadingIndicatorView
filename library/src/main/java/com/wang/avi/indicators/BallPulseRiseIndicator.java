package com.wang.avi.indicators;

import android.animation.ValueAnimator;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.animation.LinearInterpolator;

import com.wang.avi.Indicator;

import java.util.ArrayList;

/**
 * Created by Jack on 2015/10/17.
 */
public class BallPulseRiseIndicator extends Indicator {

    private Camera mCamera;
    private Matrix mMatrix;

    private float degress;

    public BallPulseRiseIndicator(){
        mCamera=new Camera();
        mMatrix=new Matrix();
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {

        mMatrix.reset();
        mCamera.save();
        mCamera.rotateX(degress);
        mCamera.getMatrix(mMatrix);
        mCamera.restore();

        mMatrix.preTranslate(-centerX(), -centerY());
        mMatrix.postTranslate(centerX(), centerY());
        canvas.concat(mMatrix);

        float radius=getWidth()/10;
        canvas.drawCircle(getWidth()/4,radius*2,radius,paint);
        canvas.drawCircle(getWidth()*3/4,radius*2,radius,paint);

        canvas.drawCircle(radius,getHeight()-2*radius,radius,paint);
        canvas.drawCircle(getWidth()/2,getHeight()-2*radius,radius,paint);
        canvas.drawCircle(getWidth()-radius,getHeight()-2*radius,radius,paint);
    }

    @Override
    public ArrayList<ValueAnimator> onCreateAnimators() {
        ArrayList<ValueAnimator> animators=new ArrayList<>();
        ValueAnimator animator=ValueAnimator.ofFloat(0,360);
        addUpdateListener(animator,new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                degress = (float) animation.getAnimatedValue();
                postInvalidate();
            }
        });
        animator.setInterpolator(new LinearInterpolator());
        animator.setRepeatCount(-1);
        animator.setDuration(1500);
        animators.add(animator);
        return animators;
    }

}
