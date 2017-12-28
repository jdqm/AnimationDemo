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
 * Demo for Rotation Animator.
 * <p>
 * Created by Jdqm on 2017-12-28.
 */
public class RotationAnimatorView extends RelativeLayout {
    Button btnAnimator;
    ImageView imageView;
    int state = 0;
    int stateCount = 6;
    Context context;

    public RotationAnimatorView(Context context) {
        this(context, null);
    }

    public RotationAnimatorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public RotationAnimatorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
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
                switch (state) {
                    case 0:
                        imageView.animate().rotation(180);
                        break;
                    case 1:
                        imageView.animate().rotation(0);
                        break;
                    case 2:
                        imageView.animate().rotationX(180);
                        break;
                    case 3:
                        imageView.animate().rotationX(0);
                        break;
                    case 4:
                        imageView.animate().rotationY(180);
                        break;
                    case 5:
                        imageView.animate().rotationY(0);
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
