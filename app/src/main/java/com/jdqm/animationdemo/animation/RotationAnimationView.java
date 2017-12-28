package com.jdqm.animationdemo.animation;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.jdqm.animationdemo.R;


/**
 * <p>
 * Demo for Rotation Animation.
 * <p>
 * Created by Jdqm on 2017-12-28.
 */
public class RotationAnimationView extends RelativeLayout {
    Button btnAnimator;
    ImageView imageView;
    Context context;

    public RotationAnimationView(Context context) {
        this(context, null);
    }

    public RotationAnimationView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        btnAnimator = findViewById(R.id.btnAnimator);
        imageView = findViewById(R.id.imageView);
        btnAnimator.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation sa = new RotateAnimation(0, 180);
                sa.setDuration(300);
                sa.setFillAfter(true);
                imageView.startAnimation(sa);
            }
        });
    }
}
