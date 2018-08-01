package com.lxf.zhuduoduo.ui.alcohol.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lxf.zhuduoduo.R;
import com.lxf.zhuduoduo.base.BaseFragment;

/**
 * 已兑换
 */
public class ChangedFragment extends BaseFragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_changed,null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView(getView());
        initData();
        initEvent();
    }
    private void initView(View view){

    }
    private void initData(){

    }
    private void initEvent(){

    }
}
