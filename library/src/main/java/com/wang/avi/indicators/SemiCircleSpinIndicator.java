package com.wang.avi.indicators;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import com.wang.avi.Indicator;

import java.util.ArrayList;

/**
 * Created by Jack on 2015/10/20.
 */
public class SemiCircleSpinIndicator extends Indicator {

    private float degress;

    @Override
    public void draw(Canvas canvas, Paint paint) {
        canvas.rotate(degress,centerX(),centerY());
        RectF rectF=new RectF(0,0,getWidth(),getHeight());
        canvas.drawArc(rectF,-60,120,false,paint);
    }

    @Override
    public ArrayList<ValueAnimator> onCreateAnimators() {
        ArrayList<ValueAnimator> animators=new ArrayList<>();
        ValueAnimator rotateAnim=ValueAnimator.ofFloat(0,180,360);
        addUpdateListener(rotateAnim,new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                degress= (float) animation.getAnimatedValue();
                postInvalidate();
            }
        });
        rotateAnim.setDuration(600);
        rotateAnim.setRepeatCount(-1);
        animators.add(rotateAnim);
        return animators;
    }

}
