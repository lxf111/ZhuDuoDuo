package com.lxf.zhuduoduo.ui.order;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lxf.zhuduoduo.R;
import com.lxf.zhuduoduo.base.BaseActivity;
import com.lxf.zhuduoduo.ui.order.adapter.CarAdapter;

public class CarActivity extends BaseActivity {
    private RecyclerView rvCar;
    private LinearLayout linBottom;
    private ImageView ivSelect;
    private TextView tvSelect;
    private TextView tvAll;
    private TextView tvSubmit;

    private CarAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);
        initTitle("购物车");
        initView();
        initData();
        initEvent();
    }

    private void initView() {
        rvCar = (RecyclerView) findViewById(R.id.rv_car);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        rvCar.setLayoutManager(linearLayoutManager);

        linBottom = (LinearLayout) findViewById(R.id.lin_bottom);
        ivSelect = (ImageView) findViewById(R.id.iv_select);
        tvSelect = (TextView) findViewById(R.id.tv_select);
        tvAll = (TextView) findViewById(R.id.tv_all);
        tvSubmit = (TextView) findViewById(R.id.tv_submit);
    }

    private void initData() {
        adapter = new CarAdapter(context);
        rvCar.setAdapter(adapter);
    }

    private void initEvent() {

    }
}
