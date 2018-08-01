package com.lxf.zhuduoduo.ui.order;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.lxf.zhuduoduo.R;
import com.lxf.zhuduoduo.base.BaseActivity;
import com.lxf.zhuduoduo.ui.alcohol.adapter.OrderPagerAdapter;
import com.lxf.zhuduoduo.ui.order.fragment.OrderFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/30 0030.
 */

public class OrderActivity extends BaseActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    private String tabNames[] = {"待付款", "待发货", "待收货", "售后"};

    private List<Fragment> fragments = new ArrayList<>();
    private OrderFragment fragment;

    private OrderPagerAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        initTitle("订单中心");
        initView();
        initData();
        initEvent();
    }

    private void initView() {
        tabLayout = findViewById(R.id.tab_order);
        viewPager = findViewById(R.id.view_order);
    }

    private void initData() {
        fragment = new OrderFragment();
        fragments.add(fragment);

        fragment = new OrderFragment();
        fragments.add(fragment);

        fragment = new OrderFragment();
        fragments.add(fragment);

        fragment = new OrderFragment();
        fragments.add(fragment);

        adapter = new OrderPagerAdapter(getSupportFragmentManager(), tabNames, fragments);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.theme));
    }

    private void initEvent() {

    }
}
