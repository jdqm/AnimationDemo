package com.jdqm.animationdemo.animation;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.jdqm.animationdemo.R;


/**
 * <p>
 * Demo for Scale Animation.
 * <p>
 * Created by Jdqm on 2017-12-28.
 */
public class ScaleAnimationView extends RelativeLayout {
    Button btnAnimator;
    ImageView imageView;
    Context context;

    public ScaleAnimationView(Context context) {
        this(context, null);
    }

    public ScaleAnimationView(Context context, @Nullable AttributeSet attrs) {
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
                Animation sa = new ScaleAnimation(1.0f, 1.5f, 1.0f, 1.5f);
                sa.setDuration(300);
                sa.setFillAfter(true);
                imageView.startAnimation(sa);
            }
        });
    }
}
