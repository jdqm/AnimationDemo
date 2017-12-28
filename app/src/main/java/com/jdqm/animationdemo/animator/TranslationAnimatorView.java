package com.jdqm.animationdemo.animator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Outline;
import android.graphics.Path;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.jdqm.animationdemo.R;

import static android.os.Build.VERSION.SDK_INT;
import static com.jdqm.animationdemo.util.DisplayUtil.dpToPixel;

/**
 * <p>
 * Demo for Translation Animator.
 * <p>
 * Created by Jdqm on 2017-12-28.
 */
public class TranslationAnimatorView extends RelativeLayout {
    Button btnAnimator;
    ImageView imageView;
    int state = 0;
    int stateCount = SDK_INT >= Build.VERSION_CODES.LOLLIPOP ? 6 : 4;
    Context context;

    public TranslationAnimatorView(Context context) {
        this(context, null);
    }

    public TranslationAnimatorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public TranslationAnimatorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        btnAnimator = findViewById(R.id.btnAnimator);
        imageView = findViewById(R.id.imageView);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            imageView.setOutlineProvider(new MusicOutlineProvider());
        }
        btnAnimator.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (state) {
                    case 0:
                        imageView.animate().translationX(dpToPixel(100))
                                .setDuration(300)
                                .setInterpolator(new AccelerateDecelerateInterpolator())
                                .setListener(new AnimatorListenerAdapter() {
                                    @Override
                                    public void onAnimationEnd(Animator animation) {
                                        Toast.makeText(context.getApplicationContext(), "平移动画结束了", Toast.LENGTH_SHORT).show();
                                    }
                                });
                        //如果View默认的Animator没有你想要改变的属性，可以用下面这种写法
                        //ObjectAnimator animator = ObjectAnimator.ofFloat(imageView, "translationX", dpToPixel(100));
                        //animator.start();
                        break;
                    case 1:
                        imageView.animate().translationX(0);
                        break;
                    case 2:
                        imageView.animate().translationYBy(dpToPixel(100));
                        break;
                    case 3:
                        imageView.animate().translationYBy(-dpToPixel(100));
                        break;
                    case 4:
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            imageView.animate().translationZ(dpToPixel(15));
                        }
                        break;
                    case 5:
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            imageView.animate().translationZ(0);
                        }
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

    /**
     * Outline for Music icon.
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    class MusicOutlineProvider extends ViewOutlineProvider {
        Path path = new Path();

        MusicOutlineProvider() {
            path.moveTo(0, dpToPixel(10));
            path.lineTo(dpToPixel(7), dpToPixel(2));
            path.lineTo(dpToPixel(116), dpToPixel(58));
            path.lineTo(dpToPixel(116), dpToPixel(70));
            path.lineTo(dpToPixel(7), dpToPixel(128));
            path.lineTo(0, dpToPixel(120));
            path.close();
        }

        @Override
        public void getOutline(View view, Outline outline) {
            outline.setConvexPath(path);
        }
    }
}
