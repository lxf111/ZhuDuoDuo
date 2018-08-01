package com.lxf.zhuduoduo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;


/**
 * Created by Administrator on 2017/1/12.
 */

public class MyLinear extends LinearLayout {
    public MyLinear(Context context) {
        super(context);
    }

    public MyLinear(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyLinear(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = (int) Math.round(width * 1);
        setMeasuredDimension(width, height);
        //super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
