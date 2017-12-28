package com.jdqm.animationdemo.animator;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
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
 * Demo for PropertyValuesHolder.
 * <p>
 * Created by Jdqm on 2017-12-28.
 */
public class PropertyValueHolderView extends RelativeLayout {
    Button btnAnimator;
    ImageView imageView;
    int state = 0;

    public PropertyValueHolderView(Context context) {
        this(context, null);
    }

    public PropertyValueHolderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PropertyValueHolderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        btnAnimator = findViewById(R.id.btnAnimator);
        imageView = findViewById(R.id.imageView);
//        imageView.animate().alpha(0);
        btnAnimator.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (state == 0) {
                    PropertyValuesHolder holder1 = PropertyValuesHolder.ofFloat("translationX", dpToPixel(100));
                    PropertyValuesHolder holder2 = PropertyValuesHolder.ofFloat("alpha", 1.0f);
                    PropertyValuesHolder holder3 = PropertyValuesHolder.ofFloat("rotation", 360);

                    ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(imageView, holder1, holder2, holder3);
                    animator.setDuration(500)
                            .start();

                    state = 1;
                } else {
                    PropertyValuesHolder holder1 = PropertyValuesHolder.ofFloat("translationX", 0);
                    PropertyValuesHolder holder2 = PropertyValuesHolder.ofFloat("alpha", 0.0f);
                    PropertyValuesHolder holder3 = PropertyValuesHolder.ofFloat("rotation", 0);

                    ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(imageView, holder1, holder2, holder3);
                    animator.setDuration(500)
                            .start();
                    state = 0;
                }

            }
        });
    }
}
