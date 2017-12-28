package com.jdqm.animationdemo.animator;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.jdqm.animationdemo.PageFragment;
import com.jdqm.animationdemo.PageNode;
import com.jdqm.animationdemo.R;

import java.util.ArrayList;
import java.util.List;

public class PropertyAnimationActivity extends AppCompatActivity {

    private List<PageNode> pageNodes = new ArrayList<>();

    {
        pageNodes.add(new PageNode(R.string.translation, R.layout.translation_animator));
        pageNodes.add(new PageNode(R.string.scale, R.layout.scale_animator));
        pageNodes.add(new PageNode(R.string.rotation, R.layout.rotation_animator));
        pageNodes.add(new PageNode(R.string.alpha, R.layout.alpha_animator));
        pageNodes.add(new PageNode(R.string.value_holder, R.layout.property_value_holder_layout));
        pageNodes.add(new PageNode(R.string.animator_set, R.layout.animator_set_layout));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_animation);
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return PageFragment.newInstance(pageNodes.get(position).layoutRes);
            }

            @Override
            public int getCount() {
                return pageNodes.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return getString(pageNodes.get(position).titleRes);
            }
        });
        tabLayout.setupWithViewPager(viewPager);
    }
}
