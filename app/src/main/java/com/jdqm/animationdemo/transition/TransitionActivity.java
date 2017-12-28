package com.jdqm.animationdemo.transition;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;

import com.jdqm.animationdemo.R;

import static android.os.Build.VERSION.SDK_INT;

public class TransitionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);
    }

    public void explode(View view) {
        Intent intent = new Intent(this, TransitionsActivity.class);
        intent.putExtra("flag", 0);
        if (SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
        }
    }

    public void slide(View view) {
        Intent intent = new Intent(this, TransitionsActivity.class);
        intent.putExtra("flag", 1);
        if (SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
        }
    }

    public void fade(View view) {
        Intent intent = new Intent(this, TransitionsActivity.class);
        intent.putExtra("flag", 2);
        if (SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
        }
    }

    public void share(View view) {
        View fab = findViewById(R.id.btnFab);
        Intent intent = new Intent(this, TransitionsActivity.class);
        intent.putExtra("flag", 3);
        if (SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this,
                    Pair.create(view, "share"),
                    Pair.create(fab, "fab")).toBundle());

        }
    }
}
