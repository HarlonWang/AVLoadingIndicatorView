package com.wang.avi.indicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by Jack on 2015/10/15.
 */
public abstract class BaseIndicatorController {

    private View mTarget;


    public void setTarget(View target){
        this.mTarget=target;
    }

    public View getTarget(){
        return mTarget;
    }


    public int getWidth(){
        return mTarget.getWidth();
    }

    public int getHeight(){
        return mTarget.getHeight();
    }

    public void postInvalidate(){
        mTarget.postInvalidate();
    }

    /**
     * draw indicator what ever
     * you want to draw
     * @param canvas
     * @param paint
     */
    public abstract void draw(Canvas canvas,Paint paint);

    /**
     * create animation or animations
     * ,and add to your indicator.
     */
    public abstract void createAnimation();


}
