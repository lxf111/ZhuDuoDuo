package com.lxf.zhuduoduo.ui.alcohol.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.lxf.zhuduoduo.R;
import com.lxf.zhuduoduo.base.BaseActivity;
import com.lxf.zhuduoduo.ui.alcohol.adapter.OrderPagerAdapter;
import com.lxf.zhuduoduo.ui.alcohol.fragment.WineryFragment;
import com.lxf.zhuduoduo.ui.alcohol.fragment.WineryGiveFragment;
import com.lxf.zhuduoduo.ui.alcohol.fragment.WineryReceiverFragment;
import com.lxf.zhuduoduo.ui.alcohol.fragment.WineryRefoundFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 酒庄
 */
public class WineryActivity extends BaseActivity {
    private TabLayout tabWinery;
    private ViewPager viewpager;

    private OrderPagerAdapter adapter;

    private String tabNames[] = {"酒庄", "已送出", "已接收", "已拒绝"};

    private WineryFragment wineryFragment;//酒庄
    private WineryGiveFragment giveFragment;//已送出
    private WineryReceiverFragment receiverFragment;//已送出
    private WineryRefoundFragment refoundFragment;//已拒绝

    private List<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winery);
        initTitle("酒庄");
        initView();
        initData();
        initEvent();
    }

    private void initView() {
        tabWinery = (TabLayout) findViewById(R.id.tab_winery);
        viewpager = (ViewPager) findViewById(R.id.viewpager);
    }

    private void initData() {
        wineryFragment = new WineryFragment();
        giveFragment = new WineryGiveFragment();
        receiverFragment = new WineryReceiverFragment();
        refoundFragment = new WineryRefoundFragment();

        fragments.add(wineryFragment);
        fragments.add(giveFragment);
        fragments.add(receiverFragment);
        fragments.add(refoundFragment);


        adapter = new OrderPagerAdapter(getSupportFragmentManager(), tabNames, fragments);
        viewpager.setAdapter(adapter);
        tabWinery.setupWithViewPager(viewpager);
        tabWinery.setSelectedTabIndicatorColor(getResources().getColor(R.color.theme));
    }

    private void initEvent() {

    }
}
