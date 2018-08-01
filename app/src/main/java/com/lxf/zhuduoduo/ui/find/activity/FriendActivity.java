package com.lxf.zhuduoduo.ui.find.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.lxf.zhuduoduo.R;
import com.lxf.zhuduoduo.base.BaseActivity;
import com.lxf.zhuduoduo.ui.find.adapter.FriendAdapter;

public class FriendActivity extends BaseActivity implements View.OnClickListener {
    private TextView tvBack;
    private EditText etContent;
    private RecyclerView rvFriend;

    private FriendAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend);
        initView();
        initData();
        initEvent();
    }

    private void initView() {
        tvBack = (TextView) findViewById(R.id.tv_back);
        etContent = (EditText) findViewById(R.id.et_content);
        rvFriend = (RecyclerView) findViewById(R.id.rv_friend);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        rvFriend.setLayoutManager(linearLayoutManager);
    }

    private void initData() {
        adapter = new FriendAdapter(context);
        rvFriend.setAdapter(adapter);
    }

    private void initEvent() {
        tvBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_back:
                finish();
                break;
        }
    }
}
