package com.lxf.zhuduoduo.ui.my.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.lxf.zhuduoduo.R;
import com.lxf.zhuduoduo.base.BaseActivity;

/**
 * Created by zhf on 2018/6/28.
 */

public class AddBankActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bank);
        initTitle("添加银行卡");
    }
}
