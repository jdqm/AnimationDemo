package com.jdqm.animationdemo.animator;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.jdqm.animationdemo.R;


/**
 * <p>
 * Demo for Alpha Animator.
 * <p>
 * Created by Jdqm on 2017-12-28.
 */
public class AlphaAnimatorView extends RelativeLayout {
    Button btnAnimator;
    ImageView imageView;
    int state = 0;

    public AlphaAnimatorView(Context context) {
        this(context, null);
    }

    public AlphaAnimatorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public AlphaAnimatorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
                    imageView.animate().alpha(0);
                    state = 1;
                } else {
                    imageView.animate().alpha(1);
                    state = 0;
                }

            }
        });
    }
}
