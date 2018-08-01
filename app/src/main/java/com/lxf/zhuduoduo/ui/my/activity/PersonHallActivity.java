package com.lxf.zhuduoduo.ui.my.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lxf.zhuduoduo.R;
import com.lxf.zhuduoduo.base.BaseActivity;
import com.lxf.zhuduoduo.ui.my.adapter.PersonHallAdapter;

/**
 * Created by Administrator on 2018/7/11 0011.
 */

public class PersonHallActivity extends BaseActivity {

    private RecyclerView recyclerView;

    private PersonHallAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_hall);
        initTitle("个人商城");
        initView();
        initData();
        initEvent();
    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.rv_hall);
        GridLayoutManager linearLayoutManager = new GridLayoutManager(context,2);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private void initData() {
        adapter = new PersonHallAdapter(context);
        recyclerView.setAdapter(adapter);
    }

    private void initEvent() {

    }
}
