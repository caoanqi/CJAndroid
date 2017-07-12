package com.tpwalk.cjdroid.utils;

import android.content.res.Resources;

/**
 * Created by jerry on 2017/7/8.
 */

public class DensityUtils {

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Resources context, float dpValue) {
        final float scale = context.getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(Resources context, float pxValue) {
        final float scale = context.getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}
