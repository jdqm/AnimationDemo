package com.jdqm.animationdemo;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;

/**
 * Created by Jdqm on 2017-12-28.
 */

public class PageFragment extends Fragment {
    @LayoutRes
    int layoutRes;

    public static Fragment newInstance(@LayoutRes int layoutRes) {
        PageFragment fragment = new PageFragment();

        Bundle args = new Bundle();
        args.putInt("layoutRes", layoutRes);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            layoutRes = args.getInt("layoutRes");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page, container, false);

        ViewStub viewStub = view.findViewById(R.id.viewStub);
        viewStub.setLayoutResource(layoutRes);
        viewStub.inflate();

        return view;
    }
}
