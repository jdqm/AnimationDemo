package com.jdqm.animationdemo.animator;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.jdqm.animationdemo.R;

/**
 * <p>
 * Demo for Scale Animator.
 * <p>
 * Created by Jdqm on 2017-12-28.
 */
public class ScaleAnimatorView extends RelativeLayout {
    Button btnAnimator;
    ImageView imageView;
    int state = 0;
    int stateCount = 4;

    public ScaleAnimatorView(Context context) {
        this(context, null);
    }

    public ScaleAnimatorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ScaleAnimatorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
                switch (state) {
                    case 0:
                        imageView.animate().scaleX(1.5f)
                                .setDuration(300)
                                .setInterpolator(new AccelerateDecelerateInterpolator());
                        break;
                    case 1:
                        imageView.animate().scaleX(1.0f);
                        break;
                    case 2:
                        imageView.animate().scaleY(.5f);
                        break;
                    case 3:
                        imageView.animate().scaleY(1.0f);
                        break;
                    default:
                        break;
                }
                if (++state == stateCount) {
                    state = 0;
                }
            }
        });
    }

}
