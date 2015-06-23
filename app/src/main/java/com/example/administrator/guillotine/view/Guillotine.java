package com.example.administrator.guillotine.view;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.administrator.guillotine.R;

/**
 * Created by yunye on 15-6-23.
 */
public class Guillotine extends RelativeLayout{
    private ValueAnimator showAnimator;
    private ObjectAnimator dismissAnimator;
    private ObjectAnimator endAnimator;
    private static final float START_ROTATE =-90f;
    private static final float END_ROTATE = 90f;

    public Guillotine(Context context, AttributeSet attrs) {
        super(context, attrs);
        setRotation(START_ROTATE);
        setPivotX(0);
        setPivotY(0);
        setBackgroundColor(getResources().getColor(R.color.background));
        showAnimator = ValueAnimator.ofObject(new ShowEvaluator(), START_ROTATE, END_ROTATE);
        showAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                setRotation((Float) animation.getAnimatedValue());
            }
        });
        showAnimator.setDuration(500);
        dismissAnimator = ObjectAnimator.ofFloat(this,"rotation",0,START_ROTATE);
        dismissAnimator.setDuration(500);

    }
    public void show(){
        showAnimator.start();
    }
    public void dismiss(){
        dismissAnimator.start();
    }
}
