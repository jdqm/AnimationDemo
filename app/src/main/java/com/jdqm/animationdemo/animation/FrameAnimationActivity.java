package com.jdqm.animationdemo.animation;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.jdqm.animationdemo.R;

public class FrameAnimationActivity extends AppCompatActivity {

    private View imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twenn_animation);
        imageView = findViewById(R.id.imageView);
        imageView.setBackgroundResource(R.drawable.music_animation);
    }

    public void start(View view) {
        AnimationDrawable tweenAnimation = (AnimationDrawable) imageView.getBackground();
        tweenAnimation.start();
    }

    public void stop(View view) {
        AnimationDrawable tweenAnimation = (AnimationDrawable) imageView.getBackground();
        tweenAnimation.stop();
    }
}
