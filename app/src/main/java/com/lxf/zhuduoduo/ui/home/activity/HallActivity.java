package com.lxf.zhuduoduo.ui.home.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.lxf.zhuduoduo.R;
import com.lxf.zhuduoduo.base.BaseActivity;

/**
 * 积分商城
 */
public class HallActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hall);
        initTitle("积分商城");
    }
}