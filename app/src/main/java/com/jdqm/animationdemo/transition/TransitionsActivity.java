package com.jdqm.animationdemo.transition;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.view.Window;

import com.jdqm.animationdemo.R;

public class TransitionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        int flag = getIntent().getExtras().getInt("flag");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            switch (flag) {
                case 0:
                    getWindow().setEnterTransition(new Explode());
                    break;
                case 1:
                    getWindow().setEnterTransition(new Slide());
                    break;
                case 2:
                    getWindow().setEnterTransition(new Fade());
                    getWindow().setExitTransition(new Fade());
                    break;
                case 3:
                    break;
                default:
                    break;
            }
        }
        setContentView(R.layout.activity_transitions);
    }
}
