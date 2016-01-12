package org.mym.avi;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.nineoldandroids.animation.Animator;
import com.wang.avi.indicator.BaseIndicatorController;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class BallRectanglePathIndicator extends BaseIndicatorController {

    private float[] translateX = new float[4],
            translateY = new float[4];
    private int[] colorSchemes = new int[]{
            Color.parseColor("#03B29E"),
            Color.parseColor("#FFB364"),
            Color.parseColor("#1E4C59"),
            Color.parseColor("#FC5853"),
    };

    @Override
    public void draw(Canvas canvas, Paint paint) {
        //save paint
        int colorBefore = paint.getColor();
        Paint.Style styleBefore = paint.getStyle();

        paint.setStyle(Paint.Style.FILL);
        for (int i = 0; i < 4; ++i) {
            canvas.save();

            canvas.translate(translateX[i], translateY[i]);
            paint.setColor(colorSchemes[i]);
            canvas.drawCircle(0, 0, getWidth() / 6, paint);

            canvas.restore();
        }

        //restore paint
        paint.setColor(colorBefore);
        paint.setStyle(styleBefore);
    }

    @Override
    public List<Animator> createAnimation() {
        List<Animator> animators = new ArrayList<>();
        for (int i = 0; i < 4; ++i) {
            final int index = i;

            ValueAnimator animatorX = null;
            ValueAnimator animatorY = null;
            float startX    = getWidth()/5;
            float startY    = getWidth()/5;

            float leftX     = startX;
            float rightX    = getWidth() - startX;
            float topY      = startY;
            float bottomY   = getHeight() - startY;

            switch (i){
                case 0:
                    animatorX = ValueAnimator.ofFloat(leftX, rightX, rightX, leftX);
                    animatorY = ValueAnimator.ofFloat(topY, topY, bottomY, bottomY);
                    break;
                case 1:
                    animatorX = ValueAnimator.ofFloat(rightX, rightX, leftX, leftX);
                    animatorY = ValueAnimator.ofFloat(topY, bottomY, bottomY, topY);
                    break;
                case 2:
                    animatorX = ValueAnimator.ofFloat(leftX, leftX, rightX, rightX);
                    animatorY = ValueAnimator.ofFloat(bottomY, topY, topY, bottomY);
                    break;
                case 3:
                    animatorX = ValueAnimator.ofFloat(rightX, leftX, leftX, rightX);
                    animatorY = ValueAnimator.ofFloat(bottomY, bottomY, topY, topY);
                    break;
                default:
                    break;
            }

            setAnimator(animatorX, new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    translateX [index]= (float) animation.getAnimatedValue();
                    postInvalidate();
                }
            });
            setAnimator(animatorY, new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    translateY [index]= (float) animation.getAnimatedValue();
                    postInvalidate();
                }
            });
        }
        return animators;
    }

    private void setAnimator(ValueAnimator animator, ValueAnimator.AnimatorUpdateListener listener) {
        animator.setDuration(2000);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        animator.addUpdateListener(listener);
        animator.start();
    }
}
