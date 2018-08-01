package com.lxf.zhuduoduo.utils;

import android.content.Context;

public class CorUtils {
    /**
     * px转换dip
     */
    public static int px2dip(Context context, int px) {
        float scale = context.getResources().getDisplayMetrics().density;
        return Integer.valueOf((int) (px / scale + 0.5f));
    }
}
