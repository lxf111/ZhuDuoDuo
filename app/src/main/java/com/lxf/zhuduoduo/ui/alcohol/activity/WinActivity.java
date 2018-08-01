package com.lxf.zhuduoduo.ui.alcohol.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lxf.zhuduoduo.R;
import com.lxf.zhuduoduo.base.BaseActivity;

/**
 * 战果
 */
public class WinActivity extends BaseActivity {


    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);
        initView();
        initData();
        initEvent();
    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.rv_win);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
    }

    private void initData() {

    }

    private void initEvent() {

    }
}
