package com.jdqm.animationdemo;

import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;

public class PageNode {
    @StringRes
    public int titleRes;
    @LayoutRes
    public int layoutRes;

    public PageNode(int titleRes, int layoutRes) {
        this.titleRes = titleRes;
        this.layoutRes = layoutRes;
    }
}