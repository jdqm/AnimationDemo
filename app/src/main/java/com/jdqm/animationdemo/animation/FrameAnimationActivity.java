package com.jdqm.animationdemo.animation;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.jdqm.animationdemo.R;

public class FrameAnimationActivity extends AppCompatActivity {

    private View frameAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twenn_animation);
        frameAnimationView = findViewById(R.id.frameAnimationView);
        frameAnimationView.setBackgroundResource(R.drawable.music_animation);
    }

    public void start(View view) {
        AnimationDrawable frameAnimation = (AnimationDrawable) frameAnimationView.getBackground();
        frameAnimation.start();
    }

    public void stop(View view) {
        AnimationDrawable frameAnimation = (AnimationDrawable) frameAnimationView.getBackground();
        frameAnimation.stop();
    }
}
