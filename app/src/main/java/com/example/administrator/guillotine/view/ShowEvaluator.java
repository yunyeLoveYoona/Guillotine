package com.example.administrator.guillotine.view;

import android.animation.TypeEvaluator;

/**
 * Created by Administrator on 15-6-23.
 */
public class ShowEvaluator implements TypeEvaluator{
    private static int num = 1;
    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        float rotate;
        if(fraction == 0){
            num = 1;
        }
        rotate = (Float) startValue
                + ((Float) endValue - (Float) startValue)
                * fraction;
        if(rotate>=0&&rotate<(float)endValue/4){
            rotate = 0-rotate*(fraction);
        }else if(rotate>=0&&rotate < (float)endValue/2){
            rotate = 0-rotate*(1-fraction);
        }else if(rotate == (float)endValue/2){
            rotate = 0;
        }else if(rotate >(float)endValue/2){
            rotate = 0-rotate*(1-fraction);
        }
         return rotate;
    }
}
