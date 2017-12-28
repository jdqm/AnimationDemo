package com.jdqm.animationdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.jdqm.animationdemo.animation.TweenAnimationActivity;
import com.jdqm.animationdemo.animation.ViewAnimationActivity;
import com.jdqm.animationdemo.animator.PropertyAnimationActivity;

public class MainActivity extends Activity implements View.OnClickListener {

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
                startActivity(new Intent(this, TweenAnimationActivity.class));
                break;
            case R.id.btnAnimator:
                startActivity(new Intent(this, PropertyAnimationActivity.class));
                break;
            default:
                break;
        }
    }
}
