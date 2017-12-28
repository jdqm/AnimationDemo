package com.jdqm.animationdemo.util;

import android.content.res.Resources;
import android.util.DisplayMetrics;

/**
 *
 * Created by Jdqm on 2017-12-28.
 */

public class DisplayUtil {
    public static float dpToPixel(float dpValue) {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        return dpValue * metrics.density;
    }
}
