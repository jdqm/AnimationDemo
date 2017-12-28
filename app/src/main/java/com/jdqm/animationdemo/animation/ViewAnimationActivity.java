package com.jdqm.animationdemo.animation;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jdqm.animationdemo.PageFragment;
import com.jdqm.animationdemo.PageNode;
import com.jdqm.animationdemo.R;

import java.util.ArrayList;
import java.util.List;

public class ViewAnimationActivity extends AppCompatActivity {

    private List<PageNode> pageNodes = new ArrayList<>();

    {
        pageNodes.add(new PageNode(R.string.translation, R.layout.translation_animation));
        pageNodes.add(new PageNode(R.string.scale, R.layout.scale_animation));
        pageNodes.add(new PageNode(R.string.rotation, R.layout.rotation_animation));
        pageNodes.add(new PageNode(R.string.alpha, R.layout.alpha_animation));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_animation);
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public int getCount() {
                return pageNodes.size();
            }

            @Override
            public Fragment getItem(int position) {
                return PageFragment.newInstance(pageNodes.get(position).layoutRes);
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return getString(pageNodes.get(position).titleRes);
            }
        });
        tabLayout.setupWithViewPager(viewPager);
    }

}
