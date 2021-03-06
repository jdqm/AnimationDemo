package com.jdqm.animationdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.jdqm.animationdemo.animation.FrameAnimationActivity;
import com.jdqm.animationdemo.animation.ViewAnimationActivity;
import com.jdqm.animationdemo.animator.PropertyAnimationActivity;
import com.jdqm.animationdemo.transition.TransitionActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAnimation:
                startActivity(new Intent(this, ViewAnimationActivity.class));
                break;
            case R.id.btnTweenAnimation:
                startActivity(new Intent(this, FrameAnimationActivity.class));
                break;
            case R.id.btnAnimator:
                startActivity(new Intent(this, PropertyAnimationActivity.class));
                overridePendingTransition(R.anim.activity_enter_anim, R.anim.activity_exit_anim);
                break;
            case R.id.btnTransition:
                startActivity(new Intent(this, TransitionActivity.class));
                overridePendingTransition(R.anim.activity_enter_anim, R.anim.activity_exit_anim);
                break;
            default:
                break;
        }
    }
}
