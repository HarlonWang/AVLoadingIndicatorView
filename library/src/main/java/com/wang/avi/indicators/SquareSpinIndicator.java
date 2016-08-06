package com.wang.avi.indicators;

import android.animation.ValueAnimator;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.animation.LinearInterpolator;

import com.wang.avi.Indicator;

import java.util.ArrayList;

/**
 * Created by Jack on 2015/10/16.
 */
public class SquareSpinIndicator extends Indicator {

    private float rotateX;
    private float rotateY;

    private Camera mCamera;
    private Matrix mMatrix;

    public SquareSpinIndicator(){
        mCamera=new Camera();
        mMatrix=new Matrix();
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {

        mMatrix.reset();
        mCamera.save();
        mCamera.rotateX(rotateX);
        mCamera.rotateY(rotateY);
        mCamera.getMatrix(mMatrix);
        mCamera.restore();

        mMatrix.preTranslate(-centerX(), -centerY());
        mMatrix.postTranslate(centerX(), centerY());
        canvas.concat(mMatrix);

        canvas.drawRect(new RectF(getWidth()/5,getHeight()/5,getWidth()*4/5,getHeight()*4/5),paint);
    }

    @Override
    public ArrayList<ValueAnimator> onCreateAnimators() {
        ArrayList<ValueAnimator> animators=new ArrayList<>();
        ValueAnimator animator=ValueAnimator.ofFloat(0,180,180,0,0);
        addUpdateListener(animator,new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                rotateX= (float) animation.getAnimatedValue();
                postInvalidate();
            }
        });
        animator.setInterpolator(new LinearInterpolator());
        animator.setRepeatCount(-1);
        animator.setDuration(2500);

        ValueAnimator animator1=ValueAnimator.ofFloat(0,0,180,180,0);
        addUpdateListener(animator1,new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                rotateY= (float) animation.getAnimatedValue();
                postInvalidate();
            }
        });
        animator1.setInterpolator(new LinearInterpolator());
        animator1.setRepeatCount(-1);
        animator1.setDuration(2500);

        animators.add(animator);
        animators.add(animator1);
        return animators;
    }

}
