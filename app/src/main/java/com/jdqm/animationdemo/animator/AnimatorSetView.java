package com.jdqm.animationdemo.animator;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.jdqm.animationdemo.R;

import static com.jdqm.animationdemo.util.DisplayUtil.dpToPixel;


/**
 * <p>
 * AnimatorSet可以同时播放一组Animator, 此时共享同一个interpolator，例如
 * <p>
 * <code>
 * animatorSet.playTogether(animator1, animator2, animator3);
 * </code>
 * <p>
 * <p>
 * Created by Jdqm on 2017-12-28.
 */
public class AnimatorSetView extends RelativeLayout {
    Button btnAnimator;
    ImageView imageView;
    int state = 0;

    public AnimatorSetView(Context context) {
        this(context, null);
    }

    public AnimatorSetView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public AnimatorSetView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        btnAnimator = findViewById(R.id.btnAnimator);
        imageView = findViewById(R.id.imageView);
        btnAnimator.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (state == 0) {
                    ObjectAnimator animator1 = ObjectAnimator.ofFloat(imageView, "translationX", dpToPixel(100));
                    ObjectAnimator animator2 = ObjectAnimator.ofFloat(imageView, "rotation", 360);
                    ObjectAnimator animator3 = ObjectAnimator.ofFloat(imageView, "alpha", 0);

                    AnimatorSet animatorSet = new AnimatorSet();
                    //animatorSet.playTogether(animator1, animator2, animator3);
                    animatorSet.playSequentially(animator1, animator2, animator3);
                    animatorSet.start();

                    state = 1;
                } else {
                    ObjectAnimator animator1 = ObjectAnimator.ofFloat(imageView, "translationX", 0);
                    ObjectAnimator animator2 = ObjectAnimator.ofFloat(imageView, "rotation", 0);
                    ObjectAnimator animator3 = ObjectAnimator.ofFloat(imageView, "alpha", 1);

                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playTogether(animator1, animator2, animator3);
                    animatorSet.start();

                    state = 0;
                }

            }
        });
    }
}
