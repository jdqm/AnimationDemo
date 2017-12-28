package com.jdqm.animationdemo.animation;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.jdqm.animationdemo.R;

import static com.jdqm.animationdemo.util.DisplayUtil.dpToPixel;


/**
 * <p>
 * Demo for translation Animation.
 * <p>
 * Created by Jdqm on 2017-12-28.
 */
public class TranslationAnimationView extends RelativeLayout {
    Button btnAnimator;
    ImageView imageView;
    Context context;

    public TranslationAnimationView(Context context) {
        this(context, null);
    }

    public TranslationAnimationView(Context context, @Nullable AttributeSet attrs) {
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
                Animation ta = new TranslateAnimation(0, dpToPixel(100), 0, 0);
                ta.setDuration(300);
                ta.setFillAfter(true);
                imageView.startAnimation(ta);
            }
        });
    }
}
