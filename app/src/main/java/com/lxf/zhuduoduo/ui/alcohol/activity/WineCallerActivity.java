package com.lxf.zhuduoduo.ui.alcohol.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;

import com.lxf.zhuduoduo.R;
import com.lxf.zhuduoduo.base.BaseActivity;
import com.lxf.zhuduoduo.popup.OtherPop;
import com.lxf.zhuduoduo.ui.alcohol.adapter.OrderPagerAdapter;
import com.lxf.zhuduoduo.ui.alcohol.fragment.AllWineCallerFragment;
import com.lxf.zhuduoduo.ui.alcohol.fragment.ChangedFragment;
import com.lxf.zhuduoduo.utils.SPUtils;
import com.lxf.zhuduoduo.utils.TabLayoutUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 酒库
 */

public class WineCallerActivity extends BaseActivity implements View.OnClickListener {
    private ImageView ivRight;
    private TabLayout tabCaller;
    private ViewPager viewCaller;

    private AllWineCallerFragment allWineCallerFragment;
    private ChangedFragment changedFragment;

    private List<Fragment> fragmentList = new ArrayList<>();

    private String[] tabNames = {"酒库", "已兑换"};

    private OrderPagerAdapter adapter;

    private int skin = 1;

    private String[] skinType = {"第一种", "第二种", "第三种"};

    private OtherPop pop;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wine_caller);

        skin = (int) SPUtils.get(context, "skin", 1);

        initTitle("酒库");
        initView();
        initData();
        initEvent();
    }

    private void initView() {
        ivRight = (ImageView) findViewById(R.id.iv_right);
        tabCaller = (TabLayout) findViewById(R.id.tab_caller);
        viewCaller = (ViewPager) findViewById(R.id.view_caller);
    }

    private void initData() {
        allWineCallerFragment = new AllWineCallerFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("skin", skin);
        allWineCallerFragment.setArguments(bundle);


        changedFragment = new ChangedFragment();
        fragmentList.add(allWineCallerFragment);
        fragmentList.add(changedFragment);

        adapter = new OrderPagerAdapter(getSupportFragmentManager(), tabNames, fragmentList);
        viewCaller.setAdapter(adapter);
        tabCaller.setupWithViewPager(viewCaller);
        tabCaller.setSelectedTabIndicatorColor(getResources().getColor(R.color.theme));
        TabLayoutUtil.reflex(tabCaller);

    }

    private void initEvent() {
        ivRight.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            //换皮肤
            case R.id.iv_right:
                pop = new OtherPop(context, onItemClickListener, skinType);
                pop.showAsDropDown(tabCaller);
                break;
        }
    }

    AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            SPUtils.put(context, "skin", i + 1);
            Intent intent = new Intent(context, WineCallerActivity.class);
            startActivity(intent);
            finish();
            pop.dismiss();
        }
    };
}
