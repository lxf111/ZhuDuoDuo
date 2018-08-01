package com.lxf.zhuduoduo.ui.my.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.lxf.zhuduoduo.R;
import com.lxf.zhuduoduo.base.BaseActivity;
import com.lxf.zhuduoduo.http.Api;
import com.lxf.zhuduoduo.ui.my.adapter.AddressAdapter;
import com.lxf.zhuduoduo.utils.MyOkhttp;

/**
 * Created by zhf on 2018/6/27.
 */

public class AddressActivity extends BaseActivity implements View.OnClickListener {

    private TextView tvRight;

    private AddressAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        initTitle("地址管理");
        initView();
        initData();
        initEvent();
    }

    private void initView() {
        tvRight = (TextView) findViewById(R.id.tv_right);
        tvRight.setText("添加");
        tvRight.setVisibility(View.VISIBLE);

        recyclerView = (RecyclerView) findViewById(R.id.rv_address);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new AddressAdapter(context);
        recyclerView.setAdapter(adapter);
    }

    private void initData() {
        String json = "{\"uid\":\"" + uid + "\"}";
        MyOkhttp.Okhttp(context, Api.BASE_URL + Api.address_list, json, new MyOkhttp.CallBack() {
            @Override
            public void onRequestComplete(String response, String msg, String code) {
                if (code.equals("0")) {

                } else {
                    Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initEvent() {
        tvRight.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_right:
                Intent intent = new Intent(context, AddAddressActivity.class);
                startActivityForResult(intent, 100);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK) {
            //添加完成的地址
        }
    }
}
