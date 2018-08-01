package com.lxf.zhuduoduo.ui.order.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lxf.zhuduoduo.R;
import com.lxf.zhuduoduo.base.BaseFragment;
import com.lxf.zhuduoduo.ui.order.adapter.OrderAdapter;

/**
 * Created by Administrator on 2018/6/30 0030.
 */

public class OrderFragment extends BaseFragment {

    private RecyclerView recyclerView;

    private OrderAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order, null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView(getView());
        initData();
        initEvent();
    }

    private void initView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_order);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private void initData() {
        adapter = new OrderAdapter(context);
        recyclerView.setAdapter(adapter);
    }

    private void initEvent() {

    }
}
